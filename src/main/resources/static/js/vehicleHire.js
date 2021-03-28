$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
         event.preventDefault();

        // trying to hit url   /locations/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (vehiclehire, status) {
            $('#txtIdAdd').val(vehiclehire.id);
            $('#ddlClientAdd').val(vehiclehire.clientid);
            $('#ddlVehicleAdd').val(vehiclehire.vehicleid);
            $('#ddlLocationAdd').val(vehiclehire.locationid);

            var DateIn = vehiclehire.dateIn.substr(0,10);
            var DateOut = vehiclehire.dateOut.substr(0,10);
            $('#dateOutAdd').val(DateOut);
            $('#dateInAdd').val(DateIn);
            $('#timeIdAdd').val(vehiclehire.timeIn);
            $('#timeOutAdd').val(vehiclehire.timeOut);
            $('#PriceAdd').val(vehiclehire.price);
            $('#RemarksAdd').val(vehiclehire.remarks);

        });

        $('#editModal').modal();
    });

        $('table #detailsButton').on('click', function (event) {
            event.preventDefault();

            var href = $(this).attr('href');
            $.get(href, function (vehiclehire, status) {
                $('#idDetails').val(vehiclehire.id);
                $('#clientLDetails').val(vehiclehire.clientid);
                $('#vehicleDetails').val(vehiclehire.vehicleid);
                $('#locationDetails').val(vehiclehire.locationid);

                var DateIn = vehiclehire.dateIn.substr(0,10);
                var DateOut = vehiclehire.dateOut.substr(0,10);
                $('#dateOutDetails').val(DateOut);
                $('#dateInDetails').val(DateIn);
                $('#timeInDetails').val(vehiclehire.timeIn);
                $('#TimeOutLDetails').val(vehiclehire.timeOut);
                $('#priceLDetails').val(vehiclehire.price);
                $('#remarksDetails').val(vehiclehire.remarks);
                $('#lastModifiedByDetails').val(vehiclehire.lastModifiedBy);
                $('#lastModifiedDateDetails').val(vehiclehire.lastModifiedDate.substr(0,19).replace("T", " "));
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