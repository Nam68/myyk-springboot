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
        <@msg "book.complete.name"/>
      </h3>

      <form action="/account/book/create/category/input" method="POST">
        <div class="d-grid gap-2 mx-auto">
          <input type="hidden" name="accountBookIdx" value="${holder.accountBookIdx}">
          <a class="btn btn-primary" role="button"><@msg "book.complete.toCategorySetting"/></a>
        </div>
      </form>

      <div class="d-grid gap-2 mx-auto mt-3">
        <a class="btn btn-outline-secondary" role="button" href="/account/book/edit"><@msg "book.complete.toList"/></a>
      </div>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/accountBook.js"></script>
</html>
