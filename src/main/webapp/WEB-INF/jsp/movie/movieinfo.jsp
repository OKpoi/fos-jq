<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>电影详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/movieinfo/moviePage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/animate.min.css">
    <html>
<body bgcolor="#f0f0f0" class="layui-anim layui-anim-upbit">
<div id="nav"></div>
<div class="layui-container" id="container" style="width: 67%">
    <div class="layui-fluid">
        <div class="layui-row ">
            <div class="layui-col-md8 layui-col-md-offset2 movie">
                <div class="layui-row grid-demo layui-col-space30" id="themovieinfo">
                    <!-- 修改部分 -->
                    <!-- 加入bgbox层 -->


                </div>
            </div>
        </div>
        <!-- 简介 -->
        <div class="layui-col-md8 layui-col-md-offset2 movieText" id="profile"
             style="position: relative;background-color: #149688;color: #ffffff;top: -4px;width: 67%;left: -2px;box-shadow: 0 0 5px 0px #00000066;"></div>
    </div>
    <br>
    <br>

    <!-- 评论区 -->
    <div class="layui-row commentArea" style="width: 97%;position: relative;left: 1.5%;">
        <!-- 用户评论 -->
        <h1 style="margin-left: 18.5%; top: 46px!important;">影评区</h1>
        <div class="layui-col-md8 layui-col-md-offset2 commentCard" id="moviecomments">

            <%--插入影评--%>
        </div>


    </div>
    <br>
    <div class="">
        <div id="render" align="center"></div>
    </div>
    <br>
    <!-- 写影评 -->
    <div class="layui-row ">
        <div class="layui-col-md8 layui-col-md-offset2 TuserCommentArea">
            <div id="mustlogin" style="background: rgba(0, 0, 0, 0.71);height: 94%; width: 97%;z-index: 15;position: absolute;display: none">
                <button id="tologin" class="hvr-pulse-grow layui-btn layui-btn-radius layui-btn-normal " style="width: 80px;position: relative;margin-left: 44%;margin-top: 13%;">
                    登录
                </button>
            </div>
            <form id="mycomment" method="post" onsubmit="false">
                <div id="userScore" value=""></div>
                <textarea required lay-verify="required" placeholder="请输入你的评论" id="TuserCommentText"
                          class="layui-textarea"></textarea>
                <div class="btns">
                    <input class="btn" type="reset" value="清空"/>
                    <input class="btn" type="submit" value="发表" onclick="submitmycomment()"/>
                    <input type="hidden" value="${user.userId}" id="myid">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/movieinfo/movieinfo.js"></script>

<script>
    $ = layui.$
    var laypage = layui.laypage,
        layer = layui.layer;
    rate = layui.rate;
    //调用ajax实现页面的局部刷新,将iframe的页面加载出来
    $("#nav").load("/filmos/nav");
    var currentToken = document.cookie.split(";")[0];
    var start = '';
    var userId=$('#myid').val();
    console.log($('#myid').val())
    rate.render({
        elem: '#userScore'
        , value: 0 //初始值
        , half: true
        , choose: function (value) {
            layer.msg(value + '  分', {offset: '60%', shade: 0.3, shadeClose: true});
            start = value;

        }

    });
    if (userId == "") {
        document.getElementById("mustlogin").style.display='block';
        $('#tologin').click(function () {
            document.getElementById("background").className = 'layui-anim layui-anim-scaleSpring';
            document.getElementById("background").style.display = 'block';
            $("#search-bar").css("display", "none");
            $("#search-bar").removeClass("yijingdianjile");
        })
    }
    function submitmycomment() {
        var movieId = getQueryString('movieid');
        var content = $('#TuserCommentText').val();
        var user = {};
        var movie = {};
        movie.movieId = movieId;
        user.userId = userId;
        var movieComment = {};
        movieComment.content = content;
        movieComment.start = start;
        movieComment.movie = movie;
        movieComment.user = user;
        var result = JSON.stringify(movieComment);
        $.ajax({
            url: '${pageContext.request.contextPath}/comment/addcomment',
            type: "POST",
            data: result,
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            processData: false,
            cache: false,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': currentToken
            },
            beforeSend: function () {
                // 禁用按钮防止重复提交
                $(".btn").attr({disabled: "disabled"});
                layer.load(0, 3000);
            },
            success: function (data) {
                if (data.code == 200) {
                    layer.msg(data.msg, {icon: 1})
                    location.reload();
                } else {
                    layer.msg(data.msg, {icon: 2})
                    location.reload();
                }
            }
        });
    }


</script>

</body>
</html>