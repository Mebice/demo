package com.example.demo.entity;

//無關係繼承  //目的:減少程式碼 //將重複的程式碼放至另一類別中
//方式二 //聚合
public class A1 {
	
//	private String city;
//	
//	private String state;
//	
//	private String country;
	
	private C c = new C();   //給予類別C預設值
	
	private String address;
	
	//屬性為 私有private 須定義 public 的 get set 方法
	
	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
