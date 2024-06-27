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

      <form method="POST">

        <#-- 카테고리 카드 홀더 -->
        <#if holder.categoryList?has_content>
        <div id="category-list-holder">
          <#list holder.categoryList as category>
          <#-- 카테고리 카드 -->
          <div class="card mb-2 category-card" data-idx="${category.categoryIdx}">

            <div class="card-body">
              <@setLanguage selected_language category.categoryNameKo category.categoryNameJp/>
              <div class="d-inline position-absolute end-0 pe-3">
                <span class="me-3" role="button"><i class="bi bi-caret-down-fill" data-next-icon="bi-caret-up-fill"></i></span>
                <span class="me-3" role="button"><i class="bi bi-gear-fill"></i></span>
                <span role="button"><i class="bi bi-x-lg"></i></span>
              </div>
            </div>

            <#-- 서브 카테고리 카드 홀더 -->
            <div id="sub-category-list-holder-for-${category.categoryIdx}" class="collapse" data-bs-parent="#category-list-holder">
              <div class="accordion-body">
              <#if category.subCategoryList?has_content>
                <#list category.subCategoryList?keys as subCategoryIdx>
                <#-- 서브 카테고리 카드 -->
                <div class="card sub-category-card mb-2">
                  <div class="card-body position-relative">
                    <div class="d-inline">${category.subCategoryList[subCategoryIdx]}</div>
                    <div class="d-inline position-absolute top-50 end-0 translate-middle-y pe-3">
                      <span class="update-sub-category me-3" role="button" data-sub-category-idx="${subCategoryIdx}"><i class="bi bi-gear-fill"></i></span>
                      <span class="delete-sub-category me-3" role="button" data-sub-category-idx="${subCategoryIdx}"><i class="bi bi-x-lg"></i></span>
                    </div>
                  </div>
                </div>
                </#list>
              </#if>

                <#-- 서브 카테고리 생성 카드 -->
                <div class="card create-sub-category-card mb-2" role="button">
                  <div class="card-body position-relative">
                    <div class="d-inline" role="button"><i class="bi bi-plus-lg"></i>&nbsp;<@msg "category.sub.create.name"/></div>
                  </div>
                </div>

              </div>
            </div>
          </div>
          </#list>
        </div>
        </#if>

        <#-- 카테고리 생성 카드 -->
        <div id="create-category-card" class="card mt-2 mb-2">
          <div class="card-body position-relative" role="button">
            <div class="d-inline"><i class="bi bi-plus-lg"></i>&nbsp;<@msg "category.create.name"/></div>
          </div>
        </div>

      </form>

      <@backBtnWithUrl "/account"/>

    </div>
  </div>

  <#-- 서브 카테고리 생성 모달 -->
  <div class="modal fade" id="create-sub-category-modal" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="create-sub-category-modal-label"><@msg 'category.sub.create.name'/></h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <#-- 카테고리 인덱스 -->
          <input type="hidden" name="categoryIdx">
          <#-- 서브 카테고리 인덱스 -->
          <input type="hidden" name="subCategoryIdx">
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

</body>
<#include "/footer.ftlh">
<script src="/js/account.js"></script>
</html>
