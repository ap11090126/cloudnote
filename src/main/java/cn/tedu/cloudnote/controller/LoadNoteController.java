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
public class LoadNoteController {
	@Resource
	private NoteService  noteService;
	@RequestMapping("/loadnotes.do")
	@ResponseBody
	public NoteResult<List<Map>> execute(String bookId){
		NoteResult<List<Map>> result=noteService.
				loadNoteBooks(bookId);
		return result;
		
	}
	@RequestMapping("/load.do")
	@ResponseBody
	public NoteResult<Notes> loadNote(String noteId){
		NoteResult<Notes> Result=noteService.loadNote(noteId);
		return Result;
		
	}
	
	
	
}
