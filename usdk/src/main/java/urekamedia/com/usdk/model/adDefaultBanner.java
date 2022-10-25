package urekamedia.com.usdk.model;

public class adDefaultBanner {
    private String banner;
    private int timeout;

    public adDefaultBanner(String banner, int timeout) {
        this.banner = banner;
        this.timeout = timeout;
    }

    public adDefaultBanner() {

    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
