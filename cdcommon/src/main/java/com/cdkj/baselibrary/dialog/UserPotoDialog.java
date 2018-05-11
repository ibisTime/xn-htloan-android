package com.cdkj.baselibrary.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @author 齐胜涛
 * @des ${TODO}
 * @updateDts 2018/5/11
 * Created by lenovo on 2018/5/11.
 */

public class UserPotoDialog extends Dialog {

    public UserPotoDialog(@NonNull Context context) {
        super(context);
    }

    public UserPotoDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected UserPotoDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreatePanelView(int featureId) {
//        setContentView();
        return super.onCreatePanelView(featureId);

    }
}
