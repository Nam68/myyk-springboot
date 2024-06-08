<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include '/lib.ftlh'>
<title><@msg 'global.title'/></title>
<link rel="stylesheet" href="/css/account.css"/>
</head>
<#include '/header.ftlh'>
<body>
  <div id="content">
    <div id="wrapper">

      <h3 class="title">
        <@msg 'category.sub.edit'/>
      </h3>

      <form action="/account/category/edit" method="POST">
        <#-- 카테고리 -->
        <div class="mb-4">
          <label class="form-label"><@msg 'category.name'/></label>
          <div>${holder.categoryName} categoryName(35) </div>
          <@errorMsg ['EE_SC_101'] 'category.sub.error.category'/>
        </div>

        <#-- 서브 카테고리 리스트 -->
        <div class="mb-5" id="sub-category-list-holder">
          <#-- 서브 카테고리 -->
          <#list holder.subCategoryList as sc>
          <div class="card mb-2">
            <div class="card-body position-relative">
              <div class="d-inline">
                <@setLanguage selected_language sc.subCategoryNameKo sc.subCategoryNameJp/>
              </div>
              <div class="d-inline position-absolute top-50 end-0 translate-middle-y pe-3">
                <span class="update-sub-category me-3" role="button" data-sub-category-idx="${sc.subCategoryIdx}"><i class="bi bi-gear-fill"></i></span>
                <span class="delete-sub-category"      role="button" data-sub-category-idx="${sc.subCategoryIdx}"><i class="bi bi-x-lg"></i></span>
              </div>
            </div>
          </div>
          </#list>
          
          
          <div class="card mb-2">
            <div class="card-body position-relative">
              <div class="d-inline">
                asdfsdfd
              </div>
              <div class="d-inline position-absolute top-50 end-0 translate-middle-y pe-3">
                <span class="update-sub-category me-3" role="button" data-sub-category-idx="123"><i class="bi bi-gear-fill"></i></span>
                <span class="delete-sub-category"      role="button" data-sub-category-idx="123"><i class="bi bi-x-lg"></i></span>
              </div>
            </div>
          </div>
          
          <div class="card mt-2 mb-2">
            <div class="card-body position-relative" data-idx="123">
              <div class="d-inline">
                asdfsdfd
              </div>
              <div class="d-inline position-absolute top-50 end-0 translate-middle-y pe-3">
                <span class="update-sub-category me-3" role="button" data-sub-category-idx="abc"><i class="bi bi-gear-fill"></i></span>
                <span class="delete-sub-category"      role="button" data-sub-category-idx="abc"><i class="bi bi-x-lg"></i></span>
              </div>
            </div>
           </div>

          <#-- 서브 카테고리 생성 -->
          <div class="card mt-2 mb-2">
            <div class="card-body position-relative" role="button" data-bs-toggle="modal" data-bs-target="#create-sub-category-modal">
              <div class="d-inline"><i class="bi bi-plus-lg"></i>&nbsp;<@msg 'category.sub.create.name'/></div>
            </div>
          </div>

        </div>
      </form>

      <@backBtnWithUrl '/account/category/edit'/>

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
              <input type="hidden" name="categoryIdx" value="35">
              <input type="hidden" name="asdfsdf" value="${holder.categoryIdx}">
              <#-- 서브 카테고리 인덱스 -->
              <input type="hidden" name="subCategoryIdx">
              <#-- 서브 카테고리 -->
              <div class="mb-3">
                <label class="form-label"><@msg 'category.sub.nameLang.${selected_language}'/></label>
                <input type="text" class="form-control" name="subCategoryName${selected_language?capitalize}" value="<@setLanguage '${selected_language}' '${holder.subCategoryNameKo}' '${holder.subCategoryNameJp}'/>">
                <div class="invalid-feedback" data-error-code="EE_SC_102"><@msg 'category.sub.error.nameEmpty'/></div>
                <div class="invalid-feedback" data-error-code="EE_SC_103"><@msg 'category.sub.error.nameMax'/></div>
                <div class="invalid-feedback" data-error-code="EE_SC_104"><@msg 'category.sub.error.nameDupl'/></div>
              </div>
              <#-- 서브 카테고리 (타언어) -->
              <div class="mb-3">
                <label class="form-label"><@msg 'category.sub.nameLang.${unselected_language}'/></label>
                <input type="text" class="form-control" name="subCategoryName${unselected_language?capitalize}" value="<@setLanguage '${unselected_language}' '${holder.subCategoryNameKo}' '${holder.subCategoryNameJp}'/>">
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
      
      <#-- 서브 카테고리 삭제 모달 -->
      <div class="modal fade" id="delete-sub-category-modal" aria-labelledby="delete-sub-category-modal-label" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="delete-sub-category-modal-label"><@msg 'category.sub.delete.name'/></h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <#-- 서브 카테고리 인덱스 -->
              <input type="text" name="subCategoryIdx">
              <@msg 'global.alert.delete.info'/>
              <br>
              <@msg 'global.alert.delete.confirm'/>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"><@msg 'global.close'/></button>
              <button type="button" class="btn btn-primary"><@msg 'global.confirm'/></button>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
</body>
<#include '/footer.ftlh'>
<script src="/js/account.js"></script>
</html>
