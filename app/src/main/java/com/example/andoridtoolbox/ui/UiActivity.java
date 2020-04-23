package com.example.andoridtoolbox.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.andoridtoolbox.R;

public class UiActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnTextEdit;
    private Button mBtnMenu;
    private Button mBtnSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        initView();
    }

    private void initView() {
        mBtnMenu = findViewById(R.id.btnMenu);
        mBtnTextView = findViewById(R.id.btnTextView);
        mBtnTextEdit = findViewById(R.id.btnTextEdit);
        mBtnButton = findViewById(R.id.btnButton);
        mBtnSurfaceView = findViewById(R.id.bnt_SurfaceView);

        mBtnMenu.setOnClickListener(this);
        mBtnTextView.setOnClickListener(this);
        mBtnTextEdit.setOnClickListener(this);
        mBtnButton.setOnClickListener(this);
        mBtnSurfaceView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTextView:
                onTvClick();
                break;
            case R.id.btnButton:
                onBtnClick();
                break;
            case R.id.btnTextEdit:
                onBtnEditClick();
                break;
            case R.id.btnMenu:
                onMenuClick();
                break;
            case R.id.bnt_SurfaceView:
                onSurfaceViewClick();
                break;
            default:
                break;
        }
    }

    private void onTvClick() {
        // 跳转到TextView演示界面
        Intent intent = new Intent(UiActivity.this, TextViewActivity.class);
        startActivity(intent);
    }

    private void onBtnClick() {
        // 跳转到Button演示界面
        Intent intent = new Intent(UiActivity.this, ButtonTestActivity.class);
        startActivity(intent);
    }

    private void onBtnEditClick() {
        Log.e("TAG", "onBtnEditClick: ");
        Intent intent = new Intent(this, TextEditActivity.class);
        startActivity(intent);
    }

    private void onMenuClick() {
        // 跳转到Button演示界面
        Intent intent = new Intent(UiActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    private void onSurfaceViewClick() {
        Intent intent = new Intent(this, SurfaceViewActivity.class);
        startActivity(intent);
    }
}
