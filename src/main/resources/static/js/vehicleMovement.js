$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
         event.preventDefault();

        // trying to hit url   /invoices/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (vehiclemovement, status) {
            $('#idEdit').val(vehiclemovement.id);
            $('#ddlVehicleEdit').val(vehiclemovement.vehicleid);
            $("#ddlStartLocationEdit").val(vehiclemovement.startlocationid);
            //Create a date variable and extract only the date part of the field
            var StartDate = vehiclemovement.date1.substr(0,10);
            $('#startDateEdit').val(StartDate);

            $("#ddlEndLocationEdit").val(vehiclemovement.endlocationid);
            var EndDate = vehiclemovement.date2.substr(0,10);
            $('#endDateEdit').val(EndDate);

            $('#remarksEdit').val(vehiclemovement.remarks);


        });

        $('#editModal').modal();
    });

        $('.table #detailsButton').on('click', function (event) {
            event.preventDefault();

            var href = $(this).attr('href');
            $.get(href, function (vehiclemovement, status) {
                $('#idDetails').val(vehiclemovement.id);
                $('#vehicleDetails').val(vehiclemovement.vehicleid);

                $("#startLocationDetails").val(vehiclemovement.startlocationid);
                //Create a date variable and extract only the date part of the field
                var StartDate = vehiclemovement.date1.substr(0,10);
                $('#startDateDetails').val(StartDate);

                $("#endLocationDetails").val(vehiclemovement.endlocationid);
                var EndDate = vehiclemovement.date2.substr(0,10);
                $('#endDateDetails').val(EndDate);

                $('#remarksDetails').val(vehiclemovement.remarks);
                $('#lastModifiedByDetails').val(vehiclemovement.lastModifiedBy);
                $('#lastModifiedDateDetails').val(vehiclemovement.lastModifiedDate.substr(0,19).replace("T", " "));
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