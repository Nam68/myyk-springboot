/**
 * CSS 제어
 */

// 입력 로딩 화면
function openLoading() {
	$('#loading-modal').css('display', 'flex');
	$('.loading-spinner').css('display', 'flex');
}
function closeLoading() {
	$('#loading-modal').css('display', 'none');
	$('.loading-spinner').css('display', 'none');
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

// 옵션 덧붙이기
function appendOption(target, value, name) {
	target.append('<option value="' + value + '">' + name + '</option>');
}

function displayToggle(target) {
	var display = target.css('display');
	if (display == 'none') {
		target.css('display', 'block');
	} else if (display == 'block') {
		target.css('display', 'none');
	}
}

function displayNone(target) {
	target.css('display', 'none');
}

/**
 * 유효성검사
 */

// 에러 추가
function addError(target) {
	target.addClass('is-invalid');
	target.removeClass('is-valid');
	return false;
}
function addErrorBorder(target) {
	target.css('border', 'solid red 2px');
	return false;
}

// 에러 제거 (valid 상태로 만듦)
function removeError(target) {
	target.addClass('is-valid');
	target.removeClass('is-invalid');
	return true;
}
function removeErrorBorder(target) {
	target.css('border', 'solid green 2px');
	return true;	
}

// 에러체크 해제 (체크 자체를 무효화)
function unsetError(target) {
	target.removeClass('is-valid');
	target.removeClass('is-invalid');
	return true;
}
function unsetErrorBorder(target, border) {
	if (border == undefined || border == '') {
		target.css('border', '');
	} else {
		target.css('border', border);
	}
	return true;	
}

// 폼 필수 확인
function checkReqiuired(form) {
	let isChecked = true;
	form.find('input:required').toArray().forEach(element => {
		if ($(element).val() == undefined || $(element).val() == null || $(element).val() == '') {
			addError($(element));
			isChecked = false;
		} else {
			removeError($(element));
		}
	});
	form.find('select:required').toArray().forEach(element => {
		if ($(element).val() == undefined || $(element).val() == null || $(element).val() == '') {
			addError($(element));
			isChecked = false;
		} else {
			removeError($(element));
		}
	});
	return isChecked;
}

// 폼 확인 해제
function unsetCheck(form) {
	form.find('input:required').toArray().forEach(element => unsetError($(element)));
	form.find('select:required').toArray().forEach(element => unsetError($(element)));
}

// 엮여있는 엘레멘트 연동
function syncError(parent, children) {
	if (parent.hasClass('is-invalid')) {
		if (!$.isArray()) {
			addError(children);
		} else {
			children.forEach(target => addError(target));
		}
	} else {
		if (!$.isArray()) {
			removeError(children);
		} else {
			children.forEach(target => removeError(target));
		}
	}
}

// 엮여있는 엘레멘트 보더 연동
function syncErrorBorder(parent, children) {
	if (parent.hasClass('is-invalid')) {
		if (!$.isArray()) {
			addErrorBorder(children);
		} else {
			children.forEach(target => addErrorBorder(target));
		}
	} else {
		if (!$.isArray()) {
			removeErrorBorder(children);
		} else {
			children.forEach(target => removeErrorBorder(target));
		}
	}
}

// form-submit처럼 name을 통해 자동으로 json데이터 습득
function getJsonData(target) {
	
	const inputs = target.find('input').toArray();
	const selects = target.find('select').toArray();
	
	let nameList = new Array();
	let jsonData = {};
	
	inputs.forEach(element => {
		let name = $(element).attr('name');
		if (nameList.indexOf(name) == -1) {
			nameList.push(name);
		}
	});
	selects.forEach(element => {
		let name = $(element).attr('name');
		if (nameList.indexOf(name) == -1) {
			nameList.push(name);
		} 
	});
	
	nameList.forEach(name => {
		
		const element = target.find('[name=' + name + ']');
		let checkable = element.attr('type') == 'radio' || element.attr('type') == 'checkbox';
		let checked = checkable ? ':checked' : '';
		
		let value = target.find('[name=' + name + ']' + checked).val();
		jsonData[name] = value;
	});
	return jsonData;
}

/**
 * 판단 결과
 */

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

// 다국어설정 확인
function isKorean(selected_language) {
	if (selected_language == 'ko') {
		return true;
	} else {
		return false;
	}
}

/**
 * 헤더
 */

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

/**
 * 로그인 기능
 */

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
