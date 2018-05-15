package com.cdkj.huatuweitong.module.main_tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdkj.baselibrary.base.BaseLazyFragment;
import com.cdkj.huatuweitong.R;
import com.cdkj.huatuweitong.databinding.FragmentUserBinding;
import com.cdkj.huatuweitong.module.user.UserInfoUpdateActivity;

/**
 * Created by cdkj on 2018/5/1.
 */

public class UserFragment extends BaseLazyFragment implements View.OnClickListener {

    private FragmentUserBinding mBinding;

    public static UserFragment getInstance() {
        UserFragment fragment = new UserFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, null, false);
        mBinding.imgUserLogo.setOnClickListener(this);

        return mBinding.getRoot();
    }

    @Override
    protected void lazyLoad() {
        setUsetPotoImg();
    }

    private void setUsetPotoImg() {

        showPotoDialog();
    }

    private void showPotoDialog() {


    }

    @Override
    protected void onInvisible() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_user_logo:

                UserInfoUpdateActivity.open(getContext());

//                AlertDialog dialog = new AlertDialog.Builder(getActivity())
//                        .create();
//                View view = View.inflate(getActivity(), R.layout.user_poto_dialog_item, null);
//                dialog.setView(view);
//                dialog.show();
//
//                view.findViewById(R.id.tv_camera).setOnClickListener((a)->{
//                    CameraHelper cameraHelper = new CameraHelper(getActivity(),new CameraPhotoListener(){
//                        @Override
//                        public void onPhotoSuccessful(int requestCode, String path) {
//                            Log.i("ppppp", "onPhotoSuccessful: "+requestCode+path);
//                        }
//
//                        @Override
//                        public void onPhotoFailure(int requestCode, String msg) {
//
//                        }
//
//                        @Override
//                        public void noPermissions(int requestCode) {
//
//                        }
//                    });
//                    cameraHelper.startCamera();
//                });
//
//                view.findViewById(R.id.tv_img).setOnClickListener((a) -> {
//
//                });

                break;
        }
    }
}
