package com.hik.hyy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hik.hyy.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	/** 
	* @Description:  查找所有用户，根据时间倒序排序
	* @param @return    
	* @return List<User>
	* @author: huyuyuan
	* @date: 2018年9月12日 下午2:31:54  
	*/
	
	@Query("select u from User u order by u.createTime Desc")
	public List<User> findAllUser();
	
	/** 
	* @Description:  根据用户名和用户描述查找用户
	* @param @param user
	* @param @return    
	* @return List<User>
	* @author: huyuyuan
	* @date: 2018年9月12日 下午2:32:18  
	* @throws 
	*/
	@Query("select u from User u where u.userName like CONCAT('%', :userName, '%') and u.remark like CONCAT('%', :remark, '%') order by u.createTime DESC")
	public List<User> searchUser(@Param("userName")String userName, @Param("remark")String remark);
	
	/** 
	* @Description:  根据用户ID查找用户
	* @param @param id
	* @param @return    
	* @return User
	* @author: huyuyuan
	* @date: 2018年9月12日 下午2:33:36  
	* @throws 
	*/
	@Query("select u from User u where u.uId = :id")
	public User findById(@Param("id")int id);
	
	/** 
	* @Description:  根据用户ID删除用户
	* @param @param id    
	* @return void
	* @author: huyuyuan
	* @date: 2018年9月12日 下午2:33:51  
	* @throws 
	*/
	@Modifying
	@Query("delete from User u where u.uId = :id")
	public void deleteById(@Param("id")int id);
	
	/** 
	* @Description:  根据用户名查找用户
	* @param @param user
	* @param @return    
	* @return User
	* @author: huyuyuan
	* @date: 2018年9月12日 下午2:34:03  
	* @throws 
	*/
	@Query("select u from User u where u.userName = :userName and uId != :uId")
	public User findUserByuserName(@Param("userName")String userName, @Param("uId")Integer uId);
	
	
	
	
	
}
