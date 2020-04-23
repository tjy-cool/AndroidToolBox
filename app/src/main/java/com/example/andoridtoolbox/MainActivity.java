package com.example.andoridtoolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.andoridtoolbox.Activity.activityActivity;
import com.example.andoridtoolbox.Broadcast.BroadcastActivity;
import com.example.andoridtoolbox.Intent.IntentActivity;
import com.example.andoridtoolbox.event.HandlerActivity;
import com.example.andoridtoolbox.event.MyHandlerActivity;
import com.example.andoridtoolbox.gl.GlActivity;
import com.example.andoridtoolbox.ui.UiActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mUiShow;
    private Button mBtnHandler;
    private Button mBtnActivityShow;
    private Button mBtnBroadcastShow;
    private Button mBtnMyHandler;
    private Button mBtnIntentShow;
    private Button mBtnGL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView() {

        mUiShow = findViewById(R.id.ui_show);
        mBtnIntentShow = findViewById(R.id.intent_show);
        mBtnActivityShow = findViewById(R.id.btnActivity_show);
        mBtnBroadcastShow = findViewById(R.id.btnBroadcast_show);
        mBtnGL = findViewById(R.id.btnGL);
        mBtnHandler = findViewById(R.id.btnHander);
        mBtnMyHandler = findViewById(R.id.btnMyHandler);

        mUiShow.setOnClickListener(this);
        mBtnIntentShow.setOnClickListener(this);
        mBtnActivityShow.setOnClickListener(this);
        mBtnBroadcastShow.setOnClickListener(this);
        mBtnGL.setOnClickListener(this);
        mBtnHandler.setOnClickListener(this);
        mBtnMyHandler.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ui_show:
                onUiShowClick();
                break;
            case R.id.intent_show:
                onIntentClick();
            case R.id.btnActivity_show:
                onActivityClick();
                break;
            case R.id.btnBroadcast_show:
                onBroadcastClick();
                break;
            case R.id.btnHander:
                onHandlerClick();
                break;
            case R.id.btnMyHandler:
                onMyHandleClick();
                break;
            case R.id.btnGL:
                onGllick();
                break;
            default:
                break;
        }
    }

    private void onGllick() {
        Intent intent = new Intent(this, GlActivity.class);
        startActivity(intent);
    }

    private void onUiShowClick(){
        Intent intent = new Intent(MainActivity.this, UiActivity.class);
        startActivity(intent);
    }


    private void onIntentClick(){
        Intent intent = new Intent(MainActivity.this, IntentActivity.class);
        startActivity(intent);
    }

    private void onActivityClick() {
        Intent intent = new Intent(this, activityActivity.class);
        startActivity(intent);
    }

    private void onBroadcastClick() {
        Intent intent = new Intent(this, BroadcastActivity.class);
        startActivity(intent);
    }

    private void onHandlerClick() {
        Intent intent = new Intent(MainActivity.this, HandlerActivity.class);
        startActivity(intent);
    }

    private void onMyHandleClick() {
        Intent intent = new Intent(MainActivity.this, MyHandlerActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You Clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You Clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
