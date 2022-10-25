package urekamedia.com.usdk.action;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import urekamedia.com.usdk.BannerActivity;
import urekamedia.com.usdk.UrekaSdk;
import urekamedia.com.usdk.api.ApiService;
import urekamedia.com.usdk.interfaces.iBanner;
import urekamedia.com.usdk.interfaces.iDefaultBanner;
import urekamedia.com.usdk.model.adBanner;
import urekamedia.com.usdk.model.adDefaultBanner;
import urekamedia.com.usdk.model.adInSong;
import urekamedia.com.usdk.utils.Constants;

public class getAdBanner {
    public static void init(int time, String id) {
        getBanner(time, id);
    }

    public static void getBanner(int time, String android_id) {
        ApiService.apiservice.getAdBanner(time, android_id).enqueue(new Callback<adBanner>() {

            @Override
            public void onResponse(Call<adBanner> call, Response<adBanner> response) {
                adBanner banner = response.body();
                if(banner!= null) {
                    methodStartActivity(banner);
                }
            }

            @Override
            public void onFailure(Call<adBanner> call, Throwable t) {
                Log.d("TAG-adConfig-onFailure", "onFailure: "+t.getMessage());
                Toast.makeText(UrekaSdk.getContext(),"Error request Banner API ",Toast.LENGTH_LONG).show();
            }
        });
    }

    public static void getBannerAds(final String ktv_id, String android_id, int time, @Nullable final iBanner callback){
        ApiService.apiservice.getAdBanner(time, android_id).enqueue(new Callback<adBanner>() {

            @Override
            public void onResponse(Call<adBanner> call, Response<adBanner> response) {
                adBanner banner = response.body();
                if(banner!= null) {
                    String url = getUrl(banner, ktv_id);
                    adInSong adinsong = new adInSong();
                    adinsong.setPosition(banner.getPosition());
                    adinsong.setBanner(url);
                    adinsong.setWidth(banner.getWidth());
                    adinsong.setHeight(banner.getHeight());
                    adinsong.setTime(banner.getTime());
                    adinsong.setTime_show(banner.getTime_show());
                    callback.onSuccess(adinsong);
                }
            }

            @Override
            public void onFailure(Call<adBanner> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public static void callDefaultBanner(String ktv_id, String deviceid, String song_id, @Nullable final iDefaultBanner callback){

        try {
            int time_show = 10;
            String url = Constants.BANNER_URL + Constants.API_ROUTE_BANNER + "?ktvads=1&position=8&ktv_id="+ktv_id+"&deviceid="+deviceid;
            adDefaultBanner defaultBanner = new adDefaultBanner();
            defaultBanner.setTimeout(time_show);
            defaultBanner.setBanner(url);

            callback.onSuccess(defaultBanner);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public static void methodStartActivity(adBanner banner) {
        Context context = UrekaSdk.getContext();
        Intent intent = new Intent(context, BannerActivity.class);
        intent = initialize(intent, banner);
        context.startActivity(intent);
    }

    public static Intent initialize(Intent intent, adBanner banner){
        intent.putExtra("ID", banner.getId());
        intent.putExtra("position", banner.getPosition());
        intent.putExtra("position_type", banner.getPosition_type());
        intent.putExtra("position_x", banner.getPosition_x());
        intent.putExtra("position_y", banner.getPosition_y());
        intent.putExtra("width", banner.getWidth());
        intent.putExtra("height", banner.getHeight());
        intent.putExtra("status", banner.getStatus());
        intent.putExtra("type_ads", banner.getType_ads());
        intent.putExtra("code_unit", banner.getCode_unit());
        intent.putExtra("code_position", banner.getCode_position());
        intent.putExtra("time_show", banner.getTime_show());
        intent.putExtra("device", banner.getDevice());
        intent.putExtra("sendPostDevice", banner.getSendPostDevice());
        return intent;
    }

    public static String getUrl(adBanner banner, String ktv_id){
        String url = "";
        if(banner != null){
            url = Constants.BANNER_URL + Constants.API_ROUTE_BANNER +
                    "?time_show=" +banner.getTime_show()+
                    "&deviceid=" +banner.getDevice()+
                    "&position=" +banner.getId()+
                    "&width=" +banner.getWidth()+
                    "&height=" +banner.getHeight()+
                    "&ktvads=" +banner.getType_ads()+
                    "&ktv_id="+ ktv_id;
        }
        return url;
    }
}
