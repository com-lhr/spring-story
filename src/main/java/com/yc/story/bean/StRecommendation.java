package com.yc.story.bean;

import java.io.Serializable;
import java.util.Date;

public class StRecommendation implements Serializable {
    private Integer id;

    private Integer bId;
    
    private StBook stBook;

    private Date recomtime;

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

    public Date getRecomtime() {
        return recomtime;
    }

    public void setRecomtime(Date recomtime) {
        this.recomtime = recomtime;
    }

	public StBook getStBook() {
		return stBook;
	}

	public void setStBook(StBook stBook) {
		this.stBook = stBook;
	}
}