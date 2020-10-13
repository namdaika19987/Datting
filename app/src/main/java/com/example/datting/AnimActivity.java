package com.example.datting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class AnimActivity extends AppCompatActivity {

    private static final long RUN_TIME = 4000;
    Animation topAnim, botAnim;
    LinearLayout layout1, layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full màn hình khi khởi động app
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_begin);

        animation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AnimActivity.this,  MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, RUN_TIME);
    }

    private void animation(){
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bot_animation);

        layout1 = findViewById(R.id.layout1);
        layout1.setAnimation(topAnim);

        layout2 = findViewById(R.id.layout2);
        layout2.setAnimation(botAnim);
    }
}