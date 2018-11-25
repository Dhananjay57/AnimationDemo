package com.example.drizzle.grappus_assignment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class FinalChartActivity extends AppCompatActivity {
    private View viewOne, viewTwo,viewThree, viewFour, viewFive;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_chart);
        viewOne = findViewById(R.id.view_one);
        viewTwo = findViewById(R.id.view_two);
        viewThree = findViewById(R.id.view_three);
        viewFour = findViewById(R.id.view_four);
        viewFive = findViewById(R.id.view_five);
       viewAnimation();

    }

    private void viewAnimation() {
        final Animation slide_up = AnimationUtils.loadAnimation(this, R.anim.slide_up_animation);
        final Animation slide_down = AnimationUtils.loadAnimation(this,R.anim.slide_down_animation);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                viewOne.startAnimation(slide_up);
                viewTwo.startAnimation(slide_up);
                viewThree.startAnimation(slide_up);
                viewFour.startAnimation(slide_up);
                viewFive.startAnimation(slide_up);
            }
        }, 500);
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                viewOne.startAnimation(slide_down);
                viewTwo.startAnimation(slide_down);
                viewThree.startAnimation(slide_down);
                viewFour.startAnimation(slide_down);
                viewFive.startAnimation(slide_down);
            }
        }, 700);
    }
}
