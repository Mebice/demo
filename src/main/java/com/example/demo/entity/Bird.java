package com.example.demo.entity;

public class Bird extends Animal {
	
	private TaipeiBank bank = new TaipeiBank(); 
	
	public Bird() {
		super();
//		System.out.println("Bird �غc��k");
	}

	//@Override: �мg or ���s�w�q
	// ���l���O���ۦP��k��(�W��+�A�ѼƭӼ�)�A�l���O�惡��k���s�w�q�ۤv����@���e
	@Override
	public void eat() {
		System.out.println(super.getName() + " ��Y�䪱!!!");
	}
	
	@Override
	public void sleep() {
		System.out.println(super.getName() + " ��Y���!!!");
	}
	
	public void flying() {
		System.out.println( super.getName() + " ���b��!!!");
	}
	


}
