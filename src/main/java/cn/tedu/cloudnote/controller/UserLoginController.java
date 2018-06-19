package cn.tedu.cloudnote.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.service.UserService;
import cn.tedu.cloudnote.service.UserServiceImpl;
import cn.tedu.cloudnote.util.NoteResult;

@Controller()
@RequestMapping("/user")
public class UserLoginController {
	@Resource
	private UserService userService;
	@RequestMapping("/login.do")
	@ResponseBody
	
	public NoteResult<User> LoginUser(String name, 
			String password){
		System.out.println(name+","+password);
		NoteResult<User> result=userService.checkLogin(
				name, password);
		return result;
	}

}
