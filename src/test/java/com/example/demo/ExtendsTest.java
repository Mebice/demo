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
		System.out.println("�����O Animal name: " + anim.getName());
		anim.eat();
		anim.sleep();
		Bird bird = new Bird();  //�I�s�l��k�ɡA�����A�l��k
		bird.setName("�p��");
		System.out.println("�l���O Bird name: " + bird.getName());
		bird.eat();
		bird.sleep();
		bird.flying();
		Cat cat = new Cat();
		cat.setName("�p��");
		System.out.println("�l���O Cat name: " + cat.getName());
		cat.eat();
		cat.barking();
	}
	
	@Test
	public void extendsTest1() {
		A1 a1 = new A1();
		//�z�L���O A1 ���o���O C �����p���ݩ� city
		a1.getC().getCity();
		// ����W�z�{���|�� NullPointException
		// �]�����O A1 �����p���ݩ� C �]�O�����O�A���O���w�]�ȬO null
		// a1.getC() �o�쪺�ȬO null�Anull �b�I�s��k�ɴN�|����
	}
	
	@Test
	public void extendsTest2() {
		A1 a1 = new A1();
		//�z�L���O A1 ���o���O C �����p���ݩ� city
		String city = a1.getC().getCity();
		System.out.println(city);
		// �]�����O A1 �����p���ݩ� C �����w�]�ȡA�A�ҥH�w�]�ȴN���O null
		// �����O C �����ݩʤ@�˷|�O�w�]�ȡAcity �O String�A�w�]�ȬO null
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
	
	//�h��:�@�Ӥ�k�A�a�J���F�褣�@�ˡA���G�]���P  �Ҧp:�@�ˬO�w�ѡA���X���f�����P
	@Test
	public void extendsTest4() {
		Animal anim = new Animal();  //�I�s�����O
		anim.eat();
		Bird bird = new Bird();		 //�I�s�l���O
		bird.eat();
		Cat cat = new Cat();		//�I�s�l���O
		cat.eat();
		System.out.println("=============="); 
		Animal animm = new Animal();  
		animm.eat();
		Animal birdd = new Bird();  //�I�s�����O���^�A�Y�Τl���O������k�Ӥ����O�S���A�h�L�k�I�s //����W���檺�O�l��k
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
