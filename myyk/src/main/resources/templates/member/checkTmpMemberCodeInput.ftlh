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

      <form action="/member/create/input" method="POST">
        <div>
          <div class="mb-3"><@msg "member.code.notReady"/></div>
        </div>
        <div>
          <div class="mb-4">
            <div class="mb-1"><@msg "member.code.name"/>&nbsp;:&nbsp;</div>
            <input class="border p-3 h1 code-holer<@error ['LE_TM_101']/>" value="${holder.tmpCode}" disabled maxlength="6">
            <@errorMsg ['LE_TM_101'] 'member.code.error'/>
            <input type="hidden" name="tmpCode" value="${holder.tmpCode}"
          </div>
        </div>
      </form>

      <@confirmHome/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
</html>
