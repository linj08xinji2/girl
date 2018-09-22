package com.demo.exception;

import com.demo.utils.ResultEnum;


/**
 * 自定义异常类
 *
 */
public class GirlException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1532175150989617871L;

	/*public GirlException(Integer code,String message) {
		super(message);
		this.code = code;
	}
*/

	public GirlException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}


	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
