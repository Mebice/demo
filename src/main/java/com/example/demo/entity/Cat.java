package com.example.demo.entity;

public class Cat extends Animal{
	
	
	@Override
	public void eat() {
		System.out.println(super.getName() + " 一直吃!!!");
	}
	
	@Override
	public void sleep() {
		System.out.println(super.getName() + " 一直睡!!!");
	}

	public void barking() {
		System.out.println(super.getName() + " 肚子咕魯叫!!!");
	}
}
