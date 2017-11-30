<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${article}" var="article">
    <div class="container" id="id${article.id}">
        <div class="row">
            <div class="span4">
                <div class="thumbnail">
                    <div class="caption">
                        <p>${article.text}</p>
                        <a class="btn pull-right">${article.issued}</a>
                    </div>
                    <button class="btn btn-danger" onclick="RecycleArticle(this)"
                        data-toggle="modal" data-target="#isRecycle"
                        data-id="${article.id}">删除</button>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
<script type="text/javascript">
function RecycleArticle(obj) {

    //获取"确认删除"按钮
    var recycleBtn = document.getElementById("recycleBtn");
    //当点击确认时
    recycleBtn.onclick = function() {
        var message;
        var id = $(obj).data("id");
        var data = {
            id : id
        }
        $('#isRecycle').modal('hide');
        message = postUrl(data, "delectArticle");
        alert(message);
        $("#id" + id).remove();
    }
}

</script>
<!-- 确定删除弹窗 -->
<div class="modal fade bs-example-modal-sm" id="isRecycle"
    tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>你是否确认，日记删除，不可找回</p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal">取消</button>
                <button class="btn btn-danger" id="recycleBtn">确定删除</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>