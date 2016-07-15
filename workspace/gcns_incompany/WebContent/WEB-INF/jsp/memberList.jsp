<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>社員リスト</title>

    <link rel="stylesheet" href="css/memberList.css" />
	<script type="text/javascript">
		function page(page) {
			document.getElementById(page).style.fontWeight = "bolder"; 
		}

/*		function  check() {
=======
/* 		function  check() {
>>>>>>> .r1086
			var data = document.getElementById("SearchInfo");
			if(data.value==" "|| data.value==null||data.value==""){
				alert("内容を入力してください。");
				return false;
			}else{
				return true;
			}
<<<<<<< .mine
		}*/

	</script>
</head>
<body onload="page(${page})">        

   <script>printSWF("flash/j_main.swf", 900, 408)</script>
   
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
            <div class="loBB bt5px" id="log_op">
                <div id="logintool">
                    <img src="img/memberList/title.png" />                  
                    <div style="overflow: hidden; width: 890px; margin-top: -26px;">
                      	<s:form method="post"   onsubmit="javascript:return check()" action="memberListSearch">
                        <table id="search" width="890">
                            <tr>
                                <td colspan="9">   
                                	<s:select name="SearchOption" list="codeList" listValue="%{code_nm}" listKey="%{ssk_nm}" theme="simple" />
                                    <input id="SearchInfo" name="SearchInfo" type="text" maxlength="20" placeholder="内容" value="${SearchInfo}" />
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
                                <th width="17%">名前</th>
                                <th width="9%">&nbsp;&nbsp;&nbsp;部署</th>
                                <th width="17%">&nbsp;&nbsp;&nbsp;職級</th>
                                <th width="22%">メール</th>
                                <th width="15%">電話番号</th>
                                <th width="17%">カカオトークID</th>
                                <th width="5"><img src="img/memberList/table_right.gif" width="5" height="30" /></th>
                            </tr>
                        </table>
                        <table id="download_list" width="890" style="table-layout:fixed">
                        	<s:if test='list.size()>0'>
	                        	<s:iterator value="list">
	                            <tr>
	                                <td width="3%"><s:property value="USER_LIST_INDEX"/></td>
	                                <td width="18%" title="「名前」&#13 &nbsp <s:property value="USER_CCFNAME"/><s:property value="USER_CCLNAME"/>
	                                	&#13「カタカナ名前」&#13 &nbsp <s:property value="USER_KATAFNAME"/><s:property value="USER_KATALNAME"/>
	                                	&#13「備考」 &#13 &nbsp <s:property value="USER_INFO"/>"><nobr>
<!-- 	                                	<div  style = "width:160px; text-overflow:ellipsis; overflow:hidden; white-space:normal;"> -->
	                                	<s:property value="USER_CCFNAME"/><s:property value="USER_CCLNAME"/></nobr>
<!-- 	                                	</div> --></td>
	                                <td width="9%"><s:property value="USER_DEPARTMENT"/></td>
	                                <td width="17%"><s:property value="USER_RANK"/></td>
	                                <td width="22%" title="<s:property value="USER_EMAIL"/>"><div style = "width:178px; text-overflow:ellipsis; overflow:hidden; white-space:normal;"><s:property value="USER_EMAIL"/></div></td>
	                                <td width="15%"><s:property value="USER_PHONE"/></td>
	                                <td width="17%"><s:property value="USER_KAKAOTALK"/></td>
	                            </tr>
	                            </s:iterator>
                            </s:if> 
							<s:else>
							    <tr>
	                            	<th colspan="7">データがありません。</th>
	                            </tr>
	                        </s:else>
                        </table>                          
                    </div>
                </div>
          
                <table>
                    <tr> 
                    	
                        <td>
<!--                         <a href="#"><img src="img/download/before.jpg" /></a> -->
                        </td>  
                                        
                        <td>             
                        <s:iterator value="pagingSearchList" >                    
                        <s:url id="nowPageLink"  action="memberListSearch" >                   		
                        		<s:param name="SearchOption"><s:property value="SearchOption" /></s:param>
                        		<s:param name="SearchInfo"><s:property value="SearchInfo" /></s:param>
                        		<s:param name="page"><s:property/></s:param>
              			 </s:url> 
                        		<s:a href="%{nowPageLink}">[<span  id="<s:property/>"><s:property/></span>]</s:a>
                        </s:iterator>
                        
                        <s:iterator value="pagingList" >    
                        <s:url id="nowPageLink" action="memberList">      
                        		<s:param name="page"><s:property /></s:param>
              			 </s:url> 
                        		<s:a href="%{nowPageLink}">[<span  id="<s:property/>"><s:property/></span>]</s:a>           
                        </s:iterator>
                   
                        </td>                         
                        <td>
<!--                         <a href="#"><img src="img/download/after.jpg" /></a> -->
                        </td>
                        	
                    </tr>
                </table>
              
            </div>
        </section>
    </center>
</body>
</html>