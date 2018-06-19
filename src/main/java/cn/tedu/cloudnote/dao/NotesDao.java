package cn.tedu.cloudnote.dao;

import java.util.List;
import java.util.Map;


import cn.tedu.cloudnote.entity.Notes;

public interface NotesDao {
	public List<Map> findByBookId(String bookId);
	public Notes findByNoteId(String noteId);
	public int updateNote(Notes notes);
	public void save(Notes notes);
	public void delete(Notes notes);
}
