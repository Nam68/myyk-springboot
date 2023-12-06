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
        <@msg "account.name"/>
      </h3>

      <div class="row mb-4" id="account-data-holder">

        <div class="col-3 border">
          <div class="title text-center border-bottom p-2 mb-2">account book list</div>
          <div class="p-2 pb-4 border-bottom">
            <div class="p-2 rounded account-book-name account-book-selected" role="button">&nbsp;account A</div>
            <div class="p-2 rounded account-book-name" role="button">&nbsp;account B</div>
            <div class="p-2 rounded account-book-name" role="button">&nbsp;account C</div>
          </div>
          <div class="text-center p-2 row">
            <button class="btn btn-outline-primary">add or edit <i class="bi bi-gear-fill"></i></button>
          </div>
        </div>

        <div class="col border">
          <div class="title text-center border-bottom p-2">account book name</div>
          <div class="m-2">
            data
          </div>
        </div>

      </div>
      
      <@toHomeBtn/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/account.js"></script>
</html>
