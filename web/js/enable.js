$(document).ready(function () {
    $("input[type='radio']").click(function () {
        var rateGroup = $('#rateGroup');
        var dateGroup = $('#dateGroup');
        var grossKnow = $("input[name='knowORnot']:checked").val();
        var cumlatively = $("input[name='cumlativelyORnon']:checked").val();
        if (grossKnow == 1 && cumlatively == 1) {
            dateGroup.css('display', 'block');
        } else if (grossKnow == 2 && cumlatively == 1) {
            rateGroup.css('display', 'block');
            dateGroup.css('display', 'block');
        } else {
            rateGroup.css('display', 'none');
            dateGroup.css('display', 'none');
        }

    });

});