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

      <form action="/account/book/create/confirm" method="POST">

        <#-- 가계부 이름 -->
        <div class="mb-5">
          <label class="form-label"><@msg "book.nameLang.${selected_language}"/></label>
          <input type="text" class="form-control<@error ['EE_AC_101', 'EE_AC_102', 'EE_AC_103']/>" name="accountBookName${selected_language?capitalize}" value="<@setLanguage '${selected_language}' '${holder.accountBookNameKr}' '${holder.accountBookNameJp}'/>">
          <@errorMsg ['EE_AC_101'] 'book.error.nameEmpty'/>
          <@errorMsg ['EE_AC_102'] 'book.error.nameMax'/>
          <@errorMsg ['EE_AC_103'] 'book.error.nameDupl'/>
        </div>

        <#-- 가계부 이름(타언어) -->
        <div class="mb-5">
          <label class="form-label"><@msg "book.nameLang.${unselected_language}"/></label>
          <input type="text" class="form-control<@error ['EE_AC_104', 'EE_AC_105', 'EE_AC_106']/>" name="accountBookName${unselected_language?capitalize}" value="<@setLanguage '${unselected_language}' '${holder.accountBookNameKr}' '${holder.accountBookNameJp}'/>">
          <@errorMsg ['EE_AC_104'] 'book.error.nameEmpty'/>
          <@errorMsg ['EE_AC_105'] 'book.error.nameMax'/>
          <@errorMsg ['EE_AC_106'] 'book.error.nameDupl'/>
        </div>

        <#-- 통화단위 -->
        <div class="mb-5">
          <label class="form-label"><@msg "book.currency.name"/></label>
          <@currencySelect/>
        </div>

        <#-- 권한 설정 -->
        <div class="mb-5">
          <label class="form-label"><@msg "share.name"/></label>
          <div id="auth-member-holder" class="card mt-2 mb-2">
            <div class="card-body">
              <#list holder.memberList as m>
              <div class="position-relative">

                <#-- 닉네임 -->
                <div class="d-inline">
                  <#-- []태그를 사용하기 위해서는 키값이 문자열이어야함 -->
                  <#assign idx = m.memberIdx?string>
                  ${m.nickname}&nbsp;(${m.maskedEmail})
                </div>

                <#-- 권한 토글 -->
                <div class="member-holder position-absolute top-50 end-0 translate-middle-y pe-3 row ">
                  <div class="form-check form-switch col me-5">
                    <#assign readable = false>
                    <#if holder.readAuthMap?has_content><#if holder.readAuthMap[idx]?has_content><#assign readable = true></#if></#if>
                    <input class="form-check-input" id="read-${idx}" type="checkbox" name="readAuthList" value="${idx}" role="switch" <#if readable>checked</#if>>
                    <label class="form-check-label" for="read-${idx}"><@msg "share.read"/></label>
                  </div>
                  <div class="form-check form-switch col">
                    <#assign writable = false>
                    <#if holder.writeAuthMap?has_content><#if holder.writeAuthMap[idx]?has_content><#assign writable = true></#if></#if>
                    <input class="form-check-input" id="write-${idx}" type="checkbox" name="writeAuthList" value="${idx}" role="switch" <#if writable>checked</#if>>
                    <label class="form-check-label" for="write-${idx}"><@msg "share.write"/></label>
                  </div>
                </div>

              </div>
              </#list>
            </div>
          </div>

          <#-- 에러메시지 출력용 (권한을 설정한 회원이 존재하지 않는 경우) -->
          <input type="hidden" class="form-control<@error ['ME_101']/>"/>
          <@errorMsg ['ME_101'] 'share.error.missing'/>

        </div>

      </form>

      <@confirmBack/>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script src="/js/accountBook.js"></script>
</html>
