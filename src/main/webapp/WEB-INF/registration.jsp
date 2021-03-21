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

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-red.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-2021.css">
</head>
<body>
    <div class="container w3-display-container w3-animate-opacity w3-text-white">
        <img class="image" src="image/submarine.png">
        <div class="box w3-display-middle w3-round-xxlarge">
        </div>
        <div class="card w3-display-middle w3-center">
            <form method="POST">
                <c:if test="${isPlayerNameIncorrect}">
                    <p class="error">Player name is too short</p>
                </c:if>
                <h1 class="battle w3-center w3-animate-opacity">Registration</h1>
                <label class="info" for="playerNameInput">Enter your user name details below</label>
                <input class="w3-input w3-border w3-round-large" type="text" id="playerNameInput" placeholder="User Name" name="playerName" value="${playerName}">
                <button type="submit" href="registration" class="button w3-button w3-xlarge w3-round-xxlarge w3-theme-gradient w3-text-white">Start</button>
            </form>
        </div>
        <div class="w3-display-bottomleft w3-padding-large">
            2021 &copy; Jekaterina Saveljeva</a>
        </div>
    </div>
</body>
</html>
