package com.example.acer.funmofoapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.funmofoapp.Data.CartProduct;
import com.example.acer.funmofoapp.PreviewActivity;
import com.example.acer.funmofoapp.R;

import java.util.List;

public class WishlistViewItemAdapter extends RecyclerView.Adapter<WishlistViewItemAdapter.ItemViewHolder> {

    private String tag;
    private View myview;
    int count=0;

    public List<CartProduct> list;
    public Context context;


    public WishlistViewItemAdapter(List<CartProduct> list,String tag){
        this.list=list;
        this.tag=tag;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivPic,ivshare,ivdelete,imclose ,imPlus,imMinus;
        public TextView name,price;
        public EditText etcount;
        private CardView card_view;

        public ItemViewHolder( final View itemView) {
            super(itemView);
            ivPic= (ImageView) itemView.findViewById(R.id.image2);
            name= (TextView) itemView.findViewById(R.id.tv_Name);
            price= (TextView) itemView.findViewById(R.id.tv_Price);
            ivshare=(ImageView)itemView.findViewById(R.id.iv_share);
            ivdelete=(ImageView)itemView.findViewById(R.id.iv_delete);
            imclose=(ImageView)itemView.findViewById(R.id.imClose);
            card_view= (CardView) itemView.findViewById(R.id.card_view);
            imPlus=(ImageView)itemView.findViewById(R.id.imPlus);
            imMinus=(ImageView)itemView.findViewById(R.id.imMinus);
            etcount=(EditText) itemView.findViewById(R.id.tv_count);

        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context=parent.getContext();

        if(tag=="Wishlist")
            myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item,parent,false);
        else if(tag=="cart")
            myview= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);


        return new ItemViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {

        switch (tag)
        {
            case "Wishlist" :
                holder.ivPic.setImageResource(list.get(position).getImageID());
                holder.name.setText(list.get(position).getProductName());
                holder.price.setText(list.get(position).getPrice());

                holder.ivshare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent shareintent=new Intent();
                        shareintent.setAction(Intent.ACTION_SEND);
                        context.startActivity(Intent.createChooser(shareintent," "));
                    }
                });


                holder.ivdelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,list.size());

                    }
                });
                break;

            case "cart" :

                holder.ivPic.setImageResource(list.get(position).getImageID());
                holder.name.setText(list.get(position).getProductName());
                holder.price.setText(list.get(position).getPrice());

                holder.imclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,list.size());
                    }
                });

                holder.etcount.setEnabled(false);

                holder.imPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count=Integer.parseInt((holder.etcount.getText()).toString());
                        holder.etcount.setText(String.valueOf(count+1));
                    }
                });

                holder.imMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count=Integer.parseInt((holder.etcount.getText()).toString());
                        holder.etcount.setText(String.valueOf(count-1));
                    }
                });
                break;
        }

            holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i1=new Intent(context, PreviewActivity.class);
                ActivityOptionsCompat optionCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,holder.ivPic,"productImage");
                Bundle data=new Bundle();
                data.putInt("imageID", list.get(position).getImageID());
                data.putString("name",list.get(position).getProductName());
                data.putString("price",list.get(position).getPrice());
                i1.putExtras(data);
                context.startActivity(i1,optionCompat.toBundle());


            }
        });

       // holder.card_view.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
