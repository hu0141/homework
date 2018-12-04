package com.hik.hyy.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.hik.hyy.exception.impl.DeviceParamException;
import com.hik.hyy.exception.impl.RepeatNameException;
import com.hik.hyy.exception.impl.SystemException;
import com.hik.hyy.exception.impl.UserParamException;

/***********************************************************************
 *
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @ClassName: BaseExceptionResolver 
 * @Description: 自定义异常处理器 
 * @author huyuyuan
 * @date 2018年9月12日 下午5:13:44  
 ***********************************************************************/
public class BaseExceptionResolver implements HandlerExceptionResolver{

	private static final Logger logger = LoggerFactory.getLogger(BaseExceptionResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.error("ErrorMessage:{}", ex.getMessage());
		
		BaseException baseException = null;
		if (ex instanceof DeviceParamException) {
			baseException = (DeviceParamException) ex;
		} else if (ex instanceof UserParamException) {
			baseException = (UserParamException) ex;
		} else if (ex instanceof RepeatNameException) {
			baseException = (RepeatNameException) ex;
		} else {
			baseException = (SystemException) ex;
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", baseException.getMessage());
		modelAndView.addObject("path", StringUtils.isEmpty(baseException.getBackPath()) ? "" : baseException.getBackPath());
		modelAndView.setViewName("errorMessage");
		return modelAndView;
	}

}
