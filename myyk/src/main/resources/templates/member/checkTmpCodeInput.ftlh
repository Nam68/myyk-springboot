<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@input "member.tmp.title"/></title>
</head>
<script src="/js/checkerJs.js"></script> 
<#include "/global/header.ftlh">
<body>
	<div class="col-lg-8 mx-auto">
		<h1 class="title">
			<@input "member.tmp.title"/>
		</h1>
		<form class="g-3 needs-validation" novalidate>
			<div class="mb-4">
				<label class="form-label">
					<@input "member.tmp.code"/>
				</label>
				<input type="text" class="form-control" name="tmpCode">
				<div class="invalid-feedback">
	        		<#--에러시 들어갈 내용-->
	      		</div>
			</div>
			<div class="pt-2 d-grid mx-auto">
				<button class="btn btn-primary" type="submit"><@input "alert.confirm"/></button>
			</div>
			
		</form>
		<form action="/member/createInput" method="post" class="next-page">
			<input type="hidden" name="tmpCode">
		</form>
	</div>
</body>
<script>
	$('.needs-validation').on('submit', function(e) {
	
		e.preventDefault();
		e.stopPropagation();
	
	 	openLoading();
		
		$.ajax({
	   		url:'/member/checkTmpCode',
	   		method:'POST',
	   		data:{tmpCode: $('input[name=tmpCode]').val()}
	   	})
	   	.done(function(data) {
	   	
	   		closeLoading();
	   		
	   		if (data == 'ERROR' || data.includes('<!DOCTYPE html>')) {
	   			$('.invalid-feedback').html('<@input "member.tmp.error"/>');
				$('input[name=tmpCode]').addClass('is-invalid');
	   		} else {
	   			$('input[name=tmpCode]').val(data);
	   			$('.next-page').submit();
	   		}
	   	})
	   	.fail(function(data) {
	   		closeLoading();
	   		window.alert('<@input "error.ajax"/>');
	   	});
		
	});
</script>
<#include "/global/footer.ftlh">
</html>