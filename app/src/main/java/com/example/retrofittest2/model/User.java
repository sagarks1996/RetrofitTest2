package com.example.retrofittest2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("user1")
    @Expose
    private User1 user1;
    @SerializedName("user2")
    @Expose
    private User2 user2;
    @SerializedName("user3")
    @Expose
    private User3 user3;

    public User1 getUser1() {
        return user1;
    }

    public void setUser1(User1 user1) {
        this.user1 = user1;
    }

    public User2 getUser2() {
        return user2;
    }

    public void setUser2(User2 user2) {
        this.user2 = user2;
    }

    public User3 getUser3() {
        return user3;
    }

    public void setUser3(User3 user3) {
        this.user3 = user3;
    }

}
