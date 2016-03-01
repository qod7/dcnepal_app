package com.dcnepal.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dcnepal.R;
import com.dcnepal.adapter.ViewPagerAdapter;
import com.dcnepal.fragments.FragmentDrawer;
import com.dcnepal.fragments.FragmentMyNewsSingleCategory;

public class MainActivity extends AppCompatActivity
        implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentMyNewsSingleCategory featuredFragment = new FragmentMyNewsSingleCategory();
        FragmentMyNewsSingleCategory popularFragment = new FragmentMyNewsSingleCategory();
        FragmentMyNewsSingleCategory latestFragment = new FragmentMyNewsSingleCategory();

        Bundle featuredArgs = new Bundle();
        featuredArgs.putInt("newsCategory", 0);
        featuredFragment.setArguments(featuredArgs);

        Bundle popularArgs = new Bundle();
        popularArgs.putInt("newsCategory", 1);
        popularFragment.setArguments(popularArgs);

        Bundle latestArgs = new Bundle();
        latestArgs.putInt("newsCategory", 2);
        latestFragment.setArguments(latestArgs);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        String[] categories = getResources().getStringArray(R.array.my_news_categories);
        adapter.addFragment(featuredFragment, categories[0]);
        adapter.addFragment(popularFragment, categories[1]);
        adapter.addFragment(latestFragment, categories[2]);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        String title = getString(R.string.app_name);
        title = getResources().getStringArray(R.array.nav_drawer_labels)[position];
        Toast.makeText(this, title, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
