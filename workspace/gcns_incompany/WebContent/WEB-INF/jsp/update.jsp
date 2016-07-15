<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>情報修正</title>
    <link rel="stylesheet" href="css/update.css" />
    <script>
	    function onload() {
			list_check();
			setEmailTail();
			PrintDay();
			chk();
			chk1();
			
	    }	    	    
	     
        function ok() {
            minlength = 6;
            var invalid = " ";
            var user_password  = document.getElementById("user_password");
            var user_password1  = document.getElementById("user_password1");
            var user_password2  = document.getElementById("user_password2");
            var ccfname = document.getElementById("ccfname");
            var cclname = document.getElementById("cclname");
            var katafname = document.getElementById("katafname");
            var katalname = document.getElementById("katalname");
            var address = document.getElementById("address");
            var email1 = document.getElementById("femail");
            var email2 = document.getElementById("lemail");
            if (user_password.value == "") {
                alert("パスワードを入力してください。");

            }else if (user_password.value.length < minlength) {
                alert("パスワードを6桁以上入力して下さい。");
            }else if (user_password.value.indexOf(invalid) > -1) {
            	alert("パスワードで空白があります");               
	        }else if(user_password1.value!=user_password2.value){
	        	alert("パスワードを入力してください");
	        }else if (ccfname.value == "") {
                alert("漢字の性を入力してください。");
            }else if (cclname.value == "") {
                alert("漢字の名を入力してください。");
            }else if (katafname.value == "") {
                alert("カタカナの性を入力してください。");
            }else if (katalname.value == "") {
                alert("カタカナの名を入力してください。");
            }else if (address.value == "") {
                alert("住所を入力してください。");
            }else if (email1.value == "") {
	            alert("メールを入力してください。");
	        }else if (email1.value.length < 4) {
	            alert("メールをを4桁以上入力して下さい。");
	        }else if (email1.value.indexOf(invalid) > -1) {
	        	alert("メールで空白があります。");
	        }else if (email2.value == ""){
	        	alert("メールを入力してください。");
	        }else if (email2.value.length < 4) {
	             alert("メールをを4桁以上入力して下さい。");
	        }else if (email2.value.indexOf(invalid) > -1){
	         	alert("メールで空白があります。");
	        }else{
	        	var theform=document.getElementById("theform");
	    		theform.action = "MemberUpdateAccess";
	    		theform.submit();	        	
	    	}
        }
        function back() {
            location.href = "<s:url value='/main.action'/>";
          
        }
        function PrintDay() {
        	var day = "";
        	var monarr = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
            var month = Number("${month}");
            for (var i = 1; i <= monarr[month - 1] ; i++) {
                if (i < 10) 
                { day = "0" + i; }
                day = i;
                value = day;
                text = day;
                optDay = new Option(value, text);
                document.theform.day.options[document.theform.day.length] = optDay;
        	}
            document.theform.day.selectedIndex = 0;

        }
        function getDayofMonth() {
            var monarr = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
            var year = document.theform.year.options[document.theform.year.selectedIndex].value;
            var month = Number("${month}");
            if (month.substring(0, 1) == '0') {
                month = month.substring(1, 2);

            }
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) monarr[1] = "29";
            return monarr[month - 1];

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
            var user_password1 = document.getElementById("user_password1").value;
            var user_password2 = document.getElementById("user_password2").value;


            if (user_password1.length == 0 || user_password2 == null) {
                document.theform.chk.value = "パスワードを入力してください。";
                right = 0;
            } else if (user_password1 != user_password2) {
                document.theform.chk.value = "パスワードが違います。";
                alert("パスワードをもう一度確認してください。");
                right = 0;
            } else {
                document.theform.chk.value = "パスワードが同じになります。";
                right = 1;
            }
            return;
        }
        
        function list_check() {   
        	
    		if("<s:property value='departmentList.USER_DEPARTMENT'/>"=="GCNS1部"){
    			document.theform.department.value="1";
    		}else if("<s:property value='departmentList.CodeTBLBean.USER_DEPARTMENT'/>"=="GCNS2部"){
    			document.theform.department.value="2";
    		}else if("<s:property value='departmentList.CodeTBLBean.USER_DEPARTMENT'/>"=="NUVO1部"){
    			document.theform.department.value="3";
    		}else if("<s:property value='departmentList.CodeTBLBean.USER_DEPARTMENT'/>"=="NUVO2部"){
    			document.theform.department.value="4";
    		}else if("<s:property value='departmentList.CodeTBLBean.USER_DEPARTMENT'/>"=="PSS総括"){
    			document.theform.department.value="5";
    		}
    		if("<s:property value='departmentList.CodeTBLBean.USER_RANK'/>"=="EMP"){
    			document.theform.rank.value="1";
    		}else if("<s:property value='departmentList.CodeTBLBean.USER_RANK'/>"=="LD"){
    			document.theform.rank.value="2";
    		}else if("<s:property value='departmentList.CodeTBLBean.USER_RANK'/>"=="AMG"){
    			document.theform.rank.value="3";
    		}else if("<s:property value='departmentList.CodeTBLBean.USER_RANK'/>"=="MG"){
    			document.theform.rank.value='4';
    		}else if("<s:property value='departmentList.CodeTBLBean.USER_RANK'/>"=="AGM"){
    			document.theform.rank.value="5";
    		}else if("<s:property value='departmentList.CodeTBLBean.USER_RANK'/>"=="GM"){
    			document.theform.rank.value="6";
    		}else if("<s:property value='departmentList.CodeTBLBean.USER_RANK'/>"=="MAST"){
    			document.theform.rank.value="7";
    		}
    	}
        function chk(){        	
        	var gen = ${gender};
        	if(gen == "1"){
        		document.getElementById("gender1").checked=true;
        	}else if(gen == "2"){
        		document.getElementById("gender2").checked=true;        		
        	}
        }
        function chk1(){
        	var year = ${year};
        	var i;
        	for(i=1946; i<2016; i++){
        		if(year==i){
            	document.getElementById("year").value=i;
            	i.selected=true;
        		}
        	}
        	var month = ${month};
        	var j;
        	for(j=1; j<13; j++){
        		if(month==j){
        			if(j<10){
		        		document.getElementById("month").value="0"+j;
		        		j.selected=true;
        			}else{
        				document.getElementById("month").value= j;
		        		j.selected=true;
        			}
        		}
        	}
        	var day = ${day};
        	var k;
        	for(k=1; k<32; k++){
        		if(day==k){
        			if(k<10){
		                document.getElementById("day").value= k;
		                k.selected=true;
        			}else{
        				document.getElementById("day").value = k;
		                k.selected=true;
        			}
        		}
        	}

        }
    </script>

