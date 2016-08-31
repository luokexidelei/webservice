(function(jQuery){
    $.fn.controlcheckbox = function(checkname) {
        //判断全选按钮的选中状态
       if( $(this).attr("checked")){
           $("input[name='"+checkname+"']").attr("checked",true);
            //alert("aa");
       } else {
           $("input[name='"+checkname+"']").attr("checked",false);
          // alert("bb");
       }
    };
})(jQuery);
