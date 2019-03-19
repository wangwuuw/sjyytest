package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.test.service.impl.RedisServiceImpl;

public class RedisTest {
	@Autowired
	private RedisServiceImpl redisServiceImpl;
}
