package com.example.chenhongyuan.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenhongyuan.Adapter.ViewPagerAdapter;
import com.example.chenhongyuan.Module.Info;
import com.example.chenhongyuan.Module.AllService;
import com.example.chenhongyuan.Adapter.IndexAdapter;
import com.example.chenhongyuan.Module.RetrofitService;
import com.example.chenhongyuan.Module.StoryBody;
import com.example.chenhongyuan.myzhihuapplication.NewsActivity;
import com.example.chenhongyuan.myzhihuapplication.R;
import com.example.chenhongyuan.myzhihuapplication.SettingActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.RestAdapter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chenhongyuan on 15/7/14.
 */
public class IndexFragment extends Fragment{
    @Bind(R.id.index_swipe_layout) SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.index_recyclerView) RecyclerView indexRecyclerView;
    public static final String KEY_STORY = "story";
    public static final String KEY_BODY = "body";
    public static final String KEY_VALUE = "main_value";
    public static final String KEY_NEWS = "newsId";
    public static final int SET_DATA = 0;
    public static final int REFRESH_DATA = 1;

    ViewPagerAdapter viewPagerAdapter;
    private boolean isLoading = false;
    IndexAdapter indexAdapter;
    StoryBody storybody;
    Info mainInfo;
    int newsId;
    RetrofitService service ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("首页");
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                ServiceInfo(SET_DATA);
            }
        });
        ServiceInfo(SET_DATA);

        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        LinearLayoutManager staggeredGridLayoutManager = new LinearLayoutManager(getActivity());
        indexRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        indexRecyclerView.setHasFixedSize(true);
        indexAdapter = new IndexAdapter(getActivity(),getActivity().getSupportFragmentManager());
        indexRecyclerView.setAdapter(indexAdapter);
        setHasOptionsMenu(true);
        indexAdapter.setOnItemClickListener(new IndexAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void OnItemClick(View view) {
                final int position = indexRecyclerView.getChildAdapterPosition(view);
                indexAdapter.setSelectedPosition(position);
                indexAdapter.setHasRead(position);
                if (position > 0) {
                    newsId = mainInfo.stories.get(position - 1).id;
                    ContentServiceInfo(position);
                }
            }
        });

        indexRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int firstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (firstVisiblePosition == 0) {
                    getActivity().setTitle("首页");
                } else {
                    getActivity().setTitle("今日热闻");
                }
                int lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
                if (lastVisiblePosition == mainInfo.stories.size()) {
                    if (!isLoading) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ServiceInfo(REFRESH_DATA);
                                isLoading = false;
                            }
                        }, 3000);
                    }
                    isLoading = true;
                }
            }
        });

    }
    public void ContentServiceInfo(final int position){
        service.retrofit().storyBody(newsId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StoryBody>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(StoryBody body) {
                        storybody = body;
                        Intent intent = new Intent();
                        intent.setClass(getActivity(), NewsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(KEY_STORY, mainInfo.stories.get(position - 1));
                        bundle.putParcelable(KEY_BODY, storybody);
                        intent.putExtra(KEY_VALUE, bundle);
                        intent.putExtra(KEY_NEWS, newsId);
                        startActivity(intent);
                    }
                });
    }
    public void ServiceInfo (final int type) {
        service.retrofit().info().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Info>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Info info) {
                        if (type == SET_DATA){
                            mainInfo = info;
                            indexAdapter.setData(info);
                        } else if(type == REFRESH_DATA){
                            indexAdapter.addData(info);
                        }
                    }
                });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.index_menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.menu_settings:
                Intent intent = new Intent();
                intent.setClass(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
