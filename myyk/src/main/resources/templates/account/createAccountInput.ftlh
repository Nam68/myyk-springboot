<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@spring.message "account.dashboard.title"/></title>
</head>
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@spring.message "account.create.input.title"/>
		</h1>
		<form action="/member/createConfirm" method="post" class="g-3 needs-validation" novalidate>
			<#-- 가계부 이름(한국어) -->
			<div class="input-group mb-3">
				<button class="btn btn-primary" type="button" id="button-addon1">Button</button>
				<input type="text" class="form-control" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
			</div>
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "account.create.input.name.ko"/>
				</label>
				<input id="create-member-password-check" type="password" class="form-control" name="password-check" required>
				<div class="invalid-feedback">
		       		<@spring.message "member.create.error.password.check"/>
				</div>
			</div>
			<#-- 가계부 이름(일본어) -->
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "account.create.input.name.jp"/>
				</label>
				<input id="create-member-password-check" type="password" class="form-control" name="password-check" required>
				<div class="invalid-feedback">
		       		<@spring.message "member.create.error.password.check"/>
				</div>
			</div>
		</form>
	</div>
</body>
<#include "/global/footer.ftlh">
<script type="text/javascript">

// 에러가 있으면 서브밋 못하게
$('.submit-button').on('click', function(e) {
	if ($('.invalid-feedback').html() != '') {
		e.preventDefault();
		e.stopPropagation();
	}
});
</script>
</html>