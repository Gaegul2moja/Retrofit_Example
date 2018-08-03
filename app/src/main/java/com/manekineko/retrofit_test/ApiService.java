package com.manekineko.retrofit_test;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    public static final String API_URL="http://jsonplaceholder.typicode.com";

    @GET("/posts/{postId}")
    Call<Data> getComment(@Path("postId") String postId);


    @POST("/posts")
    Call<Data> getPostComment(@Body PutData putData);
//        //Body->통신을 통해 전송하는 값이 특정 JSON형식일 때 형태를 매번 만들지 않고 객체를 통해서 넘겨주는 방식


//    @GET("/posts/{userId}")
//    Call<ResponseBody>getFirst(@Path("userId")String id);
}
