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

.sub-category-holder {
	display: none;
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
					<p><i class="bi bi-journal-text"></i> <@if selected_language=='ko' '${list.koBookName}' '${list.jpBookName}'/></p>
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
				<div class="dashboard-top row ps-3 pe-3">
					<div class="dashboard-title col">
						<@if selected_language == 'ko' '${dto.koBookName}' '${dto.jpBookName}'/>
					</div>
					<div class="col text-end">
						<button class="btn btn-outline-primary list-category-btn" data-idx="${dto.accountBookIdx}">
							<i class="bi bi-file-earmark-text"></i> <@spring.message "account.category.edit"/>
						</button>
					</div>
				</div>
				<div class="mt-3">
					graph(no data)
				</div>
				<div class="mt-3">
					detail(no data)
				</div>
				<hr>
				<div class="d-grid gap-2 mt-2">
					<button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#add-account-modal">
						<i class="bi bi-cart-plus-fill"></i> Add Account
					</button>
					<button class="btn btn-outline-primary" type="button">Edit Account</button>
				</div>
				<#else>
				<@spring.message "account.right.empty"/>
				</#if>
			</div>
		</div>
	</div>
</body>
<#-- Add Account Modal -->
<div class="modal fade" id="add-account-modal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="add-account-modal" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="add-account-label">Modal title</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body text-start">
				<#-- 카테고리 셀렉트 -->
				<div class="mb-4 prime-category-holder">
					<label class="form-label">
						<@spring.message "account.category.title"/>
					</label>
					<select class="form-select">
						<option value=""><@spring.message "account.category.select"/></option>
						<#list dto.categoryList as category>
						<option value="${category.categoryIdx}">
							<@if selected_language=='ko' '${category.koCategoryName}' '${category.jpCategoryName}'/>
						</option>
						</#list>
					</select>
				</div>
				<#-- 2차 카테고리 셀렉트 -->
				<div class="mb-4 sub-category-holder">
					<label class="form-label">
						<@spring.message "account.category.sub.title"/>
					</label>
					<select class="form-select" name="sub-category-select">
						<option value="">-</option> <#-- 서브카테고리는 선택하지 않는 경우도 -->
					</select>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>
<#include "/global/footer.ftlh">
<script type="text/javascript">
$(document).ready(function() {
	if (!isMobile()) {
		<#-- pc면 가계부 일람을 왼쪽으로 이동시킨다 --> 
		$('.account-pannel-left').addClass('text-start');
		$('.account-pannel-left').addClass('col-4');
		$('.account-pannel-right').addClass('col');
	}
});

$('.create-account-book').on('click', function(e) {
	location.href='/account/createInput';
});

$('.list-category-btn').on('click', function(e) {
	location.href='/account/category/list?accountBookIdx=' + $(this).data('idx');
});

<#-- 회계 등록 카테고리 선택 -->
$('.prime-category-holder').find('select').on('change', function (e) {
	alert('hi');
	alert($(this).val());
});
</script>
</html>