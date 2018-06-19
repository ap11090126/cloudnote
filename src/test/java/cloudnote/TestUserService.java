package cloudnote;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloudnote.dao.UserDao;
import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.service.UserService;
import cn.tedu.cloudnote.service.UserServiceImpl;
import cn.tedu.cloudnote.util.NoteResult;

public class TestUserService {
	UserService service;
	private ApplicationContext ac;
	@Before
	public void init(){
		String[] conf={"conf/spring-mybatis.xml","conf/springmvc.xml","conf/spring-transaction.xml"};
		ac=new 
				ClassPathXmlApplicationContext(
						conf);
		service=ac.getBean("userService",UserService.class);
		
	}
		
	
	@Test
	public void test1(){
	
	UserDao dao=ac.getBean("userDao",UserDao.class);
	User user=dao.findByName("demo");
	System.out.println(user);
	}
	@Test
	public void test2(){
		NoteResult<User> result=
				service.checkLogin("demo","123");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());		
	}
	@Test
	public void test3(){
		NoteResult<User> result=
				service.checkLogin("demo1","c8837b23ff8aaa8a2dde915473ce0991");
		System.out.println(service.getClass().getName());
		//	System.out.println(result.getStatus());
	//	System.out.println(result.getMsg());
	//	System.out.println(result.getData());
	}
	@Test
	public void test4(){
		NoteResult<User> result=
				service.checkLogin("demo","c8837b23ff8aaa8a2dde915473ce0991");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	@Test
	public void test5(){
		NoteResult<Object> result=
				service.addUser("ADP", 
						"123456","豪哥");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	@Test
	public void testSave(){
		UserDao dao=ac.getBean("userDao",UserDao.class);
		User user=new User();
		user.setCn_user_id("");
		user.setCn_user_name("ATP");
		user.setCn_user_password("123456");
		user.setCn_user_nick("豪哥");
		dao.save(user);
		System.out.println(user);
	}
}
