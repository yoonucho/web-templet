function save(){
	
	saveData("demo_2",$("a.clicked").parent().attr("id"));
}

function getData(treeId){
	
	$.metadata.setType('attr','value');
	var data = $("#"+treeId + " > input").metadata();
	//alert(data.url);
	//console.log(data);
	JSONtoString(data);
}                 

function makeData(index){
	if($(this).attr("value")!="저장" && $(this).attr("value")!="취소"){
		if(data1 !=''){
			data1 += ",";
		}
		data1 +=$(this).attr("name")+":"+"'"+$(this).val()+"'";	
	}
}

var data1 = "";
function saveData(myChild,target){
	/*
	var chk=false;
	$("#demo_1").find("li[id!='"+target+"']").each(function (){
		if($(this).attr("id")==$("#sId").val()){
			alert('중복된 id가 있습니다.');
			chk=true;
		}
	});
	if(chk){
		return;
	}
	alert("start");
	*/
	data1="";
	$("#"+myChild+" > input").each(makeData);
	$("#"+target + " > input").remove();
	$("#"+target).append("<input name=\"value\" type=\"hidden\"/>");
	
	
	//$("#"+target).attr("id",$("#sId").val());
	$("#"+target + " > a").html("<ins>&nbsp;</ins>"+$("#sNm").val());
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
