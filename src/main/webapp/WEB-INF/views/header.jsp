<div style="width: 1300px; height: 100px;margin-left: 100px; margin-top: 5px; border-radius: 5px">
    <div style="float: left; width: 900px; height: 100px; margin-top: 5px">
        <div style="">
            <div style="float: right; width: 300px; height: 40px;text-align: center; font-size: xx-large; font: 'Franklin Gothic Book'; ">
                PRE - OWNED<br>CARS
            </div>
            <img style="align-content: center; width: 600px; height: 80px" src="assests/pictures/header.jpg"
                 class="img-rounded img-responsive"/>
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
                <button style="width: 70px; height: 70px"><a href="/logout"> logout</a></button>
            </form>
        </div>
        <div style="float: left; margin-top: 40px">or</div>
        <div style="margin-top: 20px; margin-left: 300px">
            <button style="width: 70px; height: 70px"><a href="/signUp"> create new account</a></button>
        </div>
    </div>
</div>
