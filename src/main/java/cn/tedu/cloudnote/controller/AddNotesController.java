package cn.tedu.cloudnote.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.entity.Notes;
import cn.tedu.cloudnote.service.NoteService;
import cn.tedu.cloudnote.util.NoteResult;

@Controller()
@RequestMapping("/note")
public class AddNotesController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Notes> addNote(String userId,
			String bookId, String title){
		NoteResult<Notes> result=noteService.addNote(
				userId, bookId, title);
		return result;
		
	}
}
