<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>検索</title>
    <link rel="stylesheet" href="css/inSearch.css" />
    <script>
        function onload() {
        	setEmailTail();
        }
        function ok() {
             	submit();
        }

        function back() {
        	location.href="login.action";
        }
        function setEmailTail() {

        	var obj = document.getElementById("email");
        	var text = obj.options[obj.selectedIndex].text; 
        	var value = obj.options[obj.selectedIndex].value;

        	if (value == "9") {
            	document.all("lemail").readOnly = false;
                document.all("lemail").value = "";
                document.all("lemail").focus();
            } else {
            	document.all("lemail").readOnly = true;
                document.all("lemail").value = text;
            }
        }
    </script>
</head>
<body onload="onload()">
    <center>
        <table border="0" cellpadding="0" cellspacing="0" width="1024" id="search">
            <tr>
                <td colspan="3" height="45"><img src="img/join/join_logo.png" /></td>
            </tr>
            <tr>
                <td class="title1">社員番号検索</td>
            </tr>
            <tr>
                <td height="35">* 入力してください。</td>
            </tr>
        </table>
        <s:form name="theform" method="post" action="IdSearchAccess" theme="simple">
            <table border="0" cellpadding="0" cellspacing="0" width="1004" id="search1" valign="center">
                <tr>
                    <td height="34" class="title_size" colspan="2"><img src="img/join/join_title_leftline.png" /> 情報入力</td>
                </tr>
                <tr class="gcs">
                    <td class="td">* メール  </td>
                    <td width="550px" align="left" class="txtbox">
                        <input type="text" name="femail" id="femail" size="13" maxlength="15" style="ime-mode:disabled" onkeyup="this.value=this.value.replace(/[^a-zA-z^0-9]/g,'')">&nbsp;@
                        <input type="text" name="lemail" id ="lemail" readonly="readonly" size="16" maxlength="34"/>
                        <s:select list="emailList" id="email" name="email" listKey="%{code_no}" listValue="%{ssk_nm}" onchange="setEmailTail()"/>
                    </td>
                </tr>
                <tr>
                    <td height="3" class="title_size" colspan="2"></td>
                </tr>       
                <tr class="id1">
                <td>
				検索したID
                </td>
                </tr>                
        	   <s:iterator value="list" >
                <tr>
                   <td class="gcs">                
						<s:property value="USER_ID"/>
					</td>
	            </s:iterator>
                <tr>
                    <td colspan="2">
                        <table align="center" height="110">
                            <tr>
                                <td><s:submit name="submit" value="検索" onclick="ok()"></s:submit>&nbsp;&nbsp;</td>
                                <td><input type="button" onclick="back()" value="キャンセル"></td>
                            </tr>

                        </table>
                    </td>
                </tr>
            </table>
        </s:form>
    </center>
</body>
</html>