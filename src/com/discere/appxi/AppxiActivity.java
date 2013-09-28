package com.discere.appxi;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.discere.appxi.ui.ActioBarTabListener;
import com.discere.appxi.ui.PageAdapter;

public class AppxiActivity extends ActionBarActivity {
  
  /**
   * UI
   */
  private ActionBar mActionBar;
  private ViewPager mViewPager;
  private PageAdapter mPageAdapter;
  
  /**
   * Listeners
   */
  private ActionBar.TabListener mActionBarTabListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.appxi_activity);
    
    mViewPager = (ViewPager) findViewById(R.id.viewPager);
    mActionBar = getSupportActionBar();
    mActionBarTabListener = new ActioBarTabListener(mViewPager);
    
    mActionBar = getSupportActionBar();
    mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

      @Override
      public void onPageSelected(int position) {
        mActionBar.setSelectedNavigationItem(position);
      }

      @Override
      public void onPageScrolled(int arg0, float arg1, int arg2) {

      }

      @Override
      public void onPageScrollStateChanged(int arg0) {

      }
    });
    
    addTabs();
    
  }

  private void addTabs() {
    List<Fragment> fragments = new ArrayList<Fragment>();
    fragments.add(Fragment.instantiate(this, TaxiMapFragment.class.getName()));
    fragments.add(Fragment.instantiate(this, DirectoryFragment.class.getName()));
    mPageAdapter = new PageAdapter(getSupportFragmentManager(), fragments);
    mViewPager.setAdapter(mPageAdapter);

    mActionBar.addTab(mActionBar.newTab().setText(R.string.tab_map)
        .setTabListener(mActionBarTabListener));
    mActionBar.addTab(mActionBar.newTab().setText(R.string.tab_directory)
        .setTabListener(mActionBarTabListener));
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.appxi, menu);
    return true;
  }
  

}
