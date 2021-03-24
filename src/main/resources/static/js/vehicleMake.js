$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();

        // trying to hit url   /locations/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (vehicleMake, status) {
            $('#idVMEdit').val(vehicleMake.id);
            $('#descriptionVMEdit').val(vehicleMake.description);
            $('#detailsVMEdit').val(vehicleMake.details);
        });

        $('#editVehicleMakeModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function (vehicleMake, status) {
            $('#idDetails').val(vehicleMake.id);
            $('#descriptionDetails').val(vehicleMake.description);
            $('#detailsDetails').val(vehicleMake.details);
            $('#lastModifiedByDetails').val(vehicleMake.lastModifiedBy);
            $('#lastModifiedDateDetails').val(vehicleMake.lastModifiedDate.substr(0,19).replace("T", " "));
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