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
        <@msg "book.nameLang.${selected_language}"/>
      </h3>

      <div class="row mb-4" id="account-data-holder">

        <#if holder.accountList?has_content>
        <div class="col-3 border">
          <div class="title text-center border-bottom p-2"><@msg "book.list"/></div>
          <div class="p-2 border-bottom">
            <div class="p-2 mt-1 mb-1 rounded account-book-name account-book-selected" role="button">&nbsp;account A</div>
            <div class="p-2 mt-1 mb-1 rounded account-book-name" role="button">&nbsp;account B</div>
            <div class="p-2 mt-1 mb-1 rounded account-book-name" role="button">&nbsp;account C</div>
          </div>
          <div class="text-center p-2 row">
            <button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#account-item-edit-modal">
              <@msg "accountOrCategory"/>&nbsp;<i class="bi bi-gear-fill"></i>
            </button>
          </div>
        </div>

        <div class="col border">
          <div class="title text-center border-bottom p-2">account A</div>
          <div class="m-2">
            data
          </div>
        </div>
        <#else>
        <button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#account-item-edit-modal">
          <@msg "accountOrCategory"/>&nbsp;<i class="bi bi-gear-fill"></i>
        </button>
        </#if>

      </div>
      
      <@toHomeBtn/>

    </div>
  </div>
</body>

<#-- 가계부 에디터인지 카테고리 에디터인지 선택하는 모달 -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-body">
        <div>
          <button class="btn btn-outline-primary" href="/account/book/edit">
            <@msg "book.createOrUpdate"/>
          </button>
        </div>
        <div>
          <button class="btn btn-outline-primary" href="/account/category/edit">
            <@msg "category.createOrUpdate"/>
          </button>
        </div>
      </div>
    </div>
  </div>
</div>

<#include "/footer.ftlh">
<script src="/js/account.js"></script>
</html>
