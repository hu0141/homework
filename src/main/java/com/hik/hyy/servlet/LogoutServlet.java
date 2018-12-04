package com.hik.hyy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.hik.hyy.constant.CommonConstant;
import com.hik.hyy.enums.DBEnum;


/***********************************************************************
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @ClassName: LogoutServlet 
 * @Description: 登出请求处理 
 * @author huyuyuan
 * @date 2018年9月11日 下午7:30:00  
 ***********************************************************************/
@WebServlet(name="logoutServlet", urlPatterns="/logoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.清除会话
		HttpSession session = request.getSession();
		DBEnum dbEnum = (DBEnum) session.getAttribute(CommonConstant.LOGIN_SESSION);
		if (null != dbEnum) {
			session.removeAttribute(CommonConstant.LOGIN_SESSION);
		}
		//2.清除Cookie
		Cookie[] cookies = request.getCookies();
		for(Cookie logoutCookie : cookies) {
			if (StringUtils.equals(CommonConstant.LOGIN_COOKIE, logoutCookie.getName())) {
				logoutCookie.setPath(CommonConstant.COOKIE_PATH);
				logoutCookie.setMaxAge(0);
				response.addCookie(logoutCookie);
				break;
			}
		}
		//3.跳往登录页面
		response.sendRedirect("/homework/login.jsp");
	}

}
