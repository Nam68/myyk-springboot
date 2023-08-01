<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@spring.message "account.dashboard.title"/></title>
<style>
.account-pannel {
	color: var(--primary-color-300);
}
</style>
</head>
<#include "/global/header.ftlh">
<body>
	<h1 class="title">
		<@spring.message "account.dashboard.title"/>
	</h1>
	<div class="row gap-2">
		<div class="account-pannel account-pannel-left shadow p-3 bg-body rounded">
			<div>
				<#list list as list>
				<span class="load-account-book primary-dark-color	" role="button">
					<p><i class="bi bi-journal-text"></i> 	<@if selected_language == 'ko' '${list.koBookName}' '${list.jpBookName}'/></p>
				</span>
				</#list>
				<span class="add-account-book primary-dark-color" role="button">
					<i class="bi bi-plus-circle"></i> <@spring.message "account.left.add"/>
				</span>
			</div>
		</div>
		<div class="account-pannel account-pannel-right shadow p-3 bg-body rounded">
			<div>
				<@spring.message "account.right.empty"/>
			</div>
		</div>
	</div>
</body>
<#include "/global/footer.ftlh">
<script type="text/javascript">
$(document).ready(function() {
	if (!isMobile()) {
		// pc면 가계부 일람을 왼쪽으로 이동시킨다 
		$('.account-pannel-left').addClass('text-start');
		$('.account-pannel-left').addClass('col-4');
		$('.account-pannel-right').addClass('col');
	}
});

$('.add-account-book').on('click', function(e) {
	location.href='/account/createInput';
});
</script>
</html>