package com.cdkj.huatuweitong;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cdkj.baselibrary.adapters.ViewPagerAdapter;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.nets.BaseResponseListCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.DisplayHelper;
import com.cdkj.baselibrary.utils.LogUtil;
import com.cdkj.huatuweitong.api.MyApiServer;
import com.cdkj.huatuweitong.bean.NodeModel;
import com.cdkj.huatuweitong.databinding.ActivityMainBinding;
import com.cdkj.huatuweitong.module.main_tab.FirstPageFragment;
import com.cdkj.huatuweitong.module.main_tab.ReimbursementFragment;
import com.cdkj.huatuweitong.module.main_tab.UserFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

@Route(path = CdRouteHelper.APP_MAIN)
public class MainActivity extends AbsBaseLoadActivity {


    private ActivityMainBinding mBinding;
    private boolean checkFerst;//是否选中 首页界面(用于修改密码后跳转mainactivity )
    public static List<NodeModel> nodeModellist;

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
        getNodeDataList();
    }


    private void initListener() {

        mBinding.layoutTab.radiogroup.setOnCheckedChangeListener((radioGroup, i) -> {

            switch (i) {
                case R.id.radio_main_tab_1:
                    mBinding.pagerMain.setCurrentItem(0);
                    break;
                case R.id.radio_main_tab_2:
                    if (!SPUtilHelper.isLogin(MainActivity.this, false)) {
                        //没有登陆点击其他的  还然他选中第一个  不然界面会错乱
                        mBinding.layoutTab.radioMainTab1.setChecked(true);
                        return;
                    }
                    mBinding.pagerMain.setCurrentItem(1);
                    break;
                case R.id.radio_main_tab_3:
                    if (!SPUtilHelper.isLogin(MainActivity.this, false)) {
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

//        DisplayUtils
        int i = DisplayHelper.dp2px(this, 185);
        LogUtil.E("打印打印___185dp:"+i);

        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        LogUtil.E("打印打印___屏幕宽度:"+width);
        LogUtil.E("打印打印___屏幕高度:"+height);

    }



    /**
     * 获取节点列表
     */
    private void getNodeDataList() {
//        Map<String, String> map = new HashMap<>();
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
