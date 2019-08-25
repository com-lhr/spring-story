package com.yc.story.bean;

import java.io.Serializable;
import java.util.Date;

public class StComment implements Serializable {
    private Integer id;

    private Integer bId;

    private Integer uId;

    private String cmContent;

    private Date cmCreatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCmContent() {
        return cmContent;
    }

    public void setCmContent(String cmContent) {
        this.cmContent = cmContent == null ? null : cmContent.trim();
    }

    public Date getCmCreatetime() {
        return cmCreatetime;
    }

    public void setCmCreatetime(Date cmCreatetime) {
        this.cmCreatetime = cmCreatetime;
    }
}