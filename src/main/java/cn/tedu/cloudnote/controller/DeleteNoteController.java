package cn.tedu.cloudnote.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.entity.Notes;
import cn.tedu.cloudnote.service.NoteService;
import cn.tedu.cloudnote.util.NoteResult;

@Controller()
@RequestMapping("/note")
public class DeleteNoteController {
	@Resource
	private NoteService  noteService;
	@RequestMapping("/delete.do")
	@ResponseBody
	public NoteResult<Object> deleteNote(String noteId){
		NoteResult<Object> result=noteService.deleteNote(noteId);
				return result;		
	}
}
