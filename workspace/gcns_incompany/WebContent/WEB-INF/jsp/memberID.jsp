<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ID発給</title>
	<link rel="stylesheet" href="css/memberID.css" />
	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
	var chkStat=0;
	
	var dep="1";	// 부서 풀다운 초기값
	var hei="1";	// 헤이세이 풀다운 초기값
	var nen="01";	// 연호 풀다운 초기값
	var mon="01";	// 입사월 풀다운 초기값
	
		 
	function dupCheck(){
		var USER_ID = $('#USER_ID').val();
	    if(USER_ID.length<7){ 
	    	/* alert("IDは8桁だけを入力可能です。"); */
	/*     	return; */
	    }else{
		    $.ajax({
			    url:'DupCheck.action',
			    type:'post',
			    dataType:'json',
			    data:{USER_ID:USER_ID},
			    success:dupCheckOK
		    });	    
	    }	    
	}	
	
	function dupCheckOK(msg){

		
		if(msg.userIDTBLBean==null){
				document.InsertUserID.submit();
				alert("IDは成功的に発給しました。");
		}else{
			alert("IDがすでに存在するです");
			return;
		}		
	}
	
/*     function digit_Idcheck(evt) {
//     	alert("1");
        var num1 = document.getElementById("USER_ID");
//         alert("2");
        var code = evt.which ? evt.which : event.keyCode;
//         alert("ID num");
        if (code < 48 || code > 57) {
//         	alert("digit"+code);
//         	alert("ss");
//				fnAlertMsg('[お知らせ]');
            num1.value="";
            return false;
        }else{
        	var USER_ID = $('#USER_ID').val();
        	if(USER_ID.length<8){ 
        		
        	}else{
        		$.ajax({
				    url:'DupCheck.action',	
				    type:'post',
				    dataType:'json',
				    data:{USER_ID:USER_ID},
				    success:dupCheckOK
		 		});
        	}
        	
        }
        
    } */
    // 아이디 전각문자입력 불가능
/*     function checkhalf() {
   	 	
        var str = document.getElementById("uid");
        var foc = document.getElementById("kaid");
        chkstr = escape(str.value);
        if (chkstr.indexOf('%') != -1) {
        	foc.focus();
			alert("ID入力は「半角数字」でお願いします。");
        	str.value = "";
            str.focus();
            
            return false;
        }
    } */
    
    
    
    function toId(){													//id발급화면 풀다운 이벤트함수
    	var memNum="00";
    	
    	if(document.getElementById("departM").value=='GCS'){
    		dep=1;
    	}else if(document.getElementById("departM").value=='NUVO'){
    		dep=2;
    	}else if(document.getElementById("departM").value=='PSS'){
    		dep=9;
    	}
    	
    	nen= document.getElementById("heiSei").value;
    	mon= document.getElementById("joinMon").value;

    	 for (i = 0; i <100 ; i++) {
             memNum = i;
             document.getElementById("USER_ID").length=i;
      
             if (i<10) {       	 
            	 var opt=new Option(dep+hei+nen+mon+"0"+memNum);	
             }else{
              	var opt=new Option(dep+hei+nen+mon+memNum);     	
    	 	}
                document.getElementById("USER_ID").options[i] = opt;
         }   		
    }
</script>
<style>
         #stat{
            position:relative;
            color:red;
            font-size:12px;
            font-weight: bold;
        }
</style>
</head>

