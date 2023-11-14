<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>new dish</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/dish/create" method="post">
<div>
<div>
      <label>
        name
        <input name="name" required>
      </label>
      <label>
         portion
         <input name="portion" type="number" required>
      </label>
      <label>
        recipe
        <input name="recipe" required>
      </label>
  <div/>
  <div>
      <label>
        min time
        <input name="timeMin" required>
      </label>
      <label>
        max time
        <input name="timeMax" required>
      </label>
  <div/>
<div/>

<div>

    <%
    Integer ingCount = Integer.parseInt((String)request.getAttribute("ingCount"));
    for(int i = 0; i < ingCount; i+=1) {
      request.setAttribute("i", i);
    %>
    <div>
          <label>
            ingredient
            <select name="ingredient${i}">
                <c:forEach items="${allIngredients}" var="ing">
                    <option value="${ing.uniqueId}">${ing.name}</option>
                </c:forEach>
            </select>
          </label>
          <label>
            volume
          <input name="volume${i}" type="number" required>
          </label>
          <label>
            unit
            <select name="unit${i}">
                <c:forEach items="${allUnits}" var="un">
                    <option value="${un.code}">${un.name}</option>
                </c:forEach>
            </select>
          </label>
    <div/>
    <% } %>

<div/>

  <div>
    <button type="submit">create</button>
  </div>
</form>
</body>

</html>