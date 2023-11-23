<#-- 삼항연산자 -->
<#macro if condition if else>
    <#if condition>${if}<#else>${else}</#if>
</#macro>

<#-- 다국어설정 확인 -->
<#macro setLanguage selected_language ko jp>
    <#if selected_language == 'ko'>${ko}<#else>${jp}</#if>
</#macro>

<#macro error error code>
    <#if error[code]?has_content> is-invalid</#if>
</#macro>

<#-- 다국어 입력 -->
<#macro msg path>
    <@spring.message path/>
</#macro>