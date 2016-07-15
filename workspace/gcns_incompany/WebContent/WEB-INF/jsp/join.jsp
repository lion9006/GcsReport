<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>会員登録</title>    
    <link rel="stylesheet" href="css/join.css" />
    <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
    <script type="text/javascript">
    function onload() {
    	setEmailTail();
    }
/* 	var count =0;

	function idCheck(){	//id	
		var USER_ID = $('#uid').val();	
	    if(USER_ID.length<7){ 
	  /*   if(USER_ID.length<7){
	    	
	    }else if(USER_ID.length>7){	    
			 }else{
				  $.ajax({
				    url:'DupCheck1.action',
				    type:'post',
				    dataType:'json',
				    data:{USER_ID:USER_ID},
				    success:idCheckOK
			 });
		}
		  }	
	}
	    */
// 			var USER_ID = document.getElementById("uid");
// 		    if(USER_ID.value.length<8){
// 		    	alert("IDは8席だけを入力可能です。");
// 		    	return;
// 		    }else{
// 			    $.ajax({
// 				    url:'DupCheck.action',
// 				    type:'post',
// 				    dataType:'json',
// 				    data:{USER_ID:USER_ID},
// 				    success:idCheckOK
// 			    });
// 		    }
		
		function idCheckOK(msg){
			var str1='使用可能なIDです。';
			var str2='すでに存在するIDです。';
// 			alert(msg.userTBLBean);
			var USER_ID = $('#uid').val();
			
			if(msg.userTBLBean==null){
				$('#po1').html(str2);
			}else{
				$('#po1').html(str1);
		 	} 
			
		/* 	
			if(msg.userTBLBean==null){
				$('#po1').html(str1);
		
 			}else{
 				$('#po1').html(str2);
 	 		}	 */
			
			
// 			if(msg.userTBLBean==null){
// 				$('#po1').html(str1);
		
// 			}else if(msg.userTBLBean!=null){
// 				$('#po1').html(str2);
// 	 		}	
			

		}			
	
// 	function dupCheckOK(msg){
		
// 		alert(msg);
// 		var str1='使用可能なIDです。';
// 		var str2='すでに存在するIDです。';
// 		if(msg.userIDTBLBean==null){
// 			$('#stat').html(str1);
// 			chkStat=1;
// 		}else if(msg.userIDTBLBean!=null){
// 			$('#stat').html(str2);
// 		}
		
