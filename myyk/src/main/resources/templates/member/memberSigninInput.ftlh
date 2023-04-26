<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title>Sample</title>
</head>
<#include "/js/checkerJs.js"> 
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<s:message code="member.create.title"/>
		</h1>
		<form class="g-3 needs-validation" novalidate>
			<!-- 이메일 -->
			<div class="mb-4">
				<label class="form-label">
					<s:message code="member.attr.email"/>
				</label>
				<input type="text" class="form-control" name="email" required>
			</div>
			<!-- 비밀번호 -->
			<div class="mb-4">
				<label class="form-label">
					<s:message code="member.password"/>
				</label>
				<input id="create-member-password" type="password" class="form-control" name="password" required>
				<div class="invalid-feedback password-length">
	        		<!--에러시 들어갈 내용-->
	        		<!-- <s:message code="error.member.create.password.length"/> -->
	      		</div>
	      		<div class="invalid-feedback password-letter">
	        		<!--에러시 들어갈 내용-->
	        		<!-- <s:message code="error.member.create.password.letter"/> -->
	      		</div>
			</div>
			<!-- 비밀번호 확인 -->
			<div class="mb-4">
				<label class="form-label">
					<s:message code="member.passwordCheck"/>
				</label>
				<input id="create-member-password-check" type="password" class="form-control" name="password-check" required>
				<div class="invalid-feedback">
	        		<s:message code="error.member.create.password.check"/>
	      		</div>
			</div>
			<!-- 닉네임 -->
			<div class="mb-4">
				<label class="form-label">
					<s:message code="member.nickname"/>
				</label>
				<input type="text" class="form-control" name="nickname" required>
				<div class="invalid-feedback">
					<s:message code="error.member.create.nickname.length"/>
	      		</div>
			</div>
			<!-- 지역 -->
			<div class="mb-4">
				<label class="form-label">
					<s:message code="member.region"/>
				</label>
				<select class="form-select" required>
					<c:forEach items="${enums.region }" var="r" varStatus="status">
					<option value="r.name" <c:if test="${status.index == 0}">selected="selected"</c:if>><s:message code="enum.region.${r.value}"/></option>
					</c:forEach>
				</select>
			</div>
			<!-- 버튼 -->
			<div class="pt-2 d-grid mx-auto">
				<button class="btn btn-primary submit-button" type="submit"><s:message code="message.ok"/></button>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$('input[name=password]').on('keyup', function(e) {
		var val = $(this).val();
		
		var length = lengthChecker(val, 8, 20);
		var letter = allLetterChecker(val);
		
		if (!length) {
			$('.password-length').html('<s:message code="error.member.create.password.length"/>');
			$(this).addClass('is-invalid');
			$(this).removeClass('is-valid');
		} else {
			$('.password-length').html('');
		}
		if (!letter) {
			$('.password-letter').html('<s:message code="error.member.create.password.letter"/>');
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