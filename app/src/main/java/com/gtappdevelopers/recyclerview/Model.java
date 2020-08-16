package com.gtappdevelopers.recyclerview;

public class Model {


    public  final int TEXT_TYPE=1;
    public  final int IMAGE_TYPE=2;
    public int type;
    public String message;
    private String name;
    private String url;
    private int img;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Model(int type, String message, String name, String url, int img) {
        this.type = type;
        this.message = message;
        this.name = name;
        this.url = url;
        this.img = img;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
