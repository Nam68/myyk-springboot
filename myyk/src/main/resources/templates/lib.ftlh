<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<#-- moment -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.19.3/moment.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.19.3/moment-with-locales.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.19.3/locale/ko.js"></script>
<#-- bootstrap datetimepicker -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<#-- color picker -->
<script src="https://cdn.jsdelivr.net/npm/spectrum-colorpicker2/dist/spectrum.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/spectrum-colorpicker2/dist/spectrum.min.css"/>
<#-- custom --> 
<link href="/css/global/globalCss.css" rel="stylesheet">
<link href="/css/global/headerFooterCss.css" rel="stylesheet">
<script src="/js/globalJs.js"></script> 
<#include "macro.ftlh">
<#-- 다국어설정 -->
<#import "/spring.ftl" as spring/>

<#-- javascript constants -->
<script>
const selectedLanguage = '${selected_language}';
const unselectedLanguage = '${unselected_language}';
const ajaxErrorMsg = '<@input "alert.error.ajax"/>';
</script>