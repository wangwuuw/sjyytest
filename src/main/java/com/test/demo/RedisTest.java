package com.test.demo;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.service.impl.RedisServiceImpl;
@RestController
public class RedisTest {
	@Autowired
	private RedisServiceImpl redisServiceImpl;
	@RequestMapping("/setValue")
	public String setValue(){
		HashMap hashMap = new HashMap();
		hashMap.put("ww", "26");
		hashMap.put("zs", "25");
		redisServiceImpl.setObject("user",hashMap);
		redisServiceImpl.expire1("user", 10, TimeUnit.SECONDS);
		return "设置成功";
	}
	@RequestMapping("/getValue")
	public Object getValue(){
		Object object = redisServiceImpl.getObject("user");
		return object;
	}
	
}
