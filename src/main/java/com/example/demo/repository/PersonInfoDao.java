package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.PersonInfo;

public interface PersonInfoDao extends JpaRepository<PersonInfo,String>{

	//自定義 //findByCity 的 City 是屬性名稱,大寫是因為小駝峰命名 //只要不是單筆就要用List接回
	public List<PersonInfo> findByCity(String city);
	
	public List<PersonInfo> findByNameAndCity(String name,String city);
	
	public List<PersonInfo> findByNameOrCity(String name,String city);
	
	//找出年紀大於輸入條件的所有個人資訊
	public List<PersonInfo> findByAgeGreaterThan(int age);
	
	//找出年紀小於等於輸入條件的所有個人資訊
	//年齡由小到大排序
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age);
	
	//找到年齡小於輸入條件1或是大於輸入條件2的資訊 
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int age1,int age2);
	
	//找到年紀介於2個數字之間(有包含)的資訊
	//年齡由大到小排序
	//只取前3筆資料
	public List<PersonInfo> findFirst3ByAgeBetweenOrderByAgeDesc(int age1,int age2);
	
	//取得city包含某個特定字的所有個人資訊
	public List<PersonInfo> findByCityContaining(String city);
	
	// 找出年紀大於輸入條件以及city包含某個特定字的所有個人資訊
	//年齡由大到小排序
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age,String city);
	
}
