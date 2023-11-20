package com.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class LoopTest {

	@Test
	public void loopTest() {
		System.out.println("============");
		for (int i = 1; i < 5; i++) {
			System.out.println("i=" + 1);
		}
		System.out.println("============");
		for (int i = 1; i < 5; ++i) {
			System.out.println("i=" + 1);
		}
	}

	// 九九乘法表
	@Test
	public void loopTest2() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 2) {
					// 跳出距離作用區域最近的迴圈
					break;
				}
				System.out.printf("%d*%d=%2d", i, j, i * j);
			}
			System.out.println();
			System.out.println();
		}
	}

	@Test
	public void randomTest() {
		// 公式:(區間上限值 - 區間下限值 +1) + 區間下限值
		// 1~99:區間上限值 = 90 ; 區間下限值 = 1
		// (99-1剩下98個數字，要再+1加回來變99個)+起始值
		double random = Math.random() * (99 - 1 + 1) + 1;
		// 20~50:區間上限值 = 50 ; 區間下限值 = 20
		double random1 = Math.random() * (50 - 20 + 1) + 20;
		System.out.println("==============");
		Random ran = new Random(); // 產生紅蚯蚓，因為首次使用，移除需import(鼠標移到紅蚯蚓import
		// Random 類別裡的 nextInt(整數1):會產生 0~小於輸入整數i的值
		// 產生1~99
		int a = ran.nextInt(99) + 1; // 亂數產生0~98(大於0小於99)的數值，所以須再+1
		System.out.println(a);
		int b = ran.nextInt(1,81);
	}

	//猜數字練習
	@Test
	public void guessTest() {
		Scanner scan = new Scanner(System.in);
		int min = 1; 		//最小值
		int max = 99;		//最大值
		int ans = (int) (Math.random() * (99 - 1 + 1)) + 1; //正確答案=範圍為1~99之間的某一亂數
		int input;
		for (;;) {
			System.out.printf("請在%d~%d之間猜一個數字:", min, max);
			input = scan.nextInt();
			if (input < min || input > max) {
				System.out.println("不在範圍");
				continue; 	//停止
			}
			if (input == ans) {
				System.out.println("答對了");
				break;
			}
			if (input > ans) {  //當輸入值大於答案
				max = input;   //最大值變成輸入值
			} else {			//反之，當輸入值小於答案
				min = input;	//最小值變成輸入值
			}
		}
	}
}