package com.sinc.project.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sinc.project.user.model.vo.UserVO;
import com.sinc.project.user.service.UserService;

@Controller
@RequestMapping("/user")
//@SessionAttributes({"loginUser"}) 일단 이거 주석처리..Spring에서 관리하는 scope//이렇게 하면 model의 scope이 session의 scope으로 변경된다.
public class UserCtrl {
	
	@Resource(name="userS")
	private UserService service;//의존성 주입!
	

	@RequestMapping("/loginForm.sinc")
	public String loginForm() {
		return "/user/login";
	}
	
	@RequestMapping(value="/login.sinc", method=RequestMethod.POST)
	public void login(UserVO user, Model model) {
		/*
		 * //UserVO user자동으로 타입이 캐스팅되서 들어옴~
		 * 사실 이렇게 안하고String id, String pwd해도 됨.(신기)
		 * 
		 * @RequestParam(name="id", required=true) 이렇게 해도됨.
		 * 이런식으로 하면 여기서 하나하나 requestParam을 하기엔 넘모 번거로움 -> UserVO단에서 관리를 해주고 하나의 객체로 받는게 편함.
		 * 현업에서는 map.put("id",id) map.put("pwd",pwd);
		 * service.xxxx(map) 해서 한번 넘기면됨....!
		 * 
		 * 어노테이션을 쓰기떄문에 이름이 일치하는걸로 알아서 타입별로 파람이 받아진다.
		 * 
		 * HttpSession session을 추가해서 세션관리 가능
		 * session.setAttribute(name, value);
		 * */
		System.out.println("user ctrl login");
		//넘겨받은 의존성으로...
		UserVO result = service.loginService(user);
		if(result!=null) {
			model.addAttribute("user",result);
		}else {
			//여기에 무엇이 들어갈지 고민해보세요
		}
		
	}
	
	/* scope가 변경이 되지 않으므로.... scope와 함께써야하는 코드
	@RequestMapping("/logout.sinc")
	public String logout(SessionStatus status) { 
		System.out.println("user ctrl logout");
		status.setComplete();
		return "redirect:/index.jsp";
	}
	*/
	@RequestMapping("/logout.sinc")
	public String logout(HttpSession session) { //WAS전용세션 웹으로 접근해야 인터셉터에서 접근 가능. 위의 방법으로 하면 container상의 session이기 때문에 접근불가.
		session.invalidate();
		return "redirect:/index.jsp";
	}
	/*옛날 코드임. 걍 invalidate통해 세션을 날려버림
	@RequestMapping("/logout.sinc")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}
	*/
	
}
