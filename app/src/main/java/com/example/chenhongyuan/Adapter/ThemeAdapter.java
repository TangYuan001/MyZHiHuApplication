package com.example.chenhongyuan.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chenhongyuan.Module.Story;
import com.example.chenhongyuan.Module.ThemeContent;
import com.example.chenhongyuan.myzhihuapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhongyuan on 15/7/14.
 */
public class ThemeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private static List<Integer> hasRead = new ArrayList<Integer>();
    private static final int FLAG_HEAD = 0;
    private static final int FLAG_EDITOR = 1;
    private static final int FLAG_CONTENT = 2;
    public ThemeContent content;
    public Context context;
    private int position;

    public ThemeAdapter (Context c){
        context = c;
    }

    public void setHasRead (int position) {
        hasRead.add(position);
        notifyDataSetChanged();
    }

    public void setData (ThemeContent content) {
        this.content = content;
        notifyDataSetChanged();
    }

    public void addData (ThemeContent addContent){
        content.stories.addAll(addContent.stories);
        notifyDataSetChanged();
    }

    public void setSelectedPosition (int selectedPosition){
        position = selectedPosition;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return content != null ? content.stories.size()+2 : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return FLAG_HEAD;
        }else if(position == 1){
            return FLAG_EDITOR;
        } else {
            return FLAG_CONTENT;
        }
    }
    public Story getItem (int position) {
        return content.stories.get(position-2);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if(viewType == FLAG_CONTENT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
            vh = new ContentViewHolder(view);
            view.setOnClickListener(this);
        } else if(viewType == FLAG_HEAD) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subtheme_head, parent, false);
            vh = new ThemeHeadViewHolder(view);
            view.setOnClickListener(this);
        } else {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_editor, parent, false);
            vh = new EditorViewHolder(view);
            view.setOnClickListener(this);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == FLAG_HEAD) {
            ThemeHeadViewHolder themeTopViewHolder = (ThemeHeadViewHolder) holder;
            Picasso.with(context)
                    .load(content.background)
                    .placeholder(R.mipmap.ic_default)
                    .into(themeTopViewHolder.imageView);
            themeTopViewHolder.titleInfo.setText(content.description);
        } else if(getItemViewType(position) == FLAG_EDITOR){
            EditorViewHolder authorViewHolder = (EditorViewHolder)holder;
            EditorAdapter authorAdapter = new EditorAdapter(context);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            authorViewHolder.editorPicRecyclerView.setLayoutManager(linearLayoutManager);
            authorViewHolder.editorPicRecyclerView.setAdapter(authorAdapter);
            authorViewHolder.editorPicRecyclerView.setHasFixedSize(true);
            authorAdapter.setData(content);
        } else {
            ContentViewHolder viewHolder = (ContentViewHolder) holder;
            viewHolder.textView.setText(getItem(position).title);
            List<String> images = getItem(position).images;
            if (images != null && images.size() > 0) {
                Picasso.with(context)
                        .load(images.get(0))
                        .placeholder(R.mipmap.ic_default)
                        .into(viewHolder.imageView);
            }
            if(hasRead.contains(position)){
                viewHolder.textView.setTextColor(Color.parseColor("#A9A9A9"));
            } else {
                viewHolder.textView.setTextColor(Color.parseColor("#000000"));
            }
        }
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public ContentViewHolder(View view){
            super(view);
            textView = (TextView)view.findViewById(R.id.tv_simple);
            imageView = (ImageView)view.findViewById(R.id.image_simple);
        }
    }

    public static class ThemeHeadViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleInfo;
        public ThemeHeadViewHolder (View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.image_theme_top);
            titleInfo = (TextView)view.findViewById(R.id.tv_theme_title);
        }
    }

    public static class EditorViewHolder extends RecyclerView.ViewHolder {
        public TextView editorName;
        public RecyclerView editorPicRecyclerView;
        public RelativeLayout editorContainerView;
        public EditorViewHolder (View view) {
            super(view);
            editorName = (TextView)view.findViewById(R.id.tv_editor);
            editorPicRecyclerView = (RecyclerView)view.findViewById(R.id.editor_recyclerView);
            editorContainerView = (RelativeLayout) view.findViewById(R.id.rl_editor_container);
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
            mOnItemClickListener.OnItemClick(v);
        }
    }
}
