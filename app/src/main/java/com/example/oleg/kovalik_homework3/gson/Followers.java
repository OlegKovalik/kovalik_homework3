package com.example.oleg.kovalik_homework3.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleg on 07.01.2017.
 */
public class Followers {
    private int media;
    @SerializedName("followed_by")
    private int followedBy;
    private int follows;

    public Followers() {
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public int getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(int followedBy) {
        this.followedBy = followedBy;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    @Override
    public String toString() {
        return "Followers{" +
                "media=" + media +
                ", followedBy=" + followedBy +
                ", follows=" + follows +
                '}';
    }
}
