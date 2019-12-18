package com.kazishihan.viewpagerprac.Retrofit;



import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface LatstNewsService {

    @GET
    Call<JsonObject> getTypeData(@Url String url);

}
