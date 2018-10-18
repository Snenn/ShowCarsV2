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
<script src="../../assests/js/library/react.js"></script>
<script src="../../assests/js/library/react-dom.js"></script>
<script src="../../assests/js/library/browser.min.js"></script>
<script src="../../assests/js/library/EventEmitter.js"></script>
<script src="../../assests/js/library/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../assests/js/library/sweetalert.css">
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
                <div>make</div>
                <select class="selMenu" id="selectMake" onchange="changeFunc();">
                    <option value="0">any</option>
                    <c:forEach items="${manufacturers}" var="manufacturer">
                        <option value="${manufacturer.id}">${manufacturer.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <div>model</div>
                <select class="selMenu" id="selectModel">
                    <option value="0">any</option>
                </select>
            </div>
            <div>
                <div>price</div>
                <input class="inputMenu" type="text" id="minPrice" name="minPrice" size="20px" onkeypress="return checkNumbers()"> - <input
                    class="inputMenu" type="text" id="maxPrice" name="maxPrice" onkeypress="return checkNumbers()">
            </div>

            <div>
                <div>year</div>
                <input class="inputMenu" type="text" id="minYear" name="minYear" size="20px" onkeypress="return checkNumbers()"> - <input
                    class="inputMenu" type="text" id="maxYear" name="maxYear" onkeypress="return checkNumbers()">
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
            Back end: Java,  Spring, Hibernate, MySQL,  manage image with Cloudinary<br>
            Front end: JSP, CSS, JavaScript, dynamic part render with ReactJS<br>
            Build - Maven<br>
            Control version - Git<br>
            Deploy on heroku<br>
            <br>
            Spring security use 2 roles - USER, ADMIN<br>
            for example<br>
            Admin: login - admin, password - admin<br>
            User:  login - Mik,   password - 1<br>
            also you can create new User<br>
        </div>

    </div>
</a>
<script type="text/babel" src="../../assests/js/render.js"></script>
<script>
    minPrice.oncut = minPrice.oncopy = minPrice.onpaste = function(event) {
        return false;
    };
    maxPrice.oncut = maxPrice.oncopy = maxPrice.onpaste = function(event) {
        return false;
    };
    minYear.oncut = minYear.oncopy = minYear.onpaste = function(event) {
        return false;
    };
    maxYear.oncut = maxYear.oncopy = maxYear.onpaste = function(event) {
        return false;
    };

    function checkNumbers(e) {

        e = e || event;

        if (e.ctrlKey || e.altKey) return;

        var chr = getChar(e);

        // с null надо осторожно в неравенствах, т.к. например null >= '0' => true!
        // на всякий случай лучше вынести проверку chr == null отдельно
        if (chr == null) return;

        if (chr < '0' || chr > '9') {
            return false;
        }

    }

    function getChar(event) {
        if (event.which == null) {
            if (event.keyCode < 32) return null;
            return String.fromCharCode(event.keyCode) // IE
        }

        if (event.which != 0 && event.charCode != 0) {
            if (event.which < 32) return null;
            return String.fromCharCode(event.which) // остальные
        }

        return null; // специальная клавиша
    }
</script>
<script>
    function changeFunc() {
        var selectBox = document.getElementById("selectMake");
        var selectedValue = selectBox.options[selectBox.selectedIndex].value;

        var req = new XMLHttpRequest();
        req.responseType = 'json';
        var url = 'http://localhost:8080/getModels';
        req.open('GET', url, true);
        req.send();
        var json;
        req.onreadystatechange = function () {
            if (req.readyState === 4 && req.status === 200) {
                json = req.response;
                writeOptions(json, selectedValue);
            }
        }


        function writeOptions(data, id) {

            var root = document.getElementById("selectModel");
            while (root.hasChildNodes()) {
                root.removeChild(root.firstChild);
            }
            var option0 = document.createElement('option');
            option0.value = "0";
            option0.innerHTML= "any";
            root.appendChild(option0);

            data.map((item) => {
                if (item.manufacturer_id == id) {
                    var option = document.createElement('option');
                    option.value=item.id;
                    option.innerHTML=item.name;
                    root.appendChild(option);
                }

            });
        }
    }


</script>
</body>
