// 타깃을 화면 정가운데로 정렬
function centerAlignDiv() {
	var target = $('.center-align-div');
	var width = target.width();
	var height = target.height();
	
	var screenX = $(window).width();
	var screenY = $(window).height();
	
	var newWidth = (screenX / 2) - (width / 2);
	var newHeight = (screenY / 2) - (height / 2);
	
	target.css('position', 'relative');
	target.css('left', newWidth);
	target.css('top', newHeight);
}

// 로그아웃 ajax
$('.header-logout-menu').on('click', function(e) {
   	
   	openLoading();
   	
   	$.ajax({
   		url:'/authorize/logoutMember.do',
   		method:'POST',
   		data:{}
   	})
   	.done(function(data) {
   		closeLoading();
   		location.reload();
   	})
   	.fail(function(data) {
   		closeLoading();
   		window.alert('<spring:message code="error.ajax"/>');
   	});
 });
    
 // 모바일 헤더 자동숨김
 var headerHeight = $('.mobile-header').height();
 var preHeaderScroll = 0; // 스크롤하기 이전의 스크롤값
 $(document).on('scroll', function() {
    	
   	var nowScroll = $(this).scrollTop();
   	
   	var flg = preHeaderScroll - nowScroll >= 0;
   	
   	if(flg == true) {
   		$('.mobile-header').css('top', 0);
   	} else if(flg == false) {
   		$('.mobile-header').css('top', -headerHeight);
   	} else if(nowScroll >= headerHeight) {
   		$('.mobile-header').css('top', -headerHeight);
   	} else if(nowScroll < headerHeight) {
   		$('.mobile-header').css('top', 0);
   	} else  {
   		$('.mobile-header').css('top', 0);
   	}
    	
 	preHeaderScroll = $(this).scrollTop();
});

// 로그인 모달 창이 닫히면 입력창 초기화
$('#login-modal').on('hidden.bs.modal', function (e) {
   	$('#login-local-part-email').val('');
   	$('#login-domain-part-email').val('');
   	$('#login-password').val('');
   	$('#auto-login-check').prop('checked', false);
});
    
// 로그인 입력창 자동 트림
$('#login-local-part-email').on('input', function(e) {
   	$(this).val($(this).val().trim());
});
$('#login-domain-part-email').on('input', function(e) {
   	$(this).val($(this).val().trim());
});
$('#login-password').on('input', function(e) {
   	$(this).val($(this).val().trim());
});
    
// 로그인 스크립트
$('#header-login-submit').on('click', function(e) {
   	var localPartEmail = $('#login-local-part-email').val().trim();
   	var domainPartEmail = $('#login-domain-part-email').val().trim();
   	var password = $('#login-password').val().trim();
   	var autoLoginCheck = $('#auto-login-check').is(':checked');
    	
   	openLoading();
   	
   	$.ajax({
  		url:'/authorize/loginMember.do',
   		method:'POST',
   		data:{
   			'localPartEmail':localPartEmail,
   			'domainPartEmail':domainPartEmail,
   			'password':password,
   			'autoLoginCheck':autoLoginCheck,
   		}
   	})
   	.done(function(data) {
			
   		closeLoading();
    		
   		if(data == 'ERROR') {
   			window.alert('<spring:message code="error.header.login"/>');
   		} else if(data == 'SUCCESS') {
       		$('#login-modal').modal('hide');
   			location.reload();
   		}
   	})
   	.fail(function(data) {
   		closeLoading();
   		window.alert('<spring:message code="error.ajax"/>');
   	});
});

function openLoading() {
	$('#loading-modal').css('display', 'flex');
	$('.loading-spinner').css('display', 'flex');
}

function closeLoading() {
	$('#loading-modal').css('display', 'none');
	$('.loading-spinner').css('display', 'none');
}

//비밀번호 확인
$('.password-form').find('i').on('mousedown', function(e) {
	$(this).removeClass('bi-eye-fill');
	$(this).addClass('bi-eye-slash-fill');
	$(this).parent().find('input').attr('type', 'text');
});
$('.password-form').find('i').on('mouseup', function(e) {
	$(this).removeClass('bi-eye-slash-fill');
	$(this).addClass('bi-eye-fill');
	$(this).parent().find('input').attr('type', 'password');
});
$('.password-form').find('i').on('touchstart', function(e) {
	$(this).removeClass('bi-eye-fill');
	$(this).addClass('bi-eye-slash-fill');
	$(this).parent().find('input').attr('type', 'text');
});
$('.password-form').find('i').on('touchend', function(e) {
	$(this).removeClass('bi-eye-slash-fill');
	$(this).addClass('bi-eye-fill');
	$(this).parent().find('input').attr('type', 'password');
});
