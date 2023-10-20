<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@input "account.category.create.input.title"/></title>
<style>
.category-icon-dropdown-item  i{
	font-size: 1.8rem;
}
</style>
</head>
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@input "account.category.create.input.title"/>
		</h1>
		<form action="/account/category/createPrimeCategory" method="post" class="g-3 needs-validation" novalidate>
			<input type="hidden" name="accountBookIdx" value="${idx}">
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
			<#-- 아이콘 선택 -->
			<div class="mb-4">
				<label class="form-label">
					<@input "account.category.create.input.icon.title"/>
				</label>
				<#-- 아이콘 메뉴 시작 -->
				<div class="dropdown category-icon-dropdown">
					<a class="category-icon-dropdown-item btn btn-outline-primary dropdown-toggle text-start" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<i id="category-icon-holder"> - </i>
					</a>
					<ul class="dropdown-menu category-icon-dropdown-item">
						<li>
							<a class="dropdown-item primary-color" role="button">
								<i class="bi bi-pencil-fill" data-icon="pencil-fill"></i> pencil-fill
							</a>
						</li>
						<li>
							<a class="dropdown-item primary-color" role="button">
								<i class="bi bi-airplane-engines" data-icon="airplane-engines"></i> airplane-engines
							</a>
						</li>
						<li>
							<a class="dropdown-item primary-color" role="button">
								<i class="bi bi-android2" data-icon="android2"></i> android2
							</a>
						</li>
						<li>
							<a class="dropdown-item primary-color" role="button">
								<i class="bi bi-apple" data-icon="apple"></i> apple
							</a>
						</li>
					</ul>
				</div>	
				<#-- 아이콘 메뉴 끝 -->
				<a class="btn btn-outline-primary mt-3 mb-2" data-bs-toggle="collapse" href="#icon-collapse" role="button" aria-expanded="false" aria-controls="icon-collapse">
					<@input "account.category.create.input.icon.input"/>
				</a>
				<div class="collapse" id="icon-collapse">
					<div class="card card-body">
						<label class="form-label">
							<@input "account.category.create.input.icon.explain.title"/> <i id="category-icon-question" class="bi bi-question-circle" role="button"></i>
						</label>
						<input class="form-control mb-2" type="text" name="icon" required>
						<button id="icon-input-button" class="btn btn-primary" type="button"><@input "alert.confirm"/></button>
					</div>
				</div>
				<input type="hidden" class="invalid-for-icon-select">
				<div class="invalid-feedback">
					<@input "account.category.create.error.icon"/>
				</div>
			</div>
			<#-- 컬러피커 -->
			<div class="mb-4">
				<label class="form-label">
					<@input "account.category.create.input.color"/>
				</label>
				<div>
					<input id="category-color-picker" name="color" value="#ea9999" class="form-control" role="button" required>
					<input type="hidden" class="invalid-for-color-picker">
					<div class="invalid-feedback">
						<@input "account.category.create.error.color"/>
					</div>
				</div>
			</div>
			<#-- 확인버튼 -->
			<div class="pt-2 d-grid mx-auto gap-2">
				<button class="btn btn-primary submit-button" type="submit"><@input "alert.confirm"/></button>
				<button class="btn btn-outline-primary returnCategoryList" onclick="return false;"><@input "alert.return"/></button>
			</div>
		</form>
	</div>
</body>
<#include "/global/footer.ftlh">
<script src="/js/categoryJs.js"></script> 
</html>