package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Menu;
import com.example.demo.entity.PersonInfo;

@Repository									//<class�W��,��ƫ��A>
public interface MenuDao extends JpaRepository<Menu, String> {
	

}
