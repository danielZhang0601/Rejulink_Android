package com.rejulink.beans;

/**
 * Created by danielzhang on 15/7/17.
 */
public class Camera {
    private String name;
    private String description;
    private String imagePath;
    private String owner;
    private String sn;
    private String version;

    public Camera() {
        this.name = "";
        this.description = "";
        this.imagePath = "";
        this.owner = "";
        this.sn = "";
        this.version = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
