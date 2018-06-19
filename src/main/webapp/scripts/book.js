function loadUserBooks(){
	var userId=getCookie("userId");
	if(userId==null){
	 window.location.href="log_in.html";
	}else{
		$.ajax({
			url:path+"/book/loadbooks.do",
			type:"post",
			data:{"userId":userId},		
			dataType:"json",
			success:function(result){
				if(result.status==0){
					var books=result.data;
					for(var i=0;i<books.length;i++){
						var bookId=books[i].cn_notebook_id;
						var bookName=books[i].cn_notebook_name;
						createBookLi(bookId,bookName);
					}
				}
			},
			error:function(result){
				alert("笔记本加载失败")
			}
		});
	}	
};
function createBookLi(bookId,bookName){
	var sli="";
	sli+='<li class="online">';
	sli+='<a>';
	sli+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
	sli+='</i>';
	sli+=bookName;
	sli+='</a></li>';
	//将sli字符串转化成jQuery对象的li元素
	var $li=$(sli);
	//将bookId值与jQuery对象绑定
	$li.data("bookId",bookId);
	//将li元素添加到笔记本ul列表区
	$("#book_ul").append($li);
	
	
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







