package com.dcnepal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.dcnepal.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sb on 3/1/16.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ProgressBar v = (ProgressBar) findViewById(R.id.splash_progress);
        v.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary),
                android.graphics.PorterDuff.Mode.MULTIPLY);


        //Fetch some data and remove the timer. just load activty when loading is done
        //Mainly push GCM_ID and other fields to identify user

        // TODO: establish connection, fetch data or something
        final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(new Runnable() {
            @Override
            public void run() {
                launchMain();
            }
        }, 1, TimeUnit.SECONDS);
    }

    protected void launchMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
