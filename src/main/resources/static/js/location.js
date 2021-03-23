$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
         event.preventDefault();

        // trying to hit url   /locations/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (location, status) {
            $('#idLocationEdit').val(location.id);
            $('#cityLEdit').val(location.city);
            $('#addressLEdit').val(location.address);
            $('#ddlLocationStateEdit').val(location.stateid);
            $('#ddlLocationCountryEdit').val(location.countryid);
            $('#descriptionLocationEdit').val(location.description);
            $('#detailsLocationEdit').val(location.details);
        });

        $('#editLocationModal').modal();
    });

        $('.table #detailsButton').on('click', function (event) {
            event.preventDefault();

            var href = $(this).attr('href');
            $.get(href, function (location, status) {
                $('#idDetails').val(location.id);
                $('#nameLDetails').val(location.description);
                $('#detailsDetails').val(location.details);
                $('#cityLDetails').val(location.city);
                $('#addressLDetails').val(location.address);
                $('#ddlLocationStateDetails').val(location.stateid);
                $('#ddlLocationCountryDetails').val(location.countryid);
                $('#lastModifiedByDetails').val(location.lastModifiedBy);
                $('#lastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        });


    $('.table #deleteLocationButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $('#confirmLocationDeleteButton').attr('href', href);

        $('#deleteLocationModal').modal();
    });


});