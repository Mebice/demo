package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Menu;

import com.example.demo.repository.MenuDao;

import com.example.demo.service.ifs.MenuService;

@SpringBootTest(classes = DemoApplication.class)
public class MenuServiceTest {

	@Autowired
	private MenuService menuService;

	@Autowired
	private MenuDao menuDao;

	// 新增單筆 //.add()
	@Test
	public void addMenuTest() {
		// name 不符條件
		Menu result = menuService.addMenu(new Menu("", 120));
		Assert.isTrue(result == null, "addMenu error1!!");
		// price = 0
		result = menuService.addMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "addMenu error2!!");
		// 正常新增
		result = menuService.addMenu(new Menu("fish1", 120));
		Assert.isTrue(result != null, "addMenu error3!!");
		// 新增已存在的 menu
		result = menuService.addMenu(new Menu("fish1", 150));
		Assert.isTrue(result == null, "addMenu error4!!");
		// 刪除
		menuDao.deleteById("fish1");
	}

	// 新增多筆 //.saveAll()
	@Test
	public void daoSaveAllTest() {
		ArrayList<Menu> list = new ArrayList<>();
		list.add(new Menu("beef", 300));
		list.add(new Menu("chicken", 500));
		menuDao.saveAll(list);
	}
/*
	@Test
	public void updateMenuTest(Menu menu) { // ???
		// name 不符條件
		Menu result = menuService.updateMenu("");
		Assert.isTrue(result == null, "updateMenu error1!!");
		// 正常新增後再更新
		result = menuService.addMenu(new Menu("fish1", 120));
		result = menuService.updateMenu("fish1");
		Assert.isTrue(result != null, "updateMenu error3!!");
		Assert.isTrue(result.getPrice() == 150, "findByName error3!!");
		// 刪除測試資料
		menuDao.deleteById("fish1");
	}
*/
	@Test
	public void findBynameTest() {
		// name 不符條件
		Menu result = menuService.findByName("");
		Assert.isTrue(result == null, "findByName error1!!");
		// name 不存在
		result = menuService.findByName("fish1");
		Assert.isTrue(result == null, "findByName error2!!");
		// 新增測試資料
		result = menuService.addMenu(new Menu("fish1", 120));
		result = menuService.findByName("fish1");
		Assert.isTrue(result != null, "findByName error3!!");
		// 刪除測試資料
		menuDao.deleteById("fish1");
	}

	// 查詢所有 //.findAll()
	@Test
	public void daoFindTest() {
		List<Menu> list = menuDao.findAll();
		for (Menu item : list) {
			System.out.printf(item.getName() + " : ");
			System.out.println(item.getPrice());
		}
	}

}
