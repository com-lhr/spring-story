
package com.yc.story.bean;

import java.io.Serializable;
import java.util.Date;

public class StCollection implements Serializable {
    private Integer id;

    private Integer uId;

    private Integer bId;

    private Integer cStatus;

    private Date cTime;

    private Integer cRecord;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Integer getcRecord() {
        return cRecord;
    }

    public void setcRecord(Integer cRecord) {
        this.cRecord = cRecord;
    }

}