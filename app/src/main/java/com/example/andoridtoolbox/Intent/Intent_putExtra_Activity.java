package com.example.andoridtoolbox.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andoridtoolbox.R;
import com.example.andoridtoolbox.utils.LogView;

public class Intent_putExtra_Activity extends AppCompatActivity {

    private Button mbtn_Back_putExtra;
    private TextView mlogView;
    private LogView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_put_extra_);


        mlogView = findViewById(R.id.intent_extra_logview);
        log = new LogView(mlogView, 100);

        mbtn_Back_putExtra = findViewById(R.id.btn_IntentBack);
        mbtn_Back_putExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent_putExtra_Activity.this, IntentActivity.class);
                intent.putExtra("key", "这是上一个页面返回的数据：1111");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        log.showLogs("   Intent intent = getIntent();\n" +
                "   String data = intent.getStringExtra(\"aaaa\");\n");

        Intent intent = getIntent();
        String data = intent.getStringExtra("aaaa");
        Toast.makeText(getBaseContext(), data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Log.d("TAG", "onBackPressed: ");
        Intent intent = new Intent(Intent_putExtra_Activity.this, IntentActivity.class);
        intent.putExtra("key", "这是上一个页面返回的数据：2222");
        setResult(RESULT_OK, intent);
        finish();
    }
}
