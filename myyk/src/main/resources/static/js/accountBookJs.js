/**
 * pc면 가계부 일람을 왼쪽으로 이동
 */
$(document).ready(function() {
	if (!isMobile()) {
		$('.account-pannel-left').addClass('text-start');
		$('.account-pannel-left').addClass('col-4');
		$('.account-pannel-right').addClass('col');
	}
});

/**
 * 가계부 생성 이동
 */
$('.create-account-book').on('click', function(e) {
	location.href='/account/book/createInput';
});

/**
 * 카테고리 리스트 이동
 */
$('.list-category-btn').on('click', function(e) {
	location.href='/account/category/list?accountBookIdx=' + $(this).data('idx');
});

/**
 * 회계 등록 카테고리 선택
 */
$('.prime-category-holder').find('select').on('change', function (e) {
	var categoryIdx = $(this).val();
	if (categoryIdx == '' || categoryIdx == undefined) {
		displayNone(subCategoryHolder);
		return false;
	}
	setSubCategory(categoryIdx);
});

// 회계 등록 서브 카테고리 가져오기
async function setSubCategory(categoryIdx) {
	openLoading();
	try {
		var data = await setSubCategoryAjax(categoryIdx);
		let categories = JSON.parse(data);

		resetSubCategory();
		
		if ($.isArray(categories)) {
			categories.forEach(category => appendSubCategory(category));
		}
		displayToggle(subCategoryHolder);

	} catch (error) {
		alert(ajaxErrorMsg);
	} finally {
		closeLoading();
	}
}

// 회계 등록 서브 카테고리 ajax
function setSubCategoryAjax(categoryIdx) {
	return $.ajax({
		url:'/account/category/getSubCategoryList',
		method:'POST',
		data:{
			categoryIdx: categoryIdx
		}
	});
}

// 서브 카테고리 부착
function appendSubCategory(categoryData) {
	const subCategorySelect = $('.sub-category-holder select');

	var categoryIdx = categoryData.categoryIdx;
	var categoryName = isKorean(selectedLanguage) ? categoryData.koCategoryName : categoryData.jpCategoryName;
	appendOption(subCategorySelect, categoryIdx, categoryName);
}

// 서브 카테고리 풀다운 초기화
function resetSubCategory() {
	const subCategorySelect = $('.sub-category-holder select');

	subCategorySelect.html('');
	appendOption(subCategorySelect, 0, subCategoryNon);
	displayNone(subCategoryHolder);
}

/**
 * 회계 등록 세금 선택
 */

const taxCollapse = new bootstrap.Collapse('#tax-collapse', {
  toggle: false
});

$('#tax-added').on('click', function (e) {
	taxCollapse.show();
});

$('#tax-non-added').on('click', function (e) {
	taxCollapse.hide();
});

/**
 * 회계 등록 모달 닫기
 */

$('#add-account-modal').on('hidden.bs.modal', function () {
	$('.prime-category-holder').find('option:eq(0)').attr('selected', 'selected'); // 1차카테고리
	resetSubCategory(); // 서브카테고리
	$('input[name=price]').val(''); // 금액
	$('input[name=taxIncluded]').eq(0).prop('checked', true); // 세금포함 선택
	$('select[name=taxRate]').find('option:eq(0)').prop('selected', true); // 세율 선택
	taxCollapse.hide(); // 세율 숨기기
	$('input[name=memo]').val('') // 메모
	
	unsetCheck($(this)); // 에러체크 풀기
});

/**
 * 회계 등록 컨펌
 */

// 컨펌 버튼 클릭
$('#add-account-modal .confirm').on('click', function (e) {

	if (checkReqiuired($('#add-account-modal')) == false) {
		return false;
	}
	let jsonData = getJsonData($(this).closest('.modal-content'));
	addAccount(jsonData);
});

// 회계 등록
async function addAccount(jsonData) {
	
	openLoading();
	
	try {
		let data = await addAccountAjax(jsonData);
		
		if (isValid(data)) {
			$('#add-account-modal').hide();
		} else {
			alert(createAccountError);
		}
		
	} catch (error) {
		alert(ajaxErrorMsg);
	} finally {
		closeLoading();
	}
}

// 회계 등록 ajax
function addAccountAjax(jsonData) {
	return $.ajax({
		type: 'POST',
		url: '/account/create',
		data: jsonData
	});
}
