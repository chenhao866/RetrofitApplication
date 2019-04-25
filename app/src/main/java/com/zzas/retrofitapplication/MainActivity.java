package com.zzas.retrofitapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button get_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_one=findViewById(R.id.get_one);
        get_one.setOnClickListener(this);
    }


    //天气预报接口的GET请求示例
    protected void Get_one(String city,String key){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.juhe.cn")//基础URL
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RxJava 适配器
                .build();
        WeatherService rxjavaService = retrofit.create(WeatherService .class);//WeatherService自己定义的接口类
//        get请求01
//                rxjavaService .getQuery(city,key)
//        get请求02
//                Map<String,String> myMap = new HashMap<>();
//                myMap.put("city",city);
//                myMap.put("key",key);
//                rxjavaService .getMap(myMap)
//        post请求01
//                rxjavaService .postField(city,key)
//        post请求02
                Map<String,String> myMap = new HashMap<>();
                myMap.put("city",city);
                myMap.put("key",key);
                rxjavaService .postMap(myMap)
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .subscribe(new DisposableObserver<WeatherEntity>() {
                    @Override
                    public void onNext(WeatherEntity weatherEntity){//获取数据后执行;WeatherEntity为自己定义的数据类
                        String str = "Reason"+":"+weatherEntity.getReason()+"\n"
                                    +"Error_code"+":"+weatherEntity.getError_code()+"\n"
                                +"City"+":"+weatherEntity.getResult().getCity()+"\n"
                                +"City"+":"+weatherEntity.getResult().getCity()+"\n";
                        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                        Log.e("获取数据后执行", "获取数据后执行");
                    }
                    @Override
                    public void onError(Throwable t) {
                        Log.e("线程错误时执行", "线程错误时执行");
                    }
                    @Override
                    public void onComplete() {//线程完成后执行
                        Log.e("线程完成后执行", "线程完成后执行" );
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v.equals(get_one)){
            Get_one("北京","3fc07c72e7f27a09aa5cfb098017fdb6");
        }
    }
}
