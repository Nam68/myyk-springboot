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
          <label class="form-label"><@msg "account.create.name"/></label>
          <input type="text" class="form-control<@error ['EE_ME_101']/>" name="accountName" value="">
          <@errorMsg ['EE_ME_101', 'EE_ME_102'] 'member.email.error.empty'/>
        </div>

        <#-- 세금 설정 -->
        <div class="mb-5">
          <label class="form-label"><@msg "account.rate.include.name"/></label>
          <div class="row">
            <div class="col">
              <div class="form-check">
                <input class="form-check-input" id="taxIncluded" type="radio" name="taxIncluded" value="true">
                <label class="form-check-label" for="taxIncluded">
                  <@msg "account.rate.include.always"/>
                </label>
              </div>
            </div>
            <div class="col">
              <div class="form-check">
                <input class="form-check-input" id="notTaxIncluded" type="radio" name="taxIncluded" value="false" checked>
                <label class="form-check-label" for="notTaxIncluded">
                  <@msg "account.rate.include.each"/>
                </label>
              </div>
            </div>
          </div>
          <@errorMsg ['EE_ME_101', 'EE_ME_102'] 'member.email.error.empty'/>
        </div>

        <#-- 세금 On인 경우 -->
        <div class="tax-setting-area">
          <#-- 부가세율 -->
          <div class="mb-5">
            <label class="form-label"><@msg "account.rate.base"/></label>
            <@taxSelect/>
            <@errorMsg ['EE_ME_101', 'EE_ME_102'] 'member.email.error.empty'/>
          </div>
        </div>

        <#-- 통화단위 -->
        <div class="mb-5">
          <label class="form-label"><@msg "account.currency.name"/></label>
          <select class="form-select" name="currency">
            <option value="won"><@msg "account.currency.won"/></option>
            <option value="yen"><@msg "account.currency.yen"/></option>
          </select>
          <@errorMsg ['EE_ME_101', 'EE_ME_102'] 'member.email.error.empty'/>
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
                    <input class="form-check-input" id="read-${m.memberIdx}" type="checkbox" name="readAuth" value="${m.memberIdx}" role="switch">
                    <label class="form-check-label" for="read-${m.memberIdx}"><@msg "share.read"/></label>
                  </div>
                  <div class="form-check form-switch col">
                    <input class="form-check-input" id="write-${m.memberIdx}" type="checkbox" name="writeAuth" value="${m.memberIdx}" role="switch" disabled>
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
