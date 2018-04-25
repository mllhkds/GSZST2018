package com.example.a13466.gsst.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a13466.gsst.R;

import java.util.Timer;
import java.util.TimerTask;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        SharedPreferences sp = this.getSharedPreferences("ToFirst", Context.MODE_PRIVATE);
        if (!sp.getBoolean("ToMain",true)){
            startActivity(new Intent(this,UserLoginActivity.class));
            finish();
            return;
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(GuideActivity.this,UserLoginActivity.class));
                finish();
            }
        },2000);
    }
}
