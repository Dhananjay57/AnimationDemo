package com.example.drizzle.grappus_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class PlanOfActionActivity extends AppCompatActivity{
    LinearLayout wingging_it;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_of_action);
        wingging_it = findViewById(R.id.layout_wining);
        final Animation slide_up = AnimationUtils.loadAnimation(this, R.anim.slide_up_animation);
        final Animation slide_down = AnimationUtils.loadAnimation(this,R.anim.slide_down_animation);
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                wingging_it.startAnimation(slide_up);
            }
        }, 500);
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                wingging_it.startAnimation(slide_down);
            }
        }, 700);

        wingging_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanOfActionActivity.this, FinalChartActivity.class);
                startActivity(intent);
            }
        });


    }

}
