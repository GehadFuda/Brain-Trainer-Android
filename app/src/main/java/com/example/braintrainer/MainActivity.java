package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button easyButton;
    Button mediumButton;
    Button hardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void easy(View view) {
        Intent i = new Intent(getApplicationContext(), EasyActivity.class);
        i.putExtra("game", "easy");
        startActivity(i);
    }

    public void medium(View view) {
        Intent i = new Intent(getApplicationContext(), MediumActivity.class);
        i.putExtra("game", "medium");
        startActivity(i);
    }

    public void hard(View view) {
        Intent i = new Intent(getApplicationContext(), HardActivity.class);
        i.putExtra("game", "hard");
        startActivity(i);
    }
}