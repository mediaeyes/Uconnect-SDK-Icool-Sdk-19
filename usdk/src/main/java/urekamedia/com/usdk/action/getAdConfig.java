package urekamedia.com.usdk.action;

import org.jetbrains.annotations.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import urekamedia.com.usdk.api.ApiService;
import urekamedia.com.usdk.interfaces.iDefaultBanner;
import urekamedia.com.usdk.interfaces.iVideo;
import urekamedia.com.usdk.model.adConfig;
import urekamedia.com.usdk.model.adDefaultScreen;
import urekamedia.com.usdk.model.adVideoPreroll;
import urekamedia.com.usdk.utils.Constants;

public class getAdConfig {

    public static void getConfig(final String ktv_id, final String device_id, final int position, final String type_show ,final int times, @Nullable final iDefaultBanner callback) {
        String ktvId = Constants.PREFIX + ktv_id;
        String deviceId = Constants.PREFIX + device_id;
        ApiService.apiservice.getAdConfig(Constants.PARTNER_ID, ktvId, deviceId, position, type_show, times, Constants.VERSIONS).enqueue(new Callback<adConfig>() {
            @Override
            public void onResponse(Call<adConfig> call, Response<adConfig> response) {
                adConfig config = response.body();
                if (config != null) {
                    String type = config.getType_ads();
                    if (type.equals("banner")) {
                        adDefaultScreen defaultBanner = new adDefaultScreen();
                        defaultBanner.setType_ads(type);
                        defaultBanner.setTime_show(config.getTime_show());
                        defaultBanner.setBanner_url(config.getBanner_url());
                        defaultBanner.setIssetItem(config.getIssetItem());
                        defaultBanner.setSound(config.getSound());
                        callback.onSuccess(defaultBanner);
                    } else if (type.equals("video")) {
                        adDefaultScreen defaultBanner = new adDefaultScreen();
                        defaultBanner.setType_ads(type);
                        defaultBanner.setTime_show(config.getTime_show());
                        defaultBanner.setBanner_url(config.getVast_xml());
                        defaultBanner.setIssetItem(config.getIssetItem());
                        defaultBanner.setSound(config.getSound());
                        callback.onSuccess(defaultBanner);
                    } else {
                        adDefaultScreen defaultBanner = new adDefaultScreen();
                        defaultBanner.setType_ads(type);
                        callback.onSuccess(defaultBanner);
                    }
                }
            }
            @Override
            public void onFailure(Call<adConfig> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public static void getConfigVideo(final String ktv_id, final String device_id, @Nullable final iVideo callback) {
        String ktvId = Constants.PREFIX + ktv_id;
        String deviceId = Constants.PREFIX + device_id;
        ApiService.apiservice.adVideoPreroll(Constants.PARTNER_ID, ktvId, deviceId, Constants.VERSIONS).enqueue(new Callback<adVideoPreroll>() {

            @Override
            public void onResponse(Call<adVideoPreroll> call, Response<adVideoPreroll> response) {
                adVideoPreroll video = response.body();
                if(video != null){
                    adVideoPreroll videoPreroll = new adVideoPreroll();
                    videoPreroll.setTime_show(video.getTime_show());
                    videoPreroll.setSound(video.getSound());
                    videoPreroll.setVast_xml(video.getVast_xml());
                    videoPreroll.setIssetItem(video.getIssetItem());
                    callback.onSuccess(videoPreroll);
                }
            }

            @Override
            public void onFailure(Call<adVideoPreroll> call, Throwable t) {
                callback.onError(t);
            }
        });
    }


}
