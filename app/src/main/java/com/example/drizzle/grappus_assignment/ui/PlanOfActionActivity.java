package com.example.drizzle.grappus_assignment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bluehomestudio.animationplus.animation.HeightAnimation;
import com.example.drizzle.grappus_assignment.R;

public class PlanOfActionActivity extends AppCompatActivity{
    LinearLayout wingging_it;
    TextView tvBringingIt, tvSubText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_of_action);
        wingging_it = findViewById(R.id.layout_wining);
        tvBringingIt = findViewById(R.id.tv_bringing_it);
        tvSubText = findViewById(R.id.tv_sub_text);
        viewAnimation();


    }

    private void viewAnimation() {
        HeightAnimation heightAnimation = new HeightAnimation(wingging_it , 50 , 450);
        heightAnimation.setDuration(1000);
        wingging_it.setAlpha(.2f);
        wingging_it.startAnimation(heightAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HeightAnimation heightAnimation = new HeightAnimation(wingging_it , 450 , 750);
                heightAnimation.setDuration(1000);
                wingging_it.setAlpha(.2f);
                wingging_it.startAnimation(heightAnimation);


            }
        }, 1300);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HeightAnimation heightAnimation = new HeightAnimation(wingging_it , 750 , 450);
                heightAnimation.setDuration(1200);
                wingging_it.setAlpha(.2f);
                wingging_it.startAnimation(heightAnimation);


            }
        }, 2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HeightAnimation heightAnimation = new HeightAnimation(wingging_it , 450 , 150);
                heightAnimation.setDuration(1400);
                wingging_it.setAlpha(.2f);
                wingging_it.startAnimation(heightAnimation);


            }
        }, 2500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HeightAnimation heightAnimation = new HeightAnimation(wingging_it , 150 , 50);
                heightAnimation.setDuration(2400);
                wingging_it.setAlpha(.2f);
                wingging_it.startAnimation(heightAnimation);


            }
        }, 3000);


        wingging_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanOfActionActivity.this, FinalChartActivity.class);
                startActivity(intent);
            }
        });
    }

}
