package com.example.demo3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtInput;
    private Button btnSend;

    public static final int REQUEST_CODE = 31;
    public static final String TEXT = "TEXT";
    //public static final String BUNDLE = "BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        setEvent();


    }

    public void getWidget(){
        edtInput = (EditText) findViewById(R.id.edt_Input);
        btnSend = (Button) findViewById(R.id.btn_send);
    }

    public void setEvent(){
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(edtInput.getText().toString())) {
                    String text = edtInput.getText().toString();
                    byExtras(text);

                    //byBundle(text);
                }
            }
        });
    }

    public void byExtras(String text){
        Intent intent = new Intent(MainActivity.this,HideActivity.class);
        intent.putExtra(TEXT,text);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE) {
            switch (resultCode) {
                case HideActivity.RESULT_CODE:
                    String result = data.getStringExtra(HideActivity.RESULT);
                    Toast.makeText(this, result + "", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }
}
