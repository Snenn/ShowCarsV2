<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="e" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="../../assests/css/formLogin.css">

<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<meta name="viewport" content="width=device-width">
<head>
    <title>Pre-owned cars</title>
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

<p class="message"><a href="/user">Go back</a></p>

<form id="createAdForm" action="/user/createAdToBase?${_csrf.parameterName}=${_csrf.token}" method="post"
      encType="multipart/form-data">
    <div class="createAd">
        <div class="ad1">
            <div>
                <div>make</div>
                <select style="width: 90%; height: 10%" id="selectMake" onchange="changeFunc();">
                    <c:forEach items="${manufacturers}" var="manufacturer">
                        <option value="${manufacturer.id}">${manufacturer.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <div>model</div>
                <select style="width: 90%; height: 10%" id="selectModel">
                    <c:forEach items="${models}" var="model">
                        <option value="${model.id}">${model.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>year</div>
            <input style="width: 90%; height: 10%" type="text" id="year" name="year" onkeypress="return checkNumbers()">
            <div>price</div>
            <input style="width: 90%; height: 10%" type="text" id="price" name="price" onkeypress="return checkNumbers()">
        </div>
        <div class="ad2">
            <div>description</div>
            <textarea rows="6" type="text" id="description" name="description" class='inputAdDesc'
                      maxlength="200"></textarea>
            <input type="file" accept="image/*" id="photo" name="photo" value="choose image">
        </div>
        <div>
            <button class="btn" type="submit">save Ad</button>
        </div>
        <br><br>
        ${message}

    </div>
</form>

<script>

    year.oncut = year.oncopy = year.onpaste = function (event) {
        return false;
    };

    price.oncut = price.oncopy = price.onpaste = function (event) {
        return false;
    };

    function checkNumbers(e) {

        e = e || event;

        if (e.ctrlKey || e.altKey || e.metaKey) return;

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

    function changeFunc() {
        var selectBox = document.getElementById("selectMake");
        var selectedValue = selectBox.options[selectBox.selectedIndex].value;

        var req = new XMLHttpRequest();
        req.responseType = 'json';
//        var url = 'http://localhost:8080/getModels';
        var url = 'https://showcarsv2.herokuapp.com/getModels';
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


