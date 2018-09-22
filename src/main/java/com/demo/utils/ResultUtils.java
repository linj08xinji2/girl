package com.demo.utils;

import com.demo.domain.Result;

public class ResultUtils {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Result success(Object object){
		Result result=new Result();
		result.setCode(0);
		result.setMessage("success");
		result.setData(object);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public static Result success(){
		return success(null);
	}
	
	@SuppressWarnings({ "rawtypes"})
	public static Result error(Integer code,String message){
		Result result=new Result();
		result.setCode(code);
		result.setMessage(message);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public static Result error(ResultEnum resultEnum){
		Result result=new Result();
		result.setCode(resultEnum.getCode());
		result.setMessage(resultEnum.getMessage());
		return result;
	}
}
