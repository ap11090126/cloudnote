package cn.tedu.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloudnote.dao.UserDao;
import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.util.NoteResult;
import cn.tedu.cloudnote.util.NoteUtil;

@Service("userService")

public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	public NoteResult<User> checkLogin(
			String name, String password) {
		NoteResult<User> result=new NoteResult<User>();
		User user=userDao.findByName(name);
		if(user==null){
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}
		try {
			String md5Password=NoteUtil.md5(password);
			if(!user.getCn_user_password().equals(md5Password )){
				result.setStatus(2);
				result.setMsg("���벻��ȷ");
				return result;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		result.setStatus(0);
		result.setMsg("��½�ɹ�");
		result.setData(user);
		return result;
	}

	public NoteResult<Object> addUser(String name, String password, 
			String nick) {
		NoteResult<Object> result=new NoteResult<Object>();
		User hasuser=userDao.findByName(name);
		
		if(hasuser!=null){
			result.setStatus(1);
			result.setMsg("�û����Ѵ���,�����");
			return result;
		}
		String id=NoteUtil.createId();
		try {
			String md5Password=NoteUtil.md5(password);
			User user=new User();
			user.setCn_user_id(id);
			user.setCn_user_name(name);
			user.setCn_user_password(md5Password);
			user.setCn_user_nick(nick);
			userDao.save(user);
			result.setStatus(0);
			result.setMsg("ע��ɹ�");
			result.setData(user);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
		
		
	}

}
