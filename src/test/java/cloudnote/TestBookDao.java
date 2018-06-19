package cloudnote;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloudnote.dao.BookDao;
import cn.tedu.cloudnote.dao.UserDao;
import cn.tedu.cloudnote.entity.Book;
import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.service.UserService;
import cn.tedu.cloudnote.service.UserServiceImpl;
import cn.tedu.cloudnote.util.NoteUtil;

public class TestBookDao {
	BookDao dao;
	private ApplicationContext ac;
	@Before
	public void init(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		dao=ac.getBean("bookDao",BookDao.class);
	}
	
	@Test
	public void test1(){

	List<Book> list=dao.findByUserId(
			"52f9b276-38ee-447f-a3aa-0d54e7a736e4");
	for(Book book:list){
		System.out.println(book.getCn_notebook_id()+","+
				book.getCn_user_id()+","+
				book.getCn_notebook_type_id()+","+
				book.getCn_notebook_name()+","+
				book.getCn_notebook_desc()+","+
				book.getCn_notebook_createtime());
		
	}
	}
	@Test
	public void test2(){
	Book book=new Book();
	String noteId=NoteUtil.createId();
	book.setCn_notebook_id(noteId);
	book.setCn_notebook_name("失恋100天");
	
	
		System.out.println(book.getCn_notebook_id()+","+
				book.getCn_user_id()+","+
				book.getCn_notebook_type_id()+","+
				book.getCn_notebook_name()+","+
				book.getCn_notebook_desc()+","+
				book.getCn_notebook_createtime());

		
	
	}
}
