package com.w.tapgabee.revealanimation;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
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
//        TODO : calculate x and y values
        int x = 0;
        int y = 0;
        int startRadius = 0;
        int endRadius = 0;

        if (!isOpen) {
//         TODO : implement open animation


        } else {
//         TODO : implement close animation

        }

    }
}
