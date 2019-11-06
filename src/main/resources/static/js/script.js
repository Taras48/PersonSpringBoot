$(document).ready(function () {

    $("tr td .btn").click(function () {

        $("#updateUserId").val($(this).closest("tr").find("#tableId").text());
        $("#updateUserId").prop("disabled", true);

        $("#updateUserName").val($(this).closest("tr").find("#tableName").text());

        $("#updateUserPass").hide();
        $("#updateUserPass").val($(this).closest("tr").find("#tablePass").text());

        var role = $(this).closest("tr").find("#tableRole").text();
        var rol = role.substring(1, role.length - 1).toString();
        var admin = "admin";
        if (rol == admin) {
            $('#updateUserRole option:contains("admin")').prop("selected", true);
        } else {
            $('#updateUserRole option:contains("user")').prop("selected", true);
        }

        $("#updateUserMess").val($(this).closest("tr").find("#tableMess").text());


    });
});