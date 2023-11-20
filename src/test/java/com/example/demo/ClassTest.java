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

	// 存款
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

//提款??
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

	// 比較記憶體位置 ，只要是有new，就是不同記憶體位置
	@Test
	public void classTest4() {
//		TaipeiBank bank = new TaipeiBank();
//		System.out.println(bank);
		System.out.println(new TaipeiBank()); //變數只使用一次，直接帶入，匿名類別，可少一行程式碼
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

	// == 只有八個資料型態還有記憶體位置才有
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
//		System.out.println(i);   //不能使用在外圍，要用在for裡面，因為只有裡面有宣告i，所以此條錯誤
		if (a > 20) {
			System.out.println("===============");
		}
		int b = 20;
		System.out.println(a);
		System.out.println(b);
//		String b = "";  //不得重複宣告
		b = 30;
	}
	
	@Test
	public void classTest7() {
		Dog dog = new Dog();   //在Dog按住ctrl可指向來源位置
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
		dog.setAttributes(); //一般方法的呼叫，必須要先把類別 new 出來
		Dog.setAttributes2(); //static 方法的呼叫，直接用類別名稱.static 方法
		System.out.println("===============");
		Math.random();
		Random ran = new Random();
		ran.nextInt();
		System.out.println("===============");
		int aaaa = 100;
		aaaa = 200;
		final int bbbb = 50;
//		bbbb = 20;  //紅蚯蚓原因:因為上方的final，所以不可再更改
	}
}
