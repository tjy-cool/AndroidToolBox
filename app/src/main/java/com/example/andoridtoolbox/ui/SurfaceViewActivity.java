package com.example.andoridtoolbox.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.andoridtoolbox.R;

public class SurfaceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);

//        this.setContentView(new MySurfaceView(this));
        this.setContentView(new SurfaceViewL(this));

    }
}
