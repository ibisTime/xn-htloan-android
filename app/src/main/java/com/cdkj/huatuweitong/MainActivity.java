package com.cdkj.huatuweitong;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cdkj.baselibrary.adapters.ViewPagerAdapter;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelpr;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.databinding.ActivityMainBinding;
import com.cdkj.huatuweitong.module.main_tab.FirstPageFragment;
import com.cdkj.huatuweitong.module.main_tab.ReimbursementFragment;
import com.cdkj.huatuweitong.module.main_tab.UserFragment;
import com.cdkj.huatuweitong.module.mfirst_page.CarBrandActivity;

import java.util.ArrayList;

@Route(path = CdRouteHelper.APP_MAIN)
public class MainActivity extends AbsBaseLoadActivity {


    private ActivityMainBinding mBinding;
    private boolean checkFerst;//是否选中 首页界面(用于修改密码后跳转mainactivity )

//    public static void open(Context context,boolean isCheckFerst){
//        if (context!=null){
//        Intent intent = new Intent(context,MainActivity.class);
//            intent.putExtra("checkFerst",isCheckFerst);
//        context.startActivity(intent);
//        }
//
//    }

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
    }


    private void initListener() {

        mBinding.layoutTab.radiogroup.setOnCheckedChangeListener((radioGroup, i) -> {

            switch (i) {
                case R.id.radio_main_tab_1:
                    mBinding.pagerMain.setCurrentItem(0);
                    break;
                case R.id.radio_main_tab_2:
                    if (!SPUtilHelpr.isLogin(MainActivity.this, false)) {
                        //没有登陆点击其他的  还然他选中第一个  不然界面会错乱
                        mBinding.layoutTab.radioMainTab1.setChecked(true);
                        return;
                    }
                    mBinding.pagerMain.setCurrentItem(1);
                    break;
                case R.id.radio_main_tab_3:
                    if (!SPUtilHelpr.isLogin(MainActivity.this, false)) {
                        mBinding.layoutTab.radioMainTab1.setChecked(true);
                        return;
                    }
                    mBinding.pagerMain.setCurrentItem(2);
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

        fragments.add(FirstPageFragment.getInstance());//首页
        fragments.add(ReimbursementFragment.getInstance());//还款
        fragments.add(UserFragment.getInstance());//我的

        mBinding.pagerMain.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        mBinding.pagerMain.setOffscreenPageLimit(fragments.size());
    }


}
