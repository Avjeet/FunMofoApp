package com.example.acer.funmofoapp;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passEditText;
    private Button loginButton;
    private TextView forgotPassTxt;
    private FrameLayout fragment;
    private TextView registerTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailEditText = (EditText) findViewById(R.id.email);
        passEditText = (EditText)   findViewById(R.id.password);
        loginButton =(Button) findViewById(R.id.login_button);
        forgotPassTxt=(TextView)findViewById(R.id.forgot_pass_txt);
        registerTxt=(TextView) findViewById(R.id.register_txt);
        fragment=(FrameLayout) findViewById(R.id.fragment_container);





    }
}
