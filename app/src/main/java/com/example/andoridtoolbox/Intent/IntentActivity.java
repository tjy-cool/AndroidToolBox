package com.example.andoridtoolbox.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.andoridtoolbox.R;
import com.example.andoridtoolbox.utils.LogView;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnActionView;
    private Button mBtnActionDIAL;
    private Button mBtn_putExtra;
    private Button mBtnForResult;
    private TextView mLogView;
    private LogView log;

    public static void actionStart(Context context, String data1, String data2)
    {
        Intent intent = new Intent(context, IntentActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        initView();
    }

    private void initView() {
        mBtnActionView = findViewById(R.id.btn_ActionView);
        mBtnActionView.setOnClickListener(this);

        mBtnActionDIAL = findViewById(R.id.btn_ActionDIAL);
        mBtnActionDIAL.setOnClickListener(this);

        mBtn_putExtra = findViewById(R.id.btn_putExtra);
        mBtn_putExtra.setOnClickListener(this);

        mBtnForResult = findViewById(R.id.btn_ForResult);
        mBtnForResult.setOnClickListener(this);

        mLogView = findViewById(R.id.intent_logview);
        log = new LogView(mLogView, 100);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_ActionView:
                log.showLogs("go to www.baidu.com");

                log.showLogs("   Intent intent = new Intent((Intent.ACTION_VIEW));\n" +
                        "   intent.setData(Uri.parse(\"https://www.baidu.com\"));\n" +
                        "   startActivity(intent);\n");

                // Intent.ACTION_VIEW，这是一个 Android 系统内 置的动作，其常量值为 android.intent.action.VIEW
                Intent intent = new Intent((Intent.ACTION_VIEW));
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);

                break;
            case R.id.btn_ActionDIAL:

                log.showLogs("pthone: 10086");
                log.showLogs("   Intent intent_phone = new Intent(Intent.ACTION_DIAL);\n" +
                        "   intent_phone.setData(Uri.parse(\"tel:10086\"));\n" +
                        "   startActivity(intent_phone);\n");

                Intent intent_phone = new Intent(Intent.ACTION_DIAL);
                intent_phone.setData(Uri.parse("tel:10086"));
                startActivity(intent_phone);

                break;

            case R.id.btn_putExtra:

                log.showLogs("Intent intent_putExtra = new Intent(IntentActivity.this, Intent_putExtra_Activity.class) ;\n" +
                        "  intent_putExtra.putExtra(\"aaaa\", \"hello world\");\n" +
                        "  startActivity(intent_putExtra);\n");

                Intent intent_putExtra = new Intent(IntentActivity.this, Intent_putExtra_Activity.class) ;
                intent_putExtra.putExtra("aaaa", "hello world");
                startActivity(intent_putExtra);
                break;

            case R.id.btn_ForResult:
                Intent intent_ForResult = new Intent(IntentActivity.this, Intent_putExtra_Activity.class);
                intent_ForResult.putExtra("aaaa", "intent_ForResult");
                startActivityForResult(intent_ForResult, 1);
                break;
            default:
                break;
        }
    }

    // 该方法用于接收上个活动返回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK) {
                    String stringResult = data.getStringExtra("key");
                    log.showLogs(stringResult);
                }
                break;
        }

    }
}
