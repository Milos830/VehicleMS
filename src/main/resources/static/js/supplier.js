$('document').ready(function () {

    $('.table #editButton').on('click', function (event) {

         event.preventDefault();

        // trying to hit url   /suppliers/findById/?id=1
        var href = $(this).attr('href');

        $.get(href, function (supplier, status) {
            $('#IdEdit').val(supplier.id);
            $('#NameEdit').val(supplier.name);
            $('#PhoneEdit').val(supplier.phone);
            $('#MobileEdit').val(supplier.mobile);
            $('#EmailEdit').val(supplier.email);
            $('#AddressEdit').val(supplier.address);
            $('#CityEdit').val(supplier.city);
            $('#ddlStateEdit').val(supplier.stateid);
            $('#ddlCountryEdit').val(supplier.countryid);
            $('#WebsiteEdit').val(supplier.website);
            $('#detailsEdit').val(supplier.details);

        });

        $('#editModal').modal();
    });

        $('.table #detailsButton').on('click', function (event) {
            event.preventDefault();

            var href = $(this).attr('href');
            $.get(href, function (supplier, status) {
                $('#IdDetails').val(supplier.id);
                $('#NameDetails').val(supplier.name);
                $('#PhoneDetails').val(supplier.phone);
                $('#MobileDetails').val(supplier.mobile);
                $('#EmailDetails').val(supplier.email);
                $('#AddressDetails').val(supplier.address);
                $('#CityDetails').val(supplier.city);
                $('#StateDetails').val(supplier.stateid);
                $('#CountryDetails').val(supplier.countryid);
                $('#WebsiteDetails').val(supplier.website);
                $('#detailsDetails').val(supplier.details);
                $('#lastModifiedByDetails').val(supplier.lastModifiedBy);
                $('#lastModifiedDateDetails').val(supplier.lastModifiedDate.substr(0,19).replace("T", " "));
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