package com.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Girl {

	@Id
	@GeneratedValue
	private Integer id;
	private String cupsize;
	private Integer age;
	
	public Girl() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCupsize() {
		return cupsize;
	}

	public void setCupsize(String cupsize) {
		this.cupsize = cupsize;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
