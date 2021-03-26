$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
         event.preventDefault();

        // trying to hit url   /invoices/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (vehiclemaintenance, status) {
            $('#idEdit').val(vehiclemaintenance.id);

            //Create a date variable and extract only the date part of the field
            var StartDate = vehiclemaintenance.startDate.substr(0,10);
            $('#startDateEdit').val(StartDate);

            var EndDate = vehiclemaintenance.endDate.substr(0,10);
            $('#endDateEdit').val(EndDate);

            $('#ddlVehicleEdit').val(vehiclemaintenance.vehicleid);
            $('#ddlSupplierEdit').val(vehiclemaintenance.supplierid);
            $('#priceEdit').val(vehiclemaintenance.price);
            $('#remarksEdit').val(vehiclemaintenance.remarks);

        });

        $('#editModal').modal();
    });

        $('.table #detailsButton').on('click', function (event) {
            event.preventDefault();

            var href = $(this).attr('href');
            $.get(href, function (vehiclemaintenance, status) {
                $('#idDetails').val(vehiclemaintenance.id);

                var StartDate = vehiclemaintenance.startDate.substr(0,10);
                $('#startDateDetails').val(StartDate);

                var EndDate = vehiclemaintenance.endDate.substr(0,10);
                $('#endDateDetails').val(EndDate);

                $('#vehicleDetails').val(vehiclemaintenance.vehicleid);
                $('#supplierDetails').val(vehiclemaintenance.supplierid);
                $('#priceDetails').val(vehiclemaintenance.price);
                $('#remarksDetails').val(vehiclemaintenance.remarks);
                $('#lastModifiedByDetails').val(vehiclemaintenance.lastModifiedBy);
                $('#lastModifiedDateDetails').val(vehiclemaintenance.lastModifiedDate.substr(0,19).replace("T", " "));
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