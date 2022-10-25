package urekamedia.com.usdk;

import static urekamedia.com.usdk.action.getAdBanner.callDefaultBanner;
import static urekamedia.com.usdk.action.getAdBanner.getBannerAds;
import static urekamedia.com.usdk.action.getAdVideo.callAdVideo;
import static urekamedia.com.usdk.action.getLuckyDraw.callLuckyDraw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;

import org.jetbrains.annotations.Nullable;

import urekamedia.com.usdk.action.getAdBanner;
import urekamedia.com.usdk.interfaces.iBanner;
import urekamedia.com.usdk.interfaces.iDefaultBanner;
import urekamedia.com.usdk.interfaces.iLuckyDraw;
import urekamedia.com.usdk.interfaces.iVideo;
import urekamedia.com.usdk.model.adDefaultBanner;
import urekamedia.com.usdk.model.adInSong;
import urekamedia.com.usdk.model.adLuckyDraw;

public class UrekaSdk {
    private static Context mContext;

    private static int times = 0;

    public static void init(Context context) {
        setContext(context);
        final String android_id = getDeviceId(context);
//        final String android_id = "bxokara01";
        times = times+1;
        getAdBanner.init(1, android_id);
    }

    public static void getBanner(String ktv_id, String deviceid, String songId, int times, Context context, @Nullable final iBanner callback){
        setContext(context);
        getBannerAds(ktv_id, deviceid, times, new iBanner(){

            @Override
            public void onSuccess(adInSong result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable t) {
                callback.onError(t);
            }
        });
    }

    public static void getLuckyDraw(String ktv_id, String deviceid, String song_id, boolean auto, Context context, @Nullable final iLuckyDraw callback) {
        setContext(context);
        callLuckyDraw(ktv_id, deviceid, song_id, auto, new iLuckyDraw(){
            @Override
            public void onSuccess(adLuckyDraw luckyDraw) {
                callback.onSuccess(luckyDraw);
            }

            @Override
            public void onError(Throwable t) {
                callback.onError(t);
            }
        });
    }

    public static void getDefaultBanner(String ktv_id, String deviceid, String song_id, Context context, @Nullable final iDefaultBanner callback){
        callDefaultBanner(ktv_id, deviceid, song_id, new iDefaultBanner(){

            @Override
            public void onSuccess(adDefaultBanner defaultBanner) {
                callback.onSuccess(defaultBanner);
            }

            @Override
            public void onError(Exception e) {
                callback.onError(e);
            }
        });
    }

    public static void getvideo(String ktv_id, String deviceid, String song_id, Context context, @Nullable final iVideo callback){
        callAdVideo(ktv_id, deviceid, song_id, new iVideo(){

            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Exception e) {
                callback.onError(e);
            }
        });
    }

    public static Context getContext(){
        return mContext;
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    public static String getDeviceId(Context context) {

        @SuppressLint("HardwareIds") String id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return id;
    }
}
