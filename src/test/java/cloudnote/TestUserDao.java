package cloudnote;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloudnote.dao.UserDao;
import cn.tedu.cloudnote.entity.User;

public class TestUserDao {
	@Test
	public void test1(){
	ApplicationContext ac=new 
			ClassPathXmlApplicationContext(
					"conf/spring-mybatis.xml");
	UserDao dao=ac.getBean("userDao",UserDao.class);
	User user=dao.findByName("demo");
	System.out.println(user);
	}
}
