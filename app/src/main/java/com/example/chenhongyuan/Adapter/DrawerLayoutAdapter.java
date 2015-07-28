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
    private int selectedPosition;
    private static final int FLAG_HEAD = 0;
    private static final int FLAG_INDEX = 1;
    private static final int FLAG_CONTENT = 2;

    public DrawerLayoutAdapter(Context context){
        this.context = context;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }

    public void setData(Themes themes){
        dataList = themes.others;
        notifyDataSetChanged();
    }

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

    protected Others getItem(int position) {
        return dataList.get(position - 2);
    }

    @Override
    public int getItemCount() {
        return dataList.size() +2;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == FLAG_HEAD){
            HeadViewHolder textViewHolder = (HeadViewHolder) holder;
        } else if(getItemViewType(position) == FLAG_CONTENT){
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
            vh = new ListViewHolder(view);
            view.setOnClickListener(this);
        }
        return vh;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ListViewHolder(View view){
            super(view);
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

    public static class IndexViewHolder extends RecyclerView.ViewHolder {
        public ImageView homeImage;
        public TextView indexText;
        public RelativeLayout indexItemLayout;
        public IndexViewHolder (View view) {
            super(view);
            homeImage = (ImageView)view.findViewById(R.id.image_home);
            indexText = (TextView)view.findViewById(R.id.tv_index);
            indexItemLayout = (RelativeLayout)view.findViewById(R.id.rl_index_item);
        }
    }

    public static interface OnRecyclerViewItemClickListener {
        void OnItemClick(View view);
    }

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
