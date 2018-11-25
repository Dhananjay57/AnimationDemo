package com.example.drizzle.grappus_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;

public class MainActivity extends AppCompatActivity {
    private ImageView logo_iv;
    private TextView tv_head_text,tv_sub_heading_text,tv_term_cond;
    private Button btn_skip, btn_create_profile;
    LinearLayout bottom_layout;
    DotIndicator indicator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo_iv = findViewById(R.id.iv_logo);
        tv_head_text = findViewById(R.id.tv_head_text);
        tv_sub_heading_text = findViewById(R.id.tv_sub_heading_text);
        btn_skip = findViewById(R.id.btn_skip);
        btn_create_profile = findViewById(R.id.btn_create_profile);
        bottom_layout = findViewById(R.id.bottom_layout);
        indicator = findViewById(R.id.indicator);
        tv_term_cond = findViewById(R.id.tv_term_cond);
        tv_term_cond.setText(Html.fromHtml(String.format(getString(R.string.by_using_this_service_i_accept_athleteminder_s_term_of_service))));
        init();

    }

    private void init() {
      final  Animation shake_animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);

        Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        logo_iv.startAnimation(animZoomOut);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                tv_head_text.setVisibility(View.VISIBLE);
            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                tv_sub_heading_text.setVisibility(View.VISIBLE);
            }
        }, 1300);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                btn_create_profile.setVisibility(View.VISIBLE);
                btn_create_profile.startAnimation(shake_animation);
            }
        }, 1600);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                btn_skip.setVisibility(View.VISIBLE);
                btn_skip.startAnimation(shake_animation);
            }
        }, 1800);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                bottom_layout.setVisibility(View.VISIBLE);
                indicator.setVisibility(View.VISIBLE);
                btn_skip.startAnimation(shake_animation);
            }
        }, 2000);

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }

}
