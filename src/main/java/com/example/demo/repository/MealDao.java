package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository
public interface MealDao extends JpaRepository<Meal, MealId> {

	// findTop數字:限制搜尋結果回傳的筆數
	public List<Meal> findTop2ByName(String name);

	// findFirst數字:限制搜尋結果回傳的筆數
	public List<Meal> findFirst2ByName(String name);

	// orderBy:排序 : 預設 ASC
	// ASC:由小到大 ; DESC:由大到小
	public List<Meal> findByNameOrderByPrice(String name);
	
	//public List<Meal> findAllByOrderByPriceAsc();
	public List<Meal> findAllByOrderByPrice();
	
	public List<Meal> findAllByOrderByPriceDesc();
	
	//比較大小
	// 1. 大於: GreaterThan 2. 大於等於 GreaterThanEqual
	// 3. 小於: LessThan 4. 小於等於 LessThanEqual
	public List<Meal> findByPriceGreaterThan(int price);
	
	// 多個欄位 + 比較大小
	public List<Meal> findByNameAndPriceGreaterThan(String name,int price);
	
	// containing
	public List<Meal> findByNameContaining(String name);
	
	public List<Meal> findByNameContainingAndCookingStyleContaining(String name,String CookingStyle);
	
	//between : 有包含上下界的值
	public List<Meal> findByPriceBetween(int price1,int price2);
	//between : 有包含上下界的值    且    按照價格排序
	public List<Meal> findByPriceBetweenOrderByPrice(int price1,int price2);
	
	//in //以內
	public List<Meal> findByPriceIn(List<Integer> priceList);
	
	//notIn //以外
		public List<Meal> findByPriceNotIn(List<Integer> priceList);
}
