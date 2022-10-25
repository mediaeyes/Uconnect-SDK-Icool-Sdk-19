package urekamedia.com.usdk.interfaces;

import urekamedia.com.usdk.model.adLuckyDraw;

public interface iLuckyDraw {
    void onSuccess(adLuckyDraw luckyDraw);
    void onError(Throwable t);
}