// 	}	
        function signup() {//button-> check
            minlength = 6;
            maxlength = 8;
            var invalid = " ";
            var num1 = document.getElementById("uid");
            var pw1 = document.getElementById("pw1");
            var pw2 = document.getElementById("pw2");
            var ccfname = document.getElementById("ccfname");
            var cclname = document.getElementById("cclname");
            var katafname = document.getElementById("katafname");
            var katalname = document.getElementById("katalname");
            var address = document.getElementById("address");
            var email1 = document.getElementById("femail");
            var email2 = document.getElementById("lemail");
            var idchk=document.getElementById("po1").innerHTML;
            
            if (num1.value == "") {
                alert("社員番号の情報を入力してください。");
                //                return false;
            }else if (num1.value.length < maxlength) {
            	alert("IDは８桁です。");
            	//                return false;
            }else if(idchk=="すでに存在するIDです。"){
            	alert("すでに存在するIDです。");
            }else if (pw1.value == "") {
                alert("パスワードを入力してください。");
                //                return false;
            }else if (pw1.value.length < minlength) {
                alert(" パスワードを6桁以上入力して下さい。");
                //                return false;
            }else if (pw1.value.indexOf(invalid) > -1) {
            	alert("パスワードで空白があります。");
            	//                 return false;
            }else if (pw2.value == "") {
                alert("パスワード確認を入力してください。");
                //                return false;
            }else if (pw2.value.indexOf(invalid) > -1) {
            	alert("パスワードで空白があります。");
            	//                 return false;
            }else if (pw1.value != pw2.value ) {
                alert("パスワードをもう一度確認してください。");
                //                return false;
            }else if (ccfname.value == "") {
                alert("漢字の性を入力してください。");
                //                return false;
            }else if (cclname.value == "") {
                alert("漢字の名を入力してください。");
                //                return false;
            }else if (katafname.value == "") {
                alert("カタカナの性を入力してください。");
                //                return false;
            }else if (katalname.value == "") {
                alert("カタカナの名を入力してください。");
                //                return false;
            }else if (address.value == "") {
                alert("住所を入力してください。");
                //                return false;
            }else if (email1.value == "") {
                alert("メールを入力してください。");
                //                return false;
            }else if (email1.value.length < 4) {
                alert("メールをを4桁以上入力して下さい。");
                //                return false;
            }else if (email1.value.indexOf(invalid) > -1) {
            	alert("メールで空白があります。");
            	//                 return false;
            }else if (email2.value == ""){
            	alert("メールを入力してください。");
            	//            	return false;
            }else if (email2.value.length < 4) {
                 alert("メールをを4桁以上入力して下さい。");
                 //                 return false;
            }else if (email2.value.indexOf(invalid) > -1){
             	alert("メールで空白があります。");
             	//             	return false;
            }else{            
/*              	location.href = "MemberJoinAccess";
             	submit(); */
	        	var theform=document.getElementById("theform");
             	
	    		theform.action = "MemberJoinAccess";
	    		theform.submit();
            }          
        }
        function back() {
        	location.href="login.action";
        }
        function getDayofMonth() {
            var monarr = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
            var year = document.getElementById("birth1").options[document.getElementById("birth1").selectedIndex].value;
            var month = document.getElementById("birth2").options[document.getElementById("birth2").selectedIndex].value;
            
            if (month.substring(0, 1) == '0') {
                month = month.substring(1, 2);             
            }
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) monarr[1] = "29";
            return monarr[month - 1];          
        }
        function PrintDay() {
            for (var i = document.getElementById("birth3").length; i > -1; i--) document.getElementById("birth3").options[i] = null;
            for (i = 1; i <= getDayofMonth() ; i++) {
                if (i < 10) { i = "0" + i; }
                value = i;
                text = i;
                optDay = new Option(value, text);
                document.getElementById("birth3").options[document.getElementById("birth3").length] = optDay;
            }
            document.theform.birth3.selectedIndex = 0;         
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
        function pwdchk() {
            var pwd1 = document.getElementById("pw1").value;
            var pwd2 = document.getElementById("pw2").value;
            if (pwd2.length == 0 || pwd2 == null) {
                document.getElementById("chk").value = "パスワードを入力してください。";
                right = 0;
            } else if (pwd1 != pwd2) {
                document.getElementById("chk").value = "パスワードが違います。";
                right = 0;
            } else {   
                document.getElementById("chk").value = "パスワードが同じになります。";
                right = 1;
            }
            return;
        }   
//         function digit_check(evt) {
//           	var name = document.getElementById("ccfname");
//         	for(name.value=0; name.value<9; name.value++){
//         		  name.value= "";
//         		  return false;
//         	}  
//             var code = evt.which ? evt.which : event.keyCode;
//             if (33<= code||code <= 46) {
                
//                 var ccfname = document.getElementById("ccfname");
//                 var cclname = document.getElementById("cclname");
//                 var katafname = document.getElementById("katafname");
//                 var katalname = document.getElementById("katalname");
//                 ccfname.value="";
//                 cclname.value="";
//                 katafname.value="";
//                 katalname.value="";
//                 return false;
//                 }
//         }
        

        function digit_Idcheck(evt) {
//         	alert("1");
            var num1 = document.getElementById("uid");
//             alert("2");
            var code = evt.which ? evt.which : event.keyCode;
//             alert("ID num");
            if (code < 48 || code > 57) {
//             	alert("digit"+code);
//             	alert("ss");
// 				fnAlertMsg('[お知らせ]');
                num1.value="";
                return false;
            }else{
            	var USER_ID = $('#uid').val();
            	if(USER_ID.length<8){ 
            		
            	}else{
            	
            		$.ajax({
					    url:'DupCheck1.action',	
					    type:'post',
					    dataType:'json',
					    data:{USER_ID:USER_ID},
					    success:idCheckOK
			 		});
            	}
            	
            }
            
        }

        function checkhalf() {
       	 	
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
        }
//         function fnKeyDown(event){
//         	var str = document.getElementById("uid");
//         	str.value="";
//         }
       
    </script>
    <style>
        #po{
            position:relative;
            right:244px;
            color:red;
            font-size:12px;
        }
         #po1{
            position:relative;
            right:244px;
            color:red;
            font-size:12px;
        }
         #chk{
            position:relative;
            right:244px;
            color:blue;
            font-size:12px;
         }
         #kaid{
             text-transform:lowercase;
             ime-mode:disabled;
         }
    </style>
