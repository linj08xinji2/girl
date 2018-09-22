package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Girl;
import com.demo.repository.GirlRepository;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional  // 事务
	public void insertTwo(){
		Girl girl=new Girl();
		girl.setAge(25);
		girl.setCupsize("B");
		girlRepository.save(girl);
		
		Girl girlB=new Girl();
		girlB.setAge(25);
		girlB.setCupsize("C");
		girlRepository.save(girlB);
	}
}
