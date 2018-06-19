package cn.tedu.cloudnote.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.tedu.cloudnote.service.UserServiceImpl;
import cn.tedu.cloudnote.util.NoteResult;

@Controller()
@RequestMapping("/user")
public class UserRegisterController {
	@Resource 
	private UserServiceImpl userService;
	@RequestMapping("/add.do")
	@ResponseBody
	
	public NoteResult<Object> userRegister(String name,
			String password,String nick){
		NoteResult<Object> result=userService.addUser(name, password, nick);
		return result;
		
		
	}


}
