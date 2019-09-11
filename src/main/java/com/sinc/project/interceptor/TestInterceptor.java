package com.sinc.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Intercepter >>>>>>>>>>>>>>>>>>>> pre");
		
		return super.preHandle(request, response, handler);
	}
	//modelAndView에 모델값 심을 수 있었음. control을 타고나서 postHandle이라는 것을 실행할 수 있는거임. 모델에 심은 값을 모델앤뷰로 받을 수 있다는것
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Intercepter >>>>>>>>>>>>>>>>>>>> post");
		super.postHandle(request, response, handler, modelAndView);
	}
}
