package com.manekineko.retrofit_test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;


import java.io.IOException;
import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    ApiService apiService;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Info> infoArrayList;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        infoArrayList = new ArrayList<>();
        Call<Data> comment;


        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(ApiService.API_URL).build();
        apiService = retrofit.create(ApiService.class);
        //final Call<Data> comment = apiService.getComment("1");
        //***********************************************************************************
        int i=1;
        for(int j=0;j<100;j++){
            comment = apiService.getComment(i+"");
            comment.enqueue(new Callback<Data>() {
                @Override
                public void onResponse(Call<Data> call, Response<Data> response) {
                    //Log.e("TEST  ", response.body().getBody());
                    adapter.update(new Info(Info.TYPE1, response.body()));
                }
                @Override
                public void onFailure(Call<Data> call, Throwable t) {
                }
            });
            i++;
        }

        PutData putData = new PutData(1, "hello", "hi");
        apiService.getPostComment(putData).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                adapter.update(new Info(Info.TYPE1, response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<Data> call, Throwable t) {
            }
    });






        adapter = new MyAdapter(new MyAdapter.OnClickListener() {
            @Override
            public void click(Info info) {
                //Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                //intent.putExtra("name", info.name);
                //startActivity(intent);
            }

            @Override
            public void insert() {

            }

            @Override
            public void delete() {

            }
        });
        mRecyclerView.setAdapter(adapter);
    }
}
