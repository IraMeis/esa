<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
    <title>Dish</title>
</head>

<body>
<h1>Привет еда</h1>
<p/>
<a href="${pageContext.request.contextPath}/dish">all dishes</a>
<a href="${pageContext.request.contextPath}/dish/create?ingCount=10">new dish</a>
<a href="${pageContext.request.contextPath}/ingredient">all ingredients</a>
<a href="${pageContext.request.contextPath}/ingredient/create">new ingredient</a>
</body>

</html>