package zyh.com.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkHttp {

    private Retrofit retrofit;
    private static NetWorkHttp netWorkHttp;

    private NetWorkHttp() {
        init();
    }

    public static NetWorkHttp instance(){
        if (netWorkHttp==null) {
            netWorkHttp = new NetWorkHttp();
        }
        return netWorkHttp;
    }


    private void init(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//打印请求参数，请求结果

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://172.17.8.100/small/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T create(Class<T> service){
        return retrofit.create(service);
    }

}
