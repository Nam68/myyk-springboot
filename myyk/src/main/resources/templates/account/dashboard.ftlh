<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@input "account.dashboard.title"/></title>
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
		<@input "account.dashboard.title"/>
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
					<i class="bi bi-journal-plus"></i> <@input "account.left.add"/>
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
							<i class="bi bi-file-earmark-text"></i> <@input "account.category.edit"/>
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
						<i class="bi bi-cart-plus-fill"></i> <@input "account.add"/>
					</button>
					<button class="btn btn-outline-primary" type="button"><@input "account.edit"/></button>
				</div>
				<#else>
				<@input "account.right.empty"/>
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
				<h1 class="modal-title form-label fs-5" id="add-account-label"><@input "account.add"/></h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body text-start">
				<#-- 카테고리 셀렉트 -->
				<div class="mb-4 prime-category-holder">
					<label class="form-label">
						<@input "account.category.title"/>
					</label>
					<select class="form-select" name="category" required>
						<option value=""><@input "account.category.select"/></option>
						<#list dto.categoryList as category>
						<option value="${category.categoryIdx}">
							<@setLanguage selected_language '${category.koCategoryName}' '${category.jpCategoryName}'/>
						</option>
						</#list>
					</select>
				</div>
				<#-- 2차 카테고리 셀렉트 -->
				<div class="mb-4 sub-category-holder">
					<label class="form-label">
						<@input "account.category.sub.title"/>
					</label>
					<select class="form-select" name="subCategory">
						<option value="">-</option> <#-- 서브카테고리는 선택하지 않는 경우도 -->
					</select>
				</div>
				<#-- 가격 입력 -->
				<div class="mb-4 account-holder">
					<label class="form-label">
						<@input "account.price.title"/>
					</label>
					<input class="form-control mb-2" name="price" required>
					<div class="invalid-feedback">
						<@input "account.category.create.error.name"/>
					</div>
				</div>
				<#-- 세금 설정 -->
				<div class="tax-holder">
					<#-- 세금포함/미포함 라디오박스 -->
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" id="tax-non-added" name="taxRadio" checked>
						<label class="form-check-label form-label" for="tax-non-added">
							<@input "account.tax.nonAdded"/>
						</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" id="tax-added" name="taxRadio">
						<label class="form-check-label form-label" for="tax-added">
							<@input "account.tax.added"/>
					  	</label>
					</div>
					<#-- 몇 퍼센트인지 -->
					<div class="collapse" id="tax-collapse">
					  <div class="">
					    <select class="form-select" name="taxRate">
					    	<#list rate as r >
					    	<option value="${r.rate}">${r.value}</option>
					    	</#list>
					    </select>
					  </div>
					</div>
				</div>
				<#-- 메모 -->
				<div class="mt-3 account-memo-holder">
					<label class="form-label">
						<@input "account.price.memo"/>
					</label>
					<input class="form-control mb-2" name="memo">
					<div class="invalid-feedback">
						<@input "account.category.create.error.name"/>
					</div>
				</div>
			</div>
			<div class="d-grid gap-2 p-3">
				<button type="button" class="btn btn-primary confirm"><@input "alert.confirm"/></button>
				<button type="button" class="btn btn-outline-primary" data-bs-dismiss="modal"><@input"alert.close"/></button>
			</div>
		</div>
	</div>
</div>
<#include "/global/footer.ftlh">
<#include "/constant/accountBookConst.ftlh">
<script src="/js/accountBookJs.js"></script> 
</html>