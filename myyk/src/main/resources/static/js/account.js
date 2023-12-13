// 가계부 편집
$('#account-list-holder .card-body span:eq(0)').on('click', function () {
    let action = '/account/book/update';
    let parameters = {accountIdx:$(this).closest('.card-body').attr('data-idx')};
    mySubmitWithParam(action, parameters);
});

// 가계부 삭제
$('#account-list-holder .card-body span:eq(1)').on('click', function () {
    let action = '/account/book/delete';
    let parameters = {accountIdx:$(this).closest('.card-body').attr('data-idx')};
    mySubmitWithParam(action, parameters);
});

// 가계부 등록
$('#account-list-holder .card-body:last').on('click', function () {
    location.href='/account/book/create/input';
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
$('.member-holder input:eq(0)').on('change', function() {
    if ($(this).prop('checked')) {
        $('.member-holder input:eq(1)').prop('disabled', false);
    } else {
        $('.member-holder input:eq(1)').prop('checked', false);
        $('.member-holder input:eq(1)').prop('disabled', true);
    }
});