package cn.tedu.cloudnote.service;

import java.util.List;
import java.util.Map;

import cn.tedu.cloudnote.entity.Notes;
import cn.tedu.cloudnote.util.NoteResult;

public interface NoteService {
	public NoteResult<List<Map>> loadNoteBooks(String bookId);
	public NoteResult< Notes> loadNote(String noteId);
	public  NoteResult<Object> updateNote(String noteId,
			String title,String body);
	public NoteResult<Notes> addNote(String userId,
			String bookId,String title);
	public NoteResult<Object> deleteNote(String noteId);
}
