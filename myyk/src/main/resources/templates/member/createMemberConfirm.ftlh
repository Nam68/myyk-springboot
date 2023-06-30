<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@spring.message "member.create.input.title"/></title>
</head>
<script src="/js/checkerJs.js"></script> 
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@spring.message "member.create.input.title"/>
		</h1>
		<form action="/member/create" method="post" class="g-3 needs-validation" novalidate>
			<#-- 이메일 -->
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "member.attr.email"/>
				</label>
				<label class="form-label">
					${dto.email}
				</label>
			</div>
			<#-- 닉네임 -->
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "member.attr.nickname"/>
				</label>
				<label class="form-label">
					${dto.nickname}
				</label>
			</div>
			<#-- 지역 -->
			<div class="mb-4">
				<label class="form-label">
					<@spring.message "member.attr.region"/>
				</label>
				<label class="form-label">
					<@spring.message "member.region.${dto.region.value}"/>
				</label>
			</div>
			<#-- 버튼 -->
			<div class="pt-2 d-grid mx-auto">
				<button class="btn btn-primary submit-button" type="submit"><@spring.message "alert.confirm"/></button>
			</div>
		</form>
	</div>
</body>
<#include "/global/footer.ftlh">
<script type="text/javascript">
	
</script>
</html>