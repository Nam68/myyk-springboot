$(function () {
    writeAuthSetting();
});

// 가계부 등록 화면
$('#create-book-button').on('click', function () {
    location.href = '/account/book/create/input';
});

// 화면 로드 시 쓰기권한 디스에이블 토글
// (뒤로가기 대책)
function writeAuthSetting() {

    const readAuthList = $('[name=readAuthList]');

    readAuthList.toArray().forEach(read => {
        if (!$(read).is(':checked')) {
            // 읽기권한이 체크되어있지 않다면 쓰기권한은 사용불가
            let write = $(read).closest('.member-holder').find('[name=writeAuthList]');
            $(write).prop('disabled', true);
        }
    });
}

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