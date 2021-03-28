$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
         event.preventDefault();

        // trying to hit url   /vehicles/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (vehicle, status) {
            $('#IdEdit').val(vehicle.id);
            $('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
            $('#vehicleNameEdit').val(vehicle.name);
            $('#vehicleNumberEdit').val(vehicle.vehiclenumber);

            var regDate = vehicle.registrationDate.substr(0,10);
            $('#RegistrationDateEdit').val(regDate);

            $('#DescriptionEdit').val(vehicle.description);

            var acqDate = vehicle.acquisitionDate.substr(0,10);
            $('#dateInAdd').val(acqDate);

            $('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
            $('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
            $('#ddlCurrentLocationEdit').val(vehicle.locationid);
            $('#PowerEdit').val(vehicle.power);
            $('#FuelCapacityEdit').val(vehicle.fuelCapacity);
            $('#NetWeightEdit').val(vehicle.netWeight);
            $('#RemarksEdit').val(vehicle.remarks);
            $('#inChargeEdit').val(vehicle.employeeid);
            $('#currentStatusEdit').val(vehicle.vehiclestatusid);
        });

        $('#editModal').modal();
    });

        $('table #detailsButton').on('click', function (event) {
            event.preventDefault();

            var href = $(this).attr('href');
            $.get(href, function (vehicle, status) {
                $('#idDetails').val(vehicle.id);
                $('#vehicleTypeLDetails').val(vehicle.vehicletypeid);
                $('#vehicleNameDetails').val(vehicle.name);
                $('#vehicleNumberDetails').val(vehicle.vehiclenumber);

                var regDate = vehicle.registrationDate.substr(0,10);
                $('#RegistrationDetails').val(regDate);

                $('#DescriptionDetails').val(vehicle.description);

                var acqDate = vehicle.acquisitionDate.substr(0,10);
                $('#AcquisitionDateDetails').val(acqDate);

                $('#ManufactureDetails').val(vehicle.vehiclemakeid);
                $('#ddlVehicleModelDetails').val(vehicle.vehiclemodelid);
                $('#ddlCurrentLocationDetails').val(vehicle.locationid);
                $('#PowerDetails').val(vehicle.power);
                $('#FuelCapacityDetails').val(vehicle.fuelCapacity);
                $('#netWeightDetails').val(vehicle.netWeight);
                $('#RemarksDetails').val(vehicle.remarks);
                $('#InChargeDetails').val(vehicle.employeeid);
                $('#CurrentStatusDetails').val(vehicle.vehiclestatusid);
                $('#lastModifiedByDetails').val(vehicle.lastModifiedBy);
                $('#lastModifiedDateDetails').val(vehicle.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        });


    $('.table #deleteButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();
    });


});