package com.cdkj.huatuweitong.module.vehicle_db;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.api.BaseResponseListModel;
import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.adapters.LevelAdapter;
import com.cdkj.huatuweitong.adapters.TvSelectAdapter;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.CarSystemListBean;
import com.cdkj.huatuweitong.bean.TvSelectBean;
import com.cdkj.huatuweitong.databinding.FragmentSelectedBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * 按条件查询
 */
public class SelectedFragment extends BaseLazyFragment {

    private FragmentSelectedBinding mBinding;
    private TvSelectAdapter adapterPrice;
    private LevelAdapter adapterLevel;
    private TvSelectAdapter adapterSpecVeison;
    private TvSelectAdapter adapterStructure;
    private TvSelectAdapter adapterDisplacement;
    private String strPrice;
    private String strLevel;
    private String strSpecVeison;
    private String strStructure;
    private String strDisplacement;
    private String strSelect = "";//选择的全部条件
    //    private TvSelectBean beanPrice;
//    private TvSelectBean beanLevel;
//    private TvSelectBean beanSpecVeison;
//    private TvSelectBean beanStructure;
//    private TvSelectBean beanDisplacement;
    private ArrayList<TvSelectBean> dataaPrice;
    private ArrayList<TvSelectBean> dataLevel;
    private ArrayList<TvSelectBean> dataSpecVeison;
    private ArrayList<TvSelectBean> dataStructure;
    private ArrayList<TvSelectBean> dataDisplacement;
    private HashMap<String, Serializable> map = new HashMap<>();//构造下个界面使用的数据
    private Call<BaseResponseListModel<CarSystemListBean>> carSystemlListDatas;

    public static SelectedFragment getInstance() {
        SelectedFragment fragment = new SelectedFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_selected, null, false);

        initRVPrice();
        initRVLevel();
        initRVSpecVeison();
        initRVStructure();
        initRVDisplacement();
        initListener();
        return mBinding.getRoot();
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void onInvisible() {

    }

    private void initListener() {

        mBinding.btnReset.setOnClickListener(v -> {
            mBinding.btnSubmit.setText("有0款车型符合要求");
            resetInitData();
        });

        mBinding.btnSubmit.setOnClickListener(v -> {
            if (!TextUtils.isEmpty(strSelect)) {
                CarSystemListActivity.open(mActivity, map);
            } else {
                UITipDialog.showFall(mActivity, "请选择要筛选的条件");
            }
        });
    }

    /**
     * 重置数据
     */
    private void resetInitData() {
        resetData(dataaPrice);
        resetData(dataLevel);
        resetData(dataSpecVeison);
        resetData(dataStructure);
        resetData(dataDisplacement);
        //重置筛选数据
        strPrice = "";
        strLevel = "";
        strSpecVeison = "";
        strStructure = "";
        strDisplacement = "";
        strSelect = "";
        map.remove("priceStart");
        map.remove("priceEnd");
        map.remove("levelList");
        map.remove("versionList");
        map.remove("structureList");
        map.remove("displacementStart");
        map.remove("displacementEnd");
        adapterPrice.notifyDataSetChanged();
        adapterLevel.notifyDataSetChanged();
        adapterSpecVeison.notifyDataSetChanged();
        adapterStructure.notifyDataSetChanged();
        adapterDisplacement.notifyDataSetChanged();
        showSelectView();
    }

