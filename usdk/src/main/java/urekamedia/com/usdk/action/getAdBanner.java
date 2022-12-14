package urekamedia.com.usdk.action;

import org.jetbrains.annotations.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import urekamedia.com.usdk.api.ApiService;
import urekamedia.com.usdk.interfaces.iBanner;
import urekamedia.com.usdk.model.adBanner;
import urekamedia.com.usdk.model.adInSong;
import urekamedia.com.usdk.utils.Constants;

public class getAdBanner {

    public static void getInsong(final String ktv_id, final String device_id, final int times, final String song_id, @Nullable final iBanner callback) {
        String ktvId = Constants.PREFIX + ktv_id;
        String deviceId = Constants.PREFIX + device_id;

        ApiService.apiservice.getAdBanner(Constants.PARTNER_ID, ktvId, deviceId, times, song_id, Constants.VERSIONS).enqueue(new Callback<adBanner>() {
            @Override
            public void onResponse(Call<adBanner> call, Response<adBanner> response) {
                adBanner banner = response.body();
                if (banner != null) {
                    String type = banner.getType_ads();
                    adInSong inSong = new adInSong();
                    String position = banner.getPosition_type();
                    inSong.setTime_show(banner.getTime_show());
                    inSong.setHeight(banner.getHeight());
                    inSong.setWidth(banner.getWidth());
                    if (type.equals("video")) {
                        inSong.setBanner_url(banner.getVast_xml());
                        inSong.setType_ads("video");
                        inSong.setPosition("top_right");
                    }else{
                        if (position.equals("1")) {
                            inSong.setPosition("center");
                        }else{
                            inSong.setPosition("top_right");
                        }
                        inSong.setBanner_url(banner.getBanner_url());
                        inSong.setType_ads("banner");
                    }
                    callback.onSuccess(inSong);
                }
            }
            @Override
            public void onFailure(Call<adBanner> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
