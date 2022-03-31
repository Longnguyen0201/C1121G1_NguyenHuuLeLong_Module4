<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Config</title>
</head>
<body>
<h1>Config</h1>
<p>Language: ${email.language}</p>
<p>page_size: ${email.page_size}</p>
<p>spams_filter: ${email.spams_filter}</p>
<p>signature: ${email.signature}</p>
<form:form action="/edit" method="post" modelAttribute="email">
    <form:input type="hidden" path="language" value="${email.language}"/>
    <form:input type="hidden" path="page_size" value="${email.page_size}"/>
    <form:input type="hidden" path="spams_filter" value="${email.spams_filter}"/>
    <form:input type="hidden" path="signature" value="${email.signature}"/>
    <input type="submit" value="edit">
</form:form>
</body>
</html>