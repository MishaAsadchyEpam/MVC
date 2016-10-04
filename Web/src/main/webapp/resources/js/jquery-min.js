(function (u, W) {
    "object" === typeof module && "object" === typeof module.exports ? module.exports = u.document ? W(u, !0) : function (u) {
        if (!u.document)throw Error("jQuery requires a window with a document");
        return W(u)
    } : W(u)
})("undefined" !== typeof window ? window : this, function (u, W) {
    function Ca(a) {
        var b = a.length, c = d.type(a);
        return"function" === c || d.isWindow(a) ? !1 : 1 === a.nodeType && b ? !0 : "array" === c || 0 === b || "number" === typeof b && 0 < b && b - 1 in a
    }

    function Da(a, b, c) {
        if (d.isFunction(b))return d.grep(a, function (a, d) {
            return!!b.call(a,
                d, a) !== c
        });
        if (b.nodeType)return d.grep(a, function (a) {
            return a === b !== c
        });
        if ("string" === typeof b) {
            if (Jb.test(b))return d.filter(b, a, c);
            b = d.filter(b, a)
        }
        return d.grep(a, function (a) {
            return 0 <= la.call(b, a) !== c
        })
    }

    function Sa(a, b) {
        for (; (a = a[b]) && 1 !== a.nodeType;);
        return a
    }

    function Kb(a) {
        var b = Ta[a] = {};
        d.each(a.match(L) || [], function (a, d) {
            b[d] = !0
        });
        return b
    }

    function ma() {
        s.removeEventListener("DOMContentLoaded", ma, !1);
        u.removeEventListener("load", ma, !1);
        d.ready()
    }

    function M() {
        Object.defineProperty(this.cache =
        {}, 0, {get: function () {
            return{}
        }});
        this.expando = d.expando + Math.random()
    }

    function Ua(a, b, c) {
        if (void 0 === c && 1 === a.nodeType)if (c = "data-" + b.replace(Lb, "-$1").toLowerCase(), c = a.getAttribute(c), "string" === typeof c) {
            try {
                c = "true" === c ? !0 : "false" === c ? !1 : "null" === c ? null : +c + "" === c ? +c : Mb.test(c) ? d.parseJSON(c) : c
            } catch (e) {
            }
            G.set(a, b, c)
        } else c = void 0;
        return c
    }

    function na() {
        return!0
    }

    function X() {
        return!1
    }

    function Va() {
        try {
            return s.activeElement
        } catch (a) {
        }
    }

    function Wa(a, b) {
        return d.nodeName(a, "table") && d.nodeName(11 !==
            b.nodeType ? b : b.firstChild, "tr") ? a.getElementsByTagName("tbody")[0] || a.appendChild(a.ownerDocument.createElement("tbody")) : a
    }

    function Nb(a) {
        a.type = (null !== a.getAttribute("type")) + "/" + a.type;
        return a
    }

    function Ob(a) {
        var b = Pb.exec(a.type);
        b ? a.type = b[1] : a.removeAttribute("type");
        return a
    }

    function Ea(a, b) {
        for (var c = 0, d = a.length; c < d; c++)n.set(a[c], "globalEval", !b || n.get(b[c], "globalEval"))
    }

    function Xa(a, b) {
        var c, e, f, g;
        if (1 === b.nodeType) {
            if (n.hasData(a) && (g = n.access(a), c = n.set(b, g), g = g.events))for (f in delete c.handle,
                c.events = {}, g)for (c = 0, e = g[f].length; c < e; c++)d.event.add(b, f, g[f][c]);
            G.hasData(a) && (f = G.access(a), f = d.extend({}, f), G.set(b, f))
        }
    }

    function x(a, b) {
        var c = a.getElementsByTagName ? a.getElementsByTagName(b || "*") : a.querySelectorAll ? a.querySelectorAll(b || "*") : [];
        return void 0 === b || b && d.nodeName(a, b) ? d.merge([a], c) : c
    }

    function Ya(a, b) {
        var c, e = d(b.createElement(a)).appendTo(b.body), f = u.getDefaultComputedStyle && (c = u.getDefaultComputedStyle(e[0])) ? c.display : d.css(e[0], "display");
        e.detach();
        return f
    }

    function Fa(a) {
        var b =
            s, c = Za[a];
        c || (c = Ya(a, b), "none" !== c && c || (T = (T || d("<iframe frameborder='0' width='0' height='0'/>")).appendTo(b.documentElement), b = T[0].contentDocument, b.write(), b.close(), c = Ya(a, b), T.detach()), Za[a] = c);
        return c
    }

    function Y(a, b, c) {
        var e, f, g = a.style;
        (c = c || oa(a)) && (f = c.getPropertyValue(b) || c[b]);
        c && ("" !== f || d.contains(a.ownerDocument, a) || (f = d.style(a, b)), Ga.test(f) && $a.test(b) && (a = g.width, b = g.minWidth, e = g.maxWidth, g.minWidth = g.maxWidth = g.width = f, f = c.width, g.width = a, g.minWidth = b, g.maxWidth = e));
        return void 0 !==
            f ? f + "" : f
    }

    function ab(a, b) {
        return{get: function () {
            if (a())delete this.get; else return(this.get = b).apply(this, arguments)
        }}
    }

    function bb(a, b) {
        if (b in a)return b;
        for (var c = b[0].toUpperCase() + b.slice(1), d = b, f = cb.length; f--;)if (b = cb[f] + c, b in a)return b;
        return d
    }

    function db(a, b, c) {
        return(a = Qb.exec(b)) ? Math.max(0, a[1] - (c || 0)) + (a[2] || "px") : b
    }

    function eb(a, b, c, e, f) {
        b = c === (e ? "border" : "content") ? 4 : "width" === b ? 1 : 0;
        for (var g = 0; 4 > b; b += 2)"margin" === c && (g += d.css(a, c + K[b], !0, f)), e ? ("content" === c && (g -= d.css(a, "padding" +
            K[b], !0, f)), "margin" !== c && (g -= d.css(a, "border" + K[b] + "Width", !0, f))) : (g += d.css(a, "padding" + K[b], !0, f), "padding" !== c && (g += d.css(a, "border" + K[b] + "Width", !0, f)));
        return g
    }

    function fb(a, b, c) {
        var e = !0, f = "width" === b ? a.offsetWidth : a.offsetHeight, g = oa(a), h = "border-box" === d.css(a, "boxSizing", !1, g);
        if (0 >= f || null == f) {
            f = Y(a, b, g);
            if (0 > f || null == f)f = a.style[b];
            if (Ga.test(f))return f;
            e = h && (w.boxSizingReliable() || f === a.style[b]);
            f = parseFloat(f) || 0
        }
        return f + eb(a, b, c || (h ? "border" : "content"), e, g) + "px"
    }

    function gb(a, b) {
        for (var c,
                 e, f, g = [], h = 0, k = a.length; h < k; h++)e = a[h], e.style && (g[h] = n.get(e, "olddisplay"), c = e.style.display, b ? (g[h] || "none" !== c || (e.style.display = ""), "" === e.style.display && U(e) && (g[h] = n.access(e, "olddisplay", Fa(e.nodeName)))) : (f = U(e), "none" === c && f || n.set(e, "olddisplay", f ? c : d.css(e, "display"))));
        for (h = 0; h < k; h++)e = a[h], !e.style || b && "none" !== e.style.display && "" !== e.style.display || (e.style.display = b ? g[h] || "" : "none");
        return a
    }

    function A(a, b, c, d, f) {
        return new A.prototype.init(a, b, c, d, f)
    }

    function hb() {
        setTimeout(function () {
            Z = void 0
        });
        return Z = d.now()
    }

    function pa(a, b) {
        var c, d = 0, f = {height: a};
        for (b = b ? 1 : 0; 4 > d; d += 2 - b)c = K[d], f["margin" + c] = f["padding" + c] = a;
        b && (f.opacity = f.width = a);
        return f
    }

    function ib(a, b, c) {
        for (var d, f = (Q[b] || []).concat(Q["*"]), g = 0, h = f.length; g < h; g++)if (d = f[g].call(c, b, a))return d
    }

    function Rb(a, b) {
        var c, e, f, g, h;
        for (c in a)if (e = d.camelCase(c), f = b[e], g = a[c], d.isArray(g) && (f = g[1], g = a[c] = g[0]), c !== e && (a[e] = g, delete a[c]), (h = d.cssHooks[e]) && "expand"in h)for (c in g = h.expand(g), delete a[e], g)c in a || (a[c] = g[c], b[c] =
            f); else b[e] = f
    }

    function jb(a, b, c) {
        var e, f = 0, g = qa.length, h = d.Deferred().always(function () {
            delete k.elem
        }), k = function () {
            if (e)return!1;
            for (var b = Z || hb(), b = Math.max(0, l.startTime + l.duration - b), c = 1 - (b / l.duration || 0), d = 0, f = l.tweens.length; d < f; d++)l.tweens[d].run(c);
            h.notifyWith(a, [l, c, b]);
            if (1 > c && f)return b;
            h.resolveWith(a, [l]);
            return!1
        }, l = h.promise({elem: a, props: d.extend({}, b), opts: d.extend(!0, {specialEasing: {}}, c), originalProperties: b, originalOptions: c, startTime: Z || hb(), duration: c.duration, tweens: [],
            createTween: function (b, c) {
                var e = d.Tween(a, l.opts, b, c, l.opts.specialEasing[b] || l.opts.easing);
                l.tweens.push(e);
                return e
            }, stop: function (b) {
                var c = 0, d = b ? l.tweens.length : 0;
                if (e)return this;
                for (e = !0; c < d; c++)l.tweens[c].run(1);
                b ? h.resolveWith(a, [l, b]) : h.rejectWith(a, [l, b]);
                return this
            }});
        c = l.props;
        for (Rb(c, l.opts.specialEasing); f < g; f++)if (b = qa[f].call(l, a, c, l.opts))return b;
        d.map(c, ib, l);
        d.isFunction(l.opts.start) && l.opts.start.call(a, l);
        d.fx.timer(d.extend(k, {elem: a, anim: l, queue: l.opts.queue}));
        return l.progress(l.opts.progress).done(l.opts.done,
            l.opts.complete).fail(l.opts.fail).always(l.opts.always)
    }

    function kb(a) {
        return function (b, c) {
            "string" !== typeof b && (c = b, b = "*");
            var e, f = 0, g = b.toLowerCase().match(L) || [];
            if (d.isFunction(c))for (; e = g[f++];)"+" === e[0] ? (e = e.slice(1) || "*", (a[e] = a[e] || []).unshift(c)) : (a[e] = a[e] || []).push(c)
        }
    }

    function lb(a, b, c, e) {
        function f(k) {
            var l;
            g[k] = !0;
            d.each(a[k] || [], function (a, d) {
                var k = d(b, c, e);
                if ("string" === typeof k && !h && !g[k])return b.dataTypes.unshift(k), f(k), !1;
                if (h)return!(l = k)
            });
            return l
        }

        var g = {}, h = a === Ha;
        return f(b.dataTypes[0]) ||
            !g["*"] && f("*")
    }

    function Ia(a, b) {
        var c, e, f = d.ajaxSettings.flatOptions || {};
        for (c in b)void 0 !== b[c] && ((f[c] ? a : e || (e = {}))[c] = b[c]);
        e && d.extend(!0, a, e);
        return a
    }

    function Ja(a, b, c, e) {
        var f;
        if (d.isArray(b))d.each(b, function (b, d) {
            c || Sb.test(a) ? e(a, d) : Ja(a + "[" + ("object" === typeof d ? b : "") + "]", d, c, e)
        }); else if (c || "object" !== d.type(b))e(a, b); else for (f in b)Ja(a + "[" + f + "]", b[f], c, e)
    }

    function mb(a) {
        return d.isWindow(a) ? a : 9 === a.nodeType && a.defaultView
    }

    var $ = [], N = $.slice, nb = $.concat, Ka = $.push, la = $.indexOf, aa = {},
        Tb = aa.toString, La = aa.hasOwnProperty, w = {}, s = u.document, d = function (a, b) {
            return new d.fn.init(a, b)
        }, Ub = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, Vb = /^-ms-/, Wb = /-([\da-z])/gi, Xb = function (a, b) {
            return b.toUpperCase()
        };
    d.fn = d.prototype = {jquery: "2.1.1", constructor: d, selector: "", length: 0, toArray: function () {
        return N.call(this)
    }, get: function (a) {
        return null != a ? 0 > a ? this[a + this.length] : this[a] : N.call(this)
    }, pushStack: function (a) {
        a = d.merge(this.constructor(), a);
        a.prevObject = this;
        a.context = this.context;
        return a
    }, each: function (a, b) {
        return d.each(this, a, b)
    }, map: function (a) {
        return this.pushStack(d.map(this, function (b, c) {
            return a.call(b, c, b)
        }))
    }, slice: function () {
        return this.pushStack(N.apply(this, arguments))
    }, first: function () {
        return this.eq(0)
    }, last: function () {
        return this.eq(-1)
    }, eq: function (a) {
        var b = this.length;
        a = +a + (0 > a ? b : 0);
        return this.pushStack(0 <= a && a < b ? [this[a]] : [])
    }, end: function () {
        return this.prevObject || this.constructor(null)
    }, push: Ka, sort: $.sort, splice: $.splice};
    d.extend = d.fn.extend = function () {
        var a, b, c, e, f, g = arguments[0] ||
        {}, h = 1, k = arguments.length, l = !1;
        "boolean" === typeof g && (l = g, g = arguments[h] || {}, h++);
        "object" === typeof g || d.isFunction(g) || (g = {});
        h === k && (g = this, h--);
        for (; h < k; h++)if (null != (a = arguments[h]))for (b in a)c = g[b], e = a[b], g !== e && (l && e && (d.isPlainObject(e) || (f = d.isArray(e))) ? (f ? (f = !1, c = c && d.isArray(c) ? c : []) : c = c && d.isPlainObject(c) ? c : {}, g[b] = d.extend(l, c, e)) : void 0 !== e && (g[b] = e));
        return g
    };
    d.extend({expando: "jQuery" + ("2.1.1" + Math.random()).replace(/\D/g, ""), isReady: !0, error: function (a) {
        throw Error(a);
    }, noop: function () {
    },
        isFunction: function (a) {
            return"function" === d.type(a)
        }, isArray: Array.isArray, isWindow: function (a) {
            return null != a && a === a.window
        }, isNumeric: function (a) {
            return!d.isArray(a) && 0 <= a - parseFloat(a)
        }, isPlainObject: function (a) {
            return"object" !== d.type(a) || a.nodeType || d.isWindow(a) || a.constructor && !La.call(a.constructor.prototype, "isPrototypeOf") ? !1 : !0
        }, isEmptyObject: function (a) {
            for (var b in a)return!1;
            return!0
        }, type: function (a) {
            return null == a ? a + "" : "object" === typeof a || "function" === typeof a ? aa[Tb.call(a)] || "object" :
                typeof a
        }, globalEval: function (a) {
            var b;
            b = eval;
            if (a = d.trim(a))1 === a.indexOf("use strict") ? (b = s.createElement("script"), b.text = a, s.head.appendChild(b).parentNode.removeChild(b)) : b(a)
        }, camelCase: function (a) {
            return a.replace(Vb, "ms-").replace(Wb, Xb)
        }, nodeName: function (a, b) {
            return a.nodeName && a.nodeName.toLowerCase() === b.toLowerCase()
        }, each: function (a, b, c) {
            var d, f = 0, g = a.length;
            d = Ca(a);
            if (c)if (d)for (; f < g && (d = b.apply(a[f], c), !1 !== d); f++); else for (f in a) {
                if (d = b.apply(a[f], c), !1 === d)break
            } else if (d)for (; f <
                                    g && (d = b.call(a[f], f, a[f]), !1 !== d); f++); else for (f in a)if (d = b.call(a[f], f, a[f]), !1 === d)break;
            return a
        }, trim: function (a) {
            return null == a ? "" : (a + "").replace(Ub, "")
        }, makeArray: function (a, b) {
            var c = b || [];
            null != a && (Ca(Object(a)) ? d.merge(c, "string" === typeof a ? [a] : a) : Ka.call(c, a));
            return c
        }, inArray: function (a, b, c) {
            return null == b ? -1 : la.call(b, a, c)
        }, merge: function (a, b) {
            for (var c = +b.length, d = 0, f = a.length; d < c; d++)a[f++] = b[d];
            a.length = f;
            return a
        }, grep: function (a, b, c) {
            for (var d = [], f = 0, g = a.length, h = !c; f < g; f++)c = !b(a[f],
                f), c !== h && d.push(a[f]);
            return d
        }, map: function (a, b, c) {
            var d, f = 0, g = a.length, h = [];
            if (Ca(a))for (; f < g; f++)d = b(a[f], f, c), null != d && h.push(d); else for (f in a)d = b(a[f], f, c), null != d && h.push(d);
            return nb.apply([], h)
        }, guid: 1, proxy: function (a, b) {
            var c, e;
            "string" === typeof b && (c = a[b], b = a, a = c);
            if (d.isFunction(a))return e = N.call(arguments, 2), c = function () {
                return a.apply(b || this, e.concat(N.call(arguments)))
            }, c.guid = a.guid = a.guid || d.guid++, c
        }, now: Date.now, support: w});
    d.each("Boolean Number String Function Array Date RegExp Object Error".split(" "),
        function (a, b) {
            aa["[object " + b + "]"] = b.toLowerCase()
        });
    var V = function (a) {
        function b(a, b, c, d) {
            var e, f, g, h, k;
            (b ? b.ownerDocument || b : C) !== B && ba(b);
            b = b || B;
            c = c || [];
            if (!a || "string" !== typeof a)return c;
            if (1 !== (h = b.nodeType) && 9 !== h)return[];
            if (R && !d) {
                if (e = qa.exec(a))if (g = e[1])if (9 === h)if ((f = b.getElementById(g)) && f.parentNode) {
                    if (f.id === g)return c.push(f), c
                } else return c; else {
                    if (b.ownerDocument && (f = b.ownerDocument.getElementById(g)) && ta(b, f) && f.id === g)return c.push(f), c
                } else {
                    if (e[2])return ca.apply(c, b.getElementsByTagName(a)),
                        c;
                    if ((g = e[3]) && v.getElementsByClassName && b.getElementsByClassName)return ca.apply(c, b.getElementsByClassName(g)), c
                }
                if (v.qsa && (!D || !D.test(a))) {
                    f = e = E;
                    g = b;
                    k = 9 === h && a;
                    if (1 === h && "object" !== b.nodeName.toLowerCase()) {
                        h = ua(a);
                        (e = b.getAttribute("id")) ? f = e.replace(sa, "\\$&") : b.setAttribute("id", f);
                        f = "[id='" + f + "'] ";
                        for (g = h.length; g--;)h[g] = f + t(h[g]);
                        g = aa.test(a) && q(b.parentNode) || b;
                        k = h.join(",")
                    }
                    if (k)try {
                        return ca.apply(c, g.querySelectorAll(k)), c
                    } catch (l) {
                    } finally {
                        e || b.removeAttribute("id")
                    }
                }
            }
            return A(a.replace(Q,
                "$1"), b, c, d)
        }

        function c() {
            function a(c, d) {
                b.push(c + " ") > r.cacheLength && delete a[b.shift()];
                return a[c + " "] = d
            }

            var b = [];
            return a
        }

        function d(a) {
            a[E] = !0;
            return a
        }

        function f(a) {
            var b = B.createElement("div");
            try {
                return!!a(b)
            } catch (c) {
                return!1
            } finally {
                b.parentNode && b.parentNode.removeChild(b)
            }
        }

        function g(a, b) {
            for (var c = a.split("|"), d = a.length; d--;)r.attrHandle[c[d]] = b
        }

        function h(a, b) {
            var c = b && a, d = c && 1 === a.nodeType && 1 === b.nodeType && (~b.sourceIndex || S) - (~a.sourceIndex || S);
            if (d)return d;
            if (c)for (; c = c.nextSibling;)if (c ===
                b)return-1;
            return a ? 1 : -1
        }

        function k(a) {
            return function (b) {
                return"input" === b.nodeName.toLowerCase() && b.type === a
            }
        }

        function l(a) {
            return function (b) {
                var c = b.nodeName.toLowerCase();
                return("input" === c || "button" === c) && b.type === a
            }
        }

        function p(a) {
            return d(function (b) {
                b = +b;
                return d(function (c, d) {
                    for (var e, f = a([], c.length, b), g = f.length; g--;)c[e = f[g]] && (c[e] = !(d[e] = c[e]))
                })
            })
        }

        function q(a) {
            return a && typeof a.getElementsByTagName !== K && a
        }

        function m() {
        }

        function t(a) {
            for (var b = 0, c = a.length, d = ""; b < c; b++)d += a[b].value;
            return d
        }

        function y(a, b, c) {
            var d = b.dir, e = c && "parentNode" === d, f = L++;
            return b.first ? function (b, c, f) {
                for (; b = b[d];)if (1 === b.nodeType || e)return a(b, c, f)
            } : function (b, c, g) {
                var h, Ma, k = [I, f];
                if (g)for (; b = b[d];) {
                    if ((1 === b.nodeType || e) && a(b, c, g))return!0
                } else for (; b = b[d];)if (1 === b.nodeType || e) {
                    Ma = b[E] || (b[E] = {});
                    if ((h = Ma[d]) && h[0] === I && h[1] === f)return k[2] = h[2];
                    Ma[d] = k;
                    if (k[2] = a(b, c, g))return!0
                }
            }
        }

        function n(a) {
            return 1 < a.length ? function (b, c, d) {
                for (var e = a.length; e--;)if (!a[e](b, c, d))return!1;
                return!0
            } : a[0]
        }

        function u(a, b, c, d, e) {
            for (var f, g = [], h = 0, k = a.length, l = null != b; h < k; h++)if (f = a[h])if (!c || c(f, d, e))g.push(f), l && b.push(h);
            return g
        }

        function s(a, c, f, g, h, k) {
            g && !g[E] && (g = s(g));
            h && !h[E] && (h = s(h, k));
            return d(function (d, e, k, l) {
                var m, p, q = [], r = [], pb = e.length, t;
                if (!(t = d)) {
                    t = c || "*";
                    for (var n = k.nodeType ? [k] : k, y = [], s = 0, ia = n.length; s < ia; s++)b(t, n[s], y);
                    t = y
                }
                t = !a || !d && c ? t : u(t, q, a, k, l);
                n = f ? h || (d ? a : pb || g) ? [] : e : t;
                f && f(t, n, k, l);
                if (g)for (m = u(n, r), g(m, [], k, l), k = m.length; k--;)if (p = m[k])n[r[k]] = !(t[r[k]] = p);
                if (d) {
                    if (h || a) {
                        if (h) {
                            m = [];
                            for (k = n.length; k--;)(p = n[k]) && m.push(t[k] = p);
                            h(null, n = [], m, l)
                        }
                        for (k = n.length; k--;)(p = n[k]) && -1 < (m = h ? ha.call(d, p) : q[k]) && (d[m] = !(e[m] = p))
                    }
                } else n = u(n === e ? n.splice(pb, n.length) : n), h ? h(null, e, n, l) : ca.apply(e, n)
            })
        }

        function w(a) {
            var b, c, d, e = a.length, f = r.relative[a[0].type];
            c = f || r.relative[" "];
            for (var g = f ? 1 : 0, h = y(function (a) {
                return a === b
            }, c, !0), k = y(function (a) {
                return-1 < ha.call(b, a)
            }, c, !0), l = [function (a, c, d) {
                return!f && (d || c !== z) || ((b = c).nodeType ? h(a, c, d) : k(a, c, d))
            }]; g < e; g++)if (c = r.relative[a[g].type])l =
                [y(n(l), c)]; else {
                c = r.filter[a[g].type].apply(null, a[g].matches);
                if (c[E]) {
                    for (d = ++g; d < e && !r.relative[a[d].type]; d++);
                    return s(1 < g && n(l), 1 < g && t(a.slice(0, g - 1).concat({value: " " === a[g - 2].type ? "*" : ""})).replace(Q, "$1"), c, g < d && w(a.slice(g, d)), d < e && w(a = a.slice(d)), d < e && t(a))
                }
                l.push(c)
            }
            return n(l)
        }

        function G(a, c) {
            var f = 0 < c.length, g = 0 < a.length, h = function (d, e, h, k, l) {
                var m, p, q, t = 0, n = "0", xa = d && [], y = [], s = z, ia = d || g && r.find.TAG("*", l), w = I += null == s ? 1 : Math.random() || .1, v = ia.length;
                for (l && (z = e !== B && e); n !== v && null !=
                    (m = ia[n]); n++) {
                    if (g && m) {
                        for (p = 0; q = a[p++];)if (q(m, e, h)) {
                            k.push(m);
                            break
                        }
                        l && (I = w)
                    }
                    f && ((m = !q && m) && t--, d && xa.push(m))
                }
                t += n;
                if (f && n !== t) {
                    for (p = 0; q = c[p++];)q(xa, y, e, h);
                    if (d) {
                        if (0 < t)for (; n--;)xa[n] || y[n] || (y[n] = Z.call(k));
                        y = u(y)
                    }
                    ca.apply(k, y);
                    l && !d && 0 < y.length && 1 < t + c.length && b.uniqueSort(k)
                }
                l && (I = w, z = s);
                return xa
            };
            return f ? d(h) : h
        }

        var J, v, r, x, ia, ua, Na, A, z, da, ra, ba, B, H, R, D, F, ya, ta, E = "sizzle" + -new Date, C = a.document, I = 0, L = 0, N = c(), O = c(), P = c(), M = function (a, b) {
                a === b && (ra = !0);
                return 0
            }, K = "undefined", S = -2147483648,
            X = {}.hasOwnProperty, ea = [], Z = ea.pop, $ = ea.push, ca = ea.push, V = ea.slice, ha = ea.indexOf || function (a) {
                for (var b = 0, c = this.length; b < c; b++)if (this[b] === a)return b;
                return-1
            }, W = "(?:\\\\.|[\\w-]|[^\\x00-\\xa0])+".replace("w", "w#"), Y = "\\[[\\x20\\t\\r\\n\\f]*((?:\\\\.|[\\w-]|[^\\x00-\\xa0])+)(?:[\\x20\\t\\r\\n\\f]*([*^$|!~]?=)[\\x20\\t\\r\\n\\f]*(?:'((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\"|(" + W + "))|)[\\x20\\t\\r\\n\\f]*\\]", U = ":((?:\\\\.|[\\w-]|[^\\x00-\\xa0])+)(?:\\((('((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\")|((?:\\\\.|[^\\\\()[\\]]|" +
                Y + ")*)|.*)\\)|)", Q = RegExp("^[\\x20\\t\\r\\n\\f]+|((?:^|[^\\\\])(?:\\\\.)*)[\\x20\\t\\r\\n\\f]+$", "g"), ja = /^[\x20\t\r\n\f]*,[\x20\t\r\n\f]*/, ka = /^[\x20\t\r\n\f]*([>+~]|[\x20\t\r\n\f])[\x20\t\r\n\f]*/, la = RegExp("=[\\x20\\t\\r\\n\\f]*([^\\]'\"]*?)[\\x20\\t\\r\\n\\f]*\\]", "g"), ma = new RegExp(U), na = new RegExp("^" + W + "$"), T = {ID: /^#((?:\\.|[\w-]|[^\x00-\xa0])+)/, CLASS: /^\.((?:\\.|[\w-]|[^\x00-\xa0])+)/, TAG: new RegExp("^(" + "(?:\\\\.|[\\w-]|[^\\x00-\\xa0])+".replace("w", "w*") + ")"), ATTR: new RegExp("^" + Y), PSEUDO: new RegExp("^" +
                U), CHILD: RegExp("^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\([\\x20\\t\\r\\n\\f]*(even|odd|(([+-]|)(\\d*)n|)[\\x20\\t\\r\\n\\f]*(?:([+-]|)[\\x20\\t\\r\\n\\f]*(\\d+)|))[\\x20\\t\\r\\n\\f]*\\)|)", "i"), bool: RegExp("^(?:checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|ismap|loop|multiple|open|readonly|required|scoped)$", "i"), needsContext: RegExp("^[\\x20\\t\\r\\n\\f]*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\([\\x20\\t\\r\\n\\f]*((?:-\\d)?\\d*)[\\x20\\t\\r\\n\\f]*\\)|)(?=[^-]|$)",
                "i")}, oa = /^(?:input|select|textarea|button)$/i, pa = /^h\d$/i, va = /^[^{]+\{\s*\[native \w/, qa = /^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/, aa = /[+~]/, sa = /'|\\/g, fa = RegExp("\\\\([\\da-f]{1,6}[\\x20\\t\\r\\n\\f]?|([\\x20\\t\\r\\n\\f])|.)", "ig"), ga = function (a, b, c) {
                a = "0x" + b - 65536;
                return a !== a || c ? b : 0 > a ? String.fromCharCode(a + 65536) : String.fromCharCode(a >> 10 | 55296, a & 1023 | 56320)
            };
        try {
            ca.apply(ea = V.call(C.childNodes), C.childNodes), ea[C.childNodes.length].nodeType
        } catch (wa) {
            ca = {apply: ea.length ? function (a, b) {
                $.apply(a, V.call(b))
            } :
                function (a, b) {
                    for (var c = a.length, d = 0; a[c++] = b[d++];);
                    a.length = c - 1
                }}
        }
        v = b.support = {};
        ia = b.isXML = function (a) {
            return(a = a && (a.ownerDocument || a).documentElement) ? "HTML" !== a.nodeName : !1
        };
        ba = b.setDocument = function (a) {
            var b = a ? a.ownerDocument || a : C;
            a = b.defaultView;
            if (b === B || 9 !== b.nodeType || !b.documentElement)return B;
            B = b;
            H = b.documentElement;
            R = !ia(b);
            a && a !== a.top && (a.addEventListener ? a.addEventListener("unload", function () {
                ba()
            }, !1) : a.attachEvent && a.attachEvent("onunload", function () {
                ba()
            }));
            v.attributes = f(function (a) {
                a.className =
                    "i";
                return!a.getAttribute("className")
            });
            v.getElementsByTagName = f(function (a) {
                a.appendChild(b.createComment(""));
                return!a.getElementsByTagName("*").length
            });
            v.getElementsByClassName = va.test(b.getElementsByClassName) && f(function (a) {
                a.innerHTML = "<div class='a'></div><div class='a i'></div>";
                a.firstChild.className = "i";
                return 2 === a.getElementsByClassName("i").length
            });
            v.getById = f(function (a) {
                H.appendChild(a).id = E;
                return!b.getElementsByName || !b.getElementsByName(E).length
            });
            v.getById ? (r.find.ID = function (a, b) {
                if (typeof b.getElementById !== K && R) {
                    var c = b.getElementById(a);
                    return c && c.parentNode ? [c] : []
                }
            }, r.filter.ID = function (a) {
                var b = a.replace(fa, ga);
                return function (a) {
                    return a.getAttribute("id") === b
                }
            }) : (delete r.find.ID, r.filter.ID = function (a) {
                var b = a.replace(fa, ga);
                return function (a) {
                    return(a = typeof a.getAttributeNode !== K && a.getAttributeNode("id")) && a.value === b
                }
            });
            r.find.TAG = v.getElementsByTagName ? function (a, b) {
                if (typeof b.getElementsByTagName !== K)return b.getElementsByTagName(a)
            } : function (a, b) {
                var c,
                    d = [], e = 0, f = b.getElementsByTagName(a);
                if ("*" === a) {
                    for (; c = f[e++];)1 === c.nodeType && d.push(c);
                    return d
                }
                return f
            };
            r.find.CLASS = v.getElementsByClassName && function (a, b) {
                if (typeof b.getElementsByClassName !== K && R)return b.getElementsByClassName(a)
            };
            F = [];
            D = [];
            if (v.qsa = va.test(b.querySelectorAll))f(function (a) {
                a.innerHTML = "<select msallowclip=''><option selected=''></option></select>";
                a.querySelectorAll("[msallowclip^='']").length && D.push("[*^$]=[\\x20\\t\\r\\n\\f]*(?:''|\"\")");
                a.querySelectorAll("[selected]").length ||
                D.push("\\[[\\x20\\t\\r\\n\\f]*(?:value|checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|ismap|loop|multiple|open|readonly|required|scoped)");
                a.querySelectorAll(":checked").length || D.push(":checked")
            }), f(function (a) {
                var c = b.createElement("input");
                c.setAttribute("type", "hidden");
                a.appendChild(c).setAttribute("name", "D");
                a.querySelectorAll("[name=d]").length && D.push("name[\\x20\\t\\r\\n\\f]*[*^$|!~]?=");
                a.querySelectorAll(":enabled").length || D.push(":enabled", ":disabled");
                a.querySelectorAll("*,:x");
                D.push(",.*:")
            });
            (v.matchesSelector = va.test(ya = H.matches || H.webkitMatchesSelector || H.mozMatchesSelector || H.oMatchesSelector || H.msMatchesSelector)) && f(function (a) {
                v.disconnectedMatch = ya.call(a, "div");
                ya.call(a, "[s!='']:x");
                F.push("!=", U)
            });
            D = D.length && new RegExp(D.join("|"));
            F = F.length && new RegExp(F.join("|"));
            ta = (a = va.test(H.compareDocumentPosition)) || va.test(H.contains) ? function (a, b) {
                var c = 9 === a.nodeType ? a.documentElement : a, d = b && b.parentNode;
                return a === d || !!(d && 1 === d.nodeType && (c.contains ? c.contains(d) :
                    a.compareDocumentPosition && a.compareDocumentPosition(d) & 16))
            } : function (a, b) {
                if (b)for (; b = b.parentNode;)if (b === a)return!0;
                return!1
            };
            M = a ? function (a, c) {
                if (a === c)return ra = !0, 0;
                var d = !a.compareDocumentPosition - !c.compareDocumentPosition;
                if (d)return d;
                d = (a.ownerDocument || a) === (c.ownerDocument || c) ? a.compareDocumentPosition(c) : 1;
                return d & 1 || !v.sortDetached && c.compareDocumentPosition(a) === d ? a === b || a.ownerDocument === C && ta(C, a) ? -1 : c === b || c.ownerDocument === C && ta(C, c) ? 1 : da ? ha.call(da, a) - ha.call(da, c) : 0 : d & 4 ? -1 :
                    1
            } : function (a, c) {
                if (a === c)return ra = !0, 0;
                var d, e = 0;
                d = a.parentNode;
                var f = c.parentNode, g = [a], k = [c];
                if (!d || !f)return a === b ? -1 : c === b ? 1 : d ? -1 : f ? 1 : da ? ha.call(da, a) - ha.call(da, c) : 0;
                if (d === f)return h(a, c);
                for (d = a; d = d.parentNode;)g.unshift(d);
                for (d = c; d = d.parentNode;)k.unshift(d);
                for (; g[e] === k[e];)e++;
                return e ? h(g[e], k[e]) : g[e] === C ? -1 : k[e] === C ? 1 : 0
            };
            return b
        };
        b.matches = function (a, c) {
            return b(a, null, null, c)
        };
        b.matchesSelector = function (a, c) {
            (a.ownerDocument || a) !== B && ba(a);
            c = c.replace(la, "='$1']");
            if (!(!v.matchesSelector || !R || F && F.test(c) || D && D.test(c)))try {
                var d = ya.call(a, c);
                if (d || v.disconnectedMatch || a.document && 11 !== a.document.nodeType)return d
            } catch (e) {
            }
            return 0 < b(c, B, null, [a]).length
        };
        b.contains = function (a, b) {
            (a.ownerDocument || a) !== B && ba(a);
            return ta(a, b)
        };
        b.attr = function (a, b) {
            (a.ownerDocument || a) !== B && ba(a);
            var c = r.attrHandle[b.toLowerCase()], c = c && X.call(r.attrHandle, b.toLowerCase()) ? c(a, b, !R) : void 0;
            return void 0 !== c ? c : v.attributes || !R ? a.getAttribute(b) : (c = a.getAttributeNode(b)) && c.specified ? c.value : null
        };
        b.error =
            function (a) {
                throw Error("Syntax error, unrecognized expression: " + a);
            };
        b.uniqueSort = function (a) {
            var b, c = [], d = 0, e = 0;
            ra = !v.detectDuplicates;
            da = !v.sortStable && a.slice(0);
            a.sort(M);
            if (ra) {
                for (; b = a[e++];)b === a[e] && (d = c.push(e));
                for (; d--;)a.splice(c[d], 1)
            }
            da = null;
            return a
        };
        x = b.getText = function (a) {
            var b, c = "", d = 0;
            b = a.nodeType;
            if (!b)for (; b = a[d++];)c += x(b); else if (1 === b || 9 === b || 11 === b) {
                if ("string" === typeof a.textContent)return a.textContent;
                for (a = a.firstChild; a; a = a.nextSibling)c += x(a)
            } else if (3 === b || 4 === b)return a.nodeValue;
            return c
        };
        r = b.selectors = {cacheLength: 50, createPseudo: d, match: T, attrHandle: {}, find: {}, relative: {">": {dir: "parentNode", first: !0}, " ": {dir: "parentNode"}, "+": {dir: "previousSibling", first: !0}, "~": {dir: "previousSibling"}}, preFilter: {ATTR: function (a) {
            a[1] = a[1].replace(fa, ga);
            a[3] = (a[3] || a[4] || a[5] || "").replace(fa, ga);
            "~=" === a[2] && (a[3] = " " + a[3] + " ");
            return a.slice(0, 4)
        }, CHILD: function (a) {
            a[1] = a[1].toLowerCase();
            "nth" === a[1].slice(0, 3) ? (a[3] || b.error(a[0]), a[4] = +(a[4] ? a[5] + (a[6] || 1) : 2 * ("even" === a[3] || "odd" ===
                a[3])), a[5] = +(a[7] + a[8] || "odd" === a[3])) : a[3] && b.error(a[0]);
            return a
        }, PSEUDO: function (a) {
            var b, c = !a[6] && a[2];
            if (T.CHILD.test(a[0]))return null;
            a[3] ? a[2] = a[4] || a[5] || "" : c && ma.test(c) && (b = ua(c, !0)) && (b = c.indexOf(")", c.length - b) - c.length) && (a[0] = a[0].slice(0, b), a[2] = c.slice(0, b));
            return a.slice(0, 3)
        }}, filter: {TAG: function (a) {
            var b = a.replace(fa, ga).toLowerCase();
            return"*" === a ? function () {
                return!0
            } : function (a) {
                return a.nodeName && a.nodeName.toLowerCase() === b
            }
        }, CLASS: function (a) {
            var b = N[a + " "];
            return b ||
                (b = new RegExp("(^|[\\x20\\t\\r\\n\\f])" + a + "([\\x20\\t\\r\\n\\f]|$)")) && N(a, function (a) {
                return b.test("string" === typeof a.className && a.className || typeof a.getAttribute !== K && a.getAttribute("class") || "")
            })
        }, ATTR: function (a, c, d) {
            return function (e) {
                e = b.attr(e, a);
                if (null == e)return"!=" === c;
                if (!c)return!0;
                e += "";
                return"=" === c ? e === d : "!=" === c ? e !== d : "^=" === c ? d && 0 === e.indexOf(d) : "*=" === c ? d && -1 < e.indexOf(d) : "$=" === c ? d && e.slice(-d.length) === d : "~=" === c ? -1 < (" " + e + " ").indexOf(d) : "|=" === c ? e === d || e.slice(0, d.length +
                    1) === d + "-" : !1
            }
        }, CHILD: function (a, b, c, d, e) {
            var f = "nth" !== a.slice(0, 3), g = "last" !== a.slice(-4), h = "of-type" === b;
            return 1 === d && 0 === e ? function (a) {
                return!!a.parentNode
            } : function (b, c, k) {
                var l, m, p, q, t;
                c = f !== g ? "nextSibling" : "previousSibling";
                var n = b.parentNode, ob = h && b.nodeName.toLowerCase();
                k = !k && !h;
                if (n) {
                    if (f) {
                        for (; c;) {
                            for (m = b; m = m[c];)if (h ? m.nodeName.toLowerCase() === ob : 1 === m.nodeType)return!1;
                            t = c = "only" === a && !t && "nextSibling"
                        }
                        return!0
                    }
                    t = [g ? n.firstChild : n.lastChild];
                    if (g && k)for (k = n[E] || (n[E] = {}), l = k[a] || [],
                                        q = l[0] === I && l[1], p = l[0] === I && l[2], m = q && n.childNodes[q]; m = ++q && m && m[c] || (p = q = 0) || t.pop();) {
                        if (1 === m.nodeType && ++p && m === b) {
                            k[a] = [I, q, p];
                            break
                        }
                    } else if (k && (l = (b[E] || (b[E] = {}))[a]) && l[0] === I)p = l[1]; else for (; (m = ++q && m && m[c] || (p = q = 0) || t.pop()) && ((h ? m.nodeName.toLowerCase() !== ob : 1 !== m.nodeType) || !++p || (k && ((m[E] || (m[E] = {}))[a] = [I, p]), m !== b)););
                    p -= e;
                    return p === d || 0 === p % d && 0 <= p / d
                }
            }
        }, PSEUDO: function (a, c) {
            var f, g = r.pseudos[a] || r.setFilters[a.toLowerCase()] || b.error("unsupported pseudo: " + a);
            return g[E] ? g(c) :
                    1 < g.length ? (f = [a, a, "", c], r.setFilters.hasOwnProperty(a.toLowerCase()) ? d(function (a, b) {
                for (var d, e = g(a, c), f = e.length; f--;)d = ha.call(a, e[f]), a[d] = !(b[d] = e[f])
            }) : function (a) {
                return g(a, 0, f)
            }) : g
        }}, pseudos: {not: d(function (a) {
            var b = [], c = [], f = Na(a.replace(Q, "$1"));
            return f[E] ? d(function (a, b, c, d) {
                d = f(a, null, d, []);
                for (var e = a.length; e--;)if (c = d[e])a[e] = !(b[e] = c)
            }) : function (a, d, e) {
                b[0] = a;
                f(b, null, e, c);
                return!c.pop()
            }
        }), has: d(function (a) {
            return function (c) {
                return 0 < b(a, c).length
            }
        }), contains: d(function (a) {
            return function (b) {
                return-1 <
                    (b.textContent || b.innerText || x(b)).indexOf(a)
            }
        }), lang: d(function (a) {
            na.test(a || "") || b.error("unsupported lang: " + a);
            a = a.replace(fa, ga).toLowerCase();
            return function (b) {
                var c;
                do if (c = R ? b.lang : b.getAttribute("xml:lang") || b.getAttribute("lang"))return c = c.toLowerCase(), c === a || 0 === c.indexOf(a + "-"); while ((b = b.parentNode) && 1 === b.nodeType);
                return!1
            }
        }), target: function (b) {
            var c = a.location && a.location.hash;
            return c && c.slice(1) === b.id
        }, root: function (a) {
            return a === H
        }, focus: function (a) {
            return a === B.activeElement &&
                (!B.hasFocus || B.hasFocus()) && !!(a.type || a.href || ~a.tabIndex)
        }, enabled: function (a) {
            return!1 === a.disabled
        }, disabled: function (a) {
            return!0 === a.disabled
        }, checked: function (a) {
            var b = a.nodeName.toLowerCase();
            return"input" === b && !!a.checked || "option" === b && !!a.selected
        }, selected: function (a) {
            a.parentNode && a.parentNode.selectedIndex;
            return!0 === a.selected
        }, empty: function (a) {
            for (a = a.firstChild; a; a = a.nextSibling)if (6 > a.nodeType)return!1;
            return!0
        }, parent: function (a) {
            return!r.pseudos.empty(a)
        }, header: function (a) {
            return pa.test(a.nodeName)
        },
            input: function (a) {
                return oa.test(a.nodeName)
            }, button: function (a) {
                var b = a.nodeName.toLowerCase();
                return"input" === b && "button" === a.type || "button" === b
            }, text: function (a) {
                var b;
                return"input" === a.nodeName.toLowerCase() && "text" === a.type && (null == (b = a.getAttribute("type")) || "text" === b.toLowerCase())
            }, first: p(function () {
                return[0]
            }), last: p(function (a, b) {
                return[b - 1]
            }), eq: p(function (a, b, c) {
                return[0 > c ? c + b : c]
            }), even: p(function (a, b) {
                for (var c = 0; c < b; c += 2)a.push(c);
                return a
            }), odd: p(function (a, b) {
                for (var c = 1; c < b; c +=
                    2)a.push(c);
                return a
            }), lt: p(function (a, b, c) {
                for (b = 0 > c ? c + b : c; 0 <= --b;)a.push(b);
                return a
            }), gt: p(function (a, b, c) {
                for (c = 0 > c ? c + b : c; ++c < b;)a.push(c);
                return a
            })}};
        r.pseudos.nth = r.pseudos.eq;
        for (J in{radio: !0, checkbox: !0, file: !0, password: !0, image: !0})r.pseudos[J] = k(J);
        for (J in{submit: !0, reset: !0})r.pseudos[J] = l(J);
        m.prototype = r.filters = r.pseudos;
        r.setFilters = new m;
        ua = b.tokenize = function (a, c) {
            var d, e, f, g, h, k, l;
            if (h = O[a + " "])return c ? 0 : h.slice(0);
            h = a;
            k = [];
            for (l = r.preFilter; h;) {
                if (!d || (e = ja.exec(h)))e && (h = h.slice(e[0].length) ||
                    h), k.push(f = []);
                d = !1;
                if (e = ka.exec(h))d = e.shift(), f.push({value: d, type: e[0].replace(Q, " ")}), h = h.slice(d.length);
                for (g in r.filter)!(e = T[g].exec(h)) || l[g] && !(e = l[g](e)) || (d = e.shift(), f.push({value: d, type: g, matches: e}), h = h.slice(d.length));
                if (!d)break
            }
            return c ? h.length : h ? b.error(a) : O(a, k).slice(0)
        };
        Na = b.compile = function (a, b) {
            var c, d = [], e = [], f = P[a + " "];
            if (!f) {
                b || (b = ua(a));
                for (c = b.length; c--;)f = w(b[c]), f[E] ? d.push(f) : e.push(f);
                f = P(a, G(e, d));
                f.selector = a
            }
            return f
        };
        A = b.select = function (a, b, c, d) {
            var e, f,
                g, h, k = "function" === typeof a && a, l = !d && ua(a = k.selector || a);
            c = c || [];
            if (1 === l.length) {
                f = l[0] = l[0].slice(0);
                if (2 < f.length && "ID" === (g = f[0]).type && v.getById && 9 === b.nodeType && R && r.relative[f[1].type]) {
                    b = (r.find.ID(g.matches[0].replace(fa, ga), b) || [])[0];
                    if (!b)return c;
                    k && (b = b.parentNode);
                    a = a.slice(f.shift().value.length)
                }
                for (e = T.needsContext.test(a) ? 0 : f.length; e--;) {
                    g = f[e];
                    if (r.relative[h = g.type])break;
                    if (h = r.find[h])if (d = h(g.matches[0].replace(fa, ga), aa.test(f[0].type) && q(b.parentNode) || b)) {
                        f.splice(e, 1);
                        a = d.length && t(f);
                        if (!a)return ca.apply(c, d), c;
                        break
                    }
                }
            }
            (k || Na(a, l))(d, b, !R, c, aa.test(a) && q(b.parentNode) || b);
            return c
        };
        v.sortStable = E.split("").sort(M).join("") === E;
        v.detectDuplicates = !!ra;
        ba();
        v.sortDetached = f(function (a) {
            return a.compareDocumentPosition(B.createElement("div")) & 1
        });
        f(function (a) {
            a.innerHTML = "<a href='#'></a>";
            return"#" === a.firstChild.getAttribute("href")
        }) || g("type|href|height|width", function (a, b, c) {
            if (!c)return a.getAttribute(b, "type" === b.toLowerCase() ? 1 : 2)
        });
        v.attributes && f(function (a) {
            a.innerHTML =
                "<input/>";
            a.firstChild.setAttribute("value", "");
            return"" === a.firstChild.getAttribute("value")
        }) || g("value", function (a, b, c) {
            if (!c && "input" === a.nodeName.toLowerCase())return a.defaultValue
        });
        f(function (a) {
            return null == a.getAttribute("disabled")
        }) || g("checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|ismap|loop|multiple|open|readonly|required|scoped", function (a, b, c) {
            var d;
            if (!c)return!0 === a[b] ? b.toLowerCase() : (d = a.getAttributeNode(b)) && d.specified ? d.value : null
        });
        return b
    }(u);
    d.find = V;
    d.expr = V.selectors;
    d.expr[":"] = d.expr.pseudos;
    d.unique = V.uniqueSort;
    d.text = V.getText;
    d.isXMLDoc = V.isXML;
    d.contains = V.contains;
    var qb = d.expr.match.needsContext, rb = /^<(\w+)\s*\/?>(?:<\/\1>|)$/, Jb = /^.[^:#\[\.,]*$/;
    d.filter = function (a, b, c) {
        var e = b[0];
        c && (a = ":not(" + a + ")");
        return 1 === b.length && 1 === e.nodeType ? d.find.matchesSelector(e, a) ? [e] : [] : d.find.matches(a, d.grep(b, function (a) {
            return 1 === a.nodeType
        }))
    };
    d.fn.extend({find: function (a) {
        var b, c = this.length, e = [], f = this;
        if ("string" !== typeof a)return this.pushStack(d(a).filter(function () {
            for (b =
                     0; b < c; b++)if (d.contains(f[b], this))return!0
        }));
        for (b = 0; b < c; b++)d.find(a, f[b], e);
        e = this.pushStack(1 < c ? d.unique(e) : e);
        e.selector = this.selector ? this.selector + " " + a : a;
        return e
    }, filter: function (a) {
        return this.pushStack(Da(this, a || [], !1))
    }, not: function (a) {
        return this.pushStack(Da(this, a || [], !0))
    }, is: function (a) {
        return!!Da(this, "string" === typeof a && qb.test(a) ? d(a) : a || [], !1).length
    }});
    var sa, Yb = /^(?:\s*(<[\w\W]+>)[^>]*|#([\w-]*))$/;
    (d.fn.init = function (a, b) {
        var c;
        if (!a)return this;
        if ("string" === typeof a) {
            c =
                    "<" === a[0] && ">" === a[a.length - 1] && 3 <= a.length ? [null, a, null] : Yb.exec(a);
            if (!c || !c[1] && b)return!b || b.jquery ? (b || sa).find(a) : this.constructor(b).find(a);
            if (c[1]) {
                if (b = b instanceof d ? b[0] : b, d.merge(this, d.parseHTML(c[1], b && b.nodeType ? b.ownerDocument || b : s, !0)), rb.test(c[1]) && d.isPlainObject(b))for (c in b)if (d.isFunction(this[c]))this[c](b[c]); else this.attr(c, b[c])
            } else(c = s.getElementById(c[2])) && c.parentNode && (this.length = 1, this[0] = c), this.context = s, this.selector = a;
            return this
        }
        if (a.nodeType)return this.context =
            this[0] = a, this.length = 1, this;
        if (d.isFunction(a))return"undefined" !== typeof sa.ready ? sa.ready(a) : a(d);
        void 0 !== a.selector && (this.selector = a.selector, this.context = a.context);
        return d.makeArray(a, this)
    }).prototype = d.fn;
    sa = d(s);
    var Zb = /^(?:parents|prev(?:Until|All))/, $b = {children: !0, contents: !0, next: !0, prev: !0};
    d.extend({dir: function (a, b, c) {
        for (var e = [], f = void 0 !== c; (a = a[b]) && 9 !== a.nodeType;)if (1 === a.nodeType) {
            if (f && d(a).is(c))break;
            e.push(a)
        }
        return e
    }, sibling: function (a, b) {
        for (var c = []; a; a = a.nextSibling)1 ===
        a.nodeType && a !== b && c.push(a);
        return c
    }});
    d.fn.extend({has: function (a) {
        var b = d(a, this), c = b.length;
        return this.filter(function () {
            for (var a = 0; a < c; a++)if (d.contains(this, b[a]))return!0
        })
    }, closest: function (a, b) {
        for (var c, e = 0, f = this.length, g = [], h = qb.test(a) || "string" !== typeof a ? d(a, b || this.context) : 0; e < f; e++)for (c = this[e]; c && c !== b; c = c.parentNode)if (11 > c.nodeType && (h ? -1 < h.index(c) : 1 === c.nodeType && d.find.matchesSelector(c, a))) {
            g.push(c);
            break
        }
        return this.pushStack(1 < g.length ? d.unique(g) : g)
    }, index: function (a) {
        return a ?
                "string" === typeof a ? la.call(d(a), this[0]) : la.call(this, a.jquery ? a[0] : a) : this[0] && this[0].parentNode ? this.first().prevAll().length : -1
    }, add: function (a, b) {
        return this.pushStack(d.unique(d.merge(this.get(), d(a, b))))
    }, addBack: function (a) {
        return this.add(null == a ? this.prevObject : this.prevObject.filter(a))
    }});
    d.each({parent: function (a) {
        return(a = a.parentNode) && 11 !== a.nodeType ? a : null
    }, parents: function (a) {
        return d.dir(a, "parentNode")
    }, parentsUntil: function (a, b, c) {
        return d.dir(a, "parentNode", c)
    }, next: function (a) {
        return Sa(a,
            "nextSibling")
    }, prev: function (a) {
        return Sa(a, "previousSibling")
    }, nextAll: function (a) {
        return d.dir(a, "nextSibling")
    }, prevAll: function (a) {
        return d.dir(a, "previousSibling")
    }, nextUntil: function (a, b, c) {
        return d.dir(a, "nextSibling", c)
    }, prevUntil: function (a, b, c) {
        return d.dir(a, "previousSibling", c)
    }, siblings: function (a) {
        return d.sibling((a.parentNode || {}).firstChild, a)
    }, children: function (a) {
        return d.sibling(a.firstChild)
    }, contents: function (a) {
        return a.contentDocument || d.merge([], a.childNodes)
    }}, function (a, b) {
        d.fn[a] = function (c, e) {
            var f = d.map(this, b, c);
            "Until" !== a.slice(-5) && (e = c);
            e && "string" === typeof e && (f = d.filter(e, f));
            1 < this.length && ($b[a] || d.unique(f), Zb.test(a) && f.reverse());
            return this.pushStack(f)
        }
    });
    var L = /\S+/g, Ta = {};
    d.Callbacks = function (a) {
        a = "string" === typeof a ? Ta[a] || Kb(a) : d.extend({}, a);
        var b, c, e, f, g, h, k = [], l = !a.once && [], p = function (d) {
            b = a.memory && d;
            c = !0;
            h = f || 0;
            f = 0;
            g = k.length;
            for (e = !0; k && h < g; h++)if (!1 === k[h].apply(d[0], d[1]) && a.stopOnFalse) {
                b = !1;
                break
            }
            e = !1;
            k && (l ? l.length && p(l.shift()) : b ?
                k = [] : q.disable())
        }, q = {add: function () {
            if (k) {
                var c = k.length;
                (function y(b) {
                    d.each(b, function (b, c) {
                        var e = d.type(c);
                        "function" === e ? a.unique && q.has(c) || k.push(c) : c && c.length && "string" !== e && y(c)
                    })
                })(arguments);
                e ? g = k.length : b && (f = c, p(b))
            }
            return this
        }, remove: function () {
            k && d.each(arguments, function (a, b) {
                for (var c; -1 < (c = d.inArray(b, k, c));)k.splice(c, 1), e && (c <= g && g--, c <= h && h--)
            });
            return this
        }, has: function (a) {
            return a ? -1 < d.inArray(a, k) : !(!k || !k.length)
        }, empty: function () {
            k = [];
            g = 0;
            return this
        }, disable: function () {
            k =
                l = b = void 0;
            return this
        }, disabled: function () {
            return!k
        }, lock: function () {
            l = void 0;
            b || q.disable();
            return this
        }, locked: function () {
            return!l
        }, fireWith: function (a, b) {
            !k || c && !l || (b = b || [], b = [a, b.slice ? b.slice() : b], e ? l.push(b) : p(b));
            return this
        }, fire: function () {
            q.fireWith(this, arguments);
            return this
        }, fired: function () {
            return!!c
        }};
        return q
    };
    d.extend({Deferred: function (a) {
        var b = [
            ["resolve", "done", d.Callbacks("once memory"), "resolved"],
            ["reject", "fail", d.Callbacks("once memory"), "rejected"],
            ["notify", "progress",
                d.Callbacks("memory")]
        ], c = "pending", e = {state: function () {
            return c
        }, always: function () {
            f.done(arguments).fail(arguments);
            return this
        }, then: function () {
            var a = arguments;
            return d.Deferred(function (c) {
                d.each(b, function (b, l) {
                    var p = d.isFunction(a[b]) && a[b];
                    f[l[1]](function () {
                        var a = p && p.apply(this, arguments);
                        if (a && d.isFunction(a.promise))a.promise().done(c.resolve).fail(c.reject).progress(c.notify); else c[l[0] + "With"](this === e ? c.promise() : this, p ? [a] : arguments)
                    })
                });
                a = null
            }).promise()
        }, promise: function (a) {
            return null !=
                a ? d.extend(a, e) : e
        }}, f = {};
        e.pipe = e.then;
        d.each(b, function (a, d) {
            var k = d[2], l = d[3];
            e[d[1]] = k.add;
            l && k.add(function () {
                c = l
            }, b[a ^ 1][2].disable, b[2][2].lock);
            f[d[0]] = function () {
                f[d[0] + "With"](this === f ? e : this, arguments);
                return this
            };
            f[d[0] + "With"] = k.fireWith
        });
        e.promise(f);
        a && a.call(f, f);
        return f
    }, when: function (a) {
        var b = 0, c = N.call(arguments), e = c.length, f = 1 !== e || a && d.isFunction(a.promise) ? e : 0, g = 1 === f ? a : d.Deferred(), h = function (a, b, c) {
            return function (d) {
                b[a] = this;
                c[a] = 1 < arguments.length ? N.call(arguments) : d;
                c === k ? g.notifyWith(b, c) : --f || g.resolveWith(b, c)
            }
        }, k, l, p;
        if (1 < e)for (k = Array(e), l = Array(e), p = Array(e); b < e; b++)c[b] && d.isFunction(c[b].promise) ? c[b].promise().done(h(b, p, c)).fail(g.reject).progress(h(b, l, k)) : --f;
        f || g.resolveWith(p, c);
        return g.promise()
    }});
    var wa;
    d.fn.ready = function (a) {
        d.ready.promise().done(a);
        return this
    };
    d.extend({isReady: !1, readyWait: 1, holdReady: function (a) {
        a ? d.readyWait++ : d.ready(!0)
    }, ready: function (a) {
        (!0 === a ? --d.readyWait : d.isReady) || (d.isReady = !0, !0 !== a && 0 < --d.readyWait || (wa.resolveWith(s,
            [d]), d.fn.triggerHandler && (d(s).triggerHandler("ready"), d(s).off("ready"))))
    }});
    d.ready.promise = function (a) {
        wa || (wa = d.Deferred(), "complete" === s.readyState ? setTimeout(d.ready) : (s.addEventListener("DOMContentLoaded", ma, !1), u.addEventListener("load", ma, !1)));
        return wa.promise(a)
    };
    d.ready.promise();
    var O = d.access = function (a, b, c, e, f, g, h) {
        var k = 0, l = a.length, p = null == c;
        if ("object" === d.type(c))for (k in f = !0, c)d.access(a, b, k, c[k], !0, g, h); else if (void 0 !== e && (f = !0, d.isFunction(e) || (h = !0), p && (h ? (b.call(a, e),
            b = null) : (p = b, b = function (a, b, c) {
            return p.call(d(a), c)
        })), b))for (; k < l; k++)b(a[k], c, h ? e : e.call(a[k], k, b(a[k], c)));
        return f ? a : p ? b.call(a) : l ? b(a[0], c) : g
    };
    d.acceptData = function (a) {
        return 1 === a.nodeType || 9 === a.nodeType || !+a.nodeType
    };
    M.uid = 1;
    M.accepts = d.acceptData;
    M.prototype = {key: function (a) {
        if (!M.accepts(a))return 0;
        var b = {}, c = a[this.expando];
        if (!c) {
            c = M.uid++;
            try {
                b[this.expando] = {value: c}, Object.defineProperties(a, b)
            } catch (e) {
                b[this.expando] = c, d.extend(a, b)
            }
        }
        this.cache[c] || (this.cache[c] = {});
        return c
    },
        set: function (a, b, c) {
            var e;
            a = this.key(a);
            var f = this.cache[a];
            if ("string" === typeof b)f[b] = c; else if (d.isEmptyObject(f))d.extend(this.cache[a], b); else for (e in b)f[e] = b[e];
            return f
        }, get: function (a, b) {
            var c = this.cache[this.key(a)];
            return void 0 === b ? c : c[b]
        }, access: function (a, b, c) {
            if (void 0 === b || b && "string" === typeof b && void 0 === c)return c = this.get(a, b), void 0 !== c ? c : this.get(a, d.camelCase(b));
            this.set(a, b, c);
            return void 0 !== c ? c : b
        }, remove: function (a, b) {
            var c, e;
            c = this.key(a);
            var f = this.cache[c];
            if (void 0 ===
                b)this.cache[c] = {}; else for (d.isArray(b) ? e = b.concat(b.map(d.camelCase)) : (c = d.camelCase(b), b in f ? e = [b, c] : (e = c, e = e in f ? [e] : e.match(L) || [])), c = e.length; c--;)delete f[e[c]]
        }, hasData: function (a) {
            return!d.isEmptyObject(this.cache[a[this.expando]] || {})
        }, discard: function (a) {
            a[this.expando] && delete this.cache[a[this.expando]]
        }};
    var n = new M, G = new M, Mb = /^(?:\{[\w\W]*\}|\[[\w\W]*\])$/, Lb = /([A-Z])/g;
    d.extend({hasData: function (a) {
        return G.hasData(a) || n.hasData(a)
    }, data: function (a, b, c) {
        return G.access(a, b, c)
    },
        removeData: function (a, b) {
            G.remove(a, b)
        }, _data: function (a, b, c) {
            return n.access(a, b, c)
        }, _removeData: function (a, b) {
            n.remove(a, b)
        }});
    d.fn.extend({data: function (a, b) {
        var c, e, f, g = this[0], h = g && g.attributes;
        if (void 0 === a) {
            if (this.length && (f = G.get(g), 1 === g.nodeType && !n.get(g, "hasDataAttrs"))) {
                for (c = h.length; c--;)h[c] && (e = h[c].name, 0 === e.indexOf("data-") && (e = d.camelCase(e.slice(5)), Ua(g, e, f[e])));
                n.set(g, "hasDataAttrs", !0)
            }
            return f
        }
        return"object" === typeof a ? this.each(function () {
            G.set(this, a)
        }) : O(this, function (b) {
            var c,
                e = d.camelCase(a);
            if (g && void 0 === b) {
                c = G.get(g, a);
                if (void 0 !== c)return c;
                c = G.get(g, e);
                if (void 0 !== c)return c;
                c = Ua(g, e, void 0);
                if (void 0 !== c)return c
            } else this.each(function () {
                var c = G.get(this, e);
                G.set(this, e, b);
                -1 !== a.indexOf("-") && void 0 !== c && G.set(this, a, b)
            })
        }, null, b, 1 < arguments.length, null, !0)
    }, removeData: function (a) {
        return this.each(function () {
            G.remove(this, a)
        })
    }});
    d.extend({queue: function (a, b, c) {
        var e;
        if (a)return b = (b || "fx") + "queue", e = n.get(a, b), c && (!e || d.isArray(c) ? e = n.access(a, b, d.makeArray(c)) :
            e.push(c)), e || []
    }, dequeue: function (a, b) {
        b = b || "fx";
        var c = d.queue(a, b), e = c.length, f = c.shift(), g = d._queueHooks(a, b), h = function () {
            d.dequeue(a, b)
        };
        "inprogress" === f && (f = c.shift(), e--);
        f && ("fx" === b && c.unshift("inprogress"), delete g.stop, f.call(a, h, g));
        !e && g && g.empty.fire()
    }, _queueHooks: function (a, b) {
        var c = b + "queueHooks";
        return n.get(a, c) || n.access(a, c, {empty: d.Callbacks("once memory").add(function () {
            n.remove(a, [b + "queue", c])
        })})
    }});
    d.fn.extend({queue: function (a, b) {
        var c = 2;
        "string" !== typeof a && (b = a, a = "fx",
            c--);
        return arguments.length < c ? d.queue(this[0], a) : void 0 === b ? this : this.each(function () {
            var c = d.queue(this, a, b);
            d._queueHooks(this, a);
            "fx" === a && "inprogress" !== c[0] && d.dequeue(this, a)
        })
    }, dequeue: function (a) {
        return this.each(function () {
            d.dequeue(this, a)
        })
    }, clearQueue: function (a) {
        return this.queue(a || "fx", [])
    }, promise: function (a, b) {
        var c, e = 1, f = d.Deferred(), g = this, h = this.length, k = function () {
            --e || f.resolveWith(g, [g])
        };
        "string" !== typeof a && (b = a, a = void 0);
        for (a = a || "fx"; h--;)(c = n.get(g[h], a + "queueHooks")) &&
        c.empty && (e++, c.empty.add(k));
        k();
        return f.promise(b)
    }});
    var za = /[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/.source, K = ["Top", "Right", "Bottom", "Left"], U = function (a, b) {
        a = b || a;
        return"none" === d.css(a, "display") || !d.contains(a.ownerDocument, a)
    }, sb = /^(?:checkbox|radio)$/i;
    (function () {
        var a = s.createDocumentFragment().appendChild(s.createElement("div")), b = s.createElement("input");
        b.setAttribute("type", "radio");
        b.setAttribute("checked", "checked");
        b.setAttribute("name", "t");
        a.appendChild(b);
        w.checkClone = a.cloneNode(!0).cloneNode(!0).lastChild.checked;
        a.innerHTML = "<textarea>x</textarea>";
        w.noCloneChecked = !!a.cloneNode(!0).lastChild.defaultValue
    })();
    w.focusinBubbles = "onfocusin"in u;
    var ac = /^key/, bc = /^(?:mouse|pointer|contextmenu)|click/, tb = /^(?:focusinfocus|focusoutblur)$/, ub = /^([^.]*)(?:\.(.+)|)$/;
    d.event = {global: {}, add: function (a, b, c, e, f) {
        var g, h, k, l, p, q, m, t, y;
        if (p = n.get(a))for (c.handler && (g = c, c = g.handler, f = g.selector), c.guid || (c.guid = d.guid++), (l = p.events) || (l = p.events = {}), (h = p.handle) || (h = p.handle = function (b) {
            return"undefined" !== typeof d && d.event.triggered !==
                b.type ? d.event.dispatch.apply(a, arguments) : void 0
        }), b = (b || "").match(L) || [""], p = b.length; p--;)k = ub.exec(b[p]) || [], t = q = k[1], y = (k[2] || "").split(".").sort(), t && (k = d.event.special[t] || {}, t = (f ? k.delegateType : k.bindType) || t, k = d.event.special[t] || {}, q = d.extend({type: t, origType: q, data: e, handler: c, guid: c.guid, selector: f, needsContext: f && d.expr.match.needsContext.test(f), namespace: y.join(".")}, g), (m = l[t]) || (m = l[t] = [], m.delegateCount = 0, k.setup && !1 !== k.setup.call(a, e, y, h) || a.addEventListener && a.addEventListener(t,
            h, !1)), k.add && (k.add.call(a, q), q.handler.guid || (q.handler.guid = c.guid)), f ? m.splice(m.delegateCount++, 0, q) : m.push(q), d.event.global[t] = !0)
    }, remove: function (a, b, c, e, f) {
        var g, h, k, l, p, q, m, t, y, s, u, w = n.hasData(a) && n.get(a);
        if (w && (l = w.events)) {
            b = (b || "").match(L) || [""];
            for (p = b.length; p--;)if (k = ub.exec(b[p]) || [], y = u = k[1], s = (k[2] || "").split(".").sort(), y) {
                m = d.event.special[y] || {};
                y = (e ? m.delegateType : m.bindType) || y;
                t = l[y] || [];
                k = k[2] && new RegExp("(^|\\.)" + s.join("\\.(?:.*\\.|)") + "(\\.|$)");
                for (h = g = t.length; g--;)q =
                    t[g], !f && u !== q.origType || c && c.guid !== q.guid || k && !k.test(q.namespace) || e && e !== q.selector && ("**" !== e || !q.selector) || (t.splice(g, 1), q.selector && t.delegateCount--, m.remove && m.remove.call(a, q));
                h && !t.length && (m.teardown && !1 !== m.teardown.call(a, s, w.handle) || d.removeEvent(a, y, w.handle), delete l[y])
            } else for (y in l)d.event.remove(a, y + b[p], c, e, !0);
            d.isEmptyObject(l) && (delete w.handle, n.remove(a, "events"))
        }
    }, trigger: function (a, b, c, e) {
        var f, g, h, k, l, p, q = [c || s], m = La.call(a, "type") ? a.type : a;
        p = La.call(a, "namespace") ?
            a.namespace.split(".") : [];
        g = f = c = c || s;
        if (3 !== c.nodeType && 8 !== c.nodeType && !tb.test(m + d.event.triggered) && (0 <= m.indexOf(".") && (p = m.split("."), m = p.shift(), p.sort()), k = 0 > m.indexOf(":") && "on" + m, a = a[d.expando] ? a : new d.Event(m, "object" === typeof a && a), a.isTrigger = e ? 2 : 3, a.namespace = p.join("."), a.namespace_re = a.namespace ? new RegExp("(^|\\.)" + p.join("\\.(?:.*\\.|)") + "(\\.|$)") : null, a.result = void 0, a.target || (a.target = c), b = null == b ? [a] : d.makeArray(b, [a]), p = d.event.special[m] || {}, e || !p.trigger || !1 !== p.trigger.apply(c,
            b))) {
            if (!e && !p.noBubble && !d.isWindow(c)) {
                h = p.delegateType || m;
                tb.test(h + m) || (g = g.parentNode);
                for (; g; g = g.parentNode)q.push(g), f = g;
                f === (c.ownerDocument || s) && q.push(f.defaultView || f.parentWindow || u)
            }
            for (f = 0; (g = q[f++]) && !a.isPropagationStopped();)a.type = 1 < f ? h : p.bindType || m, (l = (n.get(g, "events") || {})[a.type] && n.get(g, "handle")) && l.apply(g, b), (l = k && g[k]) && l.apply && d.acceptData(g) && (a.result = l.apply(g, b), !1 === a.result && a.preventDefault());
            a.type = m;
            e || a.isDefaultPrevented() || p._default && !1 !== p._default.apply(q.pop(),
                b) || !d.acceptData(c) || !k || !d.isFunction(c[m]) || d.isWindow(c) || ((f = c[k]) && (c[k] = null), d.event.triggered = m, c[m](), d.event.triggered = void 0, f && (c[k] = f));
            return a.result
        }
    }, dispatch: function (a) {
        a = d.event.fix(a);
        var b, c, e, f, g = [], h = N.call(arguments);
        b = (n.get(this, "events") || {})[a.type] || [];
        var k = d.event.special[a.type] || {};
        h[0] = a;
        a.delegateTarget = this;
        if (!k.preDispatch || !1 !== k.preDispatch.call(this, a)) {
            g = d.event.handlers.call(this, a, b);
            for (b = 0; (f = g[b++]) && !a.isPropagationStopped();)for (a.currentTarget = f.elem,
                                                                            c = 0; (e = f.handlers[c++]) && !a.isImmediatePropagationStopped();)if (!a.namespace_re || a.namespace_re.test(e.namespace))a.handleObj = e, a.data = e.data, e = ((d.event.special[e.origType] || {}).handle || e.handler).apply(f.elem, h), void 0 !== e && !1 === (a.result = e) && (a.preventDefault(), a.stopPropagation());
            k.postDispatch && k.postDispatch.call(this, a);
            return a.result
        }
    }, handlers: function (a, b) {
        var c, e, f, g, h = [], k = b.delegateCount, l = a.target;
        if (k && l.nodeType && (!a.button || "click" !== a.type))for (; l !== this; l = l.parentNode || this)if (!0 !==
            l.disabled || "click" !== a.type) {
            e = [];
            for (c = 0; c < k; c++)g = b[c], f = g.selector + " ", void 0 === e[f] && (e[f] = g.needsContext ? 0 <= d(f, this).index(l) : d.find(f, this, null, [l]).length), e[f] && e.push(g);
            e.length && h.push({elem: l, handlers: e})
        }
        k < b.length && h.push({elem: this, handlers: b.slice(k)});
        return h
    }, props: "altKey bubbles cancelable ctrlKey currentTarget eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "), fixHooks: {}, keyHooks: {props: ["char", "charCode", "key", "keyCode"], filter: function (a, b) {
        null ==
        a.which && (a.which = null != b.charCode ? b.charCode : b.keyCode);
        return a
    }}, mouseHooks: {props: "button buttons clientX clientY offsetX offsetY pageX pageY screenX screenY toElement".split(" "), filter: function (a, b) {
        var c, d, f = b.button;
        null == a.pageX && null != b.clientX && (c = a.target.ownerDocument || s, d = c.documentElement, c = c.body, a.pageX = b.clientX + (d && d.scrollLeft || c && c.scrollLeft || 0) - (d && d.clientLeft || c && c.clientLeft || 0), a.pageY = b.clientY + (d && d.scrollTop || c && c.scrollTop || 0) - (d && d.clientTop || c && c.clientTop || 0));
        a.which ||
            void 0 === f || (a.which = f & 1 ? 1 : f & 2 ? 3 : f & 4 ? 2 : 0);
        return a
    }}, fix: function (a) {
        if (a[d.expando])return a;
        var b, c, e;
        b = a.type;
        var f = a, g = this.fixHooks[b];
        g || (this.fixHooks[b] = g = bc.test(b) ? this.mouseHooks : ac.test(b) ? this.keyHooks : {});
        e = g.props ? this.props.concat(g.props) : this.props;
        a = new d.Event(f);
        for (b = e.length; b--;)c = e[b], a[c] = f[c];
        a.target || (a.target = s);
        3 === a.target.nodeType && (a.target = a.target.parentNode);
        return g.filter ? g.filter(a, f) : a
    }, special: {load: {noBubble: !0}, focus: {trigger: function () {
        if (this !== Va() &&
            this.focus)return this.focus(), !1
    }, delegateType: "focusin"}, blur: {trigger: function () {
        if (this === Va() && this.blur)return this.blur(), !1
    }, delegateType: "focusout"}, click: {trigger: function () {
        if ("checkbox" === this.type && this.click && d.nodeName(this, "input"))return this.click(), !1
    }, _default: function (a) {
        return d.nodeName(a.target, "a")
    }}, beforeunload: {postDispatch: function (a) {
        void 0 !== a.result && a.originalEvent && (a.originalEvent.returnValue = a.result)
    }}}, simulate: function (a, b, c, e) {
        a = d.extend(new d.Event, c, {type: a,
            isSimulated: !0, originalEvent: {}});
        e ? d.event.trigger(a, null, b) : d.event.dispatch.call(b, a);
        a.isDefaultPrevented() && c.preventDefault()
    }};
    d.removeEvent = function (a, b, c) {
        a.removeEventListener && a.removeEventListener(b, c, !1)
    };
    d.Event = function (a, b) {
        if (!(this instanceof d.Event))return new d.Event(a, b);
        a && a.type ? (this.originalEvent = a, this.type = a.type, this.isDefaultPrevented = a.defaultPrevented || void 0 === a.defaultPrevented && !1 === a.returnValue ? na : X) : this.type = a;
        b && d.extend(this, b);
        this.timeStamp = a && a.timeStamp ||
            d.now();
        this[d.expando] = !0
    };
    d.Event.prototype = {isDefaultPrevented: X, isPropagationStopped: X, isImmediatePropagationStopped: X, preventDefault: function () {
        var a = this.originalEvent;
        this.isDefaultPrevented = na;
        a && a.preventDefault && a.preventDefault()
    }, stopPropagation: function () {
        var a = this.originalEvent;
        this.isPropagationStopped = na;
        a && a.stopPropagation && a.stopPropagation()
    }, stopImmediatePropagation: function () {
        var a = this.originalEvent;
        this.isImmediatePropagationStopped = na;
        a && a.stopImmediatePropagation && a.stopImmediatePropagation();
        this.stopPropagation()
    }};
    d.each({mouseenter: "mouseover", mouseleave: "mouseout", pointerenter: "pointerover", pointerleave: "pointerout"}, function (a, b) {
        d.event.special[a] = {delegateType: b, bindType: b, handle: function (a) {
            var e, f = a.relatedTarget, g = a.handleObj;
            if (!f || f !== this && !d.contains(this, f))a.type = g.origType, e = g.handler.apply(this, arguments), a.type = b;
            return e
        }}
    });
    w.focusinBubbles || d.each({focus: "focusin", blur: "focusout"}, function (a, b) {
        var c = function (a) {
            d.event.simulate(b, a.target, d.event.fix(a), !0)
        };
        d.event.special[b] =
        {setup: function () {
            var d = this.ownerDocument || this, f = n.access(d, b);
            f || d.addEventListener(a, c, !0);
            n.access(d, b, (f || 0) + 1)
        }, teardown: function () {
            var d = this.ownerDocument || this, f = n.access(d, b) - 1;
            f ? n.access(d, b, f) : (d.removeEventListener(a, c, !0), n.remove(d, b))
        }}
    });
    d.fn.extend({on: function (a, b, c, e, f) {
        var g, h;
        if ("object" === typeof a) {
            "string" !== typeof b && (c = c || b, b = void 0);
            for (h in a)this.on(h, b, c, a[h], f);
            return this
        }
        null == c && null == e ? (e = b, c = b = void 0) : null == e && ("string" === typeof b ? (e = c, c = void 0) : (e = c, c = b, b = void 0));
        if (!1 === e)e = X; else if (!e)return this;
        1 === f && (g = e, e = function (a) {
            d().off(a);
            return g.apply(this, arguments)
        }, e.guid = g.guid || (g.guid = d.guid++));
        return this.each(function () {
            d.event.add(this, a, e, c, b)
        })
    }, one: function (a, b, c, d) {
        return this.on(a, b, c, d, 1)
    }, off: function (a, b, c) {
        var e;
        if (a && a.preventDefault && a.handleObj)return e = a.handleObj, d(a.delegateTarget).off(e.namespace ? e.origType + "." + e.namespace : e.origType, e.selector, e.handler), this;
        if ("object" === typeof a) {
            for (e in a)this.off(e, b, a[e]);
            return this
        }
        if (!1 ===
            b || "function" === typeof b)c = b, b = void 0;
        !1 === c && (c = X);
        return this.each(function () {
            d.event.remove(this, a, c, b)
        })
    }, trigger: function (a, b) {
        return this.each(function () {
            d.event.trigger(a, b, this)
        })
    }, triggerHandler: function (a, b) {
        var c = this[0];
        if (c)return d.event.trigger(a, b, c, !0)
    }});
    var vb = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi, wb = /<([\w:]+)/, cc = /<|&#?\w+;/, dc = /<(?:script|style|link)/i, ec = /checked\s*(?:[^=]|=\s*.checked.)/i, xb = /^$|\/(?:java|ecma)script/i, Pb = /^true\/(.*)/, fc =
        /^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g, z = {option: [1, "<select multiple='multiple'>", "</select>"], thead: [1, "<table>", "</table>"], col: [2, "<table><colgroup>", "</colgroup></table>"], tr: [2, "<table><tbody>", "</tbody></table>"], td: [3, "<table><tbody><tr>", "</tr></tbody></table>"], _default: [0, "", ""]};
    z.optgroup = z.option;
    z.tbody = z.tfoot = z.colgroup = z.caption = z.thead;
    z.th = z.td;
    d.extend({clone: function (a, b, c) {
        var e, f, g, h, k = a.cloneNode(!0), l = d.contains(a.ownerDocument, a);
        if (!(w.noCloneChecked || 1 !== a.nodeType &&
            11 !== a.nodeType || d.isXMLDoc(a)))for (h = x(k), g = x(a), e = 0, f = g.length; e < f; e++) {
            var p = g[e], n = h[e], m = n.nodeName.toLowerCase();
            if ("input" === m && sb.test(p.type))n.checked = p.checked; else if ("input" === m || "textarea" === m)n.defaultValue = p.defaultValue
        }
        if (b)if (c)for (g = g || x(a), h = h || x(k), e = 0, f = g.length; e < f; e++)Xa(g[e], h[e]); else Xa(a, k);
        h = x(k, "script");
        0 < h.length && Ea(h, !l && x(a, "script"));
        return k
    }, buildFragment: function (a, b, c, e) {
        for (var f, g, h, k = b.createDocumentFragment(), l = [], p = 0, n = a.length; p < n; p++)if ((f = a[p]) || 0 ===
            f)if ("object" === d.type(f))d.merge(l, f.nodeType ? [f] : f); else if (cc.test(f)) {
            g = g || k.appendChild(b.createElement("div"));
            h = (wb.exec(f) || ["", ""])[1].toLowerCase();
            h = z[h] || z._default;
            g.innerHTML = h[1] + f.replace(vb, "<$1></$2>") + h[2];
            for (h = h[0]; h--;)g = g.lastChild;
            d.merge(l, g.childNodes);
            g = k.firstChild;
            g.textContent = ""
        } else l.push(b.createTextNode(f));
        k.textContent = "";
        for (p = 0; f = l[p++];)if (!e || -1 === d.inArray(f, e))if (a = d.contains(f.ownerDocument, f), g = x(k.appendChild(f), "script"), a && Ea(g), c)for (h = 0; f = g[h++];)xb.test(f.type ||
            "") && c.push(f);
        return k
    }, cleanData: function (a) {
        for (var b, c, e, f, g = d.event.special, h = 0; void 0 !== (c = a[h]); h++) {
            if (d.acceptData(c) && (f = c[n.expando]) && (b = n.cache[f])) {
                if (b.events)for (e in b.events)g[e] ? d.event.remove(c, e) : d.removeEvent(c, e, b.handle);
                n.cache[f] && delete n.cache[f]
            }
            delete G.cache[c[G.expando]]
        }
    }});
    d.fn.extend({text: function (a) {
        return O(this, function (a) {
            return void 0 === a ? d.text(this) : this.empty().each(function () {
                if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType)this.textContent =
                    a
            })
        }, null, a, arguments.length)
    }, append: function () {
        return this.domManip(arguments, function (a) {
            1 !== this.nodeType && 11 !== this.nodeType && 9 !== this.nodeType || Wa(this, a).appendChild(a)
        })
    }, prepend: function () {
        return this.domManip(arguments, function (a) {
            if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
                var b = Wa(this, a);
                b.insertBefore(a, b.firstChild)
            }
        })
    }, before: function () {
        return this.domManip(arguments, function (a) {
            this.parentNode && this.parentNode.insertBefore(a, this)
        })
    }, after: function () {
        return this.domManip(arguments,
            function (a) {
                this.parentNode && this.parentNode.insertBefore(a, this.nextSibling)
            })
    }, remove: function (a, b) {
        for (var c, e = a ? d.filter(a, this) : this, f = 0; null != (c = e[f]); f++)b || 1 !== c.nodeType || d.cleanData(x(c)), c.parentNode && (b && d.contains(c.ownerDocument, c) && Ea(x(c, "script")), c.parentNode.removeChild(c));
        return this
    }, empty: function () {
        for (var a, b = 0; null != (a = this[b]); b++)1 === a.nodeType && (d.cleanData(x(a, !1)), a.textContent = "");
        return this
    }, clone: function (a, b) {
        a = null == a ? !1 : a;
        b = null == b ? a : b;
        return this.map(function () {
            return d.clone(this,
                a, b)
        })
    }, html: function (a) {
        return O(this, function (a) {
            var c = this[0] || {}, e = 0, f = this.length;
            if (void 0 === a && 1 === c.nodeType)return c.innerHTML;
            if ("string" === typeof a && !dc.test(a) && !z[(wb.exec(a) || ["", ""])[1].toLowerCase()]) {
                a = a.replace(vb, "<$1></$2>");
                try {
                    for (; e < f; e++)c = this[e] || {}, 1 === c.nodeType && (d.cleanData(x(c, !1)), c.innerHTML = a);
                    c = 0
                } catch (g) {
                }
            }
            c && this.empty().append(a)
        }, null, a, arguments.length)
    }, replaceWith: function () {
        var a = arguments[0];
        this.domManip(arguments, function (b) {
            a = this.parentNode;
            d.cleanData(x(this));
            a && a.replaceChild(b, this)
        });
        return a && (a.length || a.nodeType) ? this : this.remove()
    }, detach: function (a) {
        return this.remove(a, !0)
    }, domManip: function (a, b) {
        a = nb.apply([], a);
        var c, e, f, g, h = 0, k = this.length, l = this, p = k - 1, q = a[0], m = d.isFunction(q);
        if (m || 1 < k && "string" === typeof q && !w.checkClone && ec.test(q))return this.each(function (c) {
            var d = l.eq(c);
            m && (a[0] = q.call(this, c, d.html()));
            d.domManip(a, b)
        });
        if (k && (c = d.buildFragment(a, this[0].ownerDocument, !1, this), e = c.firstChild, 1 === c.childNodes.length && (c = e), e)) {
            e = d.map(x(c,
                "script"), Nb);
            for (f = e.length; h < k; h++)g = c, h !== p && (g = d.clone(g, !0, !0), f && d.merge(e, x(g, "script"))), b.call(this[h], g, h);
            if (f)for (c = e[e.length - 1].ownerDocument, d.map(e, Ob), h = 0; h < f; h++)g = e[h], xb.test(g.type || "") && !n.access(g, "globalEval") && d.contains(c, g) && (g.src ? d._evalUrl && d._evalUrl(g.src) : d.globalEval(g.textContent.replace(fc, "")))
        }
        return this
    }});
    d.each({appendTo: "append", prependTo: "prepend", insertBefore: "before", insertAfter: "after", replaceAll: "replaceWith"}, function (a, b) {
        d.fn[a] = function (a) {
            for (var e =
                [], f = d(a), g = f.length - 1, h = 0; h <= g; h++)a = h === g ? this : this.clone(!0), d(f[h])[b](a), Ka.apply(e, a.get());
            return this.pushStack(e)
        }
    });
    var T, Za = {}, $a = /^margin/, Ga = new RegExp("^(" + za + ")(?!px)[a-z%]+$", "i"), oa = function (a) {
        return a.ownerDocument.defaultView.getComputedStyle(a, null)
    };
    (function () {
        function a() {
            g.style.cssText = "-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;display:block;margin-top:1%;top:1%;border:1px;padding:1px;width:4px;position:absolute";
            g.innerHTML = "";
            e.appendChild(f);
            var a = u.getComputedStyle(g, null);
            b = "1%" !== a.top;
            c = "4px" === a.width;
            e.removeChild(f)
        }

        var b, c, e = s.documentElement, f = s.createElement("div"), g = s.createElement("div");
        g.style && (g.style.backgroundClip = "content-box", g.cloneNode(!0).style.backgroundClip = "", w.clearCloneStyle = "content-box" === g.style.backgroundClip, f.style.cssText = "border:0;width:0;height:0;top:0;left:-9999px;margin-top:1px;position:absolute", f.appendChild(g), u.getComputedStyle && d.extend(w, {pixelPosition: function () {
            a();
            return b
        }, boxSizingReliable: function () {
            null ==
            c && a();
            return c
        }, reliableMarginRight: function () {
            var a;
            a = g.appendChild(s.createElement("div"));
            a.style.cssText = g.style.cssText = "-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;margin:0;border:0;padding:0";
            a.style.marginRight = a.style.width = "0";
            g.style.width = "1px";
            e.appendChild(f);
            a = !parseFloat(u.getComputedStyle(a, null).marginRight);
            e.removeChild(f);
            return a
        }}))
    })();
    d.swap = function (a, b, c, d) {
        var f, g = {};
        for (f in b)g[f] = a.style[f], a.style[f] = b[f];
        c = c.apply(a,
                d || []);
        for (f in b)a.style[f] = g[f];
        return c
    };
    var gc = /^(none|table(?!-c[ea]).+)/, Qb = new RegExp("^(" + za + ")(.*)$", "i"), hc = new RegExp("^([+-])=(" + za + ")", "i"), ic = {position: "absolute", visibility: "hidden", display: "block"}, yb = {letterSpacing: "0", fontWeight: "400"}, cb = ["Webkit", "O", "Moz", "ms"];
    d.extend({cssHooks: {opacity: {get: function (a, b) {
        if (b) {
            var c = Y(a, "opacity");
            return"" === c ? "1" : c
        }
    }}}, cssNumber: {columnCount: !0, fillOpacity: !0, flexGrow: !0, flexShrink: !0, fontWeight: !0, lineHeight: !0, opacity: !0, order: !0, orphans: !0,
        widows: !0, zIndex: !0, zoom: !0}, cssProps: {"float": "cssFloat"}, style: function (a, b, c, e) {
        if (a && 3 !== a.nodeType && 8 !== a.nodeType && a.style) {
            var f, g, h, k = d.camelCase(b), l = a.style;
            b = d.cssProps[k] || (d.cssProps[k] = bb(l, k));
            h = d.cssHooks[b] || d.cssHooks[k];
            if (void 0 !== c)g = typeof c, "string" === g && (f = hc.exec(c)) && (c = (f[1] + 1) * f[2] + parseFloat(d.css(a, b)), g = "number"), null != c && c === c && ("number" !== g || d.cssNumber[k] || (c += "px"), w.clearCloneStyle || "" !== c || 0 !== b.indexOf("background") || (l[b] = "inherit"), h && "set"in h && void 0 === (c =
                h.set(a, c, e)) || (l[b] = c)); else return h && "get"in h && void 0 !== (f = h.get(a, !1, e)) ? f : l[b]
        }
    }, css: function (a, b, c, e) {
        var f, g;
        g = d.camelCase(b);
        b = d.cssProps[g] || (d.cssProps[g] = bb(a.style, g));
        (g = d.cssHooks[b] || d.cssHooks[g]) && "get"in g && (f = g.get(a, !0, c));
        void 0 === f && (f = Y(a, b, e));
        "normal" === f && b in yb && (f = yb[b]);
        return"" === c || c ? (a = parseFloat(f), !0 === c || d.isNumeric(a) ? a || 0 : f) : f
    }});
    d.each(["height", "width"], function (a, b) {
        d.cssHooks[b] = {get: function (a, e, f) {
            if (e)return gc.test(d.css(a, "display")) && 0 === a.offsetWidth ?
                d.swap(a, ic, function () {
                    return fb(a, b, f)
                }) : fb(a, b, f)
        }, set: function (a, e, f) {
            var g = f && oa(a);
            return db(a, e, f ? eb(a, b, f, "border-box" === d.css(a, "boxSizing", !1, g), g) : 0)
        }}
    });
    d.cssHooks.marginRight = ab(w.reliableMarginRight, function (a, b) {
        if (b)return d.swap(a, {display: "inline-block"}, Y, [a, "marginRight"])
    });
    d.each({margin: "", padding: "", border: "Width"}, function (a, b) {
        d.cssHooks[a + b] = {expand: function (c) {
            var d = 0, f = {};
            for (c = "string" === typeof c ? c.split(" ") : [c]; 4 > d; d++)f[a + K[d] + b] = c[d] || c[d - 2] || c[0];
            return f
        }};
        $a.test(a) ||
        (d.cssHooks[a + b].set = db)
    });
    d.fn.extend({css: function (a, b) {
        return O(this, function (a, b, f) {
            var g, h = {}, k = 0;
            if (d.isArray(b)) {
                f = oa(a);
                for (g = b.length; k < g; k++)h[b[k]] = d.css(a, b[k], !1, f);
                return h
            }
            return void 0 !== f ? d.style(a, b, f) : d.css(a, b)
        }, a, b, 1 < arguments.length)
    }, show: function () {
        return gb(this, !0)
    }, hide: function () {
        return gb(this)
    }, toggle: function (a) {
        return"boolean" === typeof a ? a ? this.show() : this.hide() : this.each(function () {
            U(this) ? d(this).show() : d(this).hide()
        })
    }});
    d.Tween = A;
    A.prototype = {constructor: A, init: function (a, b, c, e, f, g) {
        this.elem = a;
        this.prop = c;
        this.easing = f || "swing";
        this.options = b;
        this.start = this.now = this.cur();
        this.end = e;
        this.unit = g || (d.cssNumber[c] ? "" : "px")
    }, cur: function () {
        var a = A.propHooks[this.prop];
        return a && a.get ? a.get(this) : A.propHooks._default.get(this)
    }, run: function (a) {
        var b, c = A.propHooks[this.prop];
        this.pos = this.options.duration ? b = d.easing[this.easing](a, this.options.duration * a, 0, 1, this.options.duration) : b = a;
        this.now = (this.end - this.start) * b + this.start;
        this.options.step && this.options.step.call(this.elem,
            this.now, this);
        c && c.set ? c.set(this) : A.propHooks._default.set(this);
        return this
    }};
    A.prototype.init.prototype = A.prototype;
    A.propHooks = {_default: {get: function (a) {
        return null == a.elem[a.prop] || a.elem.style && null != a.elem.style[a.prop] ? (a = d.css(a.elem, a.prop, "")) && "auto" !== a ? a : 0 : a.elem[a.prop]
    }, set: function (a) {
        if (d.fx.step[a.prop])d.fx.step[a.prop](a); else a.elem.style && (null != a.elem.style[d.cssProps[a.prop]] || d.cssHooks[a.prop]) ? d.style(a.elem, a.prop, a.now + a.unit) : a.elem[a.prop] = a.now
    }}};
    A.propHooks.scrollTop =
        A.propHooks.scrollLeft = {set: function (a) {
            a.elem.nodeType && a.elem.parentNode && (a.elem[a.prop] = a.now)
        }};
    d.easing = {linear: function (a) {
        return a
    }, swing: function (a) {
        return.5 - Math.cos(a * Math.PI) / 2
    }};
    d.fx = A.prototype.init;
    d.fx.step = {};
    var Z, Aa, jc = /^(?:toggle|show|hide)$/, zb = new RegExp("^(?:([+-])=|)(" + za + ")([a-z%]*)$", "i"), kc = /queueHooks$/, qa = [function (a, b, c) {
        var e, f, g, h, k, l, p = this, q = {}, m = a.style, t = a.nodeType && U(a), s = n.get(a, "fxshow");
        c.queue || (h = d._queueHooks(a, "fx"), null == h.unqueued && (h.unqueued = 0, k = h.empty.fire,
            h.empty.fire = function () {
                h.unqueued || k()
            }), h.unqueued++, p.always(function () {
            p.always(function () {
                h.unqueued--;
                d.queue(a, "fx").length || h.empty.fire()
            })
        }));
        1 === a.nodeType && ("height"in b || "width"in b) && (c.overflow = [m.overflow, m.overflowX, m.overflowY], l = d.css(a, "display"), f = "none" === l ? n.get(a, "olddisplay") || Fa(a.nodeName) : l, "inline" === f && "none" === d.css(a, "float") && (m.display = "inline-block"));
        c.overflow && (m.overflow = "hidden", p.always(function () {
            m.overflow = c.overflow[0];
            m.overflowX = c.overflow[1];
            m.overflowY =
                c.overflow[2]
        }));
        for (e in b)if (f = b[e], jc.exec(f)) {
            delete b[e];
            g = g || "toggle" === f;
            if (f === (t ? "hide" : "show"))if ("show" === f && s && void 0 !== s[e])t = !0; else continue;
            q[e] = s && s[e] || d.style(a, e)
        } else l = void 0;
        if (d.isEmptyObject(q))"inline" === ("none" === l ? Fa(a.nodeName) : l) && (m.display = l); else for (e in s ? "hidden"in s && (t = s.hidden) : s = n.access(a, "fxshow", {}), g && (s.hidden = !t), t ? d(a).show() : p.done(function () {
            d(a).hide()
        }), p.done(function () {
            var b;
            n.remove(a, "fxshow");
            for (b in q)d.style(a, b, q[b])
        }), q)b = ib(t ? s[e] : 0, e,
            p), e in s || (s[e] = b.start, t && (b.end = b.start, b.start = "width" === e || "height" === e ? 1 : 0))
    }], Q = {"*": [function (a, b) {
        var c = this.createTween(a, b), e = c.cur(), f = zb.exec(b), g = f && f[3] || (d.cssNumber[a] ? "" : "px"), h = (d.cssNumber[a] || "px" !== g && +e) && zb.exec(d.css(c.elem, a)), k = 1, l = 20;
        if (h && h[3] !== g) {
            g = g || h[3];
            f = f || [];
            h = +e || 1;
            do k = k || ".5", h /= k, d.style(c.elem, a, h + g); while (k !== (k = c.cur() / e) && 1 !== k && --l)
        }
        f && (h = c.start = +h || +e || 0, c.unit = g, c.end = f[1] ? h + (f[1] + 1) * f[2] : +f[2]);
        return c
    }]};
    d.Animation = d.extend(jb, {tweener: function (a, b) {
        d.isFunction(a) ? (b = a, a = ["*"]) : a = a.split(" ");
        for (var c, e = 0, f = a.length; e < f; e++)c = a[e], Q[c] = Q[c] || [], Q[c].unshift(b)
    }, prefilter: function (a, b) {
        b ? qa.unshift(a) : qa.push(a)
    }});
    d.speed = function (a, b, c) {
        var e = a && "object" === typeof a ? d.extend({}, a) : {complete: c || !c && b || d.isFunction(a) && a, duration: a, easing: c && b || b && !d.isFunction(b) && b};
        e.duration = d.fx.off ? 0 : "number" === typeof e.duration ? e.duration : e.duration in d.fx.speeds ? d.fx.speeds[e.duration] : d.fx.speeds._default;
        if (null == e.queue || !0 === e.queue)e.queue = "fx";
        e.old = e.complete;
        e.complete = function () {
            d.isFunction(e.old) && e.old.call(this);
            e.queue && d.dequeue(this, e.queue)
        };
        return e
    };
    d.fn.extend({fadeTo: function (a, b, c, d) {
        return this.filter(U).css("opacity", 0).show().end().animate({opacity: b}, a, c, d)
    }, animate: function (a, b, c, e) {
        var f = d.isEmptyObject(a), g = d.speed(b, c, e);
        b = function () {
            var b = jb(this, d.extend({}, a), g);
            (f || n.get(this, "finish")) && b.stop(!0)
        };
        b.finish = b;
        return f || !1 === g.queue ? this.each(b) : this.queue(g.queue, b)
    }, stop: function (a, b, c) {
        var e = function (a) {
            var b =
                a.stop;
            delete a.stop;
            b(c)
        };
        "string" !== typeof a && (c = b, b = a, a = void 0);
        b && !1 !== a && this.queue(a || "fx", []);
        return this.each(function () {
            var b = !0, g = null != a && a + "queueHooks", h = d.timers, k = n.get(this);
            if (g)k[g] && k[g].stop && e(k[g]); else for (g in k)k[g] && k[g].stop && kc.test(g) && e(k[g]);
            for (g = h.length; g--;)h[g].elem !== this || null != a && h[g].queue !== a || (h[g].anim.stop(c), b = !1, h.splice(g, 1));
            !b && c || d.dequeue(this, a)
        })
    }, finish: function (a) {
        !1 !== a && (a = a || "fx");
        return this.each(function () {
            var b, c = n.get(this), e = c[a + "queue"];
            b = c[a + "queueHooks"];
            var f = d.timers, g = e ? e.length : 0;
            c.finish = !0;
            d.queue(this, a, []);
            b && b.stop && b.stop.call(this, !0);
            for (b = f.length; b--;)f[b].elem === this && f[b].queue === a && (f[b].anim.stop(!0), f.splice(b, 1));
            for (b = 0; b < g; b++)e[b] && e[b].finish && e[b].finish.call(this);
            delete c.finish
        })
    }});
    d.each(["toggle", "show", "hide"], function (a, b) {
        var c = d.fn[b];
        d.fn[b] = function (a, d, g) {
            return null == a || "boolean" === typeof a ? c.apply(this, arguments) : this.animate(pa(b, !0), a, d, g)
        }
    });
    d.each({slideDown: pa("show"), slideUp: pa("hide"),
        slideToggle: pa("toggle"), fadeIn: {opacity: "show"}, fadeOut: {opacity: "hide"}, fadeToggle: {opacity: "toggle"}}, function (a, b) {
        d.fn[a] = function (a, d, f) {
            return this.animate(b, a, d, f)
        }
    });
    d.timers = [];
    d.fx.tick = function () {
        var a, b = 0, c = d.timers;
        for (Z = d.now(); b < c.length; b++)a = c[b], a() || c[b] !== a || c.splice(b--, 1);
        c.length || d.fx.stop();
        Z = void 0
    };
    d.fx.timer = function (a) {
        d.timers.push(a);
        a() ? d.fx.start() : d.timers.pop()
    };
    d.fx.interval = 13;
    d.fx.start = function () {
        Aa || (Aa = setInterval(d.fx.tick, d.fx.interval))
    };
    d.fx.stop = function () {
        clearInterval(Aa);
        Aa = null
    };
    d.fx.speeds = {slow: 600, fast: 200, _default: 400};
    d.fn.delay = function (a, b) {
        a = d.fx ? d.fx.speeds[a] || a : a;
        return this.queue(b || "fx", function (b, d) {
            var f = setTimeout(b, a);
            d.stop = function () {
                clearTimeout(f)
            }
        })
    };
    (function () {
        var a = s.createElement("input"), b = s.createElement("select"), c = b.appendChild(s.createElement("option"));
        a.type = "checkbox";
        w.checkOn = "" !== a.value;
        w.optSelected = c.selected;
        b.disabled = !0;
        w.optDisabled = !c.disabled;
        a = s.createElement("input");
        a.value = "t";
        a.type = "radio";
        w.radioValue = "t" === a.value
    })();
    var Ab, ja = d.expr.attrHandle;
    d.fn.extend({attr: function (a, b) {
        return O(this, d.attr, a, b, 1 < arguments.length)
    }, removeAttr: function (a) {
        return this.each(function () {
            d.removeAttr(this, a)
        })
    }});
    d.extend({attr: function (a, b, c) {
        var e, f, g = a.nodeType;
        if (a && 3 !== g && 8 !== g && 2 !== g) {
            if ("undefined" === typeof a.getAttribute)return d.prop(a, b, c);
            1 === g && d.isXMLDoc(a) || (b = b.toLowerCase(), e = d.attrHooks[b] || (d.expr.match.bool.test(b) ? Ab : void 0));
            if (void 0 !== c)if (null === c)d.removeAttr(a, b); else {
                if (e && "set"in e && void 0 !== (f = e.set(a,
                    c, b)))return f;
                a.setAttribute(b, c + "");
                return c
            } else {
                if (e && "get"in e && null !== (f = e.get(a, b)))return f;
                f = d.find.attr(a, b);
                return null == f ? void 0 : f
            }
        }
    }, removeAttr: function (a, b) {
        var c, e, f = 0, g = b && b.match(L);
        if (g && 1 === a.nodeType)for (; c = g[f++];)e = d.propFix[c] || c, d.expr.match.bool.test(c) && (a[e] = !1), a.removeAttribute(c)
    }, attrHooks: {type: {set: function (a, b) {
        if (!w.radioValue && "radio" === b && d.nodeName(a, "input")) {
            var c = a.value;
            a.setAttribute("type", b);
            c && (a.value = c);
            return b
        }
    }}}});
    Ab = {set: function (a, b, c) {
        !1 === b ?
            d.removeAttr(a, c) : a.setAttribute(c, c);
        return c
    }};
    d.each(d.expr.match.bool.source.match(/\w+/g), function (a, b) {
        var c = ja[b] || d.find.attr;
        ja[b] = function (a, b, d) {
            var h, k;
            d || (k = ja[b], ja[b] = h, h = null != c(a, b, d) ? b.toLowerCase() : null, ja[b] = k);
            return h
        }
    });
    var lc = /^(?:input|select|textarea|button)$/i;
    d.fn.extend({prop: function (a, b) {
        return O(this, d.prop, a, b, 1 < arguments.length)
    }, removeProp: function (a) {
        return this.each(function () {
            delete this[d.propFix[a] || a]
        })
    }});
    d.extend({propFix: {"for": "htmlFor", "class": "className"},
        prop: function (a, b, c) {
            var e, f, g;
            g = a.nodeType;
            if (a && 3 !== g && 8 !== g && 2 !== g) {
                if (g = 1 !== g || !d.isXMLDoc(a))b = d.propFix[b] || b, f = d.propHooks[b];
                return void 0 !== c ? f && "set"in f && void 0 !== (e = f.set(a, c, b)) ? e : a[b] = c : f && "get"in f && null !== (e = f.get(a, b)) ? e : a[b]
            }
        }, propHooks: {tabIndex: {get: function (a) {
            return a.hasAttribute("tabindex") || lc.test(a.nodeName) || a.href ? a.tabIndex : -1
        }}}});
    w.optSelected || (d.propHooks.selected = {get: function (a) {
        (a = a.parentNode) && a.parentNode && a.parentNode.selectedIndex;
        return null
    }});
    d.each("tabIndex readOnly maxLength cellSpacing cellPadding rowSpan colSpan useMap frameBorder contentEditable".split(" "),
        function () {
            d.propFix[this.toLowerCase()] = this
        });
    var Oa = /[\t\r\n\f]/g;
    d.fn.extend({addClass: function (a) {
        var b, c, e, f, g;
        b = "string" === typeof a && a;
        var h = 0, k = this.length;
        if (d.isFunction(a))return this.each(function (b) {
            d(this).addClass(a.call(this, b, this.className))
        });
        if (b)for (b = (a || "").match(L) || []; h < k; h++)if (c = this[h], e = 1 === c.nodeType && (c.className ? (" " + c.className + " ").replace(Oa, " ") : " ")) {
            for (g = 0; f = b[g++];)0 > e.indexOf(" " + f + " ") && (e += f + " ");
            e = d.trim(e);
            c.className !== e && (c.className = e)
        }
        return this
    },
        removeClass: function (a) {
            var b, c, e, f, g;
            b = 0 === arguments.length || "string" === typeof a && a;
            var h = 0, k = this.length;
            if (d.isFunction(a))return this.each(function (b) {
                d(this).removeClass(a.call(this, b, this.className))
            });
            if (b)for (b = (a || "").match(L) || []; h < k; h++)if (c = this[h], e = 1 === c.nodeType && (c.className ? (" " + c.className + " ").replace(Oa, " ") : "")) {
                for (g = 0; f = b[g++];)for (; 0 <= e.indexOf(" " + f + " ");)e = e.replace(" " + f + " ", " ");
                e = a ? d.trim(e) : "";
                c.className !== e && (c.className = e)
            }
            return this
        }, toggleClass: function (a, b) {
            var c =
                typeof a;
            return"boolean" === typeof b && "string" === c ? b ? this.addClass(a) : this.removeClass(a) : d.isFunction(a) ? this.each(function (c) {
                d(this).toggleClass(a.call(this, c, this.className, b), b)
            }) : this.each(function () {
                if ("string" === c)for (var b, f = 0, g = d(this), h = a.match(L) || []; b = h[f++];)g.hasClass(b) ? g.removeClass(b) : g.addClass(b); else if ("undefined" === c || "boolean" === c)this.className && n.set(this, "__className__", this.className), this.className = this.className || !1 === a ? "" : n.get(this, "__className__") || ""
            })
        }, hasClass: function (a) {
            a =
                " " + a + " ";
            for (var b = 0, c = this.length; b < c; b++)if (1 === this[b].nodeType && 0 <= (" " + this[b].className + " ").replace(Oa, " ").indexOf(a))return!0;
            return!1
        }});
    var mc = /\r/g;
    d.fn.extend({val: function (a) {
        var b, c, e, f = this[0];
        if (arguments.length)return e = d.isFunction(a), this.each(function (c) {
            1 === this.nodeType && (c = e ? a.call(this, c, d(this).val()) : a, null == c ? c = "" : "number" === typeof c ? c += "" : d.isArray(c) && (c = d.map(c, function (a) {
                return null == a ? "" : a + ""
            })), b = d.valHooks[this.type] || d.valHooks[this.nodeName.toLowerCase()], b &&
                "set"in b && void 0 !== b.set(this, c, "value") || (this.value = c))
        });
        if (f) {
            if ((b = d.valHooks[f.type] || d.valHooks[f.nodeName.toLowerCase()]) && "get"in b && void 0 !== (c = b.get(f, "value")))return c;
            c = f.value;
            return"string" === typeof c ? c.replace(mc, "") : null == c ? "" : c
        }
    }});
    d.extend({valHooks: {option: {get: function (a) {
        var b = d.find.attr(a, "value");
        return null != b ? b : d.trim(d.text(a))
    }}, select: {get: function (a) {
        for (var b, c = a.options, e = a.selectedIndex, f = (a = "select-one" === a.type || 0 > e) ? null : [], g = a ? e + 1 : c.length, h = 0 > e ? g : a ? e : 0; h < g; h++)if (b =
            c[h], !(!b.selected && h !== e || (w.optDisabled ? b.disabled : null !== b.getAttribute("disabled")) || b.parentNode.disabled && d.nodeName(b.parentNode, "optgroup"))) {
            b = d(b).val();
            if (a)return b;
            f.push(b)
        }
        return f
    }, set: function (a, b) {
        for (var c, e, f = a.options, g = d.makeArray(b), h = f.length; h--;)if (e = f[h], e.selected = 0 <= d.inArray(e.value, g))c = !0;
        c || (a.selectedIndex = -1);
        return g
    }}}});
    d.each(["radio", "checkbox"], function () {
        d.valHooks[this] = {set: function (a, b) {
            if (d.isArray(b))return a.checked = 0 <= d.inArray(d(a).val(), b)
        }};
        w.checkOn ||
        (d.valHooks[this].get = function (a) {
            return null === a.getAttribute("value") ? "on" : a.value
        })
    });
    d.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error contextmenu".split(" "), function (a, b) {
        d.fn[b] = function (a, d) {
            return 0 < arguments.length ? this.on(b, null, a, d) : this.trigger(b)
        }
    });
    d.fn.extend({hover: function (a, b) {
        return this.mouseenter(a).mouseleave(b || a)
    }, bind: function (a, b, c) {
        return this.on(a, null, b, c)
    }, unbind: function (a, b) {
        return this.off(a, null, b)
    }, delegate: function (a, b, c, d) {
        return this.on(b, a, c, d)
    }, undelegate: function (a, b, c) {
        return 1 === arguments.length ? this.off(a, "**") : this.off(b, a || "**", c)
    }});
    var Pa = d.now(), Qa = /\?/;
    d.parseJSON = function (a) {
        return JSON.parse(a + "")
    };
    d.parseXML = function (a) {
        var b, c;
        if (!a || "string" !== typeof a)return null;
        try {
            c = new DOMParser, b = c.parseFromString(a, "text/xml")
        } catch (e) {
            b = void 0
        }
        b && !b.getElementsByTagName("parsererror").length || d.error("Invalid XML: " +
            a);
        return b
    };
    var S, P, nc = /#.*$/, Bb = /([?&])_=[^&]*/, oc = /^(.*?):[ \t]*([^\r\n]*)$/mg, pc = /^(?:GET|HEAD)$/, qc = /^\/\//, Cb = /^([\w.+-]+:)(?:\/\/(?:[^\/?#]*@|)([^\/?#:]*)(?::(\d+)|)|)/, Db = {}, Ha = {}, Eb = "*/".concat("*");
    try {
        P = location.href
    } catch (yc) {
        P = s.createElement("a"), P.href = "", P = P.href
    }
    S = Cb.exec(P.toLowerCase()) || [];
    d.extend({active: 0, lastModified: {}, etag: {}, ajaxSettings: {url: P, type: "GET", isLocal: /^(?:about|app|app-storage|.+-extension|file|res|widget):$/.test(S[1]), global: !0, processData: !0, async: !0, contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        accepts: {"*": Eb, text: "text/plain", html: "text/html", xml: "application/xml, text/xml", json: "application/json, text/javascript"}, contents: {xml: /xml/, html: /html/, json: /json/}, responseFields: {xml: "responseXML", text: "responseText", json: "responseJSON"}, converters: {"* text": String, "text html": !0, "text json": d.parseJSON, "text xml": d.parseXML}, flatOptions: {url: !0, context: !0}}, ajaxSetup: function (a, b) {
        return b ? Ia(Ia(a, d.ajaxSettings), b) : Ia(d.ajaxSettings, a)
    }, ajaxPrefilter: kb(Db), ajaxTransport: kb(Ha), ajax: function (a, b) {
        function c(a, b, c, h) {
            var l, n, q, v;
            v = b;
            if (2 !== J) {
                J = 2;
                k && clearTimeout(k);
                e = void 0;
                g = h || "";
                r.readyState = 0 < a ? 4 : 0;
                h = 200 <= a && 300 > a || 304 === a;
                if (c) {
                    q = m;
                    for (var B = r, H, x, D, F, A = q.contents, z = q.dataTypes; "*" === z[0];)z.shift(), void 0 === H && (H = q.mimeType || B.getResponseHeader("Content-Type"));
                    if (H)for (x in A)if (A[x] && A[x].test(H)) {
                        z.unshift(x);
                        break
                    }
                    if (z[0]in c)D = z[0]; else {
                        for (x in c) {
                            if (!z[0] || q.converters[x + " " + z[0]]) {
                                D = x;
                                break
                            }
                            F || (F = x)
                        }
                        D = D || F
                    }
                    D ? (D !== z[0] && z.unshift(D), q = c[D]) : q = void 0
                }
                a:{
                    c = m;
                    H = q;
                    x = r;
                    D = h;
                    var E,
                        C, I, B = {}, A = c.dataTypes.slice();
                    if (A[1])for (C in c.converters)B[C.toLowerCase()] = c.converters[C];
                    for (F = A.shift(); F;)if (c.responseFields[F] && (x[c.responseFields[F]] = H), !I && D && c.dataFilter && (H = c.dataFilter(H, c.dataType)), I = F, F = A.shift())if ("*" === F)F = I; else if ("*" !== I && I !== F) {
                        C = B[I + " " + F] || B["* " + F];
                        if (!C)for (E in B)if (q = E.split(" "), q[1] === F && (C = B[I + " " + q[0]] || B["* " + q[0]])) {
                            !0 === C ? C = B[E] : !0 !== B[E] && (F = q[0], A.unshift(q[1]));
                            break
                        }
                        if (!0 !== C)if (C && c["throws"])H = C(H); else try {
                            H = C(H)
                        } catch (K) {
                            q = {state: "parsererror",
                                error: C ? K : "No conversion from " + I + " to " + F};
                            break a
                        }
                    }
                    q = {state: "success", data: H}
                }
                if (h)m.ifModified && ((v = r.getResponseHeader("Last-Modified")) && (d.lastModified[f] = v), (v = r.getResponseHeader("etag")) && (d.etag[f] = v)), 204 === a || "HEAD" === m.type ? v = "nocontent" : 304 === a ? v = "notmodified" : (v = q.state, l = q.data, n = q.error, h = !n); else if (n = v, a || !v)v = "error", 0 > a && (a = 0);
                r.status = a;
                r.statusText = (b || v) + "";
                h ? u.resolveWith(t, [l, v, r]) : u.rejectWith(t, [r, v, n]);
                r.statusCode(G);
                G = void 0;
                p && s.trigger(h ? "ajaxSuccess" : "ajaxError",
                    [r, m, h ? l : n]);
                w.fireWith(t, [r, v]);
                p && (s.trigger("ajaxComplete", [r, m]), --d.active || d.event.trigger("ajaxStop"))
            }
        }

        "object" === typeof a && (b = a, a = void 0);
        b = b || {};
        var e, f, g, h, k, l, p, n, m = d.ajaxSetup({}, b), t = m.context || m, s = m.context && (t.nodeType || t.jquery) ? d(t) : d.event, u = d.Deferred(), w = d.Callbacks("once memory"), G = m.statusCode || {}, x = {}, A = {}, J = 0, v = "canceled", r = {readyState: 0, getResponseHeader: function (a) {
            var b;
            if (2 === J) {
                if (!h)for (h = {}; b = oc.exec(g);)h[b[1].toLowerCase()] = b[2];
                b = h[a.toLowerCase()]
            }
            return null ==
                b ? null : b
        }, getAllResponseHeaders: function () {
            return 2 === J ? g : null
        }, setRequestHeader: function (a, b) {
            var c = a.toLowerCase();
            J || (a = A[c] = A[c] || a, x[a] = b);
            return this
        }, overrideMimeType: function (a) {
            J || (m.mimeType = a);
            return this
        }, statusCode: function (a) {
            var b;
            if (a)if (2 > J)for (b in a)G[b] = [G[b], a[b]]; else r.always(a[r.status]);
            return this
        }, abort: function (a) {
            a = a || v;
            e && e.abort(a);
            c(0, a);
            return this
        }};
        u.promise(r).complete = w.add;
        r.success = r.done;
        r.error = r.fail;
        m.url = ((a || m.url || P) + "").replace(nc, "").replace(qc, S[1] +
            "//");
        m.type = b.method || b.type || m.method || m.type;
        m.dataTypes = d.trim(m.dataType || "*").toLowerCase().match(L) || [""];
        null == m.crossDomain && (l = Cb.exec(m.url.toLowerCase()), m.crossDomain = !(!l || l[1] === S[1] && l[2] === S[2] && (l[3] || ("http:" === l[1] ? "80" : "443")) === (S[3] || ("http:" === S[1] ? "80" : "443"))));
        m.data && m.processData && "string" !== typeof m.data && (m.data = d.param(m.data, m.traditional));
        lb(Db, m, b, r);
        if (2 === J)return r;
        (p = m.global) && 0 === d.active++ && d.event.trigger("ajaxStart");
        m.type = m.type.toUpperCase();
        m.hasContent = !pc.test(m.type);
        f = m.url;
        m.hasContent || (m.data && (f = m.url += (Qa.test(f) ? "&" : "?") + m.data, delete m.data), !1 === m.cache && (m.url = Bb.test(f) ? f.replace(Bb, "$1_=" + Pa++) : f + (Qa.test(f) ? "&" : "?") + "_=" + Pa++));
        m.ifModified && (d.lastModified[f] && r.setRequestHeader("If-Modified-Since", d.lastModified[f]), d.etag[f] && r.setRequestHeader("If-None-Match", d.etag[f]));
        (m.data && m.hasContent && !1 !== m.contentType || b.contentType) && r.setRequestHeader("Content-Type", m.contentType);
        r.setRequestHeader("Accept", m.dataTypes[0] && m.accepts[m.dataTypes[0]] ?
            m.accepts[m.dataTypes[0]] + ("*" !== m.dataTypes[0] ? ", " + Eb + "; q=0.01" : "") : m.accepts["*"]);
        for (n in m.headers)r.setRequestHeader(n, m.headers[n]);
        if (m.beforeSend && (!1 === m.beforeSend.call(t, r, m) || 2 === J))return r.abort();
        v = "abort";
        for (n in{success: 1, error: 1, complete: 1})r[n](m[n]);
        if (e = lb(Ha, m, b, r)) {
            r.readyState = 1;
            p && s.trigger("ajaxSend", [r, m]);
            m.async && 0 < m.timeout && (k = setTimeout(function () {
                r.abort("timeout")
            }, m.timeout));
            try {
                J = 1, e.send(x, c)
            } catch (z) {
                if (2 > J)c(-1, z); else throw z;
            }
        } else c(-1, "No Transport");
        return r
    }, getJSON: function (a, b, c) {
        return d.get(a, b, c, "json")
    }, getScript: function (a, b) {
        return d.get(a, void 0, b, "script")
    }});
    d.each(["get", "post"], function (a, b) {
        d[b] = function (a, e, f, g) {
            d.isFunction(e) && (g = g || f, f = e, e = void 0);
            return d.ajax({url: a, type: b, dataType: g, data: e, success: f})
        }
    });
    d.each("ajaxStart ajaxStop ajaxComplete ajaxError ajaxSuccess ajaxSend".split(" "), function (a, b) {
        d.fn[b] = function (a) {
            return this.on(b, a)
        }
    });
    d._evalUrl = function (a) {
        return d.ajax({url: a, type: "GET", dataType: "script", async: !1,
            global: !1, "throws": !0})
    };
    d.fn.extend({wrapAll: function (a) {
        var b;
        if (d.isFunction(a))return this.each(function (b) {
            d(this).wrapAll(a.call(this, b))
        });
        this[0] && (b = d(a, this[0].ownerDocument).eq(0).clone(!0), this[0].parentNode && b.insertBefore(this[0]), b.map(function () {
            for (var a = this; a.firstElementChild;)a = a.firstElementChild;
            return a
        }).append(this));
        return this
    }, wrapInner: function (a) {
        return d.isFunction(a) ? this.each(function (b) {
            d(this).wrapInner(a.call(this, b))
        }) : this.each(function () {
            var b = d(this), c = b.contents();
            c.length ? c.wrapAll(a) : b.append(a)
        })
    }, wrap: function (a) {
        var b = d.isFunction(a);
        return this.each(function (c) {
            d(this).wrapAll(b ? a.call(this, c) : a)
        })
    }, unwrap: function () {
        return this.parent().each(function () {
            d.nodeName(this, "body") || d(this).replaceWith(this.childNodes)
        }).end()
    }});
    d.expr.filters.hidden = function (a) {
        return 0 >= a.offsetWidth && 0 >= a.offsetHeight
    };
    d.expr.filters.visible = function (a) {
        return!d.expr.filters.hidden(a)
    };
    var rc = /%20/g, Sb = /\[\]$/, Fb = /\r?\n/g, sc = /^(?:submit|button|image|reset|file)$/i, tc =
        /^(?:input|select|textarea|keygen)/i;
    d.param = function (a, b) {
        var c, e = [], f = function (a, b) {
            b = d.isFunction(b) ? b() : null == b ? "" : b;
            e[e.length] = encodeURIComponent(a) + "=" + encodeURIComponent(b)
        };
        void 0 === b && (b = d.ajaxSettings && d.ajaxSettings.traditional);
        if (d.isArray(a) || a.jquery && !d.isPlainObject(a))d.each(a, function () {
            f(this.name, this.value)
        }); else for (c in a)Ja(c, a[c], b, f);
        return e.join("&").replace(rc, "+")
    };
    d.fn.extend({serialize: function () {
        return d.param(this.serializeArray())
    }, serializeArray: function () {
        return this.map(function () {
            var a =
                d.prop(this, "elements");
            return a ? d.makeArray(a) : this
        }).filter(function () {
            var a = this.type;
            return this.name && !d(this).is(":disabled") && tc.test(this.nodeName) && !sc.test(a) && (this.checked || !sb.test(a))
        }).map(function (a, b) {
            var c = d(this).val();
            return null == c ? null : d.isArray(c) ? d.map(c, function (a) {
                return{name: b.name, value: a.replace(Fb, "\r\n")}
            }) : {name: b.name, value: c.replace(Fb, "\r\n")}
        }).get()
    }});
    d.ajaxSettings.xhr = function () {
        try {
            return new XMLHttpRequest
        } catch (a) {
        }
    };
    var uc = 0, Ba = {}, vc = {0: 200, 1223: 204}, ka =
        d.ajaxSettings.xhr();
    if (u.ActiveXObject)d(u).on("unload", function () {
        for (var a in Ba)Ba[a]()
    });
    w.cors = !!ka && "withCredentials"in ka;
    w.ajax = ka = !!ka;
    d.ajaxTransport(function (a) {
        var b;
        if (w.cors || ka && !a.crossDomain)return{send: function (c, d) {
            var f, g = a.xhr(), h = ++uc;
            g.open(a.type, a.url, a.async, a.username, a.password);
            if (a.xhrFields)for (f in a.xhrFields)g[f] = a.xhrFields[f];
            a.mimeType && g.overrideMimeType && g.overrideMimeType(a.mimeType);
            a.crossDomain || c["X-Requested-With"] || (c["X-Requested-With"] = "XMLHttpRequest");
            for (f in c)g.setRequestHeader(f, c[f]);
            b = function (a) {
                return function () {
                    b && (delete Ba[h], b = g.onload = g.onerror = null, "abort" === a ? g.abort() : "error" === a ? d(g.status, g.statusText) : d(vc[g.status] || g.status, g.statusText, "string" === typeof g.responseText ? {text: g.responseText} : void 0, g.getAllResponseHeaders()))
                }
            };
            g.onload = b();
            g.onerror = b("error");
            b = Ba[h] = b("abort");
            try {
                g.send(a.hasContent && a.data || null)
            } catch (k) {
                if (b)throw k;
            }
        }, abort: function () {
            b && b()
        }}
    });
    d.ajaxSetup({accepts: {script: "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"},
        contents: {script: /(?:java|ecma)script/}, converters: {"text script": function (a) {
            d.globalEval(a);
            return a
        }}});
    d.ajaxPrefilter("script", function (a) {
        void 0 === a.cache && (a.cache = !1);
        a.crossDomain && (a.type = "GET")
    });
    d.ajaxTransport("script", function (a) {
        if (a.crossDomain) {
            var b, c;
            return{send: function (e, f) {
                b = d("<script>").prop({async: !0, charset: a.scriptCharset, src: a.url}).on("load error", c = function (a) {
                    b.remove();
                    c = null;
                    a && f("error" === a.type ? 404 : 200, a.type)
                });
                s.head.appendChild(b[0])
            }, abort: function () {
                c && c()
            }}
        }
    });
    var Gb = [], Ra = /(=)\?(?=&|$)|\?\?/;
    d.ajaxSetup({jsonp: "callback", jsonpCallback: function () {
        var a = Gb.pop() || d.expando + "_" + Pa++;
        this[a] = !0;
        return a
    }});
    d.ajaxPrefilter("json jsonp", function (a, b, c) {
        var e, f, g, h = !1 !== a.jsonp && (Ra.test(a.url) ? "url" : "string" === typeof a.data && !(a.contentType || "").indexOf("application/x-www-form-urlencoded") && Ra.test(a.data) && "data");
        if (h || "jsonp" === a.dataTypes[0])return e = a.jsonpCallback = d.isFunction(a.jsonpCallback) ? a.jsonpCallback() : a.jsonpCallback, h ? a[h] = a[h].replace(Ra, "$1" +
            e) : !1 !== a.jsonp && (a.url += (Qa.test(a.url) ? "&" : "?") + a.jsonp + "=" + e), a.converters["script json"] = function () {
            g || d.error(e + " was not called");
            return g[0]
        }, a.dataTypes[0] = "json", f = u[e], u[e] = function () {
            g = arguments
        }, c.always(function () {
            u[e] = f;
            a[e] && (a.jsonpCallback = b.jsonpCallback, Gb.push(e));
            g && d.isFunction(f) && f(g[0]);
            g = f = void 0
        }), "script"
    });
    d.parseHTML = function (a, b, c) {
        if (!a || "string" !== typeof a)return null;
        "boolean" === typeof b && (c = b, b = !1);
        b = b || s;
        var e = rb.exec(a);
        c = !c && [];
        if (e)return[b.createElement(e[1])];
        e = d.buildFragment([a], b, c);
        c && c.length && d(c).remove();
        return d.merge([], e.childNodes)
    };
    var Hb = d.fn.load;
    d.fn.load = function (a, b, c) {
        if ("string" !== typeof a && Hb)return Hb.apply(this, arguments);
        var e, f, g, h = this, k = a.indexOf(" ");
        0 <= k && (e = d.trim(a.slice(k)), a = a.slice(0, k));
        d.isFunction(b) ? (c = b, b = void 0) : b && "object" === typeof b && (f = "POST");
        0 < h.length && d.ajax({url: a, type: f, dataType: "html", data: b}).done(function (a) {
            g = arguments;
            h.html(e ? d("<div>").append(d.parseHTML(a)).find(e) : a)
        }).complete(c && function (a, b) {
            h.each(c,
                    g || [a.responseText, b, a])
        });
        return this
    };
    d.expr.filters.animated = function (a) {
        return d.grep(d.timers, function (b) {
            return a === b.elem
        }).length
    };
    var Ib = u.document.documentElement;
    d.offset = {setOffset: function (a, b, c) {
        var e, f, g, h = d.css(a, "position"), k = d(a), l = {};
        "static" === h && (a.style.position = "relative");
        g = k.offset();
        f = d.css(a, "top");
        e = d.css(a, "left");
        ("absolute" === h || "fixed" === h) && -1 < (f + e).indexOf("auto") ? (e = k.position(), f = e.top, e = e.left) : (f = parseFloat(f) || 0, e = parseFloat(e) || 0);
        d.isFunction(b) && (b = b.call(a,
            c, g));
        null != b.top && (l.top = b.top - g.top + f);
        null != b.left && (l.left = b.left - g.left + e);
        "using"in b ? b.using.call(a, l) : k.css(l)
    }};
    d.fn.extend({offset: function (a) {
        if (arguments.length)return void 0 === a ? this : this.each(function (b) {
            d.offset.setOffset(this, a, b)
        });
        var b, c;
        c = this[0];
        var e = {top: 0, left: 0}, f = c && c.ownerDocument;
        if (f) {
            b = f.documentElement;
            if (!d.contains(b, c))return e;
            "undefined" !== typeof c.getBoundingClientRect && (e = c.getBoundingClientRect());
            c = mb(f);
            return{top: e.top + c.pageYOffset - b.clientTop, left: e.left +
                c.pageXOffset - b.clientLeft}
        }
    }, position: function () {
        if (this[0]) {
            var a, b, c = this[0], e = {top: 0, left: 0};
            "fixed" === d.css(c, "position") ? b = c.getBoundingClientRect() : (a = this.offsetParent(), b = this.offset(), d.nodeName(a[0], "html") || (e = a.offset()), e.top += d.css(a[0], "borderTopWidth", !0), e.left += d.css(a[0], "borderLeftWidth", !0));
            return{top: b.top - e.top - d.css(c, "marginTop", !0), left: b.left - e.left - d.css(c, "marginLeft", !0)}
        }
    }, offsetParent: function () {
        return this.map(function () {
            for (var a = this.offsetParent || Ib; a && !d.nodeName(a,
                "html") && "static" === d.css(a, "position");)a = a.offsetParent;
            return a || Ib
        })
    }});
    d.each({scrollLeft: "pageXOffset", scrollTop: "pageYOffset"}, function (a, b) {
        var c = "pageYOffset" === b;
        d.fn[a] = function (d) {
            return O(this, function (a, d, e) {
                var k = mb(a);
                if (void 0 === e)return k ? k[b] : a[d];
                k ? k.scrollTo(c ? u.pageXOffset : e, c ? e : u.pageYOffset) : a[d] = e
            }, a, d, arguments.length, null)
        }
    });
    d.each(["top", "left"], function (a, b) {
        d.cssHooks[b] = ab(w.pixelPosition, function (a, e) {
            if (e)return e = Y(a, b), Ga.test(e) ? d(a).position()[b] + "px" : e
        })
    });
    d.each({Height: "height",
        Width: "width"}, function (a, b) {
        d.each({padding: "inner" + a, content: b, "": "outer" + a}, function (c, e) {
            d.fn[e] = function (e, g) {
                var h = arguments.length && (c || "boolean" !== typeof e), k = c || (!0 === e || !0 === g ? "margin" : "border");
                return O(this, function (b, c, e) {
                    return d.isWindow(b) ? b.document.documentElement["client" + a] : 9 === b.nodeType ? (c = b.documentElement, Math.max(b.body["scroll" + a], c["scroll" + a], b.body["offset" + a], c["offset" + a], c["client" + a])) : void 0 === e ? d.css(b, c, k) : d.style(b, c, e, k)
                }, b, h ? e : void 0, h, null)
            }
        })
    });
    d.fn.size = function () {
        return this.length
    };
    d.fn.andSelf = d.fn.addBack;
    "function" === typeof define && define.amd && define("jquery", [], function () {
        return d
    });
    var wc = u.jQuery, xc = u.$;
    d.noConflict = function (a) {
        u.$ === d && (u.$ = xc);
        a && u.jQuery === d && (u.jQuery = wc);
        return d
    };
    "undefined" === typeof W && (u.jQuery = u.$ = d);
    return d
});