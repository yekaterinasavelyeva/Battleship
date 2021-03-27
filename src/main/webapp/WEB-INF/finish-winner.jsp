<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BattleShip Winner</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/finish.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<img class="image" src="image/submarine.png">
<div class="container winner w3-card-4 w3-display-middle w3-center w3-round-xlarge">
    <h1>${player.name}, you have won the battle!</h1>
    <form method="POST">
        <button type="submit" href="finish" class="button w3-button w3-xlarge w3-round-xxlarge w3-theme-gradient w3-text-white">Start Over</button>
    </form>
</div>
<div class="w3-display-bottomleft w3-padding-large">
    2021 &copy; Jekaterina Saveljeva</a>
</div>
</body>
</html>
