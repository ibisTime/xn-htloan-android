package com.cdkj.huatuweitong;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cdkj.baselibrary.adapters.ViewPagerAdapter;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.NodeModel;
import com.cdkj.huatuweitong.databinding.ActivityMainBinding;
import com.cdkj.huatuweitong.module.main_tab.HomeFragment;
import com.cdkj.huatuweitong.module.main_tab.UserFragment;
import com.cdkj.huatuweitong.module.vehicle_db.VehicleDBFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

@Route(path = CdRouteHelper.APP_MAIN)
public class MainActivity extends AbsBaseLoadActivity {


    public ActivityMainBinding mBinding;
    public static List<NodeModel> nodeModellist;
    private int currentPostion;

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }

    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_main, null, false);
        return mBinding.getRoot();
    }

    @Override
    protected boolean canLoadTopTitleView() {
        return false;
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        initListener();
        initViewPager();
        getNodeDataList();
    }


    private void initListener() {

        mBinding.layoutTab.radiogroup.setOnCheckedChangeListener((radioGroup, i) -> {

            switch (i) {
                case R.id.radio_main_tab_1:
                    currentPostion = 0;
                    mBinding.pagerMain.setCurrentItem(currentPostion);
                    break;
                case R.id.radio_main_tab_2:
//                    if (!SPUtilHelper.isLogin(MainActivity.this, false)) {
//                        //没有登陆点击其他的  还然他选中第一个  不然界面会错乱
//                        mBinding.layoutTab.radioMainTab1.setChecked(true);
//                        return;
//                    }
                    currentPostion = 1;
                    mBinding.pagerMain.setCurrentItem(currentPostion);
                    break;
                case R.id.radio_main_tab_3:
                    if (!SPUtilHelper.isLogin(MainActivity.this, false)) {
                        if (currentPostion == 0) {
                            mBinding.layoutTab.radioMainTab1.setChecked(true);
                        } else {
                            mBinding.layoutTab.radioMainTab2.setChecked(true);
                        }
                        return;
                    }
                    currentPostion = 2;
                    mBinding.pagerMain.setCurrentItem(currentPostion);
                    break;
                default:
            }
        });
    }


    /**
     * 初始化ViewPager
     */
    private void initViewPager() {

        //设置fragment数据
        ArrayList fragments = new ArrayList<>();

//        fragments.add(FirstPageFragment.getInstance());//首页
        fragments.add(HomeFragment.getInstance());//首页
//        fragments.add(ReimbursementFragment.getInstance());//还款
        fragments.add(VehicleDBFragment.getInstance());//还款
        fragments.add(UserFragment.getInstance());//我的

        mBinding.pagerMain.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        mBinding.pagerMain.setOffscreenPageLimit(fragments.size());

    }


    /**
     * 获取节点列表
     */
    private void getNodeDataList() {
        Call callNode = RetrofitUtils.createApi(MyApiServer.class).getNodeDataList("630147", "{}");
        showLoadingDialog();
        callNode.enqueue(new BaseResponseListCallBack<NodeModel>(this) {

            @Override
            protected void onSuccess(List<NodeModel> data, String SucMessage) {
                if (data == null || data.size() == 0)
                    return;

                nodeModellist = data;
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

}
