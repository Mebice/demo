package com.example.demo.entity;

public class Cat extends Animal{
	
	
	@Override
	public void eat() {
		System.out.println(super.getName() + " �@���Y!!!");
	}
	
	@Override
	public void sleep() {
		System.out.println(super.getName() + " �@����!!!");
	}

	public void barking() {
		System.out.println(super.getName() + " �{�l�B�|�s!!!");
	}
}
