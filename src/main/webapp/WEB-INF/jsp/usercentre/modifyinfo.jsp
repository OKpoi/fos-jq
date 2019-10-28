<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/animate.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/hover-min.css">
</head>

<body bgcolor="#f0f0f0" class="layui-anim layui-anim-upbit">

<div id="nav"></div>
<div class="layui-container" style="position: relative;top: 20px;height: 901px">
    <div class="layui-row layui-col-space30">
        <div class="layui-col-md8">
            <div class="layui-tab layui-tab-card layui-card">
                <ul class="layui-tab-title">
                    <li class="layui-this">我的资料</li>
                    <li>修改密码</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show myComment layui-anim layui-anim-upbit">
                        <div class="layui-card-header" style="height: 60px">
                            <div class="layui-icon layui-icon-form"
                                 style="font-size: 43px;position: relative;top: 6px;"></div>
                            <h3 style="position: relative;top: -33px;left: 58px;">个人资料</h3></div>
                        <div class="layui-card-body" style="height: 600px">
                            <div class="layui-bg layui-bg-green"
                                 style="height: 35px;position: relative;top:30px;text-align: center;font-size: 14px"><span
                                    style="position:relative;top: 5px;">基本资料</span></div>
                            <form style="position: relative;top:60px;text-align: left" class="layui-form"
                                  onsubmit="false">
                                <div class="layui-form-item">
                                    <label class="layui-form-label">用户ID</label>
                                    <span style="position:relative;top: 7px;font-size: 15px;left: 76px;">${user.userId}</span>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">用户名</label>
                                    <div class="layui-input-inline">
                                        <input id="update-username" type="text" name="update-username"
                                               placeholder="请输入用户名"
                                               autocomplete="off" class="layui-input" value="${user.userName}">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">年龄</label>
                                    <div class="layui-input-inline">
                                        <input id="update-age" type="text" name="update-age" required
                                               lay-verify="number"
                                               placeholder="请输入年龄" autocomplete="off" class="layui-input"
                                               value="${user.age}">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">性别</label>
                                    <div class="layui-input-inline ">
                                        <select id="update-sex" name="update-sex" class="hvr-glow">
                                            <option id="0" value="0">未知</option>
                                            <option id="1" value="1">男</option>
                                            <option id="2" value="2">女</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">手机</label>
                                    <div class="layui-input-inline">
                                        <input id="update-phone" type="text" name="update-phone" placeholder="请输入手机"
                                               autocomplete="off" class="layui-input" value="${user.phone}">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">邮箱</label>
                                    <div class="layui-input-inline">
                                        <input id="update-email" type="text" name="update-email" placeholder="请输入邮箱"
                                               autocomplete="off" class="layui-input" value="${user.email}">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <div class="layui-input-block">
                                        <input onclick="asubmita()" id="update" class="layui-btn" type="button"
                                               style="width: 80px;text-align: center" value="修改"/>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>

                    <div class="layui-tab-item replyMe layui-anim layui-anim-upbit">
                        <div class="layui-icon layui-icon-password hvr-pulse-grow"
                             style="font-size: 100px;position: relative;left: 76px;top: 37px;cursor: pointer"
                             onclick="modifypassword()">
                        </div>
                        <br><br><br><br><br><br><br>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-col-md5" style="position: absolute;top: 17px;right: 67px;width: 310px;">
        <div class="layui-card" style="height: 300px">
            <div class="layui-card-header" style="height: 60px;text-align: center">
                <div class="layui-icon layui-icon-picture" style="font-size: 30px;position: relative;top: 6px;"></div>
                <h3 style="position: relative;top: -12px;left: 1px;font-size: 15px;color: white">修改头像</h3></div>
            <div class="layui-card-body">
                <img src="/img/${user.userImg}" class="layui-upload-img" id="user-img"
                     style="width: 100px;height: 100px;position: relative;left: 88px;background-color: #0F9E5E">
                <hr>
                <div class="layui-upload" style="text-align: center">
                    <button type="button" class="layui-btn" id="choose" style="width: 80px">选择图片</button>
                    <button type="button" class="layui-btn  layui-btn-danger layui-anim layui-anim-upbit" id="upload"
                            style="width: 80px;display: none;position: relative;left: 100px;top: 20px;" >开始上传
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


