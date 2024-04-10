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
        <@msg "member.email.check"/>
      </h3>

      <form action="/member/tmp/code/create/confirm" method="POST">
        <#-- 이메일 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.email.name"/></label>
          <div class="input-group mb-3">
            <input type="text" class="form-control<@error ['EE_ME_101']/>" name="emailLocalpart" value="${holder.emailLocalpart}">
            <span class="input-group-text">@</span>
            <input type="text" class="form-control<@error ['EE_ME_102', 'EE_ME_103']/>" name="emailDomain" value="${holder.emailDomain}">
            <@errorMsg ['EE_ME_101', 'EE_ME_102'] 'member.email.error.empty'/>
            <@errorMsg ['EE_ME_103'] 'member.email.error.empty'/>
          </div>
        </div>

        <#-- 비밀번호 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.password.name"/></label>
          <input type="password" class="form-control<@error ['EE_ME_106', 'EE_ME_107', 'EE_ME_108', 'EE_ME_109']/>" name="password">
          <@errorMsg ['EE_ME_106'] 'signup.error.passwordEmpty'/>
          <@errorMsg ['EE_ME_107'] 'signup.error.passwordMin'/>
          <@errorMsg ['EE_ME_108'] 'signup.error.passwordMax'/>
          <@errorMsg ['EE_ME_109'] 'signup.error.passwordForm'/>
        </div>
      </form>

      <@confirmBack/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/account.js"></script>
</html>
