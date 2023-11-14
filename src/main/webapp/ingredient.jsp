<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>ingredient</title>
</head>

<body>
<h1>all ingredients</h1>
<a href="${pageContext.request.contextPath}/ingredient/create">create new ingredient</a>

<br/>

<table>

    <thead>
    <tr>
        <td>№</td>
        <td>name</td>
        <td>delete</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${ingredients}" var="a" varStatus="idx">
        <tr>
            <td>${idx.getIndex()+1}</td>
            <td>${a.name}</td>
            <td>
                <form action="${pageContext.request.contextPath}/ingredient/delete" method="post">
                    <label>
                        <input name="id" value="${a.uniqueId}" hidden>
                    </label>
                    <div>
                        <button type="submit">delete</button>
                    </div>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>