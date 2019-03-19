package com.test.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
@Service
@EnableAsync
public class AsycnService {
	@Async
    public String add(String s) throws InterruptedException{
		System.out.println(s);
    	Thread.sleep(2000);
		return s+"hello";
    	
    }
}
