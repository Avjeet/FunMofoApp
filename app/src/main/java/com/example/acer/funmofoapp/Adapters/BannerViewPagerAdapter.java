package com.example.acer.funmofoapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.acer.funmofoapp.R;

import java.util.ArrayList;

/**
 * Created by AVJEET on 08-07-2017.
 */

public class BannerViewPagerAdapter extends PagerAdapter {

    private final Activity context;
    private LayoutInflater layoutInflater;
    private ArrayList<Integer> images ;
    private ImageView imageView;



    public BannerViewPagerAdapter(ArrayList<Integer> imagesID, Activity context) {
        super();
        this.images=imagesID;
        this.context=context;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.image_banner,container,false);
        imageView = (ImageView)view.findViewById(R.id.imageBannerView);

        imageView.setImageResource(images.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