<script src="${pageContext.request.contextPath}/resources/layui.all.js"></script>
<script>
    $ = layui.$;
    var $ = layui.jquery
    var form = layui.form;
    var element = layui.element;
    var layer = layui.layer;
    var upload = layui.upload;
    $("#nav").load("${pageContext.request.contextPath}/nav");
    var active = {
        tabChange: function () {
            //切换到指定Tab项
            element.tabChange('demo', '22');
        }
    };
    var currentToken=document.cookie.split(";")[0];
    $.ajax({
        url: "/filmos/user/islogin",
        type: 'get',
        dataType: "json",
        headers:{
            'Content-Type':'application/json',
            'Authorization':currentToken
        },
        success: function (data) {
            console.log(data.code);
            if (data.code!=200) {
                window.location.href="index.jsp"
            }
        }
    });

    //文件上传
    upload.render({
        elem: '#choose'
        , auto: false
        , url: '${pageContext.request.contextPath}/user/updateuserimg'
        , accept: 'file'
        , bindAction: '#upload'
        , choose: function (obj) {//选择文件的回调，obj为选中的文件
            //将每次选择的文件追加到文件队列
            var files = obj.pushFile();
            //预览选中的文件（本地文件）
            obj.preview(function (index, file, result) {
                $('#user-img').attr('src', result);
                $('#upload').css('display', 'block');
            });
        }
        , before: function (obj) {//文件上传前的回调
        }
        , done: function (res) {
            if (res.code == 200) {
                layer.msg(res.msg, {
                    icon: 0, time: 800, end: function () {
                        location.reload();
                    }});
            } else {
                return layer.msg(res.msg);
            }
        }
        , error: function (res) {
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function () {
                uploadInst.upload();
            });
        }
    });

    //修改信息提示
    $('#update-username').on('click', function () {
        var that = this;
        layer.tips('用户名不能全部为数字或者有特殊字符哦!', that); //在元素的事件回调体中，follow直接赋予this即可

    });
    $('#update-age').on('click', function () {
        var that = this;
        layer.tips('年龄在1-120之间哦!', that); //在元素的事件回调体中，follow直接赋予this即可

    });

    $('#update-phone').on('click', function () {
        var that = this;
        layer.tips('暂时只支持大陆手机号码哦!', that); //在元素的事件回调体中，follow直接赋予this即可

    });
    $('#update-email').on('click', function () {
        var that = this;
        layer.tips('输入正确的email，用来登录!', that); //在元素的事件回调体中，follow直接赋予this即可

    });
    $('#update-password').on('click', function () {
        var that = this;
        layer.tips('密码必须6到12位，且不能出现空格!', that); //在元素的事件回调体中，follow直接赋予this即可

    });

    //提交修改
    function asubmita() {
        layer.confirm('你确定要修改信息？', {
            btn: ['是的', '我再想想'] //按钮
        }, function () {
            var updataid =${user.userId};
            var updateusername = $('#update-username').val();
            var updateage = $('#update-age').val();
            var updateemail = $('#update-email').val();
            var updatephone = $('#update-phone').val();
            var updatesex = $('#update-sex option:selected').val();
            var updateuser = {};
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(updateusername)) {
                layer.msg('用户名不能有特殊字符！', {icon: 2});
                return false;

            }

            if (/(^\_)|(\__)|(\_+$)/.test(updateusername)) {
                layer.msg('用户名首尾不能出现下划线\'_\'！', {icon: 2});
                return false;
            }
            if (/^\d+\d+\d$/.test(updateusername)) {
                layer.msg('用户名不能全为数字！', {icon: 2});
                return false;
            }
            if (!/^[0-9]*[1-9][0-9]*$/.test(updateage)) {
                layer.msg('年龄输入不合法，不允许有小数！', {icon: 2});
                return false;
            }
            if (updateage <= 0) {
                layer.msg('年龄必须大于0！', {icon: 2});
                return false;
            }
            if (updateage > 120) {
                layer.msg('年龄输入太大了！', {icon: 2});
                return false;
            }
            if (!/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(updateemail)) {
                layer.msg('请输入有效的邮箱!', {icon: 2});
                return false;
            }
            if (!/^1\d{10}$/.test(updatephone)) {
                layer.msg('请输入有效的手机号码!', {icon: 2});
                return false;
            }
            updateuser.userId = updataid;
            updateuser.userName = updateusername;
            updateuser.age = updateage;
            updateuser.email = updateemail;
            updateuser.phone = updatephone;
            updateuser.sex = updatesex;
            var result = JSON.stringify(updateuser);
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/user/updateuserinfo",
                data: result,
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                processData: false,
                cache: false,
                headers:{
                    'Content-Type':'application/json',
                    'Authorization':currentToken
                },
                beforeSend: function () {
                    // 禁用按钮防止重复提交
                    $("#update").attr({disabled: "disabled"});
                    layer.load(0, 5000);
                },
                success: function (data) {
                    if (data.code == 200) {
                        location.href = "/filmos/page/ok"
                    } else {
                        layer.msg(data.msg, {icon: 2, time: 3000});
                        location.href = "index.jsp";
                    }
                },
            });
            return false;
        }, function () {
            layer.closeAll();
        });

    }

    function modifypassword() {
        layer.open({
            type: 1,
            skin: 'layui-layer-rim', //加上边框
            area: ['400px', '340px'], //宽高
            content: '<form class="layui-form">\n' + '<div class="layui-form-item" style="position: relative;top:53px ;">\n' +
                '                                <label class="layui-form-label">用户名</label>\n' +
                '                                <div class="layui-input-inline">\n' +
                '                                    <input id="yanzheng-username" type="text" name="username" required\n' +
                '                                           lay-verify="required" placeholder="请输入用户名" autocomplete="off"\n' +
                '                                           class="layui-input">\n' +
                '                                </div><br><br>\n' +
                '                            <div class="layui-form-item" style="position: relative;top:44px;">\n' +
                '                                <label class="layui-form-label">原密码</label>\n' +
                '                                <div class="layui-input-inline">\n' +
                '                                    <input id="yanzheng-password" type="password" name="password" required\n' +
                '                                           lay-verify="required" placeholder="请输入原密码" autocomplete="off"\n' +
                '                                           class="layui-input">\n' +
                '                                </div>\n' +
                '                                <div class="layui-form-item">\n' +
                '                                    <div class="layui-input-block">\n' +
                '                                        <button type="button" class="layui-btn" onclick="querenpassword()"\n' +
                '                                                style="width: 80px;position:relative;top: 20px">确定\n' +
                '                                        </button>\n' +
                '                                    </div>\n' +
                '                                </div>\n' +
                '                            </div>\n' +
                '                        </form>'
        });


    }

    function querenpassword() {
        var username = $('#yanzheng-username').val();
        console.log(username);
        var yanzheng = $('#yanzheng-password').val();
        var md5pas = md5(yanzheng)
        var user = {};
        user.userName = username;
        user.password = md5pas;
        var login = JSON.stringify(user);
        console.log(login)
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/user/login",
            data: login,
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            processData: false,
            cache: false,
            headers:{
                'Content-Type':'application/json',
                'Authorization':currentToken
            },
            beforeSend: function () {
                layer.load(0, 5000);
            },
            success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    layer.closeAll();
                    layer.open({
                        type: 1,
                        skin: 'layui-layer-rim', //加上边框
                        area: ['400px', '340px'], //宽高
                        content: '<form class="layui-form" >\n' +
                            '                            <div class="layui-form-item" style="position: relative;top:40px">\n' +
                            '                                <label class="layui-form-label">新的密码</label>\n' +
                            '                                <div class="layui-input-inline">\n' +
                            '                                    <input id="update-password" type="password" name="password" required\n' +
                            '                                           lay-verify="required" placeholder="请输入新的密码" autocomplete="off"\n' +
                            '                                           class="layui-input">\n' +
                            '                                </div>\n' +
                            '\n' +
                            '                                <div class="layui-form-item">\n' +
                            '                                    <div class="layui-input-block">\n' +
                            '                                        <button type="button" class="layui-btn" onclick="updatepassword()"\n' +
                            '                                                style="width: 80px;position:relative;top: 20px">立即修改\n' +
                            '                                        </button>\n' +
                            '                                    </div>\n' +
                            '                                </div>\n' +
                            '                            </div>\n' +
                            '                        </form>'
                    });
                } else {
                    layer.msg('原密码错误!', {
                        icon: 2, time: 2000, end: function () {
                            layer.closeAll()
                        }
                    });

                }
            },
        });
        return false;

    }

    function updatepassword() {
        layer.confirm('确定要修改密码', {
            btn: ['确定', '不了']
        }, function () {
            var mypassword = $('#update-password').val();
            var md5pass2 = md5(mypassword);
            var updataid =${user.userId};
            var user = {}
            if (!/^[\S]{6,12}$/.test(mypassword)) {
                layer.msg('密码必须6到12位，且不能出现空格!', {icon: 2});
                return false
            }
            user.userId = updataid;
            user.password = md5pass2;
            var result = JSON.stringify(user);
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/user/updatepassword",
                data: result,
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                processData: false,
                cache: false,
                headers:{
                    'Content-Type':'application/json',
                    'Authorization':currentToken
                },
                beforeSend: function () {
                    layer.load(0, 5000);
                },
                success: function (data) {
                    if (data.code == 200) {
                        $.ajax({
                            url: "${pageContext.request.contextPath}/user/quit",
                            type: "get",
                            dataType: "json",
                            data: {},
                            headers: {
                                'Content-Type': 'application/json',
                                'Authorization': currentToken
                            }
                            , success: function (data) {

                            }
                        });
                        location.href = "/filmos/page/goback"
                    } else {
                        layer.msg(data.msg, {icon: 2, time: 5000});
                        location.href = "index.jsp";
                    }
                },
            });
            return false;
        }, function () {
            layer.closeAll()
        });

    }

</script>
</body>
</html>
