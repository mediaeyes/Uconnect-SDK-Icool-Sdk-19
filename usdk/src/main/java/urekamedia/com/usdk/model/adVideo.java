package urekamedia.com.usdk.model;

public class adVideo {
    private int id;
    private String device;
    private int position_type;
    private int position_align;
    private int position_x;
    private int position_y;
    private int width;
    private int height;
    private int status;
    private int type_ads;
    private String resolution;
    private int time_show;
    private int sendPostDevice;
    private String adTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public int getPosition_type() {
        return position_type;
    }

    public void setPosition_type(int position_type) {
        this.position_type = position_type;
    }

    public int getPosition_align() {
        return position_align;
    }

    public void setPosition_align(int position_align) {
        this.position_align = position_align;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType_ads() {
        return type_ads;
    }

    public void setType_ads(int type_ads) {
        this.type_ads = type_ads;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getTime_show() {
        return time_show;
    }

    public void setTime_show(int time_show) {
        this.time_show = time_show;
    }

    public int getSendPostDevice() {
        return sendPostDevice;
    }

    public void setSendPostDevice(int sendPostDevice) {
        this.sendPostDevice = sendPostDevice;
    }

    public String getAdTag() {
        return adTag;
    }

    public void setAdTag(String adTag) {
        this.adTag = adTag;
    }

    public adVideo(int id, String device, int position_type, int position_align, int position_x, int position_y, int width, int height, int status, int type_ads, String resolution, int time_show, int sendPostDevice, String adTag) {
        this.id = id;
        this.device = device;
        this.position_type = position_type;
        this.position_align = position_align;
        this.position_x = position_x;
        this.position_y = position_y;
        this.width = width;
        this.height = height;
        this.status = status;
        this.type_ads = type_ads;
        this.resolution = resolution;
        this.time_show = time_show;
        this.sendPostDevice = sendPostDevice;
        this.adTag = adTag;
    }
}
