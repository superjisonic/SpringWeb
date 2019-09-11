package com.sinc.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinc.project.test.service.TestServiceImpl;

/*annotaion추가하면 새 콘트롤러 객체를 호출한고임*/
@Controller
//@RequestMapping("/bbs") //이렇게 콘트롤러에 리퀘스트 매핑을 걸어주면 무조건 이걸 디폴트로 추가해나간다
public class TestController {
	
	//name은 루트 컨텍스트에 있는 testS를 찾는것
	@Resource(name="testS") //TestServiceImpl의 @Service("testS")와 매칭이된다.
	private TestServiceImpl service;
	
	@RequestMapping("/dependency.sinc")
	public String dependency() {
		System.out.println("test dependency");
		System.out.println(service.sayEcho("맛점하시구요~~~ 초복!!!!"));
		return "home";
	}
	
	/*매개변수의 타입만 지정해주면 리퀘스트 스콥을 할 필요없이  모델의 스콥은 리퀘스트의 스콥까지이기 때문에 존나 가능*/
	@RequestMapping("/index.sinc")
	public String main(Model model) {
		System.out.println("test main");
		model.addAttribute("msg","Hi~~~~~~~~~~");
		return "home";
	}
	//이건 안됨. void로 하면 리퀘들어오는 url과 ㅏㅌ은 이름을 보고 찾는데. 뷰폴더 밑에 a.jsp가 없으니까 못찾는고임 현재 바꿔놓음
	/*
	 * @RequestMapping("/test/a.sinc") public void doA() {
	 * System.out.println("test main"); }
	 */
	
	@RequestMapping("/a.sinc")
	public String doA() {
		System.out.println("test main");
		return "test/a";
	}
	@RequestMapping("/b.sinc")
	public ModelAndView doB() {
		System.out.println("test main");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("msg", "Hi, model and view");
		return mv;
	}
	
	
	
}
