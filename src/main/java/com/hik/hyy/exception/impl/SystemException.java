package com.hik.hyy.exception.impl;

import com.hik.hyy.exception.BaseException;

/***********************************************************************
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 * @ClassName: SystemException 
 * @Description: 自定义系统异常
 * @author huyuyuan
 * @date 2018年9月12日 下午5:18:30  
 ***********************************************************************/
public class SystemException extends BaseException {

	private static final long serialVersionUID = -7098664252079435071L;

	public SystemException() {
		super("系统错误，请与系统管理员联系！");
		setPath(null);
	}

	@Override
	public String getBackPath() {
		return getPath();
	}

}
