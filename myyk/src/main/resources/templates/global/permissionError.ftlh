<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@input "error.page.title"/></title>
</head>
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@input "error.permission.message"/>
		</h1>
		<div class="primary-color-not-hover">
			<p><@input "member.type.${memberType}"/><@input "error.permission.${status}"/></p>
		</div>
	</div>
</body>
<#include "/global/footer.ftlh">
</html>