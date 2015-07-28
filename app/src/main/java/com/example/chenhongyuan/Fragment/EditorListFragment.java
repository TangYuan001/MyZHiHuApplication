package com.example.chenhongyuan.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.chenhongyuan.Adapter.EditorListAdapter;
import com.example.chenhongyuan.Module.Editor;
import com.example.chenhongyuan.myzhihuapplication.EditorInfoActivity;
import com.example.chenhongyuan.myzhihuapplication.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by chenhongyuan on 15/7/16.
 */
public class EditorListFragment extends Fragment {
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
    }
}
