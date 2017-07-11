package com.example.acer.funmofoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ItemViewHolder1 extends RecyclerView.ViewHolder {

    public TextView tvorderdate,tvorderid,tvproductname,tvexpectedtime,tvprice,tvtraceorder;
    public ImageView image;

    public ItemViewHolder1(View itemView) {
        super(itemView);

        tvorderdate=(TextView)itemView.findViewById(R.id.tv_order_placed_date);
        tvorderid=(TextView)itemView.findViewById(R.id.tv_order_id2);
        tvproductname=(TextView)itemView.findViewById(R.id.tv_product_name);
        tvexpectedtime=(TextView)itemView.findViewById(R.id.tv_expected_time2);
        tvprice=(TextView)itemView.findViewById(R.id.tv_price);
        tvtraceorder=(TextView)itemView.findViewById(R.id.tv_trace_order);
        image=(ImageView)itemView.findViewById(R.id.iv_product);
    }
}
