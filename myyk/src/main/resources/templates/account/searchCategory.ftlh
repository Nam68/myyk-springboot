<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@spring.message "account.category.list.title"/></title>
</head>
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@spring.message "account.category.list.title"/>
		</h1>
		<div>
			<button class="btn btn-outline-primary add-category-btn">
				<i class="bi bi-file-earmark-plus"></i> add category
			</button>
		</div>
		<div>
			<#list list as category>
				
			</#list>
		</div>
	</div>
</body>
<#include "/global/footer.ftlh">
<script type="text/javascript">
$('.add-category-btn').on('click', function(e) {
	location.href = '/account/category/createInput';
});
</script>
</html>