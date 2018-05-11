package com.cdkj.baselibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cdkj.baselibrary.R;

/**
 * 图片加载工具类
 * Created by Administrator on 2016-09-14.
 */
public class ImgUtils {


    public static void loadImg(Object obj, Object imgid, ImageView img) {

        LogUtil.E("图片" + imgid);


        if (obj instanceof Context) {
            try {
                GlideApp.with((Context) obj).load(imgid).placeholder(R.drawable.default_pic).error(R.drawable.default_pic).into(img);
            } catch (Exception e) {
                LogUtil.E("图片加载错误");
            }
        } else if (obj instanceof Activity) {

            if (!AppUtils.isActivityExist((Activity) obj)) {

                LogUtil.E("图片加载界面销毁");
                return;
            }
            if (obj == null || img == null) {
                return;
            }
            try {
                GlideApp.with((Activity) obj).load(imgid).placeholder(R.drawable.default_pic).error(R.drawable.default_pic).into(img);
            } catch (Exception e) {
                LogUtil.E("图片加载错误");
            }

        } else if (obj instanceof Fragment) {
            try {
                GlideApp.with((Fragment) obj).load(imgid).placeholder(R.drawable.default_pic).error(R.drawable.default_pic).into(img);
            } catch (Exception e) {
                LogUtil.E("图片加载错误");
            }
        }
    }

    public static void loadImgNoPlaceholder(Object obj, Object imgid, ImageView img) {

        if (obj instanceof Activity) {

            if (!AppUtils.isActivityExist((Activity) obj)) {

                LogUtil.E("图片加载界面销毁");
                return;
            }
            if (obj == null || img == null) {
                return;
            }
            try {
                GlideApp.with((Activity) obj).load(imgid).error(R.drawable.default_pic).into(img);
            } catch (Exception e) {
                LogUtil.E("图片加载错误");
            }

        } else if (obj instanceof Fragment) {
            try {
                GlideApp.with((Fragment) obj).load(imgid).error(R.drawable.default_pic).into(img);
            } catch (Exception e) {
                LogUtil.E("图片加载错误");
            }
        } else if (obj instanceof Context) {
            try {
                GlideApp.with((Context) obj).load(imgid).error(R.drawable.default_pic).into(img);
            } catch (Exception e) {
                LogUtil.E("图片加载错误");
            }
        }
    }


    public static void loadLogo(Object obj, Object imgid, ImageView img) {


        if (obj instanceof Activity) {

            if (!AppUtils.isActivityExist((Activity) obj)) {

                LogUtil.E("图片加载界面销毁");
                return;
            }
            if (obj == null || img == null) {
                return;
            }
            try {
                GlideApp.with((Activity) obj).load(imgid).placeholder(R.drawable.photo_default).error(R.drawable.photo_default).transform(new CircleCrop()).into(img);
            } catch (Exception e) {
                LogUtil.E("图片加载错误");
            }

        } else if (obj instanceof Fragment) {
            try {
                GlideApp.with((Fragment) obj).load(imgid).placeholder(R.drawable.photo_default).error(R.drawable.photo_default).transform(new CircleCrop()).into(img);
            } catch (Exception e) {
                LogUtil.E("图片加载错误");
            }
        } else if (obj instanceof Context) {
            try {
                GlideApp.with((Context) obj).load(imgid).placeholder(R.drawable.photo_default).error(R.drawable.photo_default).transform(new RoundedCorners(15)).into(img);
            } catch (Exception e) {
                LogUtil.E("图片加载错误");
            }
        }
    }


    public static void loadBankBg(Context context, int imgid, ImageView img) {

        if (context == null || img == null) {
            return;
        }
        try {
            GlideApp.with(context).load(imgid).placeholder(R.drawable.back_default).error(R.drawable.back_default).into(img);
        } catch (Exception e) {

        }

    }

    public static void loadBankLogo(Context context, int imgid, ImageView img) {

        if (context == null || img == null || imgid == 0) {
            return;
        }
        try {
            GlideApp.with(context).load(imgid).placeholder(R.drawable.back_logo_defalut).error(R.drawable.back_logo_defalut).into(img);
        } catch (Exception e) {

        }

    }

    /**
     * 用于判断链接是否添加了七牛
     *
     * @param url
     * @return
     */
    public static boolean isHaveHttp(String url) {
        if (TextUtils.isEmpty(url)) return false;
        return url.indexOf("http:") != -1 || url.indexOf("https:") != -1;
    }


}
