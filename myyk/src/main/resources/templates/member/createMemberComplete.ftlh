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
        <@msg "signup.complete"/>
      </h3>

      <form action="/" method="POST">
        <div class="mt-5 mb-5">
          <@msg "signup.completeMessage"/>
        </div>
      </form>

      <div class="d-grid gap-3 bottom-btn-set">
        <button class="btn btn-primary" onclick="mySubmit()"><@msg "login.toLogin"/></button>
        <button class="btn btn-outline-secondary" onclick="history.back()"><@msg "global.toHome"/></button>
      </div>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
</html>
