package com.example.braintrainer.ui.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.braintrainer.R;
import com.example.braintrainer.databinding.ActivityMainBinding;
import com.example.braintrainer.ui.EasyActivity;
import com.example.braintrainer.ui.HardActivity;
import com.example.braintrainer.ui.MediumActivity;

public class MainActivity extends AppCompatActivity {

    LevelViewModel levelViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        levelViewModel = ViewModelProviders.of(this).get(LevelViewModel.class);
        binding.setViewModel(levelViewModel);
        binding.setLifecycleOwner(this);

        binding.easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EasyActivity.class)
                        .putExtra("game", "easy"));
            }
        });

        binding.mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MediumActivity.class)
                        .putExtra("game", "medium"));
            }
        });

        binding.hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HardActivity.class)
                        .putExtra("game", "hard"));
            }
        });

    }
}