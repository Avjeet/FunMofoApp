package com.example.acer.funmofoapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.funmofoapp.Adapters.TopViewItemAdapter;
import com.example.acer.funmofoapp.Data.Pr1;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {
    private RecyclerView rvTop;
    private TopViewItemAdapter topAdapter;
    public static List<Pr1> getData(){
        List<Pr1> list =new ArrayList<>();
        list.add(new Pr1(R.drawable.pic1,"Durex","Rs. 60",Pr1.card1));
        list.add(new Pr1(R.drawable.pic10,"Skore","Rs. 80",Pr1.card2));
        list.add(new Pr1(R.drawable.pic2,"Manforce","Rs. 100",Pr1.card1));
        list.add(new Pr1(R.drawable.pic4,"Assorted","Rs. 50",Pr1.card2));
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


}
