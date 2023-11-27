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
            <input type="text" class="form-control<@error ['EE_ME_101', 'LE_ME_101']/>" name="emailLocalpart" value="${holder.emailLocalpart}">
            <span class="input-group-text">@</span>
            <input type="text" class="form-control<@error ['EE_ME_102', 'EE_ME_103', 'LE_ME_101']/>" name="emailDomain" value="${holder.emailDomain}">
            <@errorMsg ['EE_ME_101', 'EE_ME_102'] 'member.email.error.empty'/>
            <@errorMsg ['EE_ME_103'] 'member.email.error.form'/>
            <@errorMsg ['LE_ME_101'] 'member.email.error.dupl'/>
          </div>
        </div>
      </form>

      <@confirmBack/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
</html>
