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
        hideIconCollapse();
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
        beforeSned: function () {
            openLoading();
        }
    })
    .done(function (errorCode) {
        allErrorOff();
        if (!isSuccess(errorCode)) {
            errorOn(errorCode);
        } else {
            $('#category-icon-holder').html(getIcon(iconName));
            hideIconCollapse();
        }
    })
    .fail(function () {
        alert(globalError);
    })
    .always(function () {
        closeLoading();
    })
    ;
});

// 직접입력창을 닫음
function hideIconCollapse() {
    const iconCollapse = new bootstrap.Collapse('#icon-collapse', {toggle: false});
    iconCollapse.hide();
}

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
