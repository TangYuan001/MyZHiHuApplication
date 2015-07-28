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
import com.example.chenhongyuan.Fragment.SubThemeFragment;
import com.example.chenhongyuan.Fragment.IndexFragment;
import com.example.chenhongyuan.Module.AllService;
import com.example.chenhongyuan.Module.Others;
import com.example.chenhongyuan.Module.RetrofitService;
import com.example.chenhongyuan.Module.Themes;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import retrofit.RestAdapter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends ActionBarActivity {
    @Bind(R.id.drawer_recyclerView) RecyclerView drawerRecyclerView;
    @Bind(R.id.drawer_layout) DrawerLayout drawerLayout;
    @Bind(R.id.main_toolbar) Toolbar mainToolbar;

    DrawerLayoutAdapter drawerLayoutAdapter;
    ActionBarDrawerToggle actionBarDrawerToggle;
    List<Others> otherList = new ArrayList<Others>();
    RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mainToolbar);
        drawerLayoutAdapter = new DrawerLayoutAdapter(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mainToolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        mainToolbar.setNavigationIcon(R.mipmap.ic_toolbar);
        mainToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        ServiceInfo();

        drawerRecyclerView.setAdapter(drawerLayoutAdapter);
        drawerLayoutAdapter.setOnItemClickListener(new DrawerLayoutAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void OnItemClick(View view) {
                int position = drawerRecyclerView.getChildLayoutPosition(view);
                drawerLayoutAdapter.setSelectedPosition(position);
                if(position == 0){
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
                }

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        drawerRecyclerView.setLayoutManager(linearLayoutManager);
        drawerRecyclerView.setHasFixedSize(true);

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
        // Handle action bar item_story clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item_story.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }
}
