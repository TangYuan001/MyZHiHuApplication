package com.example.chenhongyuan.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
<<<<<<< HEAD
=======
import android.widget.LinearLayout;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
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
<<<<<<< HEAD
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

=======
    public ThemeContent content;
    public Context context;
    private int position;
    private static List<Integer> hasread = new ArrayList<Integer>();
    private static final int FLAG_HEAD = 0;
    private static final int FLAG_AUTHOR = 1;
    private static final int FLAG_CONTENT = 2;
    public ThemeAdapter (Context c){
        context = c;
    }
    public void setHasread (int position) {
        hasread.add(position);
        notifyDataSetChanged();
    }
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    public void setData (ThemeContent content) {
        this.content = content;
        notifyDataSetChanged();
    }
<<<<<<< HEAD

=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    public void addData (ThemeContent addContent){
        content.stories.addAll(addContent.stories);
        notifyDataSetChanged();
    }
<<<<<<< HEAD

=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    public void setSelectedPosition (int selectedPosition){
        position = selectedPosition;
        notifyDataSetChanged();
    }
<<<<<<< HEAD

=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
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
<<<<<<< HEAD
            return FLAG_EDITOR;
=======
            return FLAG_AUTHOR;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
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
<<<<<<< HEAD
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
            vh = new ContentViewHolder(view);
            view.setOnClickListener(this);
        } else if(viewType == FLAG_HEAD) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subtheme_head, parent, false);
            vh = new ThemeHeadViewHolder(view);
            view.setOnClickListener(this);
        } else {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_editor, parent, false);
=======
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            vh = new ContentViewHolder(view);
            view.setOnClickListener(this);
        } else if(viewType == FLAG_HEAD) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.theme_top, parent, false);
            vh = new ThemeTopViewHolder(view);
            view.setOnClickListener(this);
        } else {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.theme_editor, parent, false);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            vh = new EditorViewHolder(view);
            view.setOnClickListener(this);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == FLAG_HEAD) {
<<<<<<< HEAD
            ThemeHeadViewHolder themeTopViewHolder = (ThemeHeadViewHolder) holder;
            Picasso.with(context)
                    .load(content.background)
                    .placeholder(R.mipmap.ic_default)
                    .into(themeTopViewHolder.imageView);
            themeTopViewHolder.titleInfo.setText(content.description);
        } else if(getItemViewType(position) == FLAG_EDITOR){
=======
            ThemeTopViewHolder themeTopViewHolder = (ThemeTopViewHolder) holder;
            Picasso.with(context)
                    .load(content.background)
                    .placeholder(R.mipmap.pic4)
                    .into(themeTopViewHolder.imageView);
            themeTopViewHolder.titleInfo.setText(content.description);
        } else if(getItemViewType(position) == FLAG_AUTHOR){
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            EditorViewHolder authorViewHolder = (EditorViewHolder)holder;
            EditorAdapter authorAdapter = new EditorAdapter(context);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            authorViewHolder.editorPicRecyclerView.setLayoutManager(linearLayoutManager);
            authorViewHolder.editorPicRecyclerView.setAdapter(authorAdapter);
            authorViewHolder.editorPicRecyclerView.setHasFixedSize(true);
            authorAdapter.setData(content);
<<<<<<< HEAD
=======

>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        } else {
            ContentViewHolder viewHolder = (ContentViewHolder) holder;
            viewHolder.textView.setText(getItem(position).title);
            List<String> images = getItem(position).images;
            if (images != null && images.size() > 0) {
<<<<<<< HEAD
                Picasso.with(context)
                        .load(images.get(0))
                        .placeholder(R.mipmap.ic_default)
                        .into(viewHolder.imageView);
            }
            if(hasRead.contains(position)){
=======
                Picasso.with(context).load(images.get(0))
                        .placeholder(R.mipmap.pic4)
                        .into(viewHolder.imageView);
            }
            if(hasread.contains(position)){
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
                viewHolder.textView.setTextColor(Color.parseColor("#A9A9A9"));
            } else {
                viewHolder.textView.setTextColor(Color.parseColor("#000000"));
            }
        }
    }
<<<<<<< HEAD

=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    public static class ContentViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public ContentViewHolder(View view){
            super(view);
<<<<<<< HEAD
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

=======
            textView = (TextView)view.findViewById(R.id.simpleText);
            imageView = (ImageView)view.findViewById(R.id.simpleImage);
        }
    }
    public static class ThemeTopViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleInfo;
        public ThemeTopViewHolder (View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.top_image);
            titleInfo = (TextView)view.findViewById(R.id.title_info);
        }
    }
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    public static class EditorViewHolder extends RecyclerView.ViewHolder {
        public TextView editorName;
        public RecyclerView editorPicRecyclerView;
        public RelativeLayout editorContainerView;
        public EditorViewHolder (View view) {
            super(view);
<<<<<<< HEAD
            editorName = (TextView)view.findViewById(R.id.tv_editor);
            editorPicRecyclerView = (RecyclerView)view.findViewById(R.id.editor_recyclerView);
=======
            editorName = (TextView)view.findViewById(R.id.editor_name);
            editorPicRecyclerView = (RecyclerView)view.findViewById(R.id.editorName_recyclerView);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            editorContainerView = (RelativeLayout) view.findViewById(R.id.rl_editor_container);
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
            mOnItemClickListener.OnItemClick(v);
        }
    }
<<<<<<< HEAD
=======


>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
}
