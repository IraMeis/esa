<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>new ingredient</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/ingredient/create" method="post">
  <label>
    name
    <input name="name" required>
  </label>
  <div>
    <button type="submit">create</button>
  </div>
</form>
</body>

</html>