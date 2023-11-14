<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>dish</title>
</head>

<body>
<h1>all dishes</h1>
<a href="${pageContext.request.contextPath}/dish/create?ingCount=10">create new dish</a>
<p/>

<table>

    <thead>
    <tr>
        <td>№</td>
        <td>name</td>
        <td>view</td>
        <td>delete</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${dishes}" var="a" varStatus="idx">
        <tr>
            <td>${idx.getIndex()+1}</td>
            <td>${a.name}</td>
            <td>
                <form action="${pageContext.request.contextPath}/dish/view" method="get">
                    <label>
                        <input name="id" value="${a.uniqueId}" hidden>
                    </label>
                    <div>
                        <button type="submit">view</button>
                    </div>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/dish/delete" method="post">
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