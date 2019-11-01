package com.tedu.sp09.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tedu.sp01.pojo.Item;
import com.tedu.web.util.JsonResult;
/*
 * 要在接口和方法上,设置调用的后台服务,以及调用的后台服务路径
 * 
 * http://localhost:8001/y4y45334t
 * http://localhost:8002/y4y45334t
 * 
 * @FeignClient(name = "item-service")
 *     指定访问哪个后台服务,可以获得服务的主机地址
 *     http://localhost:8001
 *     http://localhost:8002
 * 
 * @GetMapping("/{orderId}")
 *     Feign利用SpringMVC注解,来确定访问路径
 *     http://localhost:8001/{orderId}
 * 
 * @PathVariable
 *     把路径中的占位符,替换成具体参数数据
 *     http://localhost:8001/44y45yt3tg3t
 */
@FeignClient(name = "item-service", fallback = ItemFeignServiceFB.class)
public interface ItemFeignService {
	@GetMapping("/{orderId}")
	JsonResult<List<Item>> getItems(@PathVariable String orderId);
	
	@PostMapping("/decreaseNumber")
	JsonResult decreaseNumber(@RequestBody List<Item> items);
}






