package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class DemoApplicationTests {

	@Test
	//���L�C:����   //���L�C:ĵ��(�Ҧp�ŧi�ܼƫo���ϥ�)�A���v�T����
	//�btest���gvoid
	//�v��   //���^�ǭ�   //��k�W��
	public void firstTest() {
		int a = 123456789;
		//��ƹw�]��int�A�Y�W�X�d��ݦb���+L
		long b = 12345678912L;
		//���O
		//String str = new String("ABC");
		String str = "ABC";
		System.out.println("str: " + str);
	}

}
