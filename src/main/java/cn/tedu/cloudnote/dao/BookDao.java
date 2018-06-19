package cn.tedu.cloudnote.dao;

import java.util.List;

import cn.tedu.cloudnote.entity.Book;

public interface BookDao {
	public List<Book> findByUserId(String userid);
	public void addBook(Book book);
}
