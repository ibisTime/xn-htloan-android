package com.cdkj.baselibrary.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<String> titleString;
    private List<Fragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titleString) {
        super(fm);
        this.fragments = fragments;
        this.titleString = titleString;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (titleString == null || titleString.size() == 0) {

            return super.getPageTitle(position);
        } else {
            return titleString.get(position);
        }
    }

}
