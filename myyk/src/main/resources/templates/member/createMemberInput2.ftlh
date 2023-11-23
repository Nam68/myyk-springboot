<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@input "member.create.input.title"/></title>
</head>
<script src="/js/checkerJs.js"></script> 
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@input "member.create.input.title"/>
		</h1>
		<form action="/member/createConfirm" method="post" class="g-3 needs-validation" novalidate>
			<#-- 이메일 -->
			<div class="mb-4">
				<label class="form-label">
					<@input "member.attr.email"/>
				</label>
				<input type="text" class="form-control" name="email" value="${email}" disabled>
				<input type="hidden" name="email" value="${email}">
			</div>
			<#-- 비밀번호 -->
			<div class="mb-4">
				<label class="form-label">
					<@input "member.attr.password"/>
				</label>
				<input id="create-member-password" type="password" class="form-control" name="password" required>
				<div class="invalid-feedback password-length">
	        		<#--에러시 들어갈 내용-->
	        		<#-- <@input "member.create.error.password.length"/> -->
	      		</div>
	      		<div class="invalid-feedback password-letter">
	        		<#--에러시 들어갈 내용-->
	        		<#-- <@input "member.create.error.password.letter"/> -->
	      		</div>
			</div>
			<#-- 비밀번호 확인 -->
			<div class="mb-4">
				<label class="form-label">
					<@input "member.attr.passwordCheck"/>
				</label>
				<input id="create-member-password-check" type="password" class="form-control" name="password-check" required>
				<div class="invalid-feedback">
	        		<@input "member.create.error.password.check"/>
	      		</div>
			</div>
			<#-- 닉네임 -->
			<div class="mb-4">
				<label class="form-label">
					<@input "member.attr.nickname"/>
				</label>
				<input type="text" class="form-control" name="nickname" required>
				<div class="invalid-feedback">
					<@input "member.create.error.nickname.length"/>
	      		</div>
	      		<#if errors?has_content && errors.nickname?has_content>
	      		<div class="alert alert-danger mt-2" role="alert">
					<@input "error.member.create.nickname"/>
				</div>
				</#if>
			</div>
			<#-- 지역 -->
			<div class="mb-4">
				<label class="form-label">
					<@input "member.attr.region"/>
				</label>
				<select class="form-select" name="region" required>
					<#list region as r>
					<option value="${r}"><@input "member.region.${r.value}"/></option>
					</#list>
				</select>
			</div>
			<#-- 버튼 -->
			<div class="pt-2 d-grid mx-auto">
				<button class="btn btn-primary submit-button" type="submit"><@input "alert.confirm"/></button>
			</div>
		</form>
	</div>
</body>
<#include "/global/footer.ftlh">
<script type="text/javascript">
	$('input[name=password]').on('keyup', function(e) {
		var val = $(this).val();
		
		var length = lengthChecker(val, 8, 20);
		var letter = allLetterChecker(val);
		
		if (!length) {
			$('.password-length').html('<@input "member.create.error.password.length"/>');
			$(this).addClass('is-invalid');
			$(this).removeClass('is-valid');
		} else {
			$('.password-length').html('');
		}
		if (!letter) {
			$('.password-letter').html('<@input "member.create.error.password.letter"/>');
			$(this).addClass('is-invalid');
			$(this).removeClass('is-valid');
		} else {
			$('.password-letter').html('');
		}
		if (length && letter) {
			$(this).removeClass('is-invalid');
			$(this).addClass('is-valid');
		}
		
		// 이 체크는 비밀번호 확인의 에러를 없앨 때 사용
		var checker = $('#create-member-password-check').val();
		if (val == checker) {
			$('#create-member-password-check').removeClass('is-invalid');
			$('#create-member-password-check').addClass('is-valid');
		} else if (checker.length > 0 && val != checker) {
			$('#create-member-password-check').addClass('is-invalid');
			$('#create-member-password-check').removeClass('is-valid');
		}
	});
	$('input[name=password-check]').on('keyup', function(e) {
		var val = $(this).val();
		var target = $('#create-member-password').val();
		var isValid = val == target;
		
		validate($(this), isValid);
	});
	$('input[name=nickname]').on('keyup', function(e) {
		var val = $(this).val();
		var length = lengthChecker(val, 1, 10);
		
		validate($(this), length);
	});
	
	// 에러가 있으면 서브밋 못하게
	$('.submit-button').on('click', function(e) {
		if ($('.invalid-feedback').html() != '') {
			e.preventDefault();
			e.stopPropagation();
		}
	});
</script>
</html>