<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type = "text/css" href="./css/bbs_update.css" >
<title>update</title>
<style type="text/css">
.a{
	text-decoration: line-through;
}
</style>
<script type="text/javascript">
function contentCheck(){
	var titleCheck = document.getElementById("BBS_TITLE");
	var contentCheck = document.getElementById("BBS_CONTENT");
	var CategoryCheck = document.getElementById("category");
	var textarealength = document.getElementById("BBS_CONTENT");
	var maxlength = 16*1024;
	
	if(titleCheck.value =="" || contentCheck.value=="" || CategoryCheck.value=="1"){
		if(titleCheck.value==""){
			alert("題目を入力してください。");
		}else if(contentCheck.value==""){
			alert("内容を入力してください。");
		}else if(CategoryCheck.value =='1'){
			alert('カテゴリーを選択してください。');
		}
	}else{
		var sub = document.getElementById("theForm");
		sub.action = "bbsUpdateAccess";
		sub.submit();
	}
	
}
function DeleteFileLode(){		
	var fileLoad = document.getElementById("fileLoad");
	var table = document.getElementById("file1");
	var remove = document.getElementById("xBtn");
	
	fileLoad.value="";
	if(fileLoad.value == ""){
		table.removeChild(remove);
	}
 }
function Delete(){
	var file = document.getElementById("file1").TEXT_NODE
	var table = document.getElementById("file1");
	var returnValue = confirm("添付ファイルを削除しますか。");
	 	
	if(returnValue == true){
		
		var hiddenC = document.getElementById("bbs_fname");
		table.removeChild(hiddenC);
		
		if(file!=null){
			var table = document.getElementById("file1");
			var textNode = document.getElementById("file2");
			var xButton =document.getElementById("xButton");
			
			table.removeChild(textNode);
			table.removeChild(xButton);
		
			var createFile = document.createElement("INPUT");
			createFile.setAttribute("type", "file");
			createFile.setAttribute("id","fileLoad");
			createFile.setAttribute("name", "BBS_FDATA");
			createFile.setAttribute("onChange", "fileCheck()");
			
			var createHidden = document.createElement("INPUT");
			createHidden.setAttribute("type", "hidden");
			createHidden.setAttribute("id", "bbs_fname");
			createHidden.setAttribute("name", "BBS_FNAME");
			
			table.appendChild(createHidden);
			table.appendChild(createFile);
		}
	}
}
function fileCheck(){
		var fileTure = document.getElementById("fileLoad");
		var table = document.getElementById("file1");
		var createBtn = document.createElement("img");
		var f = fileTure.files[0];
		var flag = false;
		var mbSize = 16;
			
		if(f!=undefined){
			var iSize = (f.size||f.fileSize);
			if((iSize/1024)>(mbSize*(1024))){
				flag = true;
			}
		}

		if(flag){
			alert("16MBまでアップロード可能です。");
			fileTure.value = "";
			var a = table.lastChild;
			table.removeChild(a);
		}else{
			
			createBtn.setAttribute("src", "./img/bbs/x.png");
			createBtn.setAttribute("width", "10px");
			createBtn.setAttribute("id", "xBtn");
			createBtn.setAttribute("onClick", "DeleteFileLode()");
	
			table.appendChild(createBtn);
			fileNameInfo();
		}
}
function fileCheck1(){
	var table = document.getElementById("file1");
	var createBtn = document.createElement("img");
	
	createBtn.setAttribute("src", "./img/bbs/x.png");
	createBtn.setAttribute("width", "15px");
	createBtn.setAttribute("id", "xBtn");
	createBtn.setAttribute("onClick", "DeleteFileLode()");
	
	if(fileLoad.value != null){
		table.appendChild(createBtn);
	}
	
}
function cancel(){
	 	var returnValue = confirm("戻りますか。");
	 	if(returnValue == true){
			var can = document.getElementById("theForm");
			can.action = "bbsList";
			can.submit();
	 	}
}

