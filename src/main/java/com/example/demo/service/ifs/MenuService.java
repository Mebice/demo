package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.Menu;

public interface MenuService {
	
	public Menu addMenu(Menu menu);  //新增單筆

	public List<Menu> addMenus(List<Menu> menuList);  //新增多筆
	
	public Menu updateMenu(Menu menu);  //更新
	
	public Menu findByName(String name);  // 查詢特定
	
	public List <Menu> findAll();  //查詢全部

}
