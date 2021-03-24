<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Placement</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/placement.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-red.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-2021.css">
</head>
<body>
<div class="container w3-display-container">
    <img class="image" src="image/submarine.png">
    <div class="w3-display-middle w3-card">
        <div class="w3-container w3-padding-large w3-center">

            <form method="POST">
                <table>
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
                                <td>
                                    <input class="${player.playerField[addr]}" type="checkbox" name="addr" value="${addr}"
                                    <c:if test="${player.playerField[addr] eq 'SHIP'}">checked</c:if> >

                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
                <button class="w3-button w3-red" type="submit">Ready</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
