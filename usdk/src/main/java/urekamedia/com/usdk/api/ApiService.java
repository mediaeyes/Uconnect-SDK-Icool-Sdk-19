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
import urekamedia.com.usdk.model.adVideoPreroll;
import urekamedia.com.usdk.service.NetworkConnectionInterceptor;
import urekamedia.com.usdk.utils.Constants;

public interface ApiService {
    RestClient rc = new RestClient();
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-DD HH:mm:ss")
            .create();

    ApiService apiservice = new Retrofit.Builder()
            .baseUrl(Constants.DELIVERY)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(rc.getClient())
            .build()
            .create(ApiService.class);

    @GET(Constants.API_ROUTE_AD_CONFIG)
    Call<adConfig> getAdConfig(
            @Query("partner_id") String partner_id,
            @Query("ktv_id") String ktv_id,
            @Query("codeNumber") String codeNumber,
            @Query("position") int position,
            @Query("type_show") String type_show,
            @Query("times") int times,
            @Query("version") String version
    );

    @GET(Constants.API_ROUTE_AD_BANNER)
    Call<adBanner> getAdBanner(
            @Query("partner_id") String partner_id,
            @Query("ktv_id") String ktv_id,
            @Query("codeNumber") String codeNumber,
            @Query("times") int times,
            @Query("song_id") String song_id,
            @Query("version") String version
    );

    @GET(Constants.API_ROUTE_VIDEO_PREROLL)
    Call<adVideoPreroll> adVideoPreroll(
            @Query("partner_id") String partner_id,
            @Query("ktv_id") String ktv_id,
            @Query("codeNumber") String codeNumber,
            @Query("version") String version
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
