/**
 * 최소치와 최대치를 입력해서 비교하는 함수
 */
function lengthChecker(val, min, max) {
	if (val.length < min || val.length > max) {
		return false;
	}
	return true;
}

/**
 * 영문 대문자, 소문자, 숫자가 전부 있는지 체크.
 */
function allLetterChecker(val) {
	var arr = [...val];
	var upper = false;
	var lower = false;
	var number = false;
	
	for (var i in arr) {
		if (arr[i] >= 'A' && arr[i] <= 'Z') {
			upper = true;
			continue;
		}
		if (arr[i] >= 'a' && arr[i] <= 'z') {
			lower = true;
			continue;
		}
		if (arr[i] >= 0 && arr[i] <= 9) {
			number = true;
		}
	}
	
	return upper && lower && number;
}

/**
 * 현재 DOM과 판단할 진위치를 넣으면 자동으로 유효성 검사의 class를 조정
 */
 function validate(dom, isValid) {
	if (isValid) {
		dom.addClass('is-valid');
		dom.removeClass('is-invalid');
	} else {
		dom.removeClass('is-valid');
		dom.addClass('is-invalid');
	}
}
 
 
 
 