package cn.tedu.cloudnote.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.service.NoteService;
import cn.tedu.cloudnote.util.NoteResult;

@Controller()
@RequestMapping("/note")
public class UpdateNoteController {
	@Resource
	private NoteService  noteService;
	@RequestMapping("/update.do")
	@ResponseBody
	public NoteResult<Object> updateNote(String noteId,
			String title,String body){
		NoteResult<Object> result=noteService.updateNote(
				noteId, title, body);
				return result;
		
	}
	
}
