package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;
import com.example.demo.repository.MealDao;
import com.example.demo.service.ifs.MealService;

@SpringBootTest(classes = DemoApplication.class)
public class MealServiceTest {

	@Autowired
	private MealService mealService;

	@Autowired
	private MealDao mealDao;

	@Test
	public void addMeal() {
		mealService.addMeal(new Meal("beef", "BBQ", 180));
		mealService.addMeal(new Meal("beef", "fry", 150));
		mealService.addMeal(new Meal("pork", "fried", 220));
		mealService.addMeal(new Meal("chicken", "stew", 260));
		mealService.addMeal(new Meal("chicken", "BBQ", 120));
		mealService.addMeal(new Meal("chicken", "steam", 520));
		mealService.addMeal(new Meal("Apple", "sugar", 1520));
	}

	@Test
	public void addMealTest() {
		// name 不符條件
		Meal result = mealService.addMeal(new Meal("", "BBQ", 180));
		Assert.isTrue(result == null, "addMeal error1!!");
		// cooking_style 不符
		result = mealService.addMeal(new Meal("beef", "", 180));
		Assert.isTrue(result == null, "addMeal error2!!");
		// price 不符
		result = mealService.addMeal(new Meal("beef", "BBQ", 0));
		Assert.isTrue(result == null, "addMenu error3!!");
		// 正常新增
		result = mealService.addMeal(new Meal("beef", "BBQ", 180));
		Assert.isTrue(result != null, "addMeal error4!!");
		// 再新增已存在的 meal
		result = mealService.addMeal(new Meal("beef", "BBQ", 180));
		Assert.isTrue(result == null, "addMeal error5!!");
		// 刪除測試資料
//		mealDao.deleteById(new MealId("beef", "BBQ"));
	}

	// 限制回傳筆數
	@Test
	public void limitTest() {
		List<Meal> res = mealDao.findFirst2ByName("chicken");
		System.out.println(res.size());
		Assert.isTrue(res.size() == 2, "find limit error!!");
	}

	@Test
	public void orderByTest() {
		// 找出名字再按照價格排序
//		List<Meal> res = mealDao.findByNameOrderByPrice("chicken");
		// 全部由小到大排序
//		List<Meal> res = mealDao.findAllByOrderByPrice();
		// 全部由大到小排序
		List<Meal> res = mealDao.findAllByOrderByPriceDesc();
		for (Meal item : res) {
			System.out.println(item.getName() + item.getCookingStyle() + ": " + item.getPrice());
		}
	}

	// 比較
	@Test
	public void compareTest() {
		// 找到價格200以上的名稱
//		List<Meal> res = mealDao.findByPriceGreaterThan(200);
		// 找到特定名稱且價格200以上
		List<Meal> res = mealDao.findByNameAndPriceGreaterThan("chicken", 200);
		for (Meal item : res) {
			System.out.println(item.getName() + item.getCookingStyle() + ": " + item.getPrice());
		}
	}

	@Test
	public void containingTest() {
		List<Meal> res = mealDao.findByNameContaining("e");
//		List<Meal> res = mealDao.findByNameContainingAndCookingStyleContaining("e","b");
		for (Meal item : res) {
			System.out.println(item.getName() + item.getCookingStyle() + ": " + item.getPrice());
		}
	}

	@Test
	public void betweenTest() {
		List<Meal> res = mealDao.findByPriceBetween(120, 260);
		for (Meal item : res) {
			System.out.println(item.getName() + item.getCookingStyle() + ": " + item.getPrice());
		}
	}

	@Test
	public void inTest() {
		List<Meal> res = mealDao.findByPriceIn(new ArrayList<>(List.of(120, 150, 180, 200)));
		for (Meal item : res) {
			System.out.println(item.getName() + item.getCookingStyle() + ": " + item.getPrice());
		}
	}
	
	@Test
	public void notInTest() {
		List<Meal> res = mealDao.findByPriceNotIn(new ArrayList<>(List.of(120, 150, 180, 200)));
		for (Meal item : res) {
			System.out.println(item.getName() + item.getCookingStyle() + ": " + item.getPrice());
		}
	}
}