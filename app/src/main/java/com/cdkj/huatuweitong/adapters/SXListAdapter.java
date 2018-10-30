package com.cdkj.huatuweitong.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;

import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.bean.SXDetailsBean;
import com.cdkj.huatuweitong.databinding.ItemSxListActivityBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author qi
 * @updateDts 2018/5/22
 */

public class SXListAdapter extends BaseQuickAdapter<SXDetailsBean.DataBean.DishonestsBean, BaseViewHolder> {

    private ItemSxListActivityBinding mBinding;

    public SXListAdapter(@Nullable List<SXDetailsBean.DataBean.DishonestsBean> data) {
        super(R.layout.item_sx_list_activity, data);
        //因为数据不全暂时先展示这个
    }

    @Override
    protected void convert(BaseViewHolder helper, SXDetailsBean.DataBean.DishonestsBean item) {
        mBinding = DataBindingUtil.bind(helper.itemView);

        mBinding.rilAge.setTvRight(item.getAge());
        mBinding.rilCaseNo.setTvRight(item.getCaseNo());
        mBinding.rilCorpLegalPerson.setTvRight(item.getCorpLegalPerson());
        mBinding.rilExecuted.setTvRight(item.getExecuted());
        mBinding.rilExecutiveArm.setTvRight(item.getExecutiveArm());
        mBinding.rilExecutiveBaiscNo.setTvRight(item.getExecutiveBaiscNo());
        mBinding.rilExecutiveCase.setTvRight(item.getExecutiveCase());
        mBinding.rilExecutiveCourt.setTvRight(item.getExecutiveCourt());
        mBinding.rilFilingTime.setTvRight(item.getFilingTime());
        mBinding.rilIdentityNo.setTvRight(item.getIdentityNo());
        mBinding.rilLegalObligation.setTvRight(item.getLegalObligation());
        mBinding.rilName.setTvRight(item.getName());
        mBinding.rilNo.setTvRight(item.getNo());
        mBinding.rilProvince.setTvRight(item.getProvince());
        mBinding.rilReleaseTime.setTvRight(item.getReleaseTime());
        mBinding.rilSex.setTvRight(item.getSex());
        mBinding.rilSpecificSituation.setTvRight(item.getSpecificSituation());
        mBinding.rilUnExecuted.setTvRight(item.getUnExecuted());

    }
}
