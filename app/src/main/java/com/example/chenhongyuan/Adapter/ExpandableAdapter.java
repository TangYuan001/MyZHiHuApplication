package com.example.chenhongyuan.Adapter;

<<<<<<< HEAD
=======
import android.app.ExpandableListActivity;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.chenhongyuan.Module.Comment;
<<<<<<< HEAD
import com.example.chenhongyuan.myzhihuapplication.R;
import com.squareup.picasso.Picasso;

=======
import com.example.chenhongyuan.myzhihuapplication.CommentActivity;
import com.example.chenhongyuan.myzhihuapplication.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by chenhongyuan on 15/7/21.
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {
    public List<List<Comment>> childData = new ArrayList<List<Comment>>();
    public List<String> groupData = new ArrayList<String>();
    public Context context;
<<<<<<< HEAD

    public void setData(List<List<Comment>> childList, List<String> groupList, Context c) {
        childData = childList;
        groupData = groupList;
        context = c;
        notifyDataSetChanged();
=======
    public ExpandableAdapter (List<List<Comment>> childList, List<String> groupList, Context c) {
        childData = childList;
        groupData = groupList;
        context = c;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        CommentViewHolder commentViewHolder;
        if(convertView == null){
<<<<<<< HEAD
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
            commentViewHolder = new CommentViewHolder();
            commentViewHolder.commentPic = (CircleImageView)convertView.findViewById(R.id.image_comment);
            commentViewHolder.commentPerson = (TextView)convertView.findViewById(R.id.tv_comment_person);
            commentViewHolder.commentContent = (TextView)convertView.findViewById(R.id.tv_comment_content);
=======
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_list_item, parent, false);
            commentViewHolder = new CommentViewHolder();
            commentViewHolder.commentPic = (CircleImageView)convertView.findViewById(R.id.comment_pic);
            commentViewHolder.commentName = (TextView)convertView.findViewById(R.id.comment_name);
            commentViewHolder.commentContent = (TextView)convertView.findViewById(R.id.comment_content);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            convertView.setTag(commentViewHolder);
        } else {
            commentViewHolder = (CommentViewHolder)convertView.getTag();
        }
<<<<<<< HEAD

        Picasso.with(parent.getContext())
                .load(childData.get(groupPosition).get(childPosition).avatar)
                .into(commentViewHolder.commentPic);
        commentViewHolder.commentPerson.setText(childData.get(groupPosition).get(childPosition).author);
=======
        Picasso.with(parent.getContext()).load(childData.get(groupPosition).get(childPosition).avatar)
                .into(commentViewHolder.commentPic);
        commentViewHolder.commentName.setText(childData.get(groupPosition).get(childPosition).author);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        commentViewHolder.commentContent.setText(childData.get(groupPosition).get(childPosition).content);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childData.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupData.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groupData.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView titleText = null;
        if(convertView != null) {
            titleText = (TextView)convertView;
            titleText.setText(groupData.get(groupPosition));
        } else {
            titleText = (TextView)createView(groupData.get(groupPosition));
        }
        return titleText;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private TextView createView (String content){
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 80);
        TextView titleText = new TextView(context);
        titleText.setLayoutParams(layoutParams);
        titleText.setText(content);
        return titleText;
    }
    public class CommentViewHolder {
        CircleImageView commentPic;
<<<<<<< HEAD
        TextView commentPerson;
=======
        TextView commentName;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        TextView commentContent;
    }

}
