package urekamedia.com.usdk.interfaces;

import urekamedia.com.usdk.model.adInSong;

public interface iBanner {
    void onSuccess(adInSong inSong);
    void onError(Throwable t);
}
