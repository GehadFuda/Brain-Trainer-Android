package com.example.braintrainer.ui.mainactivity;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.braintrainer.pojo.Database;
import com.example.braintrainer.pojo.LevelModel;
import com.example.braintrainer.ui.EasyActivity;
import com.example.braintrainer.ui.HardActivity;
import com.example.braintrainer.ui.MediumActivity;

public class LevelViewModel extends ViewModel {

    public MutableLiveData<String> levelsMutableLiveData = new MutableLiveData<>();

    public void getEasy() {
        levelsMutableLiveData.setValue(getLevrlsFromDataBase().getEasy());
    }

    public void getMedium() {
        levelsMutableLiveData.setValue(getLevrlsFromDataBase().getMedium());
    }

    public void getHard() {
        levelsMutableLiveData.setValue(getLevrlsFromDataBase().getHard());
    }

    private LevelModel getLevrlsFromDataBase(){
        return new Database().getLevels();
    }

}
