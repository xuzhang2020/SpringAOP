<%--
  Created by IntelliJ IDEA.
  User: sophiexu
  Date: 6/25/22
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String loginPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/login";
    String bookPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/book";
%>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    <script type="text/javascript">
        function submit() {
            alert("1");
            var name= document.getElementById("name").value;
            var password= document.getElementById("password").value;
            alert(name);
            alert(password);


            var stringify = JSON.stringify("{'name':'" + name + "','password':'" + password + "'}");
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.open("POST","<%=loginPath%>",true);
            xmlhttp.setRequestHeader('Content-Type', 'application/json');
            alert(stringify);
            xmlhttp.send('{"name":"' + name + '","password":"' + password + '"}');
            xmlhttp.onreadystatechange = function(){
                if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var data = JSON.parse(xmlhttp.responseText);
                    if(data.code==200){
                        alert("Login succeed!");
                        window.location.href="<%=bookPath%>";
                    } else {
                        alert(data.message);
                    }
                }
            }
        }
    </script>
</head>

<body>
<% Object message=session.getAttribute("message"); if (message !=null && !"".equals(message)) { %>
<script type="text/javascript">
    alert("<%=message%>");
</script>
<%} %>
<div id="box" style="width:350px; margin:auto; text-align:center;padding-top: 150px;">
    <!--action="login" method="post" -->
    <!--<form id="form" method="POST" action="/login?redirect=${param.redirect}">-->
    <form id="form" method="POST" action="/login">
    <!--    <fieldset>-->
        <h1>User Login</h1>
        <p><input placeholder="Login Name" type="text" name="name" id="name" /></p>
        <p><input placeholder="Password" type="password" name="password" id="password" /></p>
            </fieldset>
        <!--<fieldset>-->
        <p><input id="submit" type="submit" value="Submit" /></p>
        <!--</fieldset>-->
    </form>
</div>
</body>

</html>
<style>
    input {
        height: 36px;
        width: 350px;
        padding: 4px 7px;
        font-size: 14px;
        border: 1px solid #dcdee2;
        border-radius: 4px;
        color: #515a6e;
    }

    #submit {
        margin-top: 10px;
        background: #2d8cf0;
        color: #fff;
        border: 0;
    }

    .account-other {
        text-align: right;
    }

    .account-other a {
        text-decoration: none;
        color: #2d8cf0;
        font-size: 12px;
    }
</style>