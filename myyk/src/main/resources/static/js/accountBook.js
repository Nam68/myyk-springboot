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


/*
    가계부 카테고리
*/
const CATEGORY_SET_HOLDER = '.category-set-holder';
const CATEGORY_HOLDER = '.category-holder';
const SUB_CATEGORY_HOLDER = '.sub-category-holder';
const CATEGORY_CHECKBOX = CATEGORY_HOLDER + ' :checkbox';
const SUB_CATEGORY_CHECKBOX = SUB_CATEGORY_HOLDER + ' :checkbox';

// 카테고리 선택이 안 되어있는 서브 카테고리를 선택 취소 및 사용불가로 전환
$(function() {
    $(CATEGORY_CHECKBOX).toArray().forEach(checkbox => {

        const categoryCheckbox = $(checkbox);

        // 서브 카테고리 체크박스 획득
        const setHolder = categoryCheckbox.parents(CATEGORY_SET_HOLDER);
        const subCategoryCheckbox = setHolder.find(SUB_CATEGORY_CHECKBOX);
        
        if (categoryCheckbox.is(':checked')) {
            // 서브 카테고리 체크박스 디스에이블드 해제
            subCategoryCheckbox.toArray().forEach(checkbox => {
                $(checkbox).prop('checked', false).prop('disabled', false).change();
            });
        } else {
            // 서브 카테고리 체크박스 디스에이블드 추가
            subCategoryCheckbox.toArray().forEach(checkbox => {
                $(checkbox).prop('checked', false).prop('disabled', true).change();
            });
        }
    });
});

// 카테고리 선택을 취소하면 서브 카테고리도 취소
$(CATEGORY_CHECKBOX).on('change', function() {

    const categoryCheckbox = $(this);

    // 서브 카테고리 체크박스 획득
    const setHolder = categoryCheckbox.parents(CATEGORY_SET_HOLDER);
    const subCategoryCheckbox = setHolder.find(SUB_CATEGORY_CHECKBOX);

    if (categoryCheckbox.is(':checked')) {
        // 서브 카테고리 체크박스 디스에이블드 해제
        subCategoryCheckbox.toArray().forEach(checkbox => {
            $(checkbox).prop('checked', false).prop('disabled', false).change();
        });
    } else {
        // 서브 카테고리 체크박스 전부 해제
        subCategoryCheckbox.toArray().forEach(checkbox => {
            $(checkbox).prop('checked', false).prop('disabled', true).change();
        });
    }
});

// TODO 0925 위에거 만들고, 카테고리 이프 체크드 만들고(이건 완료), 가계부 만들 때 기본 카테고리 설정되도록 수정
// TODO 0926 기본 카테고리 선택 취소하면 서브도 취소 -> 인풋 에러 플로우 -> 컨펌화면 -> 가계부 생성시 기본카테고리 자동 추가