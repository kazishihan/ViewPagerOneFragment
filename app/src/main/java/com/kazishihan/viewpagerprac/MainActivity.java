package com.kazishihan.viewpagerprac;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.google.gson.JsonObject;
import com.kazishihan.viewpagerprac.Retrofit.LatstNewsService;
import com.kazishihan.viewpagerprac.Retrofit.RetrofitClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 10;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
    }




    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {



            return new BlankFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }





    private void getAllRetroData3() {




        String url="";
        url= String.format("json-feed/latest.json");

        LatstNewsService latstNewsService = RetrofitClass.getRetrofitInstance().create(LatstNewsService.class);
        Call<JsonObject> serviceRespone = latstNewsService.getTypeData(url);
        serviceRespone.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                response.body();

                String s="";

                List<JsonObject> obb=new ArrayList<>();
                for(int i=0;i<response.body().size();i++)
                {


                }
                //RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(,this);

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

                String asbcdf=t.toString();


                String abcd="";
            }
        });



    }
}
