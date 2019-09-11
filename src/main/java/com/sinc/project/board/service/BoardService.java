package com.sinc.project.board.service;

import java.util.List;
import java.util.Map;

import com.sinc.project.board.model.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> listService();
	public int registerService(BoardVO board);
	public List<BoardVO> searchService(Map<String, String> map);
	public BoardVO readService(BoardVO board);
}
