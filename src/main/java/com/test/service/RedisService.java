package com.test.service;

import java.util.concurrent.TimeUnit;


/**
 * 
 * @classDesc: 功能描述:(redis工具类封装)
 * @author: 余胜军
 * @createTime: 2017年5月17日 下午6:49:42
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public interface RedisService {

	public void setString(String key, String str);

	public String getString(String key);

	public void setObject(String key, Object str);

	public Object getObject(String key);
	
	public String getStringListleftPop(String key);
	
	public void setStringList(String key, String value);
	

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
	Boolean expire(String key, long timeout, TimeUnit unit);

	/**
	 * @methodDesc: 功能描述:(查询该key值离过期时间还有多少秒)
	 * @author: 张帝中
	 * @param key
	 *            key值
	 * @return 离过期时间还有多少秒
	 * @createTime:2017年5月26日 下午8:08:32
	 * @copyright:善林(上海)金融信息服务有限公司
	 */
	Long getExpire(String key);

	/**
	 * 
	 * @methodDesc: 功能描述:(根据key删除)
	 * @author: 李俊威
	 * @param: @param
	 *             key
	 * @createTime:2017年5月31日 下午2:38:23
	 * @returnType:@param key void
	 * @copyright:善林(上海)金融信息服务有限公司
	 */
	public void delete(String key);
	
	/**
	 * 
			* @methodDesc: 功能描述:(添加redis队列，清除无用乱码)
	        * @author: 徐畅  
			* @param: @param key
			* @param: @param value   
	        * @createTime:2017年7月27日 下午4:57:30
	        * @returnType:@param key
	        * @returnType:@param value void  
			* @copyright:善林科技
	 */
	public void setListString(String key,String value);
}
