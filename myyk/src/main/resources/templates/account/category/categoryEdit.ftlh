<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh">
<title><@msg "global.title"/></title>
<link rel="stylesheet" href="/css/account.css"/>
</head>
<#include "/header.ftlh">
<body>
  <div id="content">
    <div id="wrapper">

      <h3 class="title">
        <@msg "category.edit"/>
      </h3>

      <div class="mb-3">
        <button id="create-category-button" class="btn btn-primary">
          <i class="bi bi-plus-lg"></i>&nbsp;<@msg "category.create.name"/>
        </button>
      </div>

      <form method="POST">

        <#-- 카테고리 카드 홀더 -->
        <#if holder.categoryList?has_content>
        <div id="category-list-holder">
          <#list holder.categoryList as category>
          <#-- 카테고리 카드 -->
          <div class="card mb-2 category-card" data-idx="${category.categoryIdx}">

            <div class="card-body">
              <@setLanguage selected_language category.categoryNameKr category.categoryNameJp/>
              <div class="d-inline position-absolute end-0 pe-3">
                <span class="me-3" role="button"><i class="bi bi-caret-down-fill arrow-icon" data-next-icon="bi-caret-up-fill"></i></span>
                <span class="me-3" role="button"><i class="bi bi-gear-fill"></i></span>
                <span role="button"><i class="bi bi-x-lg"></i></span>
              </div>
            </div>

            <#-- 서브 카테고리 카드 홀더 -->
            <div id="sub-category-list-holder-for-${category.categoryIdx}" class="collapse" data-bs-parent="#category-list-holder">
              <div class="accordion-body">
                <#-- 서브 카테고리 생성 버튼 -->
                <hr>
                <a id="create-sub-category-button" class="btn btn-primary mb-3">
                  <i class="bi bi-plus-lg"></i>&nbsp;<@msg "category.sub.create.name"/>
                </a>
                <#-- 서브 카테고리 리스트 -->
                <div class="sub-category-wrap"><#-- 이곳에 삽입 --></div>
              </div>
            </div>
          </div>
          </#list>
        </div>
        </#if>

      </form>

      <@backBtnWithUrl "/account"/>

    </div>
  </div>

  <#-- 서브 카테고리 생성 모달 -->
  <div class="modal fade" id="create-sub-category-modal" aria-labelledby="create-sub-category-modal-label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div id="create-sub-category-modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="create-sub-category-modal-label"><@msg 'category.sub.create.name'/></h1>
            <h1 class="modal-title fs-5" id="update-sub-category-modal-label"><@msg 'category.sub.update.name'/></h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <#-- 카테고리 인덱스 -->
            <input type="hidden" name="categoryIdx">
            <#-- 서브 카테고리 인덱스 -->
            <input type="hidden" name="subCategoryIdx">
            <#-- 제한 초과 에러 메세지 -->
            <div class="invalid-feedback mb-3" data-error-code="EE_SC_108"><@msg 'category.sub.error.limit'/></div>

            <#-- 서브 카테고리 -->
            <div class="mb-3">
              <label class="form-label"><@msg 'category.sub.nameLang.${selected_language}'/></label>
              <input type="text" class="form-control" name="subCategoryName${selected_language?capitalize}">
              <div class="invalid-feedback" data-error-code="EE_SC_102"><@msg 'category.sub.error.nameEmpty'/></div>
              <div class="invalid-feedback" data-error-code="EE_SC_103"><@msg 'category.sub.error.nameMax'/></div>
              <div class="invalid-feedback" data-error-code="EE_SC_104"><@msg 'category.sub.error.nameDupl'/></div>
            </div>
            <#-- 서브 카테고리 (타언어) -->
            <div class="mb-3">
              <label class="form-label"><@msg 'category.sub.nameLang.${unselected_language}'/></label>
              <input type="text" class="form-control" name="subCategoryName${unselected_language?capitalize}">
              <div class="invalid-feedback" data-error-code="EE_SC_105"><@msg 'category.sub.error.nameEmpty'/></div>
              <div class="invalid-feedback" data-error-code="EE_SC_106"><@msg 'category.sub.error.nameMax'/></div>
              <div class="invalid-feedback" data-error-code="EE_SC_107"><@msg 'category.sub.error.nameDupl'/></div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"><@msg 'global.close'/></button>
            <button type="button" class="btn btn-primary"><@msg 'global.confirm'/></button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <#-- 서브 카테고리 생성 완료 모달 -->
  <div class="modal fade" id="create-complete-sub-category-modal" aria-labelledby="create-complete-sub-category-modal-label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div id="create-complete-sub-category-modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="create-complete-sub-category-modal-label"><@msg 'category.sub.create.complete.name'/></h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <@msg 'category.sub.create.complete.info'/>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"><@msg 'global.close'/></button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <#-- 서브 카테고리 수정 완료 모달 -->
  <div class="modal fade" id="update-complete-sub-category-modal" aria-labelledby="update-complete-sub-category-modal-label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div id="update-complete-sub-category-modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="update-complete-sub-category-modal-label"><@msg 'category.sub.update.complete.name'/></h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <@msg 'category.sub.update.complete.info'/>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"><@msg 'global.close'/></button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <#-- 서브 카테고리 수정 열람 실패 모달 -->
  <div class="modal fade" id="update-fail-sub-category-modal" aria-labelledby="update-fail-sub-category-modal-label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div id="update-fail-sub-category-modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="delete-fail-sub-category-modal-label"><@msg 'category.sub.update.fail.name'/></h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <@msg 'category.sub.update.fail.info'/>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"><@msg 'global.close'/></button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <#-- 서브 카테고리 삭제 모달 -->
  <div class="modal fade" id="delete-sub-category-modal" aria-labelledby="delete-sub-category-modal-label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">

        <#-- 카테고리 인덱스 -->
        <input type="hidden" name="categoryIdx">
        <#-- 서브 카테고리 인덱스 -->
        <input type="hidden" name="subCategoryIdx">

        <div id="delete-sub-category-modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="complete-sub-category-modal-label"><@msg 'category.sub.delete.name'/></h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <@msg 'category.sub.delete.info'/>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"><@msg 'global.close'/></button>
            <button type="button" class="btn btn-primary"><@msg 'global.confirm'/></button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <#-- 서브 카테고리 삭제 완료 모달 -->
  <div class="modal fade" id="delete-complete-sub-category-modal" aria-labelledby="delete-complete-sub-category-modal-label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div id="delete-complete-sub-category-modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="delete-complete-sub-category-modal-label"><@msg 'category.sub.delete.complete.name'/></h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <@msg 'category.sub.delete.complete.info'/>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"><@msg 'global.close'/></button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <#-- 서브 카테고리 삭제 실패 모달 -->
  <div class="modal fade" id="delete-fail-sub-category-modal" aria-labelledby="delete-fail-sub-category-modal-label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div id="delete-fail-sub-category-modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="delete-fail-sub-category-modal-label"><@msg 'category.sub.delete.fail.name'/></h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <@msg 'category.sub.delete.fail.info'/>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"><@msg 'global.close'/></button>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>
<#include "/footer.ftlh">
<script src="/js/category.js"></script>
<script src="/js/subCategory.js"></script>
</html>
