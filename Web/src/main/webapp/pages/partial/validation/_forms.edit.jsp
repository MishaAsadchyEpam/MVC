<jsp:include page="../../partial/shared/_ajaxForms.jsp"/>
<script>
    $(document).ready(function () {
        $("#form").validate({
            rules: {
                aboutMe: {
                    required: true,
                    maxlength: 50
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
<script type="text/javascript">

    var currentPhoto,
            myPhoto,
            currentAboutMe,
            lastPhoto,
            lastAboutMe,
            noPhoto = "${mediaFolder}/NoPhoto.jpg";

    $(document).ready(function () {
        currentPhoto = document.getElementById("currentPhoto");
        myPhoto = document.getElementById("myPhoto");

        currentAboutMe = document.getElementById("aboutMe");

        lastPhoto = document.getElementById("currentPhoto").src;
        lastAboutMe = document.getElementById("aboutMe").value;

        myPhoto.value = currentPhoto.src;
    });

    function setPhoto(photo) {
        currentPhoto.src = photo;
        myPhoto.value = photo;
    }

    function changeCurrentPhoto(newPhoto) {
        var photo = document.getElementById(newPhoto);
        setPhoto(photo.src);
    }


    function resetChanges() {
        setPhoto(lastPhoto);
        currentAboutMe.value = lastAboutMe;
    }

    function notPhoto() {
        setPhoto(noPhoto);
    }


</script>
