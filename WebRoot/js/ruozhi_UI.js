
// AJAX POST发送数据
function postUrl(data, url) {
	alert(data.sumcode);
	var message;
	$.ajax({
		async : false,
		type : 'POST',
		url : url,
		data : data,
		dataType : 'json',
		success : function(result) {
			message = result;
		},
		error : function(result) {
			message = result;
		}
	})
	return message;
}

function uploadFile(data, id, url) {
    var message;
    $.ajax({
        type : 'post',
        url : url,
        data : data,
        async : false,
        cache : false,
        contentType : false,
        // dataType : 'json',
        processData : false,
        
        success : function(result) {
            id.html(result.msg).show();
            id.html(result.msg).hide(3000);
            message = result;
        },
        error : function(result) {
            id.html(result.msg).show();
            id.html(result.msg).hide(3000);
            message = result;
        }
    })
    return message;
}