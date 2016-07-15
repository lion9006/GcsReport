<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>LOGIN</title>
<link rel="stylesheet" href="css/index.css" />
<script>
   
   function init() {
         document.msCapsLockWarningOff = true;    
      if (getCookie("id")) { // getCookie함수로 id라는 이름의 쿠키를 불러와서 있을경우
          document.login_box.user_id.value = getCookie("id"); //input 이름이 id인곳에 getCookie("id")값을 넣어줌
          document.login_box.id_save.checked = true; // 체크는 체크됨으로
       }
     
   }


     function setCookie(name, value, expiredays) //쿠키 저장함수

     {
         var todayDate = new Date();
         todayDate.setDate(todayDate.getDate() + expiredays);
         document.cookie = name + "=" + escape(value) + "; path=/; expires="
                 + todayDate.toGMTString() + ";"
     }



     function getCookie(Name) { // 쿠키 불러오는 함수
         var search = Name + "=";
         if (document.cookie.length > 0) {
             offset = document.cookie.indexOf(search);
             if (offset != -1) { // 쿠키가 존재할 때 
                 offset += search.length; // set index of beginning of value
                 end = document.cookie.indexOf(";", offset); // set index of end of cookie value
                 if (end == -1)
                     end = document.cookie.length;
                 return unescape(document.cookie.substring(offset, end));
             }
         }
     }

 </script>


