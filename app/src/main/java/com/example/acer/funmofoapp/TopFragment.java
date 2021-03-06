package com.example.acer.funmofoapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.funmofoapp.Adapters.TopViewItemAdapter;
import com.example.acer.funmofoapp.Data.Pr1;

import java.util.ArrayList;
import java.util.List;


public class TopFragment extends BaseFragment {
    private RecyclerView rvTop;
    private TopViewItemAdapter topAdapter;
    public static List<Pr1> getData(){
        List<Pr1> list =new ArrayList<>();
        list.add(new Pr1(R.drawable.pic1,"Durex","Rs. 60"));
        list.add(new Pr1(R.drawable.pic10,"Skore","Rs. 80"));
        list.add(new Pr1(R.drawable.pic2,"Manforce","Rs. 100"));
        list.add(new Pr1(R.drawable.pic4,"Assorted","Rs. 50"));
        return list;

    }

    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        rvTop= (RecyclerView) view.findViewById(R.id.rvTop);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topAdapter=new TopViewItemAdapter(getData());
        rvTop.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTop.setAdapter(topAdapter);

    }

    @Override
    public boolean onBackPressed() {
        Intent i1=new Intent(getContext(),MainActivity.class);
        i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i1);
     return true;
    }


}
