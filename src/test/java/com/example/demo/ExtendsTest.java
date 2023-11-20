package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.A1;
import com.example.demo.entity.Animal;
import com.example.demo.entity.Bird;
import com.example.demo.entity.C;
import com.example.demo.entity.Car;
import com.example.demo.entity.Cat;
import com.example.demo.entity.Dog;

public class ExtendsTest {
	
	@Test
	public void extendsTest() {
		Animal anim = new Animal();
		System.out.println("父類別 Animal name: " + anim.getName());
		anim.eat();
		anim.sleep();
		Bird bird = new Bird();  //呼叫子方法時，先父再子方法
		bird.setName("小花");
		System.out.println("子類別 Bird name: " + bird.getName());
		bird.eat();
		bird.sleep();
		bird.flying();
		Cat cat = new Cat();
		cat.setName("小草");
		System.out.println("子類別 Cat name: " + cat.getName());
		cat.eat();
		cat.barking();
	}
	
	@Test
	public void extendsTest1() {
		A1 a1 = new A1();
		//透過類別 A1 取得類別 C 中的私有屬性 city
		a1.getC().getCity();
		// 執行上述程式會報 NullPointException
		// 因為類別 A1 中的私有屬性 C 也是個類別，類別的預設值是 null
		// a1.getC() 得到的值是 null，null 在呼叫方法時就會報錯
	}
	
	@Test
	public void extendsTest2() {
		A1 a1 = new A1();
		//透過類別 A1 取得類別 C 中的私有屬性 city
		String city = a1.getC().getCity();
		System.out.println(city);
		// 因為類別 A1 中的私有屬性 C 有給預設值，，所以預設值就不是 null
		// 但類別 C 中的屬性一樣會是預設值，city 是 String，預設值是 null
	}
	
	@Test
	public void extendsTest3() {
		C c = new C("AAA","BBB","CCC");
//		c.setCity("AAA");
//		c.setCity("BBB");
//		c.setCity("CCC");
		A1 a1 = new A1();
		a1.setC(c);
		a1.setAddress("DDD");
		System.out.println("==================");
		System.out.println("city: " + a1.getC().getCity());
		System.out.println("country: " + a1.getC().getCountry());
		System.out.println("state: " + a1.getC().getState());
		System.out.println("address: " + a1.getAddress());
	}
	
	//多形:一個方法，帶入的東西不一樣，結果也不同  例如:一樣是泡麵，做出的口味不同
	@Test
	public void extendsTest4() {
		Animal anim = new Animal();  //呼叫父類別
		anim.eat();
		Bird bird = new Bird();		 //呼叫子類別
		bird.eat();
		Cat cat = new Cat();		//呼叫子類別
		cat.eat();
		System.out.println("=============="); 
		Animal animm = new Animal();  
		animm.eat();
		Animal birdd = new Bird();  //呼叫父類別接回，若用子類別有的方法而父類別沒有，則無法呼叫 //本質上執行的是子方法
		birdd.eat();
		Animal catt = new Cat();
		catt.eat();
	}
	
	@Test
	public void interfaceTest() {
		Car car = new Car();
		car.run();
		Dog dog = new Dog();
		dog.run();
	}

}
