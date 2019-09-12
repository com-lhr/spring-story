package com.yc.story.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"handler"})
public class StCollection implements Serializable {
	
	
    @Override
	public String toString() {
		return "StCollection [id=" + id + ", uId=" + uId + ", bId=" + bId + ", cStatus=" + cStatus + ", stBook="
				+ stBook + ", stUser=" + stUser + ", cTime=" + cTime + ", cRecord=" + cRecord + "]";
	}

	private Integer id;

    private Integer uId;

    private Integer bId;

    private Integer cStatus;

    private StBook stBook;
    
    private StUser stUser;
    
    private Date cTime;
    
    private Integer cRecord;
    
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

	public StBook getStBook() {
		return stBook;
	}

	public void setStBook(StBook stBook) {
		this.stBook = stBook;
	}

	public StUser getStUser() {
		return stUser;
	}

	public void setStUser(StUser stUser) {
		this.stUser = stUser;
	}

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
}