</head>
<body onload="onload()">

    <center>
        <table border="0" cellpadding="0" cellspacing="0" width="1024" id="join">
            <tr>
                <td colspan="3" height="45"><img src="img/join/join_logo.png" /></td>
            </tr>
            <tr>
                <td class="title1">情報修正</td>
            </tr>
            <tr>
                <td height="40">* 修正してください。</td>
            </tr>
        </table>
<%--         <s:form method="post"  name="theform" onsubmit="ok()" action="MemberUpdateAccess" autocomplete="off" theme="simple"> --%>
        <s:form id="theform" method="post"  name="theform" action="" onsubmit="ok()" autocomplete="off" theme="simple">
            <table border="0" cellpadding="0" cellspacing="0" width="1004" id="update1" align="center">
                <tr>
                    <td height="34" class="title_size" colspan="2"><img src="img/join/join_title_leftline.png" /> 会社情報入力</td>
                </tr>
                <tr class="gcs">
                    <td width="350" class="td" >　* 社員番号  </td>
                    <td align="left" class="txtbox">
                        <input type="text" maxlength="8" name="uid" id="uid" size="22" value="<%=session.getAttribute("id")%>" disabled>
                    </td>
                </tr>
             
                <tr class="gcs">
                    <td class="td">　* パスワード </td>
                    <td>
                        <input type="password" maxlength="16" name="user_password"  id="user_password" class="txtbox" size="23"/>
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td"> &nbsp; &nbsp;* 新しいパスワード　</td>
                    <td>  
                        <input type="password" maxlength="16" name="user_password1" id="user_password1" class="txtbox" size="23" />
                        <span id="po">パスワードは6~16桁までです。</span>             
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td"> &nbsp; &nbsp;* パスワード確認　</td>
                    <td>
                        <input type="password" maxlength="16" name="user_password2" id="user_password2" class="txtbox" size="23" onblur="pwdchk()">
                        <input type="text" style="border-width:0px" size="20" name="chk" id="chk" value="パスワードを入力してください。" readonly="readonly" />
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td"> &nbsp; &nbsp;* 職級  </td>
                    <td class="txtbox">
                      <s:select list="rankList" id="rank" name="rank" listKey="%{code_no}" listValue="%{ssk_nm}"/>
                     </td>
                </tr>
                <tr class="gcs">
                    <td class="td">&nbsp; &nbsp;* 部署  </td>
                    <td class="txtbox">
                      <s:select list="departmentList" id="department" name="department" listKey="%{code_no}" listValue="%{ssk_nm}"/>
                   </td>
                </tr>
                <tr>
                    <td height="33" class="title_size" colspan="2"><img src="img/join/join_title_leftline.png" /> 個人情報入力</td>
