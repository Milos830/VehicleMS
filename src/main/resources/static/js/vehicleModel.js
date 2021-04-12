$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();

        // trying to hit url   /locations/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (vehicleModel, status) {
            $('#idVMEdit').val(vehicleModel.id);
            $('#descriptionVMEdit').val(vehicleModel.description);
            $('#detailsVMEdit').val(vehicleModel.details);
        });

        $('#editVehicleModelModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function (vehicleModel, status) {
            $('#idDetails').val(vehicleModel.id);
            $('#descriptionDetails').val(vehicleModel.description);
            $('#detailsDetails').val(vehicleModel.details);
            $('#createdByDetails').val(vehicleModel.createdBy);
            $('#createdDateDetails').val(vehicleModel.createdDate.substr(0, 19).replace("T", " "));
            $('#lastModifiedByDetails').val(vehicleModel.lastModifiedBy);
            $('#lastModifiedDateDetails').val(vehicleModel.lastModifiedDate.substr(0,19).replace("T", " "));
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