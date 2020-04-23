package com.example.andoridtoolbox.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.andoridtoolbox.R;
import com.example.andoridtoolbox.utils.LogView;

public class MenuActivity extends AppCompatActivity {

    private LogView log;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = findViewById(R.id.menuLogView);
        LogView log = new LogView(textView, 100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menutest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.qunliao:
//                Toast.makeText(this, "群聊。。。", Toast.LENGTH_SHORT).show();
                log.showLogs("群聊。。。");
                break;
            case R.id.add_friend:
//                Toast.makeText(this, "添加朋友。。。", Toast.LENGTH_SHORT).show();
                log.showLogs("添加朋友。。。");
                break;
            case R.id.saoyisao:
//                Toast.makeText(this, "扫一扫。。。", Toast.LENGTH_SHORT).show();
                log.showLogs("扫一扫。。。");
                break;
            case R.id.pay:
//                Toast.makeText(this, "收付款。。。", Toast.LENGTH_SHORT).show();
                log.showLogs("收付款。。。");
                break;
            case R.id.help:
//                Toast.makeText(this, "帮助与反馈。。。", Toast.LENGTH_SHORT).show();
                log.showLogs("帮助与反馈。。。");
                break;
            default:
                break;

        }
        return  true;
    }
}
