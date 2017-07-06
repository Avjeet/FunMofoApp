package com.example.acer.funmofoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class OtpActivity extends AppCompatActivity {
    private Button btnsubmit;
    private EditText etOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        btnsubmit= (Button) findViewById(R.id.btnsubmit);
        etOtp=(EditText)findViewById(R.id.etOtp);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        btnsubmit.setEnabled(false);

        TextWatcher tw=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==0){
                    btnsubmit.setEnabled(false);
                }
                else
                    btnsubmit.setEnabled(true);
            }

        };
        etOtp.addTextChangedListener(tw);



    }
}
