$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();

        // trying to hit url   /locations/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (jobTitle, status) {
            $('#idVMEdit').val(jobTitle.id);
            $('#descriptionVMEdit').val(jobTitle.description);
            $('#detailsVMEdit').val(jobTitle.details);
        });

        $('#editVehicleModelModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function (jobTitle, status) {
            $('#idDetails').val(jobTitle.id);
            $('#descriptionDetails').val(jobTitle.description);
            $('#detailsDetails').val(jobTitle.details);
            $('#lastModifiedByDetails').val(jobTitle.lastModifiedBy);
            $('#lastModifiedDateDetails').val(jobTitle.lastModifiedDate.substr(0,19).replace("T", " "));
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