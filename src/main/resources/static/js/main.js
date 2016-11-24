/**
 * Created by Administrator on 2016/11/24.
 */
$(document).ready(function () {
    $("#qryBtn").on('click', function () {
        var $qryBtn = $("#qryBtn");
        $qryBtn.on('click', function () {
            $.ajax({
                url: /*[[@{/auth/main}]]*/ '',
                type: 'post',
                data: {
                    investorType: $("input[name=investorType]").val(),
                    starttime: $("input[name=starttime]").val(),
                    endTime: $("input[name=endtime]").val()
                },
                dataType: 'html',
                success: function (data) {
                    $(".table").html(data);
                },
                error: function () {
                    alert("error")
                }
            });
        });
    });
});