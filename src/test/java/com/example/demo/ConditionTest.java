package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.remoting.soap.SoapFaultException;

public class ConditionTest {

	@Test
	public void ifTest() {
		int a = 5;
		// true���ܦL�W���A�_�hfalse�L�U��
		if (a < 5) {
			System.out.println("===========");
		} else {
			System.out.println("+++++++++++");
		}
	}

	// ���k�W��(�Ҧp:ifTest1)���k��A����Ӱϰ�
	@Test
	public void ifTest1() {
		int a = 5;
		// true���ܦL�W���A�_�hfalse�L�U��
		if (a < 5) {
			System.out.println("===========");
		} else if (a > 6) {
			System.out.println("+++++++++++");
		} else {
			System.out.println("-----------");
		}
	}

	@Test
	public void switchTest() {
		int a = 95;
		// int�O��ơA���G�u�|�O���
		int b = 95 / 10;
		// ������L�X���O9.0?�]��95�M10���O���(int)�A�ҥH�X�Ӫ����G�]�|�O��ơA���D�b���ƩγQ����+.0�A���G�~�|�O9.5�C
		double c = 95 / 10;
		// ��X
		System.out.println(b);
		System.out.println(c);
	}

	@Test
	public void scannerTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��r:");
		// ���ŧi�@�ӡA�ҥH�u�X�{�@��
		String a = scan.next();
		System.out.println("��J����r�O: " + a);
	}

	@Test
	public void scannerTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��r:");
		// �ŧi��ӡA�ҥH����ӡA���J�����y�Ů�A��U�@��
		String a = scan.next();
		String b = scan.next();
		System.out.println("��J����r�O: " + a + b);
	}

	@Test
	public void scannerTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��r:");
		String a = scan.nextLine();
		System.out.println("��J����r�O: " + a);
	}

	@Test
	public void scannerTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�Ʀr:");
		int a = scan.nextInt();
		System.out.println("��J���Ʀr�O: " + a);
	}

	@Test
	public void switchTest1() {
		// //��J
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J���Z:");
		int input = scan.nextInt();
		switch (input / 10) {
		// ���浲�G�ۦP�i�g�@�_
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("D");
		}
	}

	// �@�~:���]���ѬO�P��X�A�Ψ��switch�g�A�@�ӬO���ѬO�P��X�A�@�ӬO�X�ѫᬰ�P��X
	@Test
	       //�^�ǭȫ��A//���^�ǭ�
	public void switchTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ѬO�P���X:");
		int inputInt = scan.nextInt();
		String weekday = switchDay(inputInt);
		System.out.println("�п�J�X�ѫ᪺�Ѽ�:");
		int days = scan.nextInt();
		String output = switchDay((inputInt + days) % 7);
		System.out.printf("���ѬO�P��%s, %d�ѫ�O�P��%s", weekday, days, output);
	}
		   //�^�ǭȫ��A//�r��
	public String switchDay(int inputInt) {
		String weekday = "";
		switch (inputInt) {
		case 0:
			weekday = "��";
			break;
		case 6:
			weekday = "��";
			break;
		case 5:
			weekday = "��";
			break;
		case 4:
			weekday = "�|";
			break;
		case 3:
			weekday = "�T";
			break;
		case 2:
			weekday = "�G";
			break;
		case 1:
			weekday = "�@";
			break;
		}
		return weekday;

	}

}
