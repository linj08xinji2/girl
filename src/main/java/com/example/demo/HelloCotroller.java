package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 上面等于 @Controller
// @ResponseBody
// @RequestMapping(value="")
public class HelloCotroller {

	@Value("${cupsize}")
	private String cupsize;

	@Value("${age}")
	private int age;

	@Value("${context}")
	private String context;

	@Autowired
	private GirlProperties girl;

	@RequestMapping(value = { "/hello", "/hi" }, method = RequestMethod.GET)
	public String say() {
		return "hi,my lover!" + girl.getCupsize();
	}

	// http://127.0.0.1:8080/testid/23
	@RequestMapping(value = "/testid/{id}", method = RequestMethod.GET)
	public String sayhi(@PathVariable(value = "id") int myid) {
		return "hi,my lover!" + myid;
	}

	// http://127.0.0.1:8080/myid?id=1234
	@RequestMapping(value = "/myid", method = RequestMethod.GET)
	public String sayhello(
			@RequestParam(value = "id", required = false, defaultValue = "0") int myid) {
		return "hi,myid：" + myid;
	}
}
