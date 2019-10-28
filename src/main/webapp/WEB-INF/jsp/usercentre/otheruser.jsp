<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>个人中心</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/animate.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/hover-min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/usercentre/otheruser.css">
</head>

<body>
<%--引入导航栏--%>
<div id="nav"></div>

<div id="main" class="layui-anim layui-anim-upbit">
    <!-- 顶部 -->
    <div id="top">
        <%--空白框--%>
        <div id="blank"></div>

        <%--用户头像--%>
        <div id="Ohead">
            <%--插入头像--%>
            <img src="">
        </div>

        <%-- 用户名--%>
        <div id="OuserName">
            <%-- 插入用户名--%>
        </div>

        <%-- 关注数,收藏数,影评数--%>
        <div id="FCC">
            <%--关注数--%>
            <div id="followCount">
                <label>关注数</label><br>
                <%--插入关注数--%>
                0
            </div>

            <%--收藏数--%>
            <div id="collectCount">
                <label>收藏数</label><br>
                <%--  插入收藏数--%>
                0
            </div>

            <%--影评数--%>
            <div id="commentCount">
                <label>影评数</label><br>
                <%--插入影评数--%>
            </div>

        </div>

    </div>

    <!-- 左侧(影评相关，收藏关注列表) -->
    <div id="left">
        <%--功能选项卡--%>
        <div class="layui-tab layui-tab-card " style="margin: 0;">
            <%--选项卡列表--%>
            <ul class="layui-tab-title">
                <li class="layui-this">Ta的影评</li>
                <li >Ta的关注</li>
                <li >Ta的收藏</li>
            </ul>

            <%--各选项卡功能块--%>
            <div class="layui-tab-content">

                <!-- Ta的影评 -->
                <div class="layui-tab-item layui-show TaComment  layui-anim layui-anim-upbit">
                    <!-- 时间线 -->
                    <ul class="layui-timeline" id="line">
                        <li class="layui-timeline-item" id="TaComment">
                        <%--  插入影评--%>
                        </li>
                    </ul>
                </div>

                <%-- Ta的关注--%>
                <div class="layui-tab-item  layui-anim layui-anim-upbit Tafollow">


                </div>

                <%-- Ta的收藏--%>
                <div class="layui-tab-item  layui-anim layui-anim-upbit Tacollect">


                </div>

            </div>
        </div>


    </div>


    <!-- 右侧(最近的关注与收藏) -->
    <div id="right">
        <br>
        <%--最近关注的三个电影--%>
        <h4><a href="">最近关注</a></h4>
        <hr class="hr">
        <div class="rightbox">
            <ul>
                <li>
                    <div class="Ofollow">
                        <div class="movie">
                            <%-- 插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
                <li>
                    <div class="Ofollow">
                        <div class="movie">
                            <%-- 插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
                <li>
                    <div class="Ofollow">
                        <%-- 插入电影图片--%>
                        <div class="movie">
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
            </ul>
        </div>
        <%--/最近关注--%>
        <br>

        <%--最近收藏的三部影片--%>
        <h4><a href="">最近收藏</a></h4>
        <hr class="hr">
        <div class="rightbox">
            <ul>
                <li>
                    <div class="Ocollect">
                        <div class="movie">
                            <%--插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
                <li>
                    <div class="Ocollect">
                        <div class="movie">
                            <%-- 插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
                <li>
                    <div class="Ocollect">
                        <div class="movie">
                            <%-- 插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
            </ul>
        </div>
        <%--/最近收藏--%>

    </div>


</div>


<script src="${pageContext.request.contextPath}/resources/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/centre/otheruser.js"></script>


<script>
    $ = layui.$

    //加载导航栏
    $("#nav").load("/filmos/nav");

    // 选项卡
    var $ = layui.jquery, element = layui.element,layer=layui.layer; //Tab的切换功能，切换事件监听等，需要依赖element模块
    //触发事件
    var active = {
        tabChange: function () {
            //切换到指定Tab项
            element.tabChange('demo', '22');
        }
    };

</script>
</body>
</html>
