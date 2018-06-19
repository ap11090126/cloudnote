package cn.tedu.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloudnote.dao.BookDao;
import cn.tedu.cloudnote.entity.Book;
import cn.tedu.cloudnote.util.NoteResult;
@Service("bookService")
public class BookServiceImpl implements BookService {
	@Resource 
	private BookDao bookdao;
	public NoteResult<List<Book>> loadUserBooks(
			String userId) {
		 NoteResult<List<Book>> result=new NoteResult<List<Book>>();
		 List<Book> list=bookdao.findByUserId(userId);
		
			 if(list==null){
				 result.setStatus(1); 
				 result.setMsg("用户不存在");
				 return result;
			
			
		 }
			 result.setStatus(0); 
			 result.setMsg("查询笔记本成功");
			 result.setData(list);  
		return result;
	}

}
