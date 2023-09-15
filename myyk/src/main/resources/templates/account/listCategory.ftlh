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
									<i class="bi bi-plus-circle"></i> <@spring.message "account.category.create.input.title"/>
								</span>
							</li>
						</ll>
					</div>
				</div>
			</#list>
		</div>
		<div class="text-start mt-2 mb-5">
			<button class="btn btn-outline-primary add-category-btn" data-idx="${idx}">
				<i class="bi bi-file-earmark-plus"></i> <@spring.message "account.category.create.input.title"/>
			</button>
			<button id="list-category-back-btn" class="btn btn-outline-secondary">
				<@spring.message "alert.close"/>
			</button>
		</div>
	</div>
</body>
<#-- Sub Category Modal -->
<div class="modal fade" id="create-sub-category-modal" tabindex="-1" aria-labelledby="create-sub-category-modal" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="create-sub-category-label"><@spring.message "account.category.sub.create"/></h1>
 				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body text-start">
				<#-- 카테고리 이름(접속언어) -->
				<div class="mb-4">
					<label class="form-label">
						<@spring.message "account.category.create.input.name.${selected_language}"/>
					</label>
					<input class="form-control" name="${selected_language}CategoryName" required>
					<div class="invalid-feedback">
						<@spring.message "account.category.create.error.name"/>
					</div>
				</div>
				<#-- 카테고리 이름(비접속언어) -->
				<div class="mb-4">
					<label class="form-label">
						<@spring.message "account.category.create.input.name.${unselected_language}"/>
					</label>
					<div class="input-group mb-3">
						<button class="btn btn-primary" type="button" id="create-category-name-translate"><@spring.message "alert.translate"/> <i class="bi bi-pencil-fill"></i></button>
						<input class="form-control" name="${unselected_language}CategoryName" required>
						<div class="invalid-feedback">
			       			<@spring.message "account.category.create.error.name"/>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<input type="hidden" class="parent-category-idx">
				<button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"><@spring.message "alert.close"/></button>
				<button type="button" class="btn btn-primary"><@spring.message "alert.confirm"/></button>
			</div>
		</div>
	</div>
</div>
<#include "/global/footer.ftlh">
<script type="text/javascript">
// 카테고리 생성 버튼 클릭
$('.add-category-btn').on('click', function(e) {
	location.href = '/account/category/createInput?accountBookIdx=' + $(this).data('idx');
});

// 서브 카테고리 생성 링크 클릭
$('.create-sub-category-link').on('click', function(e) {
	var parentCategoryIdx = $(this).attr('data-categoryIdx');
	$('.parent-category-idx').val(parentCategoryIdx);
});

// 서브 모달 확인버튼
$('#create-sub-category-modal').find('.modal-footer').find('.btn-primary').on('click', function(e) {

	var koCategoryName = $('input[name="koCategoryName"]').val();
	var jpCategoryName = $('input[name="jpCategoryName"]').val();
	var accountBookIdx = $('.add-category-btn').data('idx');
	var parentCategoryIdx = $('.parent-category-idx').val();

	$.ajax({
		url:'/account/category/createSubCategory',
		method:'POST',
		data:{
			koCategoryName: koCategoryName,
			jpCategoryName: jpCategoryName,
			accountBookIdx: accountBookIdx,
			parentCategoryIdx: parentCategoryIdx
		}
	})
	.done(function(data) {
	   	
		closeLoading();
	   		
		if (isValid(data)) {
			alert('good');
		} else {
			alert('bad');
		}
	})
	.fail(function(data) {
		closeLoading();
		window.alert('<@spring.message "error.ajax"/>');
	});
});

// 번역
$('#create-category-name-translate').on('click', function(e) {
	alert('not ready...');
});

// 뒤로가기
$('#list-category-back-btn').on('click', function(e) {
	location.href = '/account/dashboard?accountBookIdx=' + $('.add-category-btn').data('idx');
});
</script>
</html>