package com.sinc.project.aop.core;

import org.springframework.stereotype.Component;

//@Service("serviceTarget")줘도됨
@Component("serviceTarget")
public class SincServiceImpl implements SincService {

	@Override
	public String sayEcho(String msg) throws Exception  {
		System.out.println("core sayEcho()");
		if(true) {
			throw new Exception();
		}
		return msg;
	}

}
