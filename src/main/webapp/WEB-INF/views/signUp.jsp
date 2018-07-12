<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../../assests/css/formLogin.css">
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="margin: 15% 35%; width: 30%; height: 30%;">
    <div class="form">
        <form class="login-form">
            <s:form id="registrationForm" action="reg" modelAttribute="userForm" method="post">

                    <input type="text" id="login" name="login" placeholder="login"/>
                    <input type="text" id="name" name="name" placeholder="name"/>
                    <input type="text" id="surname" name="surname" placeholder="surname"/>
                    <input type="password" id="password" name="password" placeholder="password"/>
                    <input type="text" id="email" name="email" placeholder="email address"/>
                    <button id="OKreg" name="OKreg">create</button>
                    <p class="message"><a href="/">Go back</a></p>

            </s:form>
        </form>
    </div>
</div>


<footer class="navbar-fixed-bottom row-fluid">
    <div class="container">
        error<p>${jsp_error}</p>
        message<p><span style="color: darkred; ">${jsp_message} </span></p>
    </div>
</footer>
</body>
</html>




