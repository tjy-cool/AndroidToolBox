package com.example.andoridtoolbox.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.andoridtoolbox.utils.ToastUtil;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ToastUtil.showShortToast("in my BroadcastReceiver");
        Log.e("BroadcastActivity", "onReceive: ");
    }
}
