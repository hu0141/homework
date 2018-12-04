package com.hik.hyy.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hik.hyy.dao.UserRepository;
import com.hik.hyy.entity.User;
import com.hik.hyy.exception.impl.RepeatNameException;
import com.hik.hyy.exception.impl.UserParamException;
import com.hik.hyy.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private final static ExecutorService threadPool = Executors.newCachedThreadPool();
	private final static int ARRAY_MAX_NUM = 10;  //分组的默认值大小
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void insertUser(User user) throws Exception {
		if (null == user || StringUtils.isEmpty(user.getUserName())) {
			throw new UserParamException("用户姓名不能为空");
		}
		User nativeUser = userRepository.findUserByuserName(user.getUserName(), null);
		if (null != nativeUser) {
			throw new RepeatNameException(nativeUser.getUserName() + " 描述信息：" + nativeUser.getRemark());
		}
		
		user.setCreateTime(new Date());
		user.setDeviceCount("0");
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		if (null == user || StringUtils.isEmpty(user.getUserName())) {
			throw new UserParamException("用户姓名不能为空");
		}
		//1.判断更改后的名字是否同名
		User nativeUser = userRepository.findUserByuserName(user.getUserName(), user.getuId());
		if (null != nativeUser) {
			throw new RepeatNameException(nativeUser.getUserName() + " 描述信息：" + nativeUser.getRemark());
		}
		//2.更新原有的对象
		nativeUser = userRepository.findById(user.getuId());
		nativeUser.setCreateTime(new Date());
		nativeUser.setUserName(user.getUserName());
		nativeUser.setRemark(user.getRemark());
		userRepository.save(nativeUser);
	}

	@Override
	public User findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public void deleteById(int id) throws Exception {
		if (0 >= id) {
			throw new UserParamException("用户uId异常");
		}
		userRepository.deleteById(id);
//		userRepository.deleteByUId(id);
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAllUser();
	}

	@Override
	public List<User> searchUser(User user) throws Exception {
		if (null == user) {
			throw new UserParamException("搜索信息为null");
		}
		return userRepository.searchUser(user.getUserName(), user.getRemark());
	}

	@Override
	public void batchDeleteUser(String[] ids) {
		if (ArrayUtils.isEmpty(ids)) {
			return;
		}
		String[] subId = new String[ARRAY_MAX_NUM];
		int length = ids.length;
		int num = 0;
		//1.处理超过默认值大小的批次
		while(length > ARRAY_MAX_NUM){
			subId = Arrays.copyOfRange(ids, num * ARRAY_MAX_NUM, (num + 1) * ARRAY_MAX_NUM);
			executeThread(subId, num);
			num++;
			length = length - ARRAY_MAX_NUM;
		}
		//2.处理上面余数或者小于默认值大小的批次
		subId = Arrays.copyOfRange(ids, num * ARRAY_MAX_NUM, ids.length);
		executeThread(subId, num);
	}
	private void executeThread(String[] subId, int sort){
		threadPool.execute(() -> {
			Stream.of(subId).forEach(id->{
				if (!StringUtils.isEmpty(id)) {
					try {
						deleteById(Integer.parseInt(id));
					} catch (Exception e) {
						logger.error(e.getMessage());
					}
					logger.info("批量删除：删除第{}组的用户，用户uId={}", sort + 1, id);
				}
			});
		});
	}

}
