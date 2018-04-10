<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles"   uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"     uri="http://www.springframework.org/security/tags" %>
<e:url value="/j_spring_security_check" var="loginUrl" />
<link rel="stylesheet" type="text/css" href="../../css/spa.css" media="all">
<head>
    <title>Pre-owned cars</title>
</head>
<div style="width: 1300px; height: 100px;margin-left: 100px; margin-top: 5px; border-radius: 5px">
    <div style="float: left; width: 900px; height: 100px; margin-top: 5px">
        <div style="">
            <div style="float: right; width: 300px; height: 40px;text-align: center; font-size: xx-large; font: 'Franklin Gothic Book'; ">
                PRE - OWNED<br>CARS
            </div>
            <img style="align-content: center; width: 600px; height: 80px"
                 src="<c:url var="header" value="/assests/pictures/header.jpg"/>">
        </div>
    </div>
    <div style="float: right; width: 400px; height: 100px; background-color: rgba(255,255,255,0.9);">
        <div style="width: 235px; float: left">
            <form class="form-group" method="post" action="${loginUrl}">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input id="j_username" name="j_username" type="text" style="margin-left: 20px; margin-top: 10px"
                       placeholder="login">
                <input id="j_password" name="j_password" type="password" style="margin-left: 20px; margin-top: 10px"
                       placeholder="password">
                <button type="submit" style="margin-left: 70px; margin-top: 10px">login</button>
            </form>
        </div>
        <div style="float: left; margin-top: 40px">or</div>
        <div style="margin-top: 20px; margin-left: 300px">
            <button style="width: 70px; height: 70px" href="/signUp">create new account</button>
        </div>
    </div>
</div>
<div style="width: 1300px; height: 30px;background-color: rgba(178,208,255,0.9); margin-left: 100px; margin-top: 5px; border-radius: 5px"></div>
<div style="float: left; width: 310px; height: 570px"></div>
<div style="width: 1300px; height: 570px;background-color: rgba(178,208,255,0.9); margin-left: 100px; margin-top: 5px; border-radius: 5px">
    <div>
        <div class="adverColomn" style="width: 150px;float: left">photo</div>
        <div class="adverColomn" style="width: 775px">
            <div style="height: 30px; border-color: black; background-color: aqua">make+model+year</div>
            <div style="height: 120px">description</div>
        </div>
        <div class="adverColomn" style="width: 150px">price</div>
    </div>
    <div>
        <div class="adverColomn" style="width: 150px;float: left">photo</div>
        <div class="adverColomn" style="width: 775px">
            <div style="height: 30px; border-color: black; background-color: aqua">make+model+year</div>
            <div style="height: 120px">description</div>
        </div>
        <div class="adverColomn" style="width: 150px">price</div>
    </div>
    <div>
        <div class="adverColomn" style="width: 150px;float: left">photo</div>
        <div class="adverColomn" style="width: 775px">
            <div style="height: 30px; border-color: black; background-color: aqua">make+model+year</div>
            <div style="height: 120px">description</div>
        </div>
        <div class="adverColomn" style="width: 150px">price</div>
    </div>
    <div>
        <div class="adverColomn" style="width: 150px;float: left">photo</div>
        <div class="adverColomn" style="width: 775px">
            <div style="height: 30px; border-color: black; background-color: aqua">make+model+year</div>
            <div style="height: 120px">description</div>
        </div>
        <div class="adverColomn" style="width: 150px">price</div>
    </div>
</div>


<button><a href="/showCars"> Show cars!</a></button>
</html>