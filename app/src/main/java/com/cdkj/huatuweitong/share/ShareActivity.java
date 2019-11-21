package com.cdkj.huatuweitong.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.cdkj.baselibrary.appmanager.SPUtilHelper;
import com.cdkj.baselibrary.dialog.UITipDialog;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.baselibrary.utils.LogUtil;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.ActivityShareBinding;
import com.cdkj.huatuweitong.utlis.WxUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;


/**
 * 分享界面
 * Created by cdkj on 2017/8/1.
 */

public class ShareActivity extends Activity {

    private ActivityShareBinding mbinding;

    private String mShareUrl;//需要分享的URL

    private String mTitle;//title
    private String mContent;//content

    private UITipDialog tipDialog;


    /**
     * 打开当前页面
     *
     * @param context
     */
    public static void open(Context context, String shareUrl, String title, String content) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, ShareActivity.class);
        intent.putExtra("shareUrl", shareUrl);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_share);

        if (getIntent() != null) {
            mShareUrl = getIntent().getStringExtra("shareUrl");
            mTitle = getIntent().getStringExtra("title");
            mContent = getIntent().getStringExtra("content");
        }
        initListener();
    }


    /**
     * 初始化事件
     */
    private void initListener() {

        mbinding.txtCancel.setOnClickListener(v -> {
            finish();
        });

        mbinding.linShareToPyq.setOnClickListener(v -> {
            WxUtil.shareToPYQ(ShareActivity.this, mShareUrl,
                    mTitle, mContent);
            finish();
        });

        mbinding.linShareToWx.setOnClickListener(v -> {
            WxUtil.shareToWX(ShareActivity.this, mShareUrl,
                    mTitle, mContent);
            finish();
        });

    }


}
