<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh">
<title><@msg "global.title"/></title>
<link rel="stylesheet" href="/css/accountBook.css"/>
</head>
<#include "/header.ftlh">
<body>
  <div id="content">
    <div id="wrapper">

      <h3 class="title">
        <@msg "book.category.name"/>
      </h3>

      <form action="/account/book/create/category/confirm" method="POST">

        <input type="hidden" name="accountBookIdx" value="${holder.accountBookIdx}">

        <div class="mb-5">
          <label class="form-label"><@msg "book.nameLang.${selected_language}"/></label>
          <div>
            <@setLanguage '${selected_language}' '${holder.accountBookNameKr}' '${holder.accountBookNameJp}'/>
          </div>
        </div>

        <div class="mb-5">
          <label class="form-label"><@msg "book.category.basic"/></label>
          <div class="card mt-2 mb-2">
            <div class="card-body">

              <#list holder.basicCategoryList as b>
              <div class="category-set-holder position-relative<#if b_index != 0> mt-3</#if>">

                <#-- 카테고리 이름 -->
                <div class="category-holder">
                  <#assign checkboxId = 'basic-category-${b_index}'/>
                  <#assign checked = holder.selectedCategory[b.categoryIdx?string]?has_content/>
                  <@checkbox 'categoryIdx' '${b.categoryIdx}' '${checkboxId}' checked/>
                  <label for="${checkboxId}" class="pointer">
                    <@setLanguage '${selected_language}' '${b.categoryNameKr}' '${b.categoryNameJp}'/>
                  <label>
                </div>

                <#-- 서브 카테고리 -->
                <#if b.subCategoryList?has_content>
                <div class="sub-category-holder ps-5">
                  <#list b.subCategoryList as sc>
                  <div class="mt-1">
                    <#assign subCheckboxId = 'basic-sub-category-${sc_index}'/>
                    <#assign checked = holder.selectedSubCategory[sc.subCategoryIdx?string]?has_content/>
                    <@checkbox 'subCategoryIdx' '${sc.subCategoryIdx}' '${subCheckboxId}' checked/>
                    <label for="${subCheckboxId}" class="pointer">
                    <@setLanguage '${selected_language}' '${sc.subCategoryNameKr}' '${sc.subCategoryNameJp}'/>
                    </label>
                  </div>
                  </#list>
                </div>
                </#if>

              </div>
              </#list>

            </div>
          </div>
        </div>

        <div class="mt-5 mb-5">
          <label class="form-label"><@msg "book.category.created"/></label>
          <div class="card mt-2 mb-2">
            <div class="card-body">

              <#list holder.createdCategoryList as c>
              <div class="category-set-holder position-relative<#if c_index != 0> mt-3</#if>">

                <#-- 카테고리 이름 -->
                <div class="category-holder">
                  <#assign checkboxId = 'created-category-${c_index}'/>
                  <#assign checked = holder.selectedCategory[c.categoryIdx?string]?has_content/>
                  <@checkbox 'categoryIdx' '${c.categoryIdx}' '${checkboxId}' checked/>
                  <label for="${checkboxId}" class="pointer">
                    <@setLanguage '${selected_language}' '${c.categoryNameKr}' '${c.categoryNameJp}' />
                  <label>
                </div>

                <#-- 서브 카테고리 -->
                <#if c.subCategoryList?has_content>
                <div class="sub-category-holder ps-5">
                  <#list c.subCategoryList as sc>
                  <div class="mt-1">
                    <#assign subCheckboxId = 'created-sub-category-${c_index}-${sc_index}'/>
                    <#assign checked = holder.selectedSubCategory[sc.subCategoryIdx?string]?has_content/>
                    <@checkbox 'subCategoryIdx' '${sc.subCategoryIdx}' '${subCheckboxId}' checked/>
                    <label for="${subCheckboxId}" class="pointer">
                    <@setLanguage '${selected_language}' '${sc.subCategoryNameKr}' '${sc.subCategoryNameJp}' />
                    </label>
                  </div>
                  </#list>
                </div>
                </#if>

              </div>
              </#list>

            </div>
          </div>
        </div>

      </form>

      <@confirmBackWithUrl '/account/book/edit'/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/accountBook.js"></script>
</html>
