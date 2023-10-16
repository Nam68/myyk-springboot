<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
</head>
<#include "/global/header.ftlh"> 
<body>
<@input "alert.confirm"/>
<a href="/not/exist/page">not exist page</a>
<br>
<a href="/sample/signin">signin page</a>
<br>
<a href="/member/emailCheckInput">email check</a>
<br>
<a href="/global/homepage?lang=ko">korean setting</a>
<br>
<a href="/global/homepage?lang=jp">japanese setting</a>
<br>
<a href="/email/sendCheckEmail">email send check</a>
<br>
<a href="/test/signupMailTest">sign up mail test</a>
</body>
<#include "/global/footer.ftlh">
</html>