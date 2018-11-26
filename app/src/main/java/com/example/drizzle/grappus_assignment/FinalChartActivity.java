package com.example.drizzle.grappus_assignment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bluehomestudio.animationplus.animation.HeightAnimation;


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
        HeightAnimation heightAnimation = new HeightAnimation(viewOne , 0 , 150);
        heightAnimation.setDuration(1000);
        viewOne.startAnimation(heightAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HeightAnimation heightAnimation = new HeightAnimation(viewTwo , 0 , 250);
                heightAnimation.setDuration(1000);
                viewTwo.startAnimation(heightAnimation);


            }
        }, 1300);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HeightAnimation heightAnimation = new HeightAnimation(viewThree , 0 , 200);
                heightAnimation.setDuration(1000);
                viewThree.startAnimation(heightAnimation);


            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HeightAnimation heightAnimation = new HeightAnimation(viewFour , 0 , 350);
                heightAnimation.setDuration(1000);
                viewFour.startAnimation(heightAnimation);


            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HeightAnimation heightAnimation = new HeightAnimation(viewFive , 0 , 150);
                heightAnimation.setDuration(1000);
                viewFive.startAnimation(heightAnimation);


            }
        }, 1700);

    }
}
