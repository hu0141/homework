package com.hik.hyy.utils;

import org.springframework.util.DigestUtils;


/***********************************************************************
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @ClassName: MessageDigestUtil 
 * @Description: 加密密码的工具类（使用单例模式） 
 * @author huyuyuan
 * @date 2018年9月11日 下午2:18:23  
 ***********************************************************************/
public class MessageDigestUtil {

	private static volatile MessageDigestUtil messageDigestUtil;
	
	private MessageDigestUtil(){}
	
	public synchronized static MessageDigestUtil getInstance(){
		if (null == messageDigestUtil) {
			messageDigestUtil = new MessageDigestUtil();
		}
		return messageDigestUtil;
	}
	
	public String md5Hex(String message){
		return DigestUtils.md5DigestAsHex(message.getBytes());
	}
}
