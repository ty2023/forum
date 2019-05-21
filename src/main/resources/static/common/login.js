function loginSubmit() {
    var userName = $('#userName').val();
    var passWord = $('#passWord').val();
    if (userName == "" || passWord == ""){
        alert("用户名密码不能为空！");
    } else {
        $.post('/userController/login',{'userName':userName,'passWord':passWord},function (data) {
            if (data.fl){
                alert(data.msg);
                location.href='/forum';
            }else {
                alert(data.msg);
                window.location.reload();
            }
        },"JSON")
    }
}