<script>
     //숫자만 입력 가능하도록 처리 하는 부분
     function digit_check(evt) {
         var msg = "";
         var code = evt.which ? evt.which : event.keyCode;
         if (code < 48 || code > 57) {
             msg = " IDは数字だけ入力可能です。";
             fnAlertMsg('[お知らせ]', msg);
             return false;
         }
     }
     // 아이디 전각문자입력 불가능
     function checkhalf() {
    	 var msg = "";
         var str = document.getElementById("user_id");
         chkstr = escape(str.value);
         if (chkstr.indexOf('%') != -1) {
        	 msg = " ID入力は「半角数字」でお願いします。";
             fnAlertMsg('[お知らせ]', msg);
             str.value = "";
             str.focus();
             return false;
         }
     }
     
     // 패스워드 전각문자입력 불가능
     function checkhalf2() {
    	 var msg = "";
         var str = document.getElementById("user_password");
         chkstr = escape(str.value);
         if (chkstr.indexOf('%') != -1) {
        	 msg = " パスワード入力は「半角英数字」でお願いします。";
             fnAlertMsg('[お知らせ]', msg);
             str.value = "";
             str.focus();
             return false;
         }
     }

     

     function check() {
         minlength = 6;
         maxlength = 8;
         var invalid = " ";

         var msg = "";
         if (document.getElementById('user_id').value == "") {
             msg = " IDを入力して下さい。";
             fnAlertMsg('[お知らせ]', msg);
             document.getElementById('user_id').focus();
             return false;
         }

         if (document.login_box.user_id.value.length < maxlength) {
             msg = " IDは８桁です。";
             fnAlertMsg('[お知らせ]', msg);
             return false;
         }

         if (document.getElementById('user_password').value == "") {
             msg = " パスワードを入力して下さい。";
             fnAlertMsg('[お知らせ]', msg);
             document.getElementById('user_password').focus();
             return false;
         }

         if (document.login_box.user_password.value.length < minlength) {
             msg = " パスワードを6桁以上入力して下さい。";
             fnAlertMsg('[お知らせ]', msg);
             return false;
         }
                
         if (document.login_box.id_save.checked == true) { // 아이디 저장을 체크 하였을때
             setCookie("id", document.login_box.user_id.value, 8); //8일동안 저장
             location.href = "loginAccess";
             return true;
         }

         else {
             setCookie("id", document.login_box.user_id.value, 0);
             location.href = "loginAccess";
             return true;
         }

     }

     function saveUse() {
        if (document.login_box.id_save.checked == true) {
             fnAlertMsg2();

         } else {
             document.login_box.id_save.checked = false;
         }      
     }
    
     function fnKeyPress(e) {
         var keyCode = 0;
         var shiftKey = false;
         keyCode = e.keyCode;
         shiftKey = e.shiftKey;

         if ((keyCode >= 65 && keyCode <= 90) && !shiftKey)
            document.getElementById('divMayus').style.visibility = 'visible';
         
         else
            document.getElementById('divMayus').style.visibility = 'hidden';
     }
     
     function fnKeyDown(e) {
         var keyCode  = 0;
         keyCode = e.keyCode;
         if (keyCode == 20)
            document.getElementById('divMayus').style.visibility = 'hidden';
     }

     function fnAlertMsg(titler, texter) {
         var posX, posY;
         posX = 300;
         posY = 300;

         oTitle.innerText = titler;
         oText.innerText = texter;
         divMsg.style.top = posY;
         divMsg.style.left = posX;

         document.getElementById('user_id').disabled = true;
         document.getElementById('user_password').disabled = true;
         document.getElementById('join').disabled = true;
         document.getElementById('id_search').disabled = true;
         document.getElementById('id_save').disabled = true;
         document.getElementById('login').disabled = true;
      

         divMsg.style.display = "block";

     }

     function fnCloseMsg() {
         var posX, posY;
         posX = -500;
         posY = -500;

         divMsg.style.display = "none";

         divMsg.style.top = posY;
         divMsg.style.left = posX;
         
         document.getElementById('user_id').disabled = false;
         document.getElementById('user_password').disabled = false;
         document.getElementById('join').disabled = false;
         document.getElementById('id_search').disabled = false;
         document.getElementById('id_save').disabled = false;
         document.getElementById('login').disabled = false;

     }
     
     function fnAlertMsg2() {
         var posX, posY;
         posX = 300;
         posY = 300;

         oTitle2.innerText = '[お知らせ]';
         oText2.innerText = "こちらのPCにログイン情報を保存なさいますか。公共場所では個人情報が流出されるので注意してください。";
         divMsg2.style.top = posY;
         divMsg2.style.left = posX;

         document.getElementById('user_id').disabled = true;
         document.getElementById('user_password').disabled = true;
         document.getElementById('join').disabled = true;
         document.getElementById('id_search').disabled = true;
         document.getElementById('id_save').disabled = true;
         document.getElementById('login').disabled = true;


         divMsg2.style.display = "block";

     }
     
     function fnOkMsg2() {
         var posX, posY;
         posX = -500;
         posY = -500;

         divMsg2.style.display = "none";

         divMsg2.style.top = posY;
         divMsg2.style.left = posX;

         document.getElementById('user_id').disabled = false;
         document.getElementById('user_password').disabled = false;
         document.getElementById('join').disabled = false;
         document.getElementById('id_search').disabled = false;
         document.getElementById('id_save').disabled = false;
         document.getElementById('login').disabled = false;
         document.login_box.id_save.checked == true;
     }
     
     function fnCloseMsg2() {
         var posX, posY;
         posX = -500;
         posY = -500;

         divMsg2.style.display = "none";

         divMsg2.style.top = posY;
         divMsg2.style.left = posX;

         document.getElementById('user_id').disabled = false;
         document.getElementById('user_password').disabled = false;
         document.getElementById('join').disabled = false;
         document.getElementById('id_search').disabled = false;
         document.getElementById('id_save').disabled = false;
         document.getElementById('login').disabled = false;
         document.login_box.id_save.checked = false;
     }

    </script>
</head>

