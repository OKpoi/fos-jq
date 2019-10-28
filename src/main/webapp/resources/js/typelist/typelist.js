
$ = layui.$;
$(function () {
    var typeId = getQueryString('typeid');
    var movieTypeUrl = '/filmos/movie/movietype?typeid=' + typeId;
    $.ajax({
        url: movieTypeUrl ,
        type: 'get',
        data: 'json',
        success: function (data) {
            var list = data.data;
            var tempHtml= '';
            var tempHtml2='';
            var typename=list[0].typeName;
            tempHtml2+='<span>'+typename+'</span>';
            $('#SmovieType').html(tempHtml2);
            $.each(list, function (i,item) {
                var time=item.onTime;
                var start=item.start;
                if (start=='0'){
                    start='暂无';
                }
                tempHtml +='<div  class="layui-col-lg3">' +
                    ' <div class="movie layui-anim layui-anim-scale">' +
                    '<figure class="imghvr-slide-right hvr-grow-shadow">' +
                    '    <img src="/img/' + item.movieImg + '">' +
                    '    <figcaption>' +
                    '    <div>' +
                    '    <span class="movieName">'+item.movieName+'</span><br>' +
                    '    <span class="year">('+time.substring(0,5)+')</span>' +
                    '    </div>'+
                    '    <div class="movieType">' +
                    item.typeName +
                    '    </div>' +
                    '    <div class="movieTime">' +
                    item.movieTime +
                    '    </div>' +
                    '    <div>' +
                    '    导演：<span class="master">'+item.director+'</span>' +
                    '    </div>' +
                    '    <div style="margin-top: 10px;">' +
                    '    主演：<br>' +
                    '<span class="actors">'+item.actor+'</span>' +
                    '    </div>' +
                    '    </figcaption><br>' +
                    '    <a href="/filmos/movieinfo?movieid='+item.movieId+'"></a>' +
                    '    </figure>' +
                    ' <div class="movieName">' +
                    item.movieName+
                    '    </div><br>' +
                    '    <div class="movieScore">' +
                    '    评分：<span class="score">'+start+'</span>' +
                    '    </div>' +
                    '</div>' +
                    '    </div>';


                $('#dianyingliebiao').html(tempHtml);
            });
        }
    });
});

