package com.manekineko.retrofit_test;

public class Info {
    public int type;
    public int postId;
    public int id;
    public String title;
    public String body;
    public static final int TYPE1=0;
    public static final int TYPE2=2;
    public Info(int type, Data data) {
        this.type = type;
        this.postId = data.getUserId();
        this.id = data.getId();
        this.title = data.getTitle();
        this.body = data.getBody();
    }
}
