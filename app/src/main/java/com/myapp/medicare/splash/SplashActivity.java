package com.myapp.medicare.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.myapp.medicare.R;
import com.myapp.medicare.home.HomeActivity;

/**
 * Created by Rijo K Jose on 1/12/16.
 */
public class SplashActivity extends Activity {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = this;
        loadSplash();
    }

    private void loadSplash() {

        new Handler().postDelayed(new Runnable() {

			/*
             * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,
                        HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

}
