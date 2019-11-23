package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_SendText extends AppCompatActivity {

    private EditText edtInput;
    private Button btnSend;

    public static final String TEXT = "TEXT";
    //public static final String BUNDLE = "BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendtext);

        edtInput = (EditText) findViewById(R.id.edt_Input);
        btnSend = (Button) findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edtInput.getText().toString();
                byExtras(text);

                //byBundle(text);
            }
        });
    }

    public void byExtras(String text){
        Intent intent = new Intent(Activity_SendText.this,Activity_ShowText.class);
        intent.putExtra(TEXT,text);
        startActivity(intent);
    }

//    public void byBundle(String text){
//        Intent intent = new Intent(Activity_SendText.this,Activity_ShowText.class);
//        Bundle bundle = new Bundle();
//        bundle.putString(TEXT,text);
//        intent.putExtra(BUNDLE,bundle);
//        startActivity(intent);
//    }
}
