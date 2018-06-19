function searchNote(event){
	
	var code=event.keyCode;
	
	if(code==13){
		$("#search_ul li").remove();
		var keyword=$("#search_note").val().trim();
		page=1;
		loadPageShare(keyword,page);
	}
	
};
function moreSearchShare(){
	var keyword=$("#more_note").val().trim();
	page=page+1;
	loadPageShare(keyword,page);
	
};
function loadPageShare(keyword,page){

	$.ajax({
		url:path+"/share/search.do",
		type:"post",
		data:{"keyword":keyword,"page":page},
		dataType:"json",
		success:function(result){
			var shares=result.data;
			for(var i=0;i<shares.length;i++){
				var shareId=shares[i].cn_share_id;
				var shareTitle=shares[i].cn_share_title;
				var sli="";
				sli+='<li class="online">';
				sli+='<a>';
				sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				sli+= shareTitle;
				sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				sli+='</a>';				
				sli+='</li>';
				var $li=$(sli);
				//绑定shareId
				$li.data("shareId", shareId);
				//将li对象添加到ul当中
				$("#search_ul").append($li);
				//切换显示区
				$("#pc_part_2").hide();
				$("#pc_part_6").show();
			}
			
			
		},
		error:function(){
						
		},

	})
};

