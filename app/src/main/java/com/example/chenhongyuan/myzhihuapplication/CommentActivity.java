package com.example.chenhongyuan.myzhihuapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.chenhongyuan.Adapter.ExpandableAdapter;
import com.example.chenhongyuan.Module.AllService;
import com.example.chenhongyuan.Module.Comment;
import com.example.chenhongyuan.Module.Comments;
import com.example.chenhongyuan.Module.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import retrofit.RestAdapter;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by chenhongyuan on 15/7/20.
 */
public class CommentActivity extends ActionBarActivity{
    @Bind(R.id.lv_comment) ExpandableListView expandableListView;
    @Bind(R.id.comment_toolbar) Toolbar commentToolbar;
    int commentNum, longCommentNum, shortCommentNum, newsId;
    ExpandableAdapter expandableAdapter;
    RetrofitService service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);

        setSupportActionBar(commentToolbar);
        commentToolbar.setNavigationIcon(R.mipmap.ic_back);
        commentNum = getIntent().getIntExtra("commentNum", 0);
        longCommentNum = getIntent().getIntExtra("longCommentNum", 0);
        shortCommentNum = getIntent().getIntExtra("shortCommentNum", 0);
        newsId = getIntent().getIntExtra("newsId", 0);
        setTitle(commentNum + "条点评");
        commentToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        commentToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        loadData();
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                CharSequence[] selectList = {"赞同", "举报", "复制", "回复"};
                AlertDialog.Builder builder = new AlertDialog.Builder(CommentActivity.this);
                builder.setItems(selectList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO NOTHING
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });
    }

    public void loadData() {
        Observable.zip(service.retrofit().shortComment(newsId), service.retrofit().longComment(newsId), new Func2<Comments, Comments, List<Comments>>() {
            @Override
            public List<Comments> call(Comments comments, Comments comments2) {
                List<Comments> list = new ArrayList<Comments>();
                list.add(comments);
                list.add(comments2);
                return list;
            }
        }).observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Observer<List<Comments>>() {
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                Log.i("log", e.getMessage());
            }

            @Override
            public void onNext(List<Comments> commentses) {
                List<String> titleList = new ArrayList<String>();
                titleList.add(longCommentNum + "条长评");
                titleList.add(shortCommentNum + "条短评");
                List<List<Comment>> childData = new ArrayList<List<Comment>>();
                childData.add(commentses.get(1).comments);
                childData.add(commentses.get(0).comments);

                expandableAdapter = new ExpandableAdapter();
                expandableAdapter.setData(childData, titleList, CommentActivity.this);
                expandableListView.setAdapter(expandableAdapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.comment_menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
