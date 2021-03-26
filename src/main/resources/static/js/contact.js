$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        // trying to hit url   /countries/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (contact, status) {
            $('#idEdit').val(contact.id);
            $('#firstNameEdit').val(contact.firstName);
            $('#lastNameEdit').val(contact.lastName);
            $('#phoneEdit').val(contact.phone);
            $('#mobileEdit').val(contact.mobile);
            $('#emailEdit').val(contact.email);
            $('#remarksEdit').val(contact.remarks);
        });

        $('#editModal').modal();
    });

        $('table #detailsButton').on('click', function (event) {
            event.preventDefault();

            var href = $(this).attr('href');
            $.get(href, function (contact, status) {
                $('#idDetails').val(contact.id);
                $('#firstNameDetails').val(contact.firstName);
                $('#lastNameDetails').val(contact.lastName);
                $('#phoneDetails').val(contact.phone);
                $('#mobileDetails').val(contact.mobile);
                $('#emailDetails').val(contact.email);
                $('#remarksDetails').val(contact.remarks);
                $('#lastModifiedByDetails').val(contact.lastModifiedBy);
                $('#lastModifiedDateDetails').val(contact.lastModifiedDate.substr(0,19).replace("T", " "));
            });
            $('#detailsModal').modal();
        });


    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();
    });


});