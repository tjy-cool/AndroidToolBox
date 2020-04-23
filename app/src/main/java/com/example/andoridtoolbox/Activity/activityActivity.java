package com.example.andoridtoolbox.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.andoridtoolbox.R;
import com.example.andoridtoolbox.utils.LogView;

public class activityActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnNormalActivity;
    private Button mBtnDailogActivity;
    private TextView mLogView;
    private LogView log;

    private final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        initView();

        if (savedInstanceState != null) {
            String saveData = savedInstanceState.getString("data_key");
            log.showLogs("保存的数据： "+ saveData);
        }else{
            log.showLogs("savedInstanceState is null ");
        }


        Log.d(TAG, "onCreate: ");
        log.showLogs(">> onCreate");
    }

    private void initView() {
        mBtnNormalActivity = findViewById(R.id.BtnNormalActivity);
        mBtnDailogActivity = findViewById(R.id.BtnDailogActivity);

        mLogView = findViewById(R.id.view_actibity);
        log = new LogView(mLogView);

        mBtnNormalActivity.setOnClickListener(this);
        mBtnDailogActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.BtnDailogActivity:
                onBtnDailogClick();
                break;
            case R.id.BtnNormalActivity:
                onBtnNormalClick();
                break;
        }
    }

    private void onBtnNormalClick() {
        Intent intent = new Intent(this, NormalActivity.class);
        startActivity(intent);
    }

    private void onBtnDailogClick() {
        Intent intent = new Intent(this, DailogActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: ");
        log.showLogs(">> onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: ");
        log.showLogs(">> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: ");
        log.showLogs(">> onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop: ");
        log.showLogs(">> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: ");
        log.showLogs(">> onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart: ");
        log.showLogs(">> onRestart");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        String temp_data = "我是要保存的数据，啊啊啊啊";
        outState.putString("data_key", temp_data);
    }
}
