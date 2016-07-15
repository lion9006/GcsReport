<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>各種報告書 ダウンロード</title>

    <link rel="stylesheet" href="css/download.css" />
	<script type="text/javascript">
		function page(page) {
			document.getElementById(page).style.fontWeight = "bolder"; 
		}
/* 		function  check() {
			var data = document.getElementById("SearchInfo");
			if(data.value==" "|| data.value==null||data.value==""){
				alert("内容を入力してください。");
				return false;
			}else{
				return true;
			}
		} */
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
                    <img src="img/download/title.png" />                   
                    <div style="overflow:hidden; width:890px; margin-top: -26px;">
                    	<form method="post"  onsubmit="javascript:return check()" action="downloadListSearch">
                        <table id="search" width="890">
                            <tr>
                             
                                <td colspan="2">
                                <input id="SearchInfo" name="SearchInfo" type="text" maxlength="20" placeholder="ファイル名" value="${searchInfo }"/>
                                <input type="submit" alt="search" value="検索" />
                                </td>
                            </tr>
                        </table>
                        </form>
                        <table width="890" cellpadding="0" cellspacing="0" border="0">
                            <tr style="height:5px;"><td></td></tr>
                            <tr style="background: url('img/download/table_mid.gif') repeat-x; text-align: center;">
                                <th width="5"><img src="img/download/table_left.gif" width="5" height="30" /></th>
                                <th width="5%">番号</th>
                                <th width="50%">ファイル名</th>
                                <th width="20%">作成者</th>
                                <th width="25%">更新日</th>
                                <th width="5"><img src="img/download/table_right.gif" width="5" height="30" /></th>
                            </tr>
                        </table>
           
                        <table id="download_list" width="890">
                        <s:if test='list.size()>0'>
	                         <s:iterator value="list">
								<tr>
									<td width="5%"><s:property value="FILE_LIST_INDEX"/></td>
									<td width="50%" title="「ファイル情報」&#13 &nbsp <s:property value="FILE_INFO"/>">
								
				                        <s:url id="download" action="download">      
				                        		<s:param name="FILE_INDEX"><s:property value="FILE_INDEX" /></s:param>
				              			</s:url> 
			                        	<s:a href="%{download}"><div style = "width:445px; text-overflow:ellipsis; overflow:hidden; white-space:normal;"><s:property value="FILE_NAME"/>.<s:property value="FILE_TYPE"/></div></s:a>           
			             		 
									
									</td>
									<%-- <td width="20%"> <s:property value="TRK_ID"/></td> --%>
									<td width="20%"> <s:property value="USER_NAME"/></td>
									<td width="25%"> <s:property value="UPD_DT"/></td>
								</tr>		
							</s:iterator>
						</s:if> 
						<s:else>
						    <tr>
                            	<th colspan="9">データがありません。</th>
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
	                        <s:url id="nowPageLink"  action="downloadListSearch" >                   		                   
	                        		<s:param name="SearchInfo"><s:property value="SearchInfo" /></s:param>
	                        		<s:param name="page"><s:property/></s:param>
	              			 </s:url> 
	                        		<s:a href="%{nowPageLink}">[<span  id="<s:property/>"><s:property/></span>]</s:a>
	                        </s:iterator>
	                        
	                        <s:iterator value="pagingList" >    
	                        <s:url id="nowPageLink" action="downloadList">      
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