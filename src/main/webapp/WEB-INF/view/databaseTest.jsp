<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:forEach items="${objs}" var="obj">
        <h1><c:out value="${obj.name}"/></h1>
    </c:forEach>
</body>
</html>
