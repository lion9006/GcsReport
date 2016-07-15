<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/memberList.css" />
</head>
<script type="text/javascript">
	function deleteCheck(){
		answer = confirm("削除しますか。");
		if(answer==false){
			return false;
		}
	}
</script>


<body>
	　<%if(session.getAttribute("id")==null){
   %>
      <script> 
       top.disableActive();
      </script> 
   <% 
   }else{
   %>    
	   <script type="text/javascript">
	   	top.fncClearTime();
	   </script>
   <%} %>        
	<center>   
        <section id="content" style="margin-top:-30px">
            <div class="loBB bt5px" id="log_op" overflow="visible">
                <div id="logintool">
                    <img src="img/manager/managerpage.png"/>                  
                    <div style="overflow: hidden; width: 890px; margin-top: -26px;">
                        <s:form method="post"  onsubmit="javascript:return check()" action="memberSearchManager">
                        <table id="search" width="890">
                            <tr>
                                <td colspan="9">
                                    <s:select name="SearchOption" list="codeList" listValue="%{code_nm}" listKey="%{ssk_nm}" theme="simple" />
                                    <input id="SearchInfo" name="SearchInfo" type="text" maxlength="20" placeholder="内容" value="${searchInfo }"/>
                                    <input type="submit" alt="search" value="検索" />
                                </td>
                            </tr>
                        </table>
                        </s:form>
                        <table width="890" cellpadding="0" cellspacing="0" border="0">                         
                            <tr style="height:5px"><td></td></tr>
                            <tr style="background: url('img/memberList/table_mid.gif') repeat-x; text-align: center;">
                            <th width="5"><img src="img/memberList/table_left.gif" width="5" height="30" /></th>
                            
                                <th width="4%">番号</th>
                                <th width="10%">社員番号</th>
                                <th width="12%">名前</th>
                                <th width="10%">部署</th>
                                <th width="10%">職級</th>
                                <th width="18%">メール</th>
                                <th width="14%">電話番号</th>
                                <th width="10%">カカオID</th>
                                <th width="6%">修正</th>
                                <th>削除</th>
                                <th width="5"><img src="img/memberList/table_right.gif" width="5" height="30" /></th>
                            </tr>
                        </table>
                        <table id="download_list" width="890" border="0" style="table-layout:fixed">
	                        <s:iterator value="userList" status="num" >
	                            <tr>
	                            	<th width="5" align="center"></th>
	                                <td width="3%" align="center"><s:property value="#num.index+1"/></td>
	                                <td width="11%" align="center"><s:property value="USER_ID"/></td>
	                                <td width="12%" title="「名前」&#13 &nbsp <s:property value="USER_CCFNAME"/><s:property value="USER_CCLNAME"/>
	                                	&#13「カタカナ名前」&#13 &nbsp <s:property value="USER_KATAFNAME"/><s:property value="USER_KATALNAME"/>
	                                	&#13「備考」 &#13 &nbsp <s:property value="USER_INFO"/>" align="center">
	                                <nobr><s:property value="USER_CCFNAME"/><s:property value="USER_CCLNAME"/></nobr></td>
	                                <td width="10%" align="center"><s:property value="USER_DEPARTMENT"/></td>
	                                <td width="10%" align="center"><s:property value="USER_RANK"/></td>
	                                <td width="18%" align="center"><s:property value="USER_EMAIL"/></td>
	                                <td width="14%" align="center"><s:property value="USER_PHONE"/></td>
	                                <td width="11%" align="center"><s:property value="USER_KAKAOTALK"/></td>
	                                <td width="5%" align="center" valign="middle">
	                                <form action="callUpdateScreen.action" method="POST" >
	                                	<input type="hidden" id="user_id" name="user_id" value="<s:property value='USER_ID'/>"/>
	                                	<input type="submit" value="修正">
	                                </form>
	                                </td>
	                                <td align="center" width="5%" valign="middle">
	                                	<form action="deleteMember" onsubmit="javascript:return deleteCheck()" method="post">
	                                	<input type="hidden" id="user_id" name="user_id" value="<s:property value='USER_ID'/>"/>
	                                		<input type="submit" value="削除">
	                                	</form>
	                                </td>
	                                <td width="5" align="center"></td>
	                            </tr>
	                        </s:iterator>
                        </table>                     
                    </div>
                </div>
            </div>
        </section>
    </center>
</body>
</html>