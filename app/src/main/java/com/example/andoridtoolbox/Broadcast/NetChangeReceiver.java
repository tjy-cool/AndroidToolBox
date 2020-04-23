package com.example.andoridtoolbox.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.andoridtoolbox.utils.ToastUtil;

public class NetChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //ToastUtil.showShortToast("网络变化了");
//        -----代码实现-------
        //获取ConnectivityManager对象。
        ConnectivityManager  manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // NetworkInfo对象用来描述网络信息,得到当前使用的网络
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if(activeNetworkInfo==null||!activeNetworkInfo.isAvailable()){
            ToastUtil.showShortToast("网络不可以");
        }else{//可能联网
            //获取首选网络
            int networkType = activeNetworkInfo.getType();
            if(networkType == ConnectivityManager.TYPE_WIFI){
                ToastUtil.showShortToast("当前成功连接WIFI: " + activeNetworkInfo.isConnected());

            }else if(networkType==ConnectivityManager.TYPE_MOBILE){

                if(activeNetworkInfo.isRoaming()){
                    ToastUtil.showShortToast("当前成功连接漫游4G网络: " + activeNetworkInfo.isConnected());

                }else{
                    ToastUtil.showShortToast("当前成功连接非漫游4G网络: " + activeNetworkInfo.isConnected());

                }
            }
        }
    }
}
