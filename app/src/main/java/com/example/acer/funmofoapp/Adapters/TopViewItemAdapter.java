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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.funmofoapp.Data.Pr1;
import com.example.acer.funmofoapp.PreviewActivity;
import com.example.acer.funmofoapp.R;

import java.util.List;

import static com.example.acer.funmofoapp.Data.Pr1.card1;
import static com.example.acer.funmofoapp.Data.Pr1.card2;


public class TopViewItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private View im1View;
    public List<Pr1> list;
    public TopViewItemAdapter(List<Pr1> list){
        this.list=list;
    }

    private Pr1 currentProduct;
    private Context context;
    public View imView;

    @Override
    public int getItemViewType(int position) {

        return position%2;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view;
        switch (viewType){
            case card1:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.top_card1,parent,false);
                return new Top1ViewHolder(view);
            case card2:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.top_card2,parent,false);
                return new Top2ViewHolder(view);

        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


            switch (position%2){
                case card1:
                    ((Top1ViewHolder)holder).ivPic.setImageResource(list.get(position).getImageID());
                    ((Top1ViewHolder)holder).name.setText(list.get(position).getProductName());
                    ((Top1ViewHolder)holder).price.setText(list.get(position).getPrice());
                    ((Top1ViewHolder)holder).cardLayout.setTag(position);
                    break;
                case card2:
                    ((Top2ViewHolder)holder).ivPic.setImageResource(list.get(position).getImageID());
                    ((Top2ViewHolder)holder).name.setText(list.get(position).getProductName());
                    ((Top2ViewHolder)holder).price.setText(list.get(position).getPrice());
                    ((Top2ViewHolder)holder).cardLayout.setTag(position);
                    break;

        }


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Top1ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivPic;
        public TextView name,price;
        public CardView cardLayout;

        public Top1ViewHolder(final View itemView) {
            super(itemView);
            ivPic= (ImageView) itemView.findViewById(R.id.img2);
            name= (TextView) itemView.findViewById(R.id.tvName);
            price= (TextView) itemView.findViewById(R.id.tvPrice);
            cardLayout=(CardView) itemView.findViewById(R.id.cv);

            cardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int currentPos = (int) view.getTag();
                    currentProduct = list.get(currentPos);

                    ActivityOptionsCompat optionCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, itemView.findViewById(R.id.img2), "productImage");
                    startPreview(optionCompat);
                }
            });
        }
    }

    public class Top2ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivPic;
        public TextView name,price;
        public CardView cardLayout;


        public Top2ViewHolder(final View itemView) {
            super(itemView);
            ivPic= (ImageView) itemView.findViewById(R.id.img2);
            name= (TextView) itemView.findViewById(R.id.tvName);
            price= (TextView) itemView.findViewById(R.id.tvPrice);
            cardLayout=(CardView) itemView.findViewById(R.id.cv);
            cardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int currentPos = (int) view.getTag();
                    currentProduct = list.get(currentPos);
                    ActivityOptionsCompat optionCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, itemView.findViewById(R.id.img2), "productImage");
                    startPreview(optionCompat);
                }
            });


        }
    }

    private void startPreview(ActivityOptionsCompat optionCompat){
        Intent detailActivityIntent = new Intent(context, PreviewActivity.class);
        Bundle data = new Bundle();
        data.putString("name", currentProduct.getProductName());
        data.putString("price", currentProduct.getPrice());
        data.putInt("imageID", currentProduct.getImageID());
        detailActivityIntent.putExtras(data);
        context.startActivity(detailActivityIntent, optionCompat.toBundle());

    }


}

