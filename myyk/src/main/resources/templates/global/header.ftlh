<!DOCTYPE html>
<html>
<#include "/lib.ftlh">

<!-- 
	
	PC버전에서의 헤더
	
-->
<header class="pc-header header-component fixed-top align-items-center justify-content-center justify-content-md-between">
	<a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
		<i class="bi bi-bootstrap-fill main-bi d-block mx-auto mb-1"></i>
	</a>
	<div>
		<ul class="nav mb-2 justify-content-center mb-md-0 text-center">
		<!-- 
			<li>
				<a href="/globalPage/homePage.do" class="nav-link px-2 me-4 selected-header">
					<i class="bi bi-bootstrap-fill mb-1 me-1 align-middle"></i>
					<strong>Home</strong>
				</a>
			</li>
		-->
		<li>
			<a href="#" class="nav-link px-2 me-4 selected-header}">
				<i class="bi bi-images main-bi mb-1 me-1 align-middle"></i>
				<strong>memory</strong>
			</a>
		</li>
		<li>
			<a href="#" class="nav-link px-2 me-4 primary-dark-color">
				<i class="bi bi-pin-map-fill main-bi mb-1 me-1 align-middle"></i>
				<strong>wishPlace</strong>
			</a>
		</li>
		<li>
			<a href="#" class="nav-link px-2 me-4 primary-dark-color">
				<i class="bi bi-map main-bi mb-1 me-1 align-middle"></i>
				<strong>map</strong>
			</a>
		</li>
		<li>
			<a href="#" class="nav-link px-2 me-4 primary-dark-color">
				<i class="bi bi-patch-question main-bi mb-1 me-1 align-middle"></i>
				<strong>request</strong>
			</a>
		</li>
		<li>
			<a href="/calendar/calendarList.do" class="nav-link px-2 me-4 primary-dark-color">
				<i class="bi bi-calendar3 main-bi mb-1 me-1 align-middle"></i>
				<strong>calendar</strong>
			</a>
		</li>
	</ul>
	</div>
	<#if login_info?exists>
		<div id="login-icon-div" class="dropdown text-end pb-2 col-md-3 d-flex align-items-center">
			<div class="login-account">
			<span class="primary-dark-color-not-hover me-3">${login_info.nickname }header.welcome</span>
			<a href="#" class="link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
				<img src="${login_info.memberIcon }" alt="mdo" class="rounded-circle login-picture <#if category = 'MEMBER'>selected-header-icon</#if>">
			</a>
			<ul class="dropdown-menu text-small">
				<c:if test="${login_info.memberType == 'ADMIN' }">
				<li><a class="dropdown-item primary-dark-color" href="/adminPage/adminHome.do">header.member.admin</a></li>
				</c:if>
				<li><a class="dropdown-item" href="#">New project...</a></li>
				<li><a class="dropdown-item" href="#">Settings</a></li>
				<li><a class="dropdown-item" href="#">header.member.myinfo</a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a href="#" class="header-logout-menu dropdown-item">header.member.logout</a></li>
			</ul>
		</div>
	<#elseif !login_info?exists>
		<div class="login-btn-div text-end pb-2 col-md-3 d-flex align-items-center">
			<button type="button" class="btn btn-outline-primary me-2" data-bs-toggle="modal" data-bs-target="#login-modal">header.login</button>
			<button type="button" class="btn btn-primary" onclick="location.href='/email/checkInput.do'">header.signup</button>
		</div>
	</#if>
	<#--
	<c:if test="${sessionScope.login_info == null }">
		<div class="login-btn-div text-end pb-2 col-md-3 d-flex align-items-center">
			<button type="button" class="btn btn-outline-primary me-2" data-bs-toggle="modal" data-bs-target="#login-modal"><s:message code="header.login"/></button>
			<button type="button" class="btn btn-primary" onclick="location.href='/email/checkInput.do'"><s:message code="header.signup"/></button>
		</div>     
	</c:if>
	<c:if test="${sessionScope.login_info != null }">
		<div id="login-icon-div" class="dropdown text-end pb-2 col-md-3 d-flex align-items-center">
			<div class="login-account">
			<span class="primary-dark-color-not-hover me-3">${sessionScope.login_info.nickname }<s:message code="header.welcome" /></span>
			<a href="#" class="link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
				<img src="${sessionScope.login_info.memberIcon }" alt="mdo" class="rounded-circle login-picture ${headerValue == 'MEMBER' ? 'selected-header-icon' : ''}">
			</a>
			<ul class="dropdown-menu text-small">
				<c:if test="${sessionScope.login_info.memberType == 'ADMIN' }">
				<li><a class="dropdown-item primary-dark-color" href="/adminPage/adminHome.do"><s:message code="header.member.admin"/></a></li>
				</c:if>
				<li><a class="dropdown-item" href="#">New project...</a></li>
				<li><a class="dropdown-item" href="#">Settings</a></li>
				<li><a class="dropdown-item" href="#"><s:message code="header.member.myinfo"/></a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a href="#" class="header-logout-menu dropdown-item"><s:message code="header.member.logout"/></a></li>
			</ul>
		</div>
	</div> 
	</c:if>
	-->
