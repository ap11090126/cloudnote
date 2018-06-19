package cn.tedu.cloudnote.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.cloudnote.dao.NotesDao;
import cn.tedu.cloudnote.entity.Notes;
import cn.tedu.cloudnote.util.NoteResult;
import cn.tedu.cloudnote.util.NoteUtil;
@Service("noteService")
public class NoteServiceImpl implements NoteService {
@Resource
private NotesDao notesDao;
	public NoteResult<List<Map>> loadNoteBooks(String bookId) {
		NoteResult<List<Map>> result=new
				NoteResult<List<Map>>();
		List<Map> list=notesDao.findByBookId(bookId);
		result.setStatus(0);
		result.setMsg("加载笔记成功");
		result.setData(list);
		return result;
	}
	public NoteResult<Notes> loadNote(String noteId) {
		Notes notes=notesDao.findByNoteId(noteId);
		NoteResult<Notes> result=new NoteResult<Notes>();
		if(notes==null){
			result.setStatus(1);
			result.setMsg("未找到数据");
			return result;
		}else{
			result.setStatus(0);
			result.setMsg("查询成功");
			result.setData(notes);
		}
		return result;
	}
	public NoteResult<Object> updateNote(String noteId,
			String title, String body) {
		Notes note=new Notes();
		note.setCn_note_id(noteId);
		note.setCn_note_title(title);
		note.setCn_note_body(body);
		long time=System.currentTimeMillis();
		note.setCn_note_last_modify_time(time);
		int rows=notesDao.updateNote(note);
		NoteResult<Object> result=new NoteResult<Object>();
		if(rows==1){
			result.setStatus(0);
			result.setMsg("保存笔记本成功");
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("保存笔记本失败");
			return result;
		}
		
	}
	public NoteResult<Notes> addNote(String userId,
			String bookId, String title) {
		NoteResult<Notes> result=new NoteResult<Notes>();
		Notes notes=new Notes();
		notes.setCn_user_id(userId);
		notes.setCn_note_title(title);
		notes.setCn_notebook_id(bookId);
		String noteId=NoteUtil.createId();
		notes.setCn_note_id(noteId);
		notes.setCn_note_body("");
		long time=System.currentTimeMillis();
		notes.setCn_note_create_time(time);
		notes.setCn_note_status_id("1");
		notes.setCn_note_last_modify_time(time);
		notesDao.save(notes);
		result.setStatus(0);
		result.setMsg("笔记保存成功");
		result.setData(notes);
		return result;
		
	}
	public NoteResult<Object> deleteNote(String noteId) {
		Notes notes=notesDao.findByNoteId(noteId);
		notesDao.delete(notes);
		 NoteResult<Object> result=new NoteResult<Object>();
		 result.setStatus(0);
		 result.setMsg("笔记本删除成功");
		return result;
	}

}
