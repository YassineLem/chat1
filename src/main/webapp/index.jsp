<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link href="css/cs1.css" rel="stylesheet" />
</head>
<body>
<div class="wrapper">
    <div class="login-text">
        <button class="cta"><i class="fas fa-chevron-down fa-1x"></i></button>
        <div class="text">
            <form method="post" action="hello-servlet">
            <a href="">Login</a>
            <hr />
            <br />
            <input type="text" placeholder="Username" name="username" />
            <br />
            <!-- <input type="password" placeholder="Password" />
            <br /> -->
            <button class="login-btn">Log In</button>
            </form>
            <!-- <button class="signup-btn">Sign Up</button> -->
        </div>
    </div>
    <div class="call-text">
        <h1>bienvenue dans le <span>chat</span></h1>
        <button>rejoindre chat</button>
    </div>
</div>
</body>
<script src="js/sc.js"></script>
</html>
