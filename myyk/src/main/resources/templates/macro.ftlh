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

<#-- 확인버튼 -->
<#macro confirmBtn>
    <div class="d-grid gap-3 bottom-btn-set">
        <button class="btn btn-primary" onclick="mySubmit()"><@spring.message "global.confirm"/></button>
    </div>
</#macro>

<#-- 홈으로 버튼 -->
<#macro toHomeBtn>
    <div class="d-grid gap-3 bottom-btn-set">
        <button class="btn btn-outline-secondary" onclick="location.href='/'"><@spring.message "global.toHome"/></button>
    </div>
</#macro>

<#-- 뒤로가기 버튼 -->
<#macro backBtn>
    <div class="d-grid gap-3 bottom-btn-set">
        <button class="btn btn-outline-secondary" onclick="history.back()"><@spring.message "global.back"/></button>
    </div>
</#macro>

<#-- 확인 & 홈으로 버튼세트 -->
<#macro confirmHome>
    <div class="d-grid gap-3 bottom-btn-set">
        <button class="btn btn-primary" onclick="mySubmit()"><@spring.message "global.confirm"/></button>
        <button class="btn btn-outline-secondary" onclick="location.href='/'"><@spring.message "global.toHome"/></button>
    </div>
</#macro>

<#-- 확인 & 뒤로가기 버튼세트 -->
<#macro confirmBack>
    <div class="d-grid gap-3 bottom-btn-set">
        <button class="btn btn-primary" onclick="mySubmit()"><@spring.message "global.confirm"/></button>
        <button class="btn btn-outline-secondary" onclick="history.back()"><@spring.message "global.back"/></button>
    </div>
</#macro>

<#-- 지역 풀다운 메뉴 -->
<#macro regionSelect>
    <select class="form-select" name="region">
        <#list Region as r>
        <option value="${r.value}"<#if holder.region.value == r.value> selected</#if>>
            <@msg "member.region.${r.value}"/>
        </option>
        </#list>
    </select>
</#macro>

<#-- 에러 체크 -->
<#macro error codes>
    <#if errors?has_content>
        <#list codes as code>
            <#if errors[code]?has_content> is-invalid<#break></#if>
        </#list>
    </#if>
</#macro>

<#-- 에러 메시지 -->
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

<#-- 인풋과 독립적인 에러 메시지 -->
<#macro errorMsgIndpt codes msg>
    <#if errors?has_content>
        <#assign hasError = false>
        <#list codes as code>
            <#if errors[code]?has_content><#assign hasError = true><#break></#if>
        </#list>
        <#if hasError == true>
            <div class="caution"><@spring.message msg/></div>
        </#if>
    </#if>
</#macro>