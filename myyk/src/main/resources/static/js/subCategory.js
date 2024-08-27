const CREATE_MODAL = 'create-sub-category-modal';
const CREATE_MODAL_LABEL = 'create-sub-category-modal-label';
const CREATE_COMPLETE_MODAL = 'create-complete-sub-category-modal';
const UPDATE_MODAL_LABEL = 'update-sub-category-modal-label';
const UPDATE_COMPLETE_MODAL = 'update-complete-sub-category-modal'
const UPDATE_FAIL_MODAL = 'update-fail-sub-category-modal';
const DELETE_MODAL = 'delete-sub-category-modal';
const DELETE_COMPLETE_MODAL = 'delete-complete-sub-category-modal';
const DELETE_FAIL_MODAL = 'delete-fail-sub-category-modal';

let createModal = getModal(CREATE_MODAL);
let deleteModal = getModal(DELETE_MODAL);
let createCompleteModal = getModal(CREATE_COMPLETE_MODAL);
let updateCompleteModal = getModal(UPDATE_COMPLETE_MODAL);
let deleteCompleteModal = getModal(DELETE_COMPLETE_MODAL);
let updateFailteModal = getModal(UPDATE_FAIL_MODAL);
let deleteFailteModal = getModal(DELETE_FAIL_MODAL);

// 서브카테고리 콜랩스 열기
$('.bi-caret-down-fill').on('click', async function () {

    const categoryCard = $(this).parents('.category-card');
    const targetSubCategoryHolder = categoryCard.find('.collapse');

    // 모든 콜랩스의 화살표를 원래대로 되돌린다
    $('i.bi-caret-up-fill').removeClass('bi-caret-up-fill').addClass('bi-caret-down-fill').data('nextIcon', 'bi-caret-up-fill');

    // 콜랩스가 열려 있는 상태라면 처리를 하지 않음
    if (targetSubCategoryHolder.hasClass('show')) {

        toggleCollapse(targetSubCategoryHolder.attr('id'));
        return false;
    }

    try {
        openLoading();

        // 서브 카테고리 리스트 로드
        let categoryIdx = categoryCard.data('idx');
        let result = await getSubCategoryList(categoryIdx);
        insertSubCategoryHtml(categoryCard, result);

        // 화살표 아이콘 변경
        setNextIcon($(this));

        // 콜랩스 열기
        toggleCollapse(targetSubCategoryHolder.attr('id'));

    } catch (error) {
        alert(globalError);
    } finally {
        closeLoading();
    }
});

// 서브 카테고리 생성 모달 열기
$(document).on('click', '#create-sub-category-button', function () {
    setCategoryIdx(CREATE_MODAL, $(this));
    toggleCreateUpdateModal(true);
    createModal.show();
});

// 서브 카테고리 생성 모달 열기 (업데이트)
$(document).on('click', '.update-sub-category', async function() {

    openLoading();

    let subCategoryIdx = setSubCategoryIdx(CREATE_MODAL, $(this));

    try {
        let url = '/category/sub/find';
        let data = {subCategoryIdx:subCategoryIdx};
        let result = await returnAjaxResult(url, data);

        // api 에러처리
        let errorCodes = getErrorCodesForApi(result);
        if (errorCodes != false) {
            createModal.hide();
            updateFailteModal.show();
            return;
        }

        // 수신된 값을 세팅
        const koInput = $('#' + CREATE_MODAL).find('input[name=subCategoryNameKo]');
        const jpInput = $('#' + CREATE_MODAL).find('input[name=subCategoryNameJp]');
        const categoryIdx = $('#' + CREATE_MODAL).find('[name=categoryIdx]');
        koInput.val(result.dto.subCategoryNameKo);
        jpInput.val(result.dto.subCategoryNameJp);
        categoryIdx.val(result.dto.categoryIdx);

        toggleCreateUpdateModal(false);
        createModal.show();

    } catch (error) {
        alert(globalError);
    } finally {
        closeLoading();
    }
});

