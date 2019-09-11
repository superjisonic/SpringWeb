package com.sinc.project.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinc.project.test.model.dao.DaoImpl;

@Service("testS")
public class TestServiceImpl {
	
	@Autowired
	//세터인젝션 또는 프로퍼티 인젝션이라고 표현
	private DaoImpl dao;
	public TestServiceImpl() {
		
	}
	public TestServiceImpl(DaoImpl dao) {
		this.dao = dao;
	}
	
	/*
	 * public void setDao(DaoImpl dao) { this.dao=dao; }
	 */
	public String sayEcho(String msg) {
		System.out.println("service sayEcho~");
		dao.sampleRow();
		return msg;
	}
	
}
