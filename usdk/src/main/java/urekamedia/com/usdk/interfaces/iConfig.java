package urekamedia.com.usdk.interfaces;

import urekamedia.com.usdk.model.adConfig;

public interface iConfig {
    void onSuccess(adConfig config);
    void onError(Throwable t);
}
