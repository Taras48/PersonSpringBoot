$(document).ready(function () {

    getTable();

    //from table
    function getTable() {
        $.ajax({
            type: 'GET',
            url: "/admin/all",

            contentType: 'application/json;',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            async: true,
            cache: false,
            dataType: 'JSON',
            success: function (listUsers) {
                var htmlTable = "";
                for (var i = 0; i < listUsers.length; i++) {
                    htmlTable += ('<tr id="list">');
                    htmlTable += ('<td id="tableId">' + listUsers[i].id + '</td>');
                    htmlTable += ('<td id="tableName">' + listUsers[i].name + '</td>');
                    htmlTable += ('<td id="tableMess>' + listUsers[i].message + '</td>');
                    htmlTable += ('<td id="tablePass>' + listUsers[i].password + '</td>');
                    htmlTable += ('<td id="tableRole">' + listUsers[i].roles[0].role + '</td>');
                    htmlTable += ('<td><button id="editUser" class="btn btn-sm btn-info" type="button" data-toggle="modal" data-target="#editUser">Edit</button></td>');
                    htmlTable += ('</tr>');
                }
                $("#getUserTable thead").after(htmlTable);
            }

        });
    };

    $("#editUser").click(function () {

        alert("test");

        $("#updateUserId").val($(this).closest("tr").find("#tableId").text());
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
        $("#addForm").reset();
    });

    function addForm() {

        var user = {
            'name': $("#addName").val(),
            'password': $("#addPassword").val(),
            'role': $("#addRole").val(),
            'message': $("#addMessage").val()
        };

        $("#addFormUser").prop("disabled", true);

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

        });


    };

    $("#updateFormUser").click(function (event) {
        event.preventDefault();
        updateForm();
        $("#updateUser").reset();
    });

    function updateForm() {

        var user = {
            'id': $("#updateUserId").val(),
            'name': $("#updateUserName").val(),
            'password': $("#updateUserPass").val(),
            'role': $("#updateUserRole").val(),
            'message': $("#updateUserMess").val()
        };

        $("#updateFormUser").prop("disabled", true);

        $.ajax({

            type: 'PUT',
            url: "/admin/update",

            contentType: 'application/json;',
            data: JSON.stringify(user),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            async: true,
            cache: false,
            dataType: 'JSON',

        });


    };


});