package com.cdkj.baselibrary.adapters;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.cdkj.baselibrary.R;
import com.cdkj.baselibrary.model.AddressModel;
import com.cdkj.baselibrary.model.BankCardModel;
import com.cdkj.baselibrary.model.MyBankCardListMode;
import com.cdkj.baselibrary.utils.ImgUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * 银行卡列表适配器
 * Created by cdkj on 2017/10/12.
 */

public class BankCardListAdapter extends BaseQuickAdapter<BankCardModel, BaseViewHolder> {

    public BankCardListAdapter(@Nullable List<BankCardModel> data) {
        super(R.layout.item_my_bank_card, data);
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, BankCardModel bankCardModel) {
        if (bankCardModel == null) return;

        viewHolder.setText(R.id.txt_name, bankCardModel.getBankName());
        if (!TextUtils.isEmpty(bankCardModel.getBankcardNumber()) && bankCardModel.getBankcardNumber().length() > 5) {
            viewHolder.setText(R.id.txt_number, bankCardModel.getBankcardNumber().substring(bankCardModel.getBankcardNumber().length() - 4, bankCardModel.getBankcardNumber().length()));
        } else {
            viewHolder.setText(R.id.txt_number, bankCardModel.getBankcardNumber());
        }

        if (!TextUtils.isEmpty(bankCardModel.getBankCode())) {
            int logoId = mContext.getResources().getIdentifier("logo_" + bankCardModel.getBankCode().toLowerCase(), "mipmap", mContext.getPackageName());
            int backId = mContext.getResources().getIdentifier("back_" + bankCardModel.getBankCode().toLowerCase(), "mipmap", mContext.getPackageName());

            ImgUtils.loadBankLogo(mContext, logoId, viewHolder.getView(R.id.img_bankCart));
            ImgUtils.loadBankBg(mContext, backId, viewHolder.getView(R.id.img_back_bg));
        }

    }

}
