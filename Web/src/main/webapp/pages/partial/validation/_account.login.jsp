<jsp:include page="../../partial/shared/_ajaxForms.jsp"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script>
    $(document).ready(function () {
        $("#form").validate({
            rules: {
                j_username: {
                    required: true,
                    maxlength: 50,
                    remote: {
                        url: "${pageContext.request.contextPath}/account/exist",
                        type: "get",
                        data: {
                            username: function () {
                                return $("#j_username").val();
                            }
                        }
                    }
                },
                j_password: {
                    required: true,
                    minlength: 6,
                    maxlength: 50
                }
            },

            messages:{
                j_username: {
                    required: "<spring:message code="account.register.validation.username.requiredMessage"/>",
                    maxlength: $.validator.format("<spring:message code="account.register.validation.username.maxlengthMessage"/>"),
                    email: "<spring:message code="account.register.validation.username.emailMessage"/>",
                    remote: "<spring:message code="account.login.validation.username.remoteMessage"/>"
                },
                j_password: {
                    required: "<spring:message code="account.login.validation.password.required"/>",
                    minlength: $.validator.format("<spring:message code="account.register.validation.password.minlengthMessage"/>"),
                    maxlength: $.validator.format("<spring:message code="account.register.validation.password.maxlengthMessage"/>")

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
