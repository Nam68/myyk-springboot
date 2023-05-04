<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@spring.message "error.page.title"/></title>
</head>
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@spring.message "error.page.message"/>
		</h1>
		<div class="primary-color-not-hover">
			<p><@spring.message "error.page.message"/> : ${errorMessage}</p>
		</div>
	</div>
</body>
<#include "/global/footer.ftlh">
</html>