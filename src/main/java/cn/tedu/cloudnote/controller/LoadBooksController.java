package cn.tedu.cloudnote.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.entity.Book;
import cn.tedu.cloudnote.service.BookService;
import cn.tedu.cloudnote.util.NoteResult;

@Controller()
@RequestMapping("/book")
public class LoadBooksController {
	@Resource
	private BookService bookService;
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult<List<Book>> execute(
			String userId){
		NoteResult<List<Book>> result =bookService.loadUserBooks(userId);
		return result;
		
	}
}
