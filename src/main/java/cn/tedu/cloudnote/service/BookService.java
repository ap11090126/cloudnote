package cn.tedu.cloudnote.service;

import java.util.List;

import cn.tedu.cloudnote.entity.Book;
import cn.tedu.cloudnote.util.NoteResult;

public interface BookService {
	public NoteResult<List<Book>> loadUserBooks( String userId);
}
