package com.yd;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadTest {

	
	public static void main(String[] args) throws InterruptedException {
		HashMap<String, String> firstHashMap=new HashMap<String, String>();
//		Map<String, String> firstHashMap=new ConcurrentHashMap<>();
		Thread  t1 = new Thread(){
			public void run() {
				for (int i = 0; i < 25; i++) {
					firstHashMap.put(i+"", i+"");
				}
			}
		};
		Thread  t2 = new Thread(){
			public void run() {
				for (int y = 25; y < 50; y++) {
					firstHashMap.put(y+"", y+"");
				}
			}
		};
		t1.start();
		t2.start();
		Thread.currentThread().sleep(1000);
		for (int i = 0; i < 50; i++) {
			 for(int l=0;l<50;l++){
			        //如果key和value不同，说明在两个线程put的过程中出现异常。
			           if(!String.valueOf(l).equals(firstHashMap.get(String.valueOf(l)))){
			               System.err.println(String.valueOf(l)+":"+firstHashMap.get(String.valueOf(l)));
			           }
					 }
		}
		
	}
	
	
}
