package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
public class Hello {
	
	int iv = 10;
	static int cv = 20; 
	
	//2. URL�� �޼��带 ����
	@RequestMapping("/hello")
	 private void main() {	//�ν��Ͻ� �޼��� - iv, cv ��� ��� ����
		System.out.println("hello");
		System.out.println(iv);
		System.out.println(cv);
	}
	
	public static void main2() { //static�޼��� - cv�� ��� ����
		//System.out.println(iv); error
		System.out.println(cv);
	}
}
