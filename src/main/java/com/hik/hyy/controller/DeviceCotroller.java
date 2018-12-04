package com.hik.hyy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hik.hyy.entity.Device;
import com.hik.hyy.service.DeviceService;


@Controller
@RequestMapping(value= {"/device"})
public class DeviceCotroller {
	
	@Autowired
	private DeviceService deviceService;
	
	/** 
	* @Description:  根据用户ID查找关联设备并按照时间倒序排序
	* @param @param request
	* @author: huyuyuan
	* @date: 2018年9月13日 上午11:13:48  
	* @throws 
	*/
	@RequestMapping("/findAllDevice")
	public ModelAndView findAllDevice(HttpServletRequest request) throws Exception{
		String uId = request.getParameter("uId");
		List<Device> list = null;
		if (!StringUtils.isEmpty(uId)) {
//			list = deviceService.findAllDeviceByuId(Integer.valueOf(uId));
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("uId", uId);
		modelAndView.addObject("deviceList", list);
		modelAndView.setViewName("deviceList");
		
		return modelAndView;
	}
	
	/** 
	* @Description:  新增设备
	* @param @param device
	* @author: huyuyuan
	* @date: 2018年9月13日 上午11:14:21  
	* @throws 
	*/
	@RequestMapping("/insertDevice")
	public String insertDevice(Device device) throws Exception {
//		deviceService.insertDev(device);
		return "redirect:/device/findAllDevice.action?uId=" + device.getuId();
	}
	
	/** 
	* @Description:  根据设备名称和描述信息查找设备
	* @param @param device
	* @date: 2018年9月13日 上午11:14:32  
	* @throws 
	*/
	@RequestMapping("/searchDevice")
	public ModelAndView searchDevice(Device device) throws Exception {
//		List<Device> deviceList = deviceService.searchDev(device);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("uId", device.getuId());
//		modelAndView.addObject("deviceList", deviceList);
		modelAndView.setViewName("deviceList");
		
		return modelAndView;
	}
	
	/** 
	* @Description:  根据设备ID查找设备
	* @param @param id
	* @author: huyuyuan
	* @date: 2018年9月13日 上午11:15:16  
	* @throws 
	*/
	@RequestMapping("/findDevById")
	public String findDevById(Integer id, Model model) throws Exception {
		Device device = null;
		if (null != id) {
//			device = deviceService.findById(id);
		}
		
		model.addAttribute("device", device);
		return "editDevice";
	}
	
	/** 
	* @Description:  更新设备
	* @param @param device
	* @author: huyuyuan
	* @date: 2018年9月13日 上午11:15:31  
	* @throws 
	*/
	@RequestMapping("/updateDevice")
	public String updateDevice(Device device, Model model) throws Exception {
//		deviceService.updateDev(device);
		model.addAttribute("uId", device.getuId());
		return "successD";
	}
	
	/** 
	* @Description:  根据设备ID删除设备
	* @author: huyuyuan
	* @date: 2018年9月13日 上午11:15:46  
	* @throws 
	*/
	@RequestMapping("/deleteDevice")
	public String deleteDev(Integer id) throws Exception {
//		int uId = deviceService.deleteById(id);
//		return "redirect:/device/findAllDevice.action?uId=" + uId;		
		return null;
	}
	
}
