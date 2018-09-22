package com.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Girl;
import com.demo.exception.GirlException;
import com.demo.repository.GirlRepository;
import com.demo.utils.ResultEnum;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;
	
	// 事务
	@Transactional
	public void insertTwo() {
		Girl girl = new Girl();
		girl.setAge(25);
		girl.setCupsize("B");
		girlRepository.save(girl);

		Girl girlB = new Girl();
		girlB.setAge(25);
		girlB.setCupsize("C");
		girlRepository.save(girlB);
	}

	/**
	 * 异常处理
	 * 
	 * @param id
	 * @throws Exception
	 */
	/*public void getAge(Integer id) throws Exception {
		Optional<Girl> girl = girlRepository.findById(id);
		Integer age = girl.get().getAge();
		if (age < 10) {
			throw new Exception("还在上小学");
		}

		if (age >= 10 && age <= 16) {
			throw new Exception("还在上初中");
		}
	}*/
	
	/**
	 * 异常处理
	 * 
	 * @param id
	 * @throws Exception
	 */
	/*public void getAge(Integer id) throws Exception {
		Optional<Girl> girl = girlRepository.findById(id);
		// 数据库没有数据，会报这个错误 java8处理空指针异常
		// java.util.NoSuchElementException: No value present
		Integer age = girl.get().getAge();
		if (age < 10) {
			throw new GirlException(101,"还在上小学");
		}

		if (age >= 10 && age <= 16) {
			throw new GirlException(102,"还在上初中");
		}
	}*/
	
	/**
	 * 异常处理
	 * 
	 * @param id
	 * @throws Exception
	 */
	
	public Object getAge(Integer id) throws Exception {
		Optional<Girl> girl = girlRepository.findById(id);
		// 数据库没有数据，会报这个错误 java8处理空指针异常
		// java.util.NoSuchElementException: No value present
		Integer age = girl.get().getAge();
		if (age < 10) {
			// 错误信息统一管理
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}

		if (age >= 10 && age <= 16) {
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
		return girl;
		
	}
}
