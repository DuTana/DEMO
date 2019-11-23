package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_ShowText extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__showtext);

        tvText = (TextView) findViewById(R.id.tv_show);
        setByExtras();
    }

    public void setByExtras(){
        Intent intent = getIntent();
        String text = "Hello " + intent.getStringExtra(Activity_SendText.TEXT);

        tvText.setText(text);
    }

}
