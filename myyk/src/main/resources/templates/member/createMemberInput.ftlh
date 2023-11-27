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
        <@msg "signup.name"/>
      </h3>

      <form action="/member/create/confirm" method="POST">
        <#-- 이메일 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.email.name"/></label>
          <div class="input-group mb-3">
            <input type="text" class="form-control" value="${holder.emailLocalpart}" disabled>
            <span class="input-group-text">@</span>
            <input type="text" class="form-control" value="${holder.emailDomain}" disabled>
          </div>
        </div>
        <input type="hidden" name="emailLocalpart" value="${holder.emailLocalpart}">
        <input type="hidden" name="emailDomain" value="${holder.emailDomain}">

        <#-- 비밀번호 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.password.name"/></label>
          <input type="password" class="form-control<@error ['EE_ME_106', 'EE_ME_107', 'EE_ME_108', 'EE_ME_109']/>" name="password">
          <@errorMsg ['EE_ME_106'] 'signup.error.passwordEmpty'/>
          <@errorMsg ['EE_ME_107'] 'signup.error.passwordMin'/>
          <@errorMsg ['EE_ME_108'] 'signup.error.passwordMax'/>
          <@errorMsg ['EE_ME_109'] 'signup.error.passwordForm'/>
        </div>

        <#-- 비밀번호 확인 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.password.check"/></label>
          <input type="password" class="form-control<@error ['EE_ME_110']/>" name="passwordCheck">
          <@errorMsg ['EE_ME_110'] 'signup.error.passwordCheck'/>
        </div>

        <#-- 닉네임 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.nickname.name"/></label>
          <input type="password" class="form-control<@error ['EE_ME_111', 'EE_ME_112', 'LE_ME_102']/>" name="nickname" value="${holder.nickname}">
          <@errorMsg ['EE_ME_111'] 'signup.error.nicknameEmpty'/>
          <@errorMsg ['EE_ME_112'] 'signup.error.nicknameMax'/>
          <@errorMsg ['LE_ME_102'] 'signup.error.nicknameDupl'/>
        </div>

        <#-- 지역 -->
        <div class="mb-5">
          <label class="form-label"><@msg "member.region.name"/></label>
          <@regionSelect/>
        </div>
      </form>

      <@confirmHome/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
</html>
