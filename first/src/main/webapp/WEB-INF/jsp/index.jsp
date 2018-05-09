<%@page contentType="text/html;charset=utf-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>就这个调调</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <style type="text/css">
            .form-signin {
                max-width: 330px;
                padding: 15px;
                margin: 0 auto;
            }
            input {
                margin-bottom: 3px;
            }
        </style>
    </head>
    <body onload='document.f.username.focus();'>            
            <h3></h3>
            <form name='f' action='/login' method='post' enctype="application/x-www-form-urlencoded">
            <table>
                <tr><td>用户名</td><td><input type='text' name='username' value=''></td></tr>
                <tr><td>面膜</td><td><input type='password' name='password'/></td></tr>
                <tr><td colspan='2'><input name="submit" type="submit" value="ç»é"/></td></tr>
                <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </table>
            </form>
             <form name='nameform' action="/test/upload" method="post"  enctype="multipart/form-data" > 
                <input type='file' name='file'></input>
                <br>
                <button type="submit"  value="提交">提交</button>
             </form>
    </body>
</html>