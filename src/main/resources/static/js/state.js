$('document').ready(function () {
    $('table #editStateButton').on('click', function (event) {
        event.preventDefault();

        // trying to hit url   /countries/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (state, status) {
            $('#idStateEdit').val(state.id);
            $('#nameStateEdit').val(state.name);
            $('#capitalStateEdit').val(state.capital);
            $('#ddlStateCountryEdit').val(state.countryid);
            $('#codeStateEdit').val(state.code);
            $('#detailsStateEdit').val(state.detail);

        });

        $('#editModal').modal();
    });

    $('table #detailsStateButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function (state, status) {
            $('#idDetails').val(state.id);
            $('#ddlCountryDetails').val(state.countryid);
            $('#nameDetails').val(state.name);
            $('#codeDetails').val(state.code);
            $('#capitalDetails').val(state.capital);
            $('#detailsDetails').val(state.details);
            $('#lastModifiedByDetails').val(state.lastModifiedBy);
            $('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
            });
        $('#detailsStateModal').modal();
    });

    $('table #deleteStateButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $('#confirmStateDeleteButton').attr('href', href);
        $('#deleteModal').modal();
    });


});