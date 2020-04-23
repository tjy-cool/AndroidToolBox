package com.example.andoridtoolbox.Broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.andoridtoolbox.R;

public class BroadcastActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnDynamicRegister;
    private Button mBtnStaticRegister;
    private Button mBtnSelfStdRegister;
    private Button mBtnSelfOrderRegister;
    private Button mBtnSendBroadcast;
    private Button mBtnLoalBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        mBtnDynamicRegister = findViewById(R.id.btn_dynamic_register);
        mBtnStaticRegister = findViewById(R.id.btn_static_register);
        mBtnSelfStdRegister = findViewById(R.id.btn_self_std_register);
        mBtnSelfOrderRegister = findViewById(R.id.btn_self_order_register);
        mBtnSendBroadcast = findViewById(R.id.btn_send_broadcast);
        mBtnLoalBroadcast = findViewById(R.id.btn_local_broadcast);


        mBtnDynamicRegister.setOnClickListener(this);
        mBtnStaticRegister.setOnClickListener(this);
        mBtnSelfStdRegister.setOnClickListener(this);
        mBtnSendBroadcast.setOnClickListener(this);
        mBtnSendBroadcast.setOnClickListener(this);
        mBtnLoalBroadcast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dynamic_register:
                onDynamicClick();
                break;
            case R.id.btn_static_register:
                onStaticClick();
                break;
            case R.id.btn_self_std_register:
                onSelfStdClick();
                break;
            case R.id.btn_self_order_register:
                onSelfOrderClick();
                break;
            case R.id.btn_send_broadcast:
                onSendBroadcastClick();
                break;
            case R.id.btn_local_broadcast:
                onLocalBroadcastClick();
                break;
            default:
                break;
        }
    }

    private void onLocalBroadcastClick() {
        Intent intent = new Intent(this, LocalBroadcastActivity.class);
        startActivity(intent);
    }

    private void onSendBroadcastClick() {
        Intent intent = new Intent("com.example.andoridtoolbox.Broadcast.MY_BROADCAST");
        sendBroadcast(intent);
        Log.e("BroadcastActivity", "onSendBroadcastClick: ");
    }

    private void onSelfOrderClick() {
    }

    private void onSelfStdClick() {
    }

    private void onDynamicClick() {
        Intent intent = new Intent(this, DynamicReigsterBroadCaseActivity.class);
        startActivity(intent);
    }

    private void onStaticClick() {
        Intent intent = new Intent(this, StaticReigsterBroadCaseActivity.class);
        startActivity(intent);
    }
}
