package com.example.android.zaporozhuyeguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Иницализация контейнера для ViewPager
        final ViewPager viewPager = findViewById(R.id.pager);

        com.example.android.zaporozhuyeguide.PagerAdapter adapterPager = new com.example.android.zaporozhuyeguide.PagerAdapter(getApplicationContext(), getSupportFragmentManager());

        viewPager.setAdapter(adapterPager);

        // ссылки в TabLatout на фрагменты (вкладки)
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(adapterPager.getPageTitle(0)));

        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
