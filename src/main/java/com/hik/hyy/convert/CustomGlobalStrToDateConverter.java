package com.hik.hyy.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/***********************************************************************
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @ClassName: CustomGlobalStrToDateConverter 
 * @Description: 全局日期格式转换器（yyyy-MM-dd hh:mm:ss）
 * @author huyuyuan
 * @date 2018年9月12日 上午10:43:33  
 ***********************************************************************/
public class CustomGlobalStrToDateConverter implements Converter<String, Date> {
	
	private final static Logger logger =  (Logger) LoggerFactory.getLogger(CustomGlobalStrToDateConverter.class);

	public Date convert(String source) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
			return date;
		} catch (ParseException e) {
			logger.error("转化日期格式错误：{}", e.getMessage());
		}
		return null;
	}

}
