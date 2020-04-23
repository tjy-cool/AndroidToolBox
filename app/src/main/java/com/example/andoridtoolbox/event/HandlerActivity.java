package com.example.andoridtoolbox.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.andoridtoolbox.R;

public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnHandle_post;
    private Button mBtnHandle_send;

    private Handler mhandler_post = null;
    private Handler mHandler_send = null;
    private final int STATUS_MSG1 = 0x100000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        initView();

        mHandler_send = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case STATUS_MSG1:
                        Toast.makeText(getBaseContext(), Integer.toString(msg.what), Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "handleMessage: ");
                        break;
                    default:
                        break;
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                Message msg = new Message();
                msg.what = STATUS_MSG1;
                mHandler_send.sendMessage(msg);
            }
        }.start();
    }

    private void initView() {
        mBtnHandle_post = findViewById(R.id.handler_post);
        mBtnHandle_send = findViewById(R.id.handler_send);

        mBtnHandle_post.setOnClickListener(this);
        mBtnHandle_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.handler_post:
                onHandle_post();
                break;
            case R.id.handler_send:
                onHandle_send();
                break;
            default:
                break;
        }
    }

    private void onHandle_post() {
        Toast.makeText(getBaseContext(), "请等待3秒，会再次Toast", Toast.LENGTH_SHORT).show();
        mhandler_post = new Handler();
        mhandler_post.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), "postDelayed 方法", Toast.LENGTH_SHORT).show();
            }
        }, 3000);

    }


    private void onHandle_send() {
        Log.d("TAG", "onHandle_send: ");
        Message myMsg = new Message();
        myMsg.what = STATUS_MSG1;
        mHandler_send.sendMessage(myMsg);
    }

    private class HandlerThread extends Thread{
        @Override
        public void run() {
            super.run();

        }
    }
}
