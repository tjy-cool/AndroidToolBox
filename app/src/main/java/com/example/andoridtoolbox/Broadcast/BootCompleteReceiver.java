package com.example.andoridtoolbox.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.andoridtoolbox.utils.ToastUtil;

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ToastUtil.showLongToast("重启完成，网络恢复");
    }
}
