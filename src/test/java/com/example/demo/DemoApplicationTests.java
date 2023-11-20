package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class DemoApplicationTests {

	@Test
	//紅蚯蚓:報錯   //黃蚯蚓:警示(例如宣告變數卻未使用)，不影響執行
	//在test都寫void
	//權限   //不回傳值   //方法名稱
	public void firstTest() {
		int a = 123456789;
		//整數預設為int，若超出範圍需在後方+L
		long b = 12345678912L;
		//類別
		//String str = new String("ABC");
		String str = "ABC";
		System.out.println("str: " + str);
	}

}
