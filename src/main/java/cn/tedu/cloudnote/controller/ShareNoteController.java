package cn.tedu.cloudnote.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tedu.cloudnote.service.ShareService;
import cn.tedu.cloudnote.util.NoteResult;

@Controller()
@RequestMapping("/share")
public class ShareNoteController {
	@Resource
	private ShareService shareService;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> execute(
			String noteId){
		NoteResult<Object> result =shareService.shareNote(noteId);
		return result;
		
	}
}
