<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
<title>掲示板</title>
</head>
<link rel="stylesheet" href="css/bbs_list.css" />
	<script>
		function page(page) {
			document.getElementById(page).style.fontWeight = "bolder";
			
		}
	
		
	</script>


<body onload="page(${page})">
<center>
	<section id="content" style="margin-top:-30px">
		<div class="loBB bt5px" id="log_op">
        	<div id="logintool">
				<img src="img/bbs/title.png"/>
				<div style="overflow:hidden; width:890px; margin-top: -26px;">
					<table id="search" width="890">
						<tr>
							<td>
								<s:form action="bbsList" method="post">
									<s:select name="searchOption1" list="codeList1" listKey="%{code_no}" listValue="%{ssk_nm}" theme="simple" />
									<s:select name="searchOption2" list="codeList2" listKey="%{ssk_nm}" listValue="%{code_nm}" theme="simple" />
									<input type="text" name="searchInfo" maxlength="40" value="${searchInfo }">
									<input type="submit" value="検索">
								</s:form>
							</td>
						</tr>
					</table>
					
					
					
					<table  width="890" cellpadding="0" cellspacing="0" border="0">
						<tr style="height:5px;"><td></td></tr>
							<tr style="background: url('img/bbs/table_mid.gif') repeat-x; text-align: center;">
							<th width="5"><img src="img/bbs/table_left.gif" width="5" height="30" /></th>
							<th width="10%">番号</th>
							<th width="15%">カテゴリー</th>
							<th width="50%">題目</th>
							<th width="15%">作成者</th>
							<th width="10%">更新日</th>
							<th width="5"><img src="img/bbs/table_right.gif" width="5" height="30" /></th>
						</tr>
					</table>
							
					<table id="bbs_list" width="890"  style="table-layout:fixed">
						<s:if test='list.size()>0'>
	                         <s:iterator value="list" var="list">
								<tr>
									<td width="10%"><s:property value="BBS_NUMBER"/></td>
									<td width="14%"><s:property value="BBS_CATEGORY"/></td>
									<td width="51%">
									<nobr>
									<s:url id="view" action="bbsView">
										<s:param name="bbs_number"><s:property value="BBS_NUMBER"/></s:param>
										<s:param name="page"><s:property value="page"/></s:param>
										<s:param name="searchOption1"><s:property value="searchOption1"/></s:param>
										<s:param name="searchOption2"><s:property value="searchOption2"/></s:param>
										<s:param name="searchInfo"><s:property value="searchInfo"/></s:param>
									</s:url>
									<s:a href="%{view}"><s:property value="BBS_TITLE"/>
										<s:if test="%{#list.BBS_FNAME!='none'}"><img src="img/bbs/listIcon.jpg"/></s:if></s:a></nobr></td>
									<%-- <td width="15%"><s:property value="TRK_ID"/></td> --%>
 						
 										<td width="15%"><s:property value="USER_NAME"/></td>
 										<td width="10%"><font title="<s:property value='TRK_TIME'/>"><s:property value="TRK_DATE"/></font></td>
								</tr>
							</s:iterator>
						</s:if>
				
						<s:else>
							<th>
								データがありません。
							</th>
							
						</s:else>
					</table>
				</div>
			</div>

			<table width="890">
				<tr>
					<td width="5%"><input type="button" value="作成" onClick="location.href='bbsWrite'"/></td>
					<td align="center">
						
					<s:if test="beforePage>1">	
						<s:url id="beforepage" action="bbsList">
							<s:param name="page"><s:property value="beforePage"/></s:param>
							<s:param name="searchOption1"><s:property value="searchOption1"/></s:param>
		                    <s:param name="searchOption2"><s:property value="searchOption2"/></s:param>
		                    <s:param name="searchInfo"><s:property value="searchInfo"/></s:param>
						</s:url>
						<s:a href="%{beforepage}"><img src="img/download/before.jpg" /></s:a>
					</s:if>

					<s:iterator value="pagingList" >    
		            	<s:url id="nowPageLink" action="bbsList">      
		                	<s:param name="page"><s:property /></s:param>
		                    <s:param name="searchOption1"><s:property value="searchOption1"/></s:param>
		                    <s:param name="searchOption2"><s:property value="searchOption2"/></s:param>
		                    <s:param name="searchInfo"><s:property value="searchInfo"/></s:param>
		              	</s:url> 	              			
		                <s:a href="%{nowPageLink}"><span  id="<s:property/>">[<s:property/>]</span></s:a>           
		             </s:iterator>
		                    
					<s:if test="nextPage>0">	
						<s:url id="nextpage" action="bbsList">
							<s:param name="page"><s:property value="nextPage"/></s:param>
							<s:param name="searchOption1"><s:property value="searchOption1"/></s:param>
		                    <s:param name="searchOption2"><s:property value="searchOption2"/></s:param>
		                    <s:param name="searchInfo"><s:property value="searchInfo"/></s:param>
						</s:url>
						<s:a href="%{nextpage}"><img src="img/download/after.jpg" /></s:a>
	                </s:if>
                    </td>    
			 	</tr>
			 </table>

		</div>
	</section>
</center>
</body>
</html>