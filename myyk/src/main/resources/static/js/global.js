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

/**
 * 서브밋 제어
 */

function mySubmit() {
    const form = $('form');
    if (form.length > 1 || form.length <= 0) {
        alert(globalError);
        return false;
    }
    form.submit();
}

function mySubmitWithParam(action, parameters) {
    const form = $('<form>', {action:action, method:'POST'});

    for (var key in parameters) {
        alert(key + ' = ' + parameters[key]);
        form.append($('<input>', {name:key, value:parameters[key]}));
    }

    $('body').append(form);
    form.submit();
}