package com.example.zy1584.myzhihudaily.ui.newsDetail;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseActivity;
import com.example.zy1584.myzhihudaily.ui.login.LoginActivity;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.OtherStoriesPresenter;
import com.example.zy1584.myzhihudaily.utils.GlobalParams;
import com.example.zy1584.myzhihudaily.utils.MyUtils;
import com.example.zy1584.myzhihudaily.utils.SPUtils;
import com.example.zy1584.myzhihudaily.utils.WebUtil;

import butterknife.BindView;

import static com.example.zy1584.myzhihudaily.R.id.image_source;

public class OtherStoryContentActivity extends BaseActivity<OtherStoryContentPresenter> implements StoryContentContract.View {

    @BindView(R.id.webView)WebView webView;
    @BindView(R.id.toolbar)Toolbar toolbar;

    private int id;
    private int commentNum;
    private int longCommentNum;
    private int shortCommentNum;
    private int likeNum;
    private TextView tv_comment;
    private TextView tv_like;
    private ImageView iv_like;
    private StoryContentBean mData;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_other_story_content;
    }

    @Override
    protected OtherStoryContentPresenter loadPresenter() {
        return new OtherStoryContentPresenter();
    }

    @Override
    protected void handleIntent(Intent intent) {
        super.handleIntent(intent);
        id = intent.getIntExtra(GlobalParams.STORY_ID, 0);
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(toolbar,false,true);
        initWebView(webView);
    }

    @Override
    protected void doBusiness() {
        super.doBusiness();
        if (id != 0){
            mPresenter.getStoryContent(id);
            mPresenter.getStoryContentExtra(id);
        }
    }

    @Override
    public void getStoryContent(StoryContentBean bean) {
        mData = bean;
        boolean night_mode = (boolean) SPUtils.get(GlobalParams.NIGHT_MODE, false);
        String data = WebUtil.buildHtmlWithCss(bean.getBody(), bean.getCss(), night_mode);
        webView.loadData(data, WebUtil.MIME_TYPE, WebUtil.ENCODING);
    }

    @Override
    public void getStoryContentExtra(StoryContentExtraBean bean) {
        commentNum = bean.getComments();
        shortCommentNum = bean.getShort_comments();
        longCommentNum = bean.getLong_comments();
        likeNum = bean.getPopularity();
        boolean isLike = (boolean) SPUtils.get(Integer.toString(id), false);
        if (isLike){
            tv_like.setText(Integer.toString(++likeNum));
            iv_like.setImageResource(R.drawable.ic_thumb_up_orange);
        }else{
            tv_like.setText(Integer.toString(likeNum));
            iv_like.setImageResource(R.drawable.ic_thumb_up);
        }
        tv_comment.setText(Integer.toString(commentNum));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_story_content, menu);
        initMenu(menu, R.id.menu_comment, R.drawable.ic_comment);
        initMenu(menu, R.id.menu_like, R.drawable.ic_thumb_up);
        return true;
    }

    private void initMenu(Menu menu, int menuId, int imgId){
        MenuItem item = menu.findItem(menuId);
        item.setActionView(R.layout.action_item);
        View actionView = item.getActionView();
        actionView.setOnClickListener(this);
        ImageView imageView = (ImageView) actionView.findViewById(R.id.action_item_image);
        imageView.setImageResource(imgId);
        if (menuId == R.id.menu_comment){
            tv_comment = (TextView) actionView.findViewById(R.id.action_item_text);
        }else if (menuId == R.id.menu_like){
            tv_like = (TextView) actionView.findViewById(R.id.action_item_text);
            iv_like = imageView;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_share:
                MyUtils.shareToOther(this, mData.getShare_url());
                break;
            case R.id.menu_collect:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.menu_comment:

                break;
            case R.id.menu_like:
                pressThumbUp();
                break;
        }
    }

    private void pressThumbUp() {
        boolean isLike = (boolean) SPUtils.get(Integer.toString(id), false);
        if (isLike){
            tv_like.setText(Integer.toString(--likeNum));
            iv_like.setImageResource(R.drawable.ic_thumb_up);
        }else{
            tv_like.setText(Integer.toString(++likeNum));
            iv_like.setImageResource(R.drawable.ic_thumb_up_orange);
        }
        SPUtils.put(Integer.toString(id),!isLike);
    }
}
