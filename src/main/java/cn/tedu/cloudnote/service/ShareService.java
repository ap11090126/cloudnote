package cn.tedu.cloudnote.service;



import java.util.List;

import cn.tedu.cloudnote.entity.Share;
import cn.tedu.cloudnote.util.NoteResult;

public interface ShareService {
	public NoteResult<Object> shareNote(String noteId);
	public NoteResult<List<Share>> searchNote(String keyword,int page);

} 
