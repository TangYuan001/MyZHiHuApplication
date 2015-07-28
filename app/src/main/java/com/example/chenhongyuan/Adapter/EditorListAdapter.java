package com.example.chenhongyuan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.BaseAdapter;
import android.widget.ImageView;
=======
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import android.widget.TextView;

import com.example.chenhongyuan.Module.Editor;
import com.example.chenhongyuan.myzhihuapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhongyuan on 15/7/16.
 */
public class EditorListAdapter extends BaseAdapter {

    public List<Editor> editorList = new ArrayList<Editor>();
    public Context context;
<<<<<<< HEAD

    public void setData(List<Editor> list, Context c) {
=======
    public EditorListAdapter(List<Editor> list, Context c) {
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        editorList = list;
        context = c;
        notifyDataSetChanged();
    }
<<<<<<< HEAD

=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    @Override
    public int getCount() {
        return editorList.size();
    }

    @Override
    public Object getItem(int position) {
        return editorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EditorViewHolder editorViewHolder;
        if(convertView == null){
<<<<<<< HEAD
            convertView = LayoutInflater.from(context).inflate(R.layout.item_editor_info, parent, false);
            editorViewHolder = new EditorViewHolder();
            editorViewHolder.editorPic = (ImageView)convertView.findViewById(R.id.editorPic);
            editorViewHolder.editorName = (TextView)convertView.findViewById(R.id.tv_editor_list_name);
            editorViewHolder.editorBio = (TextView)convertView.findViewById(R.id.tv_editor_list_office);
=======
            convertView = LayoutInflater.from(context).inflate(R.layout.editorinfolistitem, parent, false);
            editorViewHolder = new EditorViewHolder();
            editorViewHolder.editorPic = (ImageView)convertView.findViewById(R.id.editorPic);
            editorViewHolder.editorName = (TextView)convertView.findViewById(R.id.editorName);
            editorViewHolder.editorOffice = (TextView)convertView.findViewById(R.id.editorOffice);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            convertView.setTag(editorViewHolder);
        } else {
            editorViewHolder = (EditorViewHolder)convertView.getTag();
        }
<<<<<<< HEAD

        Picasso.with(context)
                .load(editorList.get(position).avatar)
                .into(editorViewHolder.editorPic);
        editorViewHolder.editorName.setText(editorList.get(position).name);
        editorViewHolder.editorBio.setText(editorList.get(position).bio);
=======
        Picasso.with(context).load(editorList.get(position).avatar).into(editorViewHolder.editorPic);
        editorViewHolder.editorName.setText(editorList.get(position).name);
        editorViewHolder.editorOffice.setText(editorList.get(position).bio);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        return convertView;
    }

    public class EditorViewHolder {
        ImageView editorPic;
        TextView editorName;
<<<<<<< HEAD
        TextView editorBio;
=======
        TextView editorOffice;

>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    }
}
