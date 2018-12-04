package com.hik.hyy.exception;

/***********************************************************************
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @ClassName: ICoreException 
 * @Description: 自定义错误异常类 
 * @author huyuyuan
 * @date 2018年9月12日 下午4:14:53  
 ***********************************************************************/
public abstract class BaseException extends Exception {

	private static final long serialVersionUID = -628615082049268338L;
	private String message;
	private String path;
	
	public BaseException(String message) {
		super(message);
		this.message = message;
	}
	/** 
	* @Description:  返回上一级的路径信息，由具体的子类来实现
	* @param     
	* @return void
	* @author: huyuyuan
	* @date: 2018年9月12日 下午4:17:05  
	* @throws 
	*/
	public abstract String getBackPath();
	
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
