$(document).ready(function () {
    $('[name=readAuthList]').toArray().forEach(readAuth => {
        writeAuthTrigger($(readAuth));
    });
});

/**
 * 가계부
 */

// 가계부 등록
$('#account-book-list-holde .card-body:last').on('click', function () {
    location.href='/account/book/create/info/input';
});

// 가계부 편집
$('#account-book-list-holde .card-body span:eq(0)').on('click', function () {
    let action = '/account/book/update';
    let parameters = {accountIdx:$(this).closest('.card-body').attr('data-idx')};
    mySubmitWithParam(action, parameters);
});

// 가계부 삭제
$('#account-book-list-holde .card-body span:eq(1)').on('click', function () {
    let action = '/account/book/delete';
    let parameters = {accountIdx:$(this).closest('.card-body').attr('data-idx')};
    mySubmitWithParam(action, parameters);
});

// 가계부 등록 부가세 에리어 여닫기
$('input[name=taxIncluded]').on('change', function () {
    if ($(this).val() == 'true') {
        $('.tax-setting-area').slideUp();
    } else {
        $('.tax-setting-area').slideDown();
    }
});

// 가계부 등록 권한설정 트리거
$('[name=readAuthList]').on('change', function() {
    writeAuthTrigger($(this));
});

// 가계부 등록 권한설정 트리거 본체
function writeAuthTrigger(readAuth) {
    const writhAuth = readAuth.closest('.member-holder').find('[name=writeAuthList]');

    if (readAuth.prop('checked')) {
        writhAuth.prop('disabled', false);
    } else {
        writhAuth.prop('checked', false);
        writhAuth.prop('disabled', true);
    }
}



/**
 * 카테고리
 */

// 카테고리 등록
$('#category-list-holder .card-body:last').on('click', function () {
    location.href='/account/category/create/input';
});

// 아이콘 선택
$('.category-icon-dropdown-item li').on('click', function () {

    // 아이콘 이름을 인풋에 세팅
    let icon = $(this).find('i').data('icon');
    $('[name=categoryIcon]').val(icon);

    // 직접입력 창을 클릭한 것이 아닐 때
    if (icon != undefined) {
        closeCollapse('icon-collapse');
        $('#category-icon-holder').html(getIcon(icon));
    } else {
        $('#category-icon-holder').html(' - ');
    }
});

// 아이콘 직접입력
$('#icon-input-button').on('click', async function () {

    let iconName = $('[name=categoryIcon]').val();
    alert(iconName);

    $.ajax({
        url:'/bootstrap/checkIconName',
        method:'POST',
        data:{iconName: iconName},
        beforeSend: function () {
            openLoading();
        }
    })
    .done(function (errorCode) {

        allErrorOff();
        let errorCodes = getErrorCodesForApi(result);

        if (errorCodes == false) {
            setErrorMsg(errorCodes);
        } else {
            $('#category-icon-holder').html(getIcon(iconName));
            hideCollapse('icon-collapse');
        }
    })
    .fail(function () {
        alert(globalError);
    })
    .always(function () {
        closeLoading();
    });
});

// 컬러피커
$('#category-color-picker').spectrum({
    type: "component",
    showInitial: true,
    showAlpha: false,
    change: function (tinycolor) {
        const iconHolder = $('#category-icon-holder');
        iconHolder.css('color', tinycolor);
    }
});

/**
 * 서브 카테고리
 */

// 서브카테고리 콜랩스 열기
$('.bi-caret-down-fill').on('click', function () {
    
    //
    //
    // TODO 서브 카테고리 리스트 얻어오는 모달
    //
    //
    
    // 화살표 아이콘 반전
    setNextIcon($(this));

    let targetSubCategoryHolder = $(this).parents('.category-card').find('.collapse').attr('id');
    toggleCollapse(targetSubCategoryHolder);
});

// 서브 카테고리 편집 모달 열기
$('.update-sub-category').on('click', function() {
    setSubCategoryIdx('create-sub-category-modal', $(this));
    showModal('create-sub-category-modal');
});

// 서브 카테고리 삭제 모달 열기
$('.delete-sub-category').on('click', function() {
    setSubCategoryIdx('delete-sub-category-modal', $(this));
    showModal('delete-sub-category-modal');
});

// 서브 카테고리 생성 모달이 닫힐 때 내용 삭제
$('#create-sub-category-modal').on('hidden.bs.modal', function() {
    initModal($(this).attr('id'));
});

// 각종 모달에 서브 카테고리 인덱스 전달
function setSubCategoryIdx(modalId, targetElement) {
    const subCategoryIdxInput = $('#' + modalId + ' [name=subCategoryIdx]');
    let subCategoryIdx = targetElement.data('subCategoryIdx');
    subCategoryIdxInput.val(subCategoryIdx);
}

// 서브 카테고리 생성 모달 열기
$('.create-sub-category-card').on('click', function () {
    const categoryCard = $(this).parents('.category-card');

    // 서브 카테고리 콜랩스 닫기
    let targetSubCategoryHolder = categoryCard.find('.collapse').attr('id');
    hideCollapse(targetSubCategoryHolder);
    // 화살표 아이콘 반전
    const arrowIcon = $(this).parents('.category-card').find('.bi-caret-up-fill');
    setNextIcon(arrowIcon);

    // 서브 카테고리 생성 모달에 카테고리 인덱스 설정
    let categoryIdx = categoryCard.data('idx');
    $('#create-sub-category-modal [name=categoryIdx]').val(categoryIdx);

    // 모달 오픈
    showModal('create-sub-category-modal');
});

// 서브 카테고리 생성 클릭
$('#create-sub-category-modal .btn-primary').on('click', function () {

    let url = '/account/category/sub/create';
    let data = getParametersForModal('create-sub-category-modal');

    $.ajax({
        url:url,
        method:'POST',
        data:data,
        beforeSend: function () {
            openLoading();
        }
    })
    .done(function (result) {
        let errorCodes = getErrorCodesForApi(result);

        if (errorCodes == false) {
            // 서브카테고리 등록되는지 확인하고 등록이 되는 거면 != false 로 수정
        } else {
            setErrorMsgForModal(errorCodes, 'create-sub-category-modal');
        }
    })
    .fail(function () {
        alert(globalError);
    })
    .always(function () {
        closeLoading();
    });
});

// 삭제 카테고리 생성 클릭
$('#delete-sub-category-modal .btn-primary').on('click', async function () {
    
    getParametersForModal('delete-sub-category-modal');
    
    let url = '/account/category/sub/create';
    let data = null;
    //getAjaxResult(url, data);
});