package com.example.andoridtoolbox.utils;

import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;


public class LogView {

    // 用于显示日志的TextView
    private TextView mLogView;
    // 能显示最大的行数
    private int mMaxLine;
    // 消息传递的handler
    private Handler logHandler;
    private final int STATUS_MSG = 0x0000001;

    // 构造函数1
    public LogView(TextView logView){
        mLogView = logView;
        mMaxLine = 500;

        init();
    }

    // 构造函数2
    public LogView(TextView logView, int nMaxLine) {
        mLogView = logView;
        mMaxLine = nMaxLine;

        init();
    }

    // 用户调用的接口
    public void showLogs(String msg){
        Message logMsg = new Message();
        logMsg.what = STATUS_MSG;
        logMsg.obj = msg;
        Log.d("send", "showLogs: ");
        // 发送消息
        logHandler.sendMessage(logMsg);
    }

    private void init() {
        // 设置支持对TextView的内容滑动
        mLogView.setMovementMethod(ScrollingMovementMethod.getInstance());
        // 消息处理
        logHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case STATUS_MSG:
                        Log.d("recv", "handleMessage: 1");
                        show((String) msg.obj);
                        Log.d("recv", "handleMessage: 2");

                        break;
                    default:
                        break;
                }
            }
        };

    }

    /**
     * 显示日志
     * @param msg 需要传递的消息
     */
    private void show(String msg) {
        // 判断是否到达最大的滚动行，如果到达了，则
        if (mLogView.getLineCount() > mMaxLine)
        {
            mLogView.scrollTo(0,0);
            mLogView.clearComposingText();
            mLogView.setText("");
        }

        // 拼接消息
        mLogView.append(msg + "\n");
        // 计算最大的想素偏移量
        int offset = mLogView.getLineCount() * mLogView.getLineHeight();

        // 如果超过了，则下滑多出来的部分
        if(offset > mLogView.getHeight()){
            mLogView.scrollTo(0,offset - mLogView.getHeight());
        }
    }
}
