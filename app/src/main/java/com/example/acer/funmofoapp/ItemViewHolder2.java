package com.example.acer.funmofoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ItemViewHolder2 extends RecyclerView.ViewHolder {

    public TextView tvorderdate1,tvorderid1,tvproductname1,tvprice1,tvdelivered;
    public ImageView image1,image_next;

    public ItemViewHolder2(View itemView) {
        super(itemView);

        tvorderdate1=(TextView)itemView.findViewById(R.id.tv_order_placed_date1);
        tvorderid1=(TextView)itemView.findViewById(R.id.tv_order_id3);
        tvproductname1=(TextView)itemView.findViewById(R.id.tv_product_name1);
        tvprice1=(TextView)itemView.findViewById(R.id.tv_price1);
        tvdelivered=(TextView)itemView.findViewById(R.id.tv_delivered);
        image1=(ImageView)itemView.findViewById(R.id.iv_product1);
        image_next=(ImageView)itemView.findViewById(R.id.iv_next);

    }
}
