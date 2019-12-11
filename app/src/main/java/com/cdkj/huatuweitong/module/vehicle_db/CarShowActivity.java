package com.cdkj.huatuweitong.module.vehicle_db;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.jzvd.Jzvd;
import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.interfaces.BaseRefreshCallBack;
import com.cdkj.baselibrary.interfaces.RefreshHelper;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.DisplayHelper;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.MainActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.*;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.*;
import com.cdkj.huatuweitong.common.WebViewArticleActivity;
import com.cdkj.huatuweitong.databinding.ActShowBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import retrofit2.Call;

import java.util.*;

import static com.cdkj.baselibrary.utils.DateUtil.DEFAULT_DATE_FMT;

/**
 * @author : qianLei
 * @since : 2019/11/5 11:31
 */
public class CarShowActivity extends AbsBaseLoadActivity {

    private ActShowBinding mBinding;

    private RefreshHelper mRefreshHelper;

    // 精选车源
    private HomeSelectedAdapter homeSelectedAdapter;

    // 全部品牌
    private BrandHorAdapter allBrandAdapter;


    public static String[] letters = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    public static void open(Context context) {
        Intent intent = new Intent(context, CarShowActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected boolean canLoadTopTitleView() {
        return false;
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil
                .inflate(getLayoutInflater(), R.layout.act_show, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

        initListener();

        initAllRecycler();

        initRefreshHelper();
        mRefreshHelper.onDefaluteMRefresh(true);

    }

    private void initListener() {
        mBinding.flBack.setOnClickListener(view -> {
            finish();
        });

        mBinding.tvAll.setOnClickListener(v -> {
        });

        mBinding.tvMore.setOnClickListener(v -> {
            BrandActivity.open(this);
        });
    }

    /**
     * 设置右边的小字母
     */
    private void initLetter(List<String> lettersList) {
//        List<String> lettersList = Arrays.asList(letters);
        LetterRVAdapter letterAdapter = new LetterRVAdapter(lettersList);
        mBinding.rvLetter.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
        mBinding.rvLetter.setAdapter(letterAdapter);
        letterAdapter.setOnItemClickListener((adapter, view, position) -> {
            int cposition = allBrandAdapter.getPositionBySort(letters[position]);
            int sposition = allBrandAdapter.getSortPosition(letters[position]);
            if (cposition != -1) {
//                    scrollToPosition 会把不在屏幕的 Item 移动到屏幕上，原来在上方的 Item 移动到 可见 Item 的第一项，在下方的移动到屏幕可见 Item 的最后一项。已经显示的 Item 不会移动。
//                mBinding.rvBrand.smoothScrollToPosition(cposition);
////                    scrollToPositionWithOffset 会把 Item 移动到可见 Item 的第一项，即使它已经在可见 Item 之中。另外它还有 offset 参数，表示 Item 移动到第一项后跟 RecyclerView 上边界或下边界之间的距离（默认是 0）
//                LinearLayoutManager mLayoutManager =
//                        (LinearLayoutManager) mBinding.rvBrand.getLayoutManager();
//                mLayoutManager.scrollToPositionWithOffset(cposition, 0);

                mBinding.slRoot.scrollTo(0,
                        mBinding.llHead.getHeight() + (cposition * DisplayHelper.dp2px(this, 65))
                                + (sposition) * DisplayHelper.dp2px(this, 20));
            }


        });

    }

    /**
     * 初始化最下面的 recy
     */
    private void initAllRecycler() {
        allBrandAdapter = new BrandHorAdapter(null);
        mBinding.rvBrand.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
        mBinding.rvBrand.setAdapter(allBrandAdapter);

        allBrandAdapter.setOnItemClickListener((adapter, view, position) -> {
            BrandBean item = (BrandBean) adapter.getItem(position);
            CarSystemListActivity.open(this, item.getCode());
        });
    }

    /**
     * 获取微车资讯数据
     */
    private void initRefreshHelper() {

        mRefreshHelper = new RefreshHelper(this, new BaseRefreshCallBack(this) {
            @Override
            public View getRefreshLayout() {
                mBinding.refreshLayout.setEnableLoadmore(false);
                return mBinding.refreshLayout;
            }

            @Override
            public RecyclerView getRecyclerView() {
                return mBinding.rvHotBrand;
            }

            @Override
            public RecyclerView.Adapter getAdapter(List listData) {
                BrandVerAdapter hotBrandAdapter = new BrandVerAdapter(null);
                hotBrandAdapter.setOnItemClickListener((adapter, view, position) -> {
                    BrandBean item = (BrandBean) adapter.getItem(position);
                    CarSystemListActivity.open(CarShowActivity.this, item.getCode());
                });
                return hotBrandAdapter;
            }

            @Override
            public void getListDataRequest(int pageindex, int limit, boolean isShowDialog) {
                getHotBrandData();

                getSelectedCarData();

                gettAllBrandData();

                getVedio();
            }
        });
        mBinding.rvHotBrand.setLayoutManager(new GridLayoutManager(this, 5) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mRefreshHelper.init(10);

    }

    private void getHotBrandData() {

        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("location", "0");
        Call<BaseResponseListModel<BrandBean>> brandData = RetrofitUtils
                .createApi(MyApiServer.class).getBrandData("630406", StringUtils
                        .getJsonToString(map));
        brandData.enqueue(new BaseResponseListCallBack<BrandBean>(CarShowActivity.this) {
            @Override
            protected void onSuccess(List<BrandBean> data, String SucMessage) {
                mRefreshHelper.setData(data, "", 0);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    /**
     * 获取精选车源数据
     */
    private void getSelectedCarData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        map.put("location", "0");//1 热门 0普通
        map.put("start", "1");
        map.put("limit", "200");
        map.put("orderDir", "asc");
        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getCarTypePage("630492", StringUtils.getJsonToString(map));
        call.enqueue(new BaseResponseModelCallBack<CarSelectPageBean>(this) {

            @Override
            protected void onSuccess(CarSelectPageBean data, String SucMessage) {

                homeSelectedAdapter = new HomeSelectedAdapter(data.getList());
                mBinding.rvCar.setLayoutManager(
                        new LinearLayoutManager(CarShowActivity.this, LinearLayout.HORIZONTAL,
                                false));
                mBinding.rvCar.setAdapter(homeSelectedAdapter);

                homeSelectedAdapter.setOnItemClickListener((adapter, view, position) -> {

                    CarBean item = (CarBean) adapter
                            .getItem(position);
                    CarDetailsActivity.open(CarShowActivity.this, item.getCode());
                });

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }


    private void gettAllBrandData() {
        showLoadingDialog();
        Map<String, String> map = new HashMap<>();
        map.put("status", "1");//0待上架，1已上架，2已下架
        Call<BaseResponseListModel<BrandBean>> brandData = RetrofitUtils
                .createApi(MyApiServer.class)
                .getBrandData("630406", StringUtils.getJsonToString(map));
        brandData.enqueue(new BaseResponseListCallBack<BrandBean>(this) {
            @Override
            protected void onSuccess(List<BrandBean> data, String SucMessage) {

                //使用冒泡排序  调整集合中的数据  使其从a-z排序
//                int size = data.size();
                for (int i = 0; i < data.size() - 1; i++) {
                    for (int j = 0; j < data.size() - 1 - i; j++) {
                        if (TextUtils.isEmpty(data.get(j).getLetter())) {
                            data.remove(j);
                            continue;
                        }
                        char sort1 = data.get(j).getLetter().toCharArray()[0];
                        char sort2 = data.get(j + 1).getLetter().toCharArray()[0];
                        if (sort1 > sort2) {  //交换两数位置
                            Collections.swap(data, j + 1, j);//交换位置
                        }
                    }
                }

                List<String> list = new ArrayList<>();
                for (BrandBean bean : data) {
                    if (!list.contains(bean.getLetter())){
                        list.add(bean.getLetter());
                    }
                }
                initLetter(list);

                allBrandAdapter.replaceData(data);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    private void getVedio() {

        Map<String, String> map = RetrofitUtils.getRequestMap();

        // { "code": "RT201911011052453667232", "name": "玩售后" },
        // { "code": "RT201911011052313086637", "name": "玩汽车" },
        // { "code": "RT201911011052165353997", "name": "玩保险" },
        // { "code": "RT201911011050254727016", "name": "玩分期" }

        map.put("bizCode", "RT201911011052313086637");
        map.put("kind", "1");
        map.put("location", "1");
        map.put("status", "1");
        map.put("start", "1");
        map.put("limit", "100");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMainResource("630585", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<MainResourceBean>(this) {

            @Override
            protected void onSuccess(MainResourceBean data, String SucMessage) {

                for (MainResourceBean.ListBean bean : data.getList()) {

                    if (bean.getKind().equals("1")) {

                        // startDismissControlViewTimer
                        mBinding.jzVideo.setTag(bean.getCode());
                        mBinding.jzVideo.setUp(MyCdConfig.QINIUURL + bean.getUrl(), bean.getName());
                        mBinding.jzVideo.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ImgUtils.loadQiniuImg(this, MyCdConfig.QINIUURL + bean.getThumbnail(),
                                mBinding.jzVideo.thumbImageView);

                        mBinding.tvTime.setText(DateUtil.formatStringData(bean.getPushDatetime(),
                                DEFAULT_DATE_FMT));
                        mBinding.tvPlays.setText(bean.getVisitNumber() + "次播放");

                        return;
                    }
                }

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}
