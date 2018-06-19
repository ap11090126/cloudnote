package cn.tedu.cloudnote.service;

import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.util.NoteResult;

public interface UserService {
	public NoteResult<User> checkLogin(
			String name,String password);
	public NoteResult<Object> addUser(
			String name,String password,String nick);


}
