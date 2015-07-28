package com.example.chenhongyuan.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chenhongyuan.Module.Story;
import com.example.chenhongyuan.Module.StoryBody;
import com.example.chenhongyuan.myzhihuapplication.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenhongyuan on 15/7/17.
 */
public class IndexNewsFragment extends Fragment {
    @Bind(R.id.image_story) public ImageView headPicView;
    @Bind(R.id.tv_story_title) public TextView storyInfoView;
    @Bind(R.id.webview_body) public WebView bodyView;
    public String headPic;
    public String storyInfo;
    public String body;

    public void setData(Story story, StoryBody body) {
        headPic = story.images.get(0);
        storyInfo = story.title;
        this.body = body.body;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index_news, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Picasso.with(getActivity()).load(headPic).into(headPicView);
        storyInfoView.setText(storyInfo);
        bodyView.getSettings().setJavaScriptEnabled(true);
        bodyView.loadData(body, "text/html; charset=utf-8", "utf-8");
    }
}
