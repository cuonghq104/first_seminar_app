package ptit.cuonghq.hny.detail;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    private static Retrofit sInstance;

    public static Retrofit getRetrofit() {
        if (sInstance == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            OkHttpClient okHttpClient = builder.build();

            sInstance = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return sInstance;
    }

}
