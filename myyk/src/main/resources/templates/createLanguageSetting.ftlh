<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh"> 
<title><@input "global.title"/></title>
</head>
<body>
    <div class="flag-button shadow rounded" role="button">
        <div class="flag-button-hover rounded"></div>
        <div class="korea-flag-div"></div>
        <img class="korea-flag img-fluid rounded" src="/img/koreaFlag.jpg"/>
        <div class="korea-letter align-middle"><i>한국어</i></div>
    </div>
    <div class="flag-button shadow rounded" role="button">
        <div class="flag-button-hover rounded"></div>
        <div class="japan-flag-div"></div>
        <img class="japan-flag img-fluid rounded" src="/img/japanFlag.jpg"/>
        <div class="japan-letter align-middle"><i>日本語</i></div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(window).on('load', function() {
        centerAlignDiv();
    });
    $('.flag-button:eq(0)').on('click', function() {
        location.href = '/global/homepage?lang=ko';
    });
    $('.flag-button:eq(1)').on('click', function() {
        location.href = '/global/homepage?lang=jp';
    });
</script>
</html>