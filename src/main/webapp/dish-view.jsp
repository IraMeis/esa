<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>view dish</title>
</head>

<body>
<a href="${pageContext.request.contextPath}/dish">go back</a>
<p/>

<div>
    <p>name : ${o.name}</p>
    <p>recipe : ${o.recipe}</p>
    <p>portion : ${o.portion}</p>
    <p>min time : ${o.timeMin}</p>
    <p>max time : ${o.timeMax}</p>
<div/>

<div>
  <%
    net.morena.esa.entity.Dish dish = (net.morena.esa.entity.Dish) request.getAttribute("o");
    java.util.List<net.morena.esa.entity.IngredientForDish> list
        = new java.util.ArrayList<>(dish.getIngredientForDish());

    for(int i = 0; i < list.size(); i+=1) {
      request.setAttribute("i", i);
      request.setAttribute("name", list.get(i).getIngredient().getName());
      request.setAttribute("volume", list.get(i).getVolume() == null ? "-" : list.get(i).getVolume());
      request.setAttribute("unit", list.get(i).getUnit() == null ? "-" : list.get(i).getUnit().getName());
    %>

    <div>
    <p/>
        <div>ingredient ${i}</div>
        <div>name : ${name}</div>
        <div>volume : ${volume}</div>
        <div>unit : ${unit}</div>
    <div/>
    <% } %>

<div/>

</body>

</html>