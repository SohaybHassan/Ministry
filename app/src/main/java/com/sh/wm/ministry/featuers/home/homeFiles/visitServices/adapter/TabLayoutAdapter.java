package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<Fragment>();
    private final List<String> fragmentTitle =new ArrayList<String>();

    public TabLayoutAdapter(FragmentManager fm) {
        super(fm);
    }// end constructer

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }// end getPageTitle()

    public void addFragment(Fragment fragment, String title){
      fragmentList.add(fragment);
      fragmentTitle.add(title);
    }// end addFragment()
    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }// end getItem()

    @Override
    public int getCount() {

        return fragmentList.size();
    } // end getCount()
}//end class
