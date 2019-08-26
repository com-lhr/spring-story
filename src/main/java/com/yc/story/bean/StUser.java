package com.yc.story.bean;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;


public class StUser implements Serializable {
    private Integer id;

    @NotEmpty(message="用户名不能为空")
    @Length(min=2,max=6,message="用户名长度必须在2~6")
    private String uName;

	@NotEmpty(message="手机号不能为空")
	@Pattern(regexp="^\\d{11}$",message="手机号格式不正确")
    private String uTel;
    
    @NotEmpty(message="邮箱地址不能为空")
    @Email(message="邮箱地址不正确")
    private String uEmail;
   
    private Integer tickets;
    
    @Length(min=6,max=12,message="密码长度必须在6~12")
    @NotEmpty(message="密码不能为空")
    private String uPwd;

    private Integer integral;

    private Integer level;

    private String uIntroduction;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel == null ? null : uTel.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd == null ? null : uPwd.trim();
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getuIntroduction() {
        return uIntroduction;
    }

    public void setuIntroduction(String uIntroduction) {
        this.uIntroduction = uIntroduction == null ? null : uIntroduction.trim();
    }
}