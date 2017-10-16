<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD Book Application</title>

    <%--<link rel="stylesheet" href="resources/static/bootstrap/css/bootstrap.min.css"/>--%>
    <%--<script src="resources/static/jquery.min.js"></script>--%>
    <%--<script src="resources/static/bootstrap/js/bootstrap.min.js"></script>--%>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
<h3>List of books is here:</h3>
<br/>
<a href="<c:url value="/books/1"/>" target="_self">Books list</a>
<br/>
<a href="<c:url value="/search"/>" target="_self">Search books</a>
        </div>
    </div>
</div>

</body>
</html>
