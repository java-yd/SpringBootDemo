package com.yd.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class IndexController {
	
	@RequestMapping("hello")
	public  String   hello(){
		log.info("使用占位符{}", "info");
		log.error("使用占位符{}", "error");
		log.debug("使用占位符{}", "debug");
		log.warn("使用占位符{}", "warn");
		return  "word";
	}
	
	/**
	 * HashMap并发问题，第一个线程进来，马上出去时，第二个线程进来，把线程1的值覆盖了
	 * @param v1
	 * @param v2
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping("thread")
	public  Map    thread(String  v1,String  v2) throws InterruptedException{
		log.info("进来线程："+Thread.currentThread().getName());
		Map<String,String>  map = new  HashMap<>();
		map.put("v1", v1);
		map.put("v2", v2);
		log.info("出去线程："+Thread.currentThread().getName()+"---"+map.get("v1"));
		return  map;
	}
	
	@RequestMapping("thread2")
	public   Map  thread2(String  v1,String  v2) throws InterruptedException{
		log.info("进来线程："+Thread.currentThread().getName());
		ConcurrentHashMap<String,String>  map = new  ConcurrentHashMap<>();
		map.put("v1", v1);
		map.put("v2", v2);
		log.info("出去线程："+Thread.currentThread().getName()+"---"+map.get("v1"));
		
		return  map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
