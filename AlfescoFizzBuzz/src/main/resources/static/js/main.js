function fire_ajax_submit() {

    var search = {}
    search["min"] = $("#rangeMin").val();
    search["max"] = $("#rangeMax").val();

    $("#btn-start").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/fizzweb/start",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4><pre>"
                + encodeURI(JSON.stringify(data, null)) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-start").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-start").prop("disabled", false);

        }
    });

}