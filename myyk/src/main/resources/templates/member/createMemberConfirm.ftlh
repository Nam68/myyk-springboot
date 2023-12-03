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
        <@msg "signup.check"/>
      </h3>

      <form action="/member/create/excute" method="POST">
        <#-- 이메일 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.email.name"/></label>
          <div>${holder.emailLocalpart}@${holder.emailDomain}</div>
        </div>

        <#-- 닉네임 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.nickname.name"/></label>
          <div>${holder.nickname}</div>
        </div>

        <#-- 지역 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.region.name"/></label>
          <div><@msg "member.region.${holder.region.value}"/></div>
        </div>
      </form>

      <div class="mb-3 text-center"><@msg "signup.checkConfirm"/></div>
      <@confirmBack/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
</html>
