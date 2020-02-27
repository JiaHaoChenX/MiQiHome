/**
 * 文本框不能输入整数数字,
 * @param event
 * @param obj
 * 调用方式：onkeypress="cannotInputNumber(event, this)"
 */
function cannotInputNumber(event, obj) {
	if (((event.which > 47 && event.which < 58))) {
		event.preventDefault();
	}
}
/**
 * 
 * 调用方式：onblur="checkIntegerNumber(event,this)" onkeyup="checkIntegerNumber(event,this)"
 */
function checkIntegerNumber(event,obj){
	if (event.which >= 37 && event.which <= 40) {
		return;
	}
	var a = obj.value.trim();
	$(obj).val(a.replace(/\d+/g,''));
}

/* 替换特殊字符 */
function replaceSpecialStr(value)
{
	if (!value) {
		return "";
	}
	value = value.replace(/'/g, "’");
	value = value.replace(/"/g, "”");
	value = value.replace(/</g, "《");
	value = value.replace(/>/g, "》");
	return value;
}