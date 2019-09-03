package com.cdkj.huatuweitong.xinge;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.cdkj.huatuweitong.bean.XGCustomBean;
import com.cdkj.huatuweitong.common.WebViewActivity2;
import com.cdkj.huatuweitong.common.WebViewArticleActivity;
import com.cdkj.huatuweitong.module.vehicle_db.CarDetailsActivity;

/**
 * @author : qianLei
 * @since : 2019/9/2 18:25
 */
public class XinGeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        if (uri != null) {
            String p1 = uri.getQueryParameter("key1");
            String p2 = uri.getQueryParameter("key2");

            if (!TextUtils.isEmpty(p1) && !TextUtils.isEmpty(p2)) {
                switch (p1) {

                    case "1":
                    case "3":
                        WebViewActivity2.open(this, p2);
                        break;

                    case "2":
                        WebViewArticleActivity.open(this, p2);
                        break;

                    case "4":
                        CarDetailsActivity.open(this, p2);
                        break;

                }

                finish();
            }


        }
    }
}
