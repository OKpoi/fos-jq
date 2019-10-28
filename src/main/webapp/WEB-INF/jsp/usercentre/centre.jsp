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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/usercentre/user.css">

    <%--修改  将删除按钮写为类并从js分离出来，但写入外联css则无效果--%>
    <%-- 删除按钮的样式 --%>
    <style type="text/css">
        /*删除按钮*/
        .delBtn {
            background: black;
            position: relative;
            left: 94%;
            top: 10px;
            cursor: pointer;
            color: gray;
        }

        .delBtn:hover {
            color: red;
        }
    </style>
</head>

<body >
<%--引入导航栏--%>
<div id="nav"></div>

<div id="main" class="layui-anim layui-anim-upbit">
    <!-- 顶部 -->
    <div id="top">
        <%--空白框--%>
        <div id="blank"></div>

        <%--用户头像--%>
        <div id="head">
            <%-- 插入用户头像--%>
            <img src="/img/${user.userImg}">
        </div>

        <%-- 用户名--%>
        <div id="userName">
            <%-- 插入用户名--%>
            ${user.userName}
        </div>

        <%--修改  修改了显示的样式，并新加了收藏数的显示--%>
        <%-- 关注数,收藏数,影评数--%>
        <div id="FCC">
            <%--关注数--%>
            <div id="followCount">
                <label>关注数</label><br>
                <%--  插入关注数--%>

            </div>

            <%--收藏数--%>
            <div id="collectCount">
                <label>收藏数</label><br>
            </div>

            <%--影评数--%>
            <div id="commentCount">

            </div>

        </div>

    </div>

    <%--修改  去除了写影评，增加了我的关注，我的收藏    --%>
    <!-- 左侧(影评相关，收藏关注列表) -->
    <div id="left">
        <%--功能选项卡--%>
        <div class="layui-tab layui-tab-card " style="margin: 0;">
            <ul class="layui-tab-title">
                <li class="layui-this">我的影评</li>
                <li>回复我的</li>
                <li>我的关注</li>
                <li>我的收藏</li>
            </ul>
            <div class="layui-tab-content">

                <!-- 我的影评 -->
                <div class="layui-tab-item layui-show myComment  layui-anim layui-anim-upbit">
                    <!-- 时间线 -->
                    <ul class="layui-timeline" id="line">
                        <li class="layui-timeline-item" id="usercomment">

                        </li>
                    </ul>
                </div>

                <!-- 回复我的 -->
                <div class="layui-tab-item layui-anim layui-anim-upbit replyMe">

                </div>

                <!-- 我的关注 -->
                <div class="layui-tab-item layui-anim layui-anim-upbit myFollow">

                </div>

                <!-- 我的收藏 -->
                <div class="layui-tab-item layui-anim layui-anim-upbit myCollect">

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
                    <div class="follow">
                        <div class="movie">
                            <%--插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
                <li>
                    <div class="follow">
                        <div class="movie">
                            <%--插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
                <li>
                    <div class="follow">
                        <div class="movie">
                            <%--插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
            </ul>
        </div>

        <br>

        <%--最近收藏的三个电影--%>
        <h4><a href="">最近收藏</a></h4>
        <hr class="hr">
        <div class="rightbox">
            <ul>
                <li>
                    <div class="collect">
                        <div class="movie">
                            <%--插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
                <li>
                    <div class="collect">
                        <div class="movie">
                            <%--插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
                <li>
                    <div class="collect">
                        <div class="movie">
                            <%--插入电影图片--%>
                            <img src="">
                        </div>
                    </div>
                    <span class="movieName">电影名</span>
                </li>
            </ul>
        </div>
    </div>

</div>


<script src="${pageContext.request.contextPath}/resources/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/centre/centre.js"></script>


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

    //删除影评
    var currentToken = document.cookie.split(";")[0];
    var user = {};
    user.userId =${user.userId};
    function deleter(){
        layer.confirm('您确定要删除此评论？', {
            btn: ['是的','再想想'] //按钮
        }, function(){
            layer.msg('好的，方法还没写', {icon: 1});
        }, function(){
            layer.closeAll();
        });

    }

</script>
</body>
</html>
