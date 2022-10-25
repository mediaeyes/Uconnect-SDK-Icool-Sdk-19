package urekamedia.com.usdk.action;

import org.jetbrains.annotations.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import urekamedia.com.usdk.api.ApiService;
import urekamedia.com.usdk.interfaces.iLuckyDraw;
import urekamedia.com.usdk.model.adLuckyDraw;

public class getLuckyDraw {
    public static void get(String ktv_id, String deviceid, String song_id, boolean auto, @Nullable final iLuckyDraw callback) {
//        callLuckyDraw(ktv_id, deviceid, song_id, auto, callback);
    }

    public static void callLuckyDraw(String ktv_id, String deviceid, String song_id, boolean auto, @Nullable final iLuckyDraw callback) {
        ApiService.apiservice.getluckydraw(ktv_id, deviceid, song_id, auto).enqueue(new Callback<adLuckyDraw>() {

            @Override
            public void onResponse(Call<adLuckyDraw> call, Response<adLuckyDraw> response) {
                adLuckyDraw luckyDraw = response.body();
                if(luckyDraw!= null) {
                    callback.onSuccess(luckyDraw);
                }
            }

            @Override
            public void onFailure(Call<adLuckyDraw> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
