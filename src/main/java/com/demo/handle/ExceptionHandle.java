package com.demo.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.domain.Result;
import com.demo.exception.GirlException;
import com.demo.utils.ResultEnum;
import com.demo.utils.ResultUtils;

/**
 * 异常处理类
 *
 */
@ControllerAdvice
public class ExceptionHandle {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if (e instanceof GirlException) {
			GirlException exception = (GirlException) e;
			return ResultUtils.error(exception.getCode(),
					exception.getMessage());
		} else {
			// 数据库没有数据，会报这个错误
//			return ResultUtils.error(-1, "未知异常");
			return ResultUtils.error(ResultEnum.UNKOWN_ERROR);
		}
	}
}
