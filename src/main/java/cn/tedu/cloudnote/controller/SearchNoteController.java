package cn.tedu.cloudnote.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.entity.Share;
import cn.tedu.cloudnote.service.NoteService;
import cn.tedu.cloudnote.service.ShareService;
import cn.tedu.cloudnote.util.NoteResult;

@Controller()
@RequestMapping("/share")
public class SearchNoteController {
	@Resource
	private ShareService  shareService;
	@RequestMapping("/search.do")
	@ResponseBody
	public NoteResult<List<Share>> searchNote(String keyword,int page){
		NoteResult<List<Share>> result=shareService.
				searchNote(keyword,page);
		return result;
		
			
		
	}
	
}
