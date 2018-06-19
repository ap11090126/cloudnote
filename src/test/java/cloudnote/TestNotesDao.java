package cloudnote;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.dao.NotesDao;
import cn.tedu.cloudnote.entity.Notes;

public class TestNotesDao extends TestBase {
	private NotesDao notesDao;
	@Before
	public void init(){
		notesDao=super.getContext().getBean(
				"notesDao",NotesDao.class);
	}
	@Test
	public void testNoteDao(){
		List<Map> list=notesDao.findByBookId("516f6f4f-eaa3-4c76-84ff-530b92c7f64d");
		for(Map note:list){
			System.out.println(note.get("cn_note_id")+","+
		note.get("cn_note_title"));
		
		}
		
	}
	@Test
	public void testNoteDao1(){
		Notes notes=notesDao.findByNoteId("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0");
		
			System.out.println(notes.getCn_note_id()+","+
			notes.getCn_note_title());
		
	
		
	}
	@Test
	public void testNoteDao2(){
		Notes notes=new Notes();
		String noteId=
				"003ec2a1-f975-4322-8e4d-dfd206d6ac0c";
		notes.setCn_note_id(noteId);
		String title="传说";
		notes.setCn_note_title(title);
		String body="匪巢";
		notes.setCn_note_body(body);
		long time=System.currentTimeMillis();
		notes.setCn_note_last_modify_time(time);
		int num=notesDao.updateNote(notes);
			System.out.println(notes+","+num);
		
	
		
	}
	@Test
	public void testNoteDao3(){
		Notes notes=new Notes();
		String noteId=
				"003ec2a1-f975-4322-8e4d-dfd206d6ac1c";
		notes.setCn_note_id(noteId);
		String title="传说";
		notes.setCn_note_title(title);
		String body="匪巢";
		notes.setCn_note_body(body);
		long time=System.currentTimeMillis();
		notes.setCn_note_last_modify_time(time);
		notesDao.save(notes);
			System.out.println(notes);
		
	
		
	}
	@Test
	public void testNoteDao4(){		
		String noteId=
				"fsaf-as-df-asdf-as-df-dsa";
		Notes notes=notesDao.findByNoteId(noteId);
		notesDao.delete(notes);
		System.out.println("删除成功");
		
	}
}
