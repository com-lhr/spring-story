package com.yc.story.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



import javax.validation.constraints.NotEmpty;





import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"handler"})
public class StComment implements Serializable {
    private Integer id;

    private Integer bId;

    private Integer uId;
    
    @NotEmpty(message= "评论不能为空")
    private String cmContent;

    private Date cmCreatetime;
    
    private List<StComment> sList;
    

    private StUser user;
    //临时储存下一级的用户
    private StUser nextuser;
                 	
	public StUser getNextuser() {
		return nextuser;
	}

	public void setNextuser(StUser nextuser) {
		this.nextuser = nextuser;
	}

	public StUser getUser() {
		return user;
	}

	public void setUser(StUser user) {
		this.user = user;
	}



    public List<StComment> getsList() {

		return sList;
	}

	public void setsList(List<StComment> sList) {
		this.sList = sList;
	}

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

	@Override
	public String toString() {
		return "StComment [id=" + id + ", bId=" + bId + ", uId=" + uId + ", cmContent=" + cmContent + ", cmCreatetime="

				+ cmCreatetime + ", sList=" + sList + ", user=" + user + "]";
	}

   
    
}