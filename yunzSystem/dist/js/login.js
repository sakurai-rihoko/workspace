$('input[name = username]').blur(function(event) {
	val = this.value;
	if(val.length < 0){
		$(this).next().html("请输入用户名")
	}
});
$('input[name = password]')