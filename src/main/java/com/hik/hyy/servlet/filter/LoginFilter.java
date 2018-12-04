package com.hik.hyy.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.hik.hyy.constant.CommonConstant;
import com.hik.hyy.enums.DBEnum;
import com.hik.hyy.utils.MessageDigestUtil;

/***********************************************************************
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @ClassName: 登录请求过滤器 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author huyuyuan
 * @date 2018年9月11日 下午3:12:12  
 ***********************************************************************/
//@WebFilter(filterName="loginFilter", servletNames="loginServlet")
public class LoginFilter implements Filter {

    public LoginFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		//1.判断用户是否已经登录了
		HttpSession session = httpRequest.getSession();
		if (null != session.getAttribute(CommonConstant.LOGIN_SESSION)) { //已经登录则放行
			chain.doFilter(httpRequest, httpResponse);
			request.getRequestDispatcher("/user/findAllUser.action").forward(httpRequest, httpResponse);
			return ;
		}
		
		//2.判断用户是否设置了有效期
		Cookie[] cookies = httpRequest.getCookies();
		if (null == cookies) {
			return;
		}
		String cookieValue = null;
		for(Cookie cookie : cookies){
			if (StringUtils.equals(cookie.getName(), CommonConstant.LOGIN_COOKIE)) { //获取value值
				cookieValue = cookie.getValue();
				break;
			}
		}
		//3.判断cookie是否正确
		if (null != cookieValue) {
			String[] result = cookieValue.split("\\+");
			String username = result[0];
			String password = result[1];
			if (StringUtils.equals(password, MessageDigestUtil.getInstance().md5Hex(DBEnum.getPassword(username)))) {//如果密码正确
				session.setAttribute(CommonConstant.LOGIN_SESSION, DBEnum.getEnum(username));
				request.getRequestDispatcher("/user/findAllUser.action").forward(httpRequest, httpResponse);
				return;
			}
		}
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {}
	
}
