package cloudnote;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.dao.NotesDao;
import cn.tedu.cloudnote.entity.Notes;
import cn.tedu.cloudnote.service.NoteService;
import cn.tedu.cloudnote.util.NoteResult;

public class TestNoteService extends TestBase {
	private NoteService  noteService;
	private NotesDao  notedao;
	@Before
	public void init(){
		noteService=super.getContext().
				getBean("noteService",NoteService.class);
		notedao=super.getContext().getBean(
				"notesDao",NotesDao.class);
	}
	@Test
	public void test(){
		NoteResult<List<Map>> result=noteService.loadNoteBooks("516f6f4f-eaa3-4c76-84ff-530b92c7f64d");
		System.out.println(result);
	}
	@Test
	public void test1(){
		NoteResult<Notes> result=noteService.loadNote("003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
	@Test
	public void test2(){
		String noteId="003ec2a1-f975-4322-8e4d-dfd206d6ac0c";
		
		Notes note=notedao.findByNoteId(noteId);
		String title=note.getCn_note_title();
		String body=note.getCn_note_body();
		NoteResult<Object> result=noteService.updateNote(noteId, title, body);
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
}
