package com.hik.hyy.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "basic_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = -2736912586413112526L;

	@Id
	@GeneratedValue
	@Column(name = "u_id", nullable = false, length = 11)
	public int uId;
	
	@Column(name = "user_name", nullable = false, length = 32)
	private String userName;
	
	@Column(name = "create_time", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createTime;
	
	@Column(name = "device_count", nullable = false, length = 11)
	private String deviceCount;
	
	@Column(name = "remark", length = 255)
	private String remark;
	
	public User() {
		super();
	}
	public User(String userName, Date createTime, String deviceCount, String remark) {
		super();
		this.userName = userName;
		this.createTime = createTime;
		this.deviceCount = deviceCount;
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDeviceCount() {
		return deviceCount;
	}
	public void setDeviceCount(String deviceCount) {
		this.deviceCount = deviceCount;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", userName=" + userName + ", createTime=" + createTime + ", deviceCount="
				+ deviceCount + "]";
	}
	
	
}
