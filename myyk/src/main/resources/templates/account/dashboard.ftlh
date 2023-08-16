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

.dashboard-title {
	color:var(--primary-color-300);
	font-size: 1.25rem;
	margin-bottom: 0.25rem;
	
	border-left: 0.5rem solid var(--primary-color-200);
	padding-left: 0.75rem;
	
	text-align: left;
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
				<span class="load-account-book primary-dark-color" role="button">
					<p><i class="bi bi-journal-text"></i> <@if selected_language == 'ko' '${list.koBookName}' '${list.jpBookName}'/></p>
				</span>
				</#list>
				<span class="create-account-book primary-dark-color" role="button">
					<i class="bi bi-journal-plus"></i> <@spring.message "account.left.add"/>
				</span>
			</div>
		</div>
		<div class="account-pannel account-pannel-right shadow p-3 bg-body rounded">
			<div>
				<#if dto?exists>
				<input class="account-book-idx" type="hidden" value="${dto.accountBookIdx}">
				<div class="dashboard-top row ps-3 pe-3">
					<div class="dashboard-title col">
						<@if selected_language == 'ko' '${dto.koBookName}' '${dto.jpBookName}'/>
					</div>
					<div class="col text-end">
						<button class="btn btn-outline-primary search-category-btn">
							<i class="bi bi-file-earmark-text"></i> category list
						</button>
					</div>
				</div>
				<div class="mt-3">
					graph(no data)
				</div>
				<div class="mt-3">
					detail(no data)
				</div>
				<#else>
				<@spring.message "account.right.empty"/>
				</#if>
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

$('.create-account-book').on('click', function(e) {
	location.href='/account/createInput';
});

$('.search-category-btn').on('click', function(e) {
	location.href='/account/category/search?accountBookIdx=' + $('.accountBookIdx').val();
});
</script>
</html>