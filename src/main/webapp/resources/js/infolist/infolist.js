
$ = layui.$;
$(function () {

    $.ajax({
        url: "/filmos/info/infolist",
        type: 'get',
        data:'',
        success: function (data) {
            var list = data.data;
            var tempHtml= '';
            $.each(list, function (i,item) {
                var profile=item.infoContent;
              tempHtml+=' <!-- 插入标注 -->' +
                  '                        <!--单个新闻 -->' +
                  '                        <div class="news ">' +
                  '                            <div class="layui-row grid-demo ">' +
                  '                                <!-- 新闻图片 -->' +
                  '                                <div class="layui-col-md4">' +
                  '                                    <a href="/filmos/info?infoid='+item.infoId+'"><div class="newsPic" >' +
                  '                                       <img src="/news'+item.infoImg+'">' +
                  '                                    </div><a>' +
                  '                                </div>' +
                  '                                <!-- 相关信息 -->' +
                  '                                <div class="layui-col-md8">' +
                  '                                    <!-- 标题 -->' +
                  '                                    <a href="/filmos/info?infoid='+item.infoId+'">' +
                  '                                        <div class="newsTitile">' + item.title +
                  '                                        </div>' +
                  '                                    </a>' +
                  '                                    <!-- 摘要 -->' +
                  '                                    <div class="newsInfo">' +
                  '                                        <p>' +profile.substring(0,79) +
                  '                                        ...</p>' +
                  '                                    </div>' +
                  '                                    <!-- 详情按钮 -->' +
                  '                                    <a href="/filmos/info?infoid='+item.infoId+'"><button  class="newsBtn layui-btn">阅读详情</button><a>' +
                  '                                    <!-- 日期 -->' +
                  '                                    <div class="newsDate">' + item.createTime+
                  '                                    </div>' +
                  '                                    <!-- 来源 -->' +
                  '                                        <div class="newsAuthor">' + item.infoFrom+
                  '                                        </div>' +
                  '                                </div>' +
                  '                            </div>' +
                  '                        </div>' +
                  '                        <br>' +
                  '                        <!-- /单个新闻 -->';

              $('.layui-col-md12').html(tempHtml);
            });
        }
    });
});


