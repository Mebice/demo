package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class RegexpTest {

	@Test
	public void regexpTest() {
		String str = "0912-345-678"; 
		// \ ����Ÿ��A���i��W�s�b�A\\�ϸ���Ÿ��ܬ��±׽u�A�L�X\�A�q�`�ǭǤ@��
//		String pattern = "\\d\\d\\d\\d-\\d\\d\\d-\\d\\d\\d";   //   \\d�N���O�Ʀr0~9
//		String pattern = "\\d{4}-\\d{3}-\\d{3}"; //�h�j�A��  {3} �N��3�� {x]�N��x��
		String pattern = "\\d{4}(-\\d{3}){2}"; // �]�����O�P�����A�n�����@�աA�n�Τp�A��
		System.out.println(str.matches(pattern));
	}

	@Test
	public void regexpTest1() {
//		String pattern = "(\\d{2})\\d{8}"; //�榡: 2�X8�X,���]�t�p�A��;�p�A���u�O���ե�
		String pattern = "\\(\\d{2}\\)\\d{7}"; // �榡: (2�X)7�X,�]�t�p�A��
		String pattern1 = "\\(\\d{2}\\)\\d{8}";// �榡: (2�X)8�X,�]�t�p�A��
		String pattern2 = "\\d{2}-\\d{7}";// �榡: 2�X-7�X
		String pattern3 = "\\d{2}-\\d{8}";// �榡: 2�X-8�X
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�q�ܸ��X:");
		System.out.println("�q�ܮ榡��:(�ϽX2�X)�q�ܸ��X7�X��8�X");
		System.out.println("�q�ܮ榡��:�ϽX2�X-�q�ܸ��X7�X��8�X");
		String input = scan.next();
		if(input.matches(pattern) || input.matches(pattern1) || input.matches(pattern2) || input.matches(pattern3)) {
			System.out.println(input + "�ŦX�榡!!");
		}else {
			System.out.println(input + "���ŦX�榡!!");
		}
	}
	
	@Test
	public void regexpTest2() {
//		String pattern = "(\\d{2})\\d{8}"; //�榡: 2�X8�X,���]�t�p�A��;�p�A���u�O���ե�
//		String pattern0= "\\(\\d{2}\\)\\d{7}"; // �榡: (2�X)7�X,�]�t�p�A��
//		String pattern1 = "\\(\\d{2}\\)\\d{8}";// �榡: (2�X)8�X,�]�t�p�A��
//		//�H�U�O�N pattern0 �M pattern1 ��X�@�_�A�ܤ@�ϥ�
//		String patternA = "\\(\\d{2}\\)\\d{7}||\\(\\d{2}\\)\\d{8}";//(02)1234567 or (02)12345678
//		String patternB = "\\(\\d{2}\\)(\\d{7}||\\d{8})";
//		String patternC = "\\(\\d{2}\\)\\d{7,8}";
//		
//		String pattern2 = "\\d{2}-\\d{7}";// �榡: 2�X-7�X
//		String pattern3 = "\\d{2}-\\d{8}";// �榡: 2�X-8�X
//		 //pattern2 �M pattern3 ��X��D
//		String patternD = "\\d{2}-\\d{7,8}";  //\\d{7,8} �����O7�� 8�X
//		//patternC �M patternD ��X
		String patternE = "(\\(\\d{2}\\)||\\d{2}-)\\d{7,8}";  
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�q�ܸ��X:");
		System.out.println("�q�ܮ榡��:(�ϽX2�X)�q�ܸ��X7�X��8�X");
		System.out.println("�q�ܮ榡��:�ϽX2�X-�q�ܸ��X7�X��8�X");
		String input = scan.next();
		if(input.matches(patternE)) {
			System.out.println(input + "�ŦX�榡!!");
		}else {
			System.out.println(input + "���ŦX�榡!!");
		}
	}
	
	@Test
	public void regexpTest3() {
		String str = "a";
		String str1 = "Ab";
		String pattern = "\\w"; //  \\w �e�Τ@�Ӧr���A���d���Y�b [A-Za-z0-9_] 
		String pattern1 = "\\w."; //  . ��ܰ��F����Ÿ�(\n)���~����L�Ҧ��r���A���u���@�Ӧr��
		//  \\w �e�Τ@�Ӧr���A���d���Y�b [A-Za-z0-9_] 
		//  .* ��� 0~�h�Ӧr���A�ҥH�᭱���r���i��(1~�h��)�i�L
		String pattern2 = "\\w.*";
		System.out.println(str.matches(pattern));
		System.out.println(str1.matches(pattern));
		System.out.println("=======================");
		System.out.println(str.matches(pattern1));
		System.out.println(str1.matches(pattern1));
		System.out.println("=======================");
		System.out.println(str.matches(pattern2));
		System.out.println(str1.matches(pattern2));
	}
	
	//�m��
	//	�����Ҧr���ˬd(Scanner ��J)
	//	10�X
	//	�Ĥ@�Ӧr���^��r��(�j�p�g�ҥi)
	//	�^��r���᭱���۪��Ĥ@�ӼƦr�u�|�O 1 �� 2
	//	�ХΥ��W��F������
	//	������,�ЦA�g�ӱư�6�����^��r��(A�BB�BD�BE�BF�BH)
	@Test
	public void regexpTest4() {
		//[���w�d��ñư�] [�d��] �Ʀr8��
		String pattern = "([A-Za-z&&[^ABDEFHabdefh]])([12])\\d{8}";
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�����Ҧr��:");
		String input = scan.next();
		if(input.matches(pattern)) {
			System.out.println(input + "�ŦX�榡!!");
		} else {
			System.out.println(input + "���ŦX�榡!!");
		}
	}


}
