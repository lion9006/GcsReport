<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <style>
    	.mousePointer:hover {
		cursor: pointer;
		}
		
		.gradient {
		
			background: linear-gradient(to right, skyblue, white);
		}
		
		#divMayus {
			margin-left: 17px;
		}
		


    </style>
    <meta charset="utf-8" />
    <script language="javascript" src="js/object.js"></script>
   
    <title>GCS Shared System</title>
</head>
<body>
   
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
</body>

</html>