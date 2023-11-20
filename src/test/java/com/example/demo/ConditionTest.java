package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.remoting.soap.SoapFaultException;

public class ConditionTest {

	@Test
	public void ifTest() {
		int a = 5;
		// true的話印上面，否則false印下面
		if (a < 5) {
			System.out.println("===========");
		} else {
			System.out.println("+++++++++++");
		}
	}

	// 對方法名稱(例如:ifTest1)按右鍵，執行該區域
	@Test
	public void ifTest1() {
		int a = 5;
		// true的話印上面，否則false印下面
		if (a < 5) {
			System.out.println("===========");
		} else if (a > 6) {
			System.out.println("+++++++++++");
		} else {
			System.out.println("-----------");
		}
	}

	@Test
	public void switchTest() {
		int a = 95;
		// int是整數，結果只會是整數
		int b = 95 / 10;
		// 為什麼印出的是9.0?因為95和10都是整數(int)，所以出來的結果也會是整數，除非在除數或被除數+.0，結果才會是9.5。
		double c = 95 / 10;
		// 輸出
		System.out.println(b);
		System.out.println(c);
	}

	@Test
	public void scannerTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字:");
		// 指宣告一個，所以只出現一個
		String a = scan.next();
		System.out.println("輸入的文字是: " + a);
	}

	@Test
	public void scannerTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字:");
		// 宣告兩個，所以找到兩個，當輸入之間流空格，找下一個
		String a = scan.next();
		String b = scan.next();
		System.out.println("輸入的文字是: " + a + b);
	}

	@Test
	public void scannerTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字:");
		String a = scan.nextLine();
		System.out.println("輸入的文字是: " + a);
	}

	@Test
	public void scannerTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入數字:");
		int a = scan.nextInt();
		System.out.println("輸入的數字是: " + a);
	}

	@Test
	public void switchTest1() {
		// //輸入
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入成績:");
		int input = scan.nextInt();
		switch (input / 10) {
		// 執行結果相同可寫一起
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("D");
		}
	}

	// 作業:假設今天是星期X，用兩個switch寫，一個是今天是星期X，一個是幾天後為星期X
	@Test
	       //回傳值型態//不回傳值
	public void switchTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("今天是星期幾:");
		int inputInt = scan.nextInt();
		String weekday = switchDay(inputInt);
		System.out.println("請輸入幾天後的天數:");
		int days = scan.nextInt();
		String output = switchDay((inputInt + days) % 7);
		System.out.printf("今天是星期%s, %d天後是星期%s", weekday, days, output);
	}
		   //回傳值型態//字串
	public String switchDay(int inputInt) {
		String weekday = "";
		switch (inputInt) {
		case 0:
			weekday = "日";
			break;
		case 6:
			weekday = "六";
			break;
		case 5:
			weekday = "五";
			break;
		case 4:
			weekday = "四";
			break;
		case 3:
			weekday = "三";
			break;
		case 2:
			weekday = "二";
			break;
		case 1:
			weekday = "一";
			break;
		}
		return weekday;

	}

}
