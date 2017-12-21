package com.tictactoeboardgame.game;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    // Logo image change frequency in mili-seconds
    private static int LOGO_IMAGE_TIMEOUT = 500;

    private ImageView ivSplashLogo;
    int[] imageSrc = {R.drawable.splash_brown, R.drawable.splash_green, R.drawable.splash_cyan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivSplashLogo = (ImageView) findViewById(R.id.ivSplashLogo);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                ivSplashLogo.setImageResource(imageSrc[i]);
                i++;
                if (i > imageSrc.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, LOGO_IMAGE_TIMEOUT);
            }
        };

        handler.postDelayed(runnable, LOGO_IMAGE_TIMEOUT);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
