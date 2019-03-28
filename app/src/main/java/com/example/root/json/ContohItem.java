package com.example.root.json;

public class ContohItem {
    private String mImageUrl;
    private String mCreator;
    private int mLikes;

    public ContohItem(String imageUrl, String creator, int likes) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mLikes = likes;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCreator() {
        return mCreator;
    }

    public int getmLikes() {
        return mLikes;
    }
}
