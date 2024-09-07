<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#include "/lib.ftlh">
<title><@msg "global.title"/></title>
<style>
.code-holer {
    color: var(--soft-black);
    width: 100%;
    letter-spacing: 1rem;
}
</style>
</head>
<#include "/header.ftlh">
<body>
  <div id="content">
    <div id="wrapper">

    hello, world!

<br>
<br>

    ** ADMIN **
    <br>
    IDX : 11
    <br>
    EMAIL : admin@sharing.myyk
    <br>
    PASSWORD : 1234

<form action="/member/update/passwordReset" method="post">
<#-- 임시로 HomepageController에 격납 -->
<input name="memberIdx">&nbsp;<button type="submit" id="passwordResetButton">Reset</button>
</form>


<button onclick="openLoading()">loading on</button>
<button onclick="closeLoading()" style="z-index:2000;">loading off</button>

<br>
<br>
<br>

<br>
<label>label</label>
<br>

<@checkbox 'test' 'A' 'test_a' false/><label for="test_a" class="pointer">test a</label>

<@checkbox 'test' 'B' 'test_b' false/><label for="test_b" class="pointer">test b</label> 

<@checkbox 'test' 'C' 'test_c' true/><label for="test_c" class="pointer">test c</label> 


<button onclick="testGo()">go!</button>
<script>
function testGo() {
    $('[name=test]').toArray().forEach(checkbox => {
        var i = $(checkbox);
        if (i.is(':checked')) {
            alert(i.val());
        }
    });
}
</script>
<br>



<br>
<br>
<br>

<a href="/sample">sample</a>

    </div>
  </div>
</body>
<#include "/footer.ftlh">
<script>

</script>

<script src="/js/member.js"></script>
</html>
