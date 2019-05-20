function Update_Pass() {
    var pass1 = $('#passWord1').val();
    var pass2 = $('#passWord2').val();
    if (pass1 != pass2){
        window.location.reload();
        $('#span_pass1').html("密码不一致");
        $('#span_pass2').html("密码不一致");
    }else {
        if (pass1 == "" || pass2 ==""){
            alert("密码不能为空");
            return false;
        }
        var id = $('#userId').val();
        debugger
        $.post('/userController/updateUserPassWord',{'id':id,'password':pass1},function (data) {
            if (data.fl){
                alert(data.msg);
                location.href='/login';
            } else{
                alert(data.msg);
                window.location.reload();
            }
        },"JSON");
    }
}