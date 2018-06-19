function alertAddBookwindow(){
	//弹出新建笔记本对话框
	$("#can").load("alert/alert_notebook.html");
	//显示背景
	$(".opacity_bg").show();
};
function closeAlertwindow(){
	//弹出新建笔记本对话框
	$("#can").html("");
	//显示背景
	$(".opacity_bg").hide();
};

function alertAddNoteWindow(){
	var $li=$("#book_ul a.checked").parent();
	if($li.length==0){
		alert("请选择笔记本");
	}else{
		$("#can").load("alert/alert_note.html");
		$(".opacity_bg").show();
	}
	//弹出新建笔记对话框
	
	//显示背景
	
};
function closeAlertwindow(){
	//弹出新建笔记本对话框
	$("#can").html("");
	//显示背景
	$(".opacity_bg").hide();
};
function addBook(){
	var bookName=$(".col-sm-3 control-label").val().trim();
	var userId=NoteUtil.createId();
		$.ajax({
		url:path+"/book/add.do",
		type:"post",
		data:{"bookName":bookName,"bookId":bookId,"noteId":noteId},
		dataType:"json",
		success:function(result){
			
		},
		error:function(result){
			
		},
	})
};
