package com.example.acer.funmofoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
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
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        emailEditText = (EditText) findViewById(R.id.email);
        passEditText = (EditText)   findViewById(R.id.password);
        loginButton =(Button) findViewById(R.id.login_button);
        forgotPassTxt=(TextView)findViewById(R.id.forgot_pass_txt);
        registerTxt=(TextView) findViewById(R.id.register_txt);
        fragment=(FrameLayout) findViewById(R.id.fragment);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(SignInActivity.this,MainActivity.class);
                i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i1);
                finish();

            }
        });

        registerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(SignInActivity.this,SignUpActivity.class);
                i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i1);
                finish();

            }
        });

        forgotPassTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(SignInActivity.this,ForgotPasswordActivity.class);
                i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i1);
                finish();
            }
        });





    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        new android.app.AlertDialog.Builder(this)
                .setMessage("Are you really want to exit ??")
                .setNegativeButton("CANCEL", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        SignInActivity.super.onBackPressed();
                        finish();
                    }
                }).create().show();
    }
}
