<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type = "text/css" href="css/bbs_view.css" >
<title>view</title>
<script type="text/javascript">

function comWrite(){
	var comform = document.comData;
	if(comData.com_content.value == ''){
		alert('内容を入力してください。');
		document.comData.title.focus();
	}else
		document.comData.submit();
	}
function comment_delete(){
 	var returnValue = confirm("コメント削除しますか。");
 	if(returnValue == true){
 		var comment = document.getElementById("comForm");
 		comment.setAttribute("action", "comDelete");
 		 document.formData.submit();
 	}
}



function Deleted(){
	 var returnValue = confirm("削除しますか。");
	    if(returnValue == true){
	       var del = document.getElementById("formData");
	       del.action = "bbsDelete";
	       del.submit();
	    }
}




</script>
 
</head>
<body>
    
    <center>
        <section id="content" style="margin-top:-30px">          
               <div class="loBB bt5px" id="log_op">
              <div id="logintool">
                    <img src="img/bbs/title.png" />                   
                    <div style="overflow:hidden; width:890px;">
              
						<s:form id="formData" method="post" action="bbsDelete">
								
							<table border="0" cellpadding="0" cellspacing="0" width="890" id="join1" align="center">
								<tr>
									<td height="34" class="title_size" colspan="2"><img src="img/join/join_title_leftline.png" /> 詳細</td>
								</tr>
								
								
						<s:iterator value="bbslist" var="list">
							    <tr>
								
								<td width="200" class="td" >カテゴリー  </td>
								<td align="left" class="td"><s:property value="CODE_NM"/></td>
								</tr>
								<tr class="gcs">
									<td width="200" class="td" >題目  
									</td>
									<td align="left" class="td">	<s:property value="BBS_TITLE"/>		
									</td>
								</tr>
								<tr class="gcs">
									<td width="200" class="td" >作成者  
									</td>
									<%-- <td align="left" class="td">	<s:property value='UPD_ID'/>
									</td> --%>
									<td align="left" class="td">	<s:property value='USER_NAME'/>  &lt<s:property value='USER_NAME_KATA'/>&gt
									</td>
										
								</tr>
								<tr class="gcs">
									<td width="200" class="td" >作成日 
									</td>
									<td align="left" class="td">	 <s:property value="TRK_DT"/>	
									</td>
								</tr>

								<tr class="gcs">
									<td width="200" class="td" >添付ファイル </td>
									<td align="left" class="td">
									    <s:url id="download" action="bbsDownload">      
				                        		<s:param name="bbs_number"><s:property value="BBS_NUMBER" /></s:param>
				                        		<s:param name="bbs_fname"><s:property value="BBS_FNAME" /></s:param>
				              			</s:url>
				              			    <s:if test="%{BBS_FNAME!='none'}">
				              				<s:a href="%{download}"><s:property value="BBS_FNAME"/></s:a> 
				              			</s:if> 
			                        	<s:else>添付ファイルない</s:else>         
			             		 
									</td>
								</tr>
								<tr class="gcs">
									<td width="200" class="td" >内容  </td>
									<td class="td" align="left">
										<pre style="word-wrap: break-word;white-space: pre-wrap; white-space:-moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap;word-break:break-all;"><s:property value="BBS_CONTENT"/></pre>
									</td>
								</tr>
						
			  		
					 <tr class="gcs">                      
			                   		
                           <s:if test='login_TRK_ID == 1'>
                        			<td align="right" colspan="2">
                        
                           <s:url id="update" action="bbsUpdate">
                              			<s:param name="BBS_NUMBER"><s:property value="BBS_NUMBER"/></s:param>
                         				<s:param name="searchOption1"><s:property value="searchOption1"/></s:param>
										<s:param name="searchOption2"><s:property value="searchOption2"/></s:param>
										<s:param name="searchInfo"><s:property value="searchInfo"/></s:param>
										<s:param name="page"><s:property value="page"/></s:param>
                           </s:url>
                            <s:a class="myButton" href="%{update}">修正</s:a>
                            
                            
								<input type="hidden" name="BBS_NUMBER" value="<s:property value="BBS_NUMBER"/>">
								<input type="hidden" name="searchOption1" value="<s:property value="searchOption1"/>">
								<input type="hidden" name="searchOption2" value="<s:property value="searchOption2"/>">	
								<input type="hidden" name="searchInfo" value="<s:property value="searchInfo"/>">
								<input type="button" class="myButton" onClick="Deleted()" value="削除">
                            
                            <s:url id="list" action="bbsList">
										<s:param name="searchOption1"><s:property value="searchOption1"/></s:param>
										<s:param name="searchOption2"><s:property value="searchOption2"/></s:param>
										<s:param name="searchInfo"><s:property value="searchInfo"/></s:param>
										<s:param name="page"><s:property value="page"/></s:param>
							 </s:url>
							 <s:a class="myButton"  href="%{list}">リスト</s:a>
							 
                           </td>

							</s:if>
							 <s:elseif test='login_TRK_ID == 2'>
                        			<td align="right" colspan="2">
                        
								<input type="hidden" name="BBS_NUMBER" value="<s:property value="BBS_NUMBER"/>">
								<input type="hidden" name="searchOption1" value="<s:property value="searchOption1"/>">
								<input type="hidden" name="searchOption2" value="<s:property value="searchOption2"/>">	
								<input type="hidden" name="searchInfo" value="<s:property value="searchInfo"/>">
								<input type="button" class="myButton" onClick="Deleted()" value="削除">
                            
                            <s:url id="list" action="bbsList">
										<s:param name="searchOption1"><s:property value="searchOption1"/></s:param>
										<s:param name="searchOption2"><s:property value="searchOption2"/></s:param>
										<s:param name="searchInfo"><s:property value="searchInfo"/></s:param>
										<s:param name="page"><s:property value="page"/></s:param>
							 </s:url>
							 <s:a class="myButton"  href="%{list}">リスト</s:a>
							 
                           </td>

							</s:elseif>
							<s:else>
	                       	 <td>
	                       		 <td align="right" colspan="2">
                          
                                    
                            <s:url id="list" action="bbsList">
										<s:param name="searchOption1"><s:property value="searchOption1"/></s:param>
										<s:param name="searchOption2"><s:property value="searchOption2"/></s:param>
										<s:param name="searchInfo"><s:property value="searchInfo"/></s:param>
										<s:param name="page"><s:property value="page"/></s:param>
							 </s:url>
							 <s:a class="myButton"  href="%{list}">リスト</s:a>
							 
                           </td>
							 	</s:else>
						 </tr>
                        
							</s:iterator>	
						
							</table>
						
                </div>
            
          

            <div  width="890px">
            
            	
            	<div style="position:center;text-align: center"><b><i>コ &nbsp;メ &nbsp;ン &nbsp;ト</i></b></div>
          			<div id="ripple_write">
            			<s:iterator value="commentlist">
            				<div id="ripple">
            	
		           			 <table width = "850px">
           			    
        		                <tr>
        	                
        	                
        		   					<th width="20%" align="left" ><s:property value="USER_CCFNAME"/><s:property value="USER_CCLNAME"/>
        		   					  &nbsp;&nbsp;(<s:property value="TRK_ID"/>) </th>
        							<td align="left"><s:property value="TRK_DT"/></td>       						
        						</tr>
        						<tr>
        	
        							<td  width="880px"colspan="2"align="left" ><pre style="word-wrap: break-word;white-space: pre-wrap; white-space:-moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap;word-break:break-all;"><s:property value="COM_CONTENT"/></pre></td>
        							<td align="right">

        					
        						 		<s:url id="Comdelete" action="comDelete">
                         	     			<s:param name="com_number"><s:property value="COM_NUMBER"/></s:param>
                        	 	    		<s:param name="bbs_number"><s:property value="BBS_NUMBER"/></s:param>
      			                       		<!--  -->
      			                       		<s:param name="searchOption1"><s:property value="searchOption1"/></s:param>
											<s:param name="searchOption2"><s:property value="searchOption2"/></s:param>
											<s:param name="searchInfo"><s:property value="searchInfo"/></s:param>
											<s:param name="page"><s:property value="page"/></s:param>
											
                          				 </s:url>
                          			
                            			 <s:if test='login_TRK_ID == "2" || login_TRK_ID == "1"'>
                            			 <s:a href="%{Comdelete}"><img src="img/bbs/x.png" width="10px" onclick="comment_delete();" alt="削除" ></s:a>
                            			 </s:if>
                            			
                            			 					
        							</td>
        						</tr>	
        					</table>
        			
        				
        				</div>
	        		</s:iterator>
        		</s:form>
        		
        			<s:form  id="comData"   action="comWrite" method="POST" enctype="multipart/form-data">
						<input type="hidden" id="bbs_number" name="bbs_number"  value="${bbs_number}"/>
						<input type="hidden" id="searchOption1" name="searchOption1" value="${searchOption1}"/>
						<input type="hidden" id="searchOption2" name="searchOption2" value="${searchOption2}"/>	
						<input type="hidden" id="searchInfo" name="searchInfo" value="${searchInfo}"/>
						<input type="hidden" id="page" name="page" value="${page}"/>
						<!--  -->
       
        					
        				   <table width="890px" border="0">
        			        	<tr >
        						 	<td align="left">
        								<input name ="com_content"type="text" maxlength="100"size="110" value="" placeholder=100字以下作成してください">
        							
									</td>
        							<td align="right">
        									
        									<input type = "button" onclick="comWrite()" value="コメント書く">
        									
        							
        									
        							</td>
        					    </tr>        	
       						</table>
						</div>           
          
             		</s:form>
        
            	</div>
            </div>
         </section>
       </center>
</body>

</html>