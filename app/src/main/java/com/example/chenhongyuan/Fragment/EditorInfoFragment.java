package com.example.chenhongyuan.Fragment;

<<<<<<< HEAD
=======
import android.app.FragmentTransaction;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
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

<<<<<<< HEAD
import butterknife.Bind;
import butterknife.ButterKnife;
=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by chenhongyuan on 15/7/16.
 */
public class EditorInfoFragment extends Fragment {
<<<<<<< HEAD
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
=======
    public CircleImageView editorInfoPic;
    public TextView editorInfoName;
    public TextView editorInfoOffice;
    public String sEditorInfoPic;
    public String sEditorInfoName;
    public String sEditorInfoOffice;
    public void setData (Editor editor) {
        sEditorInfoName = editor.name;
        sEditorInfoOffice = editor.bio;
        sEditorInfoPic = editor.avatar;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.editor_info_fragment, container, false);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
<<<<<<< HEAD

        Picasso.with(getActivity())
                .load(EditorInfoPic)
                .into(editorInfoPic);
        editorInfoName.setText(EditorInfoName);
        editorInfoBio.setText(EditorInfoBio);
=======
        editorInfoOffice = (TextView)getActivity().findViewById(R.id.editor_info_bio);
        editorInfoName = (TextView)getActivity().findViewById(R.id.editor_info_name);
        editorInfoPic = (CircleImageView)getActivity().findViewById(R.id.editor_info_pic);
        Picasso.with(getActivity())
                .load(sEditorInfoPic).into(editorInfoPic);
        editorInfoName.setText(sEditorInfoName);
        editorInfoOffice.setText(sEditorInfoOffice);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    }

}
