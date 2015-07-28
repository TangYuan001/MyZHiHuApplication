package com.example.chenhongyuan.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.chenhongyuan.Module.StoryBody;
import com.example.chenhongyuan.myzhihuapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenhongyuan on 15/7/20.
 */
public class SubThemeNewsFragment extends Fragment {
    @Bind(R.id.theme_news_body) public WebView bodyView;
    public String body;

    public void setData(StoryBody body) {
        this.body = body.body;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subtheme_news, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bodyView.getSettings().setJavaScriptEnabled(true);
        bodyView.loadData(body, "text/html; charset=utf-8", "utf-8");
    }
}
