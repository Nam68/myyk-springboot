<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh">
<title><@msg "global.title"/></title>
<link rel="stylesheet" href="/css/login.css"/>
</head>
<body class="text-center">
  <main class="form-login position-absolute top-50 start-50 translate-middle">
    <form action="/login/confirm" method="POST">
      <img class="form-icon mb-1" src="/img/title.jpg" alt="..." onclick="location.href='/'" role="button">
      <h1 class="h3 mb-3 fw-normal"><@msg "login.name"/></h1>

      <div class="form-floating">
        <input type="email" class="form-control<@error ['LE_LG_101']/>" name="email" value="${holder.email}" id="floatingInput">
        <label for="floatingInput"><@msg "member.email.name"/></label>
      </div>
      <div class="form-floating mb-3">
        <input type="password" class="form-control<@error ['LE_LG_101']/>" name="password" id="floatingPassword">
        <label for="floatingPassword"><@msg "member.password.name"/></label>
      </div>

      <@errorMsgIndpt ['LE_LG_101'] 'login.error'/>

      <div class="form-check text-start mt-3 my-3">
        <@checkbox 'autoLogin' 'true' 'auto-login' holder.autoLogin/>
        <label class="pointer" for="auto-login">
          <@msg "login.remember"/>  
        </label>
      </div>
    </form>

    <div class="mt-4">
      <button class="btn btn-primary w-100 py-2" onclick="mySubmit()"><@msg "login.name"/></button>
      <button class="btn btn-outline-secondary w-100 py-2 mt-2" onclick="location.href='/'"><@msg "global.toHome"/></button>
      <p class="mt-5 mb-3 text-body-secondary">&copy; 2023 Nam Youngkyu</p>
    </div>
  </main>
</body>
<script src="/js/login.js"></script>
</html>
