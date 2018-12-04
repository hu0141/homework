package com.hik.hyy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hik.hyy.dao.UserRepository;
import com.hik.hyy.entity.User;
import com.hik.hyy.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	/**
	 * 显示用户列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAllUser")
	public ModelAndView findAllDevice() throws Exception{
		List<User> list = userService.findAllUser();
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("userList", list);
		modelAndView.setViewName("userList");
		
		return modelAndView;
	}
	
	/** 
	* @Description:  根据用户的姓名和描述信息查找用户
	* @param @param user
	* @author: huyuyuan
	* @date: 2018年9月13日 上午11:12:37  
	* @throws 
	*/
	@RequestMapping("/searchUser")
	public ModelAndView searchUser(User user, Model model) throws Exception{
		List<User> list = userService.searchUser(user);
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("userList", list);
		modelAndView.setViewName("userList");
		return modelAndView;
	}
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertUser")
	public String insertUser(User user) throws Exception{
		userService.insertUser(user);
		return "redirect:/user/findAllUser.action";
	}
	
	/**
	 * 根据用户ID查找用户
	 * @param reuqest
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findUserById")
	public String findUserById(HttpServletRequest reuqest, 
			 Model model) throws Exception{
		String userId = reuqest.getParameter("uId");
		User user = null;
		if (!StringUtils.isEmpty(userId)) {
			user = userService.findById(Integer.parseInt(userId));
		}
		model.addAttribute("user", user);
		return "editUser";
	}
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser")
	public String updateUser(User user) throws Exception {
		userService.updateUser(user);
		return "successU";
	}
	/**
	 * 根据用户Id
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(int uId) throws Exception {
		userService.deleteById(uId);
		return "redirect:/user/findAllUser.action";
	}
	
	/** 
	* @Description:  批量删除用户
	* @param @param ids
	* @author: huyuyuan
	* @date: 2018年9月13日 上午11:13:25  
	* @throws 
	*/
	@RequestMapping("/batchDeleteUser")
	public String batchDeleteUser(String[] ids) throws Exception {
		userService.batchDeleteUser(ids);
		return "redirect:/user/findAllUser.action";
	}
}
