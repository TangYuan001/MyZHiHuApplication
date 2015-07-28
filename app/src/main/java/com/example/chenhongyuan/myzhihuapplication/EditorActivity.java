package com.example.chenhongyuan.myzhihuapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.chenhongyuan.Fragment.EditorListFragment;
import com.example.chenhongyuan.Module.Editor;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenhongyuan on 15/7/16.
 */
public class EditorActivity extends ActionBarActivity {
    @Bind(R.id.editor_toolbar) Toolbar editorToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        ButterKnife.bind(this);

        setSupportActionBar(editorToolbar);
        editorToolbar.setNavigationIcon(R.mipmap.ic_back);
        editorToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        editorToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        List<Editor> list = new ArrayList<Editor>();
        Bundle bundle = new Bundle();
        bundle= intent.getBundleExtra("EditorList");
        list = bundle.getParcelableArrayList("EditorList");
        EditorListFragment editorListFragment = new EditorListFragment();
        editorListFragment.setData(list);
        getSupportFragmentManager().beginTransaction().replace(R.id.editor_fragment_container, editorListFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
