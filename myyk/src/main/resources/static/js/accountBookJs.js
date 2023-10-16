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
	location.href='/account/createInput';
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

async function setSubCategory(categoryIdx) {
	openLoading();
	try {
		var data = await getSubCategory(categoryIdx);
		var caregories = JSON.parse(data);
		createSubCategory(caregories);
	} catch (error) {
		alert(ajaxErrorMsg);
	} finally {
		closeLoading();
	}
}

function getSubCategory(categoryIdx) {
	return $.ajax({
		url:'/account/category/getSubCategoryList',
		method:'POST',
		data:{
			categoryIdx: categoryIdx
		}
	});
}

function createSubCategory(categories) {
	
	resetSubCategory();

	if (categories.length <= 0) {
		return false;
	}
	if ($.isArray(categories)) {
		categories.forEach((category) => appendSubCategory(category));
	}

	displayToggle(subCategoryHolder);
}

function appendSubCategory(categoryData) {
	var categoryIdx = categoryData.categoryIdx;
	var categoryName = isKorean(selectedLanguage) ? categoryData.koCategoryName : categoryData.jpCategoryName;
	appendOption(subCategorySelect, categoryIdx, categoryName);
}

function appendSubCategoryDefault() {
	appendOption(subCategorySelect, '', subCategoryNon);
}

// 서브 카테고리 풀다운 초기화
function resetSubCategory() {
	// 카테고리
	subCategorySelect.html('');
	appendSubCategoryDefault();
	displayNone(subCategoryHolder);
}

/**
 * 회계 등록 세금 선택
 */
const bsCollapse = new bootstrap.Collapse('#tax-collapse', {
  toggle: false
});

$('#tax-added').on('click', function (e) {
	bsCollapse.show();
});

$('#tax-non-added').on('click', function (e) {
	bsCollapse.hide();
});

/**
 * 회계 등록 모달 닫기
 */
$('#add-account-modal').on('hidden.bs.modal', function () {
	$('.prime-category-holder').find('option:eq(0)').attr('selected', 'selected'); // 1차카테고리
	resetSubCategory(); // 서브카테고리
	$('.account-holder').val(''); // 금액
});
