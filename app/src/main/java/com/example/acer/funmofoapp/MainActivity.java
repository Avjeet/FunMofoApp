package com.example.acer.funmofoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final long total_time= 30*60*1000;
    private static final long time_tick= 1000;

    private TextView tvtitle;
    FragmentTransaction trans;
    private FragmentManager mgr;

    private FloatingActionButton productTrckbtn;

    private CountDownTimer timer;

    private TextView notifyTextBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvtitle=(TextView)findViewById(R.id.tv_title);

        notifyTextBadge=(TextView) findViewById(R.id.notify_no);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
       // drawer.setDrawerListener(toggle);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

         mgr=getSupportFragmentManager();
        trans=mgr.beginTransaction();
        trans.replace(R.id.fragment,new HomeFragment());
        trans.addToBackStack("Home");
        trans.commit();


        productTrckbtn=(FloatingActionButton) findViewById(R.id.fltrack);




        timer= new CountDownTimer(total_time,time_tick) {

            @Override
            public void onTick(long l) {
                long progress = (l*100)/total_time;

                productTrckbtn.setProgress((int)progress,false);
                Log.w("time:",String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(l),TimeUnit.MILLISECONDS.toSeconds(l)-TimeUnit.MILLISECONDS.toMinutes(l)*60));
                productTrckbtn.setLabelText(String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(l),TimeUnit.MILLISECONDS.toSeconds(l)-TimeUnit.MILLISECONDS.toMinutes(l)*60));

            }

            @Override
            public void onFinish() {

            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        timer.start();

    }

    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        else{
                //  super.onBackPressed();
                new android.app.AlertDialog.Builder(this)
                        .setMessage("Are you really want to exit ??")
                        .setNegativeButton("CANCEL", null)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface arg0, int arg1) {
                                MainActivity.super.onBackPressed();
                                finish();
                            }
                        }).create().show();
            }

    }*/



    @Override
    public void onBackPressed() {

        List fragmentList = getSupportFragmentManager().getFragments();

        boolean handled = false;
        for(Object f : fragmentList) {
            if(f instanceof BaseFragment) {
                handled = ((BaseFragment)f).onBackPressed();

                if(handled) {
                    break;
                }
            }
        }

        if(!handled) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack("Home",FragmentManager.POP_BACK_STACK_INCLUSIVE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new HomeFragment()).commit();
            } else {

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    //  super.onBackPressed();
                    new android.app.AlertDialog.Builder(this)
                            .setMessage("Are you really want to exit ??")
                            .setNegativeButton("CANCEL", null)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface arg0, int arg1) {
                                    MainActivity.super.onBackPressed();
                                    finish();
                                }
                            }).create().show();
                }
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        FragmentManager mgr=getSupportFragmentManager();
        FragmentTransaction trans=mgr.beginTransaction();

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
         if (id == R.id.cart) {
             tvtitle.setText("Cart");

              trans.replace(R.id.fragment,new CartFillFragment());
             trans.addToBackStack(null);
              trans.commit();
        }
        else
            if(id==R.id.wishlist)
            {
                tvtitle.setText("Wishlist");
              trans.replace(R.id.fragment,new WishlistFillFragment());
                trans.addToBackStack(null);
              trans.commit();
            }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager mgr=getSupportFragmentManager();
        FragmentTransaction trans=mgr.beginTransaction();

        if (id == R.id.home) {
            tvtitle.setText(" ");
           trans.replace(R.id.fragment,new HomeFragment());
            trans.commit();

        } else if (id == R.id.about) {

        } else if (id == R.id.top) {
            tvtitle.setText("Top Products");
            trans.replace(R.id.fragment,new TopFragment());
            trans.commit();


        }

        else if (id == R.id.wishlist2) {
            tvtitle.setText("Wishlist");
            trans.replace(R.id.fragment,new WishlistFillFragment());
            trans.addToBackStack(null);
            trans.commit();

        } else if (id == R.id.cart2) {

            tvtitle.setText("Cart");

            trans.replace(R.id.fragment,new CartFillFragment());
            trans.addToBackStack(null);
            trans.commit();

        } else if(id == R.id.orders){
            Intent i1=new Intent(MainActivity.this,MyOrderActivity.class);
//            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i1);
//            finish();

        } else if(id == R.id.contact_us){

        } else if(id == R.id.account){
            Intent i1=new Intent(MainActivity.this,MyAccountActivity.class);
//            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i1);
//            finish();

        } else if(id == R.id.password){
            Intent i1=new Intent(MainActivity.this,ChangePasswordActivity.class);
//            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i1);
//            finish();

        } else if(id == R.id.logout){
            Intent i1=new Intent(MainActivity.this,SignInActivity.class);
//            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i1);
//            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
