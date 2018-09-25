package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.domain.Girl;

@Mapper
// 或在启动类增加@MapperScan()
public interface GirlMapper {
	public List<Girl> queryByAll();
}
