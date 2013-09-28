package com.discere.appxi.ui;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;

public class ActioBarTabListener implements ActionBar.TabListener {
  private ViewPager mViewPager;

  public ActioBarTabListener(ViewPager viewPager) {
    this.mViewPager = viewPager;
  }

  @Override
  public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
    mViewPager.setCurrentItem(tab.getPosition());
  }

  @Override
  public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {
    // TODO Auto-generated method stub

  }
}
