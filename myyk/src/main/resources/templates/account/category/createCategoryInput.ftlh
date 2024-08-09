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
        <@msg "category.create.name"/>
      </h3>

      <form action="/account/category/create/confirm" method="POST">

        <#-- 카테고리 -->
        <div class="mb-5">
          <label class="form-label"><@msg "category.nameLang.${selected_language}"/></label>
          <input type="text" class="form-control<@error ['EE_CA_101', 'EE_CA_102', 'EE_CA_103']/>" name="categoryName${selected_language?capitalize}" value="<@setLanguage '${selected_language}' '${holder.categoryNameKo}' '${holder.categoryNameJp}'/>">
          <@errorMsg ['EE_CA_101'] 'category.error.nameEmpty'/>
          <@errorMsg ['EE_CA_102'] 'category.error.nameMax'/>
          <@errorMsg ['EE_CA_103'] 'category.error.nameDupl'/>
        </div>

        <#-- 카테고리 (타언어) -->
        <div class="mb-5">
          <label class="form-label"><@msg "category.nameLang.${unselected_language}"/></label>
          <input type="text" class="form-control<@error ['EE_CA_104', 'EE_CA_105', 'EE_CA_106']/>" name="categoryName${unselected_language?capitalize}" value="<@setLanguage '${unselected_language}' '${holder.categoryNameKo}' '${holder.categoryNameJp}'/>">
          <@errorMsg ['EE_CA_104'] 'category.error.nameEmpty'/>
          <@errorMsg ['EE_CA_105'] 'category.error.nameMax'/>
          <@errorMsg ['EE_CA_106'] 'category.error.nameDupl'/>
        </div>

        <#-- 아이콘 -->
        <div class="mb-5">
          <label class="form-label"><@msg "category.icon.name"/></label>
          <#-- 아이콘 메뉴 시작 -->
          <div class="dropdown category-icon-dropdown">
            <a class="category-icon-dropdown-item btn btn-outline-primary dropdown-toggle text-start" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              <i id="category-icon-holder"<#if holder.categoryIcon?has_content> class="bi bi-${holder.categoryIcon}"</#if>><#if !holder.categoryIcon?has_content>&nbsp;-&nbsp;</#if></i>
            </a>
            <ul class="dropdown-menu category-icon-dropdown-item">
              <li><a class="dropdown-item primary-color" role="button" data-bs-toggle="collapse" href="#icon-collapse" aria-expanded="false" aria-controls="icon-collapse"><i class="bi bi-plus-lg"></i>&nbsp;<@msg "category.icon.noHope"/></a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-basket2" data-icon="basket2"></i> basket2</a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-box-seam" data-icon="box-seam"></i> box-seam</a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-airplane-engines" data-icon="airplane-engines"></i> airplane-engines</a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-cake" data-icon="cake"></i> cake</a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-camera-reels" data-icon="camera-reels"></i> camera-reels</a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-car-front" data-icon="car-front"></i> car-front</a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-credit-card" data-icon="credit-card"></i> credit-card</a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-cup-hot" data-icon="cup-hot"></i> cup-hot</a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-gift" data-icon="gift"></i> gift</a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-hospital" data-icon="hospital"></i> hospital</a></li>
              <li><a class="dropdown-item primary-color" role="button"><i class="bi bi-house" data-icon="house"></i> house</a></li>
            </ul>
          </div>  
          <#-- 아이콘 메뉴 끝 -->
          <div class="collapse mt-3" id="icon-collapse">
            <div class="card card-body">
              <label class="form-label">
                <i id="category-icon-question" class="bi bi-question-circle" role="button"></i>
              </label>
              <input class="form-control mb-2" type="text" name="categoryIcon" value="${holder.categoryIcon}">
              <div class="caution error-off" data-code="EE_CA_107"><@msg "category.error.iconEmpty"/></div>
              <div class="caution error-off" data-code="EE_CA_108"><@msg "category.error.iconNotExist"/></div>
              <button id="icon-input-button" class="btn btn-primary mt-2" type="button"><@msg "global.confirm"/></button>
            </div>
          </div>
          <@errorMsgIndpt ['EE_CA_107'] 'category.error.iconEmpty'/>
        </div>

        <#-- 컬러 -->
        <div class="mb-5">
            <label class="form-label">
                <@msg "category.color.name"/>
            </label>
            <div>
                <input id="category-color-picker" name="categoryColor" value="<@if holder.categoryColor?has_content '${holder.categoryColor}' '#9EEAF9'/>" class="form-control" role="button">
            </div>
        </div>
      </form>

      <@confirmBackWithUrl '/account/category/edit'/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/category.js"></script>
</html>
