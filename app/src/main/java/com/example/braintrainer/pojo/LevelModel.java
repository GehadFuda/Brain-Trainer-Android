package com.example.braintrainer.pojo;

public class LevelModel {
    private String easy, medium, hard;

    public LevelModel(String easy, String medium, String hard) {
        this.easy = easy;
        this.medium = medium;
        this.hard = hard;
    }

    public String getEasy() {
        return easy;
    }

    public String getMedium() {
        return medium;
    }

    public String getHard() {
        return hard;
    }
}
