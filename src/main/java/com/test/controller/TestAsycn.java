package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.AsycnService;

/**
 * 测试异步
 * @author wangwu
 *
 */
//@EnableAsync
@Controller
public class TestAsycn {
	@Autowired
	private AsycnService asycnService;
	@RequestMapping("/testAsycn")
	@ResponseBody
	public void testAsycn() throws InterruptedException{
		for (int i = 0; i < 3; i++) {
			String add = asycnService.add("linfeng"+i);
			String ha = add+"!";
			System.out.println(ha);
		}
	}

}
