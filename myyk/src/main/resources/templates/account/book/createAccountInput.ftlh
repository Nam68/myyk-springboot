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
        <@msg "account.create.name"/>
      </h3>

      <form action="/account/book/create/confirm" method="POST">

        <#-- 가계부 이름 -->
        <div class="mb-5">
          <label class="form-label"><@msg "account.accountName"/></label>
          <input type="text" class="form-control<@error ['EE_ME_101']/>" name="accountName" value="${holder.accountName}">
          <@errorMsg ['EE_AC_101'] 'account.error.accountNameEmpty'/>
          <@errorMsg ['EE_AC_102'] 'account.error.accountNameMax'/>
          <@errorMsg ['EE_AC_103'] 'account.error.accountNameDupl'/>
        </div>

        <#-- 세금 설정 -->
        <div class="mb-5">
          <label class="form-label"><@msg "account.rate.include.name"/></label>
          <div class="row">
            <div class="col">
              <div class="form-check">
                <input class="form-check-input" id="taxInclude" type="radio" name="taxInclude" value="true"<#if holder.taxInclude>checked</#if>>
                <label class="form-check-label" for="taxInclude">
                  <@msg "account.rate.include.always"/>
                </label>
              </div>
            </div>
            <div class="col">
              <div class="form-check">
                <input class="form-check-input" id="notTaxInclude" type="radio" name="taxInclude" value="false"<#if !holder.taxInclude>checked</#if>>
                <label class="form-check-label" for="notTaxInclude">
                  <@msg "account.rate.include.each"/>
                </label>
              </div>
            </div>
          </div>
        </div>

        <#-- 세금 On인 경우 -->
        <div class="tax-setting-area">
          <#-- 부가세율 -->
          <div class="mb-5">
            <label class="form-label"><@msg "account.rate.base"/></label>
            <@taxRateSelect/>
          </div>
        </div>

        <#-- 통화단위 -->
        <div class="mb-5">
          <label class="form-label"><@msg "account.currency.name"/></label>
          <@currencySelect/>
        </div>

        <#-- 권한 설정 -->
        <div class="mb-5">
          <label class="form-label"><@msg "share.name"/></label>
          <div id="auth-member-holder" class="card mt-2 mb-2">
            <div class="card-body">
              <#list holder.memberList as m>
              <div class="position-relative">
                <div class="d-inline">
                  ${ m.nickname }&nbsp;(<@maskedEmail "${m.emailLocalpart}" "${m.emailDomain}"/>)
                </div>
                <div class="member-holder position-absolute top-50 end-0 translate-middle-y pe-3 row ">
                  <div class="form-check form-switch col me-5">
                    <#assign readable = false>
                    <#if holder.readAuthMap?has_content><#if holder.readAuthMap[memberIdx]?has_content><#assign readable = true></#if></#if>
                    <input class="form-check-input" id="read-${m.memberIdx}" type="checkbox" name="readAuth" value="${m.memberIdx}" role="switch" <#if readable>checked</#if>>
                    <label class="form-check-label" for="read-${m.memberIdx}"><@msg "share.read"/></label>
                  </div>
                  <div class="form-check form-switch col">
                    <#assign writable = false>
                    <#if holder.writeAuthMap?has_content><#if holder.writeAuthMap[memberIdx]?has_content><#assign writable = true></#if></#if>
                    <input class="form-check-input" id="write-${m.memberIdx}" type="checkbox" name="writeAuth" value="${m.memberIdx}" role="switch" <#if writable>checked<#else>disabled</#if>>
                    <label class="form-check-label" for="write-${m.memberIdx}"><@msg "share.write"/></label>
                  </div>
                </div>
              </div>
              </#list>
            </div>
          </div>
        </div>

      </form>

      <@confirmBack/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/account.js"></script>
</html>
