package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

public class Dog implements RunService{  //import完RunService變Dog紅蚯蚓，鼠標移置並點擊add
	// 類別的底下要宣告權限
	private String name = "Apple"; //預設值為Apple

	private String color; //預設值為null

	private int age; //預設值為0
	
	//預設建構方法: 格式: 權限+方法名稱   v.s.  一般方法: 格式: 權限+回傳值型態+方法名稱
	//預設建構方法，未帶參數 //自動生成:右鍵1.source 2.Generate super
	//只有預設建構方法的話，生成不生成皆可
	public Dog() { 
		super(); //用於繼承
	}
	//無任何回傳型態//類別與方法名稱相同
	//帶參數或帶有屬性的預設建構方法//自動生成:右鍵1.source 2.Generate using 
	//使用時必須要生成上方的預設建構方法  //優點:不用生成一堆set方法
	public Dog(String name, String color, int age) { 
		super();                                     
		this.name = name;			//this=最上方的此class
		this.color = color;
		this.age = age;
	}


	public String getName() {
		return name;  //有資料型態一定要return
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAttributes(String name,String color,int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}
	
	public void setAttributes() {
		System.out.println("===============");
	}
	
	public static void setAttributes2() {
		System.out.println("===============");
	}
	
	@Override
	public void run() {
		System.out.println("小狗在奔跑!!");
		
	}

}
