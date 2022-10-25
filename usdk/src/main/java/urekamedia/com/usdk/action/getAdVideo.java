package urekamedia.com.usdk.action;

import org.jetbrains.annotations.Nullable;

import urekamedia.com.usdk.interfaces.iVideo;
import urekamedia.com.usdk.utils.Constants;

public class getAdVideo {
    public static void callAdVideo(String ktv_id, String deviceid, String song_id, @Nullable final iVideo callback){
        try {
            String url = Constants.API_CONFIG + Constants.API_ROUTE_AD_VIDEO + "?ktv_id="+ktv_id+"&deviceid="+deviceid+"&song_id="+song_id;
            callback.onSuccess(url);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
