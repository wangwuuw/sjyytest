package com.test.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Array;
import com.test.entity.User;

public class Test1 {
	 private static final String BTC= "BTC,BCH,USDT,LTC";
	public static void main(String[] args) {
		System.out.println(BTC.contains("ETH"));
	}
	/**
	 * 测试动态修改值
	 */
	@Test
    public  void testChangeVariable(){
    	   String str = "abc";
           ArrayList arrayList = new ArrayList();
           arrayList.add(str);
           System.out.println(arrayList.get(0));
    }
    /**
     * 测试数组边界
     */
	@Test
    public  void testList(){
    	ArrayList arrayList = new ArrayList();
    	arrayList.add("a");
    	arrayList.add("b");
    	arrayList.add("c");
    	for (int i = 0; i <arrayList.size(); i++) {
    		arrayList.get(i);
    		if (i==arrayList.size()-1) {
				break;
			}
    		arrayList.get(i+1);
		}
    	
    	
    }
	@Test
    public  void testStringInit(){
    	
    	String str;
    	str = "a";
    	System.out.println(str);
    }
	/**
	 * 比大小
	 */
	@Test
    public void compareBigDecimal(){
    BigDecimal bigDecimal = new BigDecimal("-1");
    BigDecimal bigDecimal2 = new BigDecimal("1");
    System.out.println(bigDecimal.compareTo(bigDecimal2));
    }
	/**
	 * lambda ->去重
	 */
//	stream()
//    .filter(transInfo -> transInfo.getAmount().compareTo(BigDecimal.ZERO) > 0)
//    .forEach(transInfo -> transHandler.receiveNewTrans(assetCode, transInfo));
	@SuppressWarnings("unchecked")
	@Test
    public void lombda(){
		List<User> arrayList = new ArrayList<User>();
		System.out.println(new Integer(2).compareTo(2)>=0);
    	for (int i = 0; i < 5; i++) {
			User user = new User("name"+i,i);
			if (i==1) {
				user = new User("name"+i,null);
			}
			arrayList.add(user);
		}
    	List<User> singleList = new ArrayList<User>();
    	System.out.println();
    	//运行逻辑是满足了过滤条件就走forEach逻辑,为false就是过滤掉
    	arrayList.stream().filter(user -> user.getAge()==null?false:user.getAge().compareTo(2)>=0).forEach(user -> singleList.add(user));
//    	arrayList.stream().filter(user -> user.getAge()==null?false:true).forEach(user -> System.out.println(user.toString()));
    	for (int i = 0; i < singleList.size(); i++) {
    		System.out.println(singleList.get(i).getName());
		}
    
    }
	/**
	 * Set去重
	 */
	
	/**
	 * 测试FASTJSON
	 */
	@Test
	public void testFastJson(){
		String str = "{\"code\":\"100200\",\"data\":[{\"assetCode\":\"ETH\",\"coinAddress\":\"0x382bbd7a51C5b072b10Fba622cF47Dc261FBd66B\",\"createDate\":1542337562000,\"createIp\":\"\",\"delFlag\":\"FALSE\",\"depositPoolId\":1602,\"id\":262,\"name\":\"\",\"uid\":15},{\"assetCode\":\"ETH\",\"coinAddress\":\"testadress\",\"createDate\":1542702522000,\"createIp\":\"0.0.0.0\",\"delFlag\":\"FALSE\",\"depositPoolId\":11111,\"id\":263,\"name\":null,\"uid\":100}],\"msg\":\"成功\"}";
		JSONObject entitys = JSON.parseObject(str);
		JSONArray jsonArray = entitys.getJSONArray("data");
		ArrayList<String> addresses = new ArrayList<String>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject object = (JSONObject) jsonArray.get(i); 
			String coinAddress = object.getString("coinAddress");
			System.out.println(coinAddress);
			addresses.add(coinAddress);
		}
		
	}
//	@Test
//	public void testIfElse(){
//		if (1==1) {
//			System.out.println("1");
//		}else if (1==1) {
//			System.out.println("1");
//		}else if (1==1) {
//			System.out.println("1");
//		}
//	}
	@Test
	public void getGas(){
		BigDecimal bigInteger = new BigDecimal("7000000000");

		BigDecimal bigInteger2 = new BigDecimal("21416");
		BigDecimal bigInteger3 = new BigDecimal("1000000000000000000");
		System.out.println("000000000000000000".length());
		BigDecimal divide = bigInteger.multiply(bigInteger2).divide(bigInteger3);
		System.out.println(divide);
		BigDecimal subtract = bigInteger.subtract(bigInteger2);
		System.out.println(subtract);
	}
	@Test
	public void testArrayList(){
		List<String> collectionEntitys = new ArrayList<String>(3);
		System.out.println(collectionEntitys.size());
	}
	@Test
	public void printArrayList(){
		List<String> collectionEntitys = new ArrayList<String>(3);
		collectionEntitys.add("a");
		collectionEntitys.add("b");
		collectionEntitys.add("c");
		collectionEntitys.stream().forEach(string -> System.out.println(string));
		
	}
	@Test
	public void testException(){
		try {
			 int i = 3/2;
			 System.out.println(i);
		} catch (Exception e) {
			
		}
	       
		
	}
	/*
	 * 数组分页
	 */
	@Test
	public void testArrayPage(){
		int pageNo = 38;
		int pagesize = 3;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 112; i++) {
			list.add(i);
		}
		
		int totalcount = list.size();//总数据条数
		int pagecount = 0;//页数
		int m = totalcount % pagesize;//算余数
		if(m > 0){
			pagecount = totalcount / pagesize + 1;//余数大于0就增加1的页数
		}else{
			pagecount = totalcount / pagesize;
		}
		if (pageNo>pagecount) {//超出总页数，返回空数组
			new ArrayList<Integer>();
		}
		
		List<Integer> subList = null;
		if (m==0) {
			subList = list.subList((pageNo-1)*pagesize,(pageNo-1)*pagesize+pagesize);//数组从下表0开始，所以要-1
		}else{
			if (pagecount==pageNo) {//如果总页数等于传参的总页数，to的参数传入总条数
				subList = list.subList((pageNo-1)*pagesize,totalcount);
			}else{
				subList = list.subList((pageNo-1)*pagesize,(pageNo-1)*pagesize+pagesize);
			}
		}
		System.out.println("aaaaaaaaaaa"+subList+"\r\n总页数："+pagecount);
//		for(int i = 1; i <= pagecount; i++) {
//			if (m == 0) {
//				List<Integer> subList = list.subList((i - 1) * pagesize, pagesize * (i));
//				System.out.println("aaaaaaaaaaa"+subList);
//			}else{
//				if(i == pagecount){
//					List<Integer> subList = list.subList((i - 1) * pagesize, totalcount);
//					System.out.println(i+"--------------"+subList);
//				}else{
//					List<Integer> subList = list.subList((i - 1) * pagesize, pagesize * (i));
//					System.out.println(i+"============="+subList);
//				}
//			}
//		}


	       
		
	}
	@Test
	public void testString(){
//		String s = new String("0 1/30 * * * ?");
//		System.out.println(s.equals("0 1/30 * * * ?"));
	}
	@Test
	public void testSpicial(){
		
		System.out.println(12&3);
	}
//	@Test
	//transactionHelper.doInCurrentTransaction(() -> doFind(config));
//	public void testLambod(){
//		String s= new String(() -> testArrayPage());
//		
//	}
}

