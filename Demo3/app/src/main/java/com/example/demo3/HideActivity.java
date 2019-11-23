package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HideActivity extends AppCompatActivity {

    private TextView tvText;
    private Button btnShow;
    public static final String RESULT = "RESULT";
    public static final int RESULT_CODE = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide);

        getWidget();
        setByExtras();
        setEvents();
        //setByBundle();
    }

    public void setByExtras(){
        Intent intent = getIntent();
        String text = "Hello " + intent.getStringExtra(MainActivity.TEXT);

        tvText.setText(text);
    }

    public void getWidget(){
        tvText = (TextView) findViewById(R.id.tv_text);
        btnShow = (Button) findViewById(R.id.btn_show);
    }

    public void setEvents(){
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = tvText.getText().toString();
                Intent intent = new Intent(HideActivity.this,MainActivity.class);
                intent.putExtra(RESULT,result);
                setResult(RESULT_CODE,intent);
                finish();
            }
        });
    }
}
