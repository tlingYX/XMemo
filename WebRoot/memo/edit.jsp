<%@ page pageEncoding="UTF-8"%>
<!-- 提示弹出框 -->
<div id="uploadMsg" style="display:none;"></div>
<div id="summernote">

</div>

<button class="btn btn-success right-8" onclick="submitup()">发表</button>

<script type="text/javascript" src="js/summernote.min.js"></script>
<script type="text/javascript">
domain = "http://192.168.10.11:8080/XMemo/";
$('#summernote').summernote({
    height: 500,                 // set editor height
    minHeight:null,             // set minimum heightof editor
    maxHeight:null,             // set maximum heightof editor
    focus: true,                  // set focus to editable areaafter initializing summernote
    callbacks : {
        onImageUpload : function(files) {
            sendFile(files[0]);
        }
    }
});

// 发送文件
function sendFile(file) {
    var data = new FormData();
    data.append("file", file);
    var message;
    message = uploadFile(data, $('#uploadMsg'), 'uploadImage');

    $('#summernote').summernote('editor.insertImage', 
        domain+"files/images/"+message.data);
}
// text提交
function submitup() {
    var sumcode = $('#summernote').summernote('code');
    
    var data = {
        sumcode:sumcode
    }; 
    postUrl(data, "text");
    location.href = "index";
}

</script>