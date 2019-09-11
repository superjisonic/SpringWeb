package com.sinc.project.board.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.project.board.model.vo.BoardVO;
import com.sinc.project.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardCtrl {
	
	@Resource(name="boardS")
	private BoardService service ;
	
	@RequestMapping(value="/listPage.sinc", method = RequestMethod.GET)
	//ModelMap이랑 ModelandView랑 똑같음
	public String list(ModelMap model) {
		List <BoardVO> list = service.listService();
		model.addAttribute("list", list);
		return "/board/listPage";
	}
	@RequestMapping(value="/register.sinc", method = RequestMethod.GET)
	public void register() {
		
	}
	@RequestMapping(value="/registerBoard.sinc", method = RequestMethod.POST)
	public String register(BoardVO board) {
		int resultFlag = service.registerService(board);
		if(resultFlag != 0) {
			return "redirect:/board/listPage.sinc";
		}
		return null;
	}
	
	@RequestMapping(value="/search.sinc", method = RequestMethod.POST)
	@ResponseBody //ajax 콘트롤러는 반드시 이 annotation을 가져야한다.
	public List<BoardVO> search(String type, String keyword, HashMap<String, String> map) {
		System.out.println(type+" , "+keyword);
		map.put("type", type);
		map.put("keyword", keyword);
		//return null;
		return service.searchService(map); //type으로 searchService(type,keyword)로 넘겨도 되지만 어차피 리스트 보드객체로 넘어가기때문에 상관 없.
	}
	
//	@RequestMapping(value="/readPage.sinc", method = RequestMethod.GET)
//	public void readPage(BoardVO board, ModelMap model) {
//		System.out.println("readPage");
//		model.addAttribute("board", service.readService(board));
//		
//	}
	@RequestMapping(value="/readPage.sinc", method = RequestMethod.GET)
	public String view(BoardVO board, Model model) {
		BoardVO result = new BoardVO(1,"공지","집중근무시간","admin","2019-07-16",0);
		model.addAttribute("boardVO", service.readService(board));
		return "/board/read";
	}
	/*
	 * @RequestMapping(value="/removePage.sinc", method = RequestMethod.GET) public
	 * String remove(BoardVO board) {
	 * 
	 * return "/board/read/listPage.sinc"; }
	 * 
	 * @RequestMapping(value="/removePage.sinc", method = RequestMethod.GET) public
	 * String modify(BoardVO board) {
	 * 
	 * return "/board/modify/readPage.sinc"; }
	 * 
	 */	
	
}
