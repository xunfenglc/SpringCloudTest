package com.tedu.sp02.item.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.service.ItemService;
import com.tedu.web.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@Value("${server.port}")
	private int port;
	
	
	@GetMapping("/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable String orderId) throws Exception {
		log.info("server.port="+port+", orderId="+orderId);
		
		if (Math.random()<0.6) {
			long t = new Random().nextInt(5000);
			log.info("延迟: "+t);
			Thread.sleep(t);
		}
		
		List<Item> list = itemService.getItems(orderId);
		return JsonResult.ok(list).msg("port="+port);
	}
	
	/*
	 * 普通的 post 请求 http协议:
	 * 协议头
	 * asdfasdf
	 * asdfasdfas
	 * dfasdf
	 * 
	 * 协议体
	 * parm1=1&param2=2&param3=3
	 * 
	 * request.getParameter("parm1")
	 * 
	 * @Controller
	 * void f(String parm1, int param2) 
	 * 
	 * 
	 * 请求 http协议:
	 * 协议头
	 * asdfasdf
	 * asdfasdfas
	 * dfasdf
	 * 
	 * 协议体
	 * [{"id":1, "name":....}, {}, {}]
	 * 
	 * @RequestBody
	 */
	@PostMapping("/decreaseNumber")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
		itemService.decreaseNumbers(items);
		return JsonResult.ok();
	}
}




