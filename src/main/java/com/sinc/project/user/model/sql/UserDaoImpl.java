package com.sinc.project.user.model.sql;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.project.user.model.vo.UserVO;

@Repository("userD") //프레임웤에 객체생성을 요구
public class UserDaoImpl implements UserDao {
	
	@Resource(name="sqlSession")
	private SqlSession session;//설정파일에 있는 6번 파트의 id값
	
	@Override
	public UserVO loginRow(UserVO user) {
		// MyBatis사용해야 디비 접근해서 유저정보 갖고옴
		System.out.println("user dao login");
		return session.selectOne("com.sinc.user.login", user); //이 태그의 식별자(mapper namespace)를 찾아서 user에게 정보를 넘김ㅁ
	}

}
