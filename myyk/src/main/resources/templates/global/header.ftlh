<!DOCTYPE html>
<html>
<#include "/lib.ftlh">

<!-- 
	
	PC버전에서의 헤더
	
-->
<div>
	<div class="language-setting pc-language-setting p-2 ps-2" style="width: 50%; text-align: left;">
		<select class="form-select form-select-sm" aria-label=".form-select-sm example">
		  <option selected>Language/언어/言語</option>
		  <option value="ko">한국어/Korean</option>
		  <option value="jp">日本語/Japanese</option>
		</select>
	</div>
</div>
<header class="pc-header header-component fixed-top align-items-center justify-content-center justify-content-md-between">
	<#-- 
	<a href="/" class="d-flex align-items-center col-md-2 mb-2 mb-md-0 text-dark text-decoration-none">
		<i class="bi bi-bootstrap-fill main-bi d-block mx-auto mb-1"></i>
	</a>
	 -->
	<div>
		<ul class="nav mb-2 justify-content-center mb-md-0 text-center">
		<#-- 
			<li>
				<a href="/globalPage/homePage.do" class="nav-link px-2 me-4 selected-header">
					<i class="bi bi-bootstrap-fill mb-1 me-1 align-middle"></i>
					<strong>Home</strong>
				</a>
			</li>
		-->
		<li>
			<a href="#" class="nav-link px-2 me-4 <@if category=='MEMORY' 'selected-header' 'primary-dark-color' />">
				<i class="bi bi-images main-bi mb-1 me-1 align-middle"></i>
				<strong><@spring.message "category.memory"/></strong>
			</a>
		</li>
		<li>
			<a href="#" class="nav-link px-2 me-4 <@if category=='WISH_PLACE' 'selected-header' 'primary-dark-color' />">
				<i class="bi bi-pin-map-fill main-bi mb-1 me-1 align-middle"></i>
				<strong><@spring.message "category.wishPlace"/></strong>
			</a>
		</li>
		<li>
			<a href="#" class="nav-link px-2 me-4 <@if category=='MAP' 'selected-header' 'primary-dark-color' />">
				<i class="bi bi-map main-bi mb-1 me-1 align-middle"></i>
				<strong><@spring.message "category.map"/></strong>
			</a>
		</li>
		<#--
		<li>
			<a href="#" class="nav-link px-2 me-4 <@if category=='REQUEST' 'selected-header' 'primary-dark-color' />">
				<i class="bi bi-patch-question main-bi mb-1 me-1 align-middle"></i>
				<strong><@spring.message "category.request"/></strong>
			</a>
		</li>
		-->
		<li>
			<a href="/account/dashboard" class="nav-link px-2 me-4 <@if category=='ACCOUNT' 'selected-header' 'primary-dark-color' />">
				<i class="bi bi-calculator main-bi mb-1 me-1 align-middle"></i>
				<strong><@spring.message "category.account"/></strong>
			</a>
		</li>
		<li>
			<a href="/calendar/calendarList.do" class="nav-link px-2 me-4 <@if category=='CALENDAR' 'selected-header' 'primary-dark-color' />">
				<i class="bi bi-calendar3 main-bi mb-1 me-1 align-middle"></i>
				<strong><@spring.message "category.calendar"/></strong>
			</a>
		</li>
	</ul>
	</div>
	<#if login_info?exists>
		<div id="login-icon-div" class="dropdown text-end pb-2 col-md-3 d-flex align-items-center">
			<div class="login-account">
			<span class="primary-dark-color-not-hover me-3">${login_info.nickname }<@spring.message "header.welcome"/></span>
			<a href="#" class="link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
				<img src="${login_info.memberIcon }" alt="mdo" class="rounded-circle login-picture <#if category = 'MEMBER'>selected-header-icon</#if>">
			</a>
			<ul class="dropdown-menu text-small">
				<#if login_info.isAdmin()>
				<li><a class="dropdown-item primary-dark-color" href="/adminPage/adminHome.do"><@spring.message "header.member.admin"/></a></li>
				</#if>
				<li><a class="dropdown-item" href="#">New project</a></li>
				<li><a class="dropdown-item" href="#">Settings</a></li>
				<li><a class="dropdown-item" href="#"><@spring.message "header.member.myInfo"/></a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a class="header-logout-menu dropdown-item" href="#"><@spring.message "header.logout"/></a></li>
			</ul>
		</div>
	<#elseif !login_info?exists>
		<div class="login-btn-div text-end pb-2 col-md-3 align-items-right">
			<button type="button" class="btn btn-outline-primary me-2" data-bs-toggle="modal" data-bs-target="#login-modal"><@spring.message "header.login"/></button>
			<button type="button" class="btn btn-primary" onclick="location.href='/member/emailCheckInput'"><@spring.message "header.signup"/></button>
		</div>
	</#if>
</header>
    
<!-- 
    
	모바일 환경에서의 헤더
    
