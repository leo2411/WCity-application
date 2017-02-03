package com.example.leo.newcity;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    PagerTitleStrip pagerTitleStrip;
    DrawerLayout drawerLayout;
    ViewPager viewPager = null;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Navigation drawer layout define
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //Fragment title setup (Asia...)
        pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.PagertitleStrip);
        pagerTitleStrip.setGravity(0x00000011);

        ////ViewPager for ScrollTab i fragmente
        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new MyAdapter(fragmentManager));

        //navigation drawer icon setup
        drawerListener = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.drawermenu);

        //home screen setup icon (swipe between fragments)
        Toast toast = new Toast(this);
        ImageView view = new ImageView(this);
        view.setImageResource(R.drawable.swipe);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();

        setUpNavigationView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerListener.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        drawerListener.syncState();
    }

    //naviagation drawer item click
    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_bookmark:
                        Toast.makeText(MainActivity.this,"Bookmark option soon",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_search:
                        Toast.makeText(MainActivity.this,"Search option soon",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_appinfo:
                       // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, AppInfo.class));
                        drawerLayout.closeDrawers();
                        return true;
                    default:
                        break;
                }
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                return true;
            }
        });
    }
}


    class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            if (position == 0) {
                fragment = new Europe_fragment();
            }
            if (position == 1) {
                fragment = new Asia_fragment();
            }
            if (position == 2) {
                fragment = new South_America_fragment();
            }
            if (position == 3) {
                fragment = new North_America_fragment();
            }
            if (position == 4) {
                fragment = new Australia_fragment();
            }
            if (position == 5) {
                fragment = new Africa_fragment();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "Europe";
            }
            if (position == 1) {
                return "Asia";
            }
            if (position == 2) {
                return "South America";
            }
            if (position == 3) {
                return "North America";
            }
            if (position == 4) {
                return "Australia";
            }
            if (position == 5) {
                return "Africa";
            }
            return null;
        }
    }