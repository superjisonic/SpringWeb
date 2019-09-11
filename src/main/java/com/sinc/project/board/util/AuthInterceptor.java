package com.sinc.project.board.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//세션이 있다 없다 판단 ->있으면 그냥 감 -> 없으면 로그인페이지로 가면된다. response를 다루면됨.
		System.out.println("Interceptor >>>>>>>>>>>>>>>>>>>> auth");
		HttpSession session = request.getSession();//이걸가지고 session.context에 접근하면됨
		String path ="/user/loginForm.sinc";
		if(session.getAttribute("loginUser")==null) {
			savePath(request); //보내주고 리다이어렉트
			response.sendRedirect(path);
			return false;
		}
		return true; //controller를 넘기는것
	}
	/*login인터셉터에서 현재 path를 받아 볼 수 있게 만들어주는 메서드*/
	public void savePath(HttpServletRequest request) {
		String uri = request.getRequestURI(); // 이렇게 하면 겟방식.. 뒷부분을 못갖고옴
		String queryString = request.getQueryString(); //이렇게 하면 위URI의 뒷부분을 다 갖고 올 수 있다.
		if(queryString == null||queryString.equals("null")) {
			queryString = "";
		}else {
			queryString =  "?" +queryString;
		}
		request.getSession().setAttribute("savePath", uri+queryString);
		System.out.println("auth >>>>>>>>> savePath"+ uri+queryString);
	}
}
