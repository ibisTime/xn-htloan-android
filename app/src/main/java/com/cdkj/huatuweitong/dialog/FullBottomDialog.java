package com.cdkj.huatuweitong.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.cdkj.huatuweitong.R;


/**
 * 横向全屏的  底部弹出的  dialog
 */

public class FullBottomDialog extends Dialog {
    View mview = null;

    public FullBottomDialog(@NonNull Context context, View itemView) {
        super(context, R.style.FullBottomDialog);
        mview = itemView;
        setContentView(itemView);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);

        Activity ssss = (Activity) context;
        WindowManager m = ssss.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        //        p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的x
        p.width = (int) (d.getWidth() * 1.0); // 宽度设置为屏幕的x
        window.setAttributes(p);
        window.setGravity(Gravity.BOTTOM);//设置弹窗的位置
    }

    public View getChildView(int ids) {
        if (mview != null) {
            View view = mview.findViewById(ids);
            return view;
        }

        return null;
    }

}
