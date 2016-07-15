<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>GCS Shared System</title>
    <link rel="stylesheet" href="css/main.css" />
	<style>
			#disableDiv {
            position: absolute;
            left: 0;
            top: 0;
            width: 1024px;
            height: 1000px;
            z-index: 995;
            background-color: #EEEEEE;
            filter: Alpha(opacity=80);
            opacity: 0.8;
            -moz-opaciry: 0.8;
        }
	</style>

    <script>
    function fnAlertMsg(titler, texter) {
        var posX, posY;
        posX = 300;
        posY = 300;

        oTitle.innerText = titler;
        oText.innerText = texter;
        divMsg.style.top = posY;
        divMsg.style.left = posX;
    }

    function fnCloseMsg() {
        var posX, posY;
        posX = -500;
        posY = -500;

        divMsg.style.display = "none";

        divMsg.style.top = posY;
        divMsg.style.left = posX;
        
        parent.location.replace('login');
        
    }
    
    function download() {
        main.location.href = "downloadList";
        mouseclick("hover2");
    }

    function home() {
        main.location.href = "home";
        mouseclick("hover1");
    }

    function member() {

        main.location.href = "memberList";
        mouseclick("hover3");

    }

    function board() {
    	main.location.href = "bbsList";
        mouseclick("hover4");
    }
    


    function mouseclick(id) {
        switch (id) {
            case "hover1":
                document.getElementById(id).style.backgroundPosition = '0 -32px';
                document.getElementById(id).style.border = "solid 1px white";
                document.getElementById("hover2").style.backgroundPosition = "0 0";
                document.getElementById("hover3").style.backgroundPosition = "0 0";
                document.getElementById("hover4").style.backgroundPosition = "0 0";
                document.getElementById("mainframe").style.height = "500px";
                break;
            case "hover2":
                document.getElementById("hover1").style.backgroundPosition = "0 0";
                document.getElementById(id).style.backgroundPosition = '0 -32px';
                document.getElementById(id).style.border = "solid 1px white";
                document.getElementById("hover3").style.backgroundPosition = "0 0";
                document.getElementById("hover4").style.backgroundPosition = "0 0";
                document.getElementById("mainframe").style.height = "740px";

                break;
            case "hover3":
                document.getElementById("hover1").style.backgroundPosition = "0 0";
                document.getElementById("hover2").style.backgroundPosition = "0 0";
                document.getElementById(id).style.backgroundPosition = '0 -32px';
                document.getElementById(id).style.border = "solid 1px white";
                document.getElementById("hover4").style.backgroundPosition = "0 0";
                document.getElementById("mainframe").style.height = "740px";
                break;

            case "hover4":
                document.getElementById("hover1").style.backgroundPosition = "0 0";
                document.getElementById("hover2").style.backgroundPosition = "0 0";
                document.getElementById("hover3").style.backgroundPosition = "0 0";
                document.getElementById(id).style.backgroundPosition = '0 -32px';
                document.getElementById(id).style.border = "solid 1px white";
                document.getElementById("mainframe").style.height = "740px";
                break;
        }
       
    }

    function disableActive() {
    	document.getElementById("disableDiv").style.width = screen.availWidth+"px";
    	document.getElementById("disableDiv").style.height = screen.availHeight+"px";
      	var  disableDivObj = document.getElementById("disableDiv");
      	var  divMsg = document.getElementById("divMsg");
        var msg = "";
        msg = " セッション時間の満了により、ログインページに移動します。";
        fnAlertMsg('[お知らせ]', msg);
      	 disableDivObj.style.display = "";
      	 divMsg.style.display = "";
      }
    
    
    
    var Minute; 
    var Second; 
    var timercheck = null;

    window.onload = function () {

        fncClearTime();
        initTimer(); 

    }
    Lpad = function (str, len) {

        str = str + "";

        while (str.length < len) {

            str = "0" + str;

        }

        return str;

    }
    initTimer = function () {

        reMinute = parseInt(Second / 60);
        reSecond = Second % 60;

        if (Second > 0) {

            timer.innerHTML = Lpad(reMinute, 2) + " : " + Lpad(reSecond, 2);
            Second--;
            timercheck = setTimeout("initTimer()", 1000); 

        } else {

            clearTimeout(timercheck);
            timer.innerHTML = "セッション満了";
            
            disableActive();//
        }

    }
    function fncClearTime() {

        Minute = 30;
        Second = Minute * 60;

    }
    </script>

</head>
<body>
	<% session.setMaxInactiveInterval(30*60); %>
　　
	<div id="disableDiv" class="disableDiv" style="display:none">
    </div>

 	 <div id="divMsg"
      style="display: none; position: relative; top: 320px; left: 45%; background: #ffffff; border: 1px solid #6699cc; width: 220px; height: 102px; font-family: verdana; font-size: 9pt; border: 1px solid black; color: black; z-index: 999;">
      <div id="oTitle" class="gradient"
         style="position: relative; width: 100%; height: 20px; color: black; font-weight: bold; font-size: 10pt;"></div>
      <div id="oText" style="padding: 5px"></div>
      <div id="oLink"
         style="font-weight: bold; color: #6699CC;">&nbsp;</div>
      <div id="oLinkStore" style="display: block; text-align: center;">
         <p onclick="fnCloseMsg()" class="mousePointer">OK</p>
      </div>
   	</div>
    <table border="0" cellpadding="0" cellspacing="0" width="1024" align="center" id="menu">
        <tr>
            <td></td>
            <td colspan="4" style="text-align:right;">
                <a href="MemberUpdate"><img src="img/main/info_update.jpg" class="mousePointer" /></a>
                <a href="memberListManager" target="main"><img src="img/main/managerbutton.jpg" class="mousePointer"/></a>
                <a href="UserIDAction" target="main"><img src="img/main/memberID.jpg" class="mousePointer"/></a>
                <a href="logout"><img src="img/main/logout.jpg" class="mousePointer"/></a>
            </td>
            <td></td>
        </tr>
        <tr style="margin-bottom:50px">
            <td></td>
            <td colspan="4" style="text-align: right; font-family: tahoma; font-size: 12px;">
            <img src="img/index/icon.gif" width="15" height="12" border="0"><font color="#848484">
            ${user_department}_${user_ccfname} ${user_cclname}(${user_rank})</font></td>
            <td></td>
        </tr>
        <tr>
         	<td></td>
            <td colspan="4" style="text-align: right; font-family: tahoma; font-size: 12px;"><img src="img/main/timer.png" width="11" height="11" border="0"> <b><span id="timer" style="color:#2c80ba"></span></b> </td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td colspan="4"><img src="img/main/title.jpg" /><img src="img/main/toon.jpg" width="400" /></td>
            <td></td>
        </tr>
        <tr style="height:32px;">
            <th width="128" class="gradient1"></th>
            <th width="192" id="hover1" onclick="home()"></th>
            <th width="192" id="hover2" onclick="download()"></th>
            <th width="192" id="hover3" onclick="member()"></th>
            <th width="192" id="hover4" onclick="board()"></th>
            <th width="128" class="gradient2"> </th>
        </tr>
        <tr>
            <td colspan="6">
                <center>
                    <iframe src="home" name="main" id="mainframe" frameborder="0" width="900" height="500" marginwidth="0" marginheight="0" scrolling="no"></iframe>
				                　<%if(session.getAttribute("id")==null){ %>
				      <script> 
				       disableActive();
				      </script> 
				　　　<%}%>
                </center>
            </td>
        </tr>
    </table>
    
    

</body>
</html>