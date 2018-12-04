package com.hik.hyy.exception.impl;

import com.hik.hyy.exception.BaseException;

/***********************************************************************
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 * @ClassName: DeviceParamException 
 * @Description: 自定义设备参数异常 
 * @author huyuyuan
 * @date 2018年9月13日 上午9:54:12  
 ***********************************************************************/
public class DeviceParamException extends BaseException {

	private static final long serialVersionUID = 2076797249253864965L;
	private static final String path = "user/findAllUser.action";
	
	public DeviceParamException(String message) {
		super("设备参数异常！ 异常原因：" + message);
		setPath(path);
	}
	
	@Override
	public String getBackPath() {
		return getPath();
	}

}
