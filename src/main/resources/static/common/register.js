
$(function () {
    //发送邮件并且判断邮箱是否唯一
    $('#checkEmail').click(function () {
        getRandomCode();
        var email = $('#email').val();
        $.post('/email/sendForgetPasswordAuthCodeEmail',{'email':email},function (data) {
            if (data.fl){
                alert(data.msg);
            }else {
                alert(data.msg);
                window.location.reload();
            }
        },"JSON");
    });

    //验证验证码是否正确
    $('#checkCode').blur(function () {
        var checkCode=$('#checkCode').val();
        $.post('/email/checkeForgetPasswordVcode',{'checkCode':checkCode},function (data) {
            $('#span_code').html(data.check);
        },"JSON")
    });

    //验证用户名是否唯一
    $('#userName').blur(function () {
        var param = new Object();
        param.userName = $('#userName').val();
        if (param.userName == null ||param.userName == ''){
            $('#span_name').html("用户名不能为空");
            return false;
        }
        $.post('/userController/getByUserName',param,function (data) {
            if (data.fl){
                $('#span_name').html(data.msg);
            }else {
                $('#span_name').html(data.msg);
            }
        },"JSON");

    });
})
var time=60;
function getRandomCode() {
    if (time === 0) {
        time = 60;
        return;
    } else {
        $("#checkEmail").css("layui-btn layui-btn-disabled",true);
        time--;
        $('#checkEmail').val(time);
    }
    setTimeout(function() {
        getRandomCode();
    },1000);
}

//提交表单
function submitbtn() {
    var param = new Object();
    param.userName = $('#userName').val();
    param.passWord = $('#passWord').val();
    param.email = $('#email').val();
    if (panduan()){
        $.post('/userController/registerUser',param,function (data){
            if(data.fl){
                alert(data.msg);
                location.href='/login';
            }else{
                alert(data.msg);
                window.location.reload();
            }
        },"JSON");
    }else {
        alert("星号标记项不能为空");
    }
}

function panduan() {
    var userName = $('#userName').val();
    var passWord = $('#password').val();
    var email = $('#email').val();
    if (userName == ""||passWord == ""||email == ""){
        return false;
    }
    return true;
}
