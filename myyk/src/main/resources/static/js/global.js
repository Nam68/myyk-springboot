/**
 * 공통기능
 */
function preventDoubleClick(button) {
    button.addClass('btn-disabled');
}

// 라벨 클릭 등으로 체크박스 값이 변했을 때 체크박스 이미지도 변경
$(document).on('change', '.my-checkbox-holder :checkbox', function () {

    const input = $(this);
    const holder = input.parent();
    const checkbox = holder.find('.my-checkbox');
    
    const hasClass = checkbox.hasClass('checked');
    const checked = input.prop('checked');
    
    if (checked && !hasClass) {
        checkbox.addClass('checked');
    } else if (!checked && hasClass) {
        checkbox.removeClass('checked');
    }
    
});

// 체크박스 이미지 클릭으로 진짜 체크박스 값 변경
function checkboxToggle(checkbox) {

    const holder = checkbox.parent();
    const input = holder.find(':checkbox');
    const checked = checkbox.hasClass('checked');

    if (checked) {
        input.prop('checked', false);
        checkbox.removeClass('checked');
    } else {
        input.prop('checked', true);
        checkbox.addClass('checked');
    }
}

// 체크박스가 체크된 상태로 화면이 로드될 때 체크박스 이미지에도 체크 추가
$(function() {
    $('.my-checkbox-holder :checkbox').toArray().forEach(input => {

        const checked = $(input).prop('checked');
        const checkbox = $(input).parent().find('.my-checkbox');

        if (checked) {
            checkbox.addClass('checked');
        }
    });
});

/**
 * CSS 제어
 */

// 입력 로딩 화면
function openLoading() {
    centerAlignDiv($('#loading-spinner'), 'flex');
    $('#loading-modal').css('display', 'flex');
    $('#loading-spinner').css('display', 'flex');
}
function closeLoading() {
    $('#loading-modal').css('display', 'none');
    $('#loading-spinner').css('display', 'none');
}

// 타깃을 화면 정가운데로 정렬
function centerAlignDiv(target, position) {
    let width = target.width();
    let height = target.height();

    let screenX = $(window).width();
    let screenY = $(window).height();
    
    let newWidth = (screenX / 2) - (width / 2);
    let newHeight = (screenY / 2) - (height / 2);

    target.css('position', position);
    target.css('left', newWidth);
    target.css('top', newHeight);
}

// data-next-icon이 있는 경우 다음 아이콘을 세팅한다.
function setNextIcon(target) {

    let nextIcon = target.data().nextIcon;

    if (nextIcon == undefined) {
        nextIcon = target.attr('data-nextIcon');
        if (nextIcon == undefined) {
            return false;
        }
    }

    let iconClassStartWith = 'bi ';         // 아이콘 시작 문자열
    let iconClassEndWith = ' ';             // 아이콘 종료 문자열

    let targetClass = target.attr('class');   // 아이콘 전체 클래스

    let firstIndex = targetClass.indexOf(iconClassStartWith) + iconClassStartWith.length; // 더하기가 없으면 bi 도 포함되기 때문
    let iconClass = targetClass.substring(firstIndex, targetClass.length);
    
    
    let secondIndex = iconClass.indexOf(iconClassEndWith) > 0 ? iconClass.indexOf(iconClassEndWith) : iconClass.length;
    let currentIcon = iconClass.substring(0, secondIndex); // 현재 아이콘

    target.data('nextIcon', currentIcon);
    target.attr('data-next-icon', currentIcon);

    target.attr('class', targetClass.replace(currentIcon, nextIcon));
}

/**
 * 서브밋 제어
 */

function mySubmit() {

    openLoading();

    const form = $('form');

    // DEBUG CODE
    // form.find('input').toArray().forEach(input => alert($(input).attr('name')));

    if (form.length > 1 || form.length <= 0) {
        alert(globalError);
        return false;
    }
    form.submit();
    closeLoading();
}

function mySubmitWithParam(action, parameters) {

    openLoading();

    const form = $('<form>', {action:action, method:'POST'});

    for (var key in parameters) {
        alert(key + ' = ' + parameters[key]);
        form.append($('<input>', {name:key, value:parameters[key]}));
    }

    $('body').append(form);
    form.submit();
    closeLoading();
}

function backWithUrl(url) {

    openLoading();

    const form = $('form');
    if (form.length > 1 || form.length <= 0) {
        alert(globalError);
        return false;
    }
    form.attr('action', url);
    form.submit();
    closeLoading();
}

