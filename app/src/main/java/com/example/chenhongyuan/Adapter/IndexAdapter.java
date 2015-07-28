package com.example.chenhongyuan.Adapter;

import android.content.Context;
<<<<<<< HEAD
=======
import android.content.res.ColorStateList;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
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
<<<<<<< HEAD
    ViewPagerAdapter indexViewPagerAdapter;
    public List<Story> data = new ArrayList();
    private static final int FLAG_HEAD = 0;
    private static final int FLAG_CONTENT = 1;
    private static List<Integer> hasRead = new ArrayList<Integer>();
    private int selectedPosition;
    Context context;

    public IndexAdapter (Context c, FragmentManager fragmentManager){
        indexViewPagerAdapter = new ViewPagerAdapter(fragmentManager);
=======
    ViewPagerFragmentPagerAdapter myFragmentPagerAdapter;
    public List<Story> datas = new ArrayList();
    Context context;
    private static List<Integer> hasread = new ArrayList<Integer>();
    private int selectedPosition;
    public IndexAdapter (Context c, FragmentManager fragmentManager){
        myFragmentPagerAdapter = new ViewPagerFragmentPagerAdapter(fragmentManager);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        context = c;
    }

    public void setSelectedPosition (int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }
<<<<<<< HEAD
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
=======
    public void setHasread (int position) {
        hasread.add(position);
        notifyDataSetChanged();
    }

    public void setDatas (Info info) {
        datas = info.stories;
        myFragmentPagerAdapter.setData(info.top_stories);
        notifyDataSetChanged();
    }
    public void addDatas (Info addInfo) {
        datas.addAll(addInfo.stories);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
<<<<<<< HEAD
            return FLAG_HEAD;
        } else {
            return FLAG_CONTENT;
        }
    }

    public Story getItem(int position) {
        return data.get(position-1);
=======
            return 1;
        } else {
            return 2;
        }
    }
    public Story getItem(int position) {
        return datas.get(position-1);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
<<<<<<< HEAD
        if(viewType == FLAG_CONTENT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
            vh = new ViewHolder(view);
            view.setOnClickListener(this);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index_head, parent, false);
=======
        if(viewType == 2) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            vh = new ViewHolder(view);
            view.setOnClickListener(this);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_topitem, parent, false);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            vh = new IndexTopViewHolder(view);
            view.setOnClickListener(this);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
<<<<<<< HEAD
        if(getItemViewType(position) == FLAG_CONTENT){
=======
        if(getItemViewType(position) == 2){
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.textView.setText("" + getItem(position).title);
            Picasso.with(context)
                    .load(Uri.parse(getItem(position).images.get(0)))
<<<<<<< HEAD
                    .placeholder(R.mipmap.ic_default)
                    .error(R.mipmap.ic_default)
                    .into(viewHolder.imageView);
           if(hasRead.contains(position)){
=======
                    .placeholder(R.mipmap.pic4)
                    .error(R.mipmap.pic4)
                    .into(viewHolder.imageView);
           if(hasread.contains(position)){
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
               viewHolder.textView.setTextColor(Color.parseColor("#A9A9A9"));
           } else {
               viewHolder.textView.setTextColor(Color.parseColor("#000000"));
           }
        } else {
            IndexTopViewHolder newViewHolder = (IndexTopViewHolder) holder;
<<<<<<< HEAD
            newViewHolder.viewPager.setAdapter(indexViewPagerAdapter);
            newViewHolder.indicator.setViewPager(newViewHolder.viewPager);
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
=======
            newViewHolder.viewPager.setAdapter(myFragmentPagerAdapter);
            newViewHolder.indicator.setViewPager(newViewHolder.viewPager);
        }

    }
    @Override
    public int getItemCount() {
        return datas.size() + 1;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public ViewHolder(View view){
            super(view);
<<<<<<< HEAD
            textView = (TextView)view.findViewById(R.id.tv_simple);
            imageView = (ImageView)view.findViewById(R.id.image_simple);
        }
    }

=======
            textView = (TextView)view.findViewById(R.id.simpleText);
            imageView = (ImageView)view.findViewById(R.id.simpleImage);
        }
    }
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    public static class IndexTopViewHolder extends RecyclerView.ViewHolder{
        public ViewPager viewPager;
        public TextView textView ;
        public CirclePageIndicator indicator;
        public IndexTopViewHolder(View view){
            super(view);
<<<<<<< HEAD
            viewPager = (ViewPager)view.findViewById(R.id.view_pager);
            indicator = (CirclePageIndicator)view.findViewById(R.id.titles);
            textView = (TextView)view.findViewById(R.id.tv_today_news);
=======
            viewPager = (ViewPager)view.findViewById(R.id.viewPager);
            indicator = (CirclePageIndicator)view.findViewById(R.id.titles);
            textView = (TextView)view.findViewById(R.id.main_text);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        }
    }

    public static interface OnRecyclerViewItemClickListener {
        void OnItemClick(View view);
    }
<<<<<<< HEAD

=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    public void onClick(View v) {
        if(mOnItemClickListener != null){
<<<<<<< HEAD
            ((TextView)v.findViewById(R.id.tv_simple)).setTextColor(Color.parseColor("#A9A9A9"));
=======
            ((TextView)v.findViewById(R.id.simpleText)).setTextColor(Color.parseColor("#A9A9A9"));
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            mOnItemClickListener.OnItemClick(v);
        }
    }

}
