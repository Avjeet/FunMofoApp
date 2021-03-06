package com.example.acer.funmofoapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.view.WindowManager;
import android.widget.RatingBar;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {
    private RatingBar ratingBar;
    private TextView nametextView,pricetextview;
    private ImageView productImageView,ivback,ivshare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ratingBar= (RatingBar) findViewById(R.id.ratingBar);
        nametextView=(TextView) findViewById(R.id.tvName);
        pricetextview=(TextView) findViewById(R.id.price);
        productImageView=(ImageView) findViewById(R.id.card_image);
        ivback=(ImageView)findViewById(R.id.iv_back2);
        ivshare=(ImageView)findViewById(R.id.img_share);

        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(PreviewActivity.this,MainActivity.class);
                i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i1);
                finish();
            }
        });

        ivshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareintent=new Intent();
                shareintent.setAction(Intent.ACTION_SEND);
                startActivity(Intent.createChooser(shareintent," "));
            }
        });

        Bundle bundle = getIntent().getExtras();
        Log.w("name","name:"+bundle.getString("name"));

        nametextView.setText(bundle.getString("name"));
        pricetextview.setText(bundle.getString("price"));
        productImageView.setImageResource(bundle.getInt("imageID"));


        //rating bar
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();

        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(this, R.color.orange_yellow), PorterDuff.Mode.SRC_ATOP);
        ratingBar.setRating(Float.parseFloat("4.0"));
        ratingBar.setEnabled(false);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i1=new Intent(PreviewActivity.this,MainActivity.class);
        i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i1);
        finish();
    }
}
