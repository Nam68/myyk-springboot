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
          <@msg "error.noHandler.message"/>
        </div>
      </div>

      <@toHomeBtn/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script type="text/javascript">

</script>
</html>
