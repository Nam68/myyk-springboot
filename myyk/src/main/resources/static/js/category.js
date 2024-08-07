// 카테고리 등록
$('#create-category-button').on('click', function () {
    location.href='/account/category/create/input';
});

// 아이콘 선택
$('.category-icon-dropdown-item li').on('click', function () {

    // 아이콘 이름을 인풋에 세팅
    let icon = $(this).find('i').data('icon');
    $('[name=categoryIcon]').val(icon);

    // 직접입력 창을 클릭한 것이 아닐 때
    if (icon != undefined) {
        closeCollapse('icon-collapse');
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
        beforeSend: function () {
            openLoading();
        }
    })
    .done(function () {

        allErrorOff();
        let errorCodes = getErrorCodesForApi(result);

        if (errorCodes == false) {
            setErrorMsg(errorCodes);
        } else {
            $('#category-icon-holder').html(getIcon(iconName));
            hideCollapse('icon-collapse');
        }
    })
    .fail(function () {
        alert(globalError);
    })
    .always(function () {
        closeLoading();
    });
});

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
