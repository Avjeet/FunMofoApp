package com.example.acer.funmofoapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
        rvCart= (RecyclerView) view.findViewById(R.id.rvCart);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list=new ArrayList<>();
        list.add(new CartProduct(R.drawable.pic1,
                "Durex","Rs. 60"));
        list.add(new CartProduct(R.drawable.pic2,
                "Skore","Rs. 80"));

        cartAdapter=new CartViewItemAdapter(list);
        rvCart.setAdapter(cartAdapter);
        rvCart.setLayoutManager(new LinearLayoutManager(getActivity()));


    }
}
