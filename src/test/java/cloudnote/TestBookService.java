package cloudnote;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.entity.Book;
import cn.tedu.cloudnote.service.BookService;
import cn.tedu.cloudnote.util.NoteResult;

public class TestBookService extends TestBase {
	private BookService bookService;
	@Before
	public void init(){
		bookService=super.getContext().getBean(
				"bookService",BookService.class);
	}
	@Test
	public void test(){
		NoteResult<List<Book>> result=bookService.
				loadUserBooks(
						"1");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		for(Book book:result.getData()){
			System.out.println(book.getCn_notebook_name());
		}
		
	}
}
