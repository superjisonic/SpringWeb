package com.sinc.project.user.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("interceptor >>>>>>>>>> post ");
		HttpSession session = request.getSession();
		ModelMap model = modelAndView.getModelMap(); //유저에 심은 모델이 겟모델맵을 통해 가져올 수 있다.
		Object obj = model.get("user");
		
		String dest = checkDestination(request);
		String path = (dest != null) ? dest : "/"; //잘못된 값일시 루트로 돌아가라.
		
		

		if (obj != null) {
			//interceptor 성공시 세션작업 
			System.out.println("Interceptor >>>>>>>>> Success");
			session.setAttribute("loginUser", obj);
			response.sendRedirect(path);
		}else {
			response.sendRedirect("/user/loginForm.sinc");
		}
	}
	/*화면에 대한 분기가 정상적으로 이루어져야함. -> 작업 필요*/
	/*로그인 되지 않은 상태에서 글쓰기 버튼 누르면 로그인 화면 -> 로그인시 다시 그 화며으로 넘어감*/
	public String checkDestination(HttpServletRequest request) {//request를 통해 사용자가 현재 어디에 있는지 url받아옴
		System.out.println("interceptor >>>>>>>>>>> save path");
		HttpSession session = request.getSession();
		String savePath = (String)session.getAttribute("savePath");
		session.removeAttribute("savePath");
		System.out.println("login >>>>>>>>>>>>>>>>>>>>>>>>>>getPath : "+savePath);
		return savePath;
	}
}
