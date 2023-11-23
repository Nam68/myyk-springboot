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
      <form action="/member/create/confirm" method="POST">
        <#-- 이메일 -->
        <div class="mb-5">
          <label class="form-label">
            <@msg "member.email.name"/>
          </label>
          <div class="input-group mb-3">
            <input type="text" class="form-control">
            <span class="input-group-text">@</span>
            <input type="text" class="form-control">
          </div>
        </div>
        <div class="d-grid gap-3 bottom-btn-set">
          <button class="btn btn-primary" type="button"><@msg "member.email.send"/></button>
          <button class="btn btn-outline-secondary" type="button"><@msg "global.back"/></button>
        </div>
      </form>
    </div>
  </div>
</body>
<#include "/footer.ftlh">
</html>
