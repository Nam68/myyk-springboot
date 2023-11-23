/**
 * CSS 제어
 */

// 입력 로딩 화면
function openLoading() {
    $('#loading-modal').css('display', 'flex');
    $('.loading-spinner').css('display', 'flex');
}
function closeLoading() {
    $('#loading-modal').css('display', 'none');
    $('.loading-spinner').css('display', 'none');
}

// 타깃을 화면 정가운데로 정렬
function centerAlignDiv(target) {
    let width = target.width();
    let height = target.height();

    let screenX = $(window).width();
    let screenY = $(window).height();
    
    let newWidth = (screenX / 2) - (width / 2);
    let newHeight = (screenY / 2) - (height / 2);

    target.css('position', 'relative');
    target.css('left', newWidth);
    target.css('top', newHeight);
}