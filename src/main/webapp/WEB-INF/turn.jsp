<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>BattleShip - Turn</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/turn.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-red.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-2021.css">
</head>
<body>
<img class="image" src="image/submarine.png">
<div class="container w3-display-container">

    <div class="box w3-display-middle w3-card w3-round-xlarge">
        <form class="w3-container w3-padding-large w3-center" method="post">
            <h1>${player.name}, it is your turn to fire!</h1>
            <div class="tables">

                <table class="field">
                    <tr>
                        <td></td>
                        <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                            <td>${col}</td>
                        </c:forEach>
                    </tr>
                    <c:forEach items="1,2,3,4,5,6,7,8,9,10" var="row">
                        <tr>
                            <td>${row}</td>
                            <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                                <c:set var="addr" value="${col}${row}"/>
                                <td class="${player.opponentView[addr]}">
                                    <input  type="radio" name="addr" value="${addr}">
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>

                <table class="field">
                    <tr>
                        <td></td>
                        <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                            <td>${col}</td>
                        </c:forEach>
                    </tr>
                    <c:forEach items="1,2,3,4,5,6,7,8,9,10" var="row">
                        <tr>
                            <td>${row}</td>
                            <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                                <c:set var="addr" value="${col}${row}"/>
                                <td class="${player.playerField[addr]}">
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>

            </div>
            <div class="button w3-container w3-center">
                <button class="w3-button w3-xlarge w3-round-xxlarge w3-theme-gradient w3-text-white" type="submit">Fire</button>
            </div>
        </form>
    </div>
    <div class="history w3-display-bottomright w3-padding-16">
    <c:if test="${fn:length(player.history) > 0 }">
        <c:forEach items="${player.history}" var="msg">
            <p>${msg}</p>
        </c:forEach>
    </c:if>
    </div>
</div>
</body>
</html>
