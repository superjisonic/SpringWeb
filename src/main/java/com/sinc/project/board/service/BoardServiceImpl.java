package com.sinc.project.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.board.model.sql.BoardDao;
import com.sinc.project.board.model.vo.BoardVO;

@Service("boardS")
public class BoardServiceImpl implements BoardService {
	
	/*//의존성주입
	 * @AutoWired
	 * privateDao dao;
	 * 
	 * */
	@Resource(name="boardD")
	private BoardDao dao;

	@Override
	public List<BoardVO> listService() {
		// TODO Auto-generated method stub
		return dao.listRow();
	}

	@Override
	public int registerService(BoardVO board) {
		
		return dao.registerRow(board);
	}

	@Override
	public List<BoardVO> searchService(Map<String, String> map) {
		return dao.searchRow(map);
	}

	@Override
	public BoardVO readService(BoardVO board) {
		return dao.readRow(board);
	}
	

	
}
