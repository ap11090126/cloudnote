package cn.tedu.cloudnote.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloudnote.dao.NotesDao;
import cn.tedu.cloudnote.dao.ShareDao;
import cn.tedu.cloudnote.entity.Notes;
import cn.tedu.cloudnote.entity.Share;
import cn.tedu.cloudnote.util.NoteResult;
import cn.tedu.cloudnote.util.NoteUtil;

@Service("shareService")
public class ShareServiceImpl implements ShareService {
	@Resource
	private NotesDao notesDao;
@Resource
private ShareDao shareDao;

	public NoteResult<Object> shareNote(String noteId) {
		
		Share share=new Share();
		String shareId=NoteUtil.createId();
		share.setCn_share_id(shareId);
		share.setCn_note_id(noteId);
		Notes note=notesDao.findByNoteId(noteId);
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		shareDao.save(share);
		NoteResult<Object> result=new NoteResult<Object>();
		result.setStatus(0);
		result.setMsg("分享笔记本成功");
		result.setData(share);
		return result;
	}

	public NoteResult<List<Share>> searchNote(String keyword,int page) {
		NoteResult<List<Share>> result=new NoteResult<List<Share>>();
		String title="%"+keyword+"%";
		int begin=(page-1)*3;
		Map<String,Object> params=new HashMap();
		params.put("title", title);
		params.put("begin", begin);
		List<Share> list=shareDao.search(params);
		result.setStatus(0);
		result.setMsg("搜索完成");
		result.setData(list);
		return result;
	}

}
