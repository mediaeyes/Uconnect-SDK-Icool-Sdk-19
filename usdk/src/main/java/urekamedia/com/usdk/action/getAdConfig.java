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
import urekamedia.com.usdk.model.adVideo;
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
                        callback.onSuccess(defaultBanner);
                    } else if (type.equals("video")) {
                        adDefaultScreen defaultBanner = new adDefaultScreen();
                        defaultBanner.setType_ads(type);
                        defaultBanner.setTime_show(config.getTime_show());
                        defaultBanner.setBanner_url(config.getVast_xml());
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

    public static void getConfigVideo(final String ktv_id, final String device_id, final int position, final String type_show ,final int times, @Nullable final iVideo callback) {
        String ktvId = Constants.PREFIX + ktv_id;
        String deviceId = Constants.PREFIX + device_id;
        ApiService.apiservice.getAdConfig(Constants.PARTNER_ID, ktvId, deviceId, position, type_show, times, Constants.VERSIONS).enqueue(new Callback<adConfig>() {
            @Override
            public void onResponse(Call<adConfig> call, Response<adConfig> response) {
                adConfig config = response.body();
                if (config != null) {
                    String type = config.getType_ads();
                    if (type.equals("video")) {
                        adVideo adVideo = new adVideo();
                        adVideo.setTime_show(config.getTime_show());
                        adVideo.setBanner_url(config.getVast_xml());
                        callback.onSuccess(adVideo);
                    }else{
                        adVideo adVideo = new adVideo();
                        adVideo.setTime_show("0");
                        adVideo.setBanner_url("");
                        callback.onSuccess(adVideo);
                    }
                }
            }

            @Override
            public void onFailure(Call<adConfig> call, Throwable t) {
                callback.onError(t);
            }
        });
    }


}
