package com.example.chenhongyuan.myzhihuapplication;

<<<<<<< HEAD
import android.os.Bundle;
=======
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.chenhongyuan.Fragment.EditorInfoFragment;
import com.example.chenhongyuan.Module.Editor;

<<<<<<< HEAD
import butterknife.Bind;
import butterknife.ButterKnife;

=======
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
/**
 * Created by chenhongyuan on 15/7/16.
 */
public class EditorInfoActivity extends ActionBarActivity {
<<<<<<< HEAD
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
=======
    Toolbar toolbar;
    Editor editorInfo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editor_info_layout);
        toolbar = (Toolbar)findViewById(R.id.editor_info_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle bundle = getIntent().getBundleExtra("EditorInfo");
<<<<<<< HEAD
        Editor editorInfo = bundle.getParcelable("EditorInfo");
        EditorInfoFragment editorInfoFragment = new EditorInfoFragment();
        editorInfoFragment.setData(editorInfo);
        getSupportFragmentManager().beginTransaction().replace(R.id.editor_fragment_container, editorInfoFragment).commit();

    }

=======
        editorInfo = bundle.getParcelable("EditorInfo");
        EditorInfoFragment editorInfoFragment = new EditorInfoFragment();
        editorInfoFragment.setData(editorInfo);
        getSupportFragmentManager().beginTransaction().replace(R.id.edit_info_container, editorInfoFragment).commit();

    }


>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
