package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public void addInfo(PersonInfo info) {
		String id = info.getId();
		String pattern = "[A-Za-z][1,2]\\d{8}";
		if (StringUtils.hasText(id) && id.matches(pattern)) {
			personInfoDao.save(info); // save為jpa的方法，有後蓋前的問題，需使用existsById
		} else {
			System.out.println("id error!!!");
		}
	}

	@Override
	public void addInfoList(List<PersonInfo> infoList) { // 假設 infoList 有 10 筆資料
		String pattern = "[A-Za-z][1,2]\\d{8}";
		for (PersonInfo item : infoList) {
			String id = item.getId();
//			if (!(StringUtils.hasText(id) && id.matches(pattern))) {  //方式1
//				System.out.println("id error!!!");
//				return;
//			}
			if (!StringUtils.hasText(id) || !id.matches(pattern)) { // 方式2 ，任一個條件未滿足時
				System.out.println("id error!!!");
				return;
			}
		}
		personInfoDao.saveAll(infoList);
	}


//	// 可創建1~多筆資訊(帳號用英文字母開頭)，只能新增新資訊，回傳被創建的資訊、訊息
//	@Override
//	public PersonInfo addInfoList1(List<PersonInfo> infoList) {
//		String pattern = "[A-Za-z]\\d{9}";
//		for (PersonInfo item : infoList) {
//			String id = item.getId();
//			if (!StringUtils.hasText(id) || !id.matches(pattern)) {
//				return null;
//			}
//			if (personInfoDao.existsById(id)) { // 只能新增新資訊(是否存在，存在不新增)
//				return null;
//			}	
//			infoList.add(personInfoDao.save(item));
//		}
//		return infoList;
//	}

	// 查詢全部 //取得所有個人資訊
	@Override
	public List<PersonInfo> findAll() {
		return personInfoDao.findAll();
	}

	// 透過id取得對應的個人資訊
	@Override
	public PersonInfo findById(String id) {

		if (!StringUtils.hasText(id)) {
			return null;
		}
		Optional<PersonInfo> op = personInfoDao.findById(id);
		if (op.isEmpty()) {
			return null;
		}
		return op.get();
	}

	@Override
	public PersonInfo addInfoList1(List<PersonInfo> infoList) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
