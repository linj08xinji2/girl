package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Girl;
import com.demo.repository.GirlRepository;
import com.demo.service.GirlService;

@RestController
public class GirlCotroller {

	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService  girlService;
	
	/**
	 * 查询所有
	 * */
	@GetMapping("/girls")
	public List<Girl> getGirlList(){
		return girlRepository.findAll();
	}
	
	/**
	 * 增加一个女生
	 * */
	@PostMapping("/girls")
	public Girl addGirl(@RequestParam("cupsize") String cupsize,
			@RequestParam("age") Integer age){
		Girl girl=new Girl();
		girl.setAge(age);
		girl.setCupsize(cupsize);
		return girlRepository.save(girl);
	}
	
	/***
	 * 查询一个女生
	 * @param id
	 * @return
	 */
	@GetMapping("/girls/{id}")
	public Optional<Girl> getAGirlfindOne(@PathVariable("id") Integer id){
		return	girlRepository.findById(id);
//		return girlRepository.getOne(id);
	}
	
	/**
	 * 修改一个女生
	 * */
	@PutMapping("/girls/{id}")
	public void updateGirl(@PathVariable("id") Integer id,
			@RequestParam("cupsize") String cupsize,
			@RequestParam("age") Integer age){
		Girl girl=new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setCupsize(cupsize);
		girlRepository.save(girl);
	}
	
	/***
	 * 删除一个女生
	 * @param id
	 * @return
	 */
	@DeleteMapping("/girls/{id}")
	public void deleteGirl(@PathVariable("id") Integer id){
		 girlRepository.deleteById(id);
	}
	
	/***
	 * 根据年龄来查询
	 * @param id
	 * @return
	 */
	@GetMapping("/girlsByage")
	public List<Girl> getAGirlfindByAge(@RequestParam("age") Integer age){
		return	girlRepository.findByAge(age);
	}
	
	/***
	 * 事务
	 * @param id
	 * @return
	 */
	@PostMapping("/girlsTwo")
	public void insertTwo(){
	 girlService.insertTwo();
	}
}