</head>
<body onload="onload()">

    <center>
        <table border="0" cellpadding="0" cellspacing="0" width="1024" id="join">
            <tr>
                <td colspan="3" height="45"><img src="img/join/join_logo.png" /></td>
            </tr>
            <tr>
                <td class="title1">社員登録</td>
            </tr>
            <tr>
                <td height="40">* のある項目は必ず入力してください。</td>
            </tr>
        </table>
        <s:form method="post" id="theform" name="theform" onsubmit="signup()" theme="simple">
            <table border="0" cellpadding="0" cellspacing="0" width="1004" id="join1" align="center">
                <tr>
                    <td height="33" class="title_size" colspan="2"><img src="img/join/join_title_leftline.png" /> 会社情報入力</td>
                </tr>
                <tr class="gcs">
                    <td width="350" class="td">* 社員番号  </td>
                    <td align="left">
                        <input type="text" maxlength="8" name="uid" id="uid" class="txtbox" size="23" onkeyup="return digit_Idcheck(event)" onkeydown="checkhalf()"  style="ime-mode:disabled"> 
                         <span id="po1">社員番号は数字だけで8桁までです。</span>
                    </td>                    
                </tr>
                <tr class="gcs">
                    <td class="td">* パスワード </td>
                    <td>
                        <input type="password" maxlength="16" name="pw1" id="pw1" class="txtbox" size="23">
                        <span id="po">パスワードは6~16桁までです。</span>
                   </td>          
               </tr>
                <tr class="gcs">
                    <td class="td">* パスワード確認　</td>
                    <td>
                        <input type="password" maxlength="16" name="pw2" id="pw2" class="txtbox" size="23" onblur="pwdchk()">
                        <input type="text" style="border-width:0px" size="20" name="chk" id="chk" value="パスワードを入力してください。" readonly="readonly" />
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td">* 職級  </td> 
                    <td class="txtbox">
                        <s:select list="rankList" id="rank" name="rank" listKey="%{code_no}" listValue="%{ssk_nm}"/>
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td"> * 部署  </td>
                    <td class="txtbox">
                         <s:select list="departmentList" id="department" name="department" listKey="%{code_no}" listValue="%{ssk_nm}"/>
                    </td>
                </tr>
                <tr>
                    <td height="33" class="title_size" colspan="2"><img src="img/join/join_title_leftline.png" /> 個人情報入力</td>
                </tr>
