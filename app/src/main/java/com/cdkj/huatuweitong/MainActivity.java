package com.cdkj.huatuweitong;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cdkj.baselibrary.adapters.ViewPagerAdapter;
import com.cdkj.baselibrary.appmanager.CdRouteHelper;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.databinding.ActivityMainBinding;
import com.cdkj.huatuweitong.module.main_tab.FirstPageFragment;
import com.cdkj.huatuweitong.module.main_tab.ReimbursementFragment;
import com.cdkj.huatuweitong.module.main_tab.UserFragment;

import java.util.ArrayList;
@Route(path = CdRouteHelper.USERMAIN)
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
//        测试接口
//        Map<String, String> loginMp = new HashMap<>();
//        loginMp.put("kind", "C");
//        loginMp.put("loginName", "15268501481");
//        loginMp.put("loginPwd", "888888");
//      //  Call<BaseResponseModel<UserLoginModel>> baseResponseModelCall = RetrofitUtils.getBaseAPiService().userLogin("80555", StringUtils.getJsonToString(loginMp));
//
//        Call<BaseResponseModel<LoginBean>> baseResponseModelCall = RetrofitUtils.createApi(MyApiServer.class).logIn("805050", StringUtils.getJsonToString(loginMp));
//        Log.i("pppppp", "afterCreate: " + baseResponseModelCall.toString());
//
//        baseResponseModelCall.enqueue(new BaseResponseModelCallBack<LoginBean>(this) {
//            @Override
//            protected void onSuccess(LoginBean data, String SucMessage) {
//
//            }
//
//            @Override
//            protected void onFinish() {
//
//            }
//        });
    }


    private void initListener() {

        mBinding.layoutTab.radiogroup.setOnCheckedChangeListener((radioGroup, i) -> {

            switch (i) {
                case R.id.radio_main_tab_1:
                    mBinding.pagerMain.setCurrentItem(0);
                    break;
                case R.id.radio_main_tab_2:
                    mBinding.pagerMain.setCurrentItem(1);
                    break;
                case R.id.radio_main_tab_3:
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
