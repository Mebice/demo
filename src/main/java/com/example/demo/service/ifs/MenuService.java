package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.Menu;

public interface MenuService {
	
	public Menu addMenu(Menu menu);  //�s�W�浧

	public List<Menu> addMenus(List<Menu> menuList);  //�s�W�h��
	
	public Menu updateMenu(Menu menu);  //��s
	
	public Menu findByName(String name);  // �d�߯S�w
	
	public List <Menu> findAll();  //�d�ߥ���

}
