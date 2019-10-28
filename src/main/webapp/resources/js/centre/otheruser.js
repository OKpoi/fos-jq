$ = layui.$;

$(function () {
    var userId = getQueryString('userid');
    var userInfoUrl = '/filmos/comment/usercomment?userId=' + userId;
    $.ajax({
        url: userInfoUrl,
        type: 'get',
        data: 'json',
        success: function (datas) {
            var tempHtml = '';
            var list = datas.data;
            $('#commentCount').html(' <label>影评数</label><br>'+datas.count);

            $.each(list, function (i, item) {

                tempHtml += '<li class="layui-timeline-item">' + '<i class="layui-icon layui-timeline-axis">&#xe63f;</i>' +
                    '<div class="layui-timeline-content layui-text" >' +
                    '<br><br><h3 class="layui-timeline-title">' + item.createTime + '</h3>' + '<p style="overflow: hidden">' + item.content +
                    ' </p><br><img style="width: 27%;" src="/img/' + item.movieImg + '">'+
                    '<h1 style="position: relative;top: -134px;left: 82%;font-size: 60px;width: 41px;height: -1px;color: #5FB878">'+item.start+'</h1>'+
                    '<h3 style="position: relative;top: -134px;left: 87%;font-size: 20px;width: 41px;height: -1px;color: #5FB878">分</h3>';


                $('#TaComment').html(tempHtml);
                console.log(item.userImg);
                $('#Ohead').html('<img src="/img/'+item.userImg+'">');

            });

        }
    });
});