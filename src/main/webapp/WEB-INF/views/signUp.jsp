<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="../../assests/css/formLogin.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin: 15% 35%; width: 30%; height: 30%;">
    <div class="form">
        <s:form class="login-form" id="registrationForm" action="/signUp/reg" modelAttribute="userForm" method="post">
            <span style="color: darkred; ">${jsp_message} </span><br>
            <input type="text" id="login" name="login" placeholder="login"/>
            <input type="text" id="name" name="name" placeholder="first name"/>
            <input type="text" id="surname" name="surname" placeholder="last name"/>
            <input type="password" id="password" name="password" placeholder="password"/>
            <input type="text" id="email" name="email" placeholder="email address"/>
            <button>create</button>
            <p class="message"><a href="/">Go back</a></p>

        </s:form>
    </div>
</div>


</body>
</html>




