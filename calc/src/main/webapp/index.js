$(function() {
    $("form").submit(function(event) {
        event.preventDefault();
        $(".required").removeClass("required");
        $("span").empty();
        
        var data = {
        	a : $("#a").val(),
        	b : $("#b").val()
        }
 
        Calculator.sum(data).done(sumOk).fail(sumFailed);
    });
});

function sumOk(data) {
    $("#result").val(data);
}

function sumFailed(jqXHR) {
    if (jqXHR.status == 422) {
        var data = JSON.parse(jqXHR.responseText);
 
        $.each(data, function(index, value) {
            $("#" + value.property).addClass("required");
            $("#" + value.property + "-message").text(value.message);
        });
    }
}