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
	
	//�浧
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

	//�h���A���Φh���ާ@
	@Test
	public void daoSaveAllTest() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("A123456787","DDD",28,"Kaohsiung"));
		list.add(new PersonInfo("E123456787","EEE",30,"Taichung"));
		personInfoDao.saveAll(list);
	}
	
	// �B�z�i��䤣�������ƪ����p	 //Optional �O���F�B�z�d�ߵ��G���Ū����p
	// �u�� findById �� Optional
	@Test
	public void daoFindTest() {		
		Optional<PersonInfo> infoOp = personInfoDao.findById("A123456781");  //findById �� Id �O�� PK �����A�P�W�ٵL��
		// �ˬd Optional �O�_���šA�]�N�O�d�䵲�G�O�_���šC�p�G�O�Ū��A�L�X "Not found!!"�A�M���^
		if(infoOp.isEmpty()) {	
			System.out.println("Not found!!");
			return;
		}
		//�N�QOptional�]��������X
		System.out.println(infoOp.get().getName());					
	}
	
	//�d�ߩҦ�
	@Test
	public void daoFindTest2() {
		List<PersonInfo> list = personInfoDao.findAll();
		for(PersonInfo item : list) {
			System.out.println(item.getName());
		}
	}
	
	// ��ƬO�_�s�b //�Ҧp:�ӱb���O�_�s�b
	@Test
	public void daoFindTest3() {
		boolean result=personInfoDao.existsById("A123456787");
		System.out.println(result);
	}
	
	//�d��city�����  //.findBy ���T�w�d�䪺��k 
	@Test
	public void daoFindTest4() {
//		List<PersonInfo> result = personInfoDao.findByCity("Kaohsiung");
//		List<PersonInfo> result = personInfoDao.findByNameAndCity("DDD","Kaohsiung");
		List<PersonInfo> result = personInfoDao.findByNameOrCity("DDD","Kaohsiung");
		for(PersonInfo item : result) {
			System.out.println(item.getName());
		}
	}
	
	//��X�~���j���J���󪺩Ҧ��ӤH��T
	@Test
	public void compareTest() {
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThan(28);
		for (PersonInfo item : res) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
	
	//��X�~���p�󵥩��J���󪺩Ҧ��ӤH��T//�Ѥp��j�Ƨ�
	@Test
	public void compareTest1() {
		List<PersonInfo> res = personInfoDao.findByAgeLessThanEqualOrderByAge(25);
		for (PersonInfo item : res) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
	
	//���~�֤p���J����1�άO�j���J����2����T   
	@Test
	public void compareTest2() {
		List<PersonInfo> res = personInfoDao.findByAgeLessThanOrAgeGreaterThan(24,28);
		for (PersonInfo item : res) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
	
	//���~������2�ӼƦr����(���]�t)����T
		//�~�֥Ѥj��p�Ƨ�
		//�u���e3�����
	@Test
	public void betweenTest() {
		List<PersonInfo> res = personInfoDao.findFirst3ByAgeBetweenOrderByAgeDesc(24,28);
		for (PersonInfo item : res ) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
	
	//���ocity�]�t�Y�ӯS�w�r���Ҧ��ӤH��T
	@Test
	public void containingTest() {
		List<PersonInfo> res = personInfoDao.findByCityContaining("K");
		for (PersonInfo item : res ) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
	
	// ��X�~���j���J����H��city�]�t�Y�ӯS�w�r���Ҧ��ӤH��T
	//�~�֥Ѥj��p�Ƨ�
	@Test
	public void containingTest2() {
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThanAndCityContainingOrderByAgeDesc(24,"T");
		for (PersonInfo item : res ) {
			System.out.println(item.getId() + item.getName() + item.getAge() + item.getCity());
		}		
	}
}