<body onload="toId()"> 	<!-- 페이지 디폴트 풀다운 초기화 -->
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
        <table border="0" cellpadding="0" cellspacing="0" width="1024" id="search">          
            <tr>
                <td class="title1">ID発給</td>
            </tr>            
        </table>
        
        <form method="post" action="InsertUserID" name="InsertUserID" autocomplete="off" >
            <table border="0" cellpadding="0" cellspacing="0" width="1004" id="search1" valign="center">
                <tr>
                    <td height="34" class="title_size" colspan="2"><img src="img/join/join_title_leftline.png" /> </td>
                </tr>
                
                 <tr class="gcs">
                    <td width="350" class="td">* 部署</td>
                    <td align="left" class="txtbox" style="left:-400px">
						<select id="departM" onchange="toId();">
							<option>GCS</option>
						    <option>NUVO</option>
						    <option>PSS</option>
						</select>
                    </td>
                </tr>
                
                  <tr class="gcs">
                
                    <td width="350" class="td">* 年号</td>
                    <td align="left" class="txtbox" style="left:-400px">
 					<select>				
 				 		<option>平成</option>	
 				</select> 				
                    </td>
                </tr>
                            
                 <tr class="gcs">
                
                    <td width="350" class="td">* 入社日 </td>
                    <td align="left" class="txtbox" style="left:-400px">
                     
 					<select id="heiSei" onchange="toId();">
 						    <option value="01">1</option>
                            <option value="02">2</option>
                            <option value="03">3</option>
                            <option value="04">4</option>
                            <option value="05">5</option>
                            <option value="06">6</option>
                            <option value="07">7</option>
                            <option value="08">8</option>
                            <option value="09">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
  				 			<option value="13">13</option>
  				 			<option value="14">14</option>
  				 			<option value="15">15</option>
  				 			<option value="16">16</option>
  				 			<option value="17">17</option>
  				 			<option value="18">18</option>
  				 			<option value="19">19</option>
  				 			<option value="20">20</option>
  				 			<option value="21">21</option>
  				 			<option value="22">22</option>
  				 			<option value="23">23</option>
  				 			<option value="24">24</option>
  				 			<option value="25">25</option>
  				 			<option value="26">26</option>
  				 			<option value="27">27</option>
 				 				 				
 				</select>&nbsp;年&nbsp;
                        <select name="joinMon" id="joinMon" onchange="toId();">
                            <option value="01">1</option>
                            <option value="02">2</option>
                            <option value="03">3</option>
                            <option value="04">4</option>
                            <option value="05">5</option>
                            <option value="06">6</option>
                            <option value="07">7</option>
                            <option value="08">8</option>
                            <option value="09">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>&nbsp;月&nbsp;                  
                    </td>
                </tr>           
                
                <tr class="gcs">
                
                    <td width="350" class="td">* 社員ID </td>
                    <td align="left" class="txtbox"  style="left:-400px">
                                      
 						<select name="USER_ID" id="USER_ID">
 							<option></option>
 						</select>
                    </td>
                </tr>
                
                <tr>
               	  <s:if test="nowSavedId!=null">
               		 <td>
               		 	<label id="stat">* ただいま登録したID: <s:property value="nowSavedId"/></label>
               		 </td>
              	  </s:if>
                  <s:else>
 					<td>
 						<label id="stat"></label>  
 					</td>  
 				  </s:else>         
             </tr>
                       
                <tr>
                    <td height="3" class="title_size" colspan="2"></td>
                </tr>
                <tr>
                	<td width="500">
                		※社員番号の発給ルール<br/>
                		&nbsp;&nbsp;&nbsp;社員番号は会社コード１桁+年号１桁+入社年月４桁+連番２桁<br/>
                		&nbsp;・会社コード<br/>
                		&nbsp;&nbsp;&nbsp;GCS:1&nbsp;NUBO:未定&nbsp;PSS:9<br/>
                		&nbsp;・年号<br/>
                		&nbsp;&nbsp;&nbsp;平成：１<br/>
                		&nbsp;・入社年月
                		&nbsp;&nbsp;&nbsp;年号年月を使用<br/>
                		&nbsp;連番
                		&nbsp;&nbsp;&nbsp;年の月別に01番で始めます。             		
                	</td>
                </tr>
         
                <tr>
                    <td colspan="2">
                        <table align="center" height="70">
                            <tr>
                                <td>
                                	<input type="button" onclick="dupCheck()" value="入力確認">&nbsp;&nbsp;
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
         
        </form>
    </center>
</body>
</html>


