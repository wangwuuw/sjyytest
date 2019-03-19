package com.test.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.test.service.RedisService;


@Service
public class RedisServiceImpl implements RedisService {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public void setString(String key, String str) {
		stringRedisTemplate.opsForValue().set(key, str);
	}

	@Override
	public String getString(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	@Override
	public void setObject(String key, Object str) {
		redisTemplate.opsForValue().set(key, str);
	}

	@Override
	public Object getObject(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	@Override
	public String getStringListleftPop(String key){
		return (String)redisTemplate.opsForList().leftPop(key);
	}
	
	@Override
	public void setStringList(String key,String value){
		redisTemplate.opsForList().rightPush(key, value);
	}
	
	

	/**
	 * @methodDesc: 功能描述:(设置该key值的过期时间)
	 * @author: 张帝中
	 * @param key
	 *            key值
	 * @param timeout
	 *            过期时间
	 * @param unit
	 *            过期时间单位
	 * @return 是否设置成功
	 * @createTime:2017年5月26日 下午8:11:50
	 * @copyright:善林(上海)金融信息服务有限公司
	 */
	@Override
	public Boolean expire(String key, long timeout, TimeUnit unit) {
		return stringRedisTemplate.expire(key, timeout, unit);
	}

	public Boolean expire1(String key, long timeout, TimeUnit unit) {
		return redisTemplate.expire(key, timeout, unit);
	}
	/**
	 * @methodDesc: 功能描述:(查询该key值离过期时间还有多少秒)
	 * @author: 张帝中
	 * @param key
	 *            key值
	 * @return 离过期时间还有多少秒
	 * @createTime:2017年5月26日 下午8:08:32
	 * @copyright:善林(上海)金融信息服务有限公司
	 */
	@Override
	public Long getExpire(String key) {
		return stringRedisTemplate.getExpire(key);
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(根据key删除)
	 * @author: 李俊威
	 * @param: @param
	 *             key
	 * @createTime:2017年5月31日 下午2:40:34
	 * @returnType:@param key void
	 * @copyright:善林(上海)金融信息服务有限公司
	 */
	public void delete(String key) {
		stringRedisTemplate.delete(key);
	}

	  
	        /*  
	        *(non-Javadoc)  
	        * @see com.shanlin.linstore.service.RedisService#setListString(java.lang.String, java.lang.String)  
	        */  
	    
	@Override
	public void setListString(String key, String value) {
		stringRedisTemplate.opsForList().rightPush(key, value);
	}

}
