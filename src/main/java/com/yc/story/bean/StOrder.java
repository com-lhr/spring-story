package com.yc.story.bean;

import java.io.Serializable;
import java.util.Date;

public class StOrder implements Serializable {
    private Integer id;

    private Date oTime;

    private Integer bId;

    private Integer uId;

    private Integer oStatus;

    private Float oAmount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getoStatus() {
        return oStatus;
    }

    public void setoStatus(Integer oStatus) {
        this.oStatus = oStatus;
    }

    public Float getoAmount() {
        return oAmount;
    }

    public void setoAmount(Float oAmount) {
        this.oAmount = oAmount;
    }
}