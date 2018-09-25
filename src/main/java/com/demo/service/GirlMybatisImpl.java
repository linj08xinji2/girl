package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Girl;
import com.demo.mapper.GirlMapper;

@Service
public class GirlMybatisImpl implements GirlMybatis {

	@Autowired
	private GirlMapper girlMapper;

	@Override
	public List<Girl> queryByAll() {
		return girlMapper.queryByAll();
	}

}
