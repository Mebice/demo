package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.PersonInfo;

public interface PersonInfoDao extends JpaRepository<PersonInfo,String>{

	//�۩w�q //findByCity �� City �O�ݩʦW��,�j�g�O�]���p�m�p�R�W //�u�n���O�浧�N�n��List���^
	public List<PersonInfo> findByCity(String city);
	
	public List<PersonInfo> findByNameAndCity(String name,String city);
	
	public List<PersonInfo> findByNameOrCity(String name,String city);
	
	//��X�~���j���J���󪺩Ҧ��ӤH��T
	public List<PersonInfo> findByAgeGreaterThan(int age);
	
	//��X�~���p�󵥩��J���󪺩Ҧ��ӤH��T
	//�~�֥Ѥp��j�Ƨ�
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age);
	
	//���~�֤p���J����1�άO�j���J����2����T 
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int age1,int age2);
	
	//���~������2�ӼƦr����(���]�t)����T
	//�~�֥Ѥj��p�Ƨ�
	//�u���e3�����
	public List<PersonInfo> findFirst3ByAgeBetweenOrderByAgeDesc(int age1,int age2);
	
	//���ocity�]�t�Y�ӯS�w�r���Ҧ��ӤH��T
	public List<PersonInfo> findByCityContaining(String city);
	
	// ��X�~���j���J����H��city�]�t�Y�ӯS�w�r���Ҧ��ӤH��T
	//�~�֥Ѥj��p�Ƨ�
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age,String city);
	
}
