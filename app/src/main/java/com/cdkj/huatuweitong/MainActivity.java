package com.cdkj.huatuweitong;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import android.widget.Toast;
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
import com.cdkj.huatuweitong.module.main_tab.InfoFragment;
import com.cdkj.huatuweitong.module.main_tab.ReimbursementFragment;
import com.cdkj.huatuweitong.module.main_tab.UserFragment;
import com.cdkj.huatuweitong.module.vehicle_db.VehicleDBFragment;

import java.util.ArrayList;
import java.util.List;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushClickedResult;
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
//        getNodeDataList();

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
                    if (!SPUtilHelper.isLogin(MainActivity.this, false)) {
                        if (currentPostion == 0) {
                            mBinding.layoutTab.radioMainTab1.setChecked(true);
                        } else {
                            mBinding.layoutTab.radioMainTab2.setChecked(true);
                        }
                        return;
                    }
                    currentPostion = 3;
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
        fragments.add(InfoFragment.getInstance());//资讯
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
                if (data == null || data.size() == 0) {
                    return;
                }

                nodeModellist = data;
            }

            @Override
            protected void onFinish() {
                disMissLoading();
            }
        });
    }

    @Subscribe
    public void setCurrentIndex(int index) {
        currentPostion = index;
        mBinding.pagerMain.setCurrentItem(currentPostion);
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

//    @Override
//    protected void onStart() {
//        // TODO Auto-generated method stub
//        super.onStart();
//        XGPushClickedResult click = XGPushManager.onActivityStarted(this);
//        // click.getCustomContent()
//
//
//        Log.e("", click.getActionType()+"");
//        Log.e("", click.getCustomContent()+"");
//        Log.d("TPush", "onResumeXGPushClickedResult:" + click);
//        if (click != null) { // 判断是否来自信鸽的打开方式
//            Toast.makeText(this, "通知被点击:" + click.toString(),
//                    Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        XGPushManager.onActivityStoped(this);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XGPushManager.unregisterPush(this);
    }
}
