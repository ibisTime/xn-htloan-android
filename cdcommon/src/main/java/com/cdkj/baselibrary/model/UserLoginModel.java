package com.cdkj.baselibrary.model;

/**
 * Created by cdkj on 2017/6/9.
 */

public class UserLoginModel {


    /**
     * token : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVMjAxODA1MTUxNTU3NDY4ODc4NDg1IiwiaXNzIjoiYWRtaW4iLCJhdWQiOiIiLCJpYXQiOjE1MjY3MjQxMjEsIm5iZiI6MTUyNjcyNDEyMSwiZXhwIjoxNTI3MzI4OTIxLCJqdGkiOiIifQ.vlp4-VbIws2Yqko4YOUpl8yOg67-os8gpgpdk2CyysSzeSP1sqcqhGmlkfkWt3a1o_q3ETewJlQuKOyLUQMarQ
     * userId : U201805151557468878485
     */

    private String token;
    private String userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
