package urekamedia.com.usdk.interfaces;

import urekamedia.com.usdk.model.adVideoPreroll;

public interface iVideo {
    void onSuccess(adVideoPreroll videoPreroll);
    void onError(Throwable t);
}
