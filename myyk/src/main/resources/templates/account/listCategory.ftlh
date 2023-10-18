<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@input "account.category.list.title"/></title>
</head>
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@input "account.category.list.title"/>
		</h1>
		<div class="text-start mt-3">
			<#list list as category>
				<div class="category-holder mb-5">
					<div style="color:${category.color}">
						<p>
							<i class="bi bi-${category.icon}"></i>
							&nbsp;${category.koCategoryName}
						</p>
						<ll>
							<#list category.subCategory as sub>
							<li class="ms-3">${sub.koCategoryName}</li>
							</#list>
							<li class="ms-3">
								<span class="create-sub-category-link" role="button" data-categoryIdx="${category.categoryIdx}" data-bs-toggle="modal" data-bs-target="#create-sub-category-modal">
									<i class="bi bi-plus-circle"></i> <@input "account.category.sub.create"/>
								</span>
							</li>
						</ll>
					</div>
				</div>
			</#list>
		</div>
		<div class="d-grid gap-2">
			<button class="btn btn-primary add-category-btn" data-idx="${idx}">
				<i class="bi bi-file-earmark-plus"></i> <@input "account.category.create.input.title"/>
			</button>
			<button id="list-category-back-btn" class="btn btn-outline-primary">
				<@input "alert.return"/>
			</button>
		</div>
	</div>
</body>
<#-- Sub Category Modal -->
<div class="modal fade" id="create-sub-category-modal" tabindex="-1" aria-labelledby="create-sub-category-modal" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="create-sub-category-label"><@input "account.category.sub.create"/></h1>
 				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body text-start">
				<#-- 카테고리 이름(접속언어) -->
				<div class="mb-4">
					<label class="form-label">
						<@input "account.category.create.input.name.${selected_language}"/>
					</label>
					<input class="form-control" name="${selected_language}CategoryName" required>
					<div class="invalid-feedback">
						<@input "account.category.create.error.name"/>
					</div>
				</div>
				<#-- 카테고리 이름(비접속언어) -->
				<div class="mb-4">
					<label class="form-label">
						<@input "account.category.create.input.name.${unselected_language}"/>
					</label>
					<div class="input-group mb-3">
						<button class="btn btn-primary" type="button" id="create-category-name-translate"><@input "alert.translate"/> <i class="bi bi-pencil-fill"></i></button>
						<input class="form-control" name="${unselected_language}CategoryName" required>
						<div class="invalid-feedback">
			       			<@input "account.category.create.error.name"/>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<input type="hidden" class="parent-category-idx">
				<button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"><@input "alert.close"/></button>
				<button type="button" class="btn btn-primary"><@input "alert.confirm"/></button>
			</div>
		</div>
	</div>
</div>
<#include "/global/footer.ftlh">
<script src="/js/categoryJs.js"></script> 
</html>