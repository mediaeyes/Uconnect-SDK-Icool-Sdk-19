package urekamedia.com.usdk.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import urekamedia.com.usdk.UrekaSdk;
import urekamedia.com.usdk.model.adBanner;
import urekamedia.com.usdk.model.adConfig;
import urekamedia.com.usdk.model.adLuckyDraw;
import urekamedia.com.usdk.service.NetworkConnectionInterceptor;
import urekamedia.com.usdk.utils.Constants;

public interface ApiService {
    RestClient rc = new RestClient();
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-DD HH:mm:ss")
            .create();

    ApiService apiservice = new Retrofit.Builder()
            .baseUrl(Constants.API_CONFIG)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(rc.getClient())
            .build()
            .create(ApiService.class);

    @GET(Constants.API_ROUTE_AD_CONFIG)
    Call<adConfig> getAdConfig(
            @Query("times") int times,
            @Query("codeNumber") String codeNumber
    );

    @GET(Constants.API_ROUTE_AD_BANNER)
    Call<adBanner> getAdBanner(
            @Query("times") int times,
            @Query("codeNumber") String codeNumber
    );

    @GET(Constants.API_ROUTE_GET_LUCKYDRAW)
    Call<adLuckyDraw> getluckydraw(
            @Query("ktv_id") String ktv_id,
            @Query("deviceid") String deviceid,
            @Query("song_id") String song_id,
            @Query("auto") boolean auto
    );
}

class RestClient {
    public OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new NetworkConnectionInterceptor(UrekaSdk.getContext()))
                .addInterceptor(logging)
                .build();
        return client;
    }
}
