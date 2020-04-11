package com.example.basiccontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv=findViewById(R.id.tv_text);
        Intent intent=getIntent();
        String data=intent.getStringExtra("content");
        tv.setText(data);
    }
}
