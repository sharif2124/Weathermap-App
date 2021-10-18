package com.example.weathermapapp;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataServices {

    //end url=data/2.5/forecast/daily?q=Dhaka&APPID=62f6de3f7c0803216a3a13bbe4ea9914&CNT=7;

    @GET("data/2.5/forecast/daily")
    Callback<DailyForecast> getDailyForecast(@Query("q") String city,@Query("APPID") String apikey,@Query("CNT")int cnt);
}
