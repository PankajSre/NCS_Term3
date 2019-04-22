package com.niit.ncs.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public Map<String, Object> sayHi(Map<String, Object> map)
	{
		map = new LinkedHashMap<String, Object>();
		map.put("message", "Hello World");
		return map;
	}
}
