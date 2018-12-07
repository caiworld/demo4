<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

date:${date}<br>
time:${time}<br>
date_time:${date_time}<br>

<br>

描述：${description}
<br/>
集合大小:${nameList?size}
<br/>
迭代list集合：
<br/>
<#list nameList as names>
这是第${names_index+1}个人，叫做：<label style="color:red">${names}</label><br/>
这是第${names?counter}个人，叫做：<label style="color:red">${names}</label><br/>
if判断：
<br/>
    <#if (names=="cai")>
    他的武器是: 十五~~
    <#elseif (names=="hao")>       <#--注意这里没有返回而是在最后面-->
    他的武器是: 轩辕剑~·
    <#else>
    她的绝招是：蛊毒~~
    </#if>
<br/>
</#list>
迭代map集合：
<br/>
<#list weaponMap?keys as key>
key--->${key}<br/>
value----->${weaponMap[key]!("null")}
<#--
fremarker 不支持null, 可以用！ 来代替为空的值。
其实也可以给一个默认值
value-----${weaponMap[key]?default("null")}
还可以 在输出前判断是否为null
<#if weaponMap[key]??></#if>都可以

-->
<br/>
</#list>
<#--welcome ${user!"boss"}.<br/>-->
<#if 18<person.user.age > 未成年</#if>
${(person.user1.age)!0}岁
<br/>
include导入文件：
<br/>
(5+8)/2=${(5+8)/2}<br>
${"It's \"quoted\""}<br>
<#if 4 gt 3>4>3</#if><br>
${r"C:\raw\string"}<br>
<#list 0..9 as n>
${n}<br>
</#list>
Hello ${(person.user.name)!"boss"}!<br>
Hello ${person.user.name[0..4]}!<br>
Hello ${person.user.name[0..<5]}!<br>
Hello ${person.user.name[0..*8]}!<br>
Hello ${person.user.name[3..]}!<br>
Hello ${person.user.name +"guest"}!<br>
Hello ${"\xA9 1999-2001"}!<br>
Hello ${"foo $\{bar}"}!<br>
${r"${foo}"}<br>
${r"C:\foo\bar"}<br>
<#if boolean>false</#if><br>
<#if person.user.name??>有user</#if>
${"true"}


<#--<#include "include.html"/>-->
</body>
</html>
