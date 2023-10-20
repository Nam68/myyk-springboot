/**
 * createCategoryInput
 */

// 번역
$('#create-category-name-translate').on('click', function(e) {
	alert('not ready...');
});

// 물음표 버튼 호버
$('#category-icon-question').on('mouseenter', function(e) {
	$(this).removeClass('bi-question-circle');
	$(this).addClass('bi-question-circle-fill');
});
$('#category-icon-question').on('mouseleave', function(e) {
	$(this).removeClass('bi-question-circle-fill');
	$(this).addClass('bi-question-circle');
});

// 아이템 드롭다운
$('.dropdown-item').on('click', function(e){
	var iconName = $(this).find('i').data('icon');
	$('input[name=icon]').val(iconName);
	changeIcon(iconName);
});

// 아이템 직접 입력
$('#icon-input-button').on('click', function(e) {
	
	openLoading();
	
	var iconName = $('input[name=icon]').val();
	
	$.ajax({
	   		url:'/bootstrap/checkIconName',
	   		method:'POST',
	   		data:{iconName: iconName}
		})
	   	.done(function(data) {
	   	
	   		closeLoading();
	   		
	   		if (isValid(data)) {
	   			changeIcon(iconName);
	   		} else {
	   			alert('<@input "account.category.create.error.notFound"/>');
	   		}
	   	})
	   	.fail(function(data) {
	   		closeLoading();
	   		window.alert('<@input "error.ajax"/>');
	   	});
});
// 아이콘 드롭다운 이미지를 바꿔줌
function changeIcon(iconName) {
	$('#category-icon-holder').html('');
	$('#category-icon-holder').attr('class', '');
	$('#category-icon-holder').addClass('bi bi-' + iconName);
}

// 컬러피커
$('#category-color-picker').spectrum({
  type: "component",
  showInitial: true,
  showAlpha: false
});

// 돌아가기
$('.returnCategoryList').on('click', function(e) {
	var accountBookIdx = $('input[name=accountBookIdx]').val();
	location.href='/account/category/list?accountBookIdx=' + accountBookIdx;
});

// 서브밋
$('form[action="/account/category/createPrimeCategory"]').on('submit', function (e) {
	
	openLoading();
	
	if (!checkReqiuired($(this))) {
		e.preventDefault();
	}
	
	syncErrorBorder($('input[name=icon]'), $('.category-icon-dropdown-item'));
	syncError($('input[name=icon]'), $('.invalid-for-icon-select'));
	syncError($('#category-color-picker'), $('.invalid-for-color-picker'));
	
	closeLoading();
});

/**
 * listCategory
 */

 // 카테고리 생성 버튼 클릭
$('.add-category-btn').on('click', function(e) {
	location.href = '/account/category/createInput?accountBookIdx=' + $(this).data('idx');
});

// 서브 카테고리 생성 링크 클릭
$('.create-sub-category-link').on('click', function(e) {
	var parentCategoryIdx = $(this).attr('data-categoryIdx');
	$('.parent-category-idx').val(parentCategoryIdx);
});

// 서브 모달 확인버튼
$('#create-sub-category-modal').find('.modal-footer').find('.btn-primary').on('click', function(e) {

	var koCategoryName = $('input[name="koCategoryName"]').val();
	var jpCategoryName = $('input[name="jpCategoryName"]').val();
	var accountBookIdx = $('.add-category-btn').data('idx');
	var parentCategoryIdx = $('.parent-category-idx').val();

	$.ajax({
		url:'/account/category/createSubCategory',
		method:'POST',
		data:{
			koCategoryName: koCategoryName,
			jpCategoryName: jpCategoryName,
			accountBookIdx: accountBookIdx,
			parentCategoryIdx: parentCategoryIdx
		}
	})
	.done(function(data) {
	   	
		closeLoading();
	   		
		if (isValid(data)) {
			alert('good');
		} else {
			alert('bad');
		}
	})
	.fail(function(data) {
		closeLoading();
		window.alert('<@input "alert.error.ajax"/>');
	});
});

// 뒤로가기
$('#list-category-back-btn').on('click', function(e) {
	location.href = '/account/dashboard?accountBookIdx=' + $('.add-category-btn').data('idx');
});