</header>
    
<!-- 
    
	모바일 환경에서의 헤더
    
-->
<#--
<header class="mobile-header header-component fixed-top align-items-center">
	<div class="row">
		<a href="/" class="d-flex text-dark text-decoration-none">
			<i class="bi bi-bootstrap-fill main-bi d-block m-auto"></i>
		</a>
	<c:if test="${sessionScope.login_info == null }">
	<div class="login-btn-div text-end p-2 pe-4">
		<button type="button" class="btn btn-outline-primary me-2" data-bs-toggle="modal" data-bs-target="#login-modal"><s:message code="header.login"/></button>
		<button type="button" class="btn btn-primary" onclick="location.href='/email/checkInput.do'"><s:message code="header.signup"/></button>
	</div>     
	</c:if>
	<c:if test="${sessionScope.login_info != null }">
		<div class="dropdown text-end pb-2 pt-2 pe-2">
			<div class="login-account">
				<span class="me-3">${sessionScope.login_info.nickname }<s:message code="header.welcome" /></span>
				<a href="#" class="link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
					<img src="${sessionScope.login_info.memberIcon }" alt="mdo" class="rounded-circle login-picture">
				</a>
				<ul class="dropdown-menu text-small">
					<c:if test="${sessionScope.login_info.memberType == 'ADMIN' }">
					<li><a class="dropdown-item primary-dark-color" href="/adminPage/adminHome.do"><s:message code="header.member.admin"/></a></li>
					</c:if>
					<li><a class="dropdown-item" href="#">New project...</a></li>
					<li><a class="dropdown-item" href="#">Settings</a></li>
					<li><a class="dropdown-item" href="#"><s:message code="header.member.myinfo"/></a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a href="#" class="header-logout-menu dropdown-item"><s:message code="header.member.logout"/></a></li>
				</ul>
			</div>
		</div> 
		</c:if>
	</div>
</header>
-->
    
    
<!-- Login Modal -->
<div class="modal fade" id="login-modal" tabindex="-1" aria-labelledby="login-modal-label" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="login-modal-label">login</h1>
				<button type="button" class="btn-close" id="header-login-modal-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<form>
				<div class="modal-body">
					<div class="mb-3">
						<label for="login-local-part-email" class="form-label">email</label>
						<div class="input-group mb-4">
							<input id="login-local-part-email" type="text" class="form-control" name="localPartEmail" placeholder="example">
							<span class="input-group-text">@</span>
							<input id="login-domain-part-email" type="text" class="form-control" name="domainPartEmail" placeholder="domain.com">
						</div>
					</div>
					<div class="mb-3">
						<label for="login-password" class="form-label">password</label>
						<div class="password-form">
							<input id="login-password" name="password" type="password" class="form-control">
							<i class="bi bi-eye-fill main-bi primary-color-not-hover"></i>
						</div>
					</div>
					<div class="form-check">
						<input id="auto-login-check" name="autoLoginCheck" type="checkbox" class="form-check-input">
			    		<label class="form-label" for="auto-login-check">autoLogin</label>
			  		</div>
	      		</div>
				<div class="d-grid gap-2 p-3">
					<button id="header-login-submit" class="btn btn-primary" type="button">login</button>
					<button id="header-login-close" class="btn btn-outline-primary" type="button" data-bs-dismiss="modal">close</button>
				</div>
			</form>
		</div>
	</div>
</div>

</html>