<body onload="init()">

   <div id="wrap">
      <div class="wrap_logo">
         <img src="img/index/login_logo.png">
         <div>

            <div id="wrap_content">
               <div class="login_title">
                  <img src="img/index/tle_login.png">
               </div>
               <form name="login_box" method="POST"
                  onsubmit="javascript:return check()" action="loginAccess">
                  <span class="join"><a href="MemberJoin" id="join"> JOIN </a></span>
                  <span class="join"><a href="IdSearch" id="id_search">
                        ID検索 </a></span>
                  <div class="login_form">
                     <p style="margin-bottom: 5px;">
                        <img src="img/index/login_group.png" alt="사내계정 로그인">
                     </p>
                     <p class="login_box" style="margin-bottom: 8px;">
                        <input style="border: 0px;" type="text" id="user_id"
                           name="user_id" class="text_id" placeholder="8桁まで入力可能(半角数字)"
                           maxlength=8 onkeypress="return digit_check(event)"
                           onkeyup="checkhalf()">
                     </p>
                     <p class="login_box">
                        <input style="border: 0px;" type="password" id="user_password"
                           name="user_password" class="text_pwd"
                           onkeypress="javascript:fnKeyPress(event);" onkeydown="javascript:fnKeyDown(event);" 
                           onkeyup="checkhalf2();"
                           placeholder="6~16桁まで入力可能"
                           minlength=6 maxlength=16> <img
                           src="img/index/capslock.gif" id="divMayus"
                           style="visibility: hidden" />
                     </p>
                     <span> <input type="checkbox" id="id_save" name="id_save"
                        value="1" onclick="saveUse()" /> <b
                        style="color: #E0F2FF; font-family: tahoma; font-size: 11px";>
                           ID Save </b>
                     </span> <span class="login_button"> <label> <input
                           style="margin-left: 88px; margin-top: 10px;" type="image"
                           src="img/index/login.png" id="login">
                     </label>
                     </span>
                  </div>
               </form>
            </div>
            <div id="footer">
               <a href="#g4_head"><img src="img/index/icon.gif" width="15"
                  height="12" border="0"></a><font color="#848484">Copyright
                  ⓒ GCS Shared System All rights reserved.</font>
            </div>
         </div>
      </div>
   </div>

   <div id="divMsg"
      style="display: none; position: relative; top: -450px; left: 50%; background: #ffffff; border: 1px solid #6699cc; width: 220px; height: 102px; font-family: verdana; font-size: 9pt; border: 1px solid black; color: black; z-index: 3;">
      <div id="oTitle" class="gradient"
         style="position: relative; width: 100%; height: 20px; color: black; font-weight: bold; font-size: 10pt;"></div>
      <div id="oText" style="padding: 5px"></div>
      <div id="oLink"
         style="font-weight: bold; color: #6699CC; padding: 5px">&nbsp;</div>
      <div id="oLinkStore" style="display: block; text-align: center;">
         <p onclick="fnCloseMsg()" class="mousePointer">OK</p>
      </div>
   </div>
   <div id="divMsg2"
      style="display: none; position: relative; top: -450px; left: 50%; background: #ffffff; border: 1px solid #6699cc; width: 290px; height: 112px; font-family: verdana; font-size: 9pt; border: 1px solid black; color: black; z-index: 3;">
      <div id="oTitle2" class="gradient"
         style="position: relative; width: 100%; height: 20px; color: black; font-weight: bold; font-size: 10pt;"></div>
      <div id="oText2" style="padding: 5px"></div>
      <div id="oLink2"
         style="font-weight: bold; color: #6699CC; padding: 5px">&nbsp;</div>
      <div id="oLinkStore2" style="display: block; text-align: center;">
         <span onclick="fnOkMsg2()" class="mousePointer" style="width: 145px">OK</span>
         <span onclick="fnCloseMsg2()" class="mousePointer"
            style="width: 145px;">NO</span>
      </div>

   </div>
   <script type="text/javascript">

      var loginMessage = ${loginMessage};
         switch(loginMessage){
              case 1:
                    msg = " IDがありません。";
                    fnAlertMsg('[お知らせ]', msg);          
                    setCookie("id", document.login_box.user_id.value, 0);
                    document.login_box.id_save.checked = false;
                    document.getElementById('user_id').value="";  
               
                 break;
              case 2:
                    msg = " IDまたはパスワードが一致しません。";
                    fnAlertMsg('[お知らせ]', msg);             
                    setCookie("id", document.login_box.user_id.value, 0);
                    document.login_box.id_save.checked = false;
                    document.getElementById('user_id').value="";  
                    
                 break;
        }
           
   </script>
</body>
</html>