<!--                 <tr class="gcs"> -->
<!--                     <td class="td"> &nbsp; &nbsp;* 名前  </td> -->
<!--                     <td width="500px" align="left" class="txtbox"> -->
<%--                         <input type="text" maxlength="30" name="namae" id="namae" size="22" value="${namae}"> --%>
<!--                     </td> -->
<!-- onkeyup="return digit_check(event)"                </tr> -->
                <tr class="gcs">
                    <td class="td">* 名前 (漢字) </td>
                    <td width="500px" align="left">
                        <input type="text" maxlength="10" name="ccfname" id="ccfname" class="txtbox" size="10" placeholder="性">
                        <input type="text" maxlength="15" name="cclname" id="cclname" class="txtbox" size="15" placeholder="名">
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td">* 名前 (カタカナ) </td>
                    <td width="500px" align="left">
                        <input type="text" maxlength="10" name="katafname" id="katafname" class="txtbox" size="10" placeholder="性">
                        <input type="text" maxlength="15" name="katalname" id="katalname" class="txtbox" size="15" placeholder="名">
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td">* 性別  </td>
                    <td align="left" class="txtbox">                  
                        <input type="radio" name="gender" value="1" checked >男性&nbsp;
                        <input type="radio" name="gender" value="2">女性&nbsp;
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td">* 生年月日  </td>
                    <td width="500px" align="left" class="txtbox"  id="birth">
                        <select name="year" id="birth1">
                            <option value="2015">2015</option>
                            <option value="2014">2014</option>
                            <option value="2013">2013</option>
                            <option value="2012">2012</option>
                            <option value="2011">2011</option>
                            <option value="2010">2010</option>
                            <option value="2009">2009</option>
                            <option value="2008">2008</option>
                            <option value="2007">2007</option>
                            <option value="2006">2006</option>
                            <option value="2005">2005</option>
                            <option value="2004">2004</option>
                            <option value="2003">2003</option>
                            <option value="2002">2002</option>
                            <option value="2001">2001</option>
                            <option value="2000">2000</option>
                            <option value="1999">1999</option>
                            <option value="1998">1998</option>
                            <option value="1997">1997</option>
                            <option value="1996">1996</option>
                            <option value="1995">1995</option>
                            <option value="1994">1994</option>
                            <option value="1993">1993</option>
                            <option value="1992">1992</option>
                            <option value="1991">1991</option>
                            <option value="1990">1990</option>
                            <option value="1989">1989</option>
                            <option value="1988">1988</option>
                            <option value="1987">1987</option>
                            <option value="1986">1986</option>
                            <option value="1985">1985</option>
                            <option value="1984">1984</option>
                            <option value="1983">1983</option>
                            <option value="1982">1982</option>
                            <option value="1981">1981</option>
                            <option value="1980">1980</option>
                            <option value="1979">1979</option>
                            <option value="1978">1978</option>
                            <option value="1977">1977</option>
                            <option value="1976">1976</option>
                            <option value="1975">1975</option>
                            <option value="1974">1974</option>
                            <option value="1973">1973</option>
                            <option value="1972">1972</option>
                            <option value="1971">1971</option>
                            <option value="1970">1970</option>
                            <option value="1969">1969</option>
                            <option value="1968">1968</option>
                            <option value="1967">1967</option>
                            <option value="1966">1966</option>
                            <option value="1965">1965</option>
                            <option value="1964">1964</option>
                            <option value="1963">1963</option>
                            <option value="1962">1962</option>
                            <option value="1961">1961</option>
                            <option value="1960">1960</option>
                            <option value="1959">1959</option>
                            <option value="1958">1958</option>
                            <option value="1957">1957</option>
                            <option value="1956">1956</option>
                            <option value="1955">1955</option>
                            <option value="1954">1954</option>
                            <option value="1953">1953</option>
                            <option value="1952">1952</option>
                            <option value="1951">1951</option>
                            <option value="1950">1950</option>
                            <option value="1949">1949</option>
                            <option value="1948">1948</option>
                            <option value="1947">1947</option>
                            <option value="1946">1946</option>
                        </select>&nbsp;年&nbsp;
                        <select name="month" id="birth2" onchange="PrintDay();">
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
                        <select name="day" id="birth3">
                            <option value="01">01</option>
                        </select>&nbsp;日
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td">* 住所</td>
                    <td width="500px" align="left">
                        <input type="text" maxlength="255" name="address" id="address" class="txtbox" size="44">
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td">* メール  </td>
                    <td width="500px" align="left" class="txtbox">
                        <input type="text" name="femail" id="femail" size="13" maxlength="15" style="ime-mode:disabled" onkeyup="this.value=this.value.replace(/[^a-zA-z^0-9]/g,'')">&nbsp;@
                        <input type="text" name="lemail" id="lemail"readonly="readonly" size="16" maxlength="34"/>
                        <s:select list="emailList" id="email" name="email" listKey="%{code_no}" listValue="%{ssk_nm}" onchange="setEmailTail()"/>
                    </td>
                </tr>        
                <tr class="gcs">
                    <td class="td">&nbsp; &nbsp;電話番号 </td>
                    <td width="500px" align="left">
                        <input type="text" maxlength="12" name="tel" id="tel" class="txtbox" size="23" placeholder="ー除いて数字だけ入力してください" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" style="ime-mode:disabled">
                        <span id ="po">電話番号は数字だけで12桁までです。</span>
                    </td>              
                </tr>
                <tr>
                    <td height="33" class="title_size" colspan="2"><img src="img/join/join_title_leftline.png" /> 追加情報入力</td>
                </tr>
                <tr class="gcs">
                    <td class="td">&nbsp;&nbsp;カカオトークID  </td>
                    <td width="500px" align="left">
                        <input type="text" maxlength="20" name="kaid" id="kaid" class="txtbox" size="23" >
                        <span id="po">カカオトークIDは20桁までのです。</span>
                    </td>
                    </tr>
                <tr class="gcs">
                    <td class="td">&nbsp;&nbsp;備考</td>
                    <td width="500px" align="left">
                        <input type="text" maxlength="40" name="bigo" class="txtbox" size="50" placeholder="自己紹介を書いてください">
                        <span id="po1">備考は40桁までのです。</span>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table align="center" height="110">
                            <tr>
                                <td><input type="button" value="会員登録" onclick="signup()"></td>
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