<!--                 </tr> -->
<!--                 <tr class="gcs"> -->
<!--                     <td class="td"> &nbsp; &nbsp;* 名前  </td> -->
<!--                     <td width="500px" align="left" class="txtbox"> -->
<%--                         <input type="text" maxlength="30" name="namae" id="namae" size="22" value="${namae}"> --%>
<!--                     </td> -->
<!--                 </tr> -->
                <tr class="gcs">
                    <td class="td">&nbsp; &nbsp;* 名前 (漢字) </td>
                    <td width="500px" align="left">
                        <input type="text" maxlength="30" name="ccfname" id="ccfname" class="txtbox" size="10" placeholder="性" value="${ccfname }">
                        <input type="text" maxlength="30" name="cclname" id="cclname" class="txtbox" size="15" placeholder="名" value="${cclname }">
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td">&nbsp; &nbsp;* 名前 (カタカナ) </td>
                    <td width="500px" align="left">
                        <input type="text" maxlength="30" name="katafname" id="katafname" class="txtbox" size="10" placeholder="性" value="${katafname }">
                        <input type="text" maxlength="30" name="katalname" id="katalname" class="txtbox" size="15" placeholder="名" value="${katalname }">
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td">&nbsp; &nbsp;* 性別  </td>
                    <td align="left" class="txtbox">
                        <input type="radio" name="gender" id="gender1" value="1" >男性&nbsp;
                        <input type="radio" name="gender" id="gender2" value="2" >女性&nbsp;
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td"> &nbsp; &nbsp;* 生年月日  </td>
                    <td width="500px" align="left" class="txtbox" name="birth" id="birth">
                        <select name="year" id="year">                  
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
                        <select name="month" id="month">
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>&nbsp;月&nbsp;
                        <select name="day" id="day">
                        </select>&nbsp;日
                    </td>
                </tr>             
                <tr class="gcs">
                    <td class="td">&nbsp; &nbsp;* 住所 </td>
                    <td align="left">
                        <input type="text" maxlength="255" name="address" id="address" class="txtbox" size="44" value="${address}">
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td"> 　* メール  </td>
                    <td width="500px" align="left" class="txtbox">
                        <input type="text" name="femail" id="femail" size="13" maxlength="15" value="${femail}" style="ime-mode:disabled" onkeyup="this.value=this.value.replace(/[^a-zA-z^0-9]/g,'')">&nbsp;@
                        <input type="text" name="lemail" id="lemail" readonly="readonly" size="16"/>
                        <s:select list="emailList" id="email" name="email" listKey="%{code_no}" listValue="%{ssk_nm}" onchange="setEmailTail()"/>
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td"> &nbsp; &nbsp;電話番号 </td>
                    <td align="left">
                        <input type="text" maxlength="12" name="tel" id="tel" class="txtbox" size="22" value="${tel}"placeholder="ー除いて数字だけ入力してください" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" style="ime-mode:disabled">
                        <span id="po">電話番号は数字だけで12桁までです。</span>
                    </td>
                </tr>
                <tr>
                    <td height="33" class="title_size" colspan="2"><img src="img/join/join_title_leftline.png" /> 追加情報入力</td>
                </tr>
                <tr class="gcs">
                    <td class="td"> &nbsp; &nbsp;カカオトークID  </td>
                    <td align="left">
                        <input type="text" maxlength="20" name="kaid" id="kaid" class="txtbox" size="22" value="${kaid}">
                        <span id="po">カカオトークIDは20桁までのです。</span>
                    </td>
                </tr>
                <tr class="gcs">
                    <td class="td">&nbsp; &nbsp;備考</td>
                    <td width="500px" align="left">
                        <input type="text" maxlength="40" name="bigo" id="bigo" class="txtbox" size="52" value="${bigo}">
                        <span id="po1">備考は40桁までのです。</span>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table align="center" height="110">
                            <tr>
                                <td><input type="button" onclick="ok()" value="情報修正" />&nbsp;&nbsp;</td>
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