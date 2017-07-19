package com.example.acer.funmofoapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.acer.funmofoapp.Adapters.BannerViewPagerAdapter;
import com.example.acer.funmofoapp.Adapters.ProductViewItemAdapter;
import com.example.acer.funmofoapp.Data.Product;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private BannerViewPagerAdapter imageViewPagerAdapter;
    private TabLayout dotTabLayout;
    private ArrayList<Integer> bannerImagesID;
    private int currentPos = 1;

    private CountDownTimer timer;

    private RelativeLayout rlMore;

    private RecyclerView recentlyViewRecycler;
    private ProductViewItemAdapter productItemAdapter;
    private ArrayList<Product> productList;

    private ArrayList<Product> topProductsList;
    private ProductViewItemAdapter topProductItemAdapter;
    private RecyclerView topProductRecycler;
    private int offset=2;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rlMore= (RelativeLayout) view.findViewById(R.id.rlMore);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        dotTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        recentlyViewRecycler = (RecyclerView) view.findViewById(R.id.recently_view_recycler);
        topProductRecycler=(RecyclerView) view.findViewById(R.id.top_product_recycler);

        rlMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager mgr=getActivity().getSupportFragmentManager();
                FragmentTransaction trans=mgr.beginTransaction();
                trans.replace(R.id.fragment,new TopFragment());
                trans.commit();

            }
        });

        timer = new CountDownTimer(3 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                //do nothing
            }

            @Override
            public void onFinish() {
                viewPager.setCurrentItem(currentPos + 1);
            }
        };

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //for banner on top of homefragment

        bannerImagesID = new ArrayList<>();

        bannerImagesID.add(R.drawable.banner2);
        bannerImagesID.add(R.drawable.banner4);
        bannerImagesID.add(R.drawable.banner1);
        bannerImagesID.add(R.drawable.banner3);

        for (int i = 0; i < bannerImagesID.size(); i++) {
            dotTabLayout.addTab(dotTabLayout.newTab(), i);
        }

        //necessary for circular banner rotation
        bannerImagesID.add(0, bannerImagesID.get(bannerImagesID.size() - 1));
        bannerImagesID.add(bannerImagesID.size(), bannerImagesID.get(1));


        imageViewPagerAdapter = new BannerViewPagerAdapter(bannerImagesID, getActivity());
        viewPager.setAdapter(imageViewPagerAdapter);



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                timer.cancel();


                if (position == 0) {
                    currentPos = 4;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setCurrentItem(currentPos,false);
                        }
                    },300);



                } else if (position == 5) {
                    currentPos = 1;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setCurrentItem(currentPos,false);
                        }
                    },300);

                } else {
                    currentPos = position;
                }
                dotTabLayout.getTabAt(currentPos - 1).select();

                timer.start();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setCurrentItem(1);
        timer.start();




        //recently view list Item

        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.pic3, "Durex Condoms", "₹130","₹150"));
        productList.add(new Product(R.drawable.pic4, "Ansell Lifestyles", "₹120","₹130"));
        productList.add(new Product(R.drawable.pic5, "Skore Condoms", "₹210",""));
        productList.add(new Product(R.drawable.pic6, "Skins Condoms", "₹100","₹120"));

        productItemAdapter = new ProductViewItemAdapter(productList,"recent");

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recentlyViewRecycler.setLayoutManager(horizontalLayoutManager);
        recentlyViewRecycler.setItemAnimator(new DefaultItemAnimator());
        recentlyViewRecycler.setAdapter(productItemAdapter);


        //top products list item

        topProductsList= new ArrayList<>();
        topProductsList.add(new Product(R.drawable.pic3, "Durex Condoms", "₹130","₹150"));
        topProductsList.add(new Product(R.drawable.pic7, "Ansell Lifestyles", "₹120","₹130"));
        topProductsList.add(new Product(R.drawable.pic5, "Skore Condoms", "₹210",""));
        topProductsList.add(new Product(R.drawable.pic6, "Skins Condoms", "₹100",""));
        topProductsList.add(new Product(R.drawable.pic9, "Durex Condoms", "₹130","₹150"));
        topProductsList.add(new Product(R.drawable.pic4, "Ansell Lifestyles", "₹120","₹130"));

        topProductItemAdapter = new ProductViewItemAdapter(topProductsList,"top");

        GridLayoutManager gridLayoutManagerManager = new GridLayoutManager(getActivity(),2);
        topProductRecycler.setItemAnimator(new DefaultItemAnimator());
        topProductRecycler.setLayoutManager(gridLayoutManagerManager);

        topProductRecycler.setAdapter(topProductItemAdapter);


    }


}


