<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="e" uri="http://www.springframework.org/tags" %>

<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<meta name="viewport" content="width=device-width">
<head>
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
<div class="main">
    <%@ include file="header.jsp" %>

    <div style="margin-left: 5%; margin-top: 2%">
        <button class="btn" id="ads">ads</button>
        <button class="btn" id="users">users</button>
        <button class="btn" id="register">register</button>
    </div>
    <div id="root" style="margin-left: 15%; margin-top: 2%;  width: 70%"></div>

</div>

<script type="text/babel" src="../../assests/js/admin.js"></script>
</body>
