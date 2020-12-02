// Validation Using JQuery Library
$(document).ready(function () {
    $('#first_form').validate({
        rules: {
            code: {
                required: true
            },
            nationality: {
                required: true
            }
        }
    });

    $('#step2').validate({
        rules: {
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
            
//          ,  hourlyRate: {
//                required: true,
//                number: true
//            },
//            hoursPerWeek: {
//                required: true,
//                number: true
//            }, previous: {
//                required: true,
//                number: true
//            },
//            date: {
//                required: true,
//                number: true
//            },
//            month: {
//                required: true
//            },
//            year: {
//                required: true,
//                number: true
//            }
        }
    });

//    $('#step3').validate({
//
//        
//    });
//
//    $('#step4').validate({
//        rules: {
//            
//        }
//    });
});