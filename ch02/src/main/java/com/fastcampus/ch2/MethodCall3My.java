package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;

public class MethodCall3My {

	public static void main(String[] args) throws Exception {
		//1. 요청할 때 제공된 값 - request.getParamterMap();
		Map map = new HashMap();
		map.put("year","2023");
		map.put("month", "06");
		map.put("day", "1");
		
		Model mode = null;
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class);
		
		
		
		
	}

}
