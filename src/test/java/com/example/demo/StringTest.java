package com.example.demo;

import java.util.ArrayList;
import java.util.Scanner;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Dog;

public class StringTest {
	// �r��O���O�A�S���a��O�i�ε���
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
		System.out.println(str.equalsIgnoreCase(str3)); // �����j�p�g
	}

	// �r�����
	@Test
	public void stringTest1() {
		String str = "ABC";
		String str1 = "";
		String str2 = "  ";
		System.out.println("str length: " + str.length());
		System.out.println("str1 length: " + str1.length());
		System.out.println("str2 length: " + str2.length());
		System.out.println("=================");
		// isEmpty() �O�ݦr�ꪺ���׬O�_��0
		System.out.println("str1 isEmpty: " + str1.isEmpty());
		System.out.println("str2 isEmpty: " + str2.isEmpty());
		System.out.println("=================");
		// isBlank(): 1.���׬�0; 2.�r�ꤺ�e�ѥ��ťղզ�:�������� 1 �� 2 �h�^�� true
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
//		System.out.println(color.length()); //��������O�έȬ�null.()(.��k)�A�������~
		System.out.println(color == null); // ��������O�έȬ�null�ɭԡA�ΧP�_
		System.out.println("=================");
		if (color == null || color.isBlank()) { // �n���P�_null�~�i�H�P�_��L�A�_�h����
			System.out.println("color �O�Ŧr��!!");
		} else {
			System.out.println("color ���O�Ŧr��!!");
		}
		System.out.println("=================");
		System.out.println(StringUtils.hasLength(" "));
		System.out.println(StringUtils.hasText(" ")); // ���`��
		System.out.println("=================");
		color = " ";
		if (color.isBlank()) {
			System.out.println("color �S�����e!!");
		} else {
			System.out.println("color �����e!!");
		}
		System.out.println("=================");

		if (StringUtils.hasText(color)) {
			System.out.println("color �����e!!");
		} else {
			System.out.println("color �S�����e!!");
		}
		System.out.println("=================");

		if (!StringUtils.hasText(color)) { // �nimport��framework Util //!���ۤϪ��N��
			System.out.println("color �S�����e!!");
		} else {
			System.out.println("color �����e!!"); // false
		}
	}

	// ��r�j�M
	// �m���D�A�峹�X�{�X���p�s�k
	// �D��:����L�Q�O���L�P�p�s�k���G�ơA�ڤ����w�p�s�k���ҥP�A���M�p�s�k�b���L�����O�M�s��U
	@Test
	public void stringTest3() {
		String text = "����L�Q�O���L�P�p�s�k���G�ơA�ڤ����w�p�s�k���ҥP�A���M�p�s�k�b���L�����O�M�s��U";
		String search = "�p�s�k";
		int index = 0;
		int count = 0;

		// ��k�@
		while (index != -1) { // �פ���󬰪���-1
			index = text.indexOf(search, index); // ���ަ�m = �峹.�j�M��r����k(����r,�_�l��m)
			count++; // ����+1
			index += search.length(); // �N���޳]�w���W�@����쪺��m����+����r����
		}

		System.out.println("�p�s�k�X�{������: " + count);
		// �q11��m�}�l�d�ߤp�s�k�A�C���d�ߨ�+3�A����-1����

		System.out.println("=================");

		// ��k�G
		for (;;) {
			if (text.indexOf(search, index) == -1) {
				break;
			}
			count++; // ����+1
			index = text.indexOf(search, index) + search.length();
		}
		System.out.println("�p�s�k�X�{������: " + count);

		System.out.println("=================");

		// ��k�T
		for (; text.indexOf(search, index) == -1;) {
			count++;
			index = text.indexOf(search, index) + search.length();
		}
		System.out.println("�p�s�k�X�{������: " + count);
	}

	@Test
	public void replaceTest() {
		String text = "����L�Q�O���L�P�p�s�k���G�ơA�ڤ����w�p�s�k���ҥP�A���M�p�s�k�b���L�����O�M�s��U";
		text = text.replace("�p�s�k", "�pŢ�]");
		System.out.println(text);
		System.out.println("=================");
		text = text.replaceAll("�pŢ�]", "�pŢ���]"); // �Ω󥿳W��F��
		System.out.println(text);
		// ��Ӭҥi�ϥ�
	}

	@Test
	public void splitTest() {
		String text = "����L�Q�O���L�P�p�s�k���G�ơA�ڤ����w�p�s�k���ҥP�A���M�p�s�k�b���L�����O�M�s��U";
		String[] array = text.split("�A");
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

	// trim�h���e��ť� + replace���N ������
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

	// �^��
	@Test
	public void substringTest() {
		String text = "����L�Q�O���L�P�p�s�k���G��";
		String substr = text.substring(5);
		String substr1 = text.substring(5, 11);
		System.out.println(substr);
		System.out.println(substr1);
	}

	// �r��걵
	@Test
	public void stringBufferTest() {
		StringBuffer sb = new StringBuffer("ABC");
		sb.append("DEF");
		sb.append("GGG");
		sb.append("AAA").append("BBB");
		System.out.println("=================");
		String str = "ABC" + "DEF" + "GGG" + "AAA" + "BBB"; // ���I:�h�s�W�O����Ŷ�
	}

	@Test
	public void stringBufferTest1() {
		StringBuffer sb = new StringBuffer("ABC");
		StringBuffer sb1 = new StringBuffer("ABC");
		System.out.println(sb.equals(sb1));
		System.out.println("=================");
		System.out.println(sb.toString().equals(sb1.toString()));
	}
	
	//�P�_��J���r��O�_�O�j��
	//�L�����J�r��
	@Test
	public void stringBufferTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��r:");
		String str = scan.next();
		StringBuffer sb = new StringBuffer(str);
		//reverse ���� �L��A�n�� StringBuffer���O ��r�� toString �A�~�i�H equals ���
		if (str.equals(sb.reverse().toString())) {  
			System.out.println(str + "�O�j��");
		} else {
			System.out.println(str + "���O�j��");
		}
	}

	//�P�_��J���r��O�_�O�j��
	//�����J2�ӥH�W���r��
	@Test
	public void stringBufferTest3() {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			System.out.println("�п�J2�ӥH�W����r:");
			String str = scan.next();
			if (str.length() <= 2) {
				continue;
			}
			StringBuffer sb = new StringBuffer(str);
			if (str.equals(sb.reverse().toString())) {
				System.out.println(str + "�O�j��");
			} else {
				System.out.println(str + "���O�j��");
			}
			break;
		}
	}

	//�m��:��@�Ӧr�� ABACADEF ���̫�@�� A ���� W
	//�覡�@
	@Test
	public void replaceTest1() {
		String str = "ABACADEF";
		int index = str.lastIndexOf("A"); // index = 4   //1.���r�ꪺ�̫᪺��m lastIndexOf = 4
		String lastString = str.substring(index); // lastString = ADEF  //2.����substring(4) = ADEF
		lastString = lastString.replace("A", "W"); // lastString = WDEF  //3.replace("A", "W") = WDEF
		str = str.substring(0, index) + lastString; //str.substring(0,index) = ABAC; //4.substring(0,4) = ABAC
		System.out.println(str);											//5.ABAC + WDEF
	}

	// �m��:��@�Ӧr�� ABACADEF ���̫�@�� A ���� W  
	//�覡�G
	@Test
	public void replaceTest2() {
		String str = "ABACADEF";
		int index = str.lastIndexOf("A"); // index = 4
		StringBuffer sb = new StringBuffer(str);
		sb.setCharAt(index, 'W'); //.setCharAt:�b�Y���ަ�m���r������//����Φr��n��char 'W'
		System.out.println(sb.toString());
	}
	
//	�m��
//	List: [1, 9]
//	��ܼƦr19
//	�i�H�令�h�ӼƦr�� List�A�Ҧp: [9, 9, 9, 9]
//	���ۧ�19 + 1 = 20
//	��X: [2, 0]
//	�Y�O�@�}�l�� List �O [9, 9, 9, 9]�F��X�|�O [1, 0, 0, 0, 0]
	@Test
	public void listTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�@�ӼƦr:");
		int inputInt = scan.nextInt();  //��J��
		inputInt++;     				// + 1
		String str = String.valueOf(inputInt); //�r����Ʀr
		String[] strArray = str.split("");  
		System.out.println(new ArrayList<>(Arrays.asList(strArray))); //�ΦW�}�C
	}
	
	
}
