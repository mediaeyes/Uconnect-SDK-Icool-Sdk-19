package urekamedia.com.usdk.interfaces;

import urekamedia.com.usdk.model.adDefaultScreen;

public interface iDefaultBanner {
    void onSuccess(adDefaultScreen defaultBanner);
    void onError(Throwable t);
}
