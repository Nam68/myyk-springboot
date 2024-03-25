<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh">
<title><@msg "global.title"/></title>
<link rel="stylesheet" href="/css/account.css"/>
</head>
<#include "/header.ftlh">
<body>
  <div id="content">
    <div id="wrapper">

      <h3 class="title">
        <@msg "account.createOrUpdate"/>
      </h3>

      <form method="POST">
        <div class="mb-4" id="account-list-holder">
          <#if holder.accountList?has_content>
            <#list holder.accountList as account>
            <div class="card mt-2 mb-2">
              <div class="card-body position-relative" data-idx="${ account.accountIdx }">
                <div class="d-inline">
                  ${ account.name }
                </div>
                <div class="d-inline position-absolute top-50 end-0 translate-middle-y pe-3">
                  <span class="me-3" role="button">
                    <i class="bi bi-gear-fill"></i>
                  </span>
                  <span role="button">
                    <i class="bi bi-x-lg"></i>
                  </span>
                </div>
              </div>
            </div>
            </#list>
          </#if>
          <div class="card mt-2 mb-2">
            <div class="card-body position-relative" role="button">
              <div class="d-inline">
                <i class="bi bi-plus-lg"></i>&nbsp;&nbsp;<@msg "account.create.name"/>
              </div>
            </div>
          </div>

        </div>
      </form>

      <@backBtnWithUrl "/account"/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/account.js"></script>
</html>
