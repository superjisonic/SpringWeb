package com.sinc.project.test.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.project.test.model.vo.TestVO;

@Repository("dao")
public class DaoImpl {
	
	//name은 root context의
	/*
	 * <!-- 6. @repository 에서 의존성 주입을 위한 설정 --> <bean id="sqlSession"
	 * class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">
	 * <constructor-arg name="sqlSessionFactory"
	 * ref="sqlSessionFactory"></constructor-arg> </bean>
	 * 
	 * 이 부분의 id에서 갖고옴
	 */
	@Resource(name="sqlSession")
	private SqlSession session;
	
	
	public void sampleRow() {
		System.out.println("dao sampleRow~");
		/*
		 * List<TestVO> list = session.selectList("com.sinc.test.select"); //xml에 명시된
		 * 식별자를 찾는것. 오류가 나지 않으려면 패키지명 앞부분부터 잘 기입 for(TestVO obj : list) {
		 * System.out.println(obj); }
		 */
		
		/*insert update update는 리턴타입이 없당*/
		TestVO vo = new TestVO("sinc","sinc","신세계");
		int flag = session.insert("com.sinc.test.insert",vo);
		System.out.println(flag);
		
		
		
	}
}
