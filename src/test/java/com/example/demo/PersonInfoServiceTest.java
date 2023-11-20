package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Meal;
import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@SpringBootTest(classes = DemoApplication.class)
public class PersonInfoServiceTest {

	@Autowired
	private PersonInfoService personInfoService;
	
	@Autowired
	private PersonInfoDao personInfoDao;
	
	//單筆
	@Test
	public void addPersonInfoServiceTest() {
		personInfoService.addInfo(new PersonInfo("A223456789","CCC",25,"Taipei"));
	}
	
	@Test
	public void addPersonInfoServiceTest2() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("K123456787","KKK",22,"Kaohsiung"));
		list.add(new PersonInfo("F123456787","FFF",24,"Taichung"));
		personInfoService.addInfoList(list);
	}

	//多筆，不用多次操作
	@Test
	public void daoSaveAllTest() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("A123456787","DDD",28,"Kaohsiung"));
		list.add(new PersonInfo("E123456787","EEE",30,"Taichung"));
		personInfoDao.saveAll(list);
	}
	
	// 處理可能找不到對應資料的情況	 //Optional 是為了處理查詢結果為空的情況
	// 只有 findById 有 Optional
	@Test
	public void daoFindTest() {		
		Optional<PersonInfo> infoOp = personInfoDao.findById("A123456781");  //findById 的 Id 是指 PK 的欄位，與名稱無關
		// 檢查 Optional 是否為空，也就是查找結果是否為空。如果是空的，印出 "Not found!!"，然後返回
		if(infoOp.isEmpty()) {	
			System.out.println("Not found!!");
			return;
		}
		//將被Optional包住的物件取出
		System.out.println(infoOp.get().getName());					
	}
	
	//查詢所有
	@Test
	public void daoFindTest2() {
		List<PersonInfo> list = personInfoDao.findAll();
		for(PersonInfo item : list) {
			System.out.println(item.getName());
		}
	}
	
	// 資料是否存在 //例如:該帳號是否存在
	@Test
	public void daoFindTest3() {
		boolean result=personInfoDao.existsById("A123456787");
		System.out.println(result);
	}
	
	//查詢city的資料  //.findBy 為固定查找的方法 
	@Test
	public void daoFindTest4() {
//		List<PersonInfo> result = personInfoDao.findByCity("Kaohsiung");
//		List<PersonInfo> result = personInfoDao.findByNameAndCity("DDD","Kaohsiung");
		List<PersonInfo> result = personInfoDao.findByNameOrCity("DDD","Kaohsiung");
		for(PersonInfo item : result) {
			System.out.println(item.getName());
		}
	}
	
	//找出年紀大於輸入條件的所有個人資訊
	@Test
	public void compareTest() {
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThan(28);
		for (PersonInfo item : res) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
	
	//找出年紀小於等於輸入條件的所有個人資訊//由小到大排序
	@Test
	public void compareTest1() {
		List<PersonInfo> res = personInfoDao.findByAgeLessThanEqualOrderByAge(25);
		for (PersonInfo item : res) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
	
	//找到年齡小於輸入條件1或是大於輸入條件2的資訊   
	@Test
	public void compareTest2() {
		List<PersonInfo> res = personInfoDao.findByAgeLessThanOrAgeGreaterThan(24,28);
		for (PersonInfo item : res) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
	
	//找到年紀介於2個數字之間(有包含)的資訊
		//年齡由大到小排序
		//只取前3筆資料
	@Test
	public void betweenTest() {
		List<PersonInfo> res = personInfoDao.findFirst3ByAgeBetweenOrderByAgeDesc(24,28);
		for (PersonInfo item : res ) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
	
	//取得city包含某個特定字的所有個人資訊
	@Test
	public void containingTest() {
		List<PersonInfo> res = personInfoDao.findByCityContaining("K");
		for (PersonInfo item : res ) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
	
	// 找出年紀大於輸入條件以及city包含某個特定字的所有個人資訊
	//年齡由大到小排序
	@Test
	public void containingTest2() {
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThanAndCityContainingOrderByAgeDesc(24,"T");
		for (PersonInfo item : res ) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
}
