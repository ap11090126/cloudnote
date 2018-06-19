package cn.tedu.cloudnote.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerBean {
	@Before("within(cn.tedu.cloudnote.controller..*)")
	public void logController(){
		
		System.out.println("AOP功能注入Controller");
	}
	@Before("within(cn.tedu.cloudnote.service..*)")
public void logService(){
		
		System.out.println("AOP功能注入Service");
	}

}
