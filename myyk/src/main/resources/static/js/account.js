// 가계부 편집
$('#account-list-holder .card-body span:eq(0)').on('click', function () {
    let action = '/account/book/update';
    let parameters = {accountIdx:$(this).closest('.card-body').attr('data-idx')};
    mySubmit(action, parameters);
});

// 가계부 삭제
$('#account-list-holder .card-body span:eq(1)').on('click', function () {
    let action = '/account/book/delete';
    let parameters = {accountIdx:$(this).closest('.card-body').attr('data-idx')};
    mySubmit(action, parameters);
});

// 가계부 등록
$('#account-list-holder .card-body:last').on('click', function () {
    location.href='/account/book/create/input';
});

// 가계부 등록 부가세 에리어 여닫기
$('input[name=isTaxIncluded]').on('change', function () {
    if ($(this).val() == 'true') {
        $('.tax-setting-area').slideUp();
    } else {
        $('.tax-setting-area').slideDown();
    }
});