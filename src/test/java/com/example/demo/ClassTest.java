package com.example.demo;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.demo.entity.Dog;
import com.example.demo.entity.TaipeiBank;

public class ClassTest {

	@Test
	public void classTest() {
		Dog yourDog = new Dog();
		System.out.println(yourDog.getName());
		yourDog.setName("cat");
		System.out.println("================");
		Dog myDog = new Dog();
		System.out.println(myDog.getName());
		myDog.setName("monkey");
		System.out.println(yourDog.getName());
		System.out.println(myDog.getName());
		System.out.println("================");
	}

	@Test
	public void classTest1() {
		Dog dog = new Dog();
		dog.setAttributes("yellw", "Lily", 2);
		System.out.println();
	}

	// �s��
	@Test
	public void classTest2() {
		TaipeiBank bank = new TaipeiBank();
		System.out.println(bank.getBalance());
		Assert.isTrue(bank.getBalance() == 1000, "saving error");
//		System.out.println(bank.getBalance());
		bank.saving(-500);
		Assert.isTrue(bank.getBalance() == 1000, "saving error");
//		System.out.println(bank.getBalance());
		bank.saving(500);
		Assert.isTrue(bank.getBalance() == 1500, "saving error");
//		System.out.println(bank.getBalance());
	}

//����??
	@Test
	public void classTest3() {
		TaipeiBank bank = new TaipeiBank();
		System.out.println(bank.getBalance());
		Assert.isTrue(bank.getBalance() == 1000, "withdraw error");

		bank.withdraw(-500);
		Assert.isTrue(bank.getBalance() == 1000, "withdraw error");
//		System.out.println(bank.getBalance());
		bank.withdraw(500);
		Assert.isTrue(bank.getBalance() == 500, "withdraw error");
//		System.out.println(bank.getBalance());
		bank.withdraw(2000);
		Assert.isTrue(bank.getBalance() == 1000, "withdraw error");
		System.out.println(bank.getBalance());
	}

	// ����O�����m �A�u�n�O��new�A�N�O���P�O�����m
	@Test
	public void classTest4() {
//		TaipeiBank bank = new TaipeiBank();
//		System.out.println(bank);
		System.out.println(new TaipeiBank()); //�ܼƥu�ϥΤ@���A�����a�J�A�ΦW���O�A�i�֤@��{���X
		Dog dog = new Dog();
		System.out.println(dog);
		System.out.println("===============");
		Dog dogg = new Dog();
		System.out.println(dogg);
		System.out.println("===============");
		Dog doggg = dog;
		System.out.println(doggg);
		System.out.println(dog == doggg);
		// back.saving(dog)
	}

	// == �u���K�Ӹ�ƫ��A�٦��O�����m�~��
	@Test
	public void classTest5() {
		int a = 5;
		int b = 5;
		System.out.println(a == b);
		System.out.println("===============");
		Integer a1 = 10;
		Integer b1 = 10;
		System.out.println(a1 == b1);
		System.out.println("===============");
		Integer a2 = new Integer(10);
		Integer b2 = new Integer(10);
		System.out.println("a2 == b2" + (a2 == b2));
		System.out.println("===============");
		boolean boo1 = false;
		boolean boo2 = false;
		boolean boo3 = true;
		System.out.println(boo1 == boo2);
	}

	@Test
	public void classTest6() {
		TaipeiBank bank = new TaipeiBank();
		int a = 10;
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
//		System.out.println(i);   //����ϥΦb�~��A�n�Φbfor�̭��A�]���u���̭����ŧii�A�ҥH�������~
		if (a > 20) {
			System.out.println("===============");
		}
		int b = 20;
		System.out.println(a);
		System.out.println(b);
//		String b = "";  //���o���ƫŧi
		b = 30;
	}
	
	@Test
	public void classTest7() {
		Dog dog = new Dog();   //�bDog����ctrl�i���V�ӷ���m
		dog.setName("Lily");
		dog.setColor("blue");
		dog.setAge(2);
		System.out.println("===============");
		Dog dogg = new Dog ("QQQQ","GGG",3);
		System.out.println("===============");
	}
	
	@Test
	public void classTest8() {
		Dog dog = new Dog();
		dog.setAttributes(); //�@���k���I�s�A�����n�������O new �X��
		Dog.setAttributes2(); //static ��k���I�s�A���������O�W��.static ��k
		System.out.println("===============");
		Math.random();
		Random ran = new Random();
		ran.nextInt();
		System.out.println("===============");
		int aaaa = 100;
		aaaa = 200;
		final int bbbb = 50;
//		bbbb = 20;  //���L�C��]:�]���W�誺final�A�ҥH���i�A���
	}
}
