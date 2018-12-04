package com.hik.hyy.queue;

import java.util.Set;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ItemQueue extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemQueue.class);
	private static final BlockingQueue<TestEvent> queue = new LinkedBlockingQueue<TestEvent>();
	private Vector<String> set = new Vector<>();
	
	
	
	
	
	
}