    /**
     * 初始化数据
     *
     * @param data
     */
    private void resetData(ArrayList<TvSelectBean> data) {
        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                data.get(i).setSelect(false);
            }
        }
    }


    /**
     * 选中item
     *
     * @param position
     * @param data
     * @return
     */
    private ArrayList<TvSelectBean> setSelectItem(int position, List<TvSelectBean> data) {
        boolean falg = false;
        ArrayList<TvSelectBean> selectList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (position == i) {
                falg = !data.get(i).isSelect();
                data.get(i).setSelect(falg);
            }
            if (data.get(i).isSelect()) {
                selectList.add(data.get(i));
            }
        }
        return selectList;
    }

    /**
     * 选中item
     *
     * @param position
     * @param data
     * @return
     */
    private boolean setSingSelectItem(int position, List<TvSelectBean> data) {
        boolean falg = false;
        for (int i = 0; i < data.size(); i++) {
            if (position == i) {
                if (data.get(i).isSelect()) {
                    falg = false;
                    data.get(i).setSelect(false);
                } else {
                    falg = true;
                    data.get(i).setSelect(true);
                }
            } else {
//                falg = false;
                data.get(i).setSelect(false);
            }
        }
        return falg;
    }

    /**
     * 预算数据
     */
    private void initRVPrice() {
        dataaPrice = new ArrayList<>();
        dataaPrice.add(new TvSelectBean("35万以下", "0", "350000000"));
        dataaPrice.add(new TvSelectBean("30-50万", "350000000", "500000000"));
        dataaPrice.add(new TvSelectBean("50-70万", "500000000", "700000000"));
        dataaPrice.add(new TvSelectBean("70-90万", "700000000", "900000000"));
        dataaPrice.add(new TvSelectBean("90-110万", "900000000", "1100000000"));
        dataaPrice.add(new TvSelectBean("110-150万", "1100000000", "1500000000"));
        dataaPrice.add(new TvSelectBean("150万以上", "1500000000", ""));
        adapterPrice = new TvSelectAdapter(dataaPrice);
        mBinding.rvPrice.setLayoutManager(new GridLayoutManager(mActivity, 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBinding.rvPrice.setAdapter(adapterPrice);

        adapterPrice.setOnItemClickListener((adapter, view, position) -> {
            List<TvSelectBean> data = adapter.getData();
            if (setSingSelectItem(position, data)) {
                strPrice = data.get(position).getName();
//                beanPrice = data.get(position);
                map.put("priceStart", data.get(position).getStartValue());
                map.put("priceEnd", data.get(position).getValue());
            } else {
                strPrice = "";
//                beanPrice = null;
                map.remove("priceStart");
                map.remove("priceEnd");
            }
            adapterPrice.notifyDataSetChanged();
            showSelectView();
        });
    }

    /**
     * 级别数据
     */
    private void initRVLevel() {
        dataLevel = new ArrayList<>();
        dataLevel.add(new TvSelectBean("SUV", "0", R.mipmap.icon_car_suv));
        dataLevel.add(new TvSelectBean("轿车", "1", R.mipmap.icon_car_jiaoche));
        dataLevel.add(new TvSelectBean("MPV", "2", R.mipmap.icon_car_mpv));
        dataLevel.add(new TvSelectBean("跑车", "3", R.mipmap.icon_car_paoche));
        dataLevel.add(new TvSelectBean("皮卡", "4", R.mipmap.icon_car_pika));
        dataLevel.add(new TvSelectBean("房车", "5", R.mipmap.icon_car_fangche));
        adapterLevel = new LevelAdapter(dataLevel);
        mBinding.rvLevel.setLayoutManager(new GridLayoutManager(mActivity, 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBinding.rvLevel.setAdapter(adapterLevel);

        adapterLevel.setOnItemClickListener((adapter, view, position) -> {
            List<TvSelectBean> data = adapter.getData();
            ArrayList<TvSelectBean> levelListBean = setSelectItem(position, data);
            strLevel = "";
            ArrayList<String> levelListStr = new ArrayList<>();
            for (int i = 0; i < levelListBean.size(); i++) {
                strLevel += levelListBean.get(i).getName();
                strLevel += "/";
                levelListStr.add(levelListBean.get(i).getValue());
            }
            if (!TextUtils.isEmpty(strLevel) && strLevel.endsWith("/")) {
                strLevel = strLevel.substring(0, strLevel.length() - 1);
            }

            if (levelListStr.size() > 0) {
                map.put("levelList", levelListStr);
            } else {
                map.remove("levelList");
            }

//            if () {
//                strLevel = data.get(position).getName();
//                beanLevel = data.get(position);
//                ArrayList<String> levelList = new ArrayList<>();
//                levelList.add(data.get(position).getValue());
//                map.put("levelList", levelList);
//
//            } else {
//                strLevel = "";
//                beanLevel = null;
//                map.remove("levelList");
//            }
            adapterLevel.notifyDataSetChanged();
            showSelectView();
        });
    }

    /**
     * 规格版本
     */
    private void initRVSpecVeison() {
        dataSpecVeison = new ArrayList<>();
        dataSpecVeison.add(new TvSelectBean("中东", "1"));
        dataSpecVeison.add(new TvSelectBean("美规", "2"));
        dataSpecVeison.add(new TvSelectBean("加规", "3"));
        dataSpecVeison.add(new TvSelectBean("墨版", "4"));
        dataSpecVeison.add(new TvSelectBean("欧规", "5"));
        adapterSpecVeison = new TvSelectAdapter(dataSpecVeison);
        mBinding.rvSpecVeison.setLayoutManager(new GridLayoutManager(mActivity, 4) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBinding.rvSpecVeison.setAdapter(adapterSpecVeison);

        adapterSpecVeison.setOnItemClickListener((adapter, view, position) -> {
            List<TvSelectBean> data = adapter.getData();
            ArrayList<TvSelectBean> versionListBean = setSelectItem(position, data);
            strSpecVeison = "";
            ArrayList<String> versionListStr = new ArrayList<>();
            for (int i = 0; i < versionListBean.size(); i++) {
                strSpecVeison += versionListBean.get(i).getName();
                strSpecVeison += "/";
                versionListStr.add(versionListBean.get(i).getValue());
            }
            if (!TextUtils.isEmpty(strSpecVeison) && strSpecVeison.endsWith("/")) {
                strSpecVeison = strSpecVeison.substring(0, strSpecVeison.length() - 1);
            }

            if (versionListStr.size() > 0) {
                map.put("versionList", versionListStr);
            } else {
                map.remove("versionList");
            }

//            if (setSelectItem(position, data)) {
//                strSpecVeison = data.get(position).getName();
//                beanSpecVeison = data.get(position);
//                ArrayList<String> versionList = new ArrayList<>();
//                versionList.add(beanSpecVeison.getValue());
//                map.put("versionList", versionList);
//            } else {
//                strSpecVeison = "";
//                beanSpecVeison = null;
//                map.remove("versionList");
//            }
            adapterSpecVeison.notifyDataSetChanged();
            showSelectView();
        });
    }

    /**
     * 结构数据
     */
    private void initRVStructure() {
        dataStructure = new ArrayList<>();
        dataStructure.add(new TvSelectBean("两厢", "1"));
        dataStructure.add(new TvSelectBean("三厢", "2"));
        dataStructure.add(new TvSelectBean("掀背", "3"));
        dataStructure.add(new TvSelectBean("旅行版", "4"));
        dataStructure.add(new TvSelectBean("硬顶敞篷", "5"));
        dataStructure.add(new TvSelectBean("软顶敞篷", "6"));
        dataStructure.add(new TvSelectBean("硬顶跑车", "7"));
        adapterStructure = new TvSelectAdapter(dataStructure);
        mBinding.rvStructure.setLayoutManager(new GridLayoutManager(mActivity, 4) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBinding.rvStructure.setAdapter(adapterStructure);

        adapterStructure.setOnItemClickListener((adapter, view, position) -> {
            List<TvSelectBean> data = adapter.getData();
            ArrayList<TvSelectBean> versionListBean = setSelectItem(position, data);
            strStructure = "";
            ArrayList<String> versionListStr = new ArrayList<>();
            for (int i = 0; i < versionListBean.size(); i++) {
                strStructure += versionListBean.get(i).getName();
                strStructure += "/";
                versionListStr.add(versionListBean.get(i).getValue());
            }
            if (!TextUtils.isEmpty(strStructure) && strStructure.endsWith("/")) {
                strStructure = strStructure.substring(0, strStructure.length() - 1);
            }

            if (versionListStr.size() > 0) {
                map.put("structureList", versionListStr);
            } else {
                map.remove("structureList");
            }

//            if (setSelectItem(position, data)) {
//                strStructure = data.get(position).getName();
//                beanStructure = data.get(position);
//                ArrayList<String> structureList = new ArrayList<>();
//                structureList.add(beanStructure.getValue());
//                map.put("structureList", structureList);
//            } else {
//                strStructure = "";
//                beanStructure = null;
//                map.remove("structureList");
//            }
            adapterStructure.notifyDataSetChanged();
            showSelectView();
        });
    }

    /**
     * 排量
     */
    private void initRVDisplacement() {
        dataDisplacement = new ArrayList<>();
        dataDisplacement.add(new TvSelectBean("2.0L及以下", "0", "2.0"));
        dataDisplacement.add(new TvSelectBean("2.1-3.0L", "2.1", "3.0"));
        dataDisplacement.add(new TvSelectBean("3.1-4.0L", "3.1", "4.0"));
        dataDisplacement.add(new TvSelectBean("4.1-5.0L", "4.1", "5.0"));
        dataDisplacement.add(new TvSelectBean("5.1L以上", "5.1", ""));
        adapterDisplacement = new TvSelectAdapter(dataDisplacement);
        mBinding.rvDisplacement.setLayoutManager(new GridLayoutManager(mActivity, 4) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBinding.rvDisplacement.setAdapter(adapterDisplacement);

        adapterDisplacement.setOnItemClickListener((adapter, view, position) -> {
            List<TvSelectBean> data = adapter.getData();
            if (setSingSelectItem(position, data)) {
                strDisplacement = data.get(position).getName();
//                beanDisplacement = data.get(position);

                map.put("displacementStart", data.get(position).getStartValue());
                map.put("displacementEnd", data.get(position).getValue());
            } else {
                strDisplacement = "";
//                beanDisplacement = null;
                map.remove("displacementStart");
                map.remove("displacementEnd");
            }
            adapterDisplacement.notifyDataSetChanged();
            showSelectView();
        });
    }

    /**
     * 最上面显示筛选的条件
     */
    private void showSelectView() {
        strSelect = "";
        if (!TextUtils.isEmpty(strPrice)) {
            strSelect = strPrice + "/";
        }
        if (!TextUtils.isEmpty(strLevel)) {
            strSelect = strSelect + strLevel + "/";
        }
        if (!TextUtils.isEmpty(strSpecVeison)) {
            strSelect = strSelect + strSpecVeison + "/";
        }
        if (!TextUtils.isEmpty(strStructure)) {
            strSelect = strSelect + strStructure + "/";
        }
        if (!TextUtils.isEmpty(strDisplacement)) {
            strSelect = strSelect + strDisplacement + "/";
        }

        if (!TextUtils.isEmpty(strSelect) && strSelect.endsWith("/")) {
            strSelect = strSelect.substring(0, strSelect.length() - 1);
        }

        if (TextUtils.isEmpty(strSelect)) {
            mBinding.tvSelect.setText("");
            mBinding.btnSubmit.setText("有0款车型符合要求");
        } else {
            mBinding.tvSelect.setText(strSelect);
            //h获取有多少辆车匹配
            if (carSystemlListDatas != null)
                carSystemlListDatas.cancel();
            getMatchingCarNumber();
        }
    }


    private void getMatchingCarNumber() {
        Map<String, Serializable> mmap = new HashMap<>();
        mmap.putAll(map);
        mmap.put("status", "1");
        carSystemlListDatas = RetrofitUtils.createApi(MyApiServer.class).getCarSystemlListDatas("630426", StringUtils.getJsonToString(mmap));
        addCall(carSystemlListDatas);
        carSystemlListDatas.enqueue(new BaseResponseListCallBack<CarSystemListBean>(mActivity) {
            @Override
            protected void onSuccess(List<CarSystemListBean> data, String SucMessage) {
//                有168款车型符合要求data


                int number = 0;
                for (CarSystemListBean datum : data) {
                    List<CarSystemListBean.CarsBean> cars = datum.getCars();
                    number += cars.size();
                }
                mBinding.btnSubmit.setText("有" + number + "款车型符合要求");

            }

            @Override
            protected void onReqFailure(String errorCode, String errorMessage) {
                UITipDialog.showFall(mActivity, errorMessage);
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

}
