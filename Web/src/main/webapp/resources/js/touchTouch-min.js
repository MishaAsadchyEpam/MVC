(function () {
    var g = !1;
    $.fn.touchTouch = function () {
        function q(a) {
            if (g)return!1;
            e.show();
            setTimeout(function () {
                e.addClass("visible")
            }, 100);
            k(a);
            g = !0
        }

        function k(a) {
            c.css("left", 100 * -a + "%")
        }

        function f(a) {
            setTimeout(function () {
                m(a)
            }, 1E3)
        }

        function m(a) {
            if (0 > a || a >= d.length)return!1;
            r(d.eq(a).attr("href"), function () {
                h.eq(a).html(this)
            })
        }

        function r(a, b) {
            var c = $("<img>").on("load", function () {
                b.call(c)
            });
            c.attr("src", a)
        }

        function n() {
            b + 1 < d.length ? (b++, k(b), f(b + l)) : (c.addClass("rightSpring"), setTimeout(function () {
                    c.removeClass("rightSpring")
                },
                500))
        }

        function p() {
            0 < b ? (b--, k(b), f(b - l)) : (c.addClass("leftSpring"), setTimeout(function () {
                c.removeClass("leftSpring")
            }, 500))
        }

        $("#galleryOverlay").remove();
        var b = 0, e = $('<div id="galleryOverlay">'), c = $('<div id="gallerySlider">'), s = $('<a id="prevArrow"></a>'), t = $('<a id="nextArrow"></a>'), d = this, h = $([]), l = 1;
        e.hide().appendTo("body");
        c.appendTo(e);
        e.append(s).append(t);
        d.each(function () {
            h = h.add($('<div class="placeholder">'))
        });
        c.append(h).on("click", function (a) {
            $(a.target).is("img") || g && (e.hide().removeClass("visible"),
                g = !1)
        });
        $("#prevArrow").click(function (a) {
            a.preventDefault();
            p()
        });
        $("#nextArrow").click(function (a) {
            a.preventDefault();
            n()
        });
        d.on("click", function (a) {
            a.preventDefault();
            b = d.index(this);
            q(b);
            m(b);
            for (a = 0; a <= l; ++a)f(b + a), f(b - a);
            for (a = 0; a < d.size(); ++a)f(a)
        });
        $(window).bind("keydown", function (a) {
            37 == a.keyCode ? p() : 39 == a.keyCode && n()
        })
    }
})(jQuery);