// 가계부 등록 화면
$('#create-book-button').on('click', function () {
    location.href = '/account/book/create/input';
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