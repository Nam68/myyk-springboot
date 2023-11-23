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

      <form action="/member/tmp/code/create/confirm" method="POST">
        <#-- 이메일 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.email.name"/></label>
          <div class="input-group mb-3">
            <input type="text" class="form-control<#if errors?exists><@error errors 'EE_ME_101'/></#if>" name="emailLocalpart" value="${holder.emailLocalpart}">
            <span class="input-group-text">@</span>
            <input type="text" class="form-control<#if errors?exists><@error errors 'EE_ME_102'/><@error errors 'EE_ME_103'/></#if>" name="emailDomain" value="${holder.emailDomain}">
            <#if errors?exists>
              <#if errors.EE_ME_101?exists || errors.EE_ME_102?exists>
                <div class="invalid-feedback"><@msg "member.email.error.empty"/></div>
              </#if>
              <#if errors.EE_ME_103?exists>
                <div class="invalid-feedback"><@msg "member.email.error.form"/></div>
              </#if>
            </#if>
          </div>
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
