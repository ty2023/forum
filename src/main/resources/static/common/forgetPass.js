function update_user_name() {
    var userName = $('#userName').val();
    if (userName == null || userName == "") {
        alert("用户名不能为空");
        return false;
    }
    $.post('/userController/getUserPass', {'userName': userName}, function (data) {
        $('#update_pass_name').html(data.ff);
        if (data.userEmail != null) {
            var email = data.userEmail;
            var id = data.userId;
            if (confirm('是否往' + email + '发送修改密码的连接')) {
                $.post('/email/UpdateUserPass',{'email':email,'id':id},function (yy) {
                    alert(yy.msg+'即将返回登录页');
                    location.href = '/login';
                });
            } else {
                alert('您选择了取消找回密码，即将返回登录页面');
                location.href = '/login';
            }
        }
    }, "JSON");
}