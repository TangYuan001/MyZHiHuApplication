package com.example.chenhongyuan.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenhongyuan.Module.Editor;
import com.example.chenhongyuan.myzhihuapplication.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by chenhongyuan on 15/7/16.
 */
public class EditorInfoFragment extends Fragment {
    @Bind(R.id.editor_info_pic) public CircleImageView editorInfoPic;
    @Bind(R.id.tv_editor_name) public TextView editorInfoName;
    @Bind(R.id.tv_editor_bio) public TextView editorInfoBio;
    public String EditorInfoPic;
    public String EditorInfoName;
    public String EditorInfoBio;

    public void setData (Editor editor) {
        EditorInfoName = editor.name;
        EditorInfoBio = editor.bio;
        EditorInfoPic = editor.avatar;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editor_info, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Picasso.with(getActivity())
                .load(EditorInfoPic)
                .into(editorInfoPic);
        editorInfoName.setText(EditorInfoName);
        editorInfoBio.setText(EditorInfoBio);
    }

}
