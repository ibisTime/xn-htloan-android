package com.cdkj.huatuweitong.module.reimbursement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cdkj.baselibrary.base.AbsBaseLoadActivity;
import com.cdkj.huatuweitong.module.mfirst_page.CarDetailsActivity;

public class CarLoanDetailsActivity extends AbsBaseLoadActivity {

    public static void open(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, CarDetailsActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public View addMainView() {
        return null;
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {

    }
}
