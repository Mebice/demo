package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@SpringBootTest
public class AtmServiceTest {
	
	@Autowired
	private AtmService atmService;
	
	@Test
	public void addInfoTest() {
		AtmResponse res = atmService.addInfo("A01","AA123");
		System.out.println(res.getRtnCode().getCode());
		System.out.println(res.getRtnCode().getMessage());
		System.out.println(res.getAtm().getAccount());
		System.out.println(res.getAtm().getPwd()); 
	}
	
	//¦s´Ú
	@Test
	public void depositTest() {
		AtmResponse res = atmService.deposit("A01", "AA123", 2000);
		System.out.println(res.getRtnCode().getCode());
		System.out.println(res.getRtnCode().getMessage());
		System.out.println(res.getAtm().getAccount());
		System.out.println(res.getAtm().getPwd());
		System.out.println(res.getAtm().getBalance());
	}
	
	// ´£´Ú
	@Test
	public void withdrawTest() {
		AtmResponse res = atmService.withdraw("A01", "AA123", 2500);
		System.out.println(res.getRtnCode().getCode());
		System.out.println(res.getRtnCode().getMessage());
		System.out.println(res.getAtm().getAccount());
		System.out.println(res.getAtm().getPwd());
		System.out.println(res.getAtm().getBalance());
	}
		

}
