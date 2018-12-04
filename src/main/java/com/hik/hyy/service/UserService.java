package com.hik.hyy.service;

import java.util.List;

import com.hik.hyy.entity.User;

public interface UserService {
	
	/** 
	 * @Description:  根据用户名和用户描述查找用户
	*/
	public List<User> searchUser(User user) throws Exception;
	
	/** 
	 * @Description:  新增用户
	*/
	public void insertUser(User user) throws Exception;
	
	/** 
	 * @Description:  根据用户ID更新用户
	*/
	public void updateUser(User user) throws Exception;
	
	/** 
	* @Description:  根据用户ID批量删除
	*/
	public void batchDeleteUser(String[] ids);

	User findById(Integer id);

	void deleteById(int id) throws Exception;

	List<User> findAllUser();
}
