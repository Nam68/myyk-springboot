<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh">
<title><@msg "global.title"/></title>
<style>
.code-holer {
    color: var(--soft-black);
    width: 100%;
    letter-spacing: 1rem;
}
</style>
</head>
<#include "/header.ftlh">
<body>
  <div id="content">
    <div id="wrapper">

    hello, world!

<br>
<br>

    ** ADMIN **
    <br>
    IDX : 11
    <br>
    EMAIL : admin@sharing.myyk
    <br>
    PASSWORD : 1234

<form action="/member/update/passwordReset" method="post">
<#-- 임시로 HomepageController에 격납 -->
<input name="memberIdx">&nbsp;<button type="submit" id="passwordResetButton">Reset</button>
</form>


    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script>

</script>

<script src="/js/member.js"></script>
</html>
