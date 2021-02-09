package com.example.braintrainer.pojo;

public class Database {
    public LevelModel getLevels(){
        return new LevelModel("easy", "medium", "hard");
    }
}
