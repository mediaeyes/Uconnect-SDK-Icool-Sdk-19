package urekamedia.com.usdk.interfaces;

import urekamedia.com.usdk.model.adVideo;

public interface iVideo {
    void onSuccess(adVideo defaultBanner);
    void onError(Throwable t);
}
