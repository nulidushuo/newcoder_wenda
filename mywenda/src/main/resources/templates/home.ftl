<html>
<body>
<pre>
    ${value1}

    <#list colors as color>
        ${color}
    </#list>

    User: ${user.name}
    ${user.description}
    ${user.getDescription()}

    <#assign title = "nowcoder">
    Title: ${title}

    Include: <#include "header.ftl">

</pre>
</body>
</html>