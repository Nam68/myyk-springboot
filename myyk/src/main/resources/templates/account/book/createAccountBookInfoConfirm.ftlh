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
        <@msg "book.create.check"/>
      </h3>

      <form action="/account/book/create/excute" method="POST">
      
      
        <#-- 가계부 이름(한국어) : 한국어 설정인 경우 -->
        <#if '${selected_language}' == 'ko'>
        <div class="mb-5">
          <label class="form-label"><@msg "book.nameLang.${selected_language}"/></label>
          <div>${holder.accountBookNameKo}</div>
        </div>
        </#if>

        <#-- 가계부 이름(일본어) -->
        <div class="mb-5">
          <label class="form-label"><@msg "book.nameLang.${unselected_language}"/></label>
          <div>${holder.accountBookNameJp}</div>
        </div>
        
        
        <#-- 가계부 이름(한국어) : 일본어 설정인 경우 -->
        <#if '${selected_language}' != 'ko'>
        <div class="mb-5">
          <label class="form-label"><@msg "book.nameLang.${selected_language}"/></label>
          <div>${holder.accountBookNameKo}</div>
        </div>
        </#if>

        <#-- 세금 설정 -->
        <div class="mb-5">
          <label class="form-label"><@msg "book.rate.include.name"/></label>
          <#if holder.taxInclude>
          <div><@msg "book.rate.include.always"/></div>
          <#else>
          <div><@msg "book.rate.include.each"/></div>
          </#if>
        </div>

        <#-- 세금 On인 경우 -->
        <div class="tax-setting-area">
          <#-- 부가세율 -->
          <div class="mb-5">
            <label class="form-label"><@msg "book.rate.base"/></label>
            <div>${holder.taxRate.value}</div>
          </div>
        </div>

        <#-- 통화단위 -->
        <div class="mb-5">
          <label class="form-label"><@msg "book.currency.name"/></label>
          <div><@msg "book.currency.${holder.currency.value}"/></div>
        </div>

        <#-- 읽기 권한 -->
        <div class="mb-5">
          <label class="form-label"><@msg "share.read"/></label>
          <div id="auth-member-holder" class="card mt-2 mb-2">
            <div class="card-body">
              <#list holder.readAuthMap as memberIdx, memberDto>
                ${memberDto.nickname}&nbsp;(${memberDto.nicknameLang})
              </#list>
            </div>
          </div>
        </div>

        <#-- 쓰기 권한 -->
        <div class="mb-5">
          <label class="form-label"><@msg "share.write"/></label>
          <div id="auth-member-holder" class="card mt-2 mb-2">
            <div class="card-body">
              <#list holder.writeAuthMap as memberIdx, memberDto>
                ${memberDto.nickname}&nbsp;(${memberDto.nicknameLang})
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