// 모달 인스턴스를 반환한다.
function getModal(modalId) {
    return new bootstrap.Modal('#' + modalId, {focus:true});
}

// 모달의 ajax에 보낼 변수를 반환한다.
function getParametersForModal(modalId) {

    let data = new Object();
    let modalInputs = $('#' + modalId).find('input');

    modalInputs.map(function () {
        let name = $(this).attr('name');
        let value = $(this).val();

        // 값이 세팅된 경우만 세팅
        // int 등 빈값으로 세팅할 수 없는 자료형을 위해
        if (!$.isEmptyObject(value)) {
            data[name] = value;
        }
    });
    return data;
}

// 모달의 ajax를 송신한다.
function returnModalAjaxResult(url, modalId) {

    let data = getParametersForModal(modalId);

    return $.ajax({
        url:url,
        method:'POST',
        data:data
    });
}

// data를 변수로 받아 ajax를 송신한다.
function returnAjaxResult(url, data) {
    return $.ajax({
        url:url,
        method:'POST',
        data:data
    });
}

// ajax가 에러인지 아닌지 판단한다.
// 에러인 경우 : 에러 코드 배열을 반환
// 에러가 아닌 경우 : false를 반환
function getErrorCodesForApi(json) {

    // 단순 성공여부 반환하는 JSON인 경우
    if (isSuccess(json)) {
        return false;
    }

    // json 타입이 아닌 경우 파싱
    if (json.isError == undefined || json.isError != true) {
        return false;
    }
    return json.codes;
}

// API가 성공인지 판단
function isSuccess(response) {
    if (typeof json == 'string') {
        return response == 'SUCCESS';
    } else {
        return response.isSuccess;
    }
}

// ajax를 통해 얻은 에러 코드로 에러 메시지를 표시한다.
function setErrorMsg(errorCodes) {
    // TODO
    errorCodes.map(function () {
        let errorCode = JSON.stringify($(this));
        errorOn(errorCode);
    });
}

// ajax를 통해 얻은 에러 코드로 에러 메시지를 표시한다(단, 표시범위를 모달로 한정).
function setErrorMsgForModal(errorCodes, modalId) {
    errorCodes.forEach(errorCode => {
        const errorMsgHolder = $('#' + modalId + ' [data-error-code=' + errorCode + ']');
        const errorInput = errorMsgHolder.parent().find('.form-control');
        errorInput.addClass('is-invalid');
        errorInput.parent().find('.invalid-feedback').hide();
        errorMsgHolder.show();
    });
}

// 모달 초기화
function initModal(modalId) {
    let inputs = $('#' + modalId).find('input').toArray();
    inputs.forEach(input => {
        $(input).val('');                   // 입력 삭제
        $(input).removeClass('is-invalid'); // 에러 클래스 삭제
    });
}

/**
 * 부트스트랩 제어
 */

// 콜랩스 열기
function showCollapse(collapseId) {
    const myCollapse = new bootstrap.Collapse('#' + collapseId, {toggle: false});
    myCollapse.show();
}

// 콜랩스 닫기
function hideCollapse(collapseId) {
    const myCollapse = new bootstrap.Collapse('#' + collapseId, {toggle: false});
    myCollapse.hide();
}

// 콜랩스 토글
function toggleCollapse(collapseId) {
    const collapse = $('#' + collapseId);
    const myCollapse = new bootstrap.Collapse('#' + collapseId, {toggle: false});
    if (collapse.attr('class').includes('show')) {
        myCollapse.hide();
    } else {
        myCollapse.show();
    }
}

/**
 * 
 * 원래 lib.ftlh에 있었던 함수들
 * lib.ftlh에 있었던 이유가 파악되기 전까지 여기에 수납
 * 이유가 파악되었다면 다시 lib.ftlh에 옮기고 그쪽에 있는 이유를 코멘트로 남기기
 * 
 */

// 부트스트랩 아이콘 HTML 코드를 반환
function getIcon(icon) {
    return iconHtml.replace(/%s/g, icon);
}

// ajax 에러 메시지 초기화
function allErrorOff() {
    $('.caution').map(function () {
        let errorCode = $(this).attr('data-code');
        if (errorCode != undefined && errorCode != '') {
            $(this).addClass('error-off');
        }
    });
}

// ajax 에러 메시지 보이기
function errorOn(errorCode) {
    $('[data-code=' + errorCode + ']').removeClass('error-off');
}
