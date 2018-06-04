package com.cdkj.huatuweitong.module.user;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.adapters.ViewPagerAdapter;
import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityMyMessageBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的消息
 */
public class MyMessageActivity extends AbsBaseLoadActivity {
    ActivityMyMessageBinding mBinding;

    public static void open(Context context){
        if (context!=null){
            Intent intent =new Intent(context,MyMessageActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_my_message, null, false);

        return mBinding.getRoot();
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        mBaseBinding.titleView.setMidTitle("我的消息");
        mBinding.viewindicator.setmLinWidth(25);
        mBinding.viewindicator.setVisibleTabCount(4);
        List<String> titls=new ArrayList<>();
//        titls.add("提醒");
//        titls.add("催款");
//        titls.add("通知");
//        titls.add("公告");
        mBinding.viewindicator.setTabItemTitles(titls);
        mBinding.viewindicator.setViewPager(mBinding.viewpager, 0);


        //设置fragment数据
        ArrayList fragments = new ArrayList<>();

        fragments.add(MyMessageActivityFragment.getInstance("1"));
//        fragments.add(MyMessageActivityFragment.getInstance("1"));
//        fragments.add(MyMessageActivityFragment.getInstance("1"));
//        fragments.add(MyMessageActivityFragment.getInstance("1"));


        mBinding.viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        mBinding.viewpager.setOffscreenPageLimit(fragments.size());
        mBinding.viewpager.setPagingEnabled(true);
    }
}
