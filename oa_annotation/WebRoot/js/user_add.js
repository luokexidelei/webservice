var user = {
    formValidate : function() {
        $("input[type='image']").unbind("click");
        $("input[type='image']").bind("click", function() {
            if ($("select[name='did'] option:selected").attr("value") == "") {
                alert("请选择部门");
                return false;
            } else {
                if (!$("select[name='pids'] option:selected").attr("value")) {
                    alert("请选择岗位");
                    return false;
                } else {
                    if($("#msg").text() == "该用户名已被注册") {
                        alert("请输入新用户名");
                        return false;
                    } else{
                        return true;
                    }
                }
                return true;
            }
        });
    },

    initEvent : function() {
        $("input[name='username']").unbind("blur");
        $("input[name='username']").bind("blur", function() {
            user.checkUser($(this).val());
        });
    },
    
    checkUser:function(username){
        var parameter = {
          username:username  
        };
        $.post("userJsonAction_checkUser.action",parameter,function(data){
           $("#msg").text(data.msg); 
           if(data.msg=="该用户名可以使用"){
                $("#msg").css("color","blue");
           }else {
                $("#msg").css("color","red");
           }
           
           // alert("ss");
        });
    }
};

$().ready(function() {
    user.formValidate();
    user.initEvent();

});
