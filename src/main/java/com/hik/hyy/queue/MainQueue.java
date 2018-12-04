package com.hik.hyy.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MainQueue extends Thread{
	
	//日志
	private static final Logger logger = LoggerFactory.getLogger(MainQueue.class);
	//线程安全的阻塞队列
	private static final BlockingQueue<TestEvent> queue = new LinkedBlockingQueue<>(0xFFF);
	//创建一个线程安全的map用以保存每个子类
	private static final ConcurrentHashMap<String, ItemQueue> map = new ConcurrentHashMap<>();
	//引入一个全局对象可以用来发布通知
	@Autowired
	private ApplicationContext applicationContext;
	
	//私有化构造函数
	private MainQueue() {
		logger.info("主事件队列启动");
		this.start();
	}
	//提供一个发布方法，用以外部将事件发到队列中
	public void pushEvent(TestEvent event){
		try {
			queue.put(event);
			//打印日志
			logger.info("加入主队列:[{}]", event.getIndexCode());
		} catch (Exception e) {
			logger.error("加入队列异常：{}", e);
		}
	}
	
	/* (非 Javadoc) 对事件的处理并将事件抛给子队列中
	* <p>Title: run</p> 
	* <p>Description: </p>  
	* @see java.lang.Thread#run() 
	*/
	@Override
	public void run() {
		Thread.currentThread().setName("XXXX主队列");
		
		while(true){
			try {
				final TestEvent event = queue.take();
				String indexCode = event.getIndexCode();
				final String code = indexCode;
				map.compute(code, (k,v)->{
					if(null == v){
//						v = new ItemQueue(code, applicationContext); 
					}
//					v.pushEvent(event);
					return v;
				});
				logger.info("MAIN QUEUE SIZE: {}" ,queue.size());
			} catch (Exception e) {
				logger.error("从队列获取事件异常",e);
			}
		}
		
		
		
		
	}

	
	
}
