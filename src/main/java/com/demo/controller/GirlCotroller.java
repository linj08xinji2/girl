package com.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Girl;
import com.demo.domain.Result;
import com.demo.repository.GirlRepository;
import com.demo.service.GirlService;
import com.demo.utils.ResultUtils;

@RestController
public class GirlCotroller {

//	private final static Logger logger = LoggerFactory
//			.getLogger(GirlCotroller.class);
	
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
/*	@PostMapping("/girls")
	public Girl addGirl(@RequestParam("cupsize") String cupsize,
			@RequestParam("age") Integer age){
		Girl girl=new Girl();
		girl.setAge(age);
		girl.setCupsize(cupsize);
		return girlRepository.save(girl);
	}*/
	
	
	/**
	 * 增加一个女生
	 * */
	/* @PostMapping("/girls")
	public Object addGirl(@Valid Girl girl,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
//			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			String message=bindingResult.getFieldError().getDefaultMessage();
//			logger.info(message);
			return message;
		}
		girl.setAge(girl.getAge());
		girl.setCupsize(girl.getCupsize());
		return girlRepository.save(girl);
	}
	*/
	
	/**
	 * 增加一个女生
	 * */
/*	@PostMapping("/girls")
	public Result<Girl> addGirl(@Valid Girl girl,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			Result<Girl> result=new Result<Girl>();
			result.setCode(1);
			result.setMessage(bindingResult.getFieldError().getDefaultMessage());
			return result;
		}
		girl.setAge(girl.getAge());
		girl.setCupsize(girl.getCupsize());
		
		Result<Girl> result=new Result<Girl>();
		result.setCode(0);
		result.setMessage("success");
		result.setData(girlRepository.save(girl));
		return result;
	}
	*/
	
	@SuppressWarnings("unchecked")
	/**
	 * 增加一个女生
	 * */
	@PostMapping("/girls")
	public Result<Girl> addGirl(@Valid Girl girl,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		girl.setAge(girl.getAge());
		girl.setCupsize(girl.getCupsize());
		
		return ResultUtils.success(girlRepository.save(girl));
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
	
	/***
	 * 异常处理
	 * @param id
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/girls/getAge/{id}")
	public Result<Girl> getAge(@PathVariable("id") Integer id) throws Exception{
		// 异常，不会再执行以下语句
		return ResultUtils.success(girlService.getAge(id));
	}
}
