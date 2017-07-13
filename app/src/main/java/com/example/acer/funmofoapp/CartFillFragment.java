package com.example.acer.funmofoapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.funmofoapp.Adapters.CartViewItemAdapter;
import com.example.acer.funmofoapp.Data.CartProduct;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFillFragment extends Fragment {
    private RecyclerView rvCart;
    private ArrayList<CartProduct> list;
    private CartViewItemAdapter cartAdapter;


    public CartFillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart_fill, container, false);

        list=new ArrayList<>();
        list.add(new CartProduct(R.drawable.pic1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,R.drawable.ic_close,
                "Durex","Rs. 60"));
        list.add(new CartProduct(R.drawable.pic1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,R.drawable.ic_close,
                "Skore","Rs. 80"));

        cartAdapter=new CartViewItemAdapter(list);
        rvCart.setAdapter(cartAdapter);
        rvCart.setLayoutManager(new LinearLayoutManager(getActivity()));


        // Inflate the layout for this fragment
        return view;
    }

}
