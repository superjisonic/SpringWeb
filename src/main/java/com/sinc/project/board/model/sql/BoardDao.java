package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import com.sinc.project.board.model.vo.BoardVO;

public interface BoardDao {
	public List <BoardVO> listRow();
	public int registerRow(BoardVO board);
	public List<BoardVO> searchRow(Map<String, String> map);
	public BoardVO readRow(BoardVO board);
}
