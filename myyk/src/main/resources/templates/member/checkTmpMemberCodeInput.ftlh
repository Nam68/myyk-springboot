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
        <@msg "member.code.check"/>
      </h3>

      <form action="/member/tmp/code/create/confirm" method="POST">
        <div>
          <div class="mb-3"><@msg "member.code.notReady"/></div>
        </div>
        <div>
          <div class="mb-3"><@msg "member.email.name"/>&nbsp;:&nbsp;<strong>${holder.email}</strong></div>
          <div class="mb-5"><@msg "member.code.name"/>&nbsp;:&nbsp;<strong>${holder.tmpCode}</strong></div>
        </div>
      </form>

      <div class="d-grid gap-3 bottom-btn-set">
        <button class="btn btn-primary" onclick="mySubmit()"><@msg "signup.name"/></button>
        <button class="btn btn-outline-secondary" onclick="location.href='/'"><@msg "global.toHome"/></button>
      </div>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
</html>
