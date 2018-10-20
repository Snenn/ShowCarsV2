<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.2.0/lodash.js"></script>
<link rel="stylesheet" type="text/css" href="../../assests/css/formLogin.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin: 10% 35%; width: 40%; height: 30%;">
    <div style="width: 100%; height: 15%; margin-left: 10%; color: red">${jsp_message}</div>
    <s:form class="login-form" id="registrationForm" action="/signUp/reg" modelAttribute="userForm" method="post"
            onsubmit="return checkFields()">
        <input type="text" id="loginF" name="login" placeholder="login"/>
        <input type="text" id="nameF" name="name" placeholder="first name"/>
        <input type="text" id="surnameF" name="surname" placeholder="last name"/>
        <input type="password" id="passwordF" name="password" placeholder="password"/>
        <input type="text" id="emailF" name="email" placeholder="email address"/>
        <button type="submit">create</button>
        <p class="message"><a href="/">Go back</a></p>
    </s:form>
    <div class="messages">
        <div class="message" id="mLogin"></div>
        <div class="message" id="mName"></div>
        <div class="message" id="mSurname"></div>
        <div class="message" id="mPassword"></div>
        <div class="message" id="mEmail"></div>
    </div>

</div>


<script>

    function checkFields() {
        document.getElementById("mLogin").innerHTML = "";
        document.getElementById("mName").innerHTML = "";
        document.getElementById("mSurname").innerHTML = "";
        document.getElementById("mPassword").innerHTML = "";
        document.getElementById("mEmail").innerHTML = "";

        var status = true;

        if ($('#loginF').val() == "") {
            document.getElementById("mLogin").innerHTML = "fill in the field!";
            status = false;
        }
        if ($('#nameF').val() == "") {
            document.getElementById("mName").innerHTML = "fill in the field!";
            status = false;
        }
        if ($('#surnameF').val() == "") {
            document.getElementById("mSurname").innerHTML = "fill in the field!";
            status = false;
        }
        if ($('#passwordF').val() == "") {
            document.getElementById("mPassword").innerHTML = "fill in the field!";
            status = false;
        }
        if ($('#emailF').val() == "") {
            document.getElementById("mEmail").innerHTML = "fill in the field!";
            status = false;
        }
        return status;
    }

</script>

</body>
</html>




