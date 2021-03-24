$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();

        // trying to hit url   /locations/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (vehicleType, status) {
            $('#idVMEdit').val(vehicleType.id);
            $('#descriptionVMEdit').val(vehicleType.description);
            $('#detailsVMEdit').val(vehicleType.details);
        });

        $('#editVehicleModelModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function (vehicleType, status) {
            $('#idDetails').val(vehicleType.id);
            $('#descriptionDetails').val(vehicleType.description);
            $('#detailsDetails').val(vehicleType.details);
            $('#lastModifiedByDetails').val(vehicleType.lastModifiedBy);
            $('#lastModifiedDateDetails').val(vehicleType.lastModifiedDate.substr(0,19).replace("T", " "));
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