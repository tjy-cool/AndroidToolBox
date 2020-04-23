package com.example.andoridtoolbox.Broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

import com.example.andoridtoolbox.R;
import com.example.andoridtoolbox.utils.ToastUtil;

public class DynamicReigsterBroadCaseActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetChangeReceiver netChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_reigster_broad_case);

        ToastUtil.showShortToast("注册网络状态广播成功");

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netChangeReceiver = new NetChangeReceiver();
        registerReceiver(netChangeReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtil.showShortToast("注销网络状态广播成功");

        unregisterReceiver(netChangeReceiver);
    }
}
