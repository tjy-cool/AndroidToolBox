package com.example.andoridtoolbox.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andoridtoolbox.R;

public class TextEditActivity extends AppCompatActivity {

    private Button mbtnLogin;
    private EditText meditPasswd;
    private EditText meditUser;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_edit);
        
        mbtnLogin = findViewById(R.id.btnLogin);
        meditPasswd = findViewById(R.id.editPasswd);
        meditUser = findViewById(R.id.editUser);
        
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String userName = meditUser.getText().toString();
                String passwd = meditPasswd.getText().toString();
                Toast.makeText(TextEditActivity.this, 
                        "userName: " + userName + "\npasswd: " + passwd, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
