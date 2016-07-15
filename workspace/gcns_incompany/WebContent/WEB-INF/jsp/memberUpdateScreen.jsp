<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function memberUpdate(){
		if(document.getElementById("user_password").value!=document.getElementById("repassword").value){
			alert("パスワード確認してください。");
			return false;
		}
		
	}
	function cancel(){
		location.href = "<s:url value='/memberListManager.action'/>";
	}
	function check(){
		document.updateform.user_department.value="<s:property value='user_bean.USER_DEPARTMENT'/>";
		document.updateform.user_rank.value="<s:property value='user_bean.USER_RANK'/>";
		document.updateform.user_status.value="<s:property value='user_bean.USER_STATUS'/>";
	}
</script>
<body onload="check()" >
	<%if(session.getAttribute("id")==null){ %>
      <script> 
       top.disableActive();
      </script> 
　　　<%}else{
   %>    
	   <script type="text/javascript">
	   	top.fncClearTime();
	   </script>
   <%} %>      
	<center>
		<img src="img/manager/memberinformupdate.jpg">
		<s:form action="memberupdateManager" name="updateform" theme="simple" onsubmit="javascript:return memberUpdate()">
			<input type="hidden" id="user_id" name="user_id" value="<s:property value='user_bean.USER_ID'/>"/>
			<table border="1"
				style="border-color: skyblue; border-collapse: collapse;">
				<tr>
					<th align="left">社員番号</th>
					<td> <s:property value="user_bean.USER_ID"/> </td>

				</tr>
				<tr>
					<th align="left">パスワード</th>
					<td><input type="password" id="user_password" name="user_password" maxlength="16"></td>

				</tr>
				<tr>
					<th align="left">パスワード確認</th>
					<td><input type="password" id="repassword" maxlength="16"></td>

				</tr>
				<tr>
					<th align="left">部署</th>
					<td align="left"><s:select name="user_department" id="user_department" list="department_code_list" listValue="%{ssk_nm}" listKey="%{code_no}"/></td>
				</tr>
				<tr>
					<th align="left">職級</th>
					<td align="left"><s:select name="user_rank" id="user_rank" list="rank_code_list" listValue="%{ssk_nm}" listKey="%{code_no}"/></td>
				</tr>
				<tr>
					<th align="left">等級</th>
					<td align="left"><s:select name="user_status" id="user_status" list="status_code_list" listValue="%{ssk_nm}" listKey="%{code_no}"/></td>
				</tr>
				<tr>
					<th align="left">名前</th>
					<td align="left"><s:property value="user_bean.USER_CCFNAME"/>
						<s:property value="user_bean.USER_CCLNAME"/></td>
				</tr>
				<tr>
					<th align="left">カタカナ名前</th>
					<td align="left"><s:property value="user_bean.USER_KATAFNAME"/>
						<s:property value="user_bean.USER_KATALNAME"/></td>
				</tr>
				<tr>
					<th align="left">メール</th>
					<td align="left"><s:property value="user_bean.USER_EMAIL"/></td>
				</tr>
				<tr>
					<th align="left">電話番号</th>
					<td align="left"><s:property value="user_bean.USER_PHONE"/></td>
				</tr>
				<tr>
					<th align="left">カカオトークID</th>
					<td align="left"><s:property value="user_bean.USER_KAKAOTALK"/></td>
				</tr>


			</table>
		
			<table>
				<tr>
					<td>
					<s:submit value="修正" />
					<input type="button" value="キャンセル" onClick="cancel()"></td>
				</tr>
			</table>
		</s:form>
	</center>
</body>
</html>