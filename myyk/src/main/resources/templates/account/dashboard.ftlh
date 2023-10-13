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
					<select class="form-select" required>
						<option value=""><@spring.message "account.category.select"/></option>
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
						<@spring.message "account.category.sub.title"/>
					</label>
					<select class="form-select" name="sub-category-select">
						<option value="">-</option> <#-- 서브카테고리는 선택하지 않는 경우도 -->
					</select>
				</div>
				<#-- 가격 입력 -->
				<div class="mb-4 account-holder">
					<label class="form-label">
						<@spring.message "account.price.title"/>
					</label>
					<input class="form-control mb-2" name="" required>
					<div class="invalid-feedback">
						<@spring.message "account.category.create.error.name"/>
					</div>
				</div>
				<#-- 세금 설정 -->
					<#-- 몇 퍼센트인지 -->
				<div class="mb-4 tax-holder">
					<#-- 세금포함/미포함 라디오박스 -->
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" id="taxNonAdded" name="taxRadio" checked data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
						<label class="form-check-label form-label" for="taxNonAdded">
							<@spring.message "account.tax.nonAdded"/>
					  	</label>
					  	
					  	
					  	
					  	라디오는 다시 누르면 아코디언이 닫힘.
					  	라디오 체인지 등을 이용해야할듯.
					  	
					  	
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" id="taxAdded" name="taxRadio" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
						<label class="form-check-label form-label" for="taxAdded">
							<@spring.message "account.tax.added"/>
						</label>
					</div>				
				
				</div>
					
					
		      <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
		        Accordion Item #1
		      </button>
					
				<div class="accordion" id="accordionExample">
					<div class="accordion-item">
						<div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
							<div class="accordion-body">
								<strong>This is the first item's accordion body.</strong> It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
							</div>
						</div>
					</div>
					<div class="accordion-item">
						<div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
							<div class="accordion-body">
								<strong>This is the second item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
							</div>
						</div>
					</div>
				</div>					
					
					
					
					
					
					
					
					
					
					
					
					
					
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</div>
</div>
<#include "/global/footer.ftlh">
<#include "/constant/accountBookConst.ftlh">
<script src="/js/accountBookJs.js"></script> 
</html>