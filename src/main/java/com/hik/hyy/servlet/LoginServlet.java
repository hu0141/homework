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
import com.hik.hyy.utils.MessageDigestUtil;
/***********************************************************************
 * HIK所有，<br/>
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。<br/>
 *
 * @ClassName: LoginServlet 
 * @Description: 登录界面的逻辑处理
 * @author huyuyuan
 * @date 2018年9月11日 下午2:13:14  
 ***********************************************************************/
@WebServlet(name="loginServlet", urlPatterns="/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter(CommonConstant.USERNAME);   //用户名
		String password = request.getParameter(CommonConstant.PASSWORD);	  //密码
		Integer loginTime = Integer.parseInt(request.getParameter(CommonConstant.LOGIN_TIME));    //自动登录的有效时长
		//1.校验用户名和密码
		if (!checkUser(username, password)) {
			request.setAttribute(CommonConstant.MESSAGE, "用户名或密码错误");
			request.getRequestDispatcher("/static/loginError.jsp").forward(request, response);
			return;
		}
		
		//2.设置回话
		HttpSession session = request.getSession();
		session.setAttribute(CommonConstant.LOGIN_SESSION, DBEnum.getEnum(username));
		
		//3.自动登录设置
		if (null != loginTime) {
			Cookie loginCookie = new Cookie(CommonConstant.LOGIN_COOKIE, username + "+" + MessageDigestUtil.getInstance().md5Hex(DBEnum.getPassword(username)));
			loginCookie.setPath(CommonConstant.COOKIE_PATH);
			loginCookie.setMaxAge(loginTime);
			response.addCookie(loginCookie);
		}
		
		//4.跳到用户列表
		request.getRequestDispatcher("/user/findAllUser.action").forward(request, response);
	}
	
	/** 
	* @Description:  校验用户名和密码是否正确
	* @param @param username 用户名
	* @param @param password 密码
	* @param @return    
	* @return boolean 正确则返回 true
	* @author: huyuyuan
	* @date: 2018年9月11日 下午2:14:18  
	* @throws 
	*/
	private boolean checkUser(String username, String password){
		if (StringUtils.isAnyEmpty(username, password)) {
			return false;
		}
		if (StringUtils.equals(DBEnum.getPassword(username), password)) {
			return true;
		}
		return false;
	}

}