// 서브 카테고리 생성 클릭
$('#' + CREATE_MODAL + ' .btn-primary').on('click', async function () {
    try {
        openLoading();

        let url = isCreateModal() ? '/category/sub/create' : '/category/sub/update';
        let result = await returnModalAjaxResult(url, CREATE_MODAL);

        // api 에러처리
        let errorCodes = getErrorCodesForApi(result);
        if (errorCodes != false) {
            setErrorMsgForModal(errorCodes, CREATE_MODAL);
            return false;
        }

        // 서브 카테고리 리스트 로드
        let categoryIdx = $(this).parents('.modal-content').find('[name=categoryIdx]').val();
        let subCategoryList = await getSubCategoryList(categoryIdx);
        let categoryCard = $('.category-card[data-idx=' + categoryIdx + ']');
        insertSubCategoryHtml(categoryCard, subCategoryList);

        // 완료 모달
        let completeModalId = isCreateModal() ? createCompleteModal : updateCompleteModal;
        createModal.hide();
        completeModalId.show();

    } catch (error) {
        alert(globalError);
    } finally {
        closeLoading();
    }
});

// 서브 카테고리 생성 모달이 닫힐 때 내용 삭제
$('#' + CREATE_MODAL).on('hidden.bs.modal', function() {
    initModal(CREATE_MODAL);
});

// 서브 카테고리 삭제 모달이 열릴 때 서브 카테고리 인덱스 설정
function deleteSubCategory(targetElement) {
    setCategoryIdx(DELETE_MODAL, targetElement);
    setSubCategoryIdx(DELETE_MODAL, targetElement);
}

// 서브 카테고리 삭제 클릭
$('#' + DELETE_MODAL + ' .btn-primary').on('click', async function () {
    try {
        openLoading();

        let url = '/category/sub/delete';
        let result = await returnModalAjaxResult(url, DELETE_MODAL);

        // api 에러처리
        let errorCodes = getErrorCodesForApi(result);
        if (errorCodes != false) {
            deleteModal.hide();
            deleteFailteModal.show();
            return;
        }

        // 서브 카테고리 리스트 로드
        let categoryIdx = $(this).parents('.modal-content').find('[name=categoryIdx]').val();
        let subCategoryList = await getSubCategoryList(categoryIdx);
        let categoryCard = $('.category-card[data-idx=' + categoryIdx + ']');
        insertSubCategoryHtml(categoryCard, subCategoryList);

        // 완료 모달
        deleteModal.hide();
        deleteCompleteModal.show();

    } catch (error) {
        alert(globalError);
    } finally {
        closeLoading();
    }
});

// 서브 카테고리 리스트 html 입력
function insertSubCategoryHtml(categoryCard, result) {
    // 에러 확인
    if (result.html == undefined) {
        throw new Error(htmlApiError);
    }
    categoryCard.find('.accordion-body .sub-category-wrap').html(result.html);
}

// 각종 모달에 카테고리 인덱스 전달
function setCategoryIdx(modalId, targetElement) {
    const categoryIdxInput = $('#' + modalId + ' [name=categoryIdx]');
    let categoryIdx = targetElement.parents('.category-card').data('idx');
    categoryIdxInput.val(categoryIdx);

    return categoryIdx;
}

// 각종 모달에 서브 카테고리 인덱스 전달
function setSubCategoryIdx(modalId, targetElement) {
    const subCategoryIdxInput = $('#' + modalId + ' [name=subCategoryIdx]');
    let subCategoryIdx = targetElement.parents('.sub-category-card').data('subCategoryIdx');
    subCategoryIdxInput.val(subCategoryIdx);

    return subCategoryIdx;
}

// 서브 카테고리 생성/수정 모달 전환
function toggleCreateUpdateModal(isCreate) {
    let showLabelId = isCreate ? CREATE_MODAL_LABEL : UPDATE_MODAL_LABEL;
    let hideLabelId = isCreate ? UPDATE_MODAL_LABEL : CREATE_MODAL_LABEL;

    $('#' + showLabelId).show();
    $('#' + hideLabelId).hide();
}

// 서브 카테고리 생성 모달인지 수정 모달인지 판단
function isCreateModal() {
    let categoryIdx = $('#' + CREATE_MODAL).find('input[name=categoryIdx]').val();
    let subCategoryIdx = $('#' + CREATE_MODAL).find('input[name=subCategoryIdx]').val();
    
    if ($.isNumeric(subCategoryIdx) && $.isNumeric(categoryIdx)) {
        return false;
    }
    if ($.isNumeric(categoryIdx) && subCategoryIdx == '') {
        return true;
    }
    throw new Error('Category index or sub category idx are not defined.');
}

// 카테고리에 속한 서브 카테고리 리스트를 가져오는 ajax
function getSubCategoryList(categoryIdx) {

    let url = '/category/sub/search/card';
    let data = new Object();
    data['categoryIdx'] = categoryIdx;

    return $.ajax({
        url:url,
        method:'POST',
        data:data,
    });
}
