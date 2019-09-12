package com.yc.story.bean;

import java.io.Serializable;

public class StCc implements Serializable {
    private Integer id;

    private Integer myCommid;

    private Integer otherCommid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMyCommid() {
        return myCommid;
    }

    public void setMyCommid(Integer myCommid) {
        this.myCommid = myCommid;
    }

    public Integer getOtherCommid() {
        return otherCommid;
    }

    public void setOtherCommid(Integer otherCommid) {
        this.otherCommid = otherCommid;
    }
}