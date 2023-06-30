<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@spring.message "member.email.input"/></title>
</head>
<script src="/js/checkerJs.js"></script> 
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@spring.message "member.email.input"/>
		</h1>
		<form action="/member/emailCheckConfirm" method="post" class="g-3 needs-validation" novalidate>
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "member.attr.email"/>
				</label>
				<input type="text" class="form-control" name="email" required>
	      		<div class="invalid-feedback">
	        		<#--에러시 들어갈 내용-->
	      		</div>
	      		<#if errors?has_content && errors.email?has_content>
	      		<div class="alert alert-danger mt-2" role="alert">
					<@spring.message "error.member.create.email"/>
				</div>
				</#if>
			</div>
			<div class="pt-2 d-grid mx-auto">
				<button class="btn btn-primary" type="submit"><@spring.message "alert.confirm"/></button>
			</div>
		</form>
	</div>
</body>
<#include "/global/footer.ftlh">
<script type="text/javascript">
	$('.needs-validation').on('submit', function(e) {
	 
	 	openLoading();
		
		var email = $(this).find('input[name="email"]');
		
		if (email.val() == '') {
			$('.invalid-feedback').html('<@spring.message "member.email.error.empty"/>');
			email.addClass('is-invalid');
			email.removeClass('is-valid');
			
			e.preventDefault();
			e.stopPropagation();
			closeLoading();
			
			return;
		} else {
			$('.invalid-feedback').html('');
		}
		
		if (!email.val().includes('@')) {
			$('.invalid-feedback').html('<@spring.message "member.email.error.constraint"/>');
			email.addClass('is-invalid');
			email.removeClass('is-valid');
			
			e.preventDefault();
			e.stopPropagation();
			closeLoading();
			
			return;
		} else {
			$('.invalid-feedback').html('');
		} 
	});
</script>
</html>