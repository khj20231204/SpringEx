package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class ModelControllerMy{
	public String main(HashMap map) {
		map.put("id", "map put id");
		map.put("pwd", "1111");
		
		return "txtView2";
	}
}


public class MethodCallMy {

	public static void main(String[] args) throws Exception {
		HashMap map = new HashMap();
		System.out.println("before:"+map);
		
		ModelControllerMy mcm = new ModelControllerMy();
		String viewName = mcm.main(map);
		
		System.out.println("after:"+map);
		
		render(map, viewName);
	}

	static void render(HashMap map, String viewName) throws IOException {
		String result = "";
		
		//1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File(viewName + ".txt"));
		
		while(sc.hasNext()) {
			result += sc.nextLine() + System.lineSeparator();
		}
		
		//2. map에 담긴 key를 하나씩 읽어서 template의 ${key}를 value로 바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();
			
			//3. replace()로 key를 value 치환한다.
		result = result.replace("${"+key+"}", (String)map.get(key));
		}
	}
}
