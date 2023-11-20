package com.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class LoopTest {

	@Test
	public void loopTest() {
		System.out.println("============");
		for (int i = 1; i < 5; i++) {
			System.out.println("i=" + 1);
		}
		System.out.println("============");
		for (int i = 1; i < 5; ++i) {
			System.out.println("i=" + 1);
		}
	}

	// �E�E���k��
	@Test
	public void loopTest2() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 2) {
					// ���X�Z���@�ΰϰ�̪񪺰j��
					break;
				}
				System.out.printf("%d*%d=%2d", i, j, i * j);
			}
			System.out.println();
			System.out.println();
		}
	}

	@Test
	public void randomTest() {
		// ����:(�϶��W���� - �϶��U���� +1) + �϶��U����
		// 1~99:�϶��W���� = 90 ; �϶��U���� = 1
		// (99-1�ѤU98�ӼƦr�A�n�A+1�[�^����99��)+�_�l��
		double random = Math.random() * (99 - 1 + 1) + 1;
		// 20~50:�϶��W���� = 50 ; �϶��U���� = 20
		double random1 = Math.random() * (50 - 20 + 1) + 20;
		System.out.println("==============");
		Random ran = new Random(); // ���ͬ��L�C�A�]�������ϥΡA������import(���в�����L�Cimport
		// Random ���O�̪� nextInt(���1):�|���� 0~�p���J���i����
		// ����1~99
		int a = ran.nextInt(99) + 1; // �üƲ���0~98(�j��0�p��99)���ƭȡA�ҥH���A+1
		System.out.println(a);
		int b = ran.nextInt(1,81);
	}

	//�q�Ʀr�m��
	@Test
	public void guessTest() {
		Scanner scan = new Scanner(System.in);
		int min = 1; 		//�̤p��
		int max = 99;		//�̤j��
		int ans = (int) (Math.random() * (99 - 1 + 1)) + 1; //���T����=�d��1~99�������Y�@�ü�
		int input;
		for (;;) {
			System.out.printf("�Цb%d~%d�����q�@�ӼƦr:", min, max);
			input = scan.nextInt();
			if (input < min || input > max) {
				System.out.println("���b�d��");
				continue; 	//����
			}
			if (input == ans) {
				System.out.println("����F");
				break;
			}
			if (input > ans) {  //���J�Ȥj�󵪮�
				max = input;   //�̤j���ܦ���J��
			} else {			//�Ϥ��A���J�Ȥp�󵪮�
				min = input;	//�̤p���ܦ���J��
			}
		}
	}
}