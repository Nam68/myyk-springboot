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