package cloudnote;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.dao.NotesDao;
import cn.tedu.cloudnote.entity.Book;
import cn.tedu.cloudnote.entity.Notes;
import cn.tedu.cloudnote.entity.Share;
import cn.tedu.cloudnote.service.BookService;
import cn.tedu.cloudnote.service.ShareService;
import cn.tedu.cloudnote.util.NoteResult;

public class TestSharekService extends TestBase {
	private ShareService shareService;
	private NotesDao notesDao;
	@Before
	public void init(){
		shareService=super.getContext().getBean(
				"shareService",ShareService.class);
		notesDao=super.getContext().getBean(
				"notesDao",NotesDao.class);
	}
	@Test
	public void test(){
		String noteId="019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0";
		
		Notes note=notesDao.findByNoteId(noteId);
		String title=note.getCn_note_title();
		String body=note.getCn_note_body();
		NoteResult<Object> result=shareService.shareNote(noteId);
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
	
}
