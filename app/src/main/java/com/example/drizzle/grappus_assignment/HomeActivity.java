package com.example.drizzle.grappus_assignment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class HomeActivity extends AppCompatActivity implements View.OnLongClickListener {
    HorizontalCalendar horizontalCalendar;
    private ImageView iv_rest, iv_competition, iv_training, iv_add_day, iv_add_day_2;
    private TextView tv_training, tv_rest, tv_competition;
    private ViewGroup layoutContent, layoutMain, swipe_layout_container;
    private Button btn_next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        iv_rest = findViewById(R.id.iv_rest);
        iv_competition = findViewById(R.id.iv_competition);
        iv_training = findViewById(R.id.iv_training);
        iv_add_day = findViewById(R.id.iv_add_day);
        tv_competition = findViewById(R.id.tv_competition);
        tv_rest = findViewById(R.id.tv_rest);
        tv_training = findViewById(R.id.tv_training);
        iv_add_day_2 = findViewById(R.id.iv_add_day_2);
        layoutContent = findViewById(R.id.layoutContent);
        layoutMain = findViewById(R.id.layoutMain);
        swipe_layout_container = findViewById(R.id.swipe_layout_container);
        btn_next = findViewById(R.id.btn_how_it_go);
        iv_training.setOnLongClickListener(this);
        iv_competition.setOnLongClickListener(this);
        iv_rest.setOnLongClickListener(this);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("24th Dec, 18");

        final Animation pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
        buttonAnimation();
        iv_training.setOnDragListener(new View.OnDragListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onDrag(final View v, DragEvent event) {
                Log.d("Dragging", event.toString());
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_ENTERED:
                        iv_competition.setAlpha(0.2f);
                        tv_competition.setVisibility(View.GONE);
                        iv_rest.setAlpha(0.2f);
                        tv_rest.setVisibility(View.GONE);

                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        iv_training.setVisibility(View.INVISIBLE);
                        tv_training.setVisibility(View.INVISIBLE);
                        circleRevelActivity();
                        break;
                    case DragEvent.ACTION_DROP:
                        break;
                }
                return true;
            }
        });
        iv_add_day.startAnimation(pulse);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                iv_add_day_2.startAnimation(pulse);
            }
        }, 500);
        init();
    }

    private void buttonAnimation() {
        iv_training.post(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator slideUp = ObjectAnimator.ofFloat(iv_training, View.TRANSLATION_Y,
                        iv_training.getHeight(), 0);
                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                animatorSet.setDuration(1000);
                animatorSet.play(slideUp);
                animatorSet.start();
            }
        });
        iv_competition.post(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator slideUp = ObjectAnimator.ofFloat(iv_competition, View.TRANSLATION_Y,
                        iv_competition.getHeight(), 0);
                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                animatorSet.setDuration(1000);
                animatorSet.play(slideUp);
                animatorSet.start();
            }
        });
        iv_rest.post(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator slideUp = ObjectAnimator.ofFloat(iv_rest, View.TRANSLATION_Y,
                        iv_rest.getHeight(), 0);
                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                animatorSet.setDuration(1000);
                animatorSet.play(slideUp);
                animatorSet.start();
            }
        });
    }


    private void init() {
        /* start 1 months ago from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);
        /* end after 1 months from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        // Default Date set to Today.
        final Calendar defaultSelectedDate = Calendar.getInstance();
        horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                .formatTopText("MMM")
                .formatMiddleText("dd")
                .formatBottomText("EEE")
                .showTopText(true)
                .showBottomText(true)
                .textColor(Color.LTGRAY, Color.WHITE)
                .colorTextMiddle(Color.LTGRAY, Color.parseColor("#ffd54f"))
                .end()
                .defaultSelectedDate(defaultSelectedDate)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                String selectedDateStr = DateFormat.format("EEE, MMM d, yyyy", date).toString();
                getSupportActionBar().setTitle(selectedDateStr);
                // Toast.makeText(HomeActivity.this, selectedDateStr + " selected!", Toast.LENGTH_SHORT).show();
                Log.i("onDateSelected", selectedDateStr + " - Position = " + position);
            }

        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PlanOfActionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void circleRevelActivity() {
        int x = layoutContent.getLeft();
        int y = layoutContent.getBottom();

        int startRadius = 0;
        int endRadius = (int) Math.hypot(layoutMain.getWidth(), layoutMain.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(iv_add_day, x, y, startRadius, endRadius);

        swipe_layout_container.setVisibility(View.INVISIBLE);
        anim.start();
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.iv_training:
                iv_training.startDrag(null, new View.DragShadowBuilder(v), null, 0);
                break;
            case R.id.iv_competition:
                iv_competition.startDrag(null, new View.DragShadowBuilder(v), null, 0);
                break;
            case R.id.iv_rest:
                iv_rest.startDrag(null, new View.DragShadowBuilder(v), null, 0);
                break;
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
