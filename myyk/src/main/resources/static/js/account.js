$(document).ready(function () {
    $('[name=readAuthList]').toArray().forEach(readAuth => {
        writeAuthTrigger($(readAuth));
    });
});

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
