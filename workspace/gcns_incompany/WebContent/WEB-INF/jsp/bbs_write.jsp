<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>掲示板 作成</title>
	<link rel="stylesheet" href="css/bbs.css" />
	<script type="text/javascript">
		
		function bbsWrite(){
			var bbsform = document.theform;
						
			if(bbsform.BBS_TITLE.value == ''){
				alert('題目を入力してください。');
				document.theform.BBS_TITLE.focus();
			}else if(bbsform.BBS_CONTENT.value ==''){
				alert('内容を入力してください。');
				document.theform.BBS_CONTENT.focus();
// 			}else if(bbsform.BBS_CONTENT.value.length >= 184320){ //360byte
// 				alert('内容を文字184,320以下で入力してください。');
// 				document.theform.BBS_CONTENT.focus();
			}else if(bbsform.BBS_CATEGORY.value =='1'){
				alert('カテゴリーを選択してください。');
				document.theform.BBS_CATEGORY.focus();
			}else{
				if(bbsform.fileName.value == "ファイルのサイズは、16MBまで可能です。")
					bbsform.fileName.value = "";
				document.theform.submit();
			}
		}
		
		function bbsFileupcnl(){
			document.theform.fileName.value="ファイルのサイズは、16MBまで可能です。";
			document.theform.fileTxt.value="";
			document.getElementById("fileCnl").style.visibility="hidden";
		}
		
		function bbsWriteCancel(){
			var msgWrite = confirm("戻りますか。");
			if(msgWrite)
				location.href='bbsList';
		}
		
		function fileSelected(){
			var f = theform.BBS_FDATA.files[0];
			var flag = false;
			var mbSize = 16;
			
			if(f!=undefined){
				var iSize = (f.size||f.fileSize);
				if((iSize/1024)>(mbSize*(1024))){
					flag = true;
				}
			}

			if(flag){ //upload damedayo
				alert("16MBまでアップロード可能です。");
				document.theform.fileName.value="ファイルのサイズは、16MBまで可能です。";
				document.theform.fileTxt.value="";
				document.getElementById("fileCnl").style.visibility="hidden";
			}else{ //upload ok!
				fileNameInfo();
				document.getElementById("fileCnl").style.visibility="visible";
			}
		}
		
		function fileNameInfo() {
			var obj = document.getElementById("fileTxt");
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
				
				document.getElementById("fileName").value = allFilename;
			}
		}
		
		
		function fncChkByte(obj, maxByte){
			var ls_str = obj.value;
			var li_str_len = ls_str.length; 
			var li_byte = 0;
			var li_len = 0;
			var ls_one_char = "";
			var ls_str2 = "";
			
			for(var i=0; i<li_str_len; i++){
				ls_one_char = ls_str.charAt(i);
			
				if(escape(ls_one_char).length > 4){
					li_byte += 2;
				}else{
					li_byte++;
				}
				        
				if(li_byte <= maxByte){
					li_len = i + 1;
				}
			}
			
			if(li_byte > maxByte) {
				alert("300byteを超えることはできません。");
				ls_str2 = ls_str.substr(0, li_len);
				obj.value = ls_str2;
				fncChkByte(obj, maxByte);
			}else{
// 				document.getElementById('byteInfo').innerText = maxByte-li_byte;
			}
		}
		
		function pageSet(){
			document.getElementById("fileCnl").style.visibility="hidden";
		}
	</script>
</head>
<body onload="pageSet();">
    <center>
        <section id="content" style="margin-top:-30px">          
            <div class="loBB bt5px" id="log_op">
                <div id="logintool">
                    <img src="img/bbs/title.png" />                   
                    <div style="overflow:hidden; width:890px;">
                        
						<s:form name="theform" action="bbsWriteAccess" method="POST" enctype="multipart/form-data">
																					  
							<table border="0" cellpadding="0" cellspacing="0" width="890" id="join1" valign="center">
								<tr>
									<td height="34" class="title_size" colspan="2"><img src="img/join/join_title_leftline.png" /> 作成</td>
								</tr>
								<tr class="gcs">
									<td class="td">カテゴリー  </td>
									<td align="left" class="txtbox">
										<s:select list="categoryList" id="category" name="BBS_CATEGORY" listKey="%{code_no}" listValue="%{ssk_nm}" theme="simple"/>
									</td>
								</tr>
								<tr class="gcs">
									<td class="td" >題目  </td>
									<td align="left" class="txtbox">
										<input type="text" maxlength="40" name="BBS_TITLE" id="num" size="90" value="" placeholder="タイトルを入力してください。">
									</td>
								</tr>
								<tr class="gcs">
									<td class="td" >内容</td> <!-- <br/><span id="byteInfo">307200</span><br/>byte残りました。   -->
									<td align="left" class="txtbox">
										<textarea name="BBS_CONTENT" id="num" rows="23" cols="90" value="" placeholder="本文を入力してください。" onkeyup="fncChkByte(this, 307200)" style="resize: none; font-family: Arial;"></textarea>
									</td>
								</tr>
								<tr class="gcs">
									<td class="td" >アップロード  </td>
									<td align="left" class="txtbox">
										<div>
											<input type="text" id="fileName" name="BBS_FNAME" class="file_input_textbox" readonly="readonly" value="ファイルのサイズは、16MBまで可能です。"/>
											<div class="file_input_div">
												<input type="button" value="ファイル選択" class="file_input_button" />
												<input type="file" id="fileTxt" name="BBS_FDATA" class="file_input_hidden" onchange="fileSelected();" />
											</div>
											<div class="file_input_div2">
												<input type="button" id="fileCnl" onclick="bbsFileupcnl()" value="X" class="file_input_button_cln"/>
											</div>
										</div>
																			
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<table align="center">
											<tr>
												<td width="890"  height="10" class="title_size"></td>
											</tr>
											<tr align="center">
												<td height="40">
													<input type="button" onclick="bbsWrite();" value="     作成     ">&nbsp;&nbsp;&nbsp;
													<input type="button" onclick="pageSet(); reset()" value=" リセット ">
													<input type="button" onclick="bbsWriteCancel();" value="キャンセル">
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</s:form>

                    </div>
                </div>
            </div> 
        </section>
    </center>
</body>
</html>