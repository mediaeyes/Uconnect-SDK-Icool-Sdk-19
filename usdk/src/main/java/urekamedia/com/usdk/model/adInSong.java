package urekamedia.com.usdk.model;

public class adInSong {
    private String type_ads;

    public String getType_ads() {
        return type_ads;
    }

    public void setType_ads(String type_ads) {
        this.type_ads = type_ads;
    }

    private String time_show;
    private String position;
    private String vast_xml;
    private String banner_url;
    private String width;
    private String height;
    private int issetItem;

    public int getIssetItem() {
        return issetItem;
    }

    public void setIssetItem(int issetItem) {
        this.issetItem = issetItem;
    }

    public adInSong(String time_show, String position, String vast_xml, String banner_url, String width, String height) {
        this.time_show = time_show;
        this.position = position;
        this.vast_xml = vast_xml;
        this.banner_url = banner_url;
        this.width = width;
        this.height = height;
    }

    public adInSong() {

    }

    public String getTime_show() {
        return time_show;
    }

    public void setTime_show(String time_show) {
        this.time_show = time_show;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getVast_xml() {
        return vast_xml;
    }

    public void setVast_xml(String vast_xml) {
        this.vast_xml = vast_xml;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
