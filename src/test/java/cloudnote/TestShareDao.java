package cloudnote;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.dao.NotesDao;
import cn.tedu.cloudnote.dao.ShareDao;
import cn.tedu.cloudnote.entity.Notes;
import cn.tedu.cloudnote.entity.Share;
import cn.tedu.cloudnote.util.NoteUtil;

public class TestShareDao extends TestBase {
	private ShareDao shareDao;

	private NotesDao notesDao;
	@Before
	public void init(){
		shareDao=super.getContext().getBean(
				"shareDao",ShareDao.class);
		notesDao=super.getContext().getBean(
				"notesDao",NotesDao.class);
	}
	@Test
	public void testShareDao(){
		Share share=new Share();
		String shareId=NoteUtil.createId();
		share.setCn_share_id(shareId);
		String noteId="019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0";
		
		Notes note=notesDao.findByNoteId(noteId);
		share.setCn_note_id(noteId);
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		shareDao.save(share);
			System.out.println("插入成功");	
		
				
	}
	/*@Test
	public void testShareDao1(){
		String title="%失恋%";
		List<Share> list=shareDao.search(title);
		for(Share share:list){
			System.out.println(share.getCn_note_id()+","+
		share.getCn_share_body()+","+
		share.getCn_share_id()+","+share.getCn_share_title());	
		}
	}*/
}
