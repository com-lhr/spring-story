package com.yc.story.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = {"handler","comments"})
public class StBook implements Serializable {

    private Integer id;

    private String bFace;

    private Date bTime;

    private Integer bCategory;

    private String bPosition;

    private String bIntroduce;

    private Integer bNum;

    private Integer bCount;

    private Integer bStatus;

    private Float bPrice;

    private String bName;

    private String bAuthor;

    private Integer bReadcnt;

    private Integer bCommcount;
    
    private StCategory stCategory;
    
    private List<String> chapter;
        

    public List<String> getChapter() {
		return chapter;
	}

	public void setChapter(List<String> chapter) {
		this.chapter = chapter;
	}



	private List<StComment> comments;
      
    public List<StComment> getComments() {
		return comments;
	}

	public void setComments(List<StComment> comments) {
		this.comments = comments;
	}
	
	
		

	public StCategory getStCategory() {
		return stCategory;
	}

	public void setStCategory(StCategory stCategory) {
		this.stCategory = stCategory;
	}



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

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor == null ? null : bAuthor.trim();
    }

    public Integer getbReadcnt() {
        return bReadcnt;
    }

    public void setbReadcnt(Integer bReadcnt) {
        this.bReadcnt = bReadcnt;
    }

    public Integer getbCommcount() {
        return bCommcount;
    }

    public void setbCommcount(Integer bCommcount) {
        this.bCommcount = bCommcount;
    }

	@Override
	public String toString() {
		return "StBook [id=" + id + ", bFace=" + bFace + ", bTime=" + bTime + ", bCategory=" + bCategory
				+ ", bPosition=" + bPosition + ", bIntroduce=" + bIntroduce + ", bNum=" + bNum + ", bCount=" + bCount
				+ ", bStatus=" + bStatus + ", bPrice=" + bPrice + ", bName=" + bName + ", bAuthor=" + bAuthor
				+ ", bReadcnt=" + bReadcnt + ", bCommcount=" + bCommcount + ", stCategory=" + stCategory + ", chapter="
				+ chapter + ", comments=" + comments + "]";
	}

}