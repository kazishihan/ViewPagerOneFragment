package com.kazishihan.viewpagerprac.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private static final String BASE_URL="https://www.rtvonline.com/";

    //private static final String BASE_URL="http://admin.service.gov.bd/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
