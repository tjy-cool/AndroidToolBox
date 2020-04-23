package com.example.andoridtoolbox.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.andoridtoolbox.R;

public class TextViewActivity extends AppCompatActivity {

    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        tv4 = findViewById(R.id.tv_4);
        tv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);   // 中划线
        tv4.getPaint().setAntiAlias(true);  // 去除锯齿

        tv5 = findViewById(R.id.tv_5);
        tv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);    // 下划线


        tv6 = findViewById(R.id.tv_6);
        tv6.setText(Html.fromHtml("<u>学习安卓使我快乐</u>"));   // html的下划线

        tv7 = findViewById(R.id.tv_7);
        tv7.setSelected(true);
    }
}
