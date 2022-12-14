package urekamedia.com.usdk;

import android.content.Context;
import org.jetbrains.annotations.Nullable;

import urekamedia.com.usdk.action.getAdBanner;
import urekamedia.com.usdk.action.getAdConfig;
import urekamedia.com.usdk.interfaces.iBanner;
import urekamedia.com.usdk.interfaces.iDefaultBanner;
import urekamedia.com.usdk.interfaces.iVideo;
import urekamedia.com.usdk.model.adDefaultScreen;
import urekamedia.com.usdk.model.adInSong;
import urekamedia.com.usdk.model.adVideo;

public class UrekaSdk {
    private static Context mContext;
    public static Context getContext(){
        return mContext;
    }
    public static void setContext(Context context) {
        mContext = context;
    }

    public static void getDefaultBanner(String ktv_id, String device_id, int times, Context context, @Nullable final iDefaultBanner callback){
        setContext(context);
        int position = 3;
        String type_show = "ktvcenter";
        int time = ( times % 3 ) + 1;
        getAdConfig.getConfig(ktv_id, device_id, position, type_show, time, new iDefaultBanner(){
            @Override
            public void onSuccess(adDefaultScreen defaultBanner) {
                callback.onSuccess(defaultBanner);
            }

            @Override
            public void onError(Throwable t) {
                callback.onError(t);
            }
        });
    }

    public static void getPrerollVideo(String ktv_id, String device_id, Context context, @Nullable final iVideo callback) {
        setContext(context);
        int position = 3;
        String type_show = "ktvcenter";
        int time = 3;

        getAdConfig.getConfigVideo(ktv_id, device_id, position, type_show, time, new iVideo(){

            @Override
            public void onSuccess(adVideo prerollVideo) {
                callback.onSuccess(prerollVideo);
            }

            @Override
            public void onError(Throwable t) {
                callback.onError(t);
            }
        });
    }

    public static void getInsong(String ktv_id, String device_id, int times, String song_id, Context context, @Nullable final iBanner callback){
        setContext(context);
        getAdBanner.getInsong(ktv_id, device_id, times, song_id, new iBanner(){

            @Override
            public void onSuccess(adInSong inSong) {
                callback.onSuccess(inSong);
            }

            @Override
            public void onError(Throwable t) {
                callback.onError(t);
            }
        });
    }
}
