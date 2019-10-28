<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>咨询</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/animate.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/infolist/newlist.css">
    <html>
<body bgcolor="#f0f0f0">
<div id="nav"></div>

<!-- 新闻标题 -->


<!-- layui容器 -->
<div class="layui-container">
    <div class="layui-row layui-col-space30">

        <h1 class="title">新闻列表</h1>
        <br><br><br><br><br>
        <!-- 新闻列表 -->
        <div class="layui-col-lg8">
            <div id="newsList" class="layui-anim layui-anim-scale">
                <div class="layui-row">
                    <div class="layui-col-md12" >


                        <%--<!-- 插入标注 -->--%>
                        <%--<!--单个新闻 -->--%>
                        <%--<div class="news">--%>
                            <%--<div class="layui-row grid-demo ">--%>
                                <%--<!-- 新闻图片 -->--%>
                                <%--<div class="layui-col-md4">--%>
                                    <%--<div class="newsPic">--%>
                                        <%--<!-- 插入新闻图片 -->--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<!-- 相关信息 -->--%>
                                <%--<div class="layui-col-md8">--%>
                                    <%--<!-- 标题 -->--%>
                                    <%--<a href="">--%>
                                        <%--<div class="newsTitile">--%>
                                            <%--<!-- 插入新闻的标题 -->--%>
                                        <%--</div>--%>
                                    <%--</a>--%>
                                    <%--<!-- 摘要 -->--%>
                                    <%--<div class="newsInfo">--%>
                                        <%--<p>--%>
                                            <%--<!-- 插入新闻摘要 -->--%>
                                        <%--</p>--%>
                                    <%--</div>--%>
                                    <%--<!-- 详情按钮 -->--%>
                                    <%--<button  class="newsBtn layui-btn">阅读详情</button>--%>
                                    <%--<!-- 日期 -->--%>
                                    <%--<div class="newsDate">--%>
                                        <%--<!-- 插入发布日期 -->--%>
                                    <%--</div>--%>
                                    <%--<!-- 来源 -->--%>
                                    <%--<a href="">--%>
                                        <%--<div class="newsAuthor">--%>
                                            <%--<!-- 插入消息来源 -->--%>
                                        <%--</div>--%>
                                    <%--</a>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                        <%--</div>--%>
                        <%--<br>--%>
                        <%--<!-- /单个新闻 -->--%>


                    </div>
                </div>

            </div>
            <!-- /新闻列表 -->
        </div>


        <!-- 热点话题 -->
        <div class="layui-col-lg4">
            <div id="hotTopic">
                <!-- Hot Topic -->
                <div id="HTtitle">
                    Hot Topioc!!!
                </div>

                <!-- 效果展示 -->
                <!--单个话题 -->
                <div class="HT">
                    <div class="layui-row">
                        <!-- 话题图片 -->
                        <div class="layui-col-lg3">
                            <div class="HTpic">
                                <img src="img/cxk.jpg">
                            </div>
                        </div>

                        <div class="layui-col-lg9 ">
                            <!-- 话题关键字 -->
                            <a href="">
                                <div class="HTkeyword">
                                    #蔡徐坤nmsl#
                                </div>
                            </a>
                            <!-- 话题简述 -->
                            <a href="" title="练习时长两年半的个人练习生，喜欢唱，跳，rap，篮球。music！鸡你太美">
                                <div class="HTinfo">
                                    练习时长两年半的个人练习生，喜欢唱，跳，rap，篮球。music！鸡你太美
                                </div>
                            </a>
                        </div>

                    </div>
                    <!-- /单个话题 -->
                </div>

                <!-- 插入标注 -->
                <!--单个话题 -->
                <div class="HT">
                    <div class="layui-row">
                        <!-- 话题图片 -->
                        <div class="layui-col-lg3">
                            <div class="HTpic">
                                <!-- 插入图片 -->
                            </div>
                        </div>

                        <div class="layui-col-lg9 ">
                            <!-- 话题关键字-->
                            <a href="">
                                <div class="HTkeyword">
                                    <!-- 插入话题关键字 -->
                                </div>
                            </a>
                            <!-- 话题简述 (title的值为话题简述全文) -->
                            <a href="" title="">
                                <div class="HTinfo">
                                    <!-- 插入话题简述 -->
                                </div>
                            </a>
                        </div>

                    </div>
                    <!-- /单个话题 -->
                </div>

                <!-- /热点话题 -->
            </div>

        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/infolist/infolist.js"></script>
<script>
    $ = layui.$
    //调用ajax实现页面的局部刷新,将iframe的页面加载出来
    $("#nav").load("/filmos/nav");

</script>

</body>
</html>