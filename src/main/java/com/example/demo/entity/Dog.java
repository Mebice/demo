package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

public class Dog implements RunService{  //import��RunService��Dog���L�C�A���в��m���I��add
	// ���O�����U�n�ŧi�v��
	private String name = "Apple"; //�w�]�Ȭ�Apple

	private String color; //�w�]�Ȭ�null

	private int age; //�w�]�Ȭ�0
	
	//�w�]�غc��k: �榡: �v��+��k�W��   v.s.  �@���k: �榡: �v��+�^�ǭȫ��A+��k�W��
	//�w�]�غc��k�A���a�Ѽ� //�۰ʥͦ�:�k��1.source 2.Generate super
	//�u���w�]�غc��k���ܡA�ͦ����ͦ��ҥi
	public Dog() { 
		super(); //�Ω��~��
	}
	//�L����^�ǫ��A//���O�P��k�W�٬ۦP
	//�a�ѼƩαa���ݩʪ��w�]�غc��k//�۰ʥͦ�:�k��1.source 2.Generate using 
	//�ϥήɥ����n�ͦ��W�誺�w�]�غc��k  //�u�I:���Υͦ��@��set��k
	public Dog(String name, String color, int age) { 
		super();                                     
		this.name = name;			//this=�̤W�誺��class
		this.color = color;
		this.age = age;
	}


	public String getName() {
		return name;  //����ƫ��A�@�w�nreturn
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
		System.out.println("�p���b�b�]!!");
		
	}

}
