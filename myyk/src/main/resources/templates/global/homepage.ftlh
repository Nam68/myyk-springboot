<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
</head>
<#include "/global/header.ftlh"> 
<body>
<@spring.message "alert.confirm"/>
<a href="/not/exist/page">not exist page</a>
<br>
<a href="/sample/signin">signin page</a>
<br>
<a href="/member/emailCheckInput">email check</a>
<br>
<a href="/global/homepage?lang=ko">korean setting</a>
<br>
<a href="/global/homepage?lang=jp">japanese setting</a>
</body>
<#include "/global/footer.ftlh">
</html>