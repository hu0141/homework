package com.hik.hyy.enums;

import org.apache.commons.lang3.StringUtils;


/***********************************************************************
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @ClassName: DBEnum 
 * @Description: 保存用户名和密码的枚举类 
 * @author huyuyuan
 * @date 2018年9月11日 下午2:15:09  
 ***********************************************************************/
public enum DBEnum{
	
	UserPwd1("admin", "hik12345+"),
	UserPwd2("admin", "Abc12345");
	
	private String userName;   //用户名
	private String password;   //密码
	
	DBEnum(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	/** 
	* @Description:  根据用户名获取登录密码
	* @param @param userName
	* @param @return    
	* @return String
	* @author: huyuyuan
	* @date: 2018年9月11日 下午2:16:02  
	* @throws 
	*/
	public static String getPassword(String userName){
		for(DBEnum db : DBEnum.values() ){
			if (StringUtils.equals(db.getUserName(), userName)) {
				return db.getPassword();
			}
		}
		return null;
	}
	
	/** 
	* @Description:  根据用户名获取枚举对象
	* @param @param userName
	* @param @return    
	* @return DBEnum
	* @author: huyuyuan
	* @date: 2018年9月11日 下午2:16:20  
	* @throws 
	*/
	public static DBEnum getEnum(String userName){
		for (DBEnum db : DBEnum.values()) {
			if (StringUtils.equals(db.getUserName(), userName)) {
				return db;
			}
		}
		return null;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

