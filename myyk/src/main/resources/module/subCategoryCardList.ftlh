<#-- 서브 카테고리 카드 -->
<#list holder.subCategoryList as subCategory>
<div class="card sub-category-card mb-2" data-sub-category-idx="${subCategory.subCategoryIdx}">
  <div class="card-body position-relative">
    <div class="d-inline">${subCategory.subCategoryName}</div>
    <div class="d-inline position-absolute top-50 end-0 translate-middle-y pe-3">
      <span class="update-sub-category me-3" role="button"><i class="bi bi-gear-fill"></i></span>
      <span class="delete-sub-category me-3" role="button" data-bs-toggle="modal" data-bs-target="#delete-sub-category-modal" onclick="deleteSubCategory($(this))"><i class="bi bi-x-lg"></i></span>
    </div>
  </div>
</div>
</#list>