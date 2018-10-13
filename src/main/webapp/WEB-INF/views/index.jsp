<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="e" uri="http://www.springframework.org/tags" %>

<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<meta name="viewport" content="width=device-width">
<head>
    <%--<style>body { background:url("../../resourses/images/homeBackground.jpg")}    </style>--%>
    <style>body {
        background: whitesmoke;
    )
    }</style>
    <title>Pre-owned cars</title>
    <link href="../../assests/css/spa.css" rel="stylesheet"/>
    <link rel="shortcut icon" href="../../assests/pictures/logo.png"/>
</head>

<body>
<script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.2.0/lodash.js"></script>
<script src="../../assests/js/react.js"></script>
<script src="../../assests/js/react-dom.js"></script>
<script src="../../assests/js/browser.min.js"></script>
<script src="../../assests/js/EventEmitter.js"></script>
<script src="../../assests/js/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../assests/js/sweetalert.css">
<link rel="stylesheet" type="text/css" href="../../assests/css/spa.css" media="all">
<link rel="stylesheet" type="text/css" href="../../assests/css/buttonClickMe.css" media="all">
<div class="main">
    <%@ include file="header.jsp" %>
    <div style="position: absolute; top: 190px; left: 880px">
        <div class="demo-btns">
            <div class="buttons">
                <p>
                    <a href="#ClickMe" class="modal__trigger">Click Me</a>
                </p>
            </div>
        </div>
    </div>

    <div style="float: left; width: 20%; height: 600px; background-color: white;">
        <div style="height: 30px; background-color: #d5d5d5; text-align: center">
            <div></div>
        </div>
        <div style="margin-top: 20%;margin-left: 10%">
            <div>
                <div>price</div>
                <input class="inputMenu" type="text" id="minPrice" name="minPrice" size="20px"> - <input
                    class="inputMenu" type="text" id="maxPrice" name="maxPrice">
            </div>

            <div>
                <div>year</div>
                <input class="inputMenu" type="text" id="minYear" name="minYear" size="20px"> - <input
                    class="inputMenu" type="text" id="maxYear" name="maxYear">
            </div>
            <div class="container">
                <button class="btn" value="apply" id="filterApply">apply</button>
            </div>
            <div class="container">
                <button class="btn" value="clear" id="filterClear">clear</button>
            </div>
        </div>
    </div>
    <div style="width: 60%; height: 3000px;float: left;background-color: #d5d5d5; float: left; text-align: center;">
        <div style="height: 30px; width: 100%;">
            <div style="height: 30px; width: 75%; float: left"></div>
            <div style="height: 30px; width: 10%; float: left">
                <a>years</a>
            </div>
            <div style="height: 30px; width: 15%; float: left">
                <a>price</a>
            </div>
        </div>
        <div id="root"></div>
    </div>
    <div style="float: left; width: 20%; height: 600px; background-color: #d5d5d5">
        <div style="height: 30px; width: 100%; background-color: #d5d5d5; text-align: center ">
            <div></div>
        </div>
        <img style="align-content: center; width: 100%; height: 570px;"
             src="assests/pictures/adsMB.gif"
        />
    </div>
</div>


<a href="#" id="ClickMe" class="clickMe">
    <div id="okno" class="okno">
        <div style="float: left; width: 75%; height: 40%">
            Greetings <br>
            I'm Mikalai Sniahurski <br>
            This is my training website to show my skills
        </div>
        <div style="float: left; width: 25%; height: 40%"><img style=""
                                                               src="assests/pictures/photo.jpg"
        /></div>
        <div style="text-align: left">
            I'm using tools here:<br>
            Java, JSP, Spring, Spring Security, Hibernate, MySQL, CSS, JS, React<br>
            Build - Maven<br>
            Control version - Git<br>
            Deploy on heroku<br>
            <br>
            You can use login: Mik password: 1 or create self new user
        </div>

    </div>
</a>
<script type="text/babel" src="../../assests/js/render.js"></script>
</body>
