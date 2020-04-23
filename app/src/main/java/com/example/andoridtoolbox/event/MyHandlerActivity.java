package com.example.andoridtoolbox.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.andoridtoolbox.R;
import com.example.andoridtoolbox.utils.LogView;

public class MyHandlerActivity extends AppCompatActivity {

    private Button mBtn_My_Handler_1;
    private Button mBtn_My_Handler_2;
    private TextView mLogView;
    private String TAG = "MyTest";

    private LogView mlog;

    private Handler mHandler1;
    private Handler mHandler2;

    private Mythread mythread;
    private int cnt = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_handler);

        mBtn_My_Handler_1 = findViewById(R.id.btn_run);
        mBtn_My_Handler_2 = findViewById(R.id.btn_stop);
        mLogView = findViewById(R.id.tv_Log);


        mHandler1 = new Handler();

        mlog = new LogView(mLogView, 50);

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mlog.showLogs("running ..." + Integer.toString(cnt++));
//                LogView.ShowLog(mLogView, "running ..." + cnt++);

                mHandler1.postDelayed(this, 100);
            }
        };

        mBtn_My_Handler_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlog.showLogs("start ...");
//                LogView.ShowLog(mLogView, "start ..." + cnt++);
                mHandler1.postDelayed(runnable, 100);
            }
        });

        mBtn_My_Handler_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler1.removeCallbacks(runnable);
            }
        });

        mythread = new Mythread();
        mythread.start();

    }

    private class Mythread extends Thread{

        int cnt = 0;
        @Override
        public void run() {
            super.run();

            while(true) {
                mlog.showLogs("Mythread: " + cnt++);
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
