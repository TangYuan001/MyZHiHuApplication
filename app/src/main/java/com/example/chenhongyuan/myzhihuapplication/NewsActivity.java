package com.example.chenhongyuan.myzhihuapplication;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
=======
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import com.example.chenhongyuan.Fragment.IndexFragment;
import com.example.chenhongyuan.Fragment.IndexNewsFragment;
import com.example.chenhongyuan.Fragment.SubThemeFragment;
import com.example.chenhongyuan.Fragment.SubThemeNewsFragment;
import com.example.chenhongyuan.Module.AdditionInfo;
import com.example.chenhongyuan.Module.AllService;
import com.example.chenhongyuan.Module.RetrofitService;
import com.example.chenhongyuan.Module.Story;
import com.example.chenhongyuan.Module.StoryBody;
=======
import com.example.chenhongyuan.Fragment.MainFragment;
import com.example.chenhongyuan.Fragment.MainNewsFragment;
import com.example.chenhongyuan.Fragment.ThemeFragment;
import com.example.chenhongyuan.Fragment.ThemeNewsFragment;
import com.example.chenhongyuan.Module.AdditionInfo;
import com.example.chenhongyuan.Module.AllService;
import com.example.chenhongyuan.Module.Story;
import com.example.chenhongyuan.Module.StoryBody;
import com.umeng.socialize.bean.SHARE_MEDIA;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
<<<<<<< HEAD
=======
import com.umeng.socialize.sso.RenrenSsoHandler;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import com.umeng.socialize.sso.SinaSsoHandler;
import com.umeng.socialize.sso.TencentWBSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.sso.UMSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;

<<<<<<< HEAD
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
=======
import de.hdodenhof.circleimageview.CircleImageView;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
import retrofit.RestAdapter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chenhongyuan on 15/7/17.
 */
public class NewsActivity extends ActionBarActivity {
<<<<<<< HEAD
    @Bind(R.id.news_toolbar) Toolbar newsToolbar;
    @Bind(R.id.image_comment) ImageView commentImage;
    @Bind(R.id.image_likes) ImageView likesImage;
    @Bind(R.id.image_share) ImageView shareImage;
    @Bind(R.id.tv_like_num) TextView likesNumView;
    @Bind(R.id.tv_comment_num) TextView commentNumView;

=======
    Toolbar toolbar;
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
    int newsId;
    int commentsNum, longCommentNum, shortCommentNum;
    int likesNum, initLikesNum;
    static int clickNum = 0;
<<<<<<< HEAD
    RetrofitService service;
    String appID = "wx967daebe835fbeac";
    String appSecret = "5fa9e68ca3970e87a1f83e563c8dcbce";
    final UMSocialService mController = UMServiceFactory.getUMSocialService("com.umeng.ic_share");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
=======
    ImageView commentItem, likesItem, shareItem;
    TextView commentNumView, likesNumView;
    String appID = "wx967daebe835fbeac";
    String appSecret = "5fa9e68ca3970e87a1f83e563c8dcbce";
    final UMSocialService mController = UMServiceFactory.getUMSocialService("com.umeng.share");
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newslayout);
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
        // 设置分享内容
        mController.setShareContent("友盟社会化组件（SDK）让移动应用快速整合社交分享功能，http://www.umeng.com/social");
        // 设置分享图片, 参数2为图片的url地址
        mController.setShareMedia(new UMImage(this,
                "http://www.umeng.com/images/pic/banner_module_social.png"));
