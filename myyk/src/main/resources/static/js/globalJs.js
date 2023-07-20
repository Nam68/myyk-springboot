// 입력 로딩 화면
function openLoading() {
	$('#loading-modal').css('display', 'flex');
	$('.loading-spinner').css('display', 'flex');
}
function closeLoading() {
	$('#loading-modal').css('display', 'none');
	$('.loading-spinner').css('display', 'none');
}

// 모바일인지 판단
// true면 모바일
function isMobile(){
	return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent);
}

// ajax의 data 에러 확인
function isValid(data) {
	if (data == 'ERROR' || data.includes('<!DOCTYPE html>')) {
		return false;
	} else {
		return true;
	}
}

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
