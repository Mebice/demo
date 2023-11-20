package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ch.qos.logback.core.net.SyslogOutputStream;

public class ArrayTest {

	@Test
	public void arrayTest() {
//		int[] a = new int[5];
//		System.out.println(a);
//		System.out.println(a.length);
//		a[0] = 1;
//		a[1] = 5;
//		System.out.println(a);
//		System.out.println("=============");
		// �ŧi���P�ɵ�����l��
		int[] b = { 1, 3, 5, 7, 9 };
//		System.out.println(b[4]);
		for (int item : b) {
			System.out.println(item);
		}
	}

	// class�i��new�A��list�Ointerface���Oclass�A�L�knew
	// ����:�ت�:�w�q��k
	// �g���Φ�:List<��ƫ��A(���r�@�w�j�g)> �ܼƦW�� = new ArrayList<���e�i�ٲ�>();
	// �Ҧp:List<String> strList = new ArrayList<>();
	@Test
	public void listTest() {
		// �ʺA�W�R //���ͰʺA�Ŷ�
		List<String> strList = new ArrayList<>();// ���L�C�nimport
		strList.add("A");
		strList.add("C");
		strList.add("D");
		strList.add("B");
		// List �O�����Ǫ��A�̷ӥ[�J�����ᶶ��
		System.out.println(strList);
		System.out.println("================");
		System.out.println(strList.size());// ��ƪ���
		System.out.println("================");
		// ��for�j����X
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println("================");
		List<String> strList1 = List.of("A", "S", "D", "F"); // �h�Ӧr��A�n�r�����j //�Ŷ����׵L�k���
		List<String> strList2 = Arrays.asList("A1", "S1", "D1", "F1");// �T�w�j�p
		// ����U�@��{���|�����A�]���� List.of() ���ͪ� List ��j�p�T�w�A�L�k�A�W�R
		// strList1.add("G");
		// ����U�@��{���|�����A�]���� Arrays.asList() ���ͪ� List ��j�p�T�w�A�L�k�A�W�R
		// strList1.add("G1");
		System.out.println("==================");
		// �i�z�L�H�U��k�ŧi�@�ӰʺA�Ŷ��æP�ɵ����w�]��
		List<String> strList3 = new ArrayList<>(List.of("A", "S", "D", "F"));
		List<String> strList4 = new ArrayList<>(Arrays.asList("A1", "S1", "D1", "F1"));
	}

	@Test
	public void foreachTest() {
		List<String> strList = new ArrayList<>(List.of("A", "S", "D", "F"));
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println("==================");
		// foreach:�M���A�N��O���N List �̪��C�Ӷ��رq�Y����@�Ӥ@�Ө��X
		for (String item : strList) {
			System.out.println(item);
		}
		System.out.println("==================");
		strList.forEach(item -> {
			System.out.println(item);
		});
	}

	@Test
	public void listTest1() {
		String str = "ABC";
		String str1 = new String("ASD");
		String str2 = null;
		System.out.println(str.length());
		System.out.println(str1.length());
//		System.out.println(str2.length()); //null.��k�@�w����
		System.out.println("================");
		
	}
}
