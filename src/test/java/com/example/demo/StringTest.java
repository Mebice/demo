package com.example.demo;

import java.util.ArrayList;
import java.util.Scanner;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Dog;

public class StringTest {
	// 字串是類別，特殊的地方是可用等號
	@Test
	public void stringTest() {
		String str = "ABC";
		String str1 = new String("ABC");
		String str2 = "ABC";
		System.out.println(str == str1);
		System.out.println(str == str2);
		System.out.println("=================");
		System.out.println(str.equals(str1));
		System.out.println(str.equals(str2));
		System.out.println("=================");
		String str3 = "aBC";
		System.out.println(str.equals(str3));
		System.out.println(str.equalsIgnoreCase(str3)); // 忽略大小寫
	}

	// 字串長度
	@Test
	public void stringTest1() {
		String str = "ABC";
		String str1 = "";
		String str2 = "  ";
		System.out.println("str length: " + str.length());
		System.out.println("str1 length: " + str1.length());
		System.out.println("str2 length: " + str2.length());
		System.out.println("=================");
		// isEmpty() 是看字串的長度是否為0
		System.out.println("str1 isEmpty: " + str1.isEmpty());
		System.out.println("str2 isEmpty: " + str2.isEmpty());
		System.out.println("=================");
		// isBlank(): 1.長度為0; 2.字串內容由全空白組成:滿足條件 1 或 2 則回傳 true
		System.out.println("str isBlank: " + str.isBlank());
		System.out.println("str1 isBlank: " + str1.isBlank());
		System.out.println("str2 isBlank: " + str2.isBlank());
	}

	@Test
	public void stringTest2() {
		Dog dog = new Dog();
		String name = dog.getName();
		String color = dog.getColor();
		System.out.println(name);
		System.out.println(color);
		System.out.println("=================");
		System.out.println(name.length());
//		System.out.println(color.length()); //當物件或類別或值為null.()(.方法)，偵測錯誤
		System.out.println(color == null); // 當物件或類別或值為null時候，用判斷
		System.out.println("=================");
		if (color == null || color.isBlank()) { // 要先判斷null才可以判斷其他，否則偵錯
			System.out.println("color 是空字串!!");
		} else {
			System.out.println("color 不是空字串!!");
		}
		System.out.println("=================");
		System.out.println(StringUtils.hasLength(" "));
		System.out.println(StringUtils.hasText(" ")); // 較常用
		System.out.println("=================");
		color = " ";
		if (color.isBlank()) {
			System.out.println("color 沒有內容!!");
		} else {
			System.out.println("color 有內容!!");
		}
		System.out.println("=================");

		if (StringUtils.hasText(color)) {
			System.out.println("color 有內容!!");
		} else {
			System.out.println("color 沒有內容!!");
		}
		System.out.println("=================");

		if (!StringUtils.hasText(color)) { // 要import選framework Util //!為相反的意思
			System.out.println("color 沒有內容!!");
		} else {
			System.out.println("color 有內容!!"); // false
		}
	}

	// 文字搜尋
	// 練習題，文章出現幾次小龍女
	// 題目:神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗
	@Test
	public void stringTest3() {
		String text = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		String search = "小龍女";
		int index = 0;
		int count = 0;

		// 方法一
		while (index != -1) { // 終止條件為直到-1
			index = text.indexOf(search, index); // 索引位置 = 文章.搜尋文字的方法(關鍵字,起始位置)
			count++; // 次數+1
			index += search.length(); // 將索引設定為上一次找到的位置之後+關鍵字長度
		}

		System.out.println("小龍女出現的次數: " + count);
		// 從11位置開始查詢小龍女，每次查詢到+3，直到-1停止

		System.out.println("=================");

		// 方法二
		for (;;) {
			if (text.indexOf(search, index) == -1) {
				break;
			}
			count++; // 次數+1
			index = text.indexOf(search, index) + search.length();
		}
		System.out.println("小龍女出現的次數: " + count);

		System.out.println("=================");

		// 方法三
		for (; text.indexOf(search, index) == -1;) {
			count++;
			index = text.indexOf(search, index) + search.length();
		}
		System.out.println("小龍女出現的次數: " + count);
	}

	@Test
	public void replaceTest() {
		String text = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		text = text.replace("小龍女", "小籠包");
		System.out.println(text);
		System.out.println("=================");
		text = text.replaceAll("小籠包", "小籠湯包"); // 用於正規表達式
		System.out.println(text);
		// 兩個皆可使用
	}

