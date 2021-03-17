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
    <link rel="stylesheet" href="css/register.css"
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <!-- Reference Bootstrap files -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css
" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js
" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <img class="image" src="image/submarine.png">
        <div class="row">

            <div class="empty col-md-4 align-self-center">
            </div>

            <div class="col-md-4 loginbox">

                <div class="mainbox ">

                    <!-- Login Form -->
                    <form method="POST">
                        <c:if test="${isPlayerNameIncorrect}">
                            <p class="error">Player name is too short</p>
                        </c:if>

                        <div class="panel panel-group">

                            <div>
                                <h1 class="battle">Registration</h1>
                            </div>

                            <div class="form">

                                <!-- User name -->
                                <div class="panel, panel-info">
                                    <label class="info" for="playerNameInput">Enter your user name details below</label>
                                    <input class="form-control" type="text" id="playerNameInput" placeholder="User Name" name="playerName" value="${playerName}">
                                </div>

                                <!-- Login/Submit Button -->
                                <div class="button">
                                    <div class="controls">
                                        <button type="submit" class="btn btn-success">Start</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="empty col-md-4 align-self-center">
            </div>
        </div>
    </div>
</body>
</html>
