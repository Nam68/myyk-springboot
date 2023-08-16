<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@spring.message "account.dashboard.title"/></title>
<style>
.card {
	height: 8rem;
	overflow: scroll;
}
</style>
</head>
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@spring.message "account.create.input.title"/>
		</h1>
		<form action="/account/create" method="post" class="g-3 needs-validation" novalidate>
			<#-- 가계부 이름(접속언어) -->
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "account.create.input.name.${selected_language}"/>
				</label>
				<input id="create-book-name-${selected_language}" class="form-control" name="${selected_language}BookName" required>
				<div class="invalid-feedback">
		       		<@spring.message "account.create.error.name"/>
				</div>
			</div>
			<#-- 가계부 이름(비접속언어) -->
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "account.create.input.name.${unselected_language}"/>
				</label>
				<div class="input-group mb-3">
					<button class="btn btn-primary" type="button" id="create-book-name-translate"><@spring.message "alert.translate"/> <i class="bi bi-pencil-fill"></i></button>
					<input id="create-book-name-${unselected_language}" class="form-control" name="${unselected_language}BookName" required>
					<div class="invalid-feedback">
		       			<@spring.message "account.create.error.name"/>
					</div>
				</div>
			</div>
			<#-- 지역 선택 -->
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "account.create.input.region"/>
				</label>
				<select class="form-select" name="region">
					<#list region as r>
					<option value="${r}"><@spring.message "account.region.${r.value}.currency"/></option>
					</#list>
				</select>
			</div>
			<#-- 열람 권한 부여 -->
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "account.create.input.auth.watchable"/>
				</label>
				<div class="row align-items-center">
					<div class="col form-label">
						<div class="card card-body" id="member-for-watchable-auth">
							<#list list as m>
							<span data-idx="${m.memberIdx}" data-nickname="${m.nickname}">${m.nickname} <i class="bi bi-plus-lg" role="button" onClick="addWatchable(${m.memberIdx});" ></i></span>
							</#list>
						</div>
					</div>
					<div class="col-1 form-label text-center">
						<h2><i class="bi bi-caret-right-fill"></i></h2>
					</div>
					<div class="col form-label">
						<div class="card card-body" id="watchable-target">
							<#-- 회원이 입력됨 -->
						</div>
					</div>
				</div>
			</div>
			<#-- 편집 권한 부여 -->
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "account.create.input.auth.writable"/>
				</label>
				<label class="alert-form">
					※ <@spring.message "account.create.input.auth.writableCondition"/>
				</label>
				<div class="row align-items-center">
					<div class="col form-label">
						<div class="card card-body" id="member-for-writable-auth">
							<#-- 회원이 입력됨 -->
						</div>
					</div>
					<div class="col-1 form-label text-center">
						<h2><i class="bi bi-caret-right-fill"></i></h2>
					</div>
					<div class="col form-label">
						<div class="card card-body" id="writable-target">
							<#-- 회원이 입력됨 -->
						</div>
					</div>
				</div>
			</div>
			<#-- 버튼 -->
			<div class="pt-2 d-grid mx-auto gap-2">
				<button class="btn btn-primary submit-button" type="submit"><@spring.message "alert.confirm"/></button>
				<button class="btn btn-outline-primary submit-button"><@spring.message "alert.return"/></button>
			</div>
		</form>
	</div>
</body>
<#include "/global/footer.ftlh">
<script type="text/javascript">
// 권한창 세로
$(document).ready(function() {
	if (isMobile()) {
		$('h2').html('<i class="bi bi-caret-down-fill"></i>');
		$('.align-items-center').removeClass('row');
		$('.col-1').removeClass('col-1');
	}
});

// 번역
$('#create-book-name-translate').on('click', function(e) {
	alert('not ready...');
});

