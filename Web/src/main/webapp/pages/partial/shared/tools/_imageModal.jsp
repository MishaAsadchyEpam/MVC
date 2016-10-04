<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center">
            </div>
        </div>
    </div>
</div>
<link rel="stylesheet" href="<c:url value='/resources/css/tools/imageModal.css'/>"/>
<script>
    $(document).ready(function () {
        $('img').on('click', function () {
            var src = $(this).attr('src');
            var img = '<img src="' + src + '" class="imageModal"/>';
            var myModal = $('#myModal');
            myModal.modal();
            myModal.on('shown.bs.modal', function () {
                myModal.find('.modal-body').html(img);
            });
            myModal.on('hidden.bs.modal', function () {
                myModal.find('.modal-body').html('');
            });
        });
    })
</script>
