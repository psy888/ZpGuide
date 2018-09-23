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
                return new FoodFragment();
            case 2:
                return new NightlifeFragment();
            case 3:
                return new ShoppingFragment();
            case 4:
                return new EntertainmentFragment();
            case 5:
                return new HotelsFragment();
            case 6:
                return new GymsFragment();
            default:
                return null;
        }
    }

    //Задаем количество вкладок
    @Override
    public int getCount() {
        return 7;
    }

    //Заголовок Вкладки получаем из строк
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.museums);
            case 1:
                return mContext.getString(R.string.food);
            case 2:
                return mContext.getString(R.string.nightlife);
            case 3:
                return mContext.getString(R.string.shopping);
            case 4:
                return mContext.getString(R.string.entertainment);
            case 5:
                return mContext.getString(R.string.hotels);
            case 6:
                return mContext.getString(R.string.gyms);
            default:
                return null;
        }
    }
}
