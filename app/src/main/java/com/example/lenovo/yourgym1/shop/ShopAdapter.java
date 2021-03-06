package com.example.lenovo.yourgym1.shop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import java.util.List;

public class ShopAdapter extends FragmentPagerAdapter {

    private List<Fragment> fmList;
    private FragmentManager fm;

    public ShopAdapter(FragmentManager fm, List<Fragment> fmList) {
        super(fm);
        this.fm = fm;
        this.fmList = fmList;
    }

    @Override
    public Fragment getItem(int arg0) {
        return fmList.get(arg0%fmList.size());
    }

    @Override
    public int getCount() {
        return fmList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
