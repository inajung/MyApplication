package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

public class SplashScreenActivity extends AppCompatActivity {

    private Thread splashThread;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //The thread to wait for splash screen events

        splashThread = new Thread() {
            public void run() {
                try {
                    synchronized (this) {
                        wait(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
                //Run next activity
                Intent intent = new Intent();
                intent.setClass(SplashScreenActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        };

        splashThread.start();
    }
    @Override
    public boolean onTouchEvent(MotionEvent evt) {
        if (evt.getAction() == MotionEvent.ACTION_DOWN) {
            synchronized (splashThread) {
                splashThread.notifyAll();
            }
        }
        return true;
    }

}


