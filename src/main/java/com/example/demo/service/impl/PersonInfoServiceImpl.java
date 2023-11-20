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
			personInfoDao.save(info); // save��jpa����k�A����\�e�����D�A�ݨϥ�existsById
		} else {
			System.out.println("id error!!!");
		}
	}

	@Override
	public void addInfoList(List<PersonInfo> infoList) { // ���] infoList �� 10 �����
		String pattern = "[A-Za-z][1,2]\\d{8}";
		for (PersonInfo item : infoList) {
			String id = item.getId();
//			if (!(StringUtils.hasText(id) && id.matches(pattern))) {  //�覡1
//				System.out.println("id error!!!");
//				return;
//			}
			if (!StringUtils.hasText(id) || !id.matches(pattern)) { // �覡2 �A���@�ӱ��󥼺�����
				System.out.println("id error!!!");
				return;
			}
		}
		personInfoDao.saveAll(infoList);
	}


//	// �i�Ы�1~�h����T(�b���έ^��r���}�Y)�A�u��s�W�s��T�A�^�ǳQ�Ыت���T�B�T��
//	@Override
//	public PersonInfo addInfoList1(List<PersonInfo> infoList) {
//		String pattern = "[A-Za-z]\\d{9}";
//		for (PersonInfo item : infoList) {
//			String id = item.getId();
//			if (!StringUtils.hasText(id) || !id.matches(pattern)) {
//				return null;
//			}
//			if (personInfoDao.existsById(id)) { // �u��s�W�s��T(�O�_�s�b�A�s�b���s�W)
//				return null;
//			}	
//			infoList.add(personInfoDao.save(item));
//		}
//		return infoList;
//	}

	// �d�ߥ��� //���o�Ҧ��ӤH��T
	@Override
	public List<PersonInfo> findAll() {
		return personInfoDao.findAll();
	}

	// �z�Lid���o�������ӤH��T
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
