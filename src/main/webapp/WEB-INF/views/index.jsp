<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="e" uri="http://www.springframework.org/tags" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.2.0/lodash.js"></script>
<script src="../../assests/js/react.js"></script>
<script src="../../assests/js/react-dom.js"></script>
<script src="../../assests/js/browser.min.js"></script>
<script src="../../assests/js/EventEmitter.js"></script>
<script src="../../assests/js/sweetalert.min.js"></script>
<script type="text/babel" src="../../assests/js/ads.js"></script>
<link rel="stylesheet" type="text/css" href="../../assests/js/sweetalert.css">
<link rel="stylesheet" type="text/css" href="../../assests/css/spa.css" media="all">
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

<div class="main">
    <%@ include file="header.jsp" %>
    <div style="float: left; width: 250px; height: 600px; background-color: white;">
        <div style="height: 30px; background-color: #d5d5d5; text-align: center ">
            <div>123 ads</div>
        </div>
        <form style="font-size: 18px; margin-left: 30px; margin-top: 40px">
            <div>
                <div>price</div>
                <input class="inputMenu" type="text" id="minPrice" name="minPrice" size="20px"> - <input
                    class="inputMenu" type="text" id="maxPrice" name="maxPrice">
            </div>
            <div class="">
                <div class="">
                    <div>make</div>
                </div>
                <div>
                    <select class="selectMenu" id="make" name="make">
                        <option value="1">honda</option>
                        <option value="2">mercedes-benz</option>
                        <option value="3">dodge</option>
                    </select>
                </div>
            </div>
            <div class="">
                <div class="">
                    <div>model</div>
                </div>
                <div>
                    <select class="selectMenu" id="model" name="model">
                        <option value="1">civik</option>
                        <option value="2">accord</option>
                        <option value="3">crv</option>
                    </select>
                </div>
            </div>
            <div>
                <div>year</div>
                <input class="inputMenu" type="text" id="minYear" name="minYear" size="20px"> - <input
                    class="inputMenu" type="text" id="maxYear" name="maxYear">
            </div>
            <div class="container">
                <button class="btn" type="submit" value="Submit">apply</button>
            </div>
            <div class="container">
                <button class="btn" type="submit" value="Submit">clean</button>
            </div>

        </form>
    </div>
    <div style="width: 940px; height: 3000px;float: left; ">
        <div style="height: 30px;">
            <div style="height: 30px; width: 690px; background-color: #d5d5d5; float: left"></div>
            <div style="height: 30px; width: 100px; background-color: #d5d5d5; float: left; text-align: center; ">
                <div>years</div>
            </div>
            <div style="height: 30px; width: 150px; background-color: #d5d5d5; float: left; text-align: center">
                <div>price</div>
            </div>
        </div>
        <div id="root"></div>
    </div>
    <div style="float: right; width: 250px; height: 600px; background-color: #d5d5d5">
        <div style="height: 30px; background-color: #d5d5d5; text-align: center ">
            <div>here can be your ads
            </div>
        </div>
        <img style="align-content: center; width: 250px; height: 570px;"
             src="assests/pictures/adsMB.gif"
        />
    </div>
</div>
</body>
