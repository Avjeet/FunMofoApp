package com.example.acer.funmofoapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.funmofoapp.Data.CartProduct;
import com.example.acer.funmofoapp.R;

import java.util.List;

/**
 * Created by ACER on 13-Jul-17.
 */

public class CartViewItemAdapter extends RecyclerView.Adapter<CartViewItemAdapter.ItemViewHolder> {

    public List<CartProduct> list;
    public CartViewItemAdapter(List<CartProduct> list){
        this.list=list;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivPic,ivPlus,ivMinus,ivClose;
        public TextView name,price;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ivPic= (ImageView) itemView.findViewById(R.id.img2);
            ivPlus= (ImageView) itemView.findViewById(R.id.imPlus);
            ivMinus= (ImageView) itemView.findViewById(R.id.imMinus);
            ivClose= (ImageView) itemView.findViewById(R.id.imClose);
            name= (TextView) itemView.findViewById(R.id.tvName);
            price= (TextView) itemView.findViewById(R.id.tvPrice);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
               return new ItemViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
       // ItemViewHolder  viewHolder=holder;
        holder.ivPic.setImageResource(list.get(position).getImageID());
        holder.ivPlus.setImageResource(list.get(position).getImPlus());
        holder.ivMinus.setImageResource(list.get(position).getImMinus());
        holder.ivClose.setImageResource(list.get(position).getImClose());
        holder.name.setText(list.get(position).getProductName());
        holder.price.setText(list.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