<<<<<<< HEAD

        setSupportActionBar(newsToolbar);
        setTitle("");
        newsToolbar.setNavigationIcon(R.mipmap.ic_back);
        newsToolbar.setNavigationOnClickListener(new View.OnClickListener() {
=======
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://news-at.zhihu.com")
                .build();
        AllService service = adapter.create(AllService.class);
        likesNumView = (TextView) findViewById(R.id.like_num);
        commentNumView = (TextView) findViewById(R.id.comment_num);
        likesItem = (ImageView)findViewById(R.id.likes_item);
        commentItem = (ImageView)findViewById(R.id.comment_item);
        shareItem = (ImageView)findViewById(R.id.share_item);
        toolbar = (Toolbar)findViewById(R.id.news_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Bundle bundle;
<<<<<<< HEAD

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
=======
        if(getIntent().getBundleExtra(MainFragment.KEY_VALUE) == null) {
            bundle = getIntent().getBundleExtra(ThemeFragment.KEY_VALUE);
            newsId = getIntent().getIntExtra(ThemeFragment.KEY_NEWS, 0);
            StoryBody storyBody = bundle.getParcelable(ThemeFragment.KEY_BODY);
            ThemeNewsFragment newsFragment = new ThemeNewsFragment();
            newsFragment.setData(storyBody);
            getSupportFragmentManager().beginTransaction().replace(R.id.news_container, newsFragment).commit();
        } else {
            bundle = getIntent().getBundleExtra(MainFragment.KEY_VALUE);
            newsId = getIntent().getIntExtra(MainFragment.KEY_NEWS, 0);
            Story story = bundle.getParcelable(MainFragment.KEY_STORY);
            StoryBody storyBody = bundle.getParcelable(MainFragment.KEY_BODY);
            MainNewsFragment newsFragment = new MainNewsFragment();
            newsFragment.setData(story, storyBody);
            getSupportFragmentManager().beginTransaction().replace(R.id.news_container, newsFragment).commit();
        }

        service.addtionInfo(newsId)
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
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
<<<<<<< HEAD
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

=======

        likesItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        commentItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(NewsActivity.this, CommentActivity.class);
                intent.putExtra("commentNum",commentsNum);
                intent.putExtra("newsId", newsId);
                intent.putExtra("longCommentNum", longCommentNum);
                intent.putExtra("shortCommentNum", shortCommentNum);
                startActivity(intent);
            }
        });
        shareItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                LayoutInflater inflater = LayoutInflater.from(NewsActivity.this);
//                View view = inflater.inflate(R.layout.share_layout, null);
//
//                Dialog shareDialog = new Dialog(NewsActivity.this);
//                shareDialog.setContentView(view);
//                shareDialog.setTitle("分享");
//                shareDialog.show();
//                CircleImageView smallBlogImage = (CircleImageView)view.findViewById(R.id.smallBlog);
//                smallBlogImage.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(NewsActivity.this, "微博", Toast.LENGTH_LONG).show();
//                    }
//                });
//                CircleImageView weChatImage = (CircleImageView)view.findViewById(R.id.weChat);
//                weChatImage.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(NewsActivity.this, "微信", Toast.LENGTH_LONG).show();
//                    }
//                });
//                CircleImageView friendImage = (CircleImageView)view.findViewById(R.id.frined);
//                friendImage.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(NewsActivity.this, "朋友圈", Toast.LENGTH_LONG).show();
//                    }
//                });
//                CircleImageView noteImage = (CircleImageView)view.findViewById(R.id.note);//evernote
//                noteImage.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(NewsActivity.this, "印象笔记", Toast.LENGTH_LONG).show();
//                    }
//                });
//                CircleImageView cloudNoteImage = (CircleImageView)view.findViewById(R.id.cloudNote);//Qzone
//                cloudNoteImage.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
////                        Toast.makeText(NewsActivity.this, "QQ空间", Toast.LENGTH_LONG).show();
//                        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(NewsActivity.this, "100424468",
//                        "c7394704798a158208a74ab60104f0ba");
//                        qZoneSsoHandler.addToSocialSDK();
//                        mController.openShare(NewsActivity.this, false);
//                    }
//                });
//                CircleImageView tencentImage = (CircleImageView)view.findViewById(R.id.tencent);//QQ
//                tencentImage.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(NewsActivity.this, "QQ", Toast.LENGTH_LONG).show();
//                    }
//                });
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
                //mController.getConfig().removePlatform( SHARE_MEDIA.RENREN, SHARE_MEDIA.DOUBAN);
                mController.openShare(NewsActivity.this, false);
            }
        });
>>>>>>> c32c71a5a5cd2a9cee1e37970d4ddf21a3d036d5
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
