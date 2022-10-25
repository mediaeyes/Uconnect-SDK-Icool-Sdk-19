package urekamedia.com.usdk.model;

public class adBanner {
    private int id;
    private String position;
    private int position_type;
    private int position_x;
    private int position_y;
    private int width;
    private int height;
    private int status;
    private int type_ads;
    private String code_unit;
    private String code_position;
    private int time_show;
    private int time;
    private String device;
    private int sendPostDevice;

    public adBanner(int id, String position, int position_type, int position_x, int position_y, int width, int height, int status, int type_ads, String code_unit, String code_position, int time_show, int time, String device, int sendPostDevice) {
        this.id = id;
        this.position = position;
        this.position_type = position_type;
        this.position_x = position_x;
        this.position_y = position_y;
        this.width = width;
        this.height = height;
        this.status = status;
        this.type_ads = type_ads;
        this.code_unit = code_unit;
        this.code_position = code_position;
        this.time_show = time_show;
        this.time = time;
        this.device = device;
        this.sendPostDevice = sendPostDevice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPosition_type() {
        return position_type;
    }

    public void setPosition_type(int position_type) {
        this.position_type = position_type;
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

    public String getCode_unit() {
        return code_unit;
    }

    public void setCode_unit(String code_unit) {
        this.code_unit = code_unit;
    }

    public String getCode_position() {
        return code_position;
    }

    public void setCode_position(String code_position) {
        this.code_position = code_position;
    }

    public int getTime_show() {
        return time_show;
    }

    public void setTime_show(int time_show) {
        this.time_show = time_show;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public int getSendPostDevice() {
        return sendPostDevice;
    }

    public void setSendPostDevice(int sendPostDevice) {
        this.sendPostDevice = sendPostDevice;
    }
}
