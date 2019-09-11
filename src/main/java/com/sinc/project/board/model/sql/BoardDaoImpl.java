package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.project.board.model.vo.BoardVO;

@Repository("boardD")
public class BoardDaoImpl implements BoardDao {
	
	
	//의존성 주입
	/*
	 * @Autowired
	 * private SqlSession session;
	 * 
	 * */
	
	@Resource(name="sqlSession")
	private SqlSession session;

	@Override
	public List<BoardVO> listRow() {
		System.out.println("board dao print");
		return session.selectList("com.sinc.board.list");
	}

	@Override
	public int registerRow(BoardVO board) {
		return session.insert("com.sinc.board.registerBoard",board); 
	}

	@Override
	public List<BoardVO> searchRow(Map<String, String> map) {
		return session.selectList("com.sinc.board.searchAjax",map);
	}

	@Override
	public BoardVO readRow(BoardVO board) {
		return session.selectOne("com.sinc.board.readBoard", board);
	}
	
}
