$('document').ready(function () {

    $('table #editButton').on('click', function () {
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
});