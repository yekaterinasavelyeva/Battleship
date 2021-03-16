<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: katja
  Date: 15/03/2021
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Battleship Registration</title>
</head>
<body>
    <form method="post">
        <c:if test="${isPlayerNameIncorrect}">
            <p>Player name is too short</p>
        </c:if>
        <label for="playerNameInput">Enter name</label>
        <input type="text" id="playerNameInput" name="playerName" value="${playerName}">
        <button type="submit">Start</button>
    </form>
</body>
</html>
