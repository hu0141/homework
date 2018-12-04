package com.hik.hyy.service.impl;

import org.springframework.stereotype.Service;

import com.hik.hyy.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{

//	@Autowired
//	private DeviceMapper deviceMapper;
//	@Autowired
//	private UserMapper userMapper;
//
//	@Override
//	public List<Device> findAllDeviceByuId(int uId) throws Exception {
//		if (uId <= 0) {
//			throw new DeviceParamException("设备ID小于0");
//		}
//		return deviceMapper.findAllDeviceByuId(uId);
//	}
//
//	@Override
//	public void insertDev(Device device) throws Exception {
//		if ( null == device || device.getuId() <= 0 || StringUtils.isEmpty(device.getDevName())) {
//			throw new DeviceParamException("设备名称为null");
//		}
//		//1.保存设备
//		device.setCreatTime(new Date());
//		deviceMapper.insertDev(device);
//		//2.更新用户关联的设备数
//		User user = userMapper.findById(device.getuId());
//		int count = deviceMapper.countDevByUId(device.getuId());
//		if (count > Integer.valueOf(user.getDeviceCount())) {
//			user.setDeviceCount(String.valueOf(count));
//			userMapper.updateUser(user);
//		}
//	}
//
//	@Override
//	public List<Device> searchDev(Device device) throws Exception {
//		if (null == device || device.getId() < 0 ) {
//			throw new DeviceParamException("设备为null或者ID小于0");
//		}
//		List<Device> list = deviceMapper.searchDev(device);
//		return list;
//	}
//
//	@Override
//	public Device findById(int id) throws Exception {
//		if (id <= 0) {
//			throw new DeviceParamException("设备为null或者ID小于0");
//		}
//		return deviceMapper.findById(id);
//	}
//
//	@Override
//	public void updateDev(Device device) throws Exception {
//		if (null == device || device.getuId() < 0 || device.getId() < 0 || org.apache.commons.lang3.StringUtils.isEmpty(device.getDevName())) {
//			throw new DeviceParamException("设备名称为null");
//		}
//		
//		Device nativeDev = deviceMapper.findById(device.getId());
//		nativeDev.setCreatTime(new Date());
//		if (!StringUtils.isEmpty(device.getDevName())) {
//			nativeDev.setDevName(device.getDevName());
//		}
//		if (!StringUtils.isEmpty(device.getRemark())) {
//			nativeDev.setRemark(device.getRemark());
//		}
//		deviceMapper.updateDev(nativeDev);
//	}
//
//	@Override
//	public int deleteById(int id) throws Exception {
//		if (id < 0) {
//			throw new DeviceParamException("设备为null或者ID小于0");
//		}
//		//1.找出该设备
//		Device nativeDev = deviceMapper.findById(id);
//		if (null == nativeDev) {
//			throw new DeviceParamException("未找到该设备");
//		}
//		//2.删除设备
//		deviceMapper.deleteById(id);
//		//3.更新用户的关联数目
//		User user = userMapper.findById(nativeDev.getuId());
//		int count = Integer.valueOf(user.getDeviceCount()) - 1;
//		user.setDeviceCount(String.valueOf(count));
//		userMapper.updateUser(user);
//		return nativeDev.getuId();
//	}

}
