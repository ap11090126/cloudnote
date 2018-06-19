function loadNoteBooks(){
	$("#book_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");
	var bookId=$(this).data("bookId");
	//alert(bookId);
	$.ajax({
		url:path+"/note/loadnotes.do",
		type:"post",
		data:{"bookId": bookId},
		dataType:"json",
		success:function(result){
			$("#note_ul").empty();
			//	$("#note_ul").remove();
			var note=result.data;
			for(var i=0;i<note.length;i++){
				noteId=note[i].cn_note_id;
				noteTitle=note[i].cn_note_title;
				createNoteLi(noteId,noteTitle);
			
		}	
		},
		error:function(){
			alert("加载失败");
		}
	})
};
function createNoteLi(noteId,noteTitle){

	var sli='';
	sli+='<li class="online">';
	sli+='<a>';
	sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	sli+= noteTitle;
	sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	sli+='</a>';
	sli+='<div class="note_menu" tabindex="-1">';	
	sli+='<dl>';	
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';	
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';	
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';	
	sli+='</dl>';
	sli+='</div>';
	sli+='</li>';	
	var $li=$(sli);
	$li.data("noteId",noteId);
	$("#note_ul").append($li);			
	
};
function editorNoteBooks(){
	$("#note_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");
	var noteId=$(this).data("noteId");
		$.ajax({
		url:path+"/note/load.do",
		type:"post",
		data:{"noteId": noteId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
		var title=result.data.cn_note_title;
		var body=result.data.cn_note_body;
		$("#input_note_title").val(title);
		um.setContent(body);
			}
		},
		
		error:function(){
			alert("加载失败");
		}
	})
	
};
function updateNoteBooks(){
	//获取参数
	var $li=$("#note_ul a.checked").parent();
	var noteId=$li.data("noteId");
	var noteTitle=$("#input_note_title").val().trim();
	var noteBody=um.getContent();
	//alert(noteId+","+notetitle+","+notebody);
	$.ajax({
		url:path+"/note/update.do",
		type:"post",
		data:{"noteId": noteId,"title":noteTitle,"body":noteBody},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var str="";
				str+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				str+= noteTitle;
				str+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				$li.find("a").html(str);
				alert(result.msg);
			}
			
		}, 
		
		error:function(){
			alert("保存笔记失败");
		}
	})
};
function addnote(){
	var title=$("#input_note").val().trim();
	var userId=getCookie("userId");
	var $li=$("#book_ul a.checked").parent();
	var bookId=$li.data("bookId");
	//alert(title);
	var ok=true;
	if(title==""){
		//alert("标题不能为空");
	
		$("#title_span").html("标题不能为空！");
		ok=false;
	}
	if(userId==null){
		ok=false;
		window.location.href="log_in.html";
	}
	if(ok){
	$.ajax({
		//alert("标题不能为空");
		url:path+"/note/add.do",
		type:"post",
		data:{"userId":userId,"bookId":bookId,"title":title},
		dataType:"json",
		success:function(result){
			//$("#note_ul").empty();
			//	$("#note_ul").remove();
			var note=result.data;
			if(result.status==0){

				id=note.cn_note_id;
				title=note.cn_note_title;
			}
				createNoteLi(id,title);
				alert(result.msg);
			
		
		},
		error:function(){
			alert("创建笔记失败");
		},
	})
	}
};
function slidedown(){
	//alert("slidedown绑定成功");
	$("#note_ul div").hide();
	var note_menu=$(this).parents("li").find("div");
	note_menu.slideDown(1000);
	return false;
};
function sharenote(){
	$li=$(this).parents("li");
	 var noteId=$li.data("noteId");
	alert(noteId);
	
	$.ajax({
		url:path+"/share/add.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			var noteTitle=$li.text();
			var sli="";
			sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
			sli+= noteTitle;
			sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
			sli+='<i class="fa fa-sitemap">';
			$li.find("a").html(sli);
			alert("分享笔记成功");
		},
		error:function(){
				alert("分享笔记失败");
				},
	})
	
	
};
function alertDeleteNotewindow(){
	$("#can").load("alert/alert_delete_note.html");
	$(".opacity_bg").show();
	
};
function deleteNote(){
	//alert("deleteNote绑定成功");

	 //获取请求参数
	 var $li = 
		$("#note_ul a.checked").parent();
	 var noteId = $li.data("noteId");
	
	 //发送Ajax请求
	 $.ajax({
		 url:path+"/note/delete.do",
		 type:"post",
		 data:{"noteId":noteId},
		 dataType:"json",
		 success:function(result){
			 if(result.status==0){
				 //删除li
				 $li.remove();
				 //提示成功
				 alert(result.msg);
			 }
		 },
		 error:function(){
			 alert("删除笔记异常");
		 }
	 });
};
