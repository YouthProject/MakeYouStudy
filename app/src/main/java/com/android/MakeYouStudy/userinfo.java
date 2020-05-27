package com.android.MakeYouStudy;
public class userinfo {
    private String userName;

    private String profile;

    private String usercal;

    private String usertable;

    private String usercheck;

    private String userdiary;


    public userinfo(String userName, String profile) {

        this.userName = userName;

        this.profile = profile;

        this.usercal=usercal;

        this.usertable=usertable;

        this.usercheck=usercheck;

        this.userdiary=userdiary;

    }


    public String getUserName() {

        return userName;

    }


    public void setUserName(String userName) {

        this.userName = userName;

    }


    public String getProfile() {

        return profile;

    }


    public void setProfile(String profile) {

        this.profile = profile;

    }


}
