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
<a href="/sample/signin.do">signin page</a>
<br>
<a href="/email/checkInput.do">email check</a>
<br>
<a href="/global/homepage?lang=ko">korean setting</a>
<br>
<a href="/global/homepage?lang=jp">japanese setting</a>
</body>
<#include "/global/footer.ftlh">
</html>