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

      <form action="/account/category/create/excute" method="POST">

        <#-- 카테고리 -->
        <div class="mb-5">
          <label class="form-label"><@msg "category.nameLang.${selected_language}"/></label>
          <div><@setLanguage '${selected_language}' '${holder.categoryNameKr}' '${holder.categoryNameJp}'/></div>
        </div>

        <#-- 카테고리 (타언어) -->
        <div class="mb-5">
          <label class="form-label"><@msg "category.nameLang.${unselected_language}"/></label>
          <div><@setLanguage '${unselected_language}' '${holder.categoryNameKr}' '${holder.categoryNameJp}'/></div>
        </div>

        <#-- 아이콘 -->
        <div class="mb-5">
          <label class="form-label"><@msg "category.icon.name"/></label>
          <div><i id="category-icon-holder" class="bi bi-${holder.categoryIcon}" style="color:${holder.categoryColor}"></i></div>
        </div>

      </form>

      <@confirmBack/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/account.js"></script>
</html>
