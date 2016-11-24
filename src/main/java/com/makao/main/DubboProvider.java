package com.makao.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProvider {
	private  static final Log log = LogFactory.getLog(DubboProvider.class);
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/application-context.xml"});  
			context.start();
		} catch (BeansException e) {
			log.error("==DubboProvider context start error:",e);
		}  
		synchronized (DubboProvider.class) {
			while(true){
				try{
					DubboProvider.class.wait();
				}catch(InterruptedException e){
					log.error("==Synchronized error:", e);
				}
			}
		}
	}

}
