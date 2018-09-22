package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

	// 根据年龄来查询
	public List<Girl> findByAge(Integer age);
}
