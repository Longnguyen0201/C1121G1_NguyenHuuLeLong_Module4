<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/30/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>List </p>
<c:forEach var="condiment" items="${condiments}">
    <p>${condiment}</p>
</c:forEach>
</body>
</html>
