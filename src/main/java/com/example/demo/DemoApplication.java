package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
												//排除預設輸入密碼
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		int x = 2;
//		// float double byte short long boolean char
//		System.out.println(x);
//		System.out.print(x + "\n"); // "\n" 換行符號
////      System.out.println("");
//		System.out.printf("x = %d", x);
//		char a = 'a';
//		char aa = 97;
//		System.out.print("\n" + "a =" + a + "\t aa=" + aa + "\n");
//		int y = 6;
//		System.out.println(x < y);
//		String str = "This is a String";
//		System.out.println(str + x);
//		Integer xx = 5;
//
//		String x1 = "x1";
//		String y1 = "y1";
//		System.out.println(5 > 4 ? 15 : 66);
//		
//
//		int x2, y2, value;
//		x2 = y2 = 10;
//		value = ++x2 * 10;
//		System.out.println("遞增放前面\t" + value);
//		value = ++y2 * 10;
//		System.out.println("遞增放後面\t" + value);
//
//		System.out.println("x2=" + x2 + "\ty=" + y2);
		
	
	}

}
