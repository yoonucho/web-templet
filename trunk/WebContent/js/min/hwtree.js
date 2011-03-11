function save(){
	
	saveData("demo_2",$("a.clicked").parent().attr("id"));
}

function getData(treeId){
	//alert();
	//console.log($("#"+treeId + " > input").length);

	if($("#"+treeId + " > input").length==0){
		$("#"+treeId).append("<input name=\"value\" type=\"hidden\" value=\"{code_seq_no:'"+treeId+"', code_p_seq_no:'',code_depth:'',code_nm:'New folder'}\"/>");
	}
	$("#demo_2").find("input[type='text']").val("");
	
	$.metadata.setType('attr','value');
	var data = $("#"+treeId + " > input").metadata();
	JSONtoString(data);
}                 

function makeData(index){
	if($(this).attr("value")!="저장" && $(this).attr("value")!="취소"
		 && $(this).attr("value")!="서버저장"){
		if(data1 !=''){
			data1 += ",";
		}
		data1 +=$(this).attr("name")+":"+"'"+$(this).val()+"'";	
	}
}

//서버에 저장
function serverSave(){
	var html="";
	$("#demo_1").find("li").each(function(){
		$.metadata.setType('attr','value');
		var object = $(this).find("input").metadata();
		var results = [];  
	    for (var property in object) {  
	        var value = object[property];  
	        if (value)  
	            //results.push(property.toString() + ': ' + value);
	        	$("#"+property.toString()).val(value);
	        html+="<input name='"+property.toString()+"' type='hidden' value='"+value+"' />";
        }  
	});
	//alert(html);
	$("#frmSave").html(html);
	$("#frmSave").submit();
}

var data1 = "";
function saveData(myChild,target){
	data1="";
	$("#"+myChild+" > input").each(makeData);
	$("#"+target + " > input").remove();
	$("#"+target).append("<input name=\"value\" type=\"hidden\"/>");
	
	$("#"+target + " > a").html("<ins>&nbsp;</ins>"+$("#code_nm").val());
	$("#"+target + " > input").val("{"+data1+"}");
	
}

function cancel(){
	getData($("a.clicked").parent().attr("id"));
}

function JSONtoString(object) {  
    var results = [];  
    for (var property in object) {  
        var value = object[property];  
        if (value)  
            //results.push(property.toString() + ': ' + value);
        	$("#"+property.toString()).val(value);
        }  
                  
        //return '{' + results.join(', ') + '}';  
}  
