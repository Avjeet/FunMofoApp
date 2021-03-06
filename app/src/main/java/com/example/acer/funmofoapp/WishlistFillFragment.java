package com.example.acer.funmofoapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.funmofoapp.Adapters.WishlistViewItemAdapter;
import com.example.acer.funmofoapp.Data.CartProduct;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class WishlistFillFragment extends BaseFragment {

    private ArrayList<CartProduct> list;
    private WishlistViewItemAdapter wishlistAdapter;
    private RecyclerView rvWishlist;


    public WishlistFillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist_fill, container, false);

        rvWishlist= (RecyclerView) view.findViewById(R.id.rvWishlist);
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list=new ArrayList<>();
        list.add(new CartProduct(R.drawable.pic1,
                "Durex","Rs. 60"));
        list.add(new CartProduct(R.drawable.pic10,
                "Skore","Rs. 80"));
        list.add(new CartProduct(R.drawable.pic2,
                "Manforce","Rs. 90"));
        list.add(new CartProduct(R.drawable.pic4,
                "Assorted","Rs. 90"));

        wishlistAdapter=new WishlistViewItemAdapter(list,"Wishlist");
        rvWishlist.setAdapter(wishlistAdapter);
        rvWishlist.setLayoutManager(new GridLayoutManager(getActivity(),2));


    }

    @Override
    public boolean onBackPressed() {
//        Intent i1=new Intent(getContext(),MainActivity.class);
//        i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(i1);

        return false;
    }

}
