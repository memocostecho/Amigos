package com.amigos.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter{

	private ArrayList<Fragment> fragments;
	private ArrayList<String> pagerTitles;


	public MyPagerAdapter(FragmentManager manager) {
		super(manager);
		fragments = new ArrayList<Fragment>();
		pagerTitles = new ArrayList<String>();
	}

	public void addFragment(Fragment fragment, String title)
    {
		fragments.add(fragment);
        pagerTitles.add(title);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return pagerTitles.get(position);
	}

	
	@Override
	public Fragment getItem(int arg0) {
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}



}
