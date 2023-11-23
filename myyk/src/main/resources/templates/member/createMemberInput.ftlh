<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh">
<title><@msg "global.title"/></title>
</head>
<#include "/header.ftlh">
<body>
  <div class="content">
    <div class="wrapper">
      <h3 class="title">
        <@msg "signup.name"/>
      </h3>
      <form action="/member/create/confirm" method="POST">
        <#-- 이메일 -->
        <div class="mb-4">
          <label class="form-label">
            <@msg "member.email.name"/>
          </label>
          <input type="text" class="form-control" name="email">
          <input type="hidden" name="email">
        </div>
      </form>
    </div>
  </div>
</body>
<#--<#include "/footer.ftlh">-->
<script type="text/javascript">

</script>
</html>
