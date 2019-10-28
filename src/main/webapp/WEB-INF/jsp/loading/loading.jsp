<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>loading</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common/loading.css" />
    <style>
        a{
            background: #00a567;
            padding:5px;
            margin:10px;
            display:block;
            font-weight:100;
            cursor:pointer;
            font-size:2.5em;
            float:left;
            text-decoration:none;
            font-size:18px;
            color:white
        }
    </style>

</head>
<body>

<div class="loader">
    <div class="text">Loading...</div>
    <div class="horizontal">
        <div class="circlesup">
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
        </div>
        <div class="circlesdwn">
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
        </div>
    </div>
    <div class="vertical">
        <div class="circlesup">
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
        </div>
        <div class="circlesdwn">
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/loading/loading.js"></script>

<script type="text/javascript">
    var num = 2; //倒计时的秒数
    var URL = "${pageContext.request.contextPath}";
    var id = window.setInterval('doUpdate()', 600);
    function doUpdate() {
        if(num == 0) {
            window.clearInterval(id);
            window.location = URL;
        }
        num --;
    }
</script>
</body>
</html>

