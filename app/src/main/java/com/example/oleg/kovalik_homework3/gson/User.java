package com.example.oleg.kovalik_homework3.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleg on 07.01.2017.
 */
public class User {
    @SerializedName("username")
    private String userName;
    private String bio;
    private String website;
    @SerializedName("profile_picture")
    private String profilePicture;
    @SerializedName("full_name")
    private String fullName;
    private Followers counts;
    private String id;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Followers getCounts() {
        return counts;
    }

    public void setCounts(Followers counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", bio='" + bio + '\'' +
                ", website='" + website + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", fullName='" + fullName + '\'' +
                ", counts=" + counts +
                ", id='" + id + '\'' +
                '}';
    }
}
