package com.sinc.project.user.model.sql;

import com.sinc.project.user.model.vo.UserVO;

public interface UserDao {
	public UserVO loginRow(UserVO user); //원래 Obect 클래스로 하지만,,, 이제는 프레임웤에서 알아서 해주기때문에  걍 이렇게 해도됨...
}
