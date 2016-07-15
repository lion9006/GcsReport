<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja" xmlns="http://www.w3.org/1999/xhtml">
<head>
 <link href='http://fonts.googleapis.com/css?family=Asap' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
    <style>
        body {
            background-color: #5b84b0;
        }

        h1 {
            font-family: 'Asap', sans-serif;
            color: white;
            text-align: center;
            margin-top: 20px;
            font-size: 60px;
            margin-bottom: 70px;
        }

        p{
            color: #5b84b0;
            font-family: 'Asap', sans-serif;
            font-size: 30px;
            text-align: center;
        }

        div {
            padding-top: 25px;
            margin: 0 auto;
            width: 800px;
            height: 200px;
            background-color: white;
            border-radius: 20px;
        }

        img{
            margin-top: 25px;
        }

        input {
            font-family: 'Asap', sans-serif;
            color: #44413c;
            width:100px;
        }

    </style>
</head>
<body>
    <h1>≫申し訳ございません。</h1>


    <p style="font-size: 45px; color:#fac32b;">404エラーFILE NOT FOUND</p>

    <div>
        <p>※ 指定されたファイルがありません。</p>
        <p>お手数ですが、「ログインページ」に戻ってください。</p>
        <center><input type="button" value="OK" onclick="location.href='logout'"style="background-color:#fac32b;"></center>
    </div>
    <center><img src="img/error/error.png" /></center>
</body>
</html>