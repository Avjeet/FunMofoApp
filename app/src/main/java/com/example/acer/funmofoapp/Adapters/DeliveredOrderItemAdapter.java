package com.example.acer.funmofoapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.funmofoapp.Data.Item2;
import com.example.acer.funmofoapp.OrderDetails;
import com.example.acer.funmofoapp.R;

import java.util.List;

/**
 * Created by Komal on 7/13/2017.
 */

public class DeliveredOrderItemAdapter extends RecyclerView.Adapter<DeliveredOrderItemAdapter.ItemViewHolder2> {
    public List<Item2> ilist;
    public Context context;

    public DeliveredOrderItemAdapter(List<Item2> ilist){
        this.ilist=ilist;
    }

    @Override
    public DeliveredOrderItemAdapter.ItemViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();

        View myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2,parent,false);
        ItemViewHolder2 viewHolder=new ItemViewHolder2(myview);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(DeliveredOrderItemAdapter.ItemViewHolder2 holder, int position) {
        ItemViewHolder2 viewHolder= (ItemViewHolder2) holder;
        viewHolder.tvorderdate1.setText(String.valueOf(ilist.get(position).getTvorderdate1()));
        viewHolder.tvorderid1.setText(String.valueOf(ilist.get(position).getTvorderid1()));
        viewHolder.tvproductname1.setText(String.valueOf(ilist.get(position).getTvproductname1()));
        viewHolder.tvprice1.setText(String.valueOf(ilist.get(position).getTvprice1()));
        viewHolder.image1.setImageResource(ilist.get(position).getImage1());
    }

    @Override
    public int getItemCount() {
        return ilist.size();
    }

    public class ItemViewHolder2 extends RecyclerView.ViewHolder {

        public TextView tvorderdate1, tvorderid1, tvproductname1, tvprice1, tvdelivered;
        public ImageView image1, image_next;
        public CardView card;

        public ItemViewHolder2(View itemView) {
            super(itemView);

            tvorderdate1 = (TextView) itemView.findViewById(R.id.tv_order_placed_date1);
            tvorderid1 = (TextView) itemView.findViewById(R.id.tv_order_id3);
            tvproductname1 = (TextView) itemView.findViewById(R.id.tv_product_name1);
            tvprice1 = (TextView) itemView.findViewById(R.id.tv_price1);
            tvdelivered = (TextView) itemView.findViewById(R.id.tv_delivered);
            image1 = (ImageView) itemView.findViewById(R.id.iv_product1);
            image_next = (ImageView) itemView.findViewById(R.id.iv_next);
            card=(CardView)itemView.findViewById(R.id.delivered_card);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i1=new Intent(context, OrderDetails.class);
                    context.startActivity(i1);

                }
            });

        }
    }
}