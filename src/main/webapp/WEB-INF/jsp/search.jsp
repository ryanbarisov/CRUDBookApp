<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Search Results</title>
</head>
<body>

<br>
<a href="<c:url value='/'/>">Back to main menu</a>
<br>
<br>

<c:url var="search" value="/books"/>

<form:form action="${search}" method="post">
    <table>
        <tr>Title <input name="title" type="text" value=""/></tr><br>
        <tr>Author <input name="author" type="text" value=""/></tr><br>
        <tr>Year <input name="year" type="number" value=""/> </tr><br>
        <tr>Read already<input name="read" type="checkbox"/></tr><br>
        <tr>Submit <input type="submit" value="Search"/></tr><br>
    </table>
</form:form>

</body>
</html>
