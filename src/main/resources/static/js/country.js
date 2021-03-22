$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        // trying to hit url   /countries/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (country, status) {
            $('#idEdit').val(country.id);
            $('#descriptionEdit').val(country.description);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#continentEdit').val(country.continent);
            $('#nationalityEdit').val(country.nationality);
        });

        $('#editModal').modal();
    });

        $('table #detailsCountryButton').on('click', function (event) {
            event.preventDefault();

            var href = $(this).attr('href');
            $.get(href, function (country, status) {
                $('#idDetails').val(country.id);
                $('#ddlCountryCode').val(country.code);
                $('#countryCapital').val(country.capital);
                $('#descrDetails').val(country.description);
                $('#nationalityDetails').val(country.nationality);
                $('#continentCountryDetails').val(country.continent);
                $('#lastModifiedByDetailsCountry').val(country.lastModifiedBy);
                $('#lastModifiedDateDetailsCountry').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsCountryModal').modal();
        });


    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();
    });


});