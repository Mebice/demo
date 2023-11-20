package com.example.demo.entity;

public class Bird extends Animal {
	
	private TaipeiBank bank = new TaipeiBank(); 
	
	public Bird() {
		super();
//		System.out.println("Bird 建構方法");
	}

	//@Override: 覆寫 or 重新定義
	// 父子類別有相同方法時(名稱+，參數個數)，子類別對此方法重新定義自己的實作內容
	@Override
	public void eat() {
		System.out.println(super.getName() + " 邊吃邊玩!!!");
	}
	
	@Override
	public void sleep() {
		System.out.println(super.getName() + " 邊吃邊睡!!!");
	}
	
	public void flying() {
		System.out.println( super.getName() + " 正在飛!!!");
	}
	


}
