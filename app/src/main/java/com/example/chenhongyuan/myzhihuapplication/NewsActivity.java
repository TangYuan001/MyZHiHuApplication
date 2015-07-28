package com.example.chenhongyuan.myzhihuapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenhongyuan.Fragment.IndexFragment;
import com.example.chenhongyuan.Fragment.IndexNewsFragment;
import com.example.chenhongyuan.Fragment.SubThemeFragment;
import com.example.chenhongyuan.Fragment.SubThemeNewsFragment;
import com.example.chenhongyuan.Module.AdditionInfo;
import com.example.chenhongyuan.Module.AllService;
import com.example.chenhongyuan.Module.RetrofitService;
import com.example.chenhongyuan.Module.Story;
import com.example.chenhongyuan.Module.StoryBody;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.SinaSsoHandler;
import com.umeng.socialize.sso.TencentWBSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.sso.UMSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.RestAdapter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chenhongyuan on 15/7/17.
 */
public class NewsActivity extends ActionBarActivity {
    @Bind(R.id.news_toolbar) Toolbar newsToolbar;
    @Bind(R.id.image_comment) ImageView commentImage;
    @Bind(R.id.image_likes) ImageView likesImage;
    @Bind(R.id.image_share) ImageView shareImage;
    @Bind(R.id.tv_like_num) TextView likesNumView;
    @Bind(R.id.tv_comment_num) TextView commentNumView;

    int newsId;
    int commentsNum, longCommentNum, shortCommentNum;
    int likesNum, initLikesNum;
    static int clickNum = 0;
    RetrofitService service;
    String appID = "wx967daebe835fbeac";
    String appSecret = "5fa9e68ca3970e87a1f83e563c8dcbce";
    final UMSocialService mController = UMServiceFactory.getUMSocialService("com.umeng.ic_share");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        // 设置分享内容
        mController.setShareContent("友盟社会化组件（SDK）让移动应用快速整合社交分享功能，http://www.umeng.com/social");
        // 设置分享图片, 参数2为图片的url地址
        mController.setShareMedia(new UMImage(this,
                "http://www.umeng.com/images/pic/banner_module_social.png"));

        setSupportActionBar(newsToolbar);
        setTitle("");
        newsToolbar.setNavigationIcon(R.mipmap.ic_back);
        newsToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Bundle bundle;

        if(getIntent().getBundleExtra(IndexFragment.KEY_VALUE) == null) {
            bundle = getIntent().getBundleExtra(SubThemeFragment.KEY_VALUE);
            newsId = getIntent().getIntExtra(SubThemeFragment.KEY_NEWS, 0);
            StoryBody storyBody = bundle.getParcelable(SubThemeFragment.KEY_BODY);
            SubThemeNewsFragment newsFragment = new SubThemeNewsFragment();
            newsFragment.setData(storyBody);
            getSupportFragmentManager().beginTransaction().replace(R.id.news_container, newsFragment).commit();
        } else {
            bundle = getIntent().getBundleExtra(IndexFragment.KEY_VALUE);
            newsId = getIntent().getIntExtra(IndexFragment.KEY_NEWS, 0);
            Story story = bundle.getParcelable(IndexFragment.KEY_STORY);
            StoryBody storyBody = bundle.getParcelable(IndexFragment.KEY_BODY);
            IndexNewsFragment newsFragment = new IndexNewsFragment();
            newsFragment.setData(story, storyBody);
            getSupportFragmentManager().beginTransaction().replace(R.id.news_container, newsFragment).commit();
        }
        ServiceInfo();
    }

    public void ServiceInfo() {
        service.retrofit().addtionInfo(newsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AdditionInfo>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(AdditionInfo additionInfo) {
                        likesNum = additionInfo.popularity;
                        likesNumView.setText(""+likesNum);
                        initLikesNum = additionInfo.popularity;
                        commentsNum = additionInfo.comments;
                        commentNumView.setText(""+(commentsNum));
                        longCommentNum = additionInfo.long_comments;
                        shortCommentNum = additionInfo.short_comments;
                    }
                });
    }

    @OnClick(R.id.image_likes)
    public void OnLikesClick(ImageView imageView){
        clickNum = clickNum + 1;
        if (clickNum % 2 == 1) {
            likesNum++;
            likesNumView.setText("" + likesNum);
            Toast.makeText(NewsActivity.this, "+1", Toast.LENGTH_LONG).show();
        } else {
            likesNum--;
            likesNumView.setText("" + likesNum);
            Toast.makeText(NewsActivity.this, "-1", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.image_comment)
    public void OnCommentClick(ImageView imageView) {
        Intent intent = new Intent();
        intent.setClass(NewsActivity.this, CommentActivity.class);
        intent.putExtra("commentNum",commentsNum);
        intent.putExtra("newsId", newsId);
        intent.putExtra("longCommentNum", longCommentNum);
        intent.putExtra("shortCommentNum", shortCommentNum);
        startActivity(intent);
    }

    @OnClick(R.id.image_share)
    public void OnShareClick(ImageView imageView) {
        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(NewsActivity.this, "100424468",
                "c7394704798a158208a74ab60104f0ba");
        qZoneSsoHandler.addToSocialSDK();
        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(NewsActivity.this, "100424468",
                "c7394704798a158208a74ab60104f0ba");
        qqSsoHandler.addToSocialSDK();

        UMWXHandler wxHandler = new UMWXHandler(NewsActivity.this, "wx967daebe835fbeac", appSecret);
        wxHandler.addToSocialSDK();

        UMWXHandler wxCircleHandler = new UMWXHandler(NewsActivity.this, "wx967daebe835fbeac" ,appSecret);
        wxCircleHandler.setToCircle(true);
        wxCircleHandler.addToSocialSDK();

        mController.getConfig().setSsoHandler(new TencentWBSsoHandler());
        mController.getConfig().setSsoHandler(new SinaSsoHandler());
        mController.openShare(NewsActivity.this, false);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**使用SSO授权必须添加如下代码 */
        UMSsoHandler ssoHandler = mController.getConfig().getSsoHandler(requestCode) ;
        if(ssoHandler != null){
            ssoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
