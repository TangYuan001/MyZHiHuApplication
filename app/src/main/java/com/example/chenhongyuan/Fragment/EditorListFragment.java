package com.example.chenhongyuan.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
import android.view.LayoutInflater;
=======
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.chenhongyuan.Adapter.EditorListAdapter;
import com.example.chenhongyuan.Module.Editor;
import com.example.chenhongyuan.myzhihuapplication.EditorInfoActivity;
import com.example.chenhongyuan.myzhihuapplication.R;

import java.util.List;

<<<<<<< HEAD
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
/**
 * Created by chenhongyuan on 15/7/16.
 */
public class EditorListFragment extends Fragment {
<<<<<<< HEAD
    @Bind(R.id.lv_editor) ListView listView;
    EditorListAdapter editorListAdapter;
    List<Editor> list;

    public void setData(List<Editor> list) {
        this.list = list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_editor_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        editorListAdapter = new EditorListAdapter();
        editorListAdapter.setData(list, getActivity());
        listView.setAdapter(editorListAdapter);
        }
    @OnItemClick(R.id.lv_editor)
    public void onClick(int position){
        Intent intent = new Intent();
        intent.setClass(getActivity(), EditorInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("EditorInfo", list.get(position));
        intent.putExtra("EditorInfo", bundle);
        startActivity(intent);
=======
    ListView listView;
    EditorListAdapter editorListAdapter;
    List<Editor> list;
    public void setData(List<Editor> list) {
        this.list = list;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.editorlistfragment, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView)getActivity().findViewById(R.id.editorlist);
        editorListAdapter = new EditorListAdapter(list, getActivity());
        listView.setAdapter(editorListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), EditorInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("EditorInfo", list.get(position));
                intent.putExtra("EditorInfo", bundle);
                startActivity(intent);

            }
        });
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    }
}
