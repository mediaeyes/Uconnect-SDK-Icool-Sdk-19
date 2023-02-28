package urekamedia.com.usdk.model;

public class adVideoPreroll {
    private int id;
    private String ktv_id;
    private String device;
    private String position_type;
    private String position_align;
    private String position_x;
    private String position_y;
    private String width;
    private String height;
    private String time_show;
    private String type_ads;
    private String vast_xml;
    private String status;
    private int issetItem;
    private int sound;

    public int getIssetItem() {
        return issetItem;
    }

    public void setIssetItem(int issetItem) {
        this.issetItem = issetItem;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public adVideoPreroll() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKtv_id() {
        return ktv_id;
    }

    public void setKtv_id(String ktv_id) {
        this.ktv_id = ktv_id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getPosition_type() {
        return position_type;
    }

    public void setPosition_type(String position_type) {
        this.position_type = position_type;
    }

    public String getPosition_align() {
        return position_align;
    }

    public void setPosition_align(String position_align) {
        this.position_align = position_align;
    }

    public String getPosition_x() {
        return position_x;
    }

    public void setPosition_x(String position_x) {
        this.position_x = position_x;
    }

    public String getPosition_y() {
        return position_y;
    }

    public void setPosition_y(String position_y) {
        this.position_y = position_y;
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

    public String getTime_show() {
        return time_show;
    }

    public void setTime_show(String time_show) {
        this.time_show = time_show;
    }

    public String getType_ads() {
        return type_ads;
    }

    public void setType_ads(String type_ads) {
        this.type_ads = type_ads;
    }

    public String getVast_xml() {
        return vast_xml;
    }

    public void setVast_xml(String vast_xml) {
        this.vast_xml = vast_xml;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public adVideoPreroll(int id, String ktv_id, String device, String position_type, String position_align, String position_x, String position_y, String width, String height, String time_show, String type_ads, String vast_xml, String status, int issetItem, int sound) {
        this.id = id;
        this.ktv_id = ktv_id;
        this.device = device;
        this.position_type = position_type;
        this.position_align = position_align;
        this.position_x = position_x;
        this.position_y = position_y;
        this.width = width;
        this.height = height;
        this.time_show = time_show;
        this.type_ads = type_ads;
        this.vast_xml = vast_xml;
        this.status = status;
        this.issetItem = issetItem;
        this.sound = sound;
    }
}
