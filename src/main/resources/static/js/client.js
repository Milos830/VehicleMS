$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
         event.preventDefault();

        // trying to hit url   /locations/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (client, status) {
            $('#IdEdit').val(client.id);
            $('#NameEdit').val(client.name);
            $('#WebsiteEdit').val(client.website);
            $('#AddressEdit').val(client.address);
            $('#ddlStateEdit').val(client.stateid);
            $('#ddlCountryEdit').val(client.countryid);
            $('#CityEdit').val(client.city);
            $('#PhoneEdit').val(client.phone);
            $('#MobileEdit').val(client.mobile);
            $('#EmailEdit').val(client.email);





        });

        $('#editModal').modal();
    });

        $('table #detailsButton').on('click', function (event) {
            event.preventDefault();

            var href = $(this).attr('href');
            $.get(href, function (client, status) {
                $('#idDetails').val(client.id);
                $('#nameLDetails').val(client.name);
                $('#phoneDetails').val(client.phone);
                $('#mobileDetails').val(client.mobile);
                $('#emailDetails').val(client.email);
                $('#websiteDetails').val(client.website);
                $('#addressLDetails').val(client.address);
                $('#cityLDetails').val(client.city);
                $('#StateDetails').val(client.stateid);
                $('#CountryDetails').val(client.countryid);
                $('#lastModifiedByDetails').val(client.lastModifiedBy);
                $('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", " "));
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