<jsp:include page="../../partial/shared/_ajaxForms.jsp"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script>
    $(document).ready(function () {
        $("#form").validate({
            rules: {
                username: {
                    required: true,
                    maxlength: 50,
                    email: true,
                    remote: {
                        url: "${pageContext.request.contextPath}/account/available",
                        type: "get",
                        data: {
                            username: function () {
                                return $("#username").val();
                            }
                        }
                    }
                },
                password: {
                    required: true,
                    minlength: 6,
                    maxlength: 50
                },
                passwordConfirm: {
                    required: true,
                    maxlength: 50,
                    equalTo: "#password"
                },
                nickName: {
                    required: true,
                    maxlength: 50
                }
            },
            messages: {
                username: {
                    required: "<spring:message code="account.register.validation.username.requiredMessage"/>",
                    maxlength: $.validator.format("<spring:message code="account.register.validation.username.maxlengthMessage"/>"),
                    email: "<spring:message code="account.register.validation.username.emailMessage"/>",
                    remote: "<spring:message code="account.register.validation.username.remoteMessage"/>"
                },
                password: {
                    required: "<spring:message code="account.register.validation.password.requiredMessage"/>",
                    minlength: $.validator.format("<spring:message code="account.register.validation.password.minlengthMessage"/>"),
                    maxlength: $.validator.format("<spring:message code="account.register.validation.password.maxlengthMessage"/>")
                },
                passwordConfirm: {
                    required: "<spring:message code="account.register.validation.passwordConfirm.requiredMessage"/>",
                    maxlength: $.validator.format("<spring:message code="account.register.validation.passwordConfirm.maxlengthMessage"/>"),
                    equalTo: "<spring:message code="account.register.validation.passwordConfirm.equalToMessage"/>"
                },
                nickName: {
                    required: "<spring:message code="account.register.validation.nickName.requiredMessage"/>",
                    maxlength: $.validator.format("<spring:message code="account.register.validation.nickName.maxlengthMessage"/>")
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
