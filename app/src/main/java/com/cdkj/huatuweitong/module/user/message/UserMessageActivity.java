package com.cdkj.huatuweitong.module.user.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.cdkj.baselibrary.base.AbsTablayoutActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : qianLei
 * @since : 2019/10/29 15:49
 */
public class UserMessageActivity extends AbsTablayoutActivity {

    private List<String> mTitleList;
    private List<Fragment> mFragmentList;

    public static void open(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, UserMessageActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        initViewPager();
    }

    private void init() {

        mBaseBinding.titleView.setMidTitle("消息");

        mTitleList = new ArrayList<>();
        mTitleList.add("全部");
        mTitleList.add("通知");
        mTitleList.add("公告");

        mFragmentList = new ArrayList<>();
        mFragmentList.add(UserMessageFragment.getInstance(""));
        mFragmentList.add(UserMessageFragment.getInstance("234"));
        mFragmentList.add(UserMessageFragment.getInstance("1"));
    }

    @Override
    public List<Fragment> getFragments() {
        return mFragmentList;
    }

    @Override
    public List<String> getFragmentTitles() {
        return mTitleList;
    }

}
