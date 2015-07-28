package com.example.chenhongyuan.myzhihuapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
<<<<<<< HEAD
=======
import android.os.PersistableBundle;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5

/**
 * Created by chenhongyuan on 15/7/21.
 */
public class IndexActivity extends Activity {
<<<<<<< HEAD

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
=======
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_layout);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(IndexActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);


    }
}