function fileNameInfo() {
	var obj = document.getElementById("fileLoad");
	var fileObj, pathHeader , pathMiddle, pathEnd, allFilename, fileName, extName;
	if(obj == "[object HTMLInputElement]") {
		fileObj = obj.value;
	}else{
		fileObj = document.getElementById(obj).value;
	}
	if (fileObj != "") {
		pathHeader = fileObj.lastIndexOf("\\");
		pathMiddle = fileObj.lastIndexOf(".");
		pathEnd = fileObj.length;
		fileName = fileObj.substring(pathHeader+1, pathMiddle);
		extName = fileObj.substring(pathMiddle+1, pathEnd);
		allFilename = fileName+"."+extName;

		document.getElementById("bbs_fname").value = allFilename;
	}
}
function byteCheck(obj, maxByte){
	var str = obj.value;
	var str_len = str.length;
 	
	var rbyte = 0;
	var one_char="";
	
	for(var i=0; i<str_len; i++){
		one_char = str.charAt(i);
		if(escape(one_char).length>4){
			rbyte +=2;
		}else{
			rbyte ++;
		}
	}
	if(rbyte>maxByte){
		alert("300KBを超えることはできません。");
		var reset = document.getElementById("BBS_CONTENT");
		reset.value = "";
	}
}
function a(){
	var a = document.getElementById("BBS_NUMBER");
	var a1 = document.getElementById("bbs_number");
	a1.value = a.value;
}
</script>
</head>
<body onload="a()">
    
    <center>
        <section id="content" style="margin-top:-30px;">          
               <div class="loBB bt5px" id="log_op">
                <div id="logintool">
                    <img src="./img/bbs/title.png" />                   
                    <div style="overflow:hidden; width:890px;">
                        	
							<s:form id="theForm" name="theForm" action="" method="POST" enctype="multipart/form-data">		
													
							<table cellpadding="0" cellspacing="0" width="890" id="join1" align="center">
								<s:iterator value="bbslist" var="list">
								<tr>
									<td height="34" class="title_size" colspan="2"><img src="./img/join/join_title_leftline.png" /> 修正</td>
								</tr>
							
								<tr class="gcs">
									<td width="200" class="td" >カテゴリー  </td>
									<td align="left" class="td">
										 <s:select list="categoryList" id="category" name="BBS_CATEGORY" listKey="%{code_no}" listValue="%{ssk_nm}" theme="simple"/>
									</td>
								</tr>
								<input type="hidden" id ="searchOption1"name="searchOption1" value="<s:property value="searchOption1"/>">
								<input type="hidden" id="searchOption2" name="searchOption2" value="<s:property value="searchOption2"/>">
								<input type="hidden" id ="searchInfo"name="searchInfo" value="<s:property value="searchInfo"/>">
								<input type="hidden" id ="page"name="page" value="<s:property value="page"/>">
								<tr class="gcs">
									<td width="200" class="td" >題目  </td>
									<td align="left" class="td">
									
										<input type="hidden" id="BBS_NUMBER"name="BBS_NUMBER" value="<s:property value="BBS_NUMBER"/>">
										<input type="hidden" id ="bbs_number" name="bbs_number" value="">
										<input type="text" maxlength="40" required="required" placeholder="題目を入力してください。" name="BBS_TITLE" id="BBS_TITLE" size="50" value="<s:property value="BBS_TITLE"/>">
									</td>
								</tr>
								<tr class="gcs">
									<td width="200" class="td">作成者</td>
									<td align="left" class="td">
										<%-- <s:property value="TRK_ID"/> --%>
										<s:property value="USER_NAME"/>  &lt<s:property value='USER_NAME_KATA'/>&gt
									</td>
								</tr>
								<tr class="gcs">
									<td width="200" class="td">作成日</td>
									<td align="left" class="td">
										<s:property value="TRK_DT"/>
									</td>
								</tr>
								<tr class="gcs">
									<td width="200" class="td">添付ファイル</td>
									<s:set name="Fname"><s:property value="BBS_FNAME"/></s:set>
									<s:if test="%{#Fname.equals('none')==false}">
									<td align="left" class="td" id="file1">
										<span id="file2"><s:property value="BBS_FNAME"/>&nbsp;</span><img src="./img/bbs/x.png" width="13px" onclick="Delete()" id="xButton">
										<input type="hidden" name="BBS_FNAME" id="bbs_fname" value="<s:property value="BBS_FNAME"/>">
									</td>
									</s:if >
									<s:else>
										<td width="200" class="td" id="file1">
											<input type="file" id ="fileLoad" name="BBS_FDATA" onChange="fileCheck()">
											<input type="hidden" name="BBS_FNAME" id="bbs_fname" value="">
										</td>
									</s:else>
								</tr>
								<tr class="gcs">
									<td width="200" class="td" >内容  </td>
									<td height ="245" align="left" class="td" >
										<textarea name="BBS_CONTENT" id="BBS_CONTENT" required="required" onkeyup="byteCheck(this, '307200')" placeholder="本文を入力してください。" style="resize: none;" rows="15" cols="80"><s:property value="BBS_CONTENT"/></textarea>
									</td>
								</tr>
								
								</s:iterator>
								<tr class="gcs">																
									<td align="right" colspan="2" width="20px" height="5px">
										<input class="myButton" type="submit" value="修正" onClick="contentCheck()"/>
										<input  class="myButton" type="button" onclick="cancel()" value="キャンセル">
									</td>
								</tr>
							</table>
							</s:form>
					</div></div>
                </div>
         </section>
       </center>
</body>

</html>