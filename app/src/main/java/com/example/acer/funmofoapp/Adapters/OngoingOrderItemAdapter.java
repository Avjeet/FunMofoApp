package com.example.acer.funmofoapp.Adapters;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.funmofoapp.Data.Item1;
import com.example.acer.funmofoapp.OrderTrackingActivity;
import com.example.acer.funmofoapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komal on 7/11/2017.
 */

public class OngoingOrderItemAdapter extends RecyclerView.Adapter<OngoingOrderItemAdapter.ItemViewHolder1> {

    public List<Item1> ilist;
     public Context context;

    public OngoingOrderItemAdapter(List<Item1> ilist){
        this.ilist=ilist;
    }
    @Override
    public ItemViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {

        context=parent.getContext();

        View myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item1,parent,false);
         return new ItemViewHolder1(myview);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder1 holder, int position) {
        ItemViewHolder1 viewHolder= (ItemViewHolder1) holder;
        viewHolder.tvorderdate.setText(String.valueOf(ilist.get(position).getTvorderdate()));
        viewHolder.tvorderid.setText(String.valueOf(ilist.get(position).getTvorderid()));
        viewHolder.tvproductname.setText(String.valueOf(ilist.get(position).getTvproductname()));
        viewHolder.tvexpectedtime.setText(String.valueOf(ilist.get(position).getTvexpectedtime()));
        viewHolder.tvprice.setText(String.valueOf(ilist.get(position).getTvprice()));
        viewHolder.image.setImageResource(ilist.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return ilist.size();
    }

    public class ItemViewHolder1 extends RecyclerView.ViewHolder {

        public TextView tvorderdate,tvorderid,tvproductname,tvexpectedtime,tvprice,tvtraceorder;
        public ImageView image;
        public CardView card;

        public ItemViewHolder1(View itemView) {
            super(itemView);

            tvorderdate=(TextView)itemView.findViewById(R.id.tv_order_placed_date);
            tvorderid=(TextView)itemView.findViewById(R.id.tv_order_id2);
            tvproductname=(TextView)itemView.findViewById(R.id.tv_product_name);
            tvexpectedtime=(TextView)itemView.findViewById(R.id.tv_expected_time2);
            tvprice=(TextView)itemView.findViewById(R.id.tv_price);
            tvtraceorder=(TextView)itemView.findViewById(R.id.tv_trace_order);
            image=(ImageView)itemView.findViewById(R.id.iv_product);
            card=(CardView) itemView.findViewById(R.id.ongoing_delivered);


            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i1=new Intent(context, OrderTrackingActivity.class);
                    context.startActivity(i1);
                }
            });

        }
    }


}
