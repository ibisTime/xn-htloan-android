package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import cn.jzvd.JzvdStd;
import com.cdkj.baselibrary.appmanager.MyCdConfig;
import com.cdkj.baselibrary.utils.DateUtil;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.MainResourceBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import static com.cdkj.baselibrary.utils.DateUtil.DEFAULT_DATE_FMT;

/**
 * @author : qianLei
 * @since : 2019/11/5 21:52
 */
public class CarVideoAdapter extends BaseQuickAdapter<MainResourceBean.ListBean, BaseViewHolder> {

    public CarVideoAdapter(@Nullable List<MainResourceBean.ListBean> data) {
        super(R.layout.item_car_video, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainResourceBean.ListBean item) {

        JzvdStd jzVideo = helper.getView(R.id.jz_video);

        jzVideo.setTag(item.getCode());
        jzVideo.setUp(MyCdConfig.QINIUURL + item.getUrl(), item.getName());
        jzVideo.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ImgUtils.loadQiniuImg(mContext, MyCdConfig.QINIUURL + item.getThumbnail(),
                jzVideo.thumbImageView);

        helper.setText(R.id.tv_time, DateUtil.formatStringData(item.getPushDatetime(),
                DEFAULT_DATE_FMT));
        helper.setText(R.id.tv_time, item.getVisitNumber() + "次播放");

    }
}
