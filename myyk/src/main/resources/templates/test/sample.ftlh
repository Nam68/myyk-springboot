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

      <form action="/account/book/create/category/input" method="POST">

        <div class="mb-5">
          <label class="form-label"><@msg "book.category.basic"/></label>
          <div class="card mt-2 mb-2">
            <div class="card-body category-holder basic">

              <#list holder.basicCategoryList as b>
              <div class="position-relative">

                <#-- 카테고리 이름 -->
                <div>
                  <#assign checkboxId = 'basic-category-${b_index}'/>
                  <@checkbox 'basic-category' '${b.categoryIdx}' '${checkboxId}' false />
                  <label for="${checkboxId}" class="pointer">
                    <@setLanguage '${selected_language}' '${b.categoryNameKr}' '${b.categoryNameJp}' />
                  <label>
                </div>

                <#-- 서브 카테고리 -->
                <#if b.subCategoryList?has_content>
                <div class="ps-5">
                  <#list b.subCategoryList as sc>
                  <div class="mt-1">
                    <#assign subCheckboxId = 'basic-sub-category-${sc_index}'/>
                    <@checkbox 'basic-sub-category' '${sc.subCategoryIdx}' '${subCheckboxId}' false />
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
        <div>

        <div class="mt-5 mb-5">
          <label class="form-label"><@msg "book.category.created"/></label>
          <div class="card mt-2 mb-2">
            <div class="card-body category-holder created">

              <#list holder.createdCategoryList as c>
              <div class="position-relative">

                <#-- 카테고리 이름 -->
                <div>
                  <#assign checkboxId = 'created-category-${c_index}'/>
                  <@checkbox 'created-category' '${c.categoryIdx}' '${checkboxId}' false />
                  <label for="${checkboxId}" class="pointer">
                    <@setLanguage '${selected_language}' '${c.categoryNameKr}' '${c.categoryNameJp}' />
                  <label>
                </div>

                <#-- 서브 카테고리 -->
                <#if c.subCategoryList?has_content>
                <div class="ps-5">
                  <#list c.subCategoryList as sc>
                  <div class="mt-1">
                    <#assign subCheckboxId = 'created-sub-category-${sc_index}'/>
                    <@checkbox 'created-sub-category' '${sc.subCategoryIdx}' '${subCheckboxId}' false />
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
        <div>

      </form>

      <@confirmBackWithUrl '/account/book/edit'/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/accountBook.js"></script>
</html>
