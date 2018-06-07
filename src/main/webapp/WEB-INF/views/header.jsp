<e:url value="/j_spring_security_check" var="loginUrl"/>
<div style="width: 1440px; height: 150px; background-color: white">
    <div style="float: left; width: 1000px; height: 100px; margin-top: 15px;">
        <div style="">
            <div style="float: right; width: 300px; height: 40px;text-align: center; font-size: 42px;
             font: 'Franklin Gothic Book'; font-weight: bold; color: #333333 ">
                PRE - OWNED<br>CARS
            </div>
            <img style="align-content: center; width: 700px; height: 100px; margin-top: 20px"
                 src="assests/pictures/header.jpg"
            />
        </div>
    </div>

    <div style="float: right; width: 400px; height: 100px;">
        <c:choose>
            <c:when test="${userName=='null'}">
                <div style="width: 235px; float: left;">
                    <form class="form-group" method="post" action="${loginUrl}">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input id="j_username" name="j_username" type="text" style="margin-left: 20px; margin-top: 10px"
                               placeholder="login">
                        <input id="j_password" name="j_password" type="password"
                               style="margin-left: 20px; margin-top: 10px"
                               placeholder="password">
                        <div class="container">
                            <button type="submit" class="btn">Sign in</button>
                        </div>
                    </form>
                </div>
                <div style="float: left; margin-top: 40px; font-size: 24px">or</div>
                <div class="container" style="float: left; margin-top: 20px; margin-left: -30px">
                    <a href="/signUp" ><button class="btn" style="white-space: normal">create new account</button></a>
                </div>
            </c:when>
            <c:otherwise>
                Hi, ${userName}
                <c:url var="logoutUrl" value="/logout"/>
                <form action="${logoutUrl}"
                      method="post">
                    <input type="submit"
                           value="Log out"/>
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>
            </c:otherwise>
        </c:choose>

    </div>
</div>
