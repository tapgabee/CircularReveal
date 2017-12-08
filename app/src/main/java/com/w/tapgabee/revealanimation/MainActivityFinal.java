package com.w.tapgabee.revealanimation;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivityFinal extends AppCompatActivity {
    private FloatingActionButton fab;
    private LinearLayout secondLayout;
    private RelativeLayout rootLayout;
    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.root_layout);
        secondLayout = findViewById(R.id.second_content_layout);
        fab = findViewById(R.id.add_fab);

        fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(getResources(), R.color.white, null)));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleLayout();
            }
        });

    }

    private void toggleLayout() {

        int x = (int) fab.getX() + (fab.getWidth() / 2);
        int y = (int) fab.getY() + (fab.getHeight() / 2);
        int startRadius = 0;
        int endRadius = 0;

        if (!isOpen) {

            startRadius = 0;
            endRadius = (int) Math.hypot(rootLayout.getWidth(), rootLayout.getHeight());
            
            Animator anim = ViewAnimationUtils.createCircularReveal(secondLayout, x, y, startRadius, endRadius);
            secondLayout.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_close);
            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(getResources(), R.color.colorAccent, null)));

            anim.setDuration(1000);
            anim.start();

            isOpen = true;

        } else {

            startRadius = (int) Math.hypot(rootLayout.getWidth(), rootLayout.getHeight());
            endRadius = 0;

            Animator anim = ViewAnimationUtils.createCircularReveal(secondLayout, x, y, startRadius, endRadius);
            fab.setImageResource(R.drawable.ic_add);
            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(getResources(), R.color.white, null)));

            anim.setDuration(1000);
            anim.start();
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    secondLayout.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });

            isOpen = false;
        }

    }
}
