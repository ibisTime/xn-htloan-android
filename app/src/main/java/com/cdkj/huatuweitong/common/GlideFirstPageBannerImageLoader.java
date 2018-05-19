package com.cdkj.huatuweitong.common;

import android.content.Context;
import android.widget.ImageView;

import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.bean.FirstPageBanner;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by cdkj on 2017/6/10.
 */

public class GlideFirstPageBannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        FirstPageBanner firstPageBanner = (FirstPageBanner) path;
        if (firstPageBanner == null) return;
        ImgUtils.loadQiniuImg(context, firstPageBanner.getPic(), imageView);
    }
}