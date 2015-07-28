package com.example.chenhongyuan.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chenhongyuan.Module.Others;
import com.example.chenhongyuan.Module.Themes;
import com.example.chenhongyuan.myzhihuapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhongyuan on 15/7/10.
 */
public class DrawerLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    public List<Others> dataList = new ArrayList<Others>();
    private Context context;
<<<<<<< HEAD
    private int selectedPosition;
    private static final int FLAG_HEAD = 0;
    private static final int FLAG_INDEX = 1;
    private static final int FLAG_CONTENT = 2;

    public DrawerLayoutAdapter(Context context){
        this.context = context;
    }
=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }
<<<<<<< HEAD

=======
    private int selectedPosition;
    public DrawerLayoutAdapter(Context context){
        this.context = context;
    }
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    public void setData(Themes themes){
        dataList = themes.others;
        notifyDataSetChanged();
    }
<<<<<<< HEAD

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return FLAG_HEAD;
        } else if(position == 1){
            return FLAG_INDEX;
        } else {
            return FLAG_CONTENT;
        }
    }

=======
    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return 0;
        } else if(position == 1){
            return 1;
        } else {
            return 2;
        }
    }

    public Others getData(int position) {
        return dataList.get(position - 2);
    }

>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    protected Others getItem(int position) {
        return dataList.get(position - 2);
    }

    @Override
    public int getItemCount() {
        return dataList.size() +2;
    }
<<<<<<< HEAD

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == FLAG_HEAD){
            HeadViewHolder textViewHolder = (HeadViewHolder) holder;
        } else if(getItemViewType(position) == FLAG_CONTENT){
=======
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == 0){
            DrawerLayoutTopHolder textViewHolder = (DrawerLayoutTopHolder) holder;
        } else if(getItemViewType(position) == 2){
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            ListViewHolder listViewHolder = (ListViewHolder) holder;
            listViewHolder.imageView.setImageResource(android.R.drawable.ic_input_add);
            listViewHolder.textView.setText(getItem(position).name);
            if (position == selectedPosition) {
                listViewHolder.relativeLayout.setSelected(true);
            } else {
                listViewHolder.relativeLayout.setSelected(false);
            }
        } else {
            IndexViewHolder indexViewHolder = (IndexViewHolder)holder;
            if (position == selectedPosition) {
                indexViewHolder.indexItemLayout.setSelected(true);
            } else {
                indexViewHolder.indexItemLayout.setSelected(false);
            }
        }
    }
<<<<<<< HEAD

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == FLAG_HEAD) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_head, parent, false);
            vh = new HeadViewHolder(view);
            view.setOnClickListener(this);
        } else if(viewType == FLAG_INDEX){
            View view = LayoutInflater.from(context).inflate(R.layout.item_index, parent, false);
            vh = new IndexViewHolder(view);
            view.setOnClickListener(this);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_subtheme, parent, false);
=======
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.drawlayout_topitem, parent, false);
            vh = new DrawerLayoutTopHolder(view);
            view.setOnClickListener(this);
        } else if(viewType == 1){
            View view = LayoutInflater.from(context).inflate(R.layout.drawlayout_indexitem, parent, false);
            vh = new IndexViewHolder(view);
            view.setOnClickListener(this);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.drawer_listlayout, parent, false);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            vh = new ListViewHolder(view);
            view.setOnClickListener(this);
        }
        return vh;
    }
<<<<<<< HEAD

=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    public static class ListViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ListViewHolder(View view){
            super(view);
<<<<<<< HEAD
            imageView = (ImageView)view.findViewById(R.id.image_list_item);
            textView = (TextView)view.findViewById(R.id.tv_list_item);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_item_container);
        }
    }

    public static class HeadViewHolder extends RecyclerView.ViewHolder{
        public HeadViewHolder(View view){
            super(view);
        }
    }

=======
            imageView = (ImageView)view.findViewById(R.id.listItemImage);
            textView = (TextView)view.findViewById(R.id.listItemTextView);
            relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_item_container);
        }
    }
    public static class DrawerLayoutTopHolder extends RecyclerView.ViewHolder{
        public LinearLayout linearLayout;
        public DrawerLayoutTopHolder(View view){
            super(view);
            linearLayout = (LinearLayout)view.findViewById(R.id.ll_layout);
        }
    }
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    public static class IndexViewHolder extends RecyclerView.ViewHolder {
        public ImageView homeImage;
        public TextView indexText;
        public RelativeLayout indexItemLayout;
        public IndexViewHolder (View view) {
            super(view);
<<<<<<< HEAD
            homeImage = (ImageView)view.findViewById(R.id.image_home);
            indexText = (TextView)view.findViewById(R.id.tv_index);
            indexItemLayout = (RelativeLayout)view.findViewById(R.id.rl_index_item);
        }
    }

    public static interface OnRecyclerViewItemClickListener {
        void OnItemClick(View view);
    }

=======
            homeImage = (ImageView)view.findViewById(R.id.home);
            indexText = (TextView)view.findViewById(R.id.textView_index);
            indexItemLayout = (RelativeLayout)view.findViewById(R.id.indexItemLayout);
        }
    }
    public static interface OnRecyclerViewItemClickListener {
        void OnItemClick(View view);
    }
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if(mOnItemClickListener != null){
            mOnItemClickListener.OnItemClick(v);
        }
    }
}
