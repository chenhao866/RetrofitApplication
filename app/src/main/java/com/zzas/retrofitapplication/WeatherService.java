package com.zzas.retrofitapplication;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


//调用网络信息的接口
//如果与框架一起使用需要写成Observable<WeatherEntity>，如果是单独使用写成Call<WeatherEntity>;其中WeatherEntity是自定义的数据返回接收类
public interface WeatherService {
    //get请求ps：直接传参
    @GET("/simpleWeather/query")
    Observable<WeatherEntity> getQuery(@Query("city") String city, @Query("key") String key);
    //get多参数请求
    @GET("/simpleWeather/query")
    Observable<WeatherEntity> getMap(@QueryMap Map<String,String> map);

    //post请求
    @FormUrlEncoded
    @POST("/simpleWeather/query")
    Observable<WeatherEntity> postField(@Field("city") String city, @Field("key") String key);

    //post多参数请求
    @FormUrlEncoded
    @POST("/simpleWeather/query")
    Observable<WeatherEntity> postMap(@FieldMap Map<String,String> map);
}
