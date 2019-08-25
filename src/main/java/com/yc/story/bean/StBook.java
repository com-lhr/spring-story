package com.yc.story.bean;

import java.io.Serializable;
import java.util.Date;

public class StBook implements Serializable {
    private Integer id;

    // 图片地址
    private String bFace;

    private Date bTime;

    private Integer bCategory;

    private String bPosition;

    private String bIntroduce;

    private Integer bNum;

    private Integer bCount;

    private Integer bStatus;

    private Float bPrice;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getbFace() {
        return bFace;
    }

    public void setbFace(String bFace) {
        this.bFace = bFace == null ? null : bFace.trim();
    }

    public Date getbTime() {
        return bTime;
    }

    public void setbTime(Date bTime) {
        this.bTime = bTime;
    }

    public Integer getbCategory() {
        return bCategory;
    }

    public void setbCategory(Integer bCategory) {
        this.bCategory = bCategory;
    }

    public String getbPosition() {
        return bPosition;
    }

    public void setbPosition(String bPosition) {
        this.bPosition = bPosition == null ? null : bPosition.trim();
    }

    public String getbIntroduce() {
        return bIntroduce;
    }

    public void setbIntroduce(String bIntroduce) {
        this.bIntroduce = bIntroduce == null ? null : bIntroduce.trim();
    }

    public Integer getbNum() {
        return bNum;
    }

    public void setbNum(Integer bNum) {
        this.bNum = bNum;
    }

    public Integer getbCount() {
        return bCount;
    }

    public void setbCount(Integer bCount) {
        this.bCount = bCount;
    }

    public Integer getbStatus() {
        return bStatus;
    }

    public void setbStatus(Integer bStatus) {
        this.bStatus = bStatus;
    }

    public Float getbPrice() {
        return bPrice;
    }

    public void setbPrice(Float bPrice) {
        this.bPrice = bPrice;
    }
}