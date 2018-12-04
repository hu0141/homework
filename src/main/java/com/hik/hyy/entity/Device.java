package com.hik.hyy.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 设备的属性
 * @author Huyuyuan
 *	
 */
@Entity
@Table(name="basic_device")
public class Device implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, length = 11)
	private int id;        	 //设备Id
	
	@Column(name = "u_id", nullable = false, length = 11)
	private int uId;         //关联用户的ID
	
	@Column(name = "dev_name", nullable = false, length = 32)
	private String devName;   //设备名称
	
	@Column(name = "create_time", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createTime;   //设备创建时间
	
	@Column(name = "remark", length = 32)
	private String remark;    //备注
	
	
	public Device() {
		super();
	}
	
	public Device(int uId, String devName, Date createTime, String remark) {
		super();
		this.uId = uId;
		this.devName = devName;
		this.createTime = createTime;
		this.remark = remark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreatTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