-->
<header class="mobile-header header-component fixed-top align-items-center">
	<div>
		<div class="language-setting mobile-language-setting p-2 ps-4" style="border: width: 50%; text-align: left;">
			<select class="form-select form-select-sm" aria-label=".form-select-sm example">
			  <option selected>Language/언어/言語</option>
			  <option value="ko">한국어/Korean</option>
			  <option value="jp">日本語/Japanese</option>
			</select>
		</div>
	</div>
	<div class="row">
		<a href="/" class="d-flex text-dark text-decoration-none">
			<i class="bi bi-bootstrap-fill main-bi d-block m-auto"></i>
		</a>
	<#if login_info?exists>
		<div class="dropdown text-end pb-2 pt-2 pe-2">
			<div class="login-account">
				<span class="me-3">${login_info.nickname }<@spring.message "header.welcome"/></span>
				<a href="#" class="link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
					<img src="${login_info.memberIcon }" alt="mdo" class="rounded-circle login-picture">
				</a>
				<ul class="dropdown-menu text-small">
					<#if login_info.memberType == 'ADMIN'>
					<li><a class="dropdown-item primary-dark-color" href="/adminPage/adminHome.do"><@spring.message "header.member.admin"/></a></li>
					</#if>
					<li><a class="dropdown-item" href="#">New project...</a></li>
					<li><a class="dropdown-item" href="#">Settings</a></li>
					<li><a class="dropdown-item" href="#"><@spring.message "header.member.myInfo"/></a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="header-logout-menu dropdown-item" href="#"><@spring.message "header.logout"/></a></li>
				</ul>
			</div>
		</div> 
	<#elseif !login_info?exists>
		<div class="login-btn-div text-end p-2 pe-4">
			<button type="button" class="btn btn-outline-primary me-2" data-bs-toggle="modal" data-bs-target="#login-modal"><@spring.message "header.login"/></button>
			<button type="button" class="btn btn-primary" onclick="location.href='/member/emailCheckInput'"><@spring.message "header.signup"/></button>
		</div>
	</#if>
	</div>
</header>
    
    
<!-- Login Modal -->
<div class="modal fade" id="login-modal" tabindex="-1" aria-labelledby="login-modal-label" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="login-modal-label"><@spring.message "header.login"/></h1>
				<button type="button" class="btn-close" id="header-login-modal-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body text-start">
				<div class="mb-3">
					<label for="login-local-part-email" class="form-label"><@spring.message "member.attr.email"/></label>
					<div class="input-group mb-4">
						<input id="login-local-part-email" type="text" class="form-control" name="localPartEmail" placeholder="example">
						<span class="input-group-text">@</span>
						<input id="login-domain-part-email" type="text" class="form-control" name="domainPartEmail" placeholder="domain.com">
					</div>
				</div>
				<div class="mb-3">
					<label for="login-password" class="form-label"><@spring.message "member.attr.password"/></label>
					<div class="password-form">
						<input id="login-password" name="password" type="password" class="form-control">
						<i class="bi bi-eye-fill main-bi primary-color-not-hover"></i>
					</div>
				</div>
				<div class="form-check">
					<input id="auto-login-check" name="autoLoginCheck" type="checkbox" class="form-check-input" value="check">
			   		<label class="form-label" for="auto-login-check"><@spring.message "header.autoLogin"/></label>
			 		</div>
	      	</div>
			<div class="d-grid gap-2 p-3">
				<button id="header-login-submit" class="btn btn-primary" type="button"><@spring.message "header.login"/></button>
				<button id="header-login-close" class="btn btn-outline-primary" type="button" data-bs-dismiss="modal"><@spring.message "alert.close"/></button>
			</div>
		</div>
	</div>
</div>
<script>
// 언어 선택
$('.language-setting').on('change', function(e) {
	var lang = $(this).find('option:selected').val();
	var sameLang = lang == '${selected_language}';
	
	if (sameLang) {
		alert('이미 선택된 언어입니다\r\n既に選択中の言語です');
		$('.language-setting').find('option:eq(0)').prop('selected', true);
		return;
	}
	
	if (confirm('메인 화면으로 돌아갑니다. 언어를 변경하시겠습니까?\r\nメイン画面に遷移します。よろしいですか？') == true) {
		location.href="/?lang=" + lang;
	} else {
		// 언어 변경을 취소하는 경우 셀렉트의 선택을 다시 원래대로
		$('.language-setting').find('option:eq(0)').prop('selected', true);
	}
});

// 로그인
$('#header-login-submit').on('click', function(e) {

	openLoading();
	
	$.ajax({
	   	url:'/member/login',
   		method:'POST',
   		data:{
   			localPartEmail: $('#login-local-part-email').val(),
   			domainPartEmail: $('#login-domain-part-email').val(),
   			password: $('#login-password').val(),
   			autoLoginCheck: $('#auto-login-check').is(':checked')
   		}
   	})
   	.done(function(data) {
   	
   		closeLoading();
   		
   		if (isValid(data)) {
   			$('#login-modal').modal('hide');
	   		location.reload();
   		} else  {
   			window.alert('<@spring.message "error.member.login.failed"/>');
   		}
   	})
   	.fail(function(data) {
   		closeLoading();
   		window.alert('<@spring.message "error.ajax"/>');
   	});	
});

// 로그아웃
$('.header-logout-menu').on('click', function(e) {
	
	openLoading();
	
	$.ajax({
		url:'/member/logout',
		method:'POST'
	})
	.done(function(data) {
	
		closeLoading();
		
		if (isValid(data)) {
			location.href="/";
		} else {
			window.alert('<@spring.message "error.member.login.failed"/>');
		}
	})
	.fail(function(data) {
		closeLoading();
   		window.alert('<@spring.message "error.ajax"/>');
	});
});
</script>
</html>