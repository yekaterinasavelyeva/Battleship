<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>BattleShip Records</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/records.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="container w3-display-container">
<img class="image" src="image/submarine.png">
    <div class="box w3-display-middle w3-card w3-round-xlarge">
        <div class="w3-container w3-padding-large w3-center">
            <h1>BattleShip Best Results</h1>

        <table>
            <thead>
                <th>Id</th>
                <th>Name</th>
                <th>Points</th>
            </thead>
            <tbody>
            <c:forEach items="${records}" var="i">
                <tr>
                    <td> ${i.id}</td>
                    <td> ${i.name}</td>
                    <td> ${i.points}</td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
        </div>
    </div>
</div>

<div class="w3-display-bottomleft w3-padding-large">
    2021 &copy; Jekaterina Saveljeva</a>
</div>
</body>
</html>
