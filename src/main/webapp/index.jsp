<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/animate.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index/index.css">
    <html>
<body bgcolor="#f0f0f0">
<div id="nav"></div>
<div class="layui-container" id="container">
    <div class="layui-fluid">
        <div class="layui-carousel" id="headline">
            <div carousel-item>
                <div><img src="resources/images/headline/1.jpg" style="width: 100%;height: 100%"></div>
                <div><img src="resources/images/headline/2.jpg" ></div>
                <div><img src="resources/images/headline/3.jpg" style="width: 100%;height: 100%"></div>
                <div><img src="resources/images/headline/4.jpg" style="width: 100%;height: 100%"></div>
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <hr>
    <div class="title">院线热映</div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="layui-row layui-col-space15" style="background-color: #555555">
        <div class="layui-col-lg6">
            <div class="layui-card">
                <div class="layui-card-header">卡片面板</div>
                <div class="layui-card-body">
                    卡片式面板面板通常用于非白色背景色的主体内<br>
                    从而映衬出边框投影
                </div>
            </div>
        </div>
        <div class="layui-col-lg6">
            <div class="layui-card">
                <div class="layui-card-header">卡片面板</div>
                <div class="layui-card-body">
                    结合 layui 的栅格系统<br>
                    轻松实现响应式布局
                </div>
            </div>
        </div>

    </div>
</div>
<%--<script !src=""></script>--%>
<script src="${pageContext.request.contextPath}/resources/layui.all.js"></script>

<script>
    $ = layui.$
    //调用ajax实现页面的局部刷新,将iframe的页面加载出来
    $("#nav").load("/filmos/nav");
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#headline'
        , width: '100%' //设置容器宽度
        , height: '580px'//设置容器高度
        , arrow: 'hover' //始终显示箭头
        , indicator: 'none'//指示器不显示
        , anim: 'fade' //切换动画方式
    });
</script>

</body>
</html>