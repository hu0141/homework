package com.hik.hyy.exception.impl;

import com.hik.hyy.exception.BaseException;

/***********************************************************************
 *
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @ClassName: RepeatNameException 
 * @Description: 自定义用户姓名重复异常 
 * @author huyuyuan
 * @date 2018年9月13日 上午9:54:53  
 ***********************************************************************/
public class RepeatNameException extends BaseException {

	private static final long serialVersionUID = -2037509172894222020L;
	private static final String path = "user/findAllUser.action";
	
	public RepeatNameException(String message) {
		super("用户姓名重复！重名用户：" + message);
		setPath(path);
	}

	@Override
	public String getBackPath() {
		return getPath();
	}
}
