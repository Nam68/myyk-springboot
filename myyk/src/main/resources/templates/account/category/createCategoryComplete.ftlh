<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh">
<title><@msg "global.title"/></title>
</head>
<#include "/header.ftlh">
<body>
  <div id="content">
    <div id="wrapper">

      <h3 class="title">
        <@msg "category.complete.name"/>
      </h3>

      <div class="d-grid gap-2 mx-auto">
        <a class="btn btn-outline-secondary" role="button" href="/account/category/edit"><@msg "category.complete.toList"/></a>
      </div>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
</html>
