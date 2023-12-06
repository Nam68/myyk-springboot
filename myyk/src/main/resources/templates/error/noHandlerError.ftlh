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
        <@msg "error.noHandler.name"/>
      </h3>

      <div class="mb-4">
        <div class="fs-4">
          <strong><@msg "error.noHandler.message"/></strong>
        </div>
      </div>

      <div class="d-grid gap-3 bottom-btn-set">
        <@toHomeBtn/>
      </div>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script type="text/javascript">

</script>
</html>
