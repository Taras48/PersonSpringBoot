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

    $("#addFormUser").click(function (event) {
        event.preventDefault();
        addForm();
    });

    function addForm() {

        var user = {
            'name': $("#addName").val(),
            'password': $("#addPassword").val(),
           'role': $("#addRole").val(),
            'message': $("#addMessage").val()
        };

        /*var role = {'role': $("#addRole").val()};

        var userData = JSON.stringify(user);
        var formData = new FormData(role);

        formData.append("user", userData);*/


        $("#submitButton").prop("disabled", true);


        $.ajax({

            type: 'POST',
            url: "/admin/add",

            contentType: 'application/json;',
            data: JSON.stringify(user),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            async: true,
            cache: false,
            dataType: 'JSON',
           success: function () {
                location.reload();
            },
            /*error: function (e) {
               alert( "Error add");
           }*/

        });

    };


    //Спросить на ревью почему сразу в кнопке нельзя описать что она должна делать
    //почему возвращает неопределеную строку
    /*function sendDataForm() {

        //var url = $(this).parent().attr("action");

        var url = $(this).closest("form").attr("action");

        alert(url);
    };*/

    /*$("#addFormUser").submit(function(event) {

        event.preventDefault();

       /!* var name = $("#addName").val();
        var password = $("#addPassword").val();
        var role = $("#addRole").val();
        var message = $("#addMessage").val();*!/

        alert("PROVERKA  " );

        /!*$.ajax({
            url: "/admin/add",
            type: "POST",
            data: (name),
            success:function (resp) {
                alert(resp.toString());
            },
            error: function (resp) {
                alert("Error sending user");
            }
        })*!/


    });*/

});