	@Test
	public void splitTest() {
		String text = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		String[] array = text.split("，");
		for (String item : array) {
			System.out.println(item);
		}
		System.out.println("=================");
		String str = "ABCD";
		String[] array1 = text.split("");
		for (String item : array1) {
			System.out.println(item);
		}
	}

	// trim去除前後空白 + replace取代 的應用
	@Test
	public void trimTest() {
		String str = "ABC DEF G";
		String str1 = " ABC DEF ";
		System.out.println(str == str1);
		System.out.println(str.equals(str1));
		str = str.trim();
		str1 = str1.trim();
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str == str1);
		System.out.println(str.equals(str1));
		System.out.println("=================");
		str = str.replace(" ", "");
		System.out.println(str);
	}

	// 擷取
	@Test
	public void substringTest() {
		String text = "神鵰俠侶是楊過與小龍女的故事";
		String substr = text.substring(5);
		String substr1 = text.substring(5, 11);
		System.out.println(substr);
		System.out.println(substr1);
	}

	// 字串串接
	@Test
	public void stringBufferTest() {
		StringBuffer sb = new StringBuffer("ABC");
		sb.append("DEF");
		sb.append("GGG");
		sb.append("AAA").append("BBB");
		System.out.println("=================");
		String str = "ABC" + "DEF" + "GGG" + "AAA" + "BBB"; // 缺點:多新增記憶體空間
	}

	@Test
	public void stringBufferTest1() {
		StringBuffer sb = new StringBuffer("ABC");
		StringBuffer sb1 = new StringBuffer("ABC");
		System.out.println(sb.equals(sb1));
		System.out.println("=================");
		System.out.println(sb.toString().equals(sb1.toString()));
	}
	
	//判斷輸入的字串是否是迴文
	//無限制輸入字數
	@Test
	public void stringBufferTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字:");
		String str = scan.next();
		StringBuffer sb = new StringBuffer(str);
		//reverse 反轉 過後，要把 StringBuffer類別 轉字串 toString ，才可以 equals 比較
		if (str.equals(sb.reverse().toString())) {  
			System.out.println(str + "是迴文");
		} else {
			System.out.println(str + "不是迴文");
		}
	}

	//判斷輸入的字串是否是迴文
	//限制輸入2個以上的字數
	@Test
	public void stringBufferTest3() {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			System.out.println("請輸入2個以上的文字:");
			String str = scan.next();
			if (str.length() <= 2) {
				continue;
			}
			StringBuffer sb = new StringBuffer(str);
			if (str.equals(sb.reverse().toString())) {
				System.out.println(str + "是迴文");
			} else {
				System.out.println(str + "不是迴文");
			}
			break;
		}
	}

	//練習:把一個字串 ABACADEF 的最後一個 A 換成 W
	//方式一
	@Test
	public void replaceTest1() {
		String str = "ABACADEF";
		int index = str.lastIndexOf("A"); // index = 4   //1.找到字串的最後的位置 lastIndexOf = 4
		String lastString = str.substring(index); // lastString = ADEF  //2.切割substring(4) = ADEF
		lastString = lastString.replace("A", "W"); // lastString = WDEF  //3.replace("A", "W") = WDEF
		str = str.substring(0, index) + lastString; //str.substring(0,index) = ABAC; //4.substring(0,4) = ABAC
		System.out.println(str);											//5.ABAC + WDEF
	}

	// 練習:把一個字串 ABACADEF 的最後一個 A 換成 W  
	//方式二
	@Test
	public void replaceTest2() {
		String str = "ABACADEF";
		int index = str.lastIndexOf("A"); // index = 4
		StringBuffer sb = new StringBuffer(str);
		sb.setCharAt(index, 'W'); //.setCharAt:在某索引位置的字元替換//不能用字串要用char 'W'
		System.out.println(sb.toString());
	}
	
//	練習
//	List: [1, 9]
//	表示數字19
//	可以改成多個數字的 List，例如: [9, 9, 9, 9]
//	接著把19 + 1 = 20
//	輸出: [2, 0]
//	若是一開始的 List 是 [9, 9, 9, 9]；輸出會是 [1, 0, 0, 0, 0]
	@Test
	public void listTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入一個數字:");
		int inputInt = scan.nextInt();  //輸入後
		inputInt++;     				// + 1
		String str = String.valueOf(inputInt); //字串轉數字
		String[] strArray = str.split("");  
		System.out.println(new ArrayList<>(Arrays.asList(strArray))); //匿名陣列
	}
	
	
}
