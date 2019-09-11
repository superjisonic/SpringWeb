package com.sinc.project.aop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*POJO형식*/
@Component("loginAspect")
@Aspect //Aop관련 어노테이션
public class LoginAspect {
	
	@Before("execution(public * com.sinc.project..*Impl.say*(..))")//root-context.xml에서 가져온것. 똑같은 기능을 어노테이션으로 구현한 것이다.
	public void before(JoinPoint join) {
		System.out.println("aspect >>>>>>>>>>>>>>>>>>>>> before advice");
	}
	/*예외가 throw되었을때 동작하도록 만듦*/
	@AfterThrowing(pointcut="execution(public * com.sinc.project..*Impl.say*(..))",throwing="e")
	public void throwing(Exception e) {
		e.printStackTrace();
	}
	
	
}
