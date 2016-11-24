/**
 * Created by Administrator on 2016/11/24.
 */

$(document).ready(function () {
    var $kaptcha = $("#kaptcha");
    $kaptcha.on('click', function () {
        $(this).attr('src', 'kaptcha/gen?e=' + new Date());
    });
    $kaptcha.trigger('click');

    $("#submitbtn").click(function() {
        $.ajax({
            url: 'user/login',
            type: 'post',
            data: $("#form").serialize(),
            dataType: 'html',
            success : function (data) {
                if ('success' == data) {
                    location.href = 'auth/main';
                } else {
                    location.href = '';
                }
            },
            error : function () {
                alert("登录失败")
            }
        });
    });
});
