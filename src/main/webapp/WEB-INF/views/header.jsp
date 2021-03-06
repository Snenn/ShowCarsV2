<e:url value="/j_spring_security_check" var="loginUrl"/>
<link rel="stylesheet" type="text/css" href="../../assests/css/formLogin.css">
<div style="width: 100%; height: 170px; background-color: white">
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

    <div style="float: right; width: 30%; height: 80%;">
        <div><c:choose>
            <c:when test="${userName=='null'}">
                <div class="form">
                    <form class="login-form" method="post" action="${loginUrl}">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input id="j_username" name="j_username" type="text" placeholder="login">
                        <input id="j_password" name="j_password" type="password" placeholder="password">
                        <div id="errorLogin">${errorLogin}</div>
                        <button>Sign in</button>
                        <p class="message">Not registered? <a href="/signUp">Create an account</a></p>
                            <%--<button type="submit" class="btn">Sign in</button>--%>
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <div style="margin: 5% 5%;">
                    <div style="float: left; width: 70%; height: 80%;">
                        <div style="width: 100%; margin-top: 3%; margin-left: 20%">Hi, ${userName}</div>

                        <div>
                            <c:url var="logoutUrl" value="/logout"/>
                            <form action="${logoutUrl}" method="post" class="login-form">
                                <button class="btn" type="submit">Logout</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </div>

                    </div>
                    <div style="; float: left; width: 30%; height: 80%"><img
                            style="align-content: center; width: 100%; height: 100px;"
                            src="assests/pictures/user.jpg"
                    />
                    </div>
                </div>
            </c:otherwise>
        </c:choose></div>
        <div style="align-content: center; width: 100%; text-align: center;">
            <c:if test="${userRole=='ADMIN'}">
                <a href="/admin">admin page</a>
                <a href="/">main page</a>
            </c:if>
            <c:if test="${userRole=='USER'}">
                <a href="/user">user page</a>
                <a href="/">main page</a>
            </c:if>
        </div>
    </div>


</div>
