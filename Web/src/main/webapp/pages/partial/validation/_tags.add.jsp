<jsp:include page="../../partial/shared/_ajaxForms.jsp"/>

<script>
    $(document).ready(function () {
        $("#form").validate({
            rules: {
                tagName: {
                    required: true,
                    maxlength: 50,
                    remote: {
                        url: "${pageContext.request.contextPath}/tags/available",
                        type: "get",
                        data: {
                            tagName: function () {
                                return $("#tagName").val();
                            }
                        }
                    }
                }
            },
            highlight: function (element) {

                var rootElement = $(element).closest(".form-group");

                rootElement.children("span").removeClass("glyphicon-ok").addClass("glyphicon-remove");
                rootElement.removeClass("has-success").addClass("has-error");

            },
            unhighlight: function (element) {
                var rootElement = $(element).closest(".form-group");

                rootElement.children("span").removeClass("glyphicon-remove").addClass("glyphicon-ok");
                rootElement.removeClass("has-error").addClass("has-success");
            }
        });
    });
</script>
