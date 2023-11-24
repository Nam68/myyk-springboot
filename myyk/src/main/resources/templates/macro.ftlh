<#-- 삼항연산자 -->
<#macro if condition if else>
    <#if condition>${if}<#else>${else}</#if>
</#macro>

<#-- 다국어설정 확인 -->
<#macro setLanguage selected_language ko jp>
    <#if selected_language == 'ko'>${ko}<#else>${jp}</#if>
</#macro>

<#-- 다국어 입력 -->
<#macro msg path>
    <@spring.message path/>
</#macro>

<#-- 에러 체크 -->
<#macro error codes>
    <#if errors?has_content>
        <#list codes as code>
            <#if errors[code]?has_content> is-invalid<#break></#if>
        </#list>
    </#if>
</#macro>

<#--에러 메시지 -->
<#macro errorMsg codes msg>
    <#if errors?has_content>
        <#assign hasError = false>
        <#list codes as code>
            <#if errors[code]?has_content><#assign hasError = true><#break></#if>
        </#list>
        <#if hasError == true>
            <div class="invalid-feedback"><@spring.message msg/></div>
        </#if>
    </#if>
</#macro>