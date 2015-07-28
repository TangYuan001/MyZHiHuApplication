package com.example.chenhongyuan.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chenhongyuan.Module.Info;
import com.example.chenhongyuan.Module.Story;
import com.example.chenhongyuan.myzhihuapplication.R;
import com.squareup.picasso.Picasso;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhongyuan on 15/7/9.
 */
public class IndexAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    ViewPagerAdapter indexViewPagerAdapter;
    public List<Story> data = new ArrayList();
    private static final int FLAG_HEAD = 0;
    private static final int FLAG_CONTENT = 1;
    private static List<Integer> hasRead = new ArrayList<Integer>();
    private int selectedPosition;
    Context context;

    public IndexAdapter (Context c, FragmentManager fragmentManager){
        indexViewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        context = c;
    }

    public void setSelectedPosition (int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }
    public void setHasRead (int position) {
        hasRead.add(position);
        notifyDataSetChanged();
    }

    public void setData (Info info) {
        data = info.stories;
        indexViewPagerAdapter.setData(info.top_stories);
        notifyDataSetChanged();
    }
    public void addData (Info addInfo) {
        data.addAll(addInfo.stories);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return FLAG_HEAD;
        } else {
            return FLAG_CONTENT;
        }
    }

    public Story getItem(int position) {
        return data.get(position-1);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if(viewType == FLAG_CONTENT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
            vh = new ViewHolder(view);
            view.setOnClickListener(this);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index_head, parent, false);
            vh = new IndexTopViewHolder(view);
            view.setOnClickListener(this);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == FLAG_CONTENT){
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.textView.setText("" + getItem(position).title);
            Picasso.with(context)
                    .load(Uri.parse(getItem(position).images.get(0)))
                    .placeholder(R.mipmap.ic_default)
                    .error(R.mipmap.ic_default)
                    .into(viewHolder.imageView);
           if(hasRead.contains(position)){
               viewHolder.textView.setTextColor(Color.parseColor("#A9A9A9"));
           } else {
               viewHolder.textView.setTextColor(Color.parseColor("#000000"));
           }
        } else {
            IndexTopViewHolder newViewHolder = (IndexTopViewHolder) holder;
            newViewHolder.viewPager.setAdapter(indexViewPagerAdapter);
            newViewHolder.indicator.setViewPager(newViewHolder.viewPager);
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public ViewHolder(View view){
            super(view);
            textView = (TextView)view.findViewById(R.id.tv_simple);
            imageView = (ImageView)view.findViewById(R.id.image_simple);
        }
    }

    public static class IndexTopViewHolder extends RecyclerView.ViewHolder{
        public ViewPager viewPager;
        public TextView textView ;
        public CirclePageIndicator indicator;
        public IndexTopViewHolder(View view){
            super(view);
            viewPager = (ViewPager)view.findViewById(R.id.view_pager);
            indicator = (CirclePageIndicator)view.findViewById(R.id.titles);
            textView = (TextView)view.findViewById(R.id.tv_today_news);
        }
    }

    public static interface OnRecyclerViewItemClickListener {
        void OnItemClick(View view);
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    public void onClick(View v) {
        if(mOnItemClickListener != null){
            ((TextView)v.findViewById(R.id.tv_simple)).setTextColor(Color.parseColor("#A9A9A9"));
            mOnItemClickListener.OnItemClick(v);
        }
    }

}
