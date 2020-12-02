(function ($) {
    "use strict"; // Start of use strict

    // Smooth scrolling using jQuery easing
    $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function () {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html, body').animate({
                    scrollTop: (target.offset().top - 57)
                }, 1000, "easeInOutExpo");
                return false;
            }
        }
    });

    // Closes responsive menu when a scroll trigger link is clicked
    $('.js-scroll-trigger').click(function () {
        $('.navbar-collapse').collapse('hide');
    });

    // Activate scrollspy to add active class to navbar items on scroll
    $('body').scrollspy({
        target: '#mainNav',
        offset: 57
    });

    // Collapse Navbar
    var navbarCollapse = function () {
        if ($("#mainNav").offset().top > 100) {
            $("#mainNav").addClass("navbar-shrink");
        } else {
            $("#mainNav").removeClass("navbar-shrink");
        }
    };
    // Collapse now if page is not at top
    navbarCollapse();
    // Collapse the navbar when page is scrolled
    $(window).scroll(navbarCollapse);

    // Scroll reveal calls
    window.sr = ScrollReveal();
    sr.reveal('.sr-icons', {
        duration: 600,
        scale: 0.3,
        distance: '0px'
    }, 200);
    sr.reveal('.sr-button', {
        duration: 1000,
        delay: 200
    });
    sr.reveal('.sr-contact', {
        duration: 600,
        scale: 0.3,
        distance: '0px'
    }, 300);

})(jQuery); // End of use strict


function form_elements() {
    $('.form-group.form-group-default').click(function () {
        $(this).find('input').focus();
    });
    $('body').on('focus', '.form-group.form-group-default :input', function () {
        $('.form-group.form-group-default').removeClass('focused');
        $(this).parents('.form-group').addClass('focused');
    });

    $('body').on('blur', '.form-group.form-group-default :input', function () {
        $(this).parents('.form-group').removeClass('focused');
        if ($(this).val()) {
            $(this).closest('.form-group').find('.control-label').addClass('fade');
        } else {
            $(this).closest('.form-group').find('.control-label').removeClass('fade');
        }
    });

    $('.form-group.form-group-default .checkbox, .form-group.form-group-default .radio').hover(function () {
        $(this).parents('.form-group').addClass('focused');
    }, function () {
        $(this).parents('.form-group').removeClass('focused');
    });

}


$(document).ready(function () {

    $(window).trigger("resize");
    form_elements();


});

var form = $("#taxCalculation");
form.validate({
    errorPlacement: function errorPlacement(error, element) {
        element.before(error);
    },
    rules: {
        code: {
            required: true
        },
        nationality: {
            required: true
        },
        grossPay: {
            required: true,
            number: true
        },
        payPeriod: {
            required: true
        },
        knowORnot: {
            required: true
        },
        cumlativelyORnon: {
            required: true
        }
//        ,
//        hourlyRate: {
//            required: true,
//            number: true
//        },
//        hoursPerWeek: {
//            required: true,
//            number: true
//        },
//        previous: {
//            required: true,
//            number: true
//        },
//        date: {
//            required: true,
//            number: true
//        },
//        month: {
//            required: true
//        },
//        year: {
//            required: true,
//            number: true
//        }
    }
});

form.steps({
    headerTag: "h3",
    bodyTag: "fieldset",
    transitionEffect: "slideLeft",
    onStepChanging: function (event, currentIndex, newIndex) {

        var mainSelect = $('#code');

        if (currentIndex === 2 && mainSelect.val() != '') {
            var selectedPre = mainSelect.val();
            console.log(selectedPre);


            var selectedPre = mainSelect.val();
            console.log(selectedPre);
            console.log(list);
            $.each(list, function (key, value) {
                claimCodePro.append($("<option></option>")
                    .attr("value", key)
                    .text(value));
            });
        }

        form.validate().settings.ignore = ":disabled,:hidden";
        return form.valid();
    },
    onFinishing: function (event, currentIndex) {
        form.validate().settings.ignore = ":disabled";
        return form.valid();
    },
    onFinished: function (event, currentIndex) {

        $('#response').html('<div class="alert success border-radius">' +
            '<i class="fa fa-lg fa-check-circle-o"></i>Thank You for complete Your data, Please Click Submit<br><br>' +
            '<div class="col-lg-3 mx-auto">' +
            '<button class="btn btn-primary btn-xl text-center" type="submit" form="taxCalculation" value="Submit">Submit</button>' +
            '</div></div>');
        form.each(function () {
            this.reset;
        });
        $('.wizard > .actions').hide(300);

    }
});
