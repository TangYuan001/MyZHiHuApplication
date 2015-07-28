package com.example.chenhongyuan.myzhihuapplication;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.chenhongyuan.Adapter.DrawerLayoutAdapter;
<<<<<<< HEAD
import com.example.chenhongyuan.Fragment.SubThemeFragment;
import com.example.chenhongyuan.Fragment.IndexFragment;
import com.example.chenhongyuan.Module.AllService;
import com.example.chenhongyuan.Module.Others;
import com.example.chenhongyuan.Module.RetrofitService;
=======
import com.example.chenhongyuan.Fragment.ThemeFragment;
import com.example.chenhongyuan.Fragment.MainFragment;
import com.example.chenhongyuan.Module.AllService;
import com.example.chenhongyuan.Module.Others;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import com.example.chenhongyuan.Module.Themes;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import retrofit.RestAdapter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends ActionBarActivity {
<<<<<<< HEAD
    @Bind(R.id.drawer_recyclerView) RecyclerView drawerRecyclerView;
    @Bind(R.id.drawer_layout) DrawerLayout drawerLayout;
    @Bind(R.id.main_toolbar) Toolbar mainToolbar;

    DrawerLayoutAdapter drawerLayoutAdapter;
    ActionBarDrawerToggle actionBarDrawerToggle;
    List<Others> otherList = new ArrayList<Others>();
    RetrofitService service;

=======
    DrawerLayout mDrawerLayout;
    DrawerLayoutAdapter drawerLayoutAdapter;
    ActionBarDrawerToggle actionBarDrawerToggle;
    RecyclerView drawerRecyclerView;
    List<Others> otherList = new ArrayList<Others>();
    Toolbar toolbar;

    RestAdapter adapter = new RestAdapter.Builder()
            .setEndpoint("http://news-at.zhihu.com")
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();
    AllService service = adapter.create(AllService.class);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        ButterKnife.bind(this);

        setSupportActionBar(mainToolbar);
        drawerLayoutAdapter = new DrawerLayoutAdapter(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mainToolbar, R.string.drawer_open, R.string.drawer_close){
=======
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerRecyclerView = (RecyclerView)findViewById(R.id.drawer_recyclerView);
        drawerLayoutAdapter = new DrawerLayoutAdapter(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close){
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };
<<<<<<< HEAD
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        mainToolbar.setNavigationIcon(R.mipmap.ic_toolbar);
        mainToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        ServiceInfo();

=======
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        toolbar.setNavigationIcon(R.mipmap.toolbaricon);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        service.themes().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Themes>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Themes themes) {
                        drawerLayoutAdapter.setData(themes);
                        otherList = themes.others;
                    }
                });
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        drawerRecyclerView.setAdapter(drawerLayoutAdapter);
        drawerLayoutAdapter.setOnItemClickListener(new DrawerLayoutAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void OnItemClick(View view) {
                int position = drawerRecyclerView.getChildLayoutPosition(view);
                drawerLayoutAdapter.setSelectedPosition(position);
                if(position == 0){
<<<<<<< HEAD
                    //TODO NOTHING
                } else if (position == 1) {
                    IndexFragment mainFragment = new IndexFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, mainFragment).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    SubThemeFragment drawLayoutFragment = new SubThemeFragment();
                    drawLayoutFragment.setLayout(otherList.get(position-2).id);
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, drawLayoutFragment).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
=======
                    //DO NOTHING
                } else if (position == 1) {
                    MainFragment mainFragment = new MainFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).commit();
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    ThemeFragment drawLayoutFragment = new ThemeFragment();
                    drawLayoutFragment.setLayout(otherList.get(position-2).id);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, drawLayoutFragment).commit();
                    mDrawerLayout.closeDrawer(GravityCompat.START);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
                }

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        drawerRecyclerView.setLayoutManager(linearLayoutManager);
        drawerRecyclerView.setHasFixedSize(true);

<<<<<<< HEAD
        IndexFragment mainFragment = new IndexFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, mainFragment).commit();
    }

    public void ServiceInfo(){
        service.retrofit().themes().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Themes>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Themes themes) {
                        drawerLayoutAdapter.setData(themes);
                        otherList = themes.others;
                    }
                });
=======
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).commit();
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
<<<<<<< HEAD
        // Handle action bar item_story clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item_story.getItemId();
=======
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }
}
