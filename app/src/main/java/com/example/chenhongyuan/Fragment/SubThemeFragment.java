package com.example.chenhongyuan.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.chenhongyuan.Adapter.ThemeAdapter;
import com.example.chenhongyuan.Module.Editor;
import com.example.chenhongyuan.Module.RetrofitService;
import com.example.chenhongyuan.Module.StoryBody;
import com.example.chenhongyuan.Module.ThemeContent;
import com.example.chenhongyuan.Module.AllService;
import com.example.chenhongyuan.myzhihuapplication.EditorActivity;
import com.example.chenhongyuan.myzhihuapplication.NewsActivity;
import com.example.chenhongyuan.myzhihuapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.RestAdapter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chenhongyuan on 15/7/14.
 */
public class SubThemeFragment extends Fragment{
    @Bind(R.id.subtheme_swipe_layout) SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.theme_recyclerView) RecyclerView themeRecyclerView;
    public static final String KEY_BODY = "body";
    public static final String KEY_VALUE = "theme_value";
    public static final String KEY_NEWS = "newsId";
    public static final int SET_DATA = 0;
    public static final int REFRESH_DATA = 1;
    ThemeAdapter themeAdapter;
    List<Editor> editorList;
    ThemeContent content;
    StoryBody storybody;
    static boolean attention;
    private boolean isLoading = false;
    int position;
    int newsId;
    RetrofitService service;

    public void setLayout(int id) {
        this.position = id;
    }

    public void ServiceInfo (final int type){
        service.retrofit().themeContent(position).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThemeContent>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(ThemeContent themeContent) {
                        if(type == SET_DATA){
                            themeAdapter.setData(themeContent);
                            getActivity().setTitle(themeContent.name);
                            editorList = themeContent.editors;
                            content = themeContent;
                        } else if(type == REFRESH_DATA){
                            themeAdapter.addData(themeContent);
                        }

                    }
                });
    }
    public void ContentServiceInfo() {
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
                        bundle.putParcelable(KEY_BODY, storybody);
                        intent.putExtra(KEY_VALUE, bundle);
                        intent.putExtra(KEY_NEWS, newsId);
                        startActivity(intent);
                    }
                });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subtheme, container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                ServiceInfo(SET_DATA);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        themeRecyclerView.setLayoutManager(linearLayoutManager);
        themeRecyclerView.setHasFixedSize(true);
        themeAdapter = new ThemeAdapter(getActivity());
        ServiceInfo(SET_DATA);
        themeRecyclerView.setAdapter(themeAdapter);
        setHasOptionsMenu(true);
        themeAdapter.setOnItemClickListener(new ThemeAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void OnItemClick(View view) {
                final int position = themeRecyclerView.getChildAdapterPosition(view);
                themeAdapter.setSelectedPosition(position);
                themeAdapter.setHasRead(position);
                if (position == 1) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), EditorActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("EditorList", (ArrayList<? extends Parcelable>) editorList);
                    intent.putExtra("EditorList", bundle);
                    startActivity(intent);
                } else if (position == 0) {
                    //TODO NOTHING
                } else {
                    newsId = content.stories.get(position - 2).id;
                    ContentServiceInfo();
                }
            }
        });

        themeRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
                if (lastVisiblePosition == content.stories.size()) {
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.fragment_menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_attention:
                if(!attention){
                    item.setIcon(R.mipmap.ic_unsubsricbe);
                    Toast.makeText(getActivity(), "已关注", Toast.LENGTH_SHORT).show();
                    attention = true;
                } else {
                    item.setIcon(R.mipmap.ic_subscribe);
                    Toast.makeText(getActivity(), "取消关注", Toast.LENGTH_SHORT).show();
                    attention = false;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }
}
