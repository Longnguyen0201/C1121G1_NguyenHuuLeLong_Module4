<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/31/2022
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Setting box</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/save" method="post" modelAttribute="mail">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><label>Languages:</label></td>
                <td>
                    <form:select path="language">
                        <form:options items="${languageList}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><label>Page size:</label></td>
                <td>Show <form:select path="page_size">
                    <form:options items="${pageSizeList}"/>
                </form:select>
                    email per page
                </td>
            </tr>
            <tr>
                <td><label>Spams filler:</label></td>
                <td>
                    <form:checkbox path="spams_filter" />Enable spams filter
                </td>
            </tr>
            <tr>
                <td><label>Signature:</label></td>
                <td>
                    <form:textarea path="signature"   cols="50" rows="2" value ="Long" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button>Update</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
