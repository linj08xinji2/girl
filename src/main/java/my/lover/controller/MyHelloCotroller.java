package my.lover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Girl;
import com.demo.service.GirlMybatis;

@RestController
public class MyHelloCotroller {
	
	@Autowired
	private GirlMybatis girlMybatis;

	@RequestMapping(value = { "/mylover"}, method = RequestMethod.GET)
	public String say() {
		return "hi,my lover!";
	}
	
	@RequestMapping(value = { "/lover"}, method = RequestMethod.GET)
	public String say2() {
	List<Girl>	list=girlMybatis.queryByAll();
	System.out.println("aaaa:"+list.size());
		return "hi,my lover22222!";
	}
}
