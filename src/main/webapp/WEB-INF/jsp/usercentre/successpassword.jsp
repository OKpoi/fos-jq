<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css">
</head>
<body>
<div class="layui-icon layui-icon-tips layui-anim layui-anim-up"
     style="font-size:100px;position: absolute;left: 45%;top: 30%"></div>
<hr class="layui-anim layui-anim-fadein" style="position: absolute;top: 48%;width: 50%;left: 20%">
<h1 class="layui-anim layui-anim-up" style="position: absolute;left: 44%;top: 55%">修改成功！</h1>
<div id="info" class="layui-anim layui-anim-fadein" style="position: absolute;left: 43%;top: 62%;color: grey"></div>


<script type="text/javascript">

    var num = 2; //倒计时的秒数
    var URL = "${pageContext.request.contextPath}";
    var id = window.setInterval('doUpdate()', 1000);
    function doUpdate() {
        document.getElementById('info').innerHTML = '将在'+num+'秒后自动返回主页!<br>请重新登录您的账户！' ;
        if(num == 0) {
            window.clearInterval(id);
            window.location = URL;
        }
        num --;
    }

</script>


</body>
</html>
