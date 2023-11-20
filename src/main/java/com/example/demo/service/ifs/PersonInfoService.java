package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.PersonInfo;

public interface PersonInfoService {

	public void addInfo(PersonInfo info);
	
	public void addInfoList(List<PersonInfo> infoList); // 新增多筆 

	public PersonInfo addInfoList1(List<PersonInfo> infoList); // 新增多筆

	public List<PersonInfo> findAll(); // 查詢全部 

	public PersonInfo findById(String id); // 查詢特定  // 透過id取得對應的個人資訊
	
	
}
