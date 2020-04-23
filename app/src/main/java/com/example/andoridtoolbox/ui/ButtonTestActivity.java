package com.example.andoridtoolbox.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.andoridtoolbox.R;

public class ButtonTestActivity extends AppCompatActivity {

    private Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_test);

        mButton1 = findViewById(R.id.btnButton1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "这是一个自定义背景颜色形状的演示", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
