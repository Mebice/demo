package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.PersonInfo;

public interface PersonInfoService {

	public void addInfo(PersonInfo info);
	
	public void addInfoList(List<PersonInfo> infoList); // �s�W�h�� 

	public PersonInfo addInfoList1(List<PersonInfo> infoList); // �s�W�h��

	public List<PersonInfo> findAll(); // �d�ߥ��� 

	public PersonInfo findById(String id); // �d�߯S�w  // �z�Lid���o�������ӤH��T
	
	
}
