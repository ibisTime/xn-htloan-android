package com.cdkj.huatuweitong.wanfenqi;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.*;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.AccountListModel;
import com.cdkj.huatuweitong.bean.MainResourceBean;
import com.cdkj.huatuweitong.databinding.FrgFenqiBinding;
import com.cdkj.huatuweitong.wanbaoxian.CarApplyActivity;
import com.cdkj.huatuweitong.wanfenqi.adapter.FenqiAdapter;
import com.github.chrisbanes.photoview.PhotoView;
import com.leochuan.CarouselLayoutManager;
import com.leochuan.CenterSnapHelper;
import retrofit2.Call;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.cdkj.baselibrary.utils.DateUtil.DEFAULT_DATE_FMT;

/**
 * @author : qianLei
 * @since : 2019/11/4 10:24
 */
public class FenqiFragment extends BaseLazyFragment {

    private FrgFenqiBinding mBinding;

    private FenqiAdapter pagerAdapter;
    private List<MainResourceBean.ListBean> list = new ArrayList<>();

    public static FenqiFragment getInstance() {
        FenqiFragment fragment = new FenqiFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void lazyLoad() {

        if (null != mBinding){
            getData();
        }

    }

    @Override
    protected void onInvisible() {
        Jzvd.releaseAllVideos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.frg_fenqi, null, false);

        initListener();

        getData();

        return mBinding.getRoot();
    }

    private void initListener() {

        mBinding.btnConfirm.setOnClickListener(view -> {
            if (!SPUtilHelper.isLogin(mActivity, false)) {
                return;
            }

            CarApplyActivity.open(mActivity, CarApplyActivity.FENQI);
        });

    }

    private void getData() {

        Map<String, String> map = RetrofitUtils.getRequestMap();

        // { "code": "RT201911011052453667232", "name": "玩售后" },
        // { "code": "RT201911011052313086637", "name": "玩汽车" },
        // { "code": "RT201911011052165353997", "name": "玩保险" },
        // { "code": "RT201911011050254727016", "name": "玩分期" }

        map.put("bizCode", "RT201911011050254727016");
        map.put("kind", "");
        map.put("location", "1");
        map.put("status", "1");
        map.put("start", "1");
        map.put("limit", "100");

        Call call = RetrofitUtils.createApi(MyApiServer.class)
                .getMainResource("630585", StringUtils.getJsonToString(map));

        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<MainResourceBean>(mActivity) {

            @Override
            protected void onSuccess(MainResourceBean data, String SucMessage) {

                List<MainResourceBean.ListBean> listBeans = new ArrayList<>();
                for (MainResourceBean.ListBean bean : data.getList()) {

                    if (bean.getKind().equals("1")) {

                        // startDismissControlViewTimer
                        mBinding.jzVideo.setTag(bean.getCode());
                        mBinding.jzVideo.setUp(MyCdConfig.QINIUURL + bean.getUrl(), bean.getName());
                        mBinding.jzVideo.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ImgUtils.loadQiniuImg(mActivity, MyCdConfig.QINIUURL + bean.getThumbnail(), mBinding.jzVideo.thumbImageView);

//                        mBinding.tvName.setText(bean.getName());
                        mBinding.tvTime.setText(DateUtil.formatStringData(bean.getPushDatetime(),
                                DEFAULT_DATE_FMT));
                        mBinding.tvPlays.setText(bean.getVisitNumber() + "次播放");

                    } else {

                        listBeans.add(bean);

                    }

                }

                setPager(listBeans);

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });

    }

    private void setPager(List<MainResourceBean.ListBean> data) {

        if (null == pagerAdapter) {

            list.addAll(data);
            pagerAdapter = new FenqiAdapter(list);
            pagerAdapter.setOnItemClickListener((adapter, view, position) -> {
                MainResourceBean.ListBean item = pagerAdapter.getItem(position);
                showUnDoDialog(item.getName(), item.getUrl());
            });

        } else {

            list.clear();
            list.addAll(data);
            pagerAdapter.notifyDataSetChanged();

        }

        CarouselLayoutManager carouselLayoutManager = new CarouselLayoutManager(mActivity,
                DisplayHelper.dp2px(mActivity, 100));
        carouselLayoutManager.setMinScale(0.8F);
        carouselLayoutManager.setInfinite(true);
        mBinding.rv.setLayoutManager(carouselLayoutManager);
        mBinding.rv.setAdapter(pagerAdapter);

        mBinding.rv.setOnFlingListener(null);
        new CenterSnapHelper().attachToRecyclerView(mBinding.rv);
    }

    private void showUnDoDialog(String title, String pic) {
        View view = LayoutInflater.from(mActivity)
                .inflate(R.layout.dialog_step, null);
        Dialog dialog = new Dialog(mActivity, R.style.TipsDialog);
        dialog.setContentView(view);

//        TextView tvTitle = view.findViewById(R.id.tv_title);
//        tvTitle.setText(title);
//
//        ImageView ivInfo = view.findViewById(R.id.iv_info);
//        ImgUtils.loadQiniuImg(this, pic, ivInfo);

        PhotoView photoView = view.findViewById(R.id.photoview);
        ImgUtils.loadQiniuImg(this, pic, photoView);
        photoView.setOnClickListener(view1 -> {
            dialog.dismiss();
        });

        view.findViewById(R.id.ll_root).setOnClickListener(view1 -> {
            dialog.dismiss();
        });

        dialog.getWindow()
                .setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setGravity(Gravity.CENTER);

        dialog.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}
