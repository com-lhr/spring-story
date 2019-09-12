package com.yc.story.bean;

import java.io.Serializable;

public class StCategory implements Serializable {
    private Integer id;

    private String caName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName == null ? null : caName.trim();
    }
}