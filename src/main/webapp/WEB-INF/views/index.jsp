<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="e" uri="http://www.springframework.org/tags" %>
<script src="http://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../../css/spa.css" media="all">
<head>
    <title>Pre-owned cars</title>
</head>
<%@ include file="header.jsp" %>
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