package com.example.android.zaporozhuyeguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public PagerAdapter(Context context, FragmentManager fm) {

        super(fm);
        mContext = context;
    }

    //Создаем вкладки из фрагментов
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MuseumsFragment();
            case 1:
                return new RestaurantsFragment();
            case 2:
                return new PlacesFragment();
            default:
                return null;
        }
    }

    //Задаем количество вкладок
    @Override
    public int getCount() {
        return 3;
    }

    //Заголовок Вкладки получаем из строк
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.museums_fragment);
            case 1:
                return mContext.getString(R.string.restaurants);
            case 2:
                return mContext.getString(R.string.places);
            default:
                return null;
        }
    }
}