// 열람권한 추가
function addWatchable(idx) {
	
	var target = $('#member-for-watchable-auth').find('span[data-idx='+idx+']');
	var clone = $('#watchable-target').find('span[data-idx='+idx+']');
	
	if (typeof clone.html() == 'undefined') {

		// 권한쪽 카드에 만들어진 적이 없는 경우
		// 새롭게 html을 만들어준다

		$('#watchable-target').append('<span data-idx="' 
			+ idx + '">' 
			+ target.data('nickname') 
			+ ' <i class="bi bi-x-lg" role="button" onClick="deleteWatchable(' 
			+ idx + ');"></i></span>');
	
	} else {
	
		// 권한쪽 카드에 만들어졌다가 삭제된 경우
		// 기존 html의 display만 block으로 바꾸어준다
		
		clone.css('display', 'block');
	}
	
	// 그리고 멤버쪽에서는 사라짐
	target.css('display', 'none');
	
	// 편집권한을 부여 가능하도록 변경
	var writableMember = $('#member-for-writable-auth').find('span[data-idx='+idx+']');
	
	if (typeof writableMember.html() == 'undefined') {

		$('#member-for-writable-auth').append('<span data-idx="' 
			+ idx + '" data-nickname="' + target.data('nickname')  + '">' 
			+ target.data('nickname') 
			+ ' <i class="bi bi-plus-lg" role="button" onClick="addWritable(' 
			+ idx + ');"></i></span>');
	
	} else {
		writableMember.css('display', 'block');
	}
}
// 열람권한 제거
function deleteWatchable(idx) {

	var target = $('#watchable-target').find('span[data-idx='+idx+']');
	var clone = $('#member-for-watchable-auth').find('span[data-idx='+idx+']');
	
	target.css('display', 'none');
	clone.css('display', 'block');
	
	// 편집권한도 지워야함
	var writableMember = $('#member-for-writable-auth').find('span[data-idx='+idx+']');
	if (typeof writableMember.html() != 'undefined') {
		writableMember.css('display', 'none');
	}
	var writableTarget = $('#writable-target').find('span[data-idx='+idx+']');
	if (typeof writableTarget.html() != 'undefined') {
		writableTarget.css('display', 'none');
	}
}

// 편집권한 추가
function addWritable(idx) {
	
	var target = $('#member-for-writable-auth').find('span[data-idx='+idx+']');
	var clone = $('#writable-target').find('span[data-idx='+idx+']');
	
	if (typeof clone.html() == 'undefined') {

		// 권한쪽 카드에 만들어진 적이 없는 경우
		// 새롭게 html을 만들어준다

		$('#writable-target').append('<span data-idx="' 
			+ idx + '">' 
			+ target.data('nickname') 
			+ ' <i class="bi bi-x-lg" role="button" onClick="deleteWritable(' 
			+ idx + ');"></i></span>');
	
	} else {
	
		// 권한쪽 카드에 만들어졌다가 삭제된 경우
		// 기존 html의 display만 block으로 바꾸어준다
		
		clone.css('display', 'block');
	}
	
	// 그리고 멤버쪽에서는 사라짐
	target.css('display', 'none');
}
// 편집권한 제거
function deleteWritable(idx) {

	var target = $('#writable-target').find('span[data-idx='+idx+']');
	var clone = $('#member-for-writable-auth').find('span[data-idx='+idx+']');
	
	target.css('display', 'none');
	clone.css('display', 'block');
}

// 에러가 있으면 서브밋 못하게
$('.needs-validation').on('submit', function(e) {
	
	openLoading();

	if (!$(this)[0].checkValidity()) {
		e.preventDefault();
		e.stopPropagation();
		
		closeLoading();
		
		$(window).scrollTop(0);
	}
	$(this).addClass('was-validated');
	
	
	$('#watchable-target').find('span').each(function(index, item) {
		var targetIdx = item.dataset['idx'];
		var target = $('#watchable-target').find('span[data-idx=' + targetIdx + ']');
		if (target.css('display') == 'block') {
			$('#watchable-target').append('<input name="watchableIdx" type="hidden" value="' + targetIdx + '">');
		}
	});
	$('#writable-target').find('span').each(function(index, item) {
		var targetIdx = item.dataset['idx'];
		var target = $('#writable-target').find('span[data-idx=' + targetIdx + ']');
		if (target.css('display') == 'block') {
			$('#writable-target').append('<input name="writableIdx" type="hidden" value="' + targetIdx + '">');
		}
		
	});
});
</script>
</html>