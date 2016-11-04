package com.github.shoji.nbmock.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.github.shoji.nbmock.R;
import com.github.shoji.nbmock.component.LoopViewPager;
import com.github.shoji.nbmock.component.SlidingTabLayout;
import com.github.shoji.nbmock.fragment.TestFragment;

public class MainActivity extends AppCompatActivity {

    private static final int[] CONTENT = new int[]{1, 2, 3, 4};
    private LoopViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleMusicAdapter adapter = new GoogleMusicAdapter(getSupportFragmentManager());
        pager = (LoopViewPager) findViewById(R.id.pager);
        pager.setBoundaryCaching(true);
        pager.setAdapter(adapter);
        pager.setCurrentItem(0, false);

        SlidingTabLayout tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        tabs.setViewPager(pager);

        AppBarLayout appbar = (AppBarLayout) findViewById(R.id.app_bar_layout);

        pager.setY(appbar.getHeight());
    }

    class GoogleMusicAdapter extends FragmentPagerAdapter {
        public GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            position = LoopViewPager.toRealPosition(position, getCount());
            return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return String.valueOf(CONTENT[position % CONTENT.length]);
        }

        @Override
        public int getCount() {
            return CONTENT.length;
        }
    }
}
