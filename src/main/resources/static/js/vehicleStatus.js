$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();

        // trying to hit url   /locations/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (vehicleStatus, status) {
            $('#idVMEdit').val(vehicleStatus.id);
            $('#descriptionVMEdit').val(vehicleStatus.description);
            $('#detailsVMEdit').val(vehicleStatus.details);
        });

        $('#editVehicleModelModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function (vehicleStatus, status) {
            $('#idDetails').val(vehicleStatus.id);
            $('#descriptionDetails').val(vehicleStatus.description);
            $('#detailsDetails').val(vehicleStatus.details);
            $('#lastModifiedByDetails').val(vehicleStatus.lastModifiedBy);
            $('#lastModifiedDateDetails').val(vehicleStatus.lastModifiedDate.substr(0,19).replace("T", " "));
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