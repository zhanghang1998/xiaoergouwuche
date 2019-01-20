package zyh.com.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Http02 {

    private Retrofit retrofit;
    private static Http02 netWorkHttp;

    private Http02() {
        init();
    }

    public static Http02 instance(){
        if (netWorkHttp==null) {
            netWorkHttp = new Http02();
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
                .baseUrl("http://www.zhaoapi.cn/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T create02(final Class<T> service){
        return retrofit.create(service);
    }

}
