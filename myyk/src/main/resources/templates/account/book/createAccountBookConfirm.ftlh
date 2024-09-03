<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh">
<title><@msg "global.title"/></title>
<link rel="stylesheet" href="/css/accountBook.css"/>
</head>
<#include "/header.ftlh">
<body>
  <div id="content">
    <div id="wrapper">

      <h3 class="title">
        <@msg "book.create.name"/>
      </h3>

      <form action="/account/book/create/execute" method="POST">

        <#-- 가계부 이름 -->
        <div class="mb-5">
          <label class="form-label"><@msg "book.nameLang.${selected_language}"/></label>
          <div><@setLanguage '${selected_language}' '${holder.accountBookNameKr}' '${holder.accountBookNameJp}'/></div>
        </div>

        <#-- 가계부 이름(타언어) -->
        <div class="mb-5">
          <label class="form-label"><@msg "book.nameLang.${unselected_language}"/></label>
          <div><@setLanguage '${unselected_language}' '${holder.accountBookNameKr}' '${holder.accountBookNameJp}'/></div>
        </div>

        <#-- 통화단위 -->
        <div class="mb-5">
          <label class="form-label"><@msg "book.currency.name"/></label>
          <div><@msg "book.currency.${holder.currency.value}"/></div>
        </div>

        <#-- 권한 설정 -->
        <div class="mb-5">
          <label class="form-label"><@msg "share.name"/></label>
          <div id="auth-member-holder" class="card mt-2 mb-2">
            <div class="card-body">
              <#list holder.readAuthMap?keys as readKey>
              <div class="position-relative">

                <#-- DTO를 프리마커 변수에 세팅 -->
                <#assign read = holder.readAuthMap[readKey]>
                <#assign write = ''>
                <#if holder.writeAuthMap[readKey]?has_content>
                  <#assign write = holder.writeAuthMap[readKey]>
                </#if>
                

                <#-- 닉네임 -->
                <div class="d-inline">
                  ${read.nickname}&nbsp;(${read.maskedEmail})
                </div>

                <#-- 권한 표시 -->
                <div class="member-holder position-absolute top-50 end-0 translate-middle-y pe-3 row ">
                  <div class="form-check form-switch col me-5">
                    <label class="form-check-label"><@msg "share.read"/></label>
                    <i class="bi bi-check"></i>
                  </div>
                  <div class="form-check form-switch col">
                    <label class="form-check-label"><@msg "share.write"/></label>
                    <#if write?has_content><i class="bi bi-check"></i><#else><i class="bi bi-x"></i></#if>
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
<script src="/js/accountBook.js"></script>
</html>
