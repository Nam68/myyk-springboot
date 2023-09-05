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
		<div class="text-start">
			<button class="btn btn-outline-primary add-category-btn" data-idx="${idx}">
				<i class="bi bi-file-earmark-plus"></i> <@spring.message "account.category.create.input.title"/>
			</button>
		</div>
		<div class="text-start mt-3">
			<#list list as category>
				<div class="category-holder">
					<div style="color:${category.color}">
						<p>
							<i class="bi bi-${category.icon}"></i>
							&nbsp;${category.koCategoryName}
						</p>
						<#list category.subCategory as sub>
						<p>
							&nbsp;&nbsp;&nbsp;${sub.koCategoryName}
						</p>
						</#list>
					</div>
				</div>
			</#list>
		</div>
	</div>
</body>
<#include "/global/footer.ftlh">
<script type="text/javascript">
$('.add-category-btn').on('click', function(e) {
	location.href = '/account/category/createInput?accountBookIdx=' + $(this).data('idx');
});
</script>
</html>