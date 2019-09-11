package com.sinc.project.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.user.model.sql.UserDao;
import com.sinc.project.user.model.vo.UserVO;

//Annotation을 걸지 않으면 객체생성이 되지 않음.
@Service("userS")//해당 어노테이션의 이름은 userS
public class UserServiceImpl implements UserService {
	
	@Resource(name="userD")
	private UserDao dao;
	@Override
	public UserVO loginService(UserVO user) {
		System.out.println("user service login");
		return dao.loginRow(user);//userDao의존관계 주입받기~
	}
	
}
