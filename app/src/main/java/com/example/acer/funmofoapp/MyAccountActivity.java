package com.example.acer.funmofoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

public class MyAccountActivity extends AppCompatActivity {

    private TextView tv_address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        tv_address=(TextView)findViewById(R.id.tv_address);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        tv_address.setText(" Block - AK \n House No.-35 \n Shalimar Bagh ,Delhi ");


    }
}
