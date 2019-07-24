package com.logixcess.republiccargo.gen_activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.logixcess.republiccargo.R;

public class SplashActivity extends AppCompatActivity {

    TextView tv_app_name;
    ProgressBar pb_loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv_app_name = findViewById(R.id.tv_app_name);
        pb_loader = findViewById(R.id.pb_loader);
        Typeface tf_roboto = Typeface.createFromAsset(SplashActivity.this.getAssets(), "fonts/Roboto-Light.ttf");
        Typeface tf_lobster = Typeface.createFromAsset(SplashActivity.this.getAssets(), "fonts/Lobster.ttf");
        tv_app_name.setTypeface(tf_lobster);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.splash_authentication_notification_bar_color));
        } else {
        }

        // Waiting For 2 Seconds Before Going To Authentication Activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(pb_loader.getVisibility() == View.VISIBLE)
                    pb_loader.setVisibility(View.GONE);
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                Animatoo.animateSlideUp(SplashActivity.this);
                finish();
            }
        }, 3000);
    }
}
