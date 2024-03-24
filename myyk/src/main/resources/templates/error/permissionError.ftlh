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
        <@msg "error.permission.name"/>
      </h3>

      <div class="mb-4">
        <div class="mt-2 mb-4">
          <span><@msg "error.permission.script"/></span>
      </div>

      <div class="d-grid gap-3 bottom-btn-set">
        <button class="btn btn-primary" onclick="location.href='/homepage'"><@msg "global.toHome"/></button>
      </div>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script type="text/javascript">

</script>
</html>
