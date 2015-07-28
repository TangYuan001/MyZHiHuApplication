package com.example.chenhongyuan.myzhihuapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.chenhongyuan.Fragment.EditorInfoFragment;
import com.example.chenhongyuan.Module.Editor;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenhongyuan on 15/7/16.
 */
public class EditorInfoActivity extends ActionBarActivity {
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

        Bundle bundle = getIntent().getBundleExtra("EditorInfo");
        Editor editorInfo = bundle.getParcelable("EditorInfo");
        EditorInfoFragment editorInfoFragment = new EditorInfoFragment();
        editorInfoFragment.setData(editorInfo);
        getSupportFragmentManager().beginTransaction().replace(R.id.editor_fragment_container, editorInfoFragment).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
