package com.adgvit.iosfusion2017;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


public class ForumFragPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    public ForumFragPagerAdapter(FragmentManager fm) {
        //required constructor
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: UserFragment userFragment = new UserFragment();
                    return userFragment;
            case 1: TrendingFragment trendingFragment = new TrendingFragment();
                    return trendingFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "FAQs";
            case 1: return "YOUR QUESTIONS";
        }
        return null;
    }
}
