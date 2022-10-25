package urekamedia.com.usdk.model;

public class adLuckyDraw {
    public adLuckyDraw(boolean status, String banner, int timeout, int is_win) {
        this.status = status;
        this.banner = banner;
        this.timeout = timeout;
        this.is_win = is_win;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public int getIs_win() {
        return is_win;
    }

    public void setIs_win(int is_win) {
        this.is_win = is_win;
    }

    private boolean status;
    private String banner;
    private int timeout;
    private int is_win;
}
