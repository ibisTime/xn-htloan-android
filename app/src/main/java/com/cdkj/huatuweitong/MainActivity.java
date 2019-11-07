package com.cdkj.huatuweitong;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import cn.jzvd.Jzvd;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.cdkj.baselibrary.adapters.ViewPagerAdapter;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.baselibrary.model.IsSuccessModes;
import com.cdkj.baselibrary.nets.BaseResponseModelCallBack;
import com.cdkj.baselibrary.nets.RetrofitUtils;
import com.cdkj.baselibrary.utils.LogUtil;
import com.cdkj.baselibrary.utils.StringUtils;
import com.cdkj.huatuweitong.bean.EventBean;
import com.cdkj.huatuweitong.bean.NodeModel;
import com.cdkj.huatuweitong.bean.ResourceVisitNumBean;
import com.cdkj.huatuweitong.databinding.ActivityMainBinding;
import com.cdkj.huatuweitong.module.main_tab.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdkj.huatuweitong.wanbaoxian.BaoxianFrgment;
import com.cdkj.huatuweitong.wanfenqi.FenqiFragment;
import com.cdkj.huatuweitong.wanshouhou.ShouhouFragment;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;
import org.greenrobot.eventbus.Subscribe;
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
        mBinding = DataBindingUtil
                .inflate(getLayoutInflater(), R.layout.activity_main, null, false);
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

        register();
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

                    currentPostion = 2;
                    mBinding.pagerMain.setCurrentItem(currentPostion);
                    break;

                case R.id.radio_main_tab_4:

                    currentPostion = 3;
                    mBinding.pagerMain.setCurrentItem(currentPostion);
                    break;
                case R.id.radio_main_tab_5:
                    if (!SPUtilHelper.isLogin(MainActivity.this, false)) {
//                        if (currentPostion == 0) {
//                            mBinding.layoutTab.radioMainTab1.setChecked(true);
//                        } else {
//                            mBinding.layoutTab.radioMainTab2.setChecked(true);
//                        }
                        return;
                    }
                    currentPostion = 4;
                    mBinding.pagerMain.setCurrentItem(currentPostion);
                    break;
                default:

//                case R.id.radio_main_tab_6:
//
//                    currentPostion = 5;
//                    mBinding.pagerMain.setCurrentItem(currentPostion);
//                    break;
            }
        });
    }


    /**
     * 初始化ViewPager
     */
    private void initViewPager() {

        //设置fragment数据
        ArrayList fragments = new ArrayList<>();

        fragments.add(FenqiFragment.getInstance());
        fragments.add(BaoxianFrgment.getInstance());
        fragments.add(HomeFragment2.getInstance());//首页
        fragments.add(ShouhouFragment.getInstance());
        fragments.add(UserFragment.getInstance());//我的

//        fragments.add(FirstPageFragment.getInstance());//首页

//        fragments.add(ReimbursementFragment.getInstance());//还款
//        fragments.add(VehicleDBFragment.getInstance());//还款
//        fragments.add(InfoFragment.getInstance());//资讯

        mBinding.pagerMain.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        mBinding.pagerMain.setOffscreenPageLimit(fragments.size());

    }


    @Subscribe
    public void setCurrentIndex(EventBean eventBean) {

        if (eventBean.getTag().equals("setCurrentIndex")) {
            currentPostion = Integer.parseInt(eventBean.getValue());

            LogUtil.E(currentPostion + "");

//            mBinding.pagerMain.setCurrentItem(currentPostion);

            switch (currentPostion) {

                case 0:
                    mBinding.layoutTab.radiogroup.check(R.id.radio_main_tab_1);
                    break;

                case 1:
                    mBinding.layoutTab.radiogroup.check(R.id.radio_main_tab_2);
                    break;

                case 2:
                    mBinding.layoutTab.radiogroup.check(R.id.radio_main_tab_3);
                    break;

                case 3:
                    mBinding.layoutTab.radiogroup.check(R.id.radio_main_tab_4);
                    break;

                case 4:
                    mBinding.layoutTab.radiogroup.check(R.id.radio_main_tab_5);
                    break;

            }

        }

    }

    private void register() {
        XGPushManager.registerPush(this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
                //token在设备卸载重装的时候有可能会变
                Log.d("TPush", "注册成功，设备token为：" + data);
            }

            @Override
            public void onFail(Object data, int errCode, String msg) {
                Log.d("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
            }
        });

        if (!TextUtils.isEmpty(SPUtilHelper.getUserId())) {
            //注意在3.2.2 版本信鸽对账号绑定和解绑接口进行了升级具体详情请参考API文档。
            XGPushManager.bindAccount(getApplicationContext(), SPUtilHelper.getUserId());
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        XGPushManager.unregisterPush(this);
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

    @Subscribe
    public void resourceVisitNum(ResourceVisitNumBean bean) {

        updateResourceVisitNum(bean.getCode());

    }

    /**
     * 视频图片点击量
     */
    private void updateResourceVisitNum(String code) {

        if (TextUtils.isEmpty(code)){
            return;
        }

        Map<String, String> map = new HashMap<>();
        map.put("code", code);

        Call call = RetrofitUtils.getBaseAPiService()
                .successRequest("630588", StringUtils.getJsonToString(map));
        addCall(call);

        call.enqueue(new BaseResponseModelCallBack<IsSuccessModes>(this) {
            @Override
            protected void onSuccess(IsSuccessModes data, String SucMessage) {

            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }
}
