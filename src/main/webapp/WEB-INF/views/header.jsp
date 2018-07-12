<e:url value="/j_spring_security_check" var="loginUrl"/>
<link rel="stylesheet" type="text/css" href="../../assests/css/formLogin.css">
<div style="width: 100%; height: 150px; background-color: white">
    <div style="float: left; width: 70%; height: 100px; margin-top: 10px;">
        <div style="">
            <div style="float: right; width: 35%; height: 30%;text-align: center; font-size: 300%;
             font: 'Franklin Gothic Book'; font-weight: bold; color: #333333;">
                PRE - OWNED<br>CARS
            </div>
            <img style="align-content: center; width: 65%; height: 100px; margin-top: 20px"
                 src="assests/pictures/header.jpg"
            />
        </div>
    </div>

    <div style="float: right; width: 30%; height: 100px;">
        <c:choose>
            <c:when test="${userName=='null'}">
                <div class="form">
                    <form class="login-form" method="post" action="${loginUrl}">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input id="j_username" name="j_username" type="text" placeholder="login">
                        <input id="j_password" name="j_password" type="password" placeholder="password">
                        <div id="errorLogin"></div>
                        <button>Sign in</button>
                        <p class="message">Not registered? <a href="/signUp">Create an account</a></p>
                            <%--<button type="submit" class="btn">Sign in</button>--%>
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <div style="margin: 5% 5%;">
                    <div style="float: left; width: 70%; height: 100%">
                        <div style="text-align: center; width: 100%">Hi, ${userName}</div>
                        <div style="text-align: center; width: 100%">info</div>
                        <div>
                            <c:url var="logoutUrl" value="/logout"/>
                            <form action="${logoutUrl}"
                                  method="post" class="login-form">
                                <button type="submit"
                                        value="Log out"> Logout
                                </button>
                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>
                            </form>
                        </div>
                    </div>
                    <div style="background-color: #0000cc; float: left; width: 30%; height: 100%">Picture</div>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</div>
