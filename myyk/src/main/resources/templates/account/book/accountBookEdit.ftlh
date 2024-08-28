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
        <@msg "book.edit"/>
      </h3>

      <div class="mb-3">
        <button id="create-book-button" class="btn btn-outline-primary">
          <i class="bi bi-plus-lg"></i>&nbsp;<@msg "book.create.name"/>
        </button>
      </div>

      <form method="POST">
        <div class="mb-4" id="account-book-list-holder">

          <#if holder.accountBookList?has_content>
            <#list holder.accountBookList as accountBook>
            <div class="card mt-2 mb-2">
              <div class="card-body position-relative" data-idx="${ accountBook.accountBookIdx }">
                <div class="d-inline">
                  ${ accountBook.name }
                </div>
                <div class="d-inline position-absolute top-50 end-0 translate-middle-y pe-3">
                  <span class="me-3" role="button">
                    <i class="bi bi-gear-fill"></i>
                  </span>
                  <span role="button">
                    <i class="bi bi-x-lg"></i>
                  </span>
                </div>
              </div>
            </div>
            </#list>
          </#if>

        </div>
      </form>

      <@backBtnWithUrl "/account"/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/account.js"></script>
</html>
