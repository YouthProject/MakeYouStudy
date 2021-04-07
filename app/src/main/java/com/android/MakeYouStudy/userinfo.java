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
    }
    public userinfo(String profile) {
        this.profile = profile;
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
