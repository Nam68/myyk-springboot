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
        <@msg "member.email.check"/>
      </h3>

      <form action="/member/tmp/code/create/execute" method="POST">
        <#-- 이메일 -->
        <div>
          <div class="mb-3"><strong>${holder.emailLocalpart}@${holder.emailDomain}</strong></div>
          <div class="mb-5"><@msg "member.email.checkConfirm"/></div>
        </div>
      </form>

      <div class="d-grid gap-3 bottom-btn-set">
        <button class="btn btn-primary" onclick="mySubmit()"><@msg "member.email.send"/></button>
        <button class="btn btn-outline-secondary" onclick="history.back()"><@msg "global.back"/></button>
      </div>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
</html>
