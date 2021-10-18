package com.example.weathermapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for handelar
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        DataServices dataServices=retrofit.create(DataServices.class);
        Call<DailyForecast> call= (Call<DailyForecast>) dataServices.getDailyForecast("Dhaka","62f6de3f7c0803216a3a13bbe4ea9914",7);

        call.enqueue(new Callback<DailyForecast>() {
            @Override
            public void onResponse(Call<DailyForecast> call, Response<DailyForecast> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "ss", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DailyForecast> call, Throwable t) {

            }
        